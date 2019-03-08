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

		throw getException("The variable should be null");
	}

	public ObjectMatcher notNullValue() {

		if (target != null) {
			return this;
		}

		throw getException("The variable should not be null");
	}

	public ObjectMatcher instanceOf(Class<?> cls) {

		if (cls.isInstance(target)) {
			return this;
		}

		throw getException("The variable should be instance of " + cls);
	}
	
	public ObjectMatcher notInstanceOf(Class<?> cls) {

		if (!cls.isInstance(target)) {
			return this;
		}

		throw getException("The variable should not be instance of " + cls);
	}
}
