package org.jbrew.concurrent;

/**
 * A TaskQueue is a set of ordered or unordered {@link org.jbrew.concurrent.Task} Tasks placed into a custom
 * queue which can be operated by producers or consumers in one or more {@link java.lang.Thread}.
 * @author nealk
 *
 * @param <T> - The type of {@link org.jbrew.concurrent.Task}. The full type parameter in the interface's signature
 * is:</br>&nbsp;&nbsp; <code>&lt;T extends {@link org.jbrew.concurrent.Task}&lt;? extends {@link java.lang.Object}&gt;&gt;</code>. 
 */
public interface TaskQueue<T extends Task<? extends Object>> {
	
	/**
	 * Adds an element to the head of the queue. When the queue is full (bounded implementations only), the calling 
	 * {@link java.lang.Thread} is blocked until capacity in the queue has been released.
	 * @param task - The {@link org.jbrew.concurrent.Task} which is being added to the queue.
	 * @throws InterruptedException - The method hands off the responsibility of exception handling to the caller in 
	 * event of an interruption in the {@link java.lang.Thread}.  
	 */
	public void enqueue(T task) throws InterruptedException;
	/**
	 * Removes an element from the tail of the queue and returns it. If the queue is empty, the calling 
	 * {@link java.lang.Thread} is blocked until a {@link org.jbrew.concurrent.Task} is added to the queue
	 * and it is no longer empty.
	 * @return The {@link org.jbrew.concurrent.Task} which is being removed from the queue.
	 * @throws InterruptedException - The method hands off the responsibility of exception handling to the caller in 
	 * event of an interruption in the {@link java.lang.Thread}.
	 */
	public T dequeue() throws InterruptedException;
	

}
