package org.jvalidation.matcher;

public abstract class Matcher {

	protected boolean isNot = false;

	protected IllegalArgumentException getException(String message) {

		if (isNot) {
			message = message.replace("%s", "not");
		} else {
			message = message.replace("%s", "");
		}

		return new IllegalArgumentException(message);
	}
	
	protected boolean validate(boolean exp) {
		return isNot ? exp : !exp;
	}
}
