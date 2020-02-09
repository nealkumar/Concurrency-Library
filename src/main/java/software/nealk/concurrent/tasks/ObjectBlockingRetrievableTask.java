package software.nealk.concurrent.tasks;

import software.nealk.concurrent.Task;

public abstract class ObjectBlockingRetrievableTask<T> implements Task{
	
	protected volatile T obj;

	@Override
	public final void run() {
		// TODO Auto-generated method stub
		execute();
	}
	
	protected abstract void execute();

	@SuppressWarnings("unchecked")
	@Override
	public synchronized final T getVal() throws InterruptedException {
		// TODO Auto-generated method stub
		while(this.obj == null) {
			this.wait();
		}
		return obj;
	}

}
