package org.jbrew.concurrent_tests.blocking_task_queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;
import java.util.Queue;

import org.jbrew.concurrent.AbstractBlockingTaskQueue;
import org.jbrew.concurrent.BasicTask;
import org.jbrew.concurrent.BoundedTaskQueue;
import org.jbrew.concurrent.MethodBlockingTask;
import org.jbrew.concurrent.Task;
import org.jbrew.concurrent.UnboundedTaskQueue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AbstractBlockingTaskQueueTest {

	private Task<? extends Object> shouldBeNull;
	private Method method;
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalErr = System.err;

	@Before
	public void setUpStreams() {
		System.setErr(new PrintStream(errContent));
	}

	@After
	public void restoreStreams() {
		System.setErr(originalErr);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void queueNullBoundedTest()
			throws SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
		AbstractBlockingTaskQueue taskQueue = new BoundedTaskQueue(3);
		Field field = taskQueue.getClass().getSuperclass().getDeclaredField("queue");
		field.setAccessible(true);
		Queue<Task<?>> queue = (Queue<Task<?>>) field.get(taskQueue);
		assertNotNull(queue);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void queueNullUnboundedTest()
			throws SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
		AbstractBlockingTaskQueue taskQueue = new UnboundedTaskQueue();
		Field field = taskQueue.getClass().getSuperclass().getDeclaredField("queue");
		field.setAccessible(true);
		Queue<Task<?>> queue = (Queue<Task<?>>) field.get(taskQueue);
		assertNotNull(queue);
	}

	/**
	 * Tests the ability for the
	 * {@link org.jbrew.concurrent.AbstractBlockingTaskQueue#dequeue()} to block
	 * while its internal queue size is empty.
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void dequeueBlockingAtSize0Test() throws InterruptedException {
		UnboundedTaskQueue dummy = new UnboundedTaskQueue();
		Thread t = new Thread(() -> {
			shouldBeNull = dummy.dequeue();
		});
		t.start();
		long start = System.nanoTime();
		t.join(1000); // force-terminate the thread after 1 second and return back its state as-is
		long end = System.nanoTime();
		long delta = start - end;
		double delta_d = (double) delta / 1_000_000_000.0; // convert from nanoseconds to milliseconds
		assert 1.0 >= delta_d;
	}

	@Test
	public void dequeueBlockingAtSize0Test2() throws InterruptedException {
		UnboundedTaskQueue dummy = new UnboundedTaskQueue();
		Thread t = new Thread(() -> {
			shouldBeNull = dummy.dequeue();
		});
		t.start();
		t.join(50);
		assertNull(shouldBeNull);
	}

	@Test
	public void dequeueBasicTest() throws InterruptedException, IllegalArgumentException, IllegalAccessException,
			NoSuchFieldException, SecurityException {
		AbstractBlockingTaskQueue dummy = new UnboundedTaskQueue();
		SpinTask task = new SpinTask();
		// enqueue two skeleton tasks
		dummy.enqueue(task);
		dummy.enqueue(task);
		// dequeue one task... there should now only be one task in the internal queue.
		dummy.dequeue();
		// check internal queue size via reflection to ensure its size == 1
		Class<?> clazz = AbstractBlockingTaskQueue.class;
		Field field = clazz.getDeclaredField("queue");
		field.setAccessible(true);
		@SuppressWarnings("unchecked")
		Queue<Task<?>> queue = (Queue<Task<?>>) field.get(dummy);
		assert queue.size() == 1;
	}

	@Test
	public void dequeueDevBasicTest() throws InterruptedException, IllegalArgumentException, IllegalAccessException,
			NoSuchFieldException, SecurityException, NoSuchMethodException, InvocationTargetException {
		AbstractBlockingTaskQueue dummy = new UnboundedTaskQueue();
		SpinTask task = new SpinTask();
		SpinTaskOptional<Optional<?>> opTask = new SpinTaskOptional<>();
		Class<?> clazz = AbstractBlockingTaskQueue.class;
		Field field = clazz.getDeclaredField("devQueue");
		field.setAccessible(true);
		@SuppressWarnings("unchecked")
		Queue<Task<Optional<?>>> queue = (Queue<Task<Optional<?>>>) field.get(dummy);
		// enqueue two skeleton tasks
		queue.offer(opTask);
		queue.offer(opTask);
		queue.offer(opTask);
		// dequeue one task... there should now only be two tasks in the internal queue.
		Thread t = new Thread(() -> {
			try {
				method = clazz.getDeclaredMethod("dequeueDev");
			} catch (NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
			method.setAccessible(true);
			try {
				method.invoke(dummy);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		});
		t.start();
		t.join(10);
		// check internal queue size to ensure its size == 1
		assertEquals(1, queue.size());
	}

	@Test
	public void devDequeueBlockingAtSize0Test() throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException, InterruptedException {
		AbstractBlockingTaskQueue dummy = new UnboundedTaskQueue();
		SpinTask task = new SpinTask();
		SpinTaskOptional<Optional<?>> opTask = new SpinTaskOptional<>();
		Class<?> clazz = AbstractBlockingTaskQueue.class;
		Field field = clazz.getDeclaredField("devQueue");
		field.setAccessible(true);
		@SuppressWarnings("unchecked")
		Queue<Task<Optional<?>>> queue = (Queue<Task<Optional<?>>>) field.get(dummy);
		// dequeue one task... this should permanently block, as no new tasks are getting enqueued.
		Thread t = new Thread(() -> {
			try {
				method = clazz.getDeclaredMethod("dequeueDev");
			} catch (NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
			method.setAccessible(true);
			try {
				method.invoke(dummy);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		});
		t.start();
		t.join(10);
		// check internal queue size to ensure its size == 1
		assertEquals(0, queue.size());
	}
	
	@Test
	public void devDequeueBlockingAtSize0Test2() throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException, InterruptedException {
		AbstractBlockingTaskQueue dummy = new UnboundedTaskQueue();
		SpinTask task = new SpinTask();
		SpinTaskOptional<Optional<?>> opTask = new SpinTaskOptional<>();
		Class<?> clazz = AbstractBlockingTaskQueue.class;
		Field field = clazz.getDeclaredField("devQueue");
		field.setAccessible(true);
		@SuppressWarnings("unchecked")
		Queue<Task<Optional<?>>> queue = (Queue<Task<Optional<?>>>) field.get(dummy);
		// dequeue one task... this should permanently block, as no new tasks are getting enqueued.
		Thread t = new Thread(() -> {
			try {
				method = clazz.getDeclaredMethod("dequeueDev");
			} catch (NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
			method.setAccessible(true);
			try {
				method.invoke(dummy);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		});
		t.start();
		long start = System.currentTimeMillis();
		t.join(100);
		long end = System.currentTimeMillis();
		// check internal queue size to ensure its size == 1
		assert((end-start) >= 100);
	}

	@Test // (expected = InterruptedException.class)
	public void dequeueBasicInterruptedExceptionTest() throws InterruptedException {
		UnboundedTaskQueue dummy = new UnboundedTaskQueue();
		Thread t = new Thread(() -> {
			shouldBeNull = dummy.dequeue();
		});
		t.start();
		t.interrupt();
		t.join();
		assert errContent.toString().contains("InterruptedException");
	}

	@Test
	public void dequeueDevBasicInterruptedExceptionTest()
			throws InterruptedException, NoSuchMethodException, SecurityException {
		// Invoke method via reflection.
		AbstractBlockingTaskQueue taskQueue = new BoundedTaskQueue(3);
		Thread t = new Thread(() -> {
			Class<?> clazz = AbstractBlockingTaskQueue.class;
			Method method = null;
			try {
				method = clazz.getDeclaredMethod("dequeueDev");
			} catch (NoSuchMethodException | SecurityException e1) {
				e1.printStackTrace();
			}
			method.setAccessible(true);
			try {
				method.invoke(taskQueue);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		});
		t.start();
		t.interrupt();
		t.join();
		assert errContent.toString().contains("InterruptedException");
	}

	@Test
	public void dequeueDevBasicBasicInterruptedExceptionTest()
			throws InterruptedException, NoSuchMethodException, SecurityException {
		// Invoke method via reflection.
		AbstractBlockingTaskQueue taskQueue = new BoundedTaskQueue(3);
		Thread t = new Thread(() -> {
			Class<?> clazz = AbstractBlockingTaskQueue.class;
			Method method = null;
			try {
				method = clazz.getDeclaredMethod("dequeueDev");
			} catch (NoSuchMethodException | SecurityException e1) {
				e1.printStackTrace();
			}
			method.setAccessible(true);
			try {
				method.invoke(taskQueue);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		});
		t.start();
		t.interrupt();
		t.join();
		assert errContent.toString().contains("InterruptedException");
	}

	private class SpinTask extends BasicTask {
		@Override
		protected void execute() {
			for (int i = 0; i < 100; i++) {
				/** intentionally empty */
			}
		}
	}

	private class SpinTaskOptional<T> extends MethodBlockingTask<Optional<?>> {
		@Override
		protected void execute() {
			for (int i = 0; i < 100; i++) {
				/** intentionally empty */
			}
		}
	}
}