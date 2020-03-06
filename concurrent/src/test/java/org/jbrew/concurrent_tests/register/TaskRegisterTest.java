package org.jbrew.concurrent_tests.register;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.jbrew.concurrent.*;

@org.jbrew.Testing
public class TaskRegisterTest {
	
	private Task<Integer> task;
	
	@org.junit.Before
	public void setup() {
		task = new BT<>();
	}
	
	@Test
	public void instantiateTaskRegisterTest() {
		assertNotNull(new TaskRegister());
	}
	
	@Test
	public void removeTaskTest() {
		
	}
	
	@Test
	public void offerAndPollTaskTest() {
		TaskRegister register = new TaskRegister();
		register.offerTask(task);
		assert register.pollTask() == this.task;
	}
	
	private class BT<T> extends ObjectBlockingTask<Integer>{
		@Override
		protected void execute() {
			this.accept(69);
		}
	}

}
