package org.jvalidation.matcher.number;

import org.jvalidation.matcher.Matcher;

public abstract class ComparisonNumber implements Matcher<Number> {

	protected Number value;
	
	public ComparisonNumber(Number value) {
		this.value = value;
	}
	
	@Override
	public boolean execute(Number o) {

		if (value instanceof Integer) {
			return compare(o.intValue(), value.intValue());
		} else if (value instanceof Double) {
			return compare(o.doubleValue(), value.doubleValue());
		} 

		return compare(o.longValue(), value.longValue());
	}
	
	protected abstract boolean compare(int a, int b);
	
	protected abstract boolean compare(double a, double b);
	
	protected abstract boolean compare(long a, long b);
}
