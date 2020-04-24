package com.example.demo.eight.java.chaper1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestChapterOne {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	public void fun () throws Exception {
		try {
			throw new Exception("");
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}

}
