package org.jbrew.concurrent;

/**
 * A {@link MethodBlockingTask} blocks {@link MethodBlockingTask#retrieve()} until the {@link MethodBlockingTask#execute()} 
 * method has fully completed and terminated.
 * @author nealk
 *
 * @param <T> The Java Generic of type "T" is explicitly defined at compile-time. 
	 * <br>&emsp;&emsp;<i>Example:</i><br>
	 * <code>
	 * &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;public class Implementor&lt;T&gt; extends MethodBlockingTask&lt;ConcreteClass&gt;{  }
	 * </code><br>
 */
public abstract class MethodBlockingTask<T> extends RetrievableTask<T>{
	
	private T obj;
	private java.util.concurrent.Semaphore objSem;
	
	protected MethodBlockingTask() {
		this.objSem = new java.util.concurrent.Semaphore(0, false);
	}

	@Override
	public final void run() {
		this.execute();
		this.objSem.release();
	}
	
	protected abstract void execute();
	
	protected final void accept(T obj) {
		this.obj = obj;
	}

	/**
	 * <p>
	 * Returns the value of the object once the {@link MethodBlockingTask#execute()} method has returned, 
	 * as set by the {@link MethodBlockingTask#accept(Object)} method. 
	 * </p><p>
	 * From the parent document:
	 * </p>
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <p>
	 * Note that compile-time type checking is enabled. The usage 
	 * of Java Generics nullifies the compiler warning "unchecked".
	 * </p>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public final T retrieve() throws InterruptedException {
		this.objSem.acquire();
		return this.obj;
	}

}
