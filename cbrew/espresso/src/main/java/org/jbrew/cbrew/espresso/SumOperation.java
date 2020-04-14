package org.jbrew.cbrew.espresso;

public class SumOperation implements EspressoOperation{
	
	static {
		System.load("agg_summer");
	}
	
	private native int sum(int size, int[] arr);
	
	@Override
	public int performOperation(int size, int[] arr) {
		return sum(size, arr);
	}

	@Override
	public int performOperation(int[] arr) {
		return sum(arr.length, arr);
	}

}
