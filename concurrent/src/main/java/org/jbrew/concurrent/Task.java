package org.jbrew.concurrent;

/**
 * A concrete Task is an object which has the ability to be wrapped inside of a {@link java.lang.Thread} - in the same manner as a {@link java.lang.Runnable} for multiple thread execution. 
 * The advantage to use a Task however, lies with with its extended capabilities from that of a {@link java.lang.Runnable}.
 * For example, an {@link ObjectBlockingRetrievableTask} handles blocking and synchronization for objects in contention. As such, downstream consumers of Tasks are easily able to integrate multithreading into their own applications, without worrying about race conditions.
 * 
 * @author Neal Kumar
 *
 * @param <T> Generic of type "T" is explicitly defined at compile-time. 
	 * <br>&emsp;&emsp;<i>Example:</i><br>
	 * <code>
	 * &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;public class TaskImplementor&lt;T&gt; implements Task&lt;T&gt;{  }
	 * </code><br>
 */
public interface Task<T> extends Runnable{
	
	/**
	 * <p>Returns the thread-safe value of Type &lt;?&gt;</p>
	 * 
	 * @param <T> Generic of type "T" is explicitly defined at compile-time. 
	 * <br>&emsp;&emsp;<i>Example:</i><br>
	 * <code>
	 * &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;public class TaskImplementor&lt;T&gt; implements Task&lt;T&gt;{  }
	 * </code><br>
	 * @return 	value of obj - with type &lt;?&gt;
	 * @exception InterruptedException is thrown if the thread is interrupted. 
	 * @author Neal Kumar
	 */
	@SuppressWarnings("hiding")
	@ThreadSafe
	public abstract <T extends Object> T getVal() throws InterruptedException;

}