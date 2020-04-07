package org.jbrew.concurrent_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;
import org.jbrew.concurrent.AbstractTask;
import org.jbrew.core.annotations.Testing;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

@Testing
public class BlockingTaskTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;
	private final Logger logger = Logger.getRootLogger();
	private final TestAppender appender = new TestAppender();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
		logger.addAppender(appender);
	}

	@After
	public void restoreStreams() {
		System.setOut(originalOut);
		System.setErr(originalErr);
		BasicConfigurator.resetConfiguration();
	}

	@Test
	public void instantiateBlockingTask() {
		AbstractTask<Void> basic = new MyTask<>();
		assertNotNull(basic);
	}
	
	@Test
	public void instantiateBlockingTask2() {
		AbstractTask<Void> basic = new MyTask<>(true);
		assertNotNull(basic);
	}

	@Test
	public void instantiateBlockingTaskAndTestSysOut() {
		AbstractTask<Void> basic = new MyTask<>();
		basic.run();
		assertEquals("", outContent.toString());
	}

	@Test
	public void instantiateBlockingTask2AndTestSysOut() {
		AbstractTask<Void> basic = new MyTask<>(true);
		basic.run();
		assertTrue(!outContent.toString().isEmpty());
	}
	
	/**
	 * Instantitates an {@link org.jbrew.concurrent.AbstractTask#AbstractTask(boolean)} and tests whether the log's
	 * <code>Level</code> is correct (should be Level.INFO).
	 */
	@Test
	public void instantiateBlockingTask2AndTestLogging() {
		AbstractTask<Void> basic = new MyTask<>(true);
		basic.run();
		logger.removeAllAppenders();
		final List<LoggingEvent> log = appender.getList();
		final LoggingEvent headLog = log.get(0);
		assertTrue(headLog.getLevel().equals(Level.INFO));
	}
	
	/**
	 * Instantitates an {@link org.jbrew.concurrent.AbstractTask#AbstractTask(boolean)} and tests whether the log's
	 * content (via regex) contains a thread number.
	 */
	@Test
	public void instantiateBlockingTask2AndTestLogging2() {
		AbstractTask<Void> basic = new MyTask<>(true);
		basic.run();
		logger.removeAllAppenders();
		final List<LoggingEvent> log = appender.getList();
		final LoggingEvent headLog = log.get(0);
		assertTrue(headLog.toString().matches(".*[0-9]+.*"));
	}

	@Test
	public void instantiateBlockingTask3() {
		AbstractTask<Void> basic = new MyTask<>("Task Name");
		assertNotNull(basic);
	}

	@Test
	public void instantiateBlockingTask3AndTestSysOut() {
		AbstractTask<Void> basic = new MyTask<>("Task Name");
		basic.run();
		assertTrue(outContent.toString().contains(basic.getName()));
	}
	
	/**
	 * Instantitates an {@link org.jbrew.concurrent.AbstractTask#AbstractTask(boolean)} and tests whether the log's
	 * <code>Level</code> is correct (should be Level.INFO).
	 */
	@Test
	public void instantiateBlockingTask3AndTestLogging() {
		AbstractTask<Void> basic = new MyTask<>(true);
		basic.run();
		logger.removeAllAppenders();
		final List<LoggingEvent> log = appender.getList();
		final LoggingEvent headLog = log.get(0);
		assertNotEquals(Optional.empty(), 
				log.parallelStream().filter(x -> Level.INFO.equals(
						headLog.getLevel()))
						.findAny());
	}
	
	/**
	 * Instantiates an {@link org.jbrew.concurrent.AbstractTask#AbstractTask(boolean)} and tests whether the log's
	 * content (via regex) contains the task name specified.
	 */
	@Test
	public void instantiateBlockingTask3AndTestLogging2() {
		AbstractTask<Void> basic = new MyTask<>("task_name");
		basic.run();
		logger.removeAllAppenders();
		final List<LoggingEvent> log = appender.getList();
		assertEquals(Optional.empty(), log.parallelStream().filter(x -> "task_name".contains(x.toString())).findAny());
	}

	@Test
	public void instantiateBlockingTask3_nameTest() {
		String s = "Task Name";
		AbstractTask<Void> basic = new MyTask<>(s);
		assertEquals(s, basic.getName());
	}

	@Test
	public void instantiateBlockingTask4() {
		AbstractTask<Void> basic = new MyTask<>(true, "Task Name for Task Four.");
		assertNotNull(basic);
	}
	
	@Test
	public void instantiateBlockingTask4AndTestLogging() {
		AbstractTask<Void> basic = new MyTask<>(true, "Task Name for Task Four.");
		basic.run();
		final List<LoggingEvent> log = appender.getList();
		assertEquals(Optional.empty(), log.parallelStream()
										.filter(x -> ".*[0-9]+.*".matches(
												x.toString())
										)
										.findAny());
	}

	@Test
	public void instantiateBlockingTask4_NameTest() {
		String s = "Task Name for Task Four.";
		AbstractTask<Void> basic = new MyTask<>(true, s);
		assertEquals(s, basic.getName());
	}

	@Test
	public void setBlockingTaskName() {
		AbstractTask<Void> basic = new MyTask<>();
		basic.setName("Basic Task Name");
		assertEquals("Basic Task Name", basic.getName());
	}

	@Test
	public void checkBlockingTaskThreadId() {
		AbstractTask<Void> basic = new MyTask<>();
		basic.run();
		assertEquals(Thread.currentThread().getId(), basic.getThreadId());
	}

	@Test
	public void checkBlockingTaskThreadId2() {
		AbstractTask<Void> basic = new MyTask<>();
		Thread t = new Thread(basic);
		t.start();
		assertNotEquals(t.getId(), Thread.currentThread().getId());
	}

	private class MyTask<T> extends AbstractTask<Void> {

		private MyTask() {
			super();
		}

		private MyTask(boolean flag) {
			super(flag);
		}

		private MyTask(String name) {
			super(name);
		}

		private MyTask(boolean flag, String name) {
			super(flag, name);
		}

		@Override
		protected void execute() {
			System.out.println("Basic Task has executed!");
		}
	}

	private class TestAppender extends AppenderSkeleton {
		private final List<LoggingEvent> log = new ArrayList<>();

		@Override
		public void close() {
			/* intentionally empty */}

		@Override
		public boolean requiresLayout() {
			return false;
		}

		@Override
		protected void append(LoggingEvent event) {
			log.add(event);
		}

		public List<LoggingEvent> getList() {
			return new ArrayList<>(log);
		}

	}

}
