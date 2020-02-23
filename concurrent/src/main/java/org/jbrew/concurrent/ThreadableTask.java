package org.jbrew.concurrent;

public abstract class ThreadableTask extends BlockingTask<Void>{

	@Override
	public final void run() {
		this.execute();
	}
	
}
