package com.pradeip.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author pradeep_patel
 * Demonstrates setter based and constructor based DI
 * You need to have 2 jars in your Class Path
 * Spring-Core
 * Spring-context 
 */
public class App {
	public static void main(String args[]) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
		Communication app = (Communication) context.getBean("communication");
		app.communicate();	
		app.getInValue();
		TextEditor textEditor = (TextEditor) context.getBean("textEditor");
		textEditor.spellCheck();	
	}
}