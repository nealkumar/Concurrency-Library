package org.jbrew.jni.verifier;

public class DoMath {
	
	static {
		System.loadLibrary("adder");
	}
	
	public native int addNative(int num1, int num2);
	
	public int add(int num1, int num2) {
		return this.addNative(num1, num2);
	}

}
