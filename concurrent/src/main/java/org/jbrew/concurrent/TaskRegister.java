package org.jbrew.concurrent;

import java.util.concurrent.PriorityBlockingQueue;

public class TaskRegister implements TaskRegistry {
	
	java.util.AbstractQueue<Task<?>> taskQueue;
	
	public TaskRegister() {
		this.taskQueue = new PriorityBlockingQueue<>();
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
		try{
			throw new UnsupportedOperationException("See TODO comment @ line 30 in TaskRegister.java.");
		} catch(Exception e) {
			System.out.println("TaskRegister#interruptAll() has NOT been implemented yet!");
			e.printStackTrace();
		}
	}

	@Override
	public int getRegistrySize() {
		return this.taskQueue.size();
	}
	
}