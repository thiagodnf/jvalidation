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
			expect(() -> { new ObjectMatcher(2).nullValue();}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception", () -> {
			new ObjectMatcher(null).nullValue();
		});
	});
	
	describe("when call notNullValue()", () -> {
		
		it("should throw an exception", () -> {
			expect(() -> { new ObjectMatcher(null).notNullValue();}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception", () -> {
			new ObjectMatcher(2).notNullValue();
		});
	});
	
	describe("when call instanceOf()", () -> {
		
		it("should throw an exception", () -> {
			expect(() -> { new ObjectMatcher("Test").instanceOf(Integer.class);}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception", () -> {
			new ObjectMatcher("Test").instanceOf(String.class);
		});
	});
	
	describe("when call notInstanceOf()", () -> {
		
		it("should throw an exception", () -> {
			expect(() -> { new ObjectMatcher("Test").notInstanceOf(String.class);}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception", () -> {
			new ObjectMatcher("Test").notInstanceOf(Integer.class);
		});
	});
}}
