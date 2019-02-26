package org.jvalidation.matcher.string;

import org.jvalidation.matcher.Matcher;
import org.jvalidation.matcher.object.NullValue;

public class Blank implements Matcher<String> {

	@Override
	public String getMessage() {
		return "The string is %s blank";
	}

	@Override
	public boolean execute(String target) {
		return new NullValue().execute(target) || new Empty().execute(target);
	}
}
