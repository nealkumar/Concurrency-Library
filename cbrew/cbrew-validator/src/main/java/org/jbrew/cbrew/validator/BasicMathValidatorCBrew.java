package org.jbrew.cbrew.validator;

public class BasicMathValidatorCBrew {
	
	static {
		System.loadLibrary("basicmath_c");
	}
	
	public native int addNative(int num1, int num2);
	public native int subNative(int num1, int num2);
	public native int multNative(int num1, int num2);
	
	/**
	 * Adds the integers together and returns the result.
	 * @param num1 - the first integer to be summed
	 * @param num2 - the second integer to be summed
	 * @return - the sum of the parameters.
	 */
	public int addCBrew(int num1, int num2) {
		return this.addNative(num1, num2);
	}
	
	/**
	 * Subtracts the integers together and returns the result.
	 * @param num1 - the first integer to be subtracted
	 * @param num2 - the second integer to be subtract
	 * @return - the subtraction result of the parameters.
	 */
	public int subtractCBrew(int num1, int num2) {
		return this.subNative(num1, num2);
	}
	
	/**
	 * Multiplies the integers together and returns the result.
	 * @param num1 - the first integer to be multiplied
	 * @param num2 - the second integer to be multiplied
	 * @return - the multiplication result of the parameters.
	 */
	public int multiplyCBrew(int num1, int num2) {
		return this.multNative(num1, num2);
	}

}
