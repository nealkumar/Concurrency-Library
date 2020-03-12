package org.jbrew.concurrent_tests.blocking_task_queue;

import static org.junit.Assert.assertNotNull;

import org.jbrew.Testing;
import org.jbrew.concurrent.BoundedTaskQueue;
import org.junit.Test;

@Testing
public class BoundedTaskQueueTest {
	
	private final static int CAPACITY = 3;
	private BoundedTaskQueue singleInstance = new BoundedTaskQueue(CAPACITY);
	
	@Test
	public void instantiateTaskQueue() {
		assertNotNull(singleInstance);
	}

}
