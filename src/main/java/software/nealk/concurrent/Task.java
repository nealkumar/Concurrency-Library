package software.nealk.concurrent;

public interface Task extends Runnable{
	
	/**
	 * <p>Returns the thread-safe value of Type &lt;?&gt;</p>
	 * 
	 * @param <T>
	 * @return - value of obj - with type &lt;?&gt;
	 * @exception InterruptedException
	 * @author nealk
	 */
	@ThreadSafe
	public abstract <T extends Object> T getVal() throws InterruptedException;

}
