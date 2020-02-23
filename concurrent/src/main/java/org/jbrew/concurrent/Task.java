package org.jbrew.concurrent;

/**
 * A concrete Task is an object which has the ability to be wrapped inside of a {@link java.lang.Thread} - in the same manner as a {@link java.lang.Runnable} for multiple thread execution. 
 * The advantage to use a Task however, lies with with its extended capabilities from that of a {@link java.lang.Runnable}.
 * For example, an {@link BlockedObject} handles blocking and synchronization for objects in contention. As such, downstream consumers of Tasks are easily able to integrate multithreading into their own applications, without worrying about race conditions.
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
	 * Returns the {@code String} name of the {@link Task}.
	 */
	public String getName();
	
	/**
	 * Sets the name of the {@link Task}.
	 * @param name - the {@code String} "name" for the {@link Task}.
	 */
	public void setName(String name);
	
	/**
	 * Returns the {@code long} id of the {@link Task}.
	 */
	public long getId();

}