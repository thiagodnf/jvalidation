package org.jvalidation.matcher.number;

public class DoubleMatcher {

	protected double target;

	public DoubleMatcher(double target) {
		this.target = target;
	}

	public void greaterThan(double min) {
		if (!(target > min)) {
			throw new IllegalArgumentException("The value '" + target + "' should be greater than '" + min + "'");
		}
	}
	
	public void greaterThanOrEqualTo(double min) {
		if (!(target >= min)) {
			throw new IllegalArgumentException("The value '" + target + "' should be greater than or equal to '" + min + "'");
		}
	}
	
	public void lessThan(double max) {
		if (!(target < max)) {
			throw new IllegalArgumentException("The value '" + target + "' should be less than '" + max + "'");
		}
	}
	
	public void lessThanOrEqualTo(double max) {
		if (!(target <= max)) {
			throw new IllegalArgumentException("The value '" + target + "' should be less than or equal to '" + max + "'");
		}
	}
	
	public void between(double min, double max) {
		greaterThanOrEqualTo(min);
		lessThanOrEqualTo(max);
	}
}
