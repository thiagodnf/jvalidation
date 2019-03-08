package org.jvalidation.matcher.number;

import org.jvalidation.matcher.Matcher;

public class IntegerMatcher extends Matcher{

	protected int target;
	
	public IntegerMatcher(int target) {
		this.target = target;
	}
	
	public IntegerMatcher equalTo(int value) {
		
		if (validate(target == value)) {
			throw getException("The value '" + target + "' should %s be equal to '" + value + "'");
		}
		
		return this;
	}

	public IntegerMatcher greaterThan(int min) {
		
		if (validate(target > min)) {
			throw getException("The value '" + target + "' should %s be greater than '" + min + "'");
		}
		
		return this;
	}
	
	public IntegerMatcher greaterThanOrEqualTo(int min) {
		
		if (validate(target >= min)) {
			throw getException("The value '" + target + "' should %s be greater than or equal to '" + min + "'");
		}
		
		return this;
	}
	
	public IntegerMatcher lessThan(int max) {
		
		if (validate(target < max)) {
			throw getException("The value '" + target + "' should %s be less than '" + max + "'");
		}
		
		return this;
	}
	
	public IntegerMatcher lessThanOrEqualTo(int max) {
		
		if (validate(target <= max)) {
			throw getException("The value '" + target + "' should %s be less than or equal to '" + max + "'");
		}
		
		return this;
	}
	
	public IntegerMatcher between(int min, int max) {
		
		if (validate(target >= min && target <= max)) {
			throw getException("The value '" + target + "' should %s be between " + min + " and " + max);
		}
		
		return this;
	}
	
	public IntegerMatcher even() {
		
		if (validate(target >= 0 && target % 2 == 0)) {
			throw getException("The value '" + target + "' should %s be even");
		}
		
		return this;
	}

	public IntegerMatcher odd() {
		
		if (validate(target >= 0 && target % 2 != 0)) {
			throw getException("The value '" + target + "' should %s be odd");
		}
		
		return this;
	}
	
	public IntegerMatcher positive() {
		
		if (validate(target >= 0)) {
			throw getException("The value '" + target + "' should %s be positive");
		}
		
		return this;
	}
	
	public IntegerMatcher negative() {
		
		if (validate(target < 0)) {
			throw getException("The value '" + target + "' should %s be negative");
		}
		
		return this;
	}
}
