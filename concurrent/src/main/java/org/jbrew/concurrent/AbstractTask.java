package org.jbrew.concurrent;

/**
 * A {@link org.jbrew.concurrent.ThreadSafe} implementation of {@link org.jbrew.concurrent.Task}. A AbstractTask wraps boilerplate
 *  utility code so its implementors can focus on executing their respective business logic. 
 * <br>
 * @author Neal Kumar
 *
 * @param <T> - The type parameter for the respective AbstractTask.
 * 
 */
@ThreadSafe
public abstract class AbstractTask<T> implements Task<T> {

	private String name;
	private boolean printThreadId, printName, printBoth;
	private int priority;
	private final static String DEFAULT_NAME = "unnamed task";
	private final static int DEFAULT_PRIORITY = 5;
	
	/**
	 * <p>
	 * Default constructor for {@link AbstractTask}blocking which assigns {@link AbstractTask#printThreadId} to <code>false</code>
	 * and the {@link AbstractTask#name} to the {@link AbstractTask#DEFAULT_NAME}. Invoking this constructor will prevent 
	 * both the {@link AbstractTask#name} and the current thread's ID from printing to the console.
	 * </p>
	 * <p>Note that this constructor is the most performance-optimal implementation of a {@link AbstractTask}.</p> 
	 */
	protected AbstractTask() {
		this.printThreadId = false;
		this.name = DEFAULT_NAME;
		this.setPriority(DEFAULT_PRIORITY);
	}
	
	/**
	 * <p>
	 * A constructor for {@link AbstractTask} which includes an option to assign the <code>boolean</code>  
	 * {@link AbstractTask#printThreadId}'s value. Invoking this constructor will assign the {@link AbstractTask#name} 
	 * to the {@link AbstractTask#DEFAULT_NAME}, and prevent the ID from printing to the console.
	 * </p><p>
	 * 	Please note that this constructor is the <i>not</i> the most performance-optimal implementation of a {@link AbstractTask}.
	 * 	As such, usage of this constructor for performance-sensitive operations is <i>highly discouraged</i> and is considered
	 *  bad practice. Performance-sensitive applications should instead use the default constructor, {@link AbstractTask#BlockingTask()}.
	 * </p>
	 * @param printThreadId - a <code>boolean</code> flag which indicates whether or not to print out the current thread id 
	 * to the console.
	 */
	public AbstractTask(boolean printThreadId) {
		this.printThreadId = printThreadId;
		this.name = DEFAULT_NAME;
		this.setPriority(DEFAULT_PRIORITY);
	}
	
	/**
	 * <p>
	 * A constructor for {@link AbstractTask} which includes an option to assign the <code>String</code>  
	 * {@link AbstractTask#name}'s value. Invoking this constructor will prevent the ID from printing to the console. 
	 * </p>
	 * <p>
	 * 	Please note that this constructor is the <i>not</i> the most performance-optimal implementation of a {@link AbstractTask}.
	 * 	As such, usage of this constructor for performance-sensitive operations is <i>highly discouraged</i> and is considered
	 *  bad practice. Performance-sensitive applications should instead use the default constructor, {@link AbstractTask#BlockingTask()}.
	 * </p>
	 * @param name - a <code>String</code> for the current {@link org.jbrew.concurrent.Task}'s name.
	 */
	protected AbstractTask(String name) {
		this.printThreadId = false;
		this.name = name;
		this.printName = true;
		this.setPriority(DEFAULT_PRIORITY);
	}
	
	/**
	 * <p>
	 * A constructor for {@link AbstractTask} which includes an option to assign the <code>String</code>  
	 * {@link AbstractTask#name}'s value, as well as the <code>boolean</code> {@link AbstractTask#printThreadId}'s 
	 * value. Invoking this constructor will automatically print both the name and ID to the console.
	 * </p>
	 * <p>
	 * 	Please note that this constructor is the <i>not</i> the most performance-optimal implementation of a {@link AbstractTask}.
	 * 	As such, usage of this constructor for performance-sensitive operations is <i>highly discouraged</i> and is considered
	 *  bad practice. Performance-sensitive applications should instead use the default constructor, {@link AbstractTask#BlockingTask()}.
	 * </p> 
	 * @param printThreadId - <code>boolean</code> flag which enables console printing of the current thread's ID
	 * @param name - a <code>String</code> for the current {@link org.jbrew.concurrent.Task}'s name.
	 */
	protected AbstractTask(boolean printThreadId, String name) {
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