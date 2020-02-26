package org.jbrew.concurrent;

/**
 * A {@link StandardTask} object is an abstract implementor of {@link org.jbrew.concurrent.Task} allowing for the
 * object to be wrapped inside of a {@link java.lang.Thread} and executed concurrently.
 * <br><br>
 * For an object blocking implementation of a {@link org.jbrew.concurrent.BlockingTask} (similar to a {@link java.util.concurrent.Callable}, please see:
 * {@link org.jbrew.concurrent.ObjectBlockingTask} and {@link org.jbrew.concurrent.MethodBlockingTask}.
 * @author nealk
 *
 */
public abstract class StandardTask extends BlockingTask<Void>{

	@Override
	public final void run() {
		this.execute();
	}
	
}
