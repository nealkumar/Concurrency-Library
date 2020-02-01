package org.jbrew.concurrent_tests;

import org.jbrew.Testing;
import org.jbrew.concurrent.MethodBlockingRetrievableTask;
import org.jbrew.concurrent.ObjectBlockingRetrievableTask;
import org.jbrew.concurrent.Task;

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
		Task<String> r = new OBRT<>();
		Task<String> r1 = new RT<>();
		new Thread(r).start();
		new Thread(r1).start();
		System.out.println(r.getVal());
		System.out.println(r1.getVal());
	}
	
	
	private class OBRT<T> extends ObjectBlockingRetrievableTask<String>{
		@Override
		protected void execute() {
			System.out.println("I am inside OBRT!");
			this.setVal("The obj has been pooopulated!");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("OBRT has successfully completed!");
		}
	}
	
	private class RT<T> extends MethodBlockingRetrievableTask<String>{
		@Override
		protected void execute() {
			System.out.println("In RT!");
			this.setVal("Retrievable Task'S Object is set!");
		}
		
	}
}
