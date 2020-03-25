package org.jbrew.concurrent;

/**
 * A {@link org.jbrew.concurrent.AbstractTask} that returns a result. Implementors must define a single method
 * with no arguments called <code>execute</code>. In these manners, a <code>RetrievableTask</code> is similar to a 
 * {@link org.jbrew.concurrent.BasicTask} and {@link java.util.concurrent.Callable} in that the former is designed
 * for classes whose instances can be potentially wrapped in another thread - while the latter also returns a result.
 * Unlike a {@link java.util.concurrent.Callable} however, a <code>RetrievableTask</code> does not natively
 * throw an exception, although certain flagship methods may, such as {@link RetrievableTask#retrieve()}.
 * <br><br>
 * For a non-returnable implementation of an {@link org.jbrew.concurrent.AbstractTask}, please refer to 
 * {@link org.jbrew.concurrent.BasicTask}.
 * 
 * @author nealk
 *
 * @param <T> - The type of object the programmer wishes to operate upon.
 * @see org.jbrew.concurrent.AbstractTask
 * @see org.jbrew.concurrent.ObjectBlockingTask
 * @see org.jbrew.concurrent.MethodBlockingTask
 * @see org.jbrew.concurrent.BasicTask
 */
public abstract class RetrievableTask<T> extends AbstractTask<T>{
	
	protected boolean printThreadIdFlag;
	
	/**
	 * <p>
	 * 	The default, noargs constructor for RetrievableTask. This can be wrapped inside of a {@link java.lang.Thread} and executed in the same manner as a {@link java.util.concurrent.Callable}.
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
	 * Please note that Java generics are used for the programmer to explicitly define the Type when extending this class. 
	 * <br>&emsp;&emsp;<i>Example:</i><br>
	 * <code>
	 * &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;public class TaskImplementor&lt;T&gt; implements Task&lt;ConcreteClass&gt;{  }
	 * </code><br>
	 * @return 	value of obj - with type &lt;T&gt;
	 * @exception InterruptedException is thrown if the thread is interrupted. 
	 * @author Neal Kumar
	 * @see org.jbrew.concurrent.ObjectBlockingTask
	 * @see org.jbrew.concurrent.MethodBlockingTask 
	 */
	@ThreadSafe
	public abstract T retrieve() throws InterruptedException;

}
