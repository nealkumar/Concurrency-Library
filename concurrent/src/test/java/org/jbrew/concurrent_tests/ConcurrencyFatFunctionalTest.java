package org.jbrew.concurrent_tests;

import org.jbrew.concurrent.MethodBlockingTask;
import org.jbrew.concurrent.ObjectBlockingTask;
import org.jbrew.concurrent.RetrievableTask;
import org.jbrew.concurrent.standard.StandardNonRetrievableTask;
import org.jbrew.core.annotations.Testing;
import org.junit.Test;

/**
 * Simple functional test for Retrievable and NonRetrievable Tasks
 * 
 * @author nealk
 *
 */
@Testing
public class ConcurrencyFatFunctionalTest {
	
	public static void main(String[] args) throws InterruptedException {
		new ConcurrencyFatFunctionalTest().go();
	}
	
	private void go() throws InterruptedException {
		RetrievableTask<String> r = new OBRT<>();
		RetrievableTask<String> r1 = new RT<>();
		new Thread(r).start();
		new Thread(r1).start();
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void testStandard() {
		new StandardNonRetrievableTask().run();
	}
	
	
	private class OBRT<T> extends ObjectBlockingTask<String>{
		@Override
		protected void execute() {
			System.out.println("I am inside OBRT!");
			this.accept("The obj has been pooopulated!");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("OBRT has successfully completed!");
		}
	}
	
	private class RT<T> extends MethodBlockingTask<String>{
		@Override
		protected void execute() {
			System.out.println("In RT!");
			this.accept("Retrievable Task'S Object is set!");
		}
		
	}
}
