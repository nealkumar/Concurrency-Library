package software.nealk.concurrent_tests;

import software.nealk.concurrent.Task;
import software.nealk.concurrent.tasks.ObjectBlockingRetrievableTask;

public class ObjectBlockingRetrievableTaskIntegTest {
	
	public static void main(String[] args) throws InterruptedException {
		new ObjectBlockingRetrievableTaskIntegTest().go();
	}
	
	private void go() throws InterruptedException {
		Task r = new OBRT();
		new Thread(r).start();
		System.out.println(r.getVal());
	}
	
	
	private class OBRT extends ObjectBlockingRetrievableTask<String>{
		@Override
		protected void execute() {
			// TODO Auto-generated method stub
			System.out.println("I am inside OBRT!");
			synchronized(this) {
				this.obj = "The obj has been poopulated!";
				this.notifyAll();
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("OBRT has successfully completed!");
		}
	}
}
