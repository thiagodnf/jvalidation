package org.jvalidation.matcher.number;

import org.jvalidation.matcher.Matcher;

public class IntegerMatcher extends Matcher{

	protected int target;
	
	public IntegerMatcher(int target) {
		this.target = target;
	}
	
	public void equalTo(int value) {
		if (validate(target == value)) {
			throwException("The value '" + target + "' should be equal to '" + value + "'");
		}
	}

	public void greaterThan(int min) {
		if (validate(target > min)) {
			throwException("The value '" + target + "' should be greater than '" + min + "'");
		}
	}
	
	public void greaterThanOrEqualTo(int min) {
		if (validate(target >= min)) {
			throwException("The value '" + target + "' should be greater than or equal to '" + min + "'");
		}
	}
	
	public void lessThan(int max) {
		if (validate(target < max)) {
			throwException("The value '" + target + "' should be less than '" + max + "'");
		}
	}
	
	public void lessThanOrEqualTo(int max) {
		if (validate(target <= max)) {
			throwException("The value '" + target + "' should be less than or equal to '" + max + "'");
		}
	}
	
	public void between(int min, int max) {
		this.greaterThanOrEqualTo(min);
		this.lessThanOrEqualTo(max);
	}
	
	public void even() {
		if (validate(target % 2 == 0)) {
			throwException("The value '" + target + "' should %s be even");
		}
	}

	public void odd() {
		if (validate(target % 2 != 0)) {
			throwException("The value '" + target + "' should %s be odd");
		}
	}
	
	public void positive() {
		if (validate(target >= 0)) {
			throwException("The value '" + target + "' should %s be positive");
		}
	}
	
	public void negative() {
		if (validate(target < 0)) {
			throwException("The value '" + target + "' should %s be negative");
		}
	}
	
	public IntegerMatcher not() {
		this.isNot = true;
		return this;
	}
}
