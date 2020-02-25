package org.jbrew.concurrent_tests;

import static org.junit.Assert.assertEquals;
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
	public void setBlockingTaskName(){
		BlockingTask<Void> basic = new BasicTask<>();
		basic.setName("Basic Task Name");
		assertEquals(basic.getName(), "Basic Task Name");
	}
	
	private class BasicTask<T> extends BlockingTask<Void>{
		@Override
		protected void execute() {
			System.out.println("Basic Task has executed!");
		}
	}

}
