package org.jbrew.concurrent;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;
import java.util.concurrent.PriorityBlockingQueue;

public class TaskRegister implements TaskRegistry {

	private java.util.Queue<Task<?>> taskQueue;
	private static final int INITIAL_QUEUE_CAPACITY = 11;

	public TaskRegister() {
		this.taskQueue = new PriorityBlockingQueue<>(INITIAL_QUEUE_CAPACITY, new TaskComparator());
	}

	@Override
	public void offer(Task<?> task) {
		if (task == null) return;
		this.taskQueue.offer(task);
	}

	/**
	 * {@inheritDoc}
	 * <br><br>
	 * This implementation also prevents a un-intialized {@link org.jbrew.concurrent.Task} from 
	 * entering the <code>TaskRegistry</code>. The reason for this inclusion is to prevent a null {@link org.jbrew.concurrent.Task}
	 * from consuming computing resources, including worker threads and memory. Note that this scan and check
	 * may spawn 0 or more worker threads to achieve efficient, high-performance checking. As a result of this scan,
	 * one can expect an asymptotic runtime upper bounding (worse-case performance) of O(n), where <i>n</i>
	 * is the number of elements present in this method's parameter{s). For the O(1) implementation of this method, please 
	 * refer to {@link TaskRegister#offer(Task)}.
	 */
	@Override
	@SafeVarargs
	public final void offer(Task<?>... tasks) {
		if (tasks == null) return;
		tasks = nullScan(tasks);
		Collections.addAll(this.taskQueue, tasks);
	}
	
	private Task<?>[] nullScan(Task<?>... tasks) {
		LinkedList<Task<?>> notNull = new LinkedList<>();	// LinkedList chosen to ensure that no "extra" array slots are allocated and cleaned during GC.
		Arrays.asList(tasks).parallelStream()
							.filter(Objects::nonNull)
							.forEach(notNull::offer);
		return notNull.toArray(new Task<?>[notNull.size()]);
	}

	@Override
	public boolean remove(Task<?> task) {
		return this.taskQueue.remove(task);
	}

	@Override
	public Task<?> pollTask() {
		return this.taskQueue.poll();
	}

	
	/**
	 * interuptAll() implementation is the subject of (#79), and as such MAY be
	 * addressed prior to release of v0.1.0.
	 */
	@Override
	public void interruptAll() {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Returns the size of the <code>TaskRegistry</code>, represented as a signed 8, 16, or 32 bit integer. The
	 * value will be an 8-bit integer for sizes of less than and including 255. For values greater than 255
	 * but less than 32,767 this will be 16 bits. Finally, for values greater than 32,767 up to the maximum integer
	 * , the value will contain 32 bits.
	 */
	@Override
	public int getRegistrySize() {
		return this.taskQueue.size();
	}

}