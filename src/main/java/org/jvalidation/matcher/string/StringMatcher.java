package org.jvalidation.matcher.string;

import org.jvalidation.matcher.object.ObjectMatcher;

public class StringMatcher extends ObjectMatcher{

	protected String target;

	public StringMatcher(String target) {
		super(target);
		
		this.target = target;
	}

	public StringMatcher empty() {

		notNull();
		
		if (target.isEmpty()) {
			return this;
		}

		throw getException("Expected an empty string but it was %s", target);
	}
	
	public StringMatcher startsWith(String prefix) {

		notNull();
		
		if (target.startsWith(prefix)) {
			return this;
		}

		throw getException("Expected start with but it was %s", target);
	}

	
}
