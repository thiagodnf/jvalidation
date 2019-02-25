package org.jvalidation.matcher.number;

public class LessThan extends ComparisonNumber {
	
	public LessThan(Number value) {
		super(value);
	}

	@Override
	public void throwException() {
		throw new IllegalArgumentException("The value should be less than " + value);
	}

	@Override
	protected boolean compare(int a, int b) {
		return a < b;
	}

	@Override
	protected boolean compare(double a, double b) {
		return a < b;
	}

	@Override
	protected boolean compare(long a, long b) {
		return a < b;
	}
}
