package org.jbrew.concurrent_tests.retrievable;

import static org.junit.Assert.assertEquals;

import org.jbrew.concurrent.MethodBlockingRetrievableTask;
import org.jbrew.concurrent.RetrievableTask;
import org.junit.Before;
import org.junit.Test;

public class MethodBlockingRetrievableTaskUnitTest {
	
	private RetrievableTask<String> retrievableTask;
	private Thread t;
	private String setMessage;
	
	@Before
	public void setup() {
		this.retrievableTask = new MBRT<String>();
		this.t = new Thread(retrievableTask);
		this.setMessage = "MBRT Val has been set.";
	}
	
	@Test
	public void retrievableTaskRunTest() throws InterruptedException {
		t.start();
		assertEquals(this.setMessage, this.retrievableTask.getVal());
	}
	
	
	private class MBRT<T> extends MethodBlockingRetrievableTask<String>{
		@Override
		protected void execute() {
			this.setVal(setMessage);
		}
	}

}
