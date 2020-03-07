package org.jbrew.concurrent.standard;

import org.jbrew.concurrent.BasicTask;

/**
 * This is a standard implementation of the BasicTask.
 * @author Neal Kumar
 *
 */
public class StandardNonRetrievableTask extends BasicTask{

	@Override
	protected void execute() {
		throw new UnsupportedOperationException();
	}

}
