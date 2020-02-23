package org.jbrew.concurrent_tests.nonretrievable;

import static org.junit.Assert.assertNotNull;

import org.jbrew.Testing;
import org.jbrew.concurrent.ThreadableTask;
import org.junit.Test;

@Testing
public class NonRetrievableTaskUnitTest {
	
	/**
	 * Tests to make sure a ThreadableTask can be instantiated.
	 */
	@Test
	public void instantiateNonRetrievableTaskTest() {
		ThreadableTask t = new NR();
		assertNotNull("ThreadableTask failed to intantiate. "
				+ "See: src/test/java/software/nealk/concurrent_tests/NonRetrievableTaskTest.java", t);
	}

	
	/**
	 * Ensures than execute() is executed in a ThreadableTask.
	 */
	@Test
	public void checkExecuteMethod() {
		NR r = new NR();
		r.execute();
	}
	
	/**
	 * Ensures that run() is executed in a ThreadableTask.
	 */
	@Test
	public void checkRunMethod() {
		Runnable r = new NR();
		r.run();
	}
	
	
	private class NR extends ThreadableTask{
		@Override
		protected void execute() {
			System.out.println("ThreadableTask works correctly.");
		}
	}
}
