package org.jbrew.concurrent_tests.register;

import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.PriorityBlockingQueue;

import org.junit.Test;
import org.jbrew.concurrent.*;

@org.jbrew.Testing
public class TaskRegisterTest {
	
	private Task<Integer> task;
	
	@org.junit.Before
	public void setup() {
		task = new BT<>();
	}
	
	@Test
	public void instantiateTaskRegisterTest() {
		assertNotNull(new TaskRegister());
	}
	
	@Test
	public void removeTaskTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
		TaskRegister register = new TaskRegister();
		register.offerTask(task);
		//add reflection to test whether the actual PriorityBlockingQueue removes the Task<?>.
		Class<? extends Object> taskRegister = register.getClass();
		Class<?>[] taskParam = {Object.class};
		Field fieldDefinition = taskRegister.getDeclaredField("taskQueue");
		fieldDefinition.setAccessible(true);
		Object fieldValue = fieldDefinition.get(taskRegister.newInstance());
		Method contains = fieldValue.getClass().getDeclaredMethod("contains", taskParam);
		assert (Boolean) contains.invoke(fieldValue, this.task) == false;
	}
	
	@Test
	public void offerAndPollTaskTest() {
		TaskRegister register = new TaskRegister();
		register.offerTask(task);
		assert register.pollTask() == this.task;
	}
	
	private class BT<T> extends ObjectBlockingTask<Integer>{
		@Override
		protected void execute() {
			this.accept(69);
		}
	}

}
