package org.jbrew.concurrent_tests.retrievable;

import static org.junit.Assert.assertEquals;

import org.jbrew.concurrent.MethodBlockingTask;
import org.jbrew.concurrent.RetrievableTask;
import org.junit.Before;
import org.junit.Test;

public class MethodBlockingRetrievableTaskUnitTest {
	
	private RetrievableTask<String> retrievableTask;
	private Thread t;
	private String setMessage;
	
	@Before
	public void setup() {
		this.retrievableTask = new MBRT<>();
		this.t = new Thread(retrievableTask);
		this.setMessage = "MBRT Val has been set.";
	}
	
	@Test
	public void retrievableTaskStartTest() throws InterruptedException {
		t.start();
		assertEquals(this.setMessage, this.retrievableTask.retrieve());
	}
	
	
	private class MBRT<T> extends MethodBlockingTask<String>{

		@Override
		protected void execute() {
			// TODO Auto-generated method stub
			
		}
	}

}
