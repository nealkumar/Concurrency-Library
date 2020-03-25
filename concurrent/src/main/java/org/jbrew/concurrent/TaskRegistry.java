package org.jbrew.concurrent;

/**
 * A {@link TaskRegistry} is an interface specifying the requirements for a "register" or collection of 
 * Tasks.
 * 
 * @see org.jbrew.concurrent.TaskRegister
 * 
 * @author nealk
 *
 */
public interface TaskRegistry {
	
	/**
	 * Inserts the specified element into this {@link TaskRegistry}. On average, the performance runtime of this
	 * method is O(1).
	 * 
	 * @param task - The {@link org.jbrew.concurrent.Task} to be inserted.
	 * @see org.jbrew.concurrent.TaskRegister#offer(Task)
	 */
	public abstract void offer(Task<?> task);
	/**
	 * Inserts the specified element into this {@link TaskRegistry}. This is the <code>varargs</code> implementation
	 * of {@link #offer(Task)}, meaning that it handles all instances where there are either 0 or &gt;1 parameter 
	 * arguments present.
	 * 
	 * @param tasks - The set of zero or more {@link org.jbrew.concurrent.Task} to be inserted into this registry.
	 */
	public abstract void offer(Task<?>...tasks);
	/**
	 * Removes a single instance of the specified {@link org.jbrew.concurrent.Task} from this {@link TaskRegistry}, 
	 * if it is present. More formally, removes a <code>Task task</code> such that <code>task</code> is no longer 
	 * present in the {@link TaskRegistry} if this {@link TaskRegistry} contains one or more such elements. 
	 * 
	 * @param task - The {@link org.jbrew.concurrent.Task} to be removed.
	 * @return
	 */
	public abstract boolean remove(Task<?> task);
	public abstract int getRegistrySize();
	public abstract Task<?> pollTask();
	public abstract void interruptAll();

}
