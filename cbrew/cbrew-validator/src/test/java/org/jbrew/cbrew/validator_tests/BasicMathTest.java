package org.jbrew.cbrew.validator_tests;

import static org.junit.Assert.assertEquals;

import org.jbrew.cbrew.validator.BasicMathValidatorCBrew;
import org.junit.Test;

public class BasicMathTest {
	
	@Test
	public void addTest() {
		System.out.println("LIbrary path = " + System.getProperty("java.library.path"));
		int ans = new BasicMathValidatorCBrew().addCBrew(20, 7);
		System.out.println("Should be 27 from C = " + ans);
		assertEquals(27, ans);
	}
	
	@Test
	public void subtractTest() {
		System.out.println("LIbrary path = " + System.getProperty("java.library.path"));
		int ans = new BasicMathValidatorCBrew().subtractCBrew(20, 7);
		System.out.println("Should be 13 from C = " + ans);
		assertEquals(13, ans);
	}
	
	@Test
	public void multiplyTest() {
		System.out.println("LIbrary path = " + System.getProperty("java.library.path"));
		int ans = new BasicMathValidatorCBrew().multiplyCBrew(111, 7);
		System.out.println("Should be 777 from C = " + ans);
		assertEquals(777, ans);
	}

}
