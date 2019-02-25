package org.jvalidation.matcher.string;

import org.jvalidation.matcher.Matcher;

public class Empty implements Matcher<String> {
	
	@Override
	public void throwException() {
		throw new IllegalArgumentException("The string is empty");
	}

	@Override
	public boolean execute(String target) {
		
		if (target == null) {
			throw new NullPointerException("The target should not be null");
		}
		
		return target.trim().isEmpty();
	}
}
