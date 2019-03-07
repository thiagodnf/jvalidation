package org.jvalidation.matcher;

public abstract class Matcher {

	protected boolean isNot = false;

	protected void throwException(String message) {

		if (isNot) {
			message = message.replace("%s", "not");
		} else {
			message = message.replace("%s", "");
		}

		throw new IllegalArgumentException(message);
	}
	
	protected boolean validate(boolean exp) {
		return isNot ? exp : !exp;
	}
	
	public Matcher not() {
		this.isNot = true;
		return this;
	}
}
