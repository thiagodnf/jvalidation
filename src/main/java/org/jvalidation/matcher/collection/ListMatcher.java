package org.jvalidation.matcher.collection;

import java.util.List;

import org.jvalidation.matcher.object.ObjectMatcher;

public class ListMatcher extends ObjectMatcher<List<?>> {

	public ListMatcher(List<?> target) {
		super(target);
	}
	
	@Override
	public ListMatcher notNull() {
		return (ListMatcher) super.notNull();
	}
	
	@Override
	public ListMatcher nullValue() {
		return (ListMatcher) super.nullValue();
	}
	
	/**
	 * Verify if the examined list is empty. Otherwise, an exception is thrown
	 * 
	 * @return the same instance for attaching another rule if desired
	 */
	public ListMatcher empty() {

		notNull();
		
		if (target.isEmpty()) {
			return this;
		}

		throw getException("Expected an empty list but it was %s", target);
	}
	
	public ListMatcher notEmpty() {
		
		notNull();
		
		if (!target.isEmpty()) {
			return this;
		}

		throw getException("Expected a non empty list but it was %s", target);
	}
	
	public ListMatcher size(int size) {
		
		notNull();
		
		if (target.size() == size) {
			return this;
		}

		throw getException("Expected a list with size %s but it was %s", target.size(), size);
	}
	
	public ListMatcher maxSize(int maxSize) {

		notNull();

		if (target.size() <= maxSize) {
			return this;
		}

		throw getException("Expected a list with max size %s but it was %s", target.size(), maxSize);
	}

	public ListMatcher minSize(int minSize) {

		notNull();

		if (target.size() >= minSize) {
			return this;
		}

		throw getException("Expected a list with min size %s but it was %s", target.size(), minSize);
	}
	
	public ListMatcher contains(Object o) {

		notNull();

		if (target.contains(o)) {
			return this;
		}

		throw getException("Expected the list contains %s but it was not found", o);
	}
}
