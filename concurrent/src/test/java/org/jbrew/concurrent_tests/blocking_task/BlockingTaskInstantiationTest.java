package org.jbrew.concurrent_tests.blocking_task;

import static org.junit.Assert.assertEquals;

import org.jbrew.Testing;
import org.jbrew.concurrent.ObjectBlocker;
import org.jbrew.concurrent.RetrievableTask;
import org.junit.Test;

@Testing
public class BlockingTaskInstantiationTest {

	@Test
	public void defaultConstructorTest() throws InterruptedException {
		RetrievableTask<Integer> task = new BT<>();
		new Thread(task).start();
		assertEquals(task.retrieve(), Integer.valueOf(69));
	}

	private class BT<T> extends ObjectBlocker<Integer> {
		@Override
		protected void execute() {
			this.submit(69);
		}
	}
	
}