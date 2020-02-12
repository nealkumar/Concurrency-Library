package org.jbrew.concurrent;

public interface Task<T> extends Runnable{
	
	/**
	 * <p>Returns the thread-safe value of Type &lt;?&gt;</p>
	 * 
	 * @param <T> Generic of type "T" is explicitly defined at compile-time. 
	 * <br>&emsp;&emsp;Ex:<br>
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