package org.jbrew.concurrent;

/**
 * A TaskQueue is a set of ordered or unordered {@link org.jbrew.concurrent.Task} Tasks placed into a custom
 * queue which can be operated by producers or consumers in one or more {@link java.lang.Thread}.
 * @author nealk
 *
 * @param <T> - The type of {@link org.jbrew.concurrent.Task}. The full type parameter in the interface's signature
 * is <code>&lt;T extends {@link org.jbrew.concurrent.Task}&lt;? extends {@link java.lang.Object}&gt;&gt;</code>. 
 */
public interface TaskQueue<T extends Task<? extends Object>> {
	
	
	

}
