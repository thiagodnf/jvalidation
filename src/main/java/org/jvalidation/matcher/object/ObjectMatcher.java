package org.jvalidation.matcher.object;

import org.jvalidation.matcher.Matcher;

public class ObjectMatcher extends Matcher{

	protected Object target;

	public ObjectMatcher(Object target) {
		this.target = target;
	}

	public void nullValue() {
		if (validate(target == null)) {
			throw getException("The object should %s be null");
		}
	}
	
	public ObjectMatcher not() {
		this.isNot = true;
		return this;
	}
}
