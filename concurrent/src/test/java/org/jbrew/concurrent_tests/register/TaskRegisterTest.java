package org.jbrew.concurrent_tests.register;

import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
		register.offer(task);
		//add reflection to test whether the actual PriorityBlockingQueue removes the Task<?>.
		Class<? extends Object> taskRegister = register.getClass();
		Class<?>[] taskParam = {Object.class};
		Field fieldDefinition = taskRegister.getDeclaredField("taskQueue");
		fieldDefinition.setAccessible(true);
		Object fieldValue = fieldDefinition.get(taskRegister.getDeclaredConstructor(new Class<?>[] {}).newInstance());
		Method contains = fieldValue.getClass().getDeclaredMethod("contains", taskParam);
		assert (Boolean) contains.invoke(fieldValue, this.task) == false;
	}
	
	@Test
	public void offerAndCheckSizeTest() {
		TaskRegister register = new TaskRegister();
		register.offer(task);
		register.offer(task);
		assert register.getRegistrySize() == 2;
	}
	
	/**
	 * Ensures that {@link org.jbrew.concurrent.TaskRegister#pollTask()} correctly sorts
	 * ands polls the highest priority Task.
	 */
	@Test
	public void offerAndPollTaskTest() {
		TaskRegister register = new TaskRegister();
		Task<Integer> lowPTask = new BT<>(), highPTask = new BT<>();
		highPTask.setPriority(10);
		highPTask.setName("High Priority");
		lowPTask.setPriority(1);
		lowPTask.setName("Low Priority");
		register.offer(lowPTask);
		register.offer(highPTask);
		assert register.pollTask().getName() == "High Priority";
	}
	
	@Test
	(expected = UnsupportedOperationException.class)
	public void interuptAllTest() {
		TaskRegister register = new TaskRegister();
		register.interruptAll();
	}
	
	private class BT<T> extends ObjectBlockingTask<Integer>{
		@Override
		protected void execute() {
			this.accept(69);
		}
	}

}
