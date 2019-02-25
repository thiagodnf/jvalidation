package org.jvalidation;

import org.jvalidation.matcher.Matcher;

public class Assertive {
	
	private Assertive() throws InstantiationException {
		throw new InstantiationException("Instances of this type are forbidden");
	}

	public static <T extends Object> T require(T target, Matcher<T> matcher) {

		if (matcher == null) {
			throw new NullPointerException("The matcher should not be null");
		}

		if (!matcher.execute(target)) {
			matcher.throwException();
		}

		return target;
	}
}
