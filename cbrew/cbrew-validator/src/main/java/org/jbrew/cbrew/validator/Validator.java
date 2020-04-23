package org.jbrew.cbrew.validator;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.jbrew.concurrent.BoundedTaskQueue;
import org.jbrew.concurrent.ObjectBlockingTask;
import org.jbrew.concurrent.Task;
import org.jbrew.concurrent.TaskQueue;

public final class Validator {

	private final ObjectBlockingTask<Boolean> memTestTask, pThreadTestTask;
	private List<Task<?>> validateTaskList;
	private TaskQueue<Task<?>> taskQueue;

	private Validator(CBrewValidatorBuilder builder){
		this.validateTaskList = new ArrayList<>(2);
		this.taskQueue = new BoundedTaskQueue(validateTaskList.size());	// TODO - Make TaskQueue a collection so it can be be used instead of ArrayList 
		this.memTestTask = (builder.memTestFlag) ? new MemoryAllocateValidatorTask() : null;
		this.pThreadTestTask = (builder.pThreadTestFlag) ? new PThreadValidatorTask() : null;
		validateTaskList.add(memTestTask);
		validateTaskList.add(pThreadTestTask);
		this.runTasks(this.validateTaskList.toArray(new Task<?>[this.validateTaskList.size()]));
	}
	
	@SafeVarargs
	private final void runTasks(Task<?>... tasks) {
		for(Task<?> t : tasks) runTask(t);
	}
	
	private final void runTask(Task<?> task) {
		if(task != null) new Thread(task).start();
	}

	public final static class CBrewValidatorBuilder{
		
		private boolean memTestFlag, pThreadTestFlag;

		public CBrewValidatorBuilder withMemTest(){
			this.memTestFlag = true;
			return this;
		}	

		public CBrewValidatorBuilder withPThreadTest(){
			this.pThreadTestFlag = true;
			return this;
		}
		
		public Validator build() {
			Validator validator = new Validator(this);
			return validator;
		}
	}
	
	private abstract class ValidatorTask extends ObjectBlockingTask<Boolean>{
		@Override
		protected void execute() {
			boolean result = executeTask();
			accept(result);		//release this thread from blocking any more resources
			String printStmt = "Status of " + getTaskName() + " Test is " + result;
			Logger.getLogger(ValidatorTask.class).info(printStmt);
			System.out.println(printStmt);
		}
		protected abstract boolean executeTask();
		protected abstract String getTaskName();
	}
	
	private final class MemoryAllocateValidatorTask extends ValidatorTask{
		@Override
		protected boolean executeTask() {
			return new MallocValidator().mallocTest();
		}

		@Override
		protected String getTaskName() {
			return "Memory Allocate";
		}
	}
	
	private final class PThreadValidatorTask extends ValidatorTask{
		@Override
		protected boolean executeTask() {
			return new PThreadValidator().pthreadTest();
		}

		@Override
		protected String getTaskName() {
			return "PThread";
		}
	}
	
	private final static class MallocValidator{
		static {
			System.loadLibrary("malloc-validator");
		}
		private native final boolean mallocTest();
	}
	
	private final static class PThreadValidator{
		static {
			System.loadLibrary("pthread-validator");
		}
		private native final boolean pthreadTest();
	}
	
	public static void main(String[] args) {
		Validator v = new Validator.CBrewValidatorBuilder().withMemTest().withPThreadTest().build();
		
	}

}
