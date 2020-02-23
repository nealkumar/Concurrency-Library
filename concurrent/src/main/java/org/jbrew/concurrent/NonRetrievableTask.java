package org.jbrew.concurrent;

public abstract class NonRetrievableTask extends BlockingTask<Void>{

	@Override
	public final void run() {
		System.out.println("Thread " 
				+ Thread.currentThread().getId()
				+ " is running...");
		this.execute();
	}
	
}
