package org.jbrew.concurrent_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.jbrew.Testing;
import org.jbrew.concurrent.AbstractBlockingTask;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

@Testing
public class BlockingTaskTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;
	
	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}
	
	@After
	public void restoreStreams() {
		System.setOut(originalOut);
		System.setErr(originalErr);
	}
	
	@Test
	public void instantiateBlockingTask() {
		AbstractBlockingTask<Void> basic = new MyTask<>();
		assertNotNull(basic);
	}
	
	@Test
	public void instantiateBlockingTaskAndTestSysOut() {
		AbstractBlockingTask<Void> basic = new MyTask<>();
		basic.run();
		assertEquals("", outContent.toString());
	}
	
	@Test
	public void instantiateBlockingTask2() {
		AbstractBlockingTask<Void> basic = new MyTask<>(true);
		assertNotNull(basic);
	}
	
	@Test
	public void instantiateBlockingTask3() {
		AbstractBlockingTask<Void> basic = new MyTask<>("Task Name");
		assertNotNull(basic);
	}
	
	@Test
	public void instantiateBlockingTask3AndTestSysOut() {
		AbstractBlockingTask<Void> basic = new MyTask<>("Task Name");
		basic.run();
		assertTrue(outContent.toString().contains(basic.getName()));
	}
	
	@Test
	public void instantiateBlockingTask3_nameTest() {
		String s = "Task Name";
		AbstractBlockingTask<Void> basic = new MyTask<>(s);
		assertEquals(s, basic.getName());
	}
	
	@Test
	public void instantiateBlockingTask4() {
		AbstractBlockingTask<Void> basic = new MyTask<>(true, "Task Name for Task Four.");
		assertNotNull(basic);
	}
	
	@Test
	public void instantiateBlockingTask4_NameTest() {
		String s = "Task Name for Task Four.";
		AbstractBlockingTask<Void> basic = new MyTask<>(true, s);
		assertEquals(s, basic.getName());
	}
	
	@Test
	public void setBlockingTaskName(){
		AbstractBlockingTask<Void> basic = new MyTask<>();
		basic.setName("Basic Task Name");
		assertEquals("Basic Task Name", basic.getName());
	}
	
	@Test
	public void checkBlockingTaskThreadId() {
		AbstractBlockingTask<Void> basic = new MyTask<>();
		basic.run();
		assertEquals(Thread.currentThread().getId(), basic.getThreadId());
	}
	
	@Test
	public void checkBlockingTaskThreadId2() {
		AbstractBlockingTask<Void> basic = new MyTask<>();
		Thread t = new Thread(basic);
		t.start();
		assertNotEquals(t.getId(), Thread.currentThread().getId());
	}
	
	private class MyTask<T> extends AbstractBlockingTask<Void>{
		
		private MyTask() {
			super();
		}
		
		private MyTask(boolean flag) {
			super(flag);
		}
		
		private MyTask(String name) {
			super(name);
		}
		
		private MyTask(boolean flag, String name) {
			super(flag, name);
		}
		
		@Override
		protected void execute() {
			System.out.println("Basic Task has executed!");
		}
	}

}
