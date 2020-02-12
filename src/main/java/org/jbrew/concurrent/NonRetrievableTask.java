package org.jbrew.concurrent;

public abstract class NonRetrievableTask implements Task<Void>{

	@Override
	public final void run() {
		System.out.println("Thread " 
				+ Thread.currentThread().getId()
				+ " is running...");
		this.execute();
	}
	
	protected abstract void execute();

	@Override
	public final <T> T getVal() throws InterruptedException {
		throw new UnsupportedOperationException();
	}

}
