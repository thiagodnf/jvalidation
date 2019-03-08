package org.jvalidation.matcher.number;

import org.jvalidation.matcher.Matcher;

public class IntegerMatcher extends Matcher{

	protected int target;
	
	public IntegerMatcher(int target) {
		this.target = target;
	}
	
	public IntegerMatcher equalTo(int value) {
		
		if (target == value) {
			return this;
		}
		
		throw getException("The value '" + target + "' should be equal to '" + value + "'");
	}

	public IntegerMatcher greaterThan(int min) {
		
		if (target > min) {
			return this;
		}
		
		throw getException("The value '" + target + "' should be greater than '" + min + "'");
	}
	
	public IntegerMatcher greaterThanOrEqualTo(int min) {
		
		if (target >= min) {
			return this;
		}
		
		throw getException("The value '" + target + "' should be greater than or equal to '" + min + "'");
	}
	
	public IntegerMatcher lessThan(int max) {
		
		if (target < max) {
			return this;
		}
		
		throw getException("The value '" + target + "' should be less than '" + max + "'");
	}
	
	public IntegerMatcher lessThanOrEqualTo(int max) {
		
		if (target <= max) {
			return this;
		}
		
		throw getException("The value '" + target + "' should be less than or equal to '" + max + "'");
	}
	
	public IntegerMatcher between(int min, int max) {
		
		if (target >= min && target <= max) {
			return this;
		}
		
		throw getException("The value '" + target + "' should be between " + min + " and " + max);
	}
	
	public IntegerMatcher even() {
		
		if (target >= 0 && target % 2 == 0) {
			return this;
		}
		
		throw getException("The value '" + target + "' should be even");
	}

	public IntegerMatcher odd() {
		
		if (target >= 0 && target % 2 != 0) {
			return this;
		}
		
		throw getException("The value '" + target + "' should be odd");
	}
	
	public IntegerMatcher positive() {
		
		if (target >= 0) {
			return this;
		}
		
		throw getException("The value '" + target + "' should be positive");
	}
	
	public IntegerMatcher negative() {
		
		if (target < 0) {
			return this;
		}
		
		throw getException("The value '" + target + "' should be negative");
	}
}
