package org.jvalidation.matcher.list;

import java.util.List;

import org.jvalidation.matcher.Matcher;

public class Size implements Matcher<List<?>> {
	
	protected int size;

	public Size(int size) {
		this.size = size;
	}
	
	@Override
	public void throwException() {
		throw new IllegalArgumentException("The list is empty");
	}

	@Override
	public boolean execute(List<?> target) {
		
		if (target == null) {
			throw new NullPointerException("The target should not be null");
		}
		
		return target.size() == size;
	}
}
