package org.jbrew.concurrent;

/**
 * A {@link Threadable} object is an abstract implementor of {@link org.jbrew.concurrent.Task} allowing for the
 * object to be wrapped inside of a {@link java.lang.Thread} and executed concurrently.
 * <br><br>
 * For an object blocking implementation of a {@link org.jbrew.concurrent.BlockingTask} (similar to a {@link java.util.concurrent.Callable}, please see:
 * {@link org.jbrew.concurrent.ObjectBlocker} and {@link org.jbrew.concurrent.MethodBlocker}.
 * @author nealk
 *
 */
public abstract class Threadable extends BlockingTask<Void>{

	@Override
	public final void run() {
		this.execute();
	}
	
}
