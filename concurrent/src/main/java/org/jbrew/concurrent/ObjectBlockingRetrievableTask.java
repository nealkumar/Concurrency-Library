package org.jbrew.concurrent;

/**
 * This implementation of {@link NonRetrievableTask} allows for the {@link obj} to be unblocked <i>as soon as</i> the {@link #setVal(Object)} method has been called. Leftover logic in the {@link #execute()} method will still execute in a {@link NonRetrievableTask} manner. 
 * As such, {@link ObjectBlockingRetrievableTask} provides fine-grained control for the respective threading operations in downstream applications. 
 * 
 * @author Neal Kumar
 *
 * @param <T> Please refer to {@link Task} for more information.
 */
public abstract class ObjectBlockingRetrievableTask<T> extends RetrievableTask<T>{
	
	private T obj;

	@Override
	public final void run() {
		execute();
	}
	
	protected abstract void execute();
	
	@Override
	protected void setVal(T obj) {
		synchronized(this) {
			this.obj = obj;
			this.notifyAll();
		}
	}

	@Override
	public final synchronized T getVal() throws InterruptedException {
		while(this.obj == null) {
			this.wait();
		}
		return obj;
	}

}
