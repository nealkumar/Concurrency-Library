package software.nealk.concurrent_tests.nonretrievable;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import software.nealk.Testing;
import software.nealk.concurrent.nonretrievable.NonRetrievableTask;

@Testing
public class NonRetrievableTaskUnitTest {
	
	/**
	 * Tests to make sure a NonRetrievableTask can be instantiated.
	 */
	@Test
	public void instantiateNonRetrievableTaskTest() {
		NonRetrievableTask t = new NR();
		assertNotNull("NonRetrievableTask failed to intantiate. "
				+ "See: src/test/java/software/nealk/concurrent_tests/NonRetrievableTaskTest.java", t);
	}
	
	/**
	 * Tests to make sure that calling getVal() on a NonRetrievableTask throws 
	 * an {@link UnsupportedOperationException}.
	 * @throws InterruptedException
	 */
	@Test(expected = UnsupportedOperationException.class)
	public void checkForUnsupportedOperationExceptionTask() throws InterruptedException {
		NonRetrievableTask r = new NR();
		r.getVal();
	}
	
	/**
	 * Ensures than execute() is executed in a NonRetrievableTask.
	 */
	@Test
	public void checkExecuteMethod() {
		NR r = new NR();
		r.execute();
	}
	
	/**
	 * Ensures that run() is executed in a NonRetrievableTask.
	 */
	@Test
	public void checkRunMethod() {
		Runnable r = new NR();
		r.run();
	}
	
	
	private class NR extends NonRetrievableTask{
		@Override
		protected void execute() {}
	}
}
