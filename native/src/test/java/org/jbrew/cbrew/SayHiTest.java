package org.jbrew.cbrew;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
import org.jbrew.jni.SayHi;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

public class SayHiTest {
	
	private final SayHi hi = new SayHi();
	private final Logger logger = Logger.getRootLogger();
	private final TestAppender appender = new TestAppender();
	
	@Before
	public void setup() {
		logger.addAppender(appender);
	}
	
	@Test
	public void sayHiJavaTest() {
		hi.sayHiJava();
		logger.removeAllAppenders();
		final List<LoggingEvent> log = appender.getList();
		final LoggingEvent headLog = log.get(0);
		assertTrue(headLog.getMessage().toString().toLowerCase().contains("called from java"));
	}
	
	private class TestAppender extends AppenderSkeleton{
		
		private final List<LoggingEvent> log = new ArrayList<>(); 
		
		@Override
		public void close() {
			/* intentionally empty */
		}

		@Override
		public boolean requiresLayout() {
			return false;
		}

		@Override
		protected void append(LoggingEvent event) {
			log.add(event);
		}
		
		public List<LoggingEvent> getList(){
			return new ArrayList<>(log);
		}
		
	}

}
