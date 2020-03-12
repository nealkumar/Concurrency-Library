package org.jbrew.concurrent;

/**
 * A {@link BasicTask} object is an abstract implementor of {@link org.jbrew.concurrent.Task} allowing for the
 * object to be wrapped inside of a {@link java.lang.Thread} and executed concurrently.
 * <br><br>
 * For an object blocking implementation of a {@link org.jbrew.concurrent.AbstractTask} (similar to a {@link java.util.concurrent.Callable}, please see:
 * {@link org.jbrew.concurrent.ObjectBlockingTask} and {@link org.jbrew.concurrent.MethodBlockingTask}.
 * @author nealk
 *
 */
public abstract class BasicTask extends AbstractTask<Void>{

	@Override
	public final void run() {
		this.execute();
	}
	
}
