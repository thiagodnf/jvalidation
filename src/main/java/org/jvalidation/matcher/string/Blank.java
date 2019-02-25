package org.jvalidation.matcher.string;

import org.jvalidation.matcher.Matcher;
import org.jvalidation.matcher.object.NullValue;

public class Blank implements Matcher<String> {

	@Override
	public void throwException() {
		throw new IllegalArgumentException("The string is blank");
	}

	@Override
	public boolean execute(String target) {
		return new NullValue().execute(target) || new Empty().execute(target);
	}
}
