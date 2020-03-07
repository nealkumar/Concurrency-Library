package org.jbrew.concurrent_tests.blocking_task_queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Field;
import java.util.Queue;

import org.jbrew.Testing;
import org.jbrew.concurrent.UnboundedTaskQueue;
import org.junit.Test;
import org.jbrew.concurrent.MethodBlockingTask;
import org.jbrew.concurrent.Task;

@Testing
public class UnboundedTaskQueueTest {
	
	private UnboundedTaskQueue singleInstance = new UnboundedTaskQueue();
	//private Queue<Task<?>> testQueue = new LinkedList<>();
	
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
	
	private class EmptySpinTask extends MethodBlockingTask<String>{
		@Override
		protected void execute() {
			for(int i=0;i<100;i++) System.out.println("hi");
		}
	}

}
