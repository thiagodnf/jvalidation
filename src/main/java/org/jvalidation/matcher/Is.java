package org.jvalidation.matcher;

public class Is<T> implements Matcher<T>{

	private Matcher<T> matcher;
	
	public Is(Matcher<T> matcher) {
		this.matcher = matcher;
	}

	@Override
	public boolean execute(T target) {
		return matcher.execute(target);
	}
	
	@Override
	public String getMessage() {
		return matcher.getMessage().replace("%s", "");
	}
}
