package org.jbrew.concurrent_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.jbrew.Testing;
import org.jbrew.concurrent.BlockingTask;
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
		BlockingTask<Void> basic = new BasicTask<>();
		assertNotNull(basic);
	}
	
	@Test
	public void instantiateBlockingTask2() {
		BlockingTask<Void> basic = new BasicTask<>(true);
		assertNotNull(basic);
	}
	
	@Test
	public void instantiateBlockingTask3() {
		BlockingTask<Void> basic = new BasicTask<>("Task Name");
		assertNotNull(basic);
	}
	
	@Test
	public void instantiateBlockingTask3_nameTest() {
		String s = "Task Name";
		BlockingTask<Void> basic = new BasicTask<>(s);
		assertEquals(s, basic.getName());
	}
	
	@Test
	public void instantiateBlockingTask4() {
		BlockingTask<Void> basic = new BasicTask<>(true, "Task Name for Task Four.");
		assertNotNull(basic);
	}
	
	@Test
	public void instantiateBlockingTask4_NameTest() {
		String s = "Task Name for Task Four.";
		BlockingTask<Void> basic = new BasicTask<>(true, s);
		assertEquals(s, basic.getName());
	}
	
	@Test
	public void setBlockingTaskName(){
		BlockingTask<Void> basic = new BasicTask<>();
		basic.setName("Basic Task Name");
		assertEquals("Basic Task Name", basic.getName());
	}
	
	@Test
	public void checkBlockingTaskThreadId() {
		BlockingTask<Void> basic = new BasicTask<>();
		basic.run();
		assertEquals(Thread.currentThread().getId(), basic.getThreadId());
	}
	
	@Test
	public void checkBlockingTaskThreadId2() {
		BlockingTask<Void> basic = new BasicTask<>();
		Thread t = new Thread(basic);
		t.start();
		assertNotEquals(t.getId(), Thread.currentThread().getId());
	}
	
	private class BasicTask<T> extends BlockingTask<Void>{
		
		private BasicTask() {
			super();
		}
		
		private BasicTask(boolean flag) {
			super(flag);
		}
		
		private BasicTask(String name) {
			super(name);
		}
		
		private BasicTask(boolean flag, String name) {
			super(flag, name);
		}
		
		@Override
		protected void execute() {
			System.out.println("Basic Task has executed!");
		}
	}

}
