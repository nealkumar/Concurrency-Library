package software.nealk.concurrent_tests;

import org.junit.Test;

import junit.framework.Assert;
import software.nealk.concurrent.tasks.NonRetrievableTask;

@SuppressWarnings("deprecation")
public class NonRetrievableTaskTest {
	
	@Test
	public void instantiateNonRetrievableTaskTest() {
		NonRetrievableTask t = new NR();
		Assert.assertNotNull("NonRetrievableTask failed to intantiate. "
				+ "See: src/test/java/software/nealk/concurrent_tests/NonRetrievableTaskTest.java", t);
	}
	
	
	private class NR extends NonRetrievableTask{
		@Override
		protected void execute() {}
	}
}
