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
		
		throw getException("Expected a value equal to %s but it was %s", value, target);
	}

	public IntegerMatcher greaterThan(int min) {
		
		if (target > min) {
			return this;
		}
		
		throw getException("Expected a value greater than to %s but it was %s", min, target);
	}
	
	public IntegerMatcher greaterThanOrEqualTo(int min) {
		
		if (target >= min) {
			return this;
		}
		
		throw getException("Expected a value greater than or equal to %s but it was %s", min, target);
	}
	
	public IntegerMatcher lessThan(int max) {
		
		if (target < max) {
			return this;
		}
		
		throw getException("Expected a value less than %s but it was %s", max, target);
	}
	
	public IntegerMatcher lessThanOrEqualTo(int max) {
		
		if (target <= max) {
			return this;
		}
		
		throw getException("Expected a value less than or equal to %s but it was %s", max, target);
	}
	
	public IntegerMatcher between(int min, int max) {
		
		if (target >= min && target <= max) {
			return this;
		}
		
		throw getException("Expected a value between %s and %s but it was %s", min, max, target);
	}
	
	public IntegerMatcher even() {
		
		if (target >= 0 && target % 2 == 0) {
			return this;
		}
		
		throw getException("Expected an even value but it was %s", target);
	}

	public IntegerMatcher odd() {
		
		if (target >= 0 && target % 2 != 0) {
			return this;
		}
		
		throw getException("Expected an odd value but it was %s", target);
	}
	
	public IntegerMatcher positive() {
		
		if (target >= 0) {
			return this;
		}
		
		throw getException("Expected a positive value but it was %s", target);
	}
	
	public IntegerMatcher negative() {
		
		if (target < 0) {
			return this;
		}
		
		throw getException("Expected a negative value but it was %s", target);
	}
}
