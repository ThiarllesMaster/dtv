package com.example.demo.framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationBeansFramework {

	@Bean
	public HelloBean createBean() {
		return new HelloBean(print());
	}
	
	@Bean
	public PrintAnimal print() {
		return new PrintAnimal();
	}
}
