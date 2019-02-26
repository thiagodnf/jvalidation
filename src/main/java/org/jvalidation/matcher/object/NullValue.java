package org.jvalidation.matcher.object;

import org.jvalidation.matcher.Matcher;

public class NullValue implements Matcher<Object> {

	@Override
	public boolean execute(Object o) {
		return o == null;
	}
	
	@Override
	public String getMessage() {
		return "The value is null";
	}
}
