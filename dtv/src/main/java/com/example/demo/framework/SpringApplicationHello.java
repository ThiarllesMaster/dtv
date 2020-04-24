package com.example.demo.framework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApplicationHello {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(ConfigurationBeansFramework.class);
		context.refresh();
		
		HelloBean helloBean = context.getBean(HelloBean.class);
		System.out.println(helloBean.helloBean("Braga Neto"));
		
	}
}
