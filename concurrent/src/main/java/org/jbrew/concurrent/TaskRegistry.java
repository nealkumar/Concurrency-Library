package org.jbrew.concurrent;

public class TaskRegistry implements Registry {
	
	java.util.Queue<Task<?>> priorityTaskQueue;
	
	public TaskRegistry() {
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
		// TODO Auto-generated method stub
		return this.priorityTaskQueue.poll();
	}

	@Override
	/**
	 * TODO - Finish interruptAll method.
	 */
	public void interruptAll() {
		try{
			throw new InterruptedException();
		} catch(Exception e) {
			System.out.println("TaskRegistry#interruptAll() has NOT been implemented yet!");
			e.printStackTrace();
		}
	}
	
}