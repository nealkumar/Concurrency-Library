package org.jbrew.concurrent;

import java.util.concurrent.PriorityBlockingQueue;

public class TaskRegister implements TaskRegistry {
	
	private java.util.Queue<Task<?>> taskQueue;
	private static final int INITIAL_QUEUE_CAPACITY = 11;
	
	public TaskRegister() {
		this.taskQueue = new PriorityBlockingQueue<>(INITIAL_QUEUE_CAPACITY, new TaskComparator());
	}

	@Override
	public void offerTask(Task<?> task) {
		this.taskQueue.offer(task);
	}

	@Override
	public void removeTask(Task<?> task) {
		this.taskQueue.remove(task);
	}

	@Override
	public Task<?> pollTask() {
		return this.taskQueue.poll();
	}

	@Override
	/**
	 * interuptAll() implementation is the subject of (#79), and as such will be
	 * addressed prior to release of v0.1.0.
	 */
	public void interruptAll() {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getRegistrySize() {
		return this.taskQueue.size();
	}
	
}