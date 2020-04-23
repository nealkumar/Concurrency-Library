package org.jbrew.cbrew.espresso;

import org.jbrew.core.annotations.UnderDevelopmentInvestigation;

public class SumOperation extends EspressoOperation {

	private final static int DEFAULT_NUM_THREADS = 5;

	static {
		System.loadLibrary("agg_summer");
	}

	private native int sumSequential(int size, int[] arr);

	private native int sumParallel(int size, int[] arr, int numThreads);

	@Override
	protected int performSequential(int[] arr) {
		return sumSequential(arr.length, arr);
	}

	@UnderDevelopmentInvestigation
	@Override
	protected int performParallel(int[] arr, int numThreads) {
		// TODO - Add parallel implementation
		// TODO - Change native method to accept numThreads argument.
		return sumSequential(arr.length, arr);
	}

}
