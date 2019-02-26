package org.jvalidation.matcher.list;

import java.util.List;

import org.jvalidation.matcher.Matcher;

public class EmptyList implements Matcher<List<?>> {
	
	@Override
	public String getMessage() {
		return "The list is empty";
	}

	@Override
	public boolean execute(List<?> target) {
		
		if (target == null) {
			throw new NullPointerException("The target should not be null");
		}
		
		return target.isEmpty();
	}
}
