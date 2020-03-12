package org.jbrew.concurrent_tests.blocking_task_queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.Queue;

import org.jbrew.Testing;
import org.jbrew.concurrent.BasicTask;
import org.jbrew.concurrent.BoundedTaskQueue;
import org.jbrew.concurrent.MethodBlockingTask;
import org.jbrew.concurrent.Task;
import org.junit.Test;

@Testing
public class BoundedTaskQueueTest {
	
	private final static int CAPACITY = 3;
	private BoundedTaskQueue singleInstance = new BoundedTaskQueue(CAPACITY);
	private Queue<Task<?>> testQueue = new LinkedList<>();
	
	@Test
	public void instantiateTaskQueue() {
		assertNotNull(singleInstance);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testEnqueueBasic() throws InterruptedException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		singleInstance.enqueue((new EmptySpinTask()));
		Field field = singleInstance.getClass()
				.getSuperclass()
				.getDeclaredField("queue");
		field.setAccessible(true);
		Queue<Task<?>> queue = (Queue<Task<?>>) field.get(singleInstance);
		assertEquals(1, queue.size());
	}
	
	@SuppressWarnings({ "unchecked" })
	@Test
	public void testEnqueueBasicMax() throws InterruptedException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Task<Void> task = new EnqueueTask();
		Thread t = new Thread(task);
		t.start();	
		t.join(250);
		Field field = singleInstance.getClass()
				.getSuperclass()
				.getDeclaredField("queue");
		field.setAccessible(true);
		testQueue = (Queue<Task<?>>) field.get(singleInstance);
		assertEquals(CAPACITY, testQueue.size());
	}
	
	@Test
	public void testGetCapacity() {
		assertEquals(CAPACITY, singleInstance.getCapacity());
	}
	
	private class EnqueueTask extends BasicTask{
		@Override
		protected void execute() {
			try {
				for(int i=0;i<7;i++) singleInstance.enqueue(new EmptySpinTask());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private class EmptySpinTask extends MethodBlockingTask<String>{
		@Override
		protected void execute() {
			for(int i=0;i<100;i++) System.out.println("hi");
		}
	}

}
