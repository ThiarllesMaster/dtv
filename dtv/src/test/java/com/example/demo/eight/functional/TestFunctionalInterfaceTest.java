package com.example.demo.eight.functional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestFunctionalInterfaceTest {

	@Test
	public void testFunctionalInterface() {
		ExampleInterfaceFunctional exampleInterfaceFunc = (String name) -> {
			if (name.equals("Rafinha")) {
				return "My Love";
			} else {
				return "";
			}
		};
		assertThat(exampleInterfaceFunc.exampleFunctionalInterface("Rafinha"), equalTo("My Love"));
	}

}
