package software.nealk.concurrent.tasks;

import org.junit.Test;

public class NonRetrievableTaskTest {
	
	private NonRetrievableTask nrt;
	
	/**
	 * Instantiates and runs a NonRetrievableTask.
	 */
	@Test
	public void instantiateNonRetrievableTask() {
		this.nrt = new NRT();
		this.nrt.run();
		assert(this.nrt == null);
	}
	
	private class NRT extends NonRetrievableTask{
		@Override
		protected void execute() {
			// TODO Auto-generated method stub
			System.out.println("I have been successfully instantiated.");
		}
	}

}
