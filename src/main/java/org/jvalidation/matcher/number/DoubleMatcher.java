package org.jvalidation.matcher.number;

import org.jvalidation.matcher.Matcher;

public class DoubleMatcher extends Matcher{

	protected double target;
	
	public DoubleMatcher(double target) {
		this.target = target;
	}
	
	public void equalTo(double value) {
		if (validate(target == value)) {
			throw getException("The value '" + target + "' should %s be equal to '" + value + "'");
		}
	}

	public void greaterThan(double min) {
		if (validate(target > min)) {
			throw getException("The value '" + target + "' should %s be greater than '" + min + "'");
		}
	}
	
	public void greaterThanOrEqualTo(double min) {
		if (validate(target >= min)) {
			throw getException("The value '" + target + "' should %s be greater than or equal to '" + min + "'");
		}
	}
	
	public void lessThan(double max) {
		if (validate(target < max)) {
			throw getException("The value '" + target + "' should %s be less than '" + max + "'");
		}
	}
	
	public void lessThanOrEqualTo(double max) {
		if (validate(target <= max)) {
			throw getException("The value '" + target + "' should %s be less than or equal to '" + max + "'");
		}
	}
	
	public void between(double min, double max) {
		if (validate(target >= min && target <= max)) {
			throw getException("The value '" + target + "' should %s be between " + min + " and " + max);
		}
	}
	
	public void positive() {
		if (validate(target >= 0)) {
			throw getException("The value '" + target + "' should %s be positive");
		}
	}
	
	public void negative() {
		if (validate(target < 0)) {
			throw getException("The value '" + target + "' should %s be negative");
		}
	}
	
	public DoubleMatcher not() {
		this.isNot = true;
		return this;
	}
}
