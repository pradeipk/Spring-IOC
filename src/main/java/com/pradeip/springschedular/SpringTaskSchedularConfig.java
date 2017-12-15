package com.pradeip.springschedular;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
@EnableScheduling
public class SpringTaskSchedularConfig {

	private AtomicInteger counter = new AtomicInteger(0);

	@Scheduled(fixedRate = 2000)
	public void fixedRateJob() {
		int jobId = counter.incrementAndGet();
		System.out.println("Job @ fixed rate " + new Date() + ", jobId: "
				+ jobId);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Job " + jobId + " done");
	}

	@Bean
	public TaskScheduler poolScheduler() {
		ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
		scheduler.setThreadNamePrefix("poolScheduler");
		scheduler.setPoolSize(10);
		return scheduler;
	}

}
