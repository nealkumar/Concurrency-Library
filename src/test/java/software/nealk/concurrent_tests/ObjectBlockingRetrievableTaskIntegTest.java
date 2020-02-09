package software.nealk.concurrent_tests;

import software.nealk.concurrent.Task;
import software.nealk.concurrent.tasks.MethodBlockingRetrievableTask;
import software.nealk.concurrent.tasks.ObjectBlockingRetrievableTask;

public class ObjectBlockingRetrievableTaskIntegTest {
	
	public static void main(String[] args) throws InterruptedException {
		new ObjectBlockingRetrievableTaskIntegTest().go();
	}
	
	private void go() throws InterruptedException {
		Task r = new OBRT();
		Task r1 = new RT();
		new Thread(r).start();
		new Thread(r1).start();
		System.out.println(r.getVal());
		System.out.println(r1.getVal());
	}
	
	
	private class OBRT extends ObjectBlockingRetrievableTask<String>{
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
	
	private class RT extends MethodBlockingRetrievableTask<String>{
		@Override
		protected void execute() {
			// TODO Auto-generated method stub
			System.out.println("In RT!");
			this.setVal("Retrievable Task'S Object is set!");
		}
		
	}
}
