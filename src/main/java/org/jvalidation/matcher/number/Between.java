package org.jvalidation.matcher.number;

import org.jvalidation.matcher.Matcher;

public class Between implements Matcher<Number> {
	
	protected Number start;
	
	protected Number end;
	
	public Between(Number start, Number end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public void throwException() {
		throw new IllegalArgumentException("The value should be between " + start);
	}

	@Override
	public boolean execute(Number o) {
		return new GreaterThanOrEqualTo(start).execute(o) && new LessThanOrEqualTo(end).execute(o);
	}

}
