package org.jbrew.cbrew_tests.espresso;

import static org.junit.Assert.assertEquals;

import org.jbrew.cbrew.espresso.SumOperation;
import org.jbrew.core.annotations.Testing;

@Testing
public class SumTest {
	
	public void sumTest() {
		int[] arr = {100, 50, 50};
		SumOperation op = new SumOperation();
		int sum = op.performOperation(arr);
		assertEquals(200, sum);
	}

}
