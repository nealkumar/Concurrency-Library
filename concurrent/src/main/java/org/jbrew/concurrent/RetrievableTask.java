package org.jbrew.concurrent;

public abstract class RetrievableTask<T> extends BlockingTask<T>{
	
	protected boolean printThreadIdFlag;
	
	/**
	 * <p>
	 * 	Default constructor for RetrievableTask. This can be wrapped inside of a {@link java.lang.Thread} and executed in the same manner as a {@link java.util.concurrent.Callable}.
	 * </p>
	 */
	protected RetrievableTask() {
		super();
	}
	
	/**
	 * <p>
	 * 	This constructor takes a boolean argument to determine whether the thread number should be printed to the console.
	 * 	A {@link RetrievableTask} can be wrapped inside of a {@link java.lang.Thread} and executed in the same manner as a {@link java.util.concurrent.Callable}.
	 * </p>
	 * @param printThreadIdFlag - <code>boolean</code> flag which specifies whether thread number should be printed to the console.
	 */
	protected RetrievableTask(boolean printThreadIdFlag) {
		super(printThreadIdFlag);
	}
	
	/**
	 * Sets the value of the <code>obj</code> in a {@link ThreadSafe} manner.
	 * @param obj The object to set.
	 */
	@ThreadSafe
	protected abstract void accept(T obj);
	
	/**
	 * <p>
	 * 	Returns the value of the <code>obj</code> in a {@link ThreadSafe} manner. The method blocks until a condition is
	 *  met (such as the excute() method returning or the <code>obj</code> of type &lt;T&gt; being set (via the setVal() 
	 *  method). For more information on the way internal contention is handled, please refer to 
	 *  {@link org.jbrew.concurrent.MethodBlockingTask} and {@link org.jbrew.concurrent.ObjectBlockingTask}.
	 * </p>
	 * 
	 * @param <T> The generic of type "T" is explicitly defined at compile-time. 
	 * <br>&emsp;&emsp;<i>Example:</i><br>
	 * <code>
	 * &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;public class TaskImplementor&lt;T&gt; implements Task&lt;ConcreteClass&gt;{  }
	 * </code><br>
	 * @return 	value of obj - with type &lt;T&gt;
	 * @exception InterruptedException is thrown if the thread is interrupted. 
	 * @author Neal Kumar
	 */
	@ThreadSafe
	public abstract T retrieve() throws InterruptedException;


}
