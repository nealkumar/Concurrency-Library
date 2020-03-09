package org.jbrew.concurrent;

/**
 * A {@link BoundedTaskQueue} is an unordered, unbounded implementation of a {@link org.jbrew.concurrent.TaskQueue}. 
 * This implementation is {@link org.jbrew.concurrent.ThreadSafe}, as it can safely handle multiple consumer
 * and producer threads writing and/or reading from it.
 * @author nealk
 */
@ThreadSafe
public class UnboundedTaskQueue {

}
