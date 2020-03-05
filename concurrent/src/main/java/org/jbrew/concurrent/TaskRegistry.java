package org.jbrew.concurrent;

public interface TaskRegistry {
	
	public abstract void offerTask(Task<?> task);
	public abstract void removeTask(Task<?> task);
	public abstract Task<?> pollTask();
	public abstract void interruptAll();

}
