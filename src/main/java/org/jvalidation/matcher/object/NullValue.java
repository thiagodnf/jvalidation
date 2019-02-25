package org.jvalidation.matcher.object;

import org.jvalidation.matcher.Matcher;

public class NullValue implements Matcher<Object> {

	@Override
	public boolean execute(Object o) {
		return o == null;
	}
	
	@Override
	public void throwException() {
		throw new NullPointerException();
	}
}
