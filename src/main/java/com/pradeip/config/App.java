package com.pradeip.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * 
 * @author pradeep_patel
 * Demonstrate Java Class file based configuration instead of XML file based Configuration
 */
public class App {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigClass.class);
		   
		   HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
		   helloWorld.setMessage("Hello World!");
		   helloWorld.getMessage();		   
		  /* 
		   * Can also add other config classes  along with ConfigClass
		   * ctx.register(AppConfig.class, OtherConfig.class);
		   ctx.register(AdditionalConfig.class);
		   ctx.refresh();
		   MyService myService = ctx.getBean(MyService.class);
		   myService.doStuff();*/
	}
}
