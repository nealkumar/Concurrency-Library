package org.jbrew.concurrent_tests;

import org.jbrew.Testing;
import org.jbrew.concurrent.MethodBlockedTask;
import org.jbrew.concurrent.BlockedTask;
import org.jbrew.concurrent.RetrievableTask;

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
	
	
	private class OBRT<T> extends BlockedTask<String>{
		@Override
		protected void execute() {
			System.out.println("I am inside OBRT!");
			this.submit("The obj has been pooopulated!");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("OBRT has successfully completed!");
		}
	}
	
	private class RT<T> extends MethodBlockedTask<String>{
		@Override
		protected void execute() {
			System.out.println("In RT!");
			this.submit("Retrievable Task'S Object is set!");
		}
		
	}
}
