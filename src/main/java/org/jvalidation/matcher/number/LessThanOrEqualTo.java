package org.jvalidation.matcher.number;

public class LessThanOrEqualTo extends LessThan {
	
	public LessThanOrEqualTo(Number value) {
		super(value);
	}

	@Override
	public void throwException() {
		throw new IllegalArgumentException("The value should be less than or equal to " + value);
	}
	
	@Override
	protected boolean compare(int a, int b) {
		return a <= b;
	}

	@Override
	protected boolean compare(double a, double b) {
		return a <= b;
	}

	@Override
	protected boolean compare(long a, long b) {
		return a <= b;
	}
}
