package org.jbrew.concurrent;

/**
 * A {@link MethodBlocker} blocks {@link MethodBlocker#retrieve()} until the {@link MethodBlocker#execute()} 
 * method has fully completed and terminated.
 * @author nealk
 *
 * @param <T> The Java Generic of type "T" is explicitly defined at compile-time. 
	 * <br>&emsp;&emsp;<i>Example:</i><br>
	 * <code>
	 * &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;public class Implementor&lt;T&gt; extends MethodBlocker&lt;ConcreteClass&gt;{  }
	 * </code><br>
 */
public abstract class MethodBlocker<T> extends RetrievableTask<T>{
	
	private T obj;
	private java.util.concurrent.Semaphore objSem;
	
	protected MethodBlocker() {
		this.objSem = new java.util.concurrent.Semaphore(0, false);
	}

	@Override
	public final void run() {
		this.execute();
		this.objSem.release();
	}
	
	protected abstract void execute();
	
	protected final void submit(T obj) {
		this.obj = obj;
	}

	/**
	 * <p>
	 * Returns the value of the object once the {@link MethodBlocker#execute()} method has returned, 
	 * as set by the {@link MethodBlocker#submit(Object)} method. 
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
	@Override
	public final T retrieve() throws InterruptedException {
		this.objSem.acquire();
		return this.obj;
	}

}
