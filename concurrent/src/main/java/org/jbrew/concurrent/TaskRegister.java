package org.jbrew.concurrent;

public class TaskRegister implements Registry {
	
	java.util.Queue<Task<?>> priorityTaskQueue;
	
	public TaskRegister() {
		this.priorityTaskQueue = new java.util.PriorityQueue<>(new TaskComparator());
	}

	@Override
	public void offerTask(Task<?> task) {
		this.priorityTaskQueue.offer(task);
	}

	@Override
	public void removeTask(Task<?> task) {
		this.priorityTaskQueue.remove(task);
	}

	@Override
	public Task<?> pollTask() {
		return this.priorityTaskQueue.poll();
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
	
}