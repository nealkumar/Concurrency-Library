package org.jbrew.concurrent_tests.retrievable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.jbrew.Testing;
import org.jbrew.concurrent.ObjectBlockingTask;
import org.jbrew.concurrent.RetrievableTask;
import org.junit.Test;

@Testing
public class ObjectBlockingRetrievableTaskUnitTest {
	
	/**
	 * Tests to make sure that an ObjectBlockingTask can be instantiated.
	 */
	@Test
	public void InstantiateOBRT(){
		RetrievableTask<Integer> task = new OBRT<>();
		assertNotNull(task);
	}
	
	/**
	 * Tests to make sure that an ObjectBlockingTask can be instantiated.
	 */
	@Test
	public void InstantiateOBRT2(){
		RetrievableTask<Integer> task = new OBRT<>();
		assertNotNull(task);
	}
	
	/**
	 * Tests to make sure ObjectBlockingRetrievableTasks values are appropriately set.
	 * @throws InterruptedException
	 */
	@Test
	public void testGetVal() throws InterruptedException{
		RetrievableTask<Integer> num = new OBRT<>();
		new Thread(num).start();
		assertEquals(num.retrieve(), Integer.valueOf(69));
	}
	
	private class OBRT<T> extends ObjectBlockingTask<Integer>{
		@Override
		protected void execute() {
			System.out.println("Inside OBRT's execute()");
			this.accept(69);
			//simulate long run non-retrievable task
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Finished with OBRT!");
		}
	}
	
}
