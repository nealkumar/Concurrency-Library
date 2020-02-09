package software.nealk.concurrent.retrievable;


public abstract class ObjectBlockingRetrievableTask<T> extends RetrievableTask<T>{
	
	private T obj;

	@Override
	public final void run() {
		execute();
	}
	
	protected abstract void execute();
	
	@Override
	protected void setVal(T obj) {
		synchronized(this) {
			this.obj = obj;
			this.notifyAll();
		}
	}

	@Override
	public synchronized final T getVal() throws InterruptedException {
		while(this.obj == null) {
			this.wait();
		}
		return obj;
	}

}
