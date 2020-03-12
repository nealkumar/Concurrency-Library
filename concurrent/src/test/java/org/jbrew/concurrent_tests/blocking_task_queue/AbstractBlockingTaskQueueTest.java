package org.jbrew.concurrent_tests.blocking_task_queue;

import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Field;
import java.util.Queue;

import org.jbrew.concurrent.AbstractBlockingTaskQueue;
import org.jbrew.concurrent.BoundedTaskQueue;
import org.jbrew.concurrent.Task;
import org.jbrew.concurrent.UnboundedTaskQueue;
import org.junit.Test;

public class AbstractBlockingTaskQueueTest {
	
	@SuppressWarnings("unchecked")
	@Test
	public void queueNullBoundedTest() throws SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
		AbstractBlockingTaskQueue taskQueue = new BoundedTaskQueue(3);
		Field field = taskQueue.getClass().getSuperclass().getDeclaredField("queue");
		field.setAccessible(true);
		Queue<Task<?>> queue = (Queue<Task<?>>) field.get(taskQueue);
		assertNotNull(queue);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void queueNullUnboundedTest() throws SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
		AbstractBlockingTaskQueue taskQueue = new UnboundedTaskQueue();
		Field field = taskQueue.getClass().getSuperclass().getDeclaredField("queue");
		field.setAccessible(true);
		Queue<Task<?>> queue = (Queue<Task<?>>) field.get(taskQueue);
		assertNotNull(queue);
	}

}
