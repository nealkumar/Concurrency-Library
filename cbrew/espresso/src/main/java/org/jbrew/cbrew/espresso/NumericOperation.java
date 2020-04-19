package org.jbrew.cbrew.espresso;

public abstract class NumericOperation<T extends Number> {
	
	/**
	 * Performs the appropriate action on the given array of type <code>T</code>.
	 * @param arr - the <code>T</code> array upon which the operation will occur.
	 * @return a <code>T</code> with the results of the operation.
	 */
	public abstract T performOperation(T[] arr);
	
	/**
	 * The variable argument implementation of {@link #performOperation(Number[])}.
	 * 
	 * @param arr - a <code>T</code> array, set of <code>T</code> arrays,
	 *            integers, or a heterogeneous mix of any of the following, provided
	 *            that they are of type <code>T</code>.
	 * @return an <code>T</code> with the results of the operation.
	 */
	//@SuppressWarnings("unchecked")
	//public abstract T performOperation(T[]... arr);
	
	//protected abstract void performSequential();
	
	//protected abstract int performParallel(int[] arr, int numThreads);

}
