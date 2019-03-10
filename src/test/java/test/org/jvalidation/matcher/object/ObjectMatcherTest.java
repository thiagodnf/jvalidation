package test.org.jvalidation.matcher.object;

import static com.mscharhag.oleaster.matcher.Matchers.expect;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.describe;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.it;

import org.junit.runner.RunWith;
import org.jvalidation.matcher.object.ObjectMatcher;

import com.mscharhag.oleaster.runner.OleasterRunner;

@RunWith(OleasterRunner.class)
public class ObjectMatcherTest {{
	
	describe("when call nullValue()", () -> {
		
		it("should throw an exception", () -> {
			expect(() -> { new ObjectMatcher<Object>(2).nullValue();}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception", () -> {
			new ObjectMatcher<Object>(null).nullValue();
		});
	});
	
	describe("when call notNullValue()", () -> {
		
		it("should throw an exception", () -> {
			expect(() -> { new ObjectMatcher<Object>(null).notNull();}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception", () -> {
			new ObjectMatcher<Object>(2).notNull();
		});
	});
	
	describe("when call instanceOf()", () -> {
		
		it("should throw an exception", () -> {
			expect(() -> { new ObjectMatcher<Object>("Test").instanceOf(Integer.class);}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception", () -> {
			new ObjectMatcher<Object>("Test").instanceOf(String.class);
		});
	});
	
	describe("when call notInstanceOf()", () -> {
		
		it("should throw an exception", () -> {
			expect(() -> { new ObjectMatcher<Object>("Test").notInstanceOf(String.class);}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception", () -> {
			new ObjectMatcher<Object>("Test").notInstanceOf(Integer.class);
		});
	});
}}
