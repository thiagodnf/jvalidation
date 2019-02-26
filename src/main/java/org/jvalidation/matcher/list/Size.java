package org.jvalidation.matcher.list;

import java.util.List;

import org.jvalidation.matcher.Matcher;

public class Size implements Matcher<List<?>> {
	
	protected int size;

	public Size(int size) {
		this.size = size;
	}
	
	@Override
	public String getMessage() {
		return "The list is empty";
	}

	@Override
	public boolean execute(List<?> target) {
		
		if (target == null) {
			throw new NullPointerException("The target should not be null");
		}
		
		return target.size() == size;
	}
}
