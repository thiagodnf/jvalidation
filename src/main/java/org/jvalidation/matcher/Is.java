package org.jvalidation.matcher;

public class Is<T> implements Matcher<T>{

	private Matcher<T> matcher;
	
	public Is(Matcher<T> matcher) {
		this.matcher = matcher;
	}

	@Override
	public boolean execute(T o) {
		return matcher.execute(o);
	}

	@Override
	public void throwException() {
		matcher.throwException();
	}
}
