package org.jbrew.jni.validator;

/**
 * A demonstration class which simply prints a char* to the console.
 * @author Neal Kumar
 *
 */
public class SayHi {
	static {
		//System.loadLibrary("hi_c");
	}
	
	private native void sayHi();
	
	public void sayHiC() {
		new org.jbrew.cbrew.validator.SayHiCBrew().sayHi();
	}
	
	public void sayHiJava() {
		//System.out.println("Hello console! Called from Java!");
		new org.jbrew.cbrew.validator.SayHiCBrew().sayHi();
	}
	
	

}
