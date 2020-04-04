package org.jbrew.cbrew;

import org.apache.log4j.Logger;

/**
 * A demonstration class which simply prints a char** to the console.
 * @author Neal Kumar
 *
 */
public class SayHi {
	static {
		//System.loadLibrary("SayHi");
	}
	
	public void sayHiJava() {
		Logger.getLogger(getClass()).info("Hello console! Called from Java!");
	}

}
