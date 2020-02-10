package software.nealk.concurrent.retrievable;

import software.nealk.concurrent.Task;
import software.nealk.concurrent.ThreadSafe;

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
	 * Sets the value of <code>obj</code> in a ThreadSafe manner.
	 * @param obj
	 */
	@ThreadSafe
	protected abstract void setVal(T obj);

	/**
	 * Blocks until {@link obj} of type &lt;T&gt; is not null. Returns the {@link obj}.
	 * <br><br>
	 * Note that compile-time type checking is enabled. The usage 
	 * of Java Generics nullifies the compiler warning "unchecked".
	 */
	@SuppressWarnings("unchecked") 
	@Override 
	@ThreadSafe
	public abstract T getVal() throws InterruptedException;

}
