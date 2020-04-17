package org.jbrew.cbrew.espresso;

import java.util.Arrays;
import java.util.stream.IntStream;

public abstract class EspressoOperation {

	public final static int DEFAULT_NUM_THREADS = 8;

	/**
	 * Performs the appropriate action on the given <code>int</code>array.
	 * 
	 * @param arr - the <code>int</code> array upon which the operation will occur.
	 * @return an <code>int</code> with the results of the operation.
	 */
	public final int performOperation(int[] arr) {
		return performSequential(arr);
	}

	/**
	 * The variable argument implementation of {@link #performOperation(int[])}.
	 * 
	 * @param arr - an <code>int</code> array, set of <code>int</code> arrays,
	 *            integers, or a heterogeneous mix of any of the following, provided
	 *            that they are of type <code>int</code>.
	 * @return an <code>int</code> with the results of the operation.
	 */
	public final int performOperation(int[]... arr) {
		IntStream aggregateIntStream = Arrays.stream(arr).flatMapToInt(num -> IntStream.of(num));
		int[] array = aggregateIntStream.toArray();
		return performSequential(array);
	}

	/**
	 * Performs the appropriate action on the given <code>int</code> array, with a
	 * <code>boolean</code> flag to specify parallel versus synchronous execution,
	 * using the default number of threads, as specified by
	 * {@link #DEFAULT_NUM_THREADS}. All threads use the native
	 * <code>p_thread</code> library.
	 * 
	 * @param arr      - the <code>int</code> array upon which the operation will
	 *                 occur.
	 * @param parallel - the <code>boolean</code> flag which explicitly specifies to
	 *                 Espresso whether parallel operations are desired.
	 * @return an <code>int</code> with the results of the operation.
	 */
	public final int performOperation(int[] arr, boolean parallel) {
		return (parallel) ? performParallel(arr, DEFAULT_NUM_THREADS) : performSequential(arr);
	}

	/**
	 * Performs the appropriate action on the given <code>int</code> array, with a
	 * <code>int</code> flag to specify the number of parallel threads to spawn for
	 * the given operation. All threads use the native <code>p_thread</code>
	 * library.
	 * 
	 * @param numThreads - the number of threads to break the operation into.
	 * @param arr        - the <code>int</code> array upon which the operation will
	 *                   occur.
	 * @return - an <code>int</code> with the results of the operation.
	 */
	public final int performOperation(int[] arr, int numThreads) {
		return performParallel(arr, numThreads);
	}

	protected abstract int performSequential(int[] arr);

	protected abstract int performParallel(int[] arr, int numThreads);

}
