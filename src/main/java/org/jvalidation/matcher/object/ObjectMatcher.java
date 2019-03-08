package org.jvalidation.matcher.object;

import org.jvalidation.matcher.Matcher;

public class ObjectMatcher extends Matcher{

	protected Object target;

	public ObjectMatcher(Object target) {
		this.target = target;
	}

	public ObjectMatcher nullValue() {

		if (validate(target == null)) {
			throw getException("The object should be null");
		}

		return this;
	}

	public ObjectMatcher notNullValue() {

		if (validate(target != null)) {
			throw getException("The object should not be null");
		}

		return this;
	}

	public ObjectMatcher instanceOf(Class<?> cls) {

		if (validate(cls.isInstance(target))) {
			throw getException("The object should be instance of " + cls);
		}

		return this;
	}
	
	public ObjectMatcher notInstanceOf(Class<?> cls) {

		if (validate(!cls.isInstance(target))) {
			throw getException("The object should not be instance of " + cls);
		}

		return this;
	}
}
