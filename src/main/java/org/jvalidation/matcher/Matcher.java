package org.jvalidation.matcher;

public abstract class Matcher {

	protected IllegalArgumentException getException(String message) {
		return new IllegalArgumentException(message);
	}
	
	protected boolean validate(boolean exp) {
		return !exp;
	}
}
