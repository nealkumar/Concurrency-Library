package org.jbrew.concurrent;

/**
 * A {@link AbstractTaskQueue} provides a skeletal implementation of the {@link org.jbrew.concurrent.TaskQueue} interface.
 * To implement an un/bounded queue of {@link org.jbrew.concurrent.Task}, the programmer only needs to extend this class
 * and concretely implement its abstract methods. 
 * @author nealk
 *
 */
public abstract class AbstractTaskQueue implements TaskQueue<Task<? extends Object>>{
	
	protected java.util.Queue<Task<? extends Object>> queue;
	
	@Override
	public final Task<? extends Object> dequeue(){
		Task<?> task = null;
		try {
			synchronized(this) {
				while(this.queue.size() <= 0) this.wait();
				task = queue.poll();
				this.notifyAll();
			}
		} catch(NullPointerException npe){
			System.out.println("TaskQueue class has NOT been initialized! You first need to instantiate your "
					+ "TaskQueue object before attempting your operation.");
			npe.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return task;
	}

}
