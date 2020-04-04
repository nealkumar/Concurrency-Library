package org.jbrew.concurrent;

import java.util.Comparator;

/**
 * A <code>TaskComparator</code> class performs priority-sensitive {@link org.jbrew.concurrent.Task} comparison. 
 * @author Neal Kumar
 *
 */
public class TaskComparator implements Comparator<Task<?>>{

	@Override
	public int compare(Task<?> o1, Task<?> o2) {
		if(o1.getPriority() == o2.getPriority()) return 0;
		return o1.getPriority() < o2.getPriority() ? 1 : -1;
	}

}
