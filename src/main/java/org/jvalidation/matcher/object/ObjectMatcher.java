package org.jvalidation.matcher.object;

public class ObjectMatcher {

	protected Object target;

	public ObjectMatcher(Object target) {
		this.target = target;
	}

	public void nullValue() {

		if (!(target == null)) {
			throw new IllegalArgumentException("The object is not null");
		}
	}
	
	public void notNullValue() {

		if (!(target != null)) {
			throw new IllegalArgumentException("The object is null");
		}
	}
}
