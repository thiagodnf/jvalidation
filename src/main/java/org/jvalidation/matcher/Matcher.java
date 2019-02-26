package org.jvalidation.matcher;

public interface Matcher<T extends Object> {

	public boolean execute(T target);

	public String getMessage();
}
