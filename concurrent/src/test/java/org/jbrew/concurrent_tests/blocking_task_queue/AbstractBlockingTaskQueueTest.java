package org.jbrew.concurrent_tests.blocking_task_queue;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.lang.reflect.Field;
import java.util.Queue;

import org.jbrew.concurrent.AbstractBlockingTaskQueue;
import org.jbrew.concurrent.BasicTask;
import org.jbrew.concurrent.BoundedTaskQueue;
import org.jbrew.concurrent.Task;
import org.jbrew.concurrent.UnboundedTaskQueue;
import org.junit.Test;

public class AbstractBlockingTaskQueueTest {
	
	private Task<? extends Object> shouldBeNull;
	
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
	
	/**
	 * Tests the ability for the {@link org.jbrew.concurrent.AbstractBlockingTaskQueue#dequeue()} to block while 
	 * its internal queue size is empty.
	 * @throws InterruptedException 
	 */
	@Test
	public void dequeueBlockingAtSize0Test() throws InterruptedException {
		UnboundedTaskQueue dummy = new UnboundedTaskQueue();
		Thread t = new Thread(() ->{
			shouldBeNull = dummy.dequeue();
		});
		t.start();
		long start = System.nanoTime();
		t.join(1000);	//force-terminate the thread after 1 second and return back its state as-is
		long end = System.nanoTime();
		long delta = start-end;
		double delta_d = (double) delta / 1_000_000_000.0;	//convert from nanoseconds to milliseconds
		assert 1.0 >= delta_d;
	}
	
	@Test
	public void dequeueBlockingAtSize0Test2() throws InterruptedException {
		UnboundedTaskQueue dummy = new UnboundedTaskQueue();
		Thread t = new Thread(() ->{
			shouldBeNull = dummy.dequeue();
		});
		t.start();
		t.join(50);
		assertNull(shouldBeNull);
	}
	
	@Test
	public void dequeueBasicTest() throws InterruptedException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		AbstractBlockingTaskQueue dummy = new UnboundedTaskQueue();
		SpinTask task = new SpinTask();
		//enqueue two skeleton tasks
		dummy.enqueue(task);
		dummy.enqueue(task);
		//dequeue one task... there should now only be one task in the internal queue.
		dummy.dequeue();
		//check internal queue size via reflection to ensure its size == 1
		Class<?> clazz = AbstractBlockingTaskQueue.class;
		Field field = clazz.getDeclaredField("queue");
		field.setAccessible(true);
		@SuppressWarnings("unchecked")
		Queue<Task<?>> queue = (Queue<Task<?>>) field.get(dummy);
		assert queue.size() == 1;
	}
	
	private class SpinTask extends BasicTask{
		@Override
		protected void execute() {
			for(int i=0;i<100;i++);
		}
	}

}
