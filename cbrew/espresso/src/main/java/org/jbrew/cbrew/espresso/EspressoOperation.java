package org.jbrew.cbrew.espresso;

public interface EspressoOperation {
	
	/**
	 * Performs the appropriate action on the given <code>int</code>array, using the default number of parallel threads.
	 * @param arr - the integer array upon which the operation will occur. All threads use the native 
	 * <code>p_thread</code> library.
	 * @return an <code>int</code> with the results of the operation.
	 */
	public int performOperation(int[] arr);
	
	/**
	 * Performs the appropriate action on the given <code>int</code> array, with a <code>boolean</code> flag
	 * to specify parallel versus synchronous execution.All threads use the native 
	 * <code>p_thread</code> library.
	 * @param arr
	 * @param parallel
	 * @return
	 */
	public abstract int performOperation(int[] arr, boolean parallel);
	
	/**
	 * Performs the appropriate action on the given <code>int</code> array, with a <code>int</code> flag to
	 * specify the number of parallel threads to spawn for the given operation. All threads use the native 
	 * <code>p_thread</code> library.
	 * @param numThreads
	 * @param arr
	 * @return
	 */
	public abstract int performOperation(int numThreads, int[] arr);
	
}
