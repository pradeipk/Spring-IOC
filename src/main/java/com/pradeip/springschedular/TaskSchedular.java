package com.pradeip.springschedular;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TaskSchedular {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				SpringTaskSchedularConfig.class);
		try {
			Thread.sleep(500000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			context.close();
		}
	}
}
