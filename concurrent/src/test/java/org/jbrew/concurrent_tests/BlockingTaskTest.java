package org.jbrew.concurrent_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.jbrew.Testing;
import org.jbrew.concurrent.BlockingTask;
import org.junit.Test;

@Testing
public class BlockingTaskTest {
	
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
	public void setBlockingTaskName(){
		BlockingTask<Void> basic = new BasicTask<>();
		basic.setName("Basic Task Name");
		assertEquals("Basic Task Name", basic.getName());
	}
	
	@Test
	public void checkBlockingTaskThreadId() {
		BlockingTask<Void> basic = new BasicTask<>();
		basic.run();
		assertEquals(Thread.currentThread().getId(), basic.getId());
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
		
		@Override
		protected void execute() {
			System.out.println("Basic Task has executed!");
		}
	}

}
