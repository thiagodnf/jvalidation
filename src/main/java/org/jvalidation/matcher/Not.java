package org.jvalidation.matcher;

public class Not<T> implements Matcher<T>{

	private Matcher<T> matcher;
	
	public Not(Matcher<T> matcher) {
		this.matcher = matcher;
	}

	@Override
	public boolean execute(T o) {
		return !matcher.execute(o);
	}
	
	@Override
	public String getMessage() {
		return matcher.getMessage().replace("%s", "not");
	}
}
