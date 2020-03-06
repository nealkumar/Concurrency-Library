package org.jbrew.concurrent;

import java.util.Comparator;

public class TaskComparator implements Comparator<Task<?>>{

	@Override
	public int compare(Task<?> o1, Task<?> o2) {
		if(o1.getPriority() == o2.getPriority()) return 0;
		return (o1.getPriority() < o2.getPriority()) ? 1 : -1;
	}

}
