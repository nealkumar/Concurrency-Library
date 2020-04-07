package org.jbrew.concurrent;

import org.jbrew.core.annotations.ThreadSafe;

/**
 * A {@link BoundedTaskQueue} is an unordered, unbounded implementation of a {@link org.jbrew.concurrent.TaskQueue}. 
 * This implementation is {@link org.jbrew.core.annotations.ThreadSafe}, as it can safely handle multiple consumer
 * and producer threads writing and/or reading from it.
 * @author nealk
 */
@ThreadSafe
public class UnboundedTaskQueue extends AbstractBlockingTaskQueue{

	@Override
	public void enqueue(Task<? extends Object> task) throws InterruptedException {
		queue.offer(task);
	}

}
