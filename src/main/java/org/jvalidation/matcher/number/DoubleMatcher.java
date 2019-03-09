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
		
		throw getException("Expected a value equal to %s but it was %s", value, target);
	}

	public DoubleMatcher greaterThan(double min) {
		
		if (target > min) {
			return this;
		}
		
		throw getException("Expected a value greater than to %s but it was %s", min, target);
	}
	
	public DoubleMatcher greaterThanOrEqualTo(double min) {
		
		if (target >= min) {
			return this;
		}
		
		throw getException("Expected a value greater than or equal to %s but it was %s", min, target);
	}
	
	public DoubleMatcher lessThan(double max) {
		
		if (target < max) {
			return this;
		}
		
		throw getException("Expected a value less than %s but it was %s", max, target);
	}
	
	public DoubleMatcher lessThanOrEqualTo(double max) {
		
		if (target <= max) {
			return this;
		}
		
		throw getException("Expected a value less than or equal to %s but it was %s", max, target);
	}
	
	public DoubleMatcher between(double min, double max) {
		
		if (target >= min && target <= max) {
			return this;
		}
		
		throw getException("Expected a value between %s and %s but it was %s", min, max, target);
	}
	
	public DoubleMatcher positive() {
		
		if (target >= 0) {
			return this;
		}
		
		throw getException("Expected a positive value but it was %s", target);
	}
	
	public DoubleMatcher negative() {
		
		if (target < 0) {
			return this;
		}
		
		throw getException("Expected a negative value but it was %s", target);
	}
	
	public DoubleMatcher closeTo(double other, double delta) {

		double distance = Math.abs(target - other);

		if (distance <= delta) {
			return this;
		}

		throw getException("Expected to be closed to %s with delta %s but it was %s", other, delta, target);
	}
	
	public DoubleMatcher infinite() {
		
		if (Double.isInfinite(target)) {
			return this;
		}
		
		throw getException("Expected a infinite value but it was %s", target);
	}
	
	public DoubleMatcher notInfinite() {
		
		if (!Double.isInfinite(target)) {
			return this;
		}
		
		throw getException("Expected a non infinite value but it was %s", target);
	}
}
