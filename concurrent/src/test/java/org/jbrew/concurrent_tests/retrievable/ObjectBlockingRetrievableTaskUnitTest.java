package org.jbrew.concurrent_tests.retrievable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.jbrew.Testing;
import org.jbrew.concurrent.ObjectBlockingRetrievableTask;
import org.jbrew.concurrent.Task;
import org.junit.Test;

@Testing
public class ObjectBlockingRetrievableTaskUnitTest {
	
	/**
	 * Tests to make sure that an ObjectBlockingRetrievableTask can be instantiated.
	 */
	@Test
	public void InstantiateOBRT(){
		Task<Integer> task = new OBRT<>();
		assertNotNull(task);
	}
	
	/**
	 * Tests to make sure ObjectBlockingRetrievableTasks values are appropriately set.
	 * @throws InterruptedException
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testGetVal() throws InterruptedException{
		Task<Integer> num = new OBRT<>();
		new Thread(num).start();
		System.out.println(num.getVal());
		assertEquals(num.getVal(), new Integer(69).intValue());
	}
	
	private class OBRT<T> extends ObjectBlockingRetrievableTask<Integer>{
		@Override
		protected void execute() {
			System.out.println("Inside OBRT's execute()");
			this.setVal(69);
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
