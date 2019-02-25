package org.jvalidation.matcher.number;

public class GreaterThan extends ComparisonNumber {

	public GreaterThan(Number value) {
		super(value);
	}
	
	@Override
	protected boolean compare(int a, int b) {
		return a > b;
	}

	@Override
	protected boolean compare(double a, double b) {
		return a > b;
	}

	@Override
	protected boolean compare(long a, long b) {
		return a > b;
	}

	@Override
	public void throwException() {
		throw new IllegalArgumentException("The value should be greater than " + value);
	}	
}
