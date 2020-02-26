package org.jbrew.concurrent_tests.nonretrievable;

import static org.junit.Assert.assertNotNull;

import org.jbrew.Testing;
import org.jbrew.concurrent.StandardTask;
import org.junit.Test;

@Testing
public class NonRetrievableTaskUnitTest {
	
	/**
	 * Tests to make sure a StandardTask can be instantiated.
	 */
	@Test
	public void instantiateNonRetrievableTaskTest() {
		StandardTask t = new NR();
		assertNotNull("StandardTask failed to intantiate. "
				+ "See: src/test/java/software/nealk/concurrent_tests/NonRetrievableTaskTest.java", t);
	}

	
	/**
	 * Ensures than execute() is executed in a StandardTask.
	 */
	@Test
	public void checkExecuteMethod() {
		NR r = new NR();
		r.execute();
	}
	
	/**
	 * Ensures that run() is executed in a StandardTask.
	 */
	@Test
	public void checkRunMethod() {
		Runnable r = new NR();
		r.run();
	}
	
	
	private class NR extends StandardTask{
		@Override
		protected void execute() {
			System.out.println("StandardTask works correctly.");
		}
	}
	
}