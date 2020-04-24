package org.jbrew.cbrew.validator_tests;

import static org.junit.Assert.assertNotNull;

import org.jbrew.cbrew.validator.Validator;
import org.jbrew.core.annotations.Testing;
import org.junit.Test;

@Testing
public class ValidatorTest {
	
	@Test
	public void testAll() {
		Validator v = new Validator.CBrewValidatorBuilder().withMemTest().withPThreadTest().build();
		assertNotNull(v);
	}
	
	@Test
	public void testMalloc() {
		Validator v = new Validator.CBrewValidatorBuilder().withMemTest().build();
		assertNotNull(v);
	}
	
	@Test
	public void testPThread() {
		Validator v = new Validator.CBrewValidatorBuilder().withPThreadTest().build();
		assertNotNull(v);
	}

}
