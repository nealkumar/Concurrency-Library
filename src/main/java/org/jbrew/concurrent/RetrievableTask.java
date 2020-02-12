package org.jbrew.concurrent;

public abstract class RetrievableTask<T> implements Task<T>{
	
	protected boolean printThreadIdFlag;
	
	protected RetrievableTask() {
		this.printThreadIdFlag = true;
	}
	
	protected RetrievableTask(boolean printThreadIdFlag) {
		this.printThreadIdFlag = printThreadIdFlag;
	}

	@Override
	public void run() {
		if(printThreadIdFlag) {
			System.out.println("Thread " 
							+ Thread.currentThread().getId()
							+ " is running...");
		}
	}
	
	protected abstract void execute();
	
	/**
	 * Sets the value of the <code>obj</code> in a {@link ThreadSafe} manner.
	 * @param obj The object to set.
	 */
	@ThreadSafe
	protected abstract void setVal(T obj);

	/**<p>
	 * Gets and returns the value of the <code>obj</code> in a {@link ThreadSafe} manner. The method blocks until a condition is met (such as the excute() method returning or the <code>obj</code> of type &lt;T&gt; being set (via the setVal() method). For more information on the way internal contention is handled, please refer to {@link org.jbrew.concurrent.MethodBlockingRetrievableTask} and {@link org.jbrew.concurrent.ObjectBlockingRetrievableTask}.
	 * <br><br>
	 * Note that compile-time type checking is enabled. The usage 
	 * of Java Generics nullifies the compiler warning "unchecked".
	 * </p>
	 */
	@SuppressWarnings("unchecked") 
	@Override 
	@ThreadSafe
	public abstract T getVal() throws InterruptedException;

}
