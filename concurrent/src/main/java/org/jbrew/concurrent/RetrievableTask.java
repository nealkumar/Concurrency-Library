package org.jbrew.concurrent;

public abstract class RetrievableTask<T> extends BlockingTask<T>{
	
	protected boolean printThreadIdFlag;
	
	/**
	 * Default constructor for RetrievableTask. This can be wrapped inside of a {@link java.lang.Thread} and executed in the same manner as a {@link java.lang.Runnable}.
	 */
	protected RetrievableTask() {
		this.printThreadIdFlag = true;
	}
	
	/**
	 * This constructor takes a boolean argument to determine whether the thread number should be printed to the console.
	 * @param printThreadIdFlag Flag which specifies whether thread number should be printed to the console.
	 */
	protected RetrievableTask(boolean printThreadIdFlag) {
		this.printThreadIdFlag = printThreadIdFlag;
	}
	
	/**
	 * Sets the value of the <code>obj</code> in a {@link ThreadSafe} manner.
	 * @param obj The object to set.
	 */
	@ThreadSafe
	protected abstract void submit(T obj);

	/**<p>
	 * Returns the value of the <code>obj</code> in a {@link ThreadSafe} manner. The method blocks until a condition is met (such as the excute() method returning or the <code>obj</code> of type &lt;T&gt; being set (via the setVal() method). For more information on the way internal contention is handled, please refer to {@link org.jbrew.concurrent.MethodBlockedTask} and {@link org.jbrew.concurrent.BlockedTask}.
	 * <br><br>
	 * Note that compile-time type checking is enabled. The usage 
	 * of Java Generics nullifies the compiler warning "unchecked".
	 * </p>
	 */
	
	/**
	 * 
	 * @param <T>
	 * @return
	 * @throws InterruptedException
	 */
	
	/**
	 * <p>
	 * 	Returns the value of the <code>obj</code> in a {@link ThreadSafe} manner. The method blocks until a condition is
	 *  met (such as the excute() method returning or the <code>obj</code> of type &lt;T&gt; being set (via the setVal() 
	 *  method). For more information on the way internal contention is handled, please refer to 
	 *  {@link org.jbrew.concurrent.MethodBlockedTask} and {@link org.jbrew.concurrent.BlockedTask}.
	 * </p>
	 * 
	 * @param <T> Generic of type "T" is explicitly defined at compile-time. 
	 * <br>&emsp;&emsp;<i>Example:</i><br>
	 * <code>
	 * &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;public class TaskImplementor&lt;T&gt; implements Task&lt;T&gt;{  }
	 * </code><br>
	 * @return 	value of obj - with type &lt;T&gt;
	 * @exception InterruptedException is thrown if the thread is interrupted. 
	 * @author Neal Kumar
	 */
	@SuppressWarnings("hiding")
	@ThreadSafe
	public abstract <T> T retrieve() throws InterruptedException;

}
