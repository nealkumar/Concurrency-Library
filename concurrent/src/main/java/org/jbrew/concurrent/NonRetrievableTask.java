package org.jbrew.concurrent;

public abstract class NonRetrievableTask extends BlockingTask<Void>{

	@Override
	public final void run() {
		this.execute();
	}
	
}
