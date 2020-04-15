package org.jbrew.cbrew.espresso;

public interface EspressoOperation {
	
	/**
	 * Performs the appropriate action on the given array, uses the default number of parallel threads.
	 * @param arr - the integer array upon which the operation will occur.
	 * @return an <code>int</code> with the results of the operation.
	 */
	public int performOperation(int[] arr);
	
	public abstract int performOperation(int[] arr, boolean parallel);
	
	public abstract int performOperation(int numThreads, int[] arr);
	
}
