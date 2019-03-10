package org.jvalidation.matcher.string;

import java.util.regex.Pattern;

import org.jvalidation.matcher.object.ObjectMatcher;

public class StringMatcher extends ObjectMatcher<String>{

	public StringMatcher(String target) {
		super(target);
	}

	public StringMatcher empty() {

		notNull();
		
		if (target.isEmpty()) {
			return this;
		}

		throw getException("Expected an empty string but it was %s", target);
	}
	
	public StringMatcher notEmpty() {
		
		notNull();
		
		if (!target.isEmpty()) {
			return this;
		}

		throw getException("Expected a non empty string but it was %s", target);
	}
	
	public StringMatcher startsWith(String prefix) {

		notNull();
		
		if (target.startsWith(prefix)) {
			return this;
		}

		throw getException("Expected string starts with but it was %s", target);
	}

	public StringMatcher endsWith(String suffix) {

		notNull();
		
		if (target.endsWith(suffix)) {
			return this;
		}

		throw getException("Expected string ends with but it was %s", target);
	}
	
	public StringMatcher contains(String sequence) {

		notNull();
		
		if (target.contains(sequence)) {
			return this;
		}

		throw getException("Expected string ends with but it was %s", target);
	}
	
	public StringMatcher matches(Pattern pattern) {

		notNull();
		
		if (pattern.matcher(target).matches()) {
			return this;
		}

		throw getException("Expected string matches with %s but it was %s", pattern.pattern(), target);
	}
	
	public StringMatcher matches(String pattern) {
		return matches(Pattern.compile(pattern));
	}
	
	public StringMatcher minLength(int minLength) {

		notNull();
		
		if (target.length() >= minLength) {
			return this;
		}

		throw getException("Expected string with min length %s but it was %s", minLength, target.length());
	}
	
	public StringMatcher maxLength(int maxLength) {

		notNull();
		
		if (target.length() <= maxLength) {
			return this;
		}

		throw getException("Expected string with max length %s but it was %s", maxLength, target.length());
	}
	
	public StringMatcher length(int length) {

		notNull();
		
		if (target.length() == length) {
			return this;
		}

		throw getException("Expected string with length %s but it was %s", length, target.length());
	}
	
	public StringMatcher email() {

		notNull();

		Pattern pattern = Pattern.compile("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");

		if (pattern.matcher(target).matches()) {
			return this;
		}

		throw getException("Expected an email but it was %s", target);
	}
	
	public StringMatcher blank() {

		if (target == null || target.isEmpty()) {
			return this;
		}

		throw getException("Expected a blank string but it was %s", target);
	}
	
	public StringMatcher notBlank() {

		if (!(target == null || target.isEmpty())) {
			return this;
		}

		throw getException("Expected a not blank string but it was %s", target);
	}
	
	@Override
	public StringMatcher notNull() {
		return (StringMatcher) super.notNull();
	}
	
	@Override
	public StringMatcher nullValue() {
		return (StringMatcher) super.nullValue();
	}
}
