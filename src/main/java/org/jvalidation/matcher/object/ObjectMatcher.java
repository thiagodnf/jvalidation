package org.jvalidation.matcher.object;

import org.jvalidation.matcher.Matcher;

public class ObjectMatcher<T> extends Matcher{

	protected T target;

	public ObjectMatcher(T target) {
		this.target = target;
	}

	public ObjectMatcher<T> nullValue() {

		if (target == null) {
			return this;
		}

		throw getException("Expected null value");
	}

	public ObjectMatcher<T> notNull() {

		if (target != null) {
			return this;
		}

		throw getException("Expected not null value");
	}

	public ObjectMatcher<T> instanceOf(Class<?> cls) {

		if (cls.isInstance(target)) {
			return this;
		}

		throw getException("Expected an instance of %s but it was %s", cls.getClass().getSimpleName(), target.getClass().getSimpleName());
	}
	
	public ObjectMatcher<T> notInstanceOf(Class<?> cls) {

		if (!cls.isInstance(target)) {
			return this;
		}

		throw getException("Expected not an instance of %s but it was %s", cls.getClass().getSimpleName(), target.getClass().getSimpleName());
	}
}
