package org.jbrew.cbrew.validator;

/**
 * A demonstration class which simply prints a char* to the console.
 * @author Neal Kumar
 *
 */
public class SayHiCBrew {
	static {
		System.loadLibrary("hi_c");
	}
	
	public void sayHiJava() {
		System.out.println("Hello console! Called from Java!");
	}
	
	public native void sayHi();

}
