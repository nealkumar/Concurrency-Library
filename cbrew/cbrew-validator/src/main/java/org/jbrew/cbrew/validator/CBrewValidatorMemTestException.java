package org.jbrew.cbrew.validator;

public class CBrewValidatorMemTestException extends CBrewValidatorException{

	private static final long serialVersionUID = -3263220235309567872L;
	
	public CBrewValidatorMemTestException() {
		super();
	}
	
	public CBrewValidatorMemTestException(String message) {
		super(message);
	}

	public CBrewValidatorMemTestException(Throwable error) {
		super(error);
	}

	@Override
	protected String getCBrewExceptionMessage() {
		return "Memory Test :: Unable to successfully allocate and/or free dynamic heap memory.";
	}

}
