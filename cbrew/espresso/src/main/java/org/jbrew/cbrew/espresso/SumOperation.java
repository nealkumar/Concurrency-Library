package org.jbrew.cbrew.espresso;

public class SumOperation implements EspressoOperation{
	
	private final static int DEFAULT_NUM_THREADS = 5;
	
	static {
		System.loadLibrary("agg_summer");
	}
	
	private native int sumSequential(int size, int[] arr);
	private native int sumParallel(int size, int[] arr, int numThreads);

	@Override
	public int performOperation(int[] arr) {
		//return new NativeAdapter().sumParallel(arr.length, arr, DEFAULT_NUM_THREADS);
		//return new NativeAdapter().sumSequential(arr.length, arr);
		return sumSequential(arr.length, arr);
	}

	@Override
	public int performOperation(int[] arr, boolean parallel) {
		return sumSequential(arr.length, arr);
	}

	@Override
	public int performOperation(int numThreads, int[] arr) {
		return sumSequential(arr.length, arr);
	}

}
