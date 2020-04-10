package org.jbrew.nativ.validator_tests;

import static org.junit.Assert.assertEquals;

import org.jbrew.nativ.validator.BasicMathValidator;
import org.junit.Test;

public class BasicMathTest {
	
	@Test
	public void addTest() {
		System.out.println("LIbrary path = " + System.getProperty("java.library.path"));
		int ans = new BasicMathValidator().add(20, 7);
		System.out.println("Should be 27 from C = " + ans);
		assertEquals(27, ans);
	}
	
	@Test
	public void subTest() {
		System.out.println("LIbrary path = " + System.getProperty("java.library.path"));
		int ans = new BasicMathValidator().subtract(20, 7);
		System.out.println("Should be 13 from C = " + ans);
		assertEquals(13, ans);
	}
	
	@Test
	public void multTest() {
		System.out.println("LIbrary path = " + System.getProperty("java.library.path"));
		int ans = new BasicMathValidator().multiply(111, 7);
		System.out.println("Should be 777 from C = " + ans);
		assertEquals(777, ans);
	}

}
