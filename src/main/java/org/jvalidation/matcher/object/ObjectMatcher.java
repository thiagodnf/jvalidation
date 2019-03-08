package org.jvalidation.matcher.object;

import org.jvalidation.matcher.Matcher;

public class ObjectMatcher extends Matcher{

	protected Object target;

	public ObjectMatcher(Object target) {
		this.target = target;
	}

	public ObjectMatcher nullValue() {

		if (target == null) {
			return this;
		}

		throw getException("Expected null value");
	}

	public ObjectMatcher notNullValue() {

		if (target != null) {
			return this;
		}

		throw getException("Expected not null value");
	}

	public ObjectMatcher instanceOf(Class<?> cls) {

		if (cls.isInstance(target)) {
			return this;
		}

		throw getException("Expected an instance of %s but it was %s", cls.getClass().getSimpleName(), target.getClass().getSimpleName());
	}
	
	public ObjectMatcher notInstanceOf(Class<?> cls) {

		if (!cls.isInstance(target)) {
			return this;
		}

		throw getException("Expected not an instance of %s but it was %s", cls.getClass().getSimpleName(), target.getClass().getSimpleName());
	}
}
