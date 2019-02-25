package org.jvalidation;

import java.util.List;

import org.jvalidation.matcher.Is;
import org.jvalidation.matcher.Matcher;
import org.jvalidation.matcher.Not;
import org.jvalidation.matcher.list.Empty;
import org.jvalidation.matcher.list.Size;
import org.jvalidation.matcher.number.Between;
import org.jvalidation.matcher.number.GreaterThan;
import org.jvalidation.matcher.number.GreaterThanOrEqualTo;
import org.jvalidation.matcher.number.LessThan;
import org.jvalidation.matcher.number.LessThanOrEqualTo;
import org.jvalidation.matcher.object.NullValue;

public class Matchers {
	
	private Matchers() throws InstantiationException {
		throw new InstantiationException("Instances of this type are forbidden");
	}
	
	public static Matcher<Object> nullValue() {
		return new NullValue();
	}
	
	public static <T> Matcher<T> not(Matcher<T> matcher) {
		return new Not<T>(matcher);
	}
	
	public static <T> Matcher<T> is(Matcher<T> matcher) {
		return new Is<T>(matcher);
	}
	
	public static <T extends Number> GreaterThan greaterThan(T value) {
		return new GreaterThan(value);
	}
	
	public static GreaterThan greaterThanOrEqualTo(int value) {
		return new GreaterThanOrEqualTo(value);
	}
	
	public static LessThan lessThan(int value) {
		return new LessThan(value);
	}
	
	public static LessThan lessThanOrEqualTo(int value) {
		return new LessThanOrEqualTo(value);
	}
	
	public static <T extends Number> Between between(T a, T b) {
		return new Between(a,b);
	}
	
	public static <T extends List<?>> Empty empty() {
		return new Empty();
	}
	
	public static <T extends List<?>> Size size(int size) {
		return new Size(size);
	}
}
