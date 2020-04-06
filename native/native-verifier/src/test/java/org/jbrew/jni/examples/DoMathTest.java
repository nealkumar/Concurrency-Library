package org.jbrew.jni.examples;

import static org.junit.Assert.assertEquals;

import org.jbrew.jni.verifier.DoMath;
import org.junit.Test;

public class DoMathTest {
	
	@Test
	public void addTest() {
		System.out.println("LIbrary path = " + System.getProperty("java.library.path"));
		int ans = new DoMath().add(20, 7);
		System.out.println("Should be 27 from C = " + ans);
		assertEquals(27, ans);
	}

}
