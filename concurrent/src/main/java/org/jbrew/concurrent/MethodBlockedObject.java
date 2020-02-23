package org.jbrew.concurrent;

public abstract class MethodBlockedObject<T> extends RetrievableTask<T>{
	
	private T obj;
	private java.util.concurrent.Semaphore objSem;
	
	protected MethodBlockedObject() {
		this.objSem = new java.util.concurrent.Semaphore(0, false);
	}

	@Override
	public final void run() {
		this.execute();
		this.objSem.release();
	}
	
	protected abstract void execute();
	
	protected final void submit(T obj) {
		this.obj = obj;
	}

	/**
	 * <p>
	 * Returns the value of the object once the {@link MethodBlockedObject#execute()} method has returned, 
	 * as set by the {@link MethodBlockedObject#submit(Object)} method. 
	 * </p><p>
	 * From the parent document:
	 * </p>
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <p>
	 * Note that compile-time type checking is enabled. The usage 
	 * of Java Generics nullifies the compiler warning "unchecked".
	 * </p>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public final T retrieve() throws InterruptedException {
		this.objSem.acquire();
		return this.obj;
	}

}
