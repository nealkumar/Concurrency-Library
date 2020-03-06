package org.jbrew.concurrent;

import java.util.concurrent.PriorityBlockingQueue;

public class TaskRegister implements TaskRegistry {
	
	private java.util.AbstractQueue<Task<?>> taskQueue;
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
	 * TODO - Finish interruptAll() method implementation.
	 */
	public void interruptAll() {
//		try{
//			throw new UnsupportedOperationException();
//		} catch(Exception e) {
//			System.out.println("TaskRegister#interruptAll() has NOT been implemented yet!");
//			e.printStackTrace();
//		}
		throw new UnsupportedOperationException();
	}

	@Override
	public int getRegistrySize() {
		return this.taskQueue.size();
	}
	
}