package org.jvalidation.matcher.number;

import org.jvalidation.matcher.Matcher;

public class DoubleMatcher extends Matcher{

	protected double target;
	
	public DoubleMatcher(double target) {
		this.target = target;
	}
	
	public DoubleMatcher equalTo(double value) {
		
		if (validate(target == value)) {
			throw getException("The value '" + target + "' should %s be equal to '" + value + "'");
		}
		
		return this;
	}

	public DoubleMatcher greaterThan(double min) {
		
		if (validate(target > min)) {
			throw getException("The value '" + target + "' should %s be greater than '" + min + "'");
		}
		
		return this;
	}
	
	public DoubleMatcher greaterThanOrEqualTo(double min) {
		
		if (validate(target >= min)) {
			throw getException("The value '" + target + "' should %s be greater than or equal to '" + min + "'");
		}
		
		return this;
	}
	
	public DoubleMatcher lessThan(double max) {
		
		if (validate(target < max)) {
			throw getException("The value '" + target + "' should %s be less than '" + max + "'");
		}
		
		return this;
	}
	
	public DoubleMatcher lessThanOrEqualTo(double max) {
		
		if (validate(target <= max)) {
			throw getException("The value '" + target + "' should %s be less than or equal to '" + max + "'");
		}
		
		return this;
	}
	
	public DoubleMatcher between(double min, double max) {
		
		if (validate(target >= min && target <= max)) {
			throw getException("The value '" + target + "' should %s be between " + min + " and " + max);
		}
		
		return this;
	}
	
	public DoubleMatcher positive() {
		
		if (validate(target >= 0)) {
			throw getException("The value '" + target + "' should %s be positive");
		}
		
		return this;
	}
	
	public DoubleMatcher negative() {
		
		if (validate(target < 0)) {
			throw getException("The value '" + target + "' should %s be negative");
		}
		
		return this;
	}
}
