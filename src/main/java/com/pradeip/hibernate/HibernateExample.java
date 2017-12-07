package com.pradeip.hibernate;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pradeip.config.HelloWorld;
import com.pradeip.hibernate.service.StudentServiceImpl;

public class HibernateExample {

	public static void main(String[] args) {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"appConfigForHibernate.xml");
		StudentServiceImpl studentService = context
				.getBean(StudentServiceImpl.class);

		Student student = new Student("Rahim", 1, 9, 'A');

		studentService.save(student);
		System.out.println("Hi");
	}

}
