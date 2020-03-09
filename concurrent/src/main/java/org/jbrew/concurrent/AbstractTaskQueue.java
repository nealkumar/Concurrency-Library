package org.jbrew.concurrent;

/**
 * A {@link AbstractTaskQueue} is an unordered bounded implementation of a {@link org.jbrew.concurrent.TaskQueue}. 
 * This implementation is {@link org.jbrew.concurrent.ThreadSafe}, as it can safely handle multiple consumer
 * and producer threads writing and/or reading from it.
 * @author nealk
 *
 */
public abstract class AbstractTaskQueue implements TaskQueue<Task<?>>{

	@Override
	public void enqueue(Task<?> task) throws InterruptedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Task<?> dequeue() throws InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
