package org.jbrew.concurrent;

public abstract class Threadable extends BlockingTask<Void>{

	@Override
	public final void run() {
		this.execute();
	}
	
}
