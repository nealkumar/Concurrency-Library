package org.jbrew.jni.examples;

/**
 * A demonstration class which simply prints a char* to the console.
 * @author Neal Kumar
 *
 */
public class SayHi {
	static {
		System.loadLibrary("hi");
	}
	
	public void sayHiJava() {
		System.out.println("Hello console! Called from Java!");
		//org.apache.log4j.Logger.getLogger(getClass()).info("Hello console! Called from Java!");
	}
	
	public native void sayHi();

}
