package org.jbrew.cbrew.validator;

public abstract class CBrewValidatorException extends Exception{
	
	private static final long serialVersionUID = 7344169460095847830L;
	
	private CBrewValidatorException() {};

	public CBrewValidatorException(Throwable error) {
		
		super("CBrew validator verification faulure :: " +
				new DefaultCBrewValidatorException().getCBrewExceptionMessage() +
				". Please check to make sure you have installed your 'bin' correctly.\n"
				+ "Ensure that you have run 'install.sh' or install-freebsd.sh'.\n"
				+ "Check documentation at: https://github.com/nealkumar/JBrew/",
				error, true, true);
	}
	
	protected abstract String getCBrewExceptionMessage();
	
	private static class DefaultCBrewValidatorException extends CBrewValidatorException{

		private static final long serialVersionUID = 4594893968113264200L;

		@Override
		protected String getCBrewExceptionMessage() {
			return "**DEFAULT**";
		}
	}

}
