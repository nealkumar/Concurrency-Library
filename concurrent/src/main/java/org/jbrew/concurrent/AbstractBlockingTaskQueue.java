package org.jbrew.concurrent;

/**
 * A {@link AbstractBlockingTaskQueue} provides a skeletal implementation of the {@link org.jbrew.concurrent.TaskQueue} interface.
 * To implement an un/bounded queue of {@link org.jbrew.concurrent.Task}, the programmer only needs to extend this class
 * and concretely implement its abstract methods. 
 * @author nealk
 *
 */
public abstract class AbstractBlockingTaskQueue implements TaskQueue<Task<?>>{
	
	protected java.util.Optional<Integer> capacity;
	
	

}
