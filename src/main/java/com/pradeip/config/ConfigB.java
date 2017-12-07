package com.pradeip.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.pradeip.config")
public class ConfigB {
	@Bean
	public HelloWorld helloWorld() {
		return new HelloWorld();
	}
}
