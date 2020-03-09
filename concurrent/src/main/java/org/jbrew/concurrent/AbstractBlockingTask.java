package org.jbrew.concurrent;

/**
 * A {@link org.jbrew.concurrent.ThreadSafe} implementation of {@link org.jbrew.concurrent.Task}. A AbstractBlockingTask wraps boilerplate
 *  utility code so its implementors can focus on executing their respective business logic. 
 * <br>
 * @author Neal Kumar
 *
 * @param <T> - The type parameter for the respective AbstractBlockingTask.
 * 
 */
@ThreadSafe
public abstract class AbstractBlockingTask<T> implements Task<T> {

	private String name;
	private boolean printThreadId, printName, printBoth;
	private int priority;
	private final static String DEFAULT_NAME = "unnamed task";
	private final static int DEFAULT_PRIORITY = 5;
	
	/**
	 * <p>
	 * Default constructor for {@link AbstractBlockingTask}blocking which assigns {@link AbstractBlockingTask#printThreadId} to <code>false</code>
	 * and the {@link AbstractBlockingTask#name} to the {@link AbstractBlockingTask#DEFAULT_NAME}. Invoking this constructor will prevent 
	 * both the {@link AbstractBlockingTask#name} and the current thread's ID from printing to the console.
	 * </p>
	 * <p>Note that this constructor is the most performance-optimal implementation of a {@link AbstractBlockingTask}.</p> 
	 */
	protected AbstractBlockingTask() {
		this.printThreadId = false;
		this.name = DEFAULT_NAME;
		this.setPriority(DEFAULT_PRIORITY);
	}
	
	/**
	 * <p>
	 * A constructor for {@link AbstractBlockingTask} which includes an option to assign the <code>boolean</code>  
	 * {@link AbstractBlockingTask#printThreadId}'s value. Invoking this constructor will assign the {@link AbstractBlockingTask#name} 
	 * to the {@link AbstractBlockingTask#DEFAULT_NAME}, and prevent the ID from printing to the console.
	 * </p><p>
	 * 	Please note that this constructor is the <i>not</i> the most performance-optimal implementation of a {@link AbstractBlockingTask}.
	 * 	As such, usage of this constructor for performance-sensitive operations is <i>highly discouraged</i> and is considered
	 *  bad practice. Performance-sensitive applications should instead use the default constructor, {@link AbstractBlockingTask#BlockingTask()}.
	 * </p>
	 * @param printThreadId - a <code>boolean</code> flag which indicates whether or not to print out the current thread id 
	 * to the console.
	 */
	public AbstractBlockingTask(boolean printThreadId) {
		this.printThreadId = printThreadId;
		this.name = DEFAULT_NAME;
		this.setPriority(DEFAULT_PRIORITY);
	}
	
	/**
	 * <p>
	 * A constructor for {@link AbstractBlockingTask} which includes an option to assign the <code>String</code>  
	 * {@link AbstractBlockingTask#name}'s value. Invoking this constructor will prevent the ID from printing to the console. 
	 * </p>
	 * <p>
	 * 	Please note that this constructor is the <i>not</i> the most performance-optimal implementation of a {@link AbstractBlockingTask}.
	 * 	As such, usage of this constructor for performance-sensitive operations is <i>highly discouraged</i> and is considered
	 *  bad practice. Performance-sensitive applications should instead use the default constructor, {@link AbstractBlockingTask#BlockingTask()}.
	 * </p>
	 * @param name - a <code>String</code> for the current {@link org.jbrew.concurrent.Task}'s name.
	 */
	protected AbstractBlockingTask(String name) {
		this.printThreadId = false;
		this.name = name;
		this.printName = true;
		this.setPriority(DEFAULT_PRIORITY);
	}
	
	/**
	 * <p>
	 * A constructor for {@link AbstractBlockingTask} which includes an option to assign the <code>String</code>  
	 * {@link AbstractBlockingTask#name}'s value, as well as the <code>boolean</code> {@link AbstractBlockingTask#printThreadId}'s 
	 * value. Invoking this constructor will automatically print both the name and ID to the console.
	 * </p>
	 * <p>
	 * 	Please note that this constructor is the <i>not</i> the most performance-optimal implementation of a {@link AbstractBlockingTask}.
	 * 	As such, usage of this constructor for performance-sensitive operations is <i>highly discouraged</i> and is considered
	 *  bad practice. Performance-sensitive applications should instead use the default constructor, {@link AbstractBlockingTask#BlockingTask()}.
	 * </p> 
	 * @param printThreadId - <code>boolean</code> flag which enables console printing of the current thread's ID
	 * @param name - a <code>String</code> for the current {@link org.jbrew.concurrent.Task}'s name.
	 */
	protected AbstractBlockingTask(boolean printThreadId, String name) {
		this.printThreadId = printThreadId;
		this.name = name;
		this.printBoth = true;
		this.printThreadId = false;
		this.setPriority(DEFAULT_PRIORITY);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		if(printThreadId) new PrintId().print();
		else if(printName) new PrintName().print();
		else if(printBoth) new PrintBoth().print();
	}
	
	/**
	 * The execute() method allows clients to execute the business logic associated 
	 * with the respective {@link org.jbrew.concurrent.Task}.
	 */
	protected abstract void execute();
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public final void setName(String name) {
		this.name = name;
	}
	
	@Override
	public final void setPriority(int priority) {
		this.priority = priority;
	}
	
	@Override
	public final int getPriority() {
		return this.priority;
	}
	
	/**
	 * Returns the id {@code long} of the {@link Task}'s current thread.
	 */
	@Override
	public long getThreadId() {
		return Thread.currentThread().getId();
	}
	
	@SuppressWarnings("hiding")
	private abstract class PrintStrategy<T>{
		public void print() {
			System.out.println("Thread " + getInfo() + " is running...");
		}
		protected abstract T getInfo();
	}
	
	private class PrintId extends PrintStrategy<Long>{
		@Override
		protected Long getInfo() {
			return Thread.currentThread().getId();
		}
	}
	
	private class PrintName extends PrintStrategy<String>{
		@Override
		protected String getInfo() {
			return name;
		}
	}
	
	private class PrintBoth extends PrintStrategy<String>{
		@Override
		protected String getInfo() {
			return "{ID = " + Thread.currentThread().getId()
					+ ", Name = '" 
					+ name + "'}";
		}
	}

}