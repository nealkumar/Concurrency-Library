package org.jbrew.concurrent_tests.nonretrievable;

import static org.junit.Assert.assertNotNull;

import org.jbrew.Testing;
import org.jbrew.concurrent.BasicTask;
import org.junit.Test;

@Testing
public class NonRetrievableTaskUnitTest {
	
	/**
	 * Tests to make sure a BasicTask can be instantiated.
	 */
	@Test
	public void instantiateNonRetrievableTaskTest() {
		BasicTask t = new NR();
		assertNotNull("BasicTask failed to intantiate. "
				+ "See: src/test/java/software/nealk/concurrent_tests/NonRetrievableTaskTest.java", t);
	}

	
	/**
	 * Ensures than execute() is executed in a BasicTask.
	 */
	@Test
	public void checkExecuteMethod() {
		NR r = new NR();
		r.execute();
	}
	
	/**
	 * Ensures that run() is executed in a BasicTask.
	 */
	@Test
	public void checkRunMethod() {
		Runnable r = new NR();
		r.run();
	}
	
	
	private class NR extends BasicTask{
		@Override
		protected void execute() {
			System.out.println("BasicTask works correctly.");
		}
	}
	
}