package com.example.demo.framework;

public class HelloBean {

	private PrintAnimal printAnimal;
	
	public HelloBean(PrintAnimal printAnimal) {
		this.printAnimal = printAnimal;
	}
	

	public String helloBean(String msg) {
		return msg + printAnimal.printAnimal("Name animal");
	}
}
