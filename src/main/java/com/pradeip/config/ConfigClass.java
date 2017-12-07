package com.pradeip.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

@Configuration
@Import(ConfigB.class)
public class ConfigClass {

	@Bean	
	public HelloWorld helloWorld() {
		return new HelloWorld();
	}
}
