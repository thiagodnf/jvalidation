package org.jvalidation.matcher.number;

import org.jvalidation.matcher.Matcher;

public class DoubleMatcher extends Matcher{

	protected double target;
	
	public DoubleMatcher(double target) {
		this.target = target;
	}
	
	public DoubleMatcher equalTo(double value) {
		
		if (target == value) {
			return this;
		}
		
		throw getException("The value '" + target + "' should be equal to '" + value + "'");
	}

	public DoubleMatcher greaterThan(double min) {
		
		if (target > min) {
			return this;
		}
		
		throw getException("The value '" + target + "' should be greater than '" + min + "'");
	}
	
	public DoubleMatcher greaterThanOrEqualTo(double min) {
		
		if (target >= min) {
			return this;
		}
		
		throw getException("The value '" + target + "' should be greater than or equal to '" + min + "'");
	}
	
	public DoubleMatcher lessThan(double max) {
		
		if (target < max) {
			return this;
		}
		
		throw getException("The value '" + target + "' should be less than '" + max + "'");
	}
	
	public DoubleMatcher lessThanOrEqualTo(double max) {
		
		if (target <= max) {
			return this;
		}
		
		throw getException("The value '" + target + "' should be less than or equal to '" + max + "'");
	}
	
	public DoubleMatcher between(double min, double max) {
		
		if (target >= min && target <= max) {
			return this;
		}
		
		throw getException("The value '" + target + "' should be between " + min + " and " + max);
	}
	
	public DoubleMatcher positive() {
		
		if (target >= 0) {
			return this;
		}
		
		throw getException("The value '" + target + "' should be positive");
	}
	
	public DoubleMatcher negative() {
		
		if (target < 0) {
			return this;
		}
		
		throw getException("The value '" + target + "' should be negative");
	}
}
