package org.jbrew.concurrent;

import org.jbrew.core.annotations.ThreadSafe;

/**
 * A {@link BoundedTaskQueue} is an unordered, bounded implementation of a {@link org.jbrew.concurrent.AbstractBlockingTaskQueue}. 
 * This implementation is {@link org.jbrew.core.annotations.ThreadSafe}, as it can safely handle multiple consumer
 * and producer threads writing and/or reading from it.
 * @author nealk
 */
@ThreadSafe
public class BoundedTaskQueue extends AbstractBlockingTaskQueue{
	
	private final int capacity;
	
	public BoundedTaskQueue(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public void enqueue(Task<? extends Object> task) throws InterruptedException {
		synchronized(this) {
			while(this.queue.size() == capacity) this.wait();
		}
		this.queue.offer(task);
		synchronized(this) {notifyAll();}
	}

	/**
	 * @return the capacity of this {@link org.jbrew.concurrent.AbstractBlockingTaskQueue}.
	 */
	public int getCapacity() {
		return capacity;
	}

}
