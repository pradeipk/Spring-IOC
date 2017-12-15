package com.pradeip.springschedular;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.IntervalTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
@EnableScheduling
public class SpringTaskSchedularUsingSchedulingConfigurer {

	private AtomicInteger counter = new AtomicInteger(0);

	@Scheduled(fixedRate = 2000)
	public void fixedRateJob() {
		int jobId = counter.incrementAndGet();
		System.out.println("Job @ fixed rate " + new Date() + ", jobId: "
				+ jobId);
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				SpringTaskSchedularUsingSchedulingConfigurer.class);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			context.close();
		}
	}

	@Configuration
	static class RegisterTaskSchedulerViaSchedulingConfigurer implements
			SchedulingConfigurer {

		@Override
		public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
			taskRegistrar.setTaskScheduler(poolScheduler());

			taskRegistrar.addFixedRateTask(new IntervalTask(new Runnable() {
				@Override
				public void run() {
					System.out.println("Job @ fixed rate " + new Date()
							+ ", Thread name is "
							+ Thread.currentThread().getName());
				}
			}, 1000, 0));
		}

		@Bean
		public TaskScheduler poolScheduler() {
			ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
			scheduler.setThreadNamePrefix("poolScheduler");
			scheduler.setPoolSize(10);
			return scheduler;
		}
	}
}