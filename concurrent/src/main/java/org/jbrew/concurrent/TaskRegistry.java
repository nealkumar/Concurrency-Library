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
	 * Inserts the specified element into this {@link TaskRegistry}. Note that the {@link TaskRegistry} is unbounded.
	 * 
	 * @param task - The {@link org.jbrew.concurrent.Task} to be inserted.
	 */
	public abstract void offerTask(Task<?> task);
	/**
	 * Removes a single instance of the specified {@link org.jbrew.concurrent.Task} from this {@link TaskRegistry}, 
	 * if it is present. More formally, removes a <code>Task task</code> such that <code>task</code> is no longer 
	 * present in the {@link TaskRegistry} if this {@link TaskRegistry} contains one or more such elements. 
	 * 
	 * @param task - The {@link org.jbrew.concurrent.Task} to be removed.
	 */
	public abstract void removeTask(Task<?> task);
	public abstract int getRegistrySize();
	public abstract Task<?> pollTask();
	public abstract void interruptAll();

}
