package test.org.jvalidation.matcher.string;

import static com.mscharhag.oleaster.matcher.Matchers.expect;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.describe;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.it;

import org.junit.runner.RunWith;
import org.jvalidation.matcher.string.StringMatcher;

import com.mscharhag.oleaster.runner.OleasterRunner;

@RunWith(OleasterRunner.class)
public class StringMatcherTest {{
	
	describe("when call empty()", () -> {
		
		it("should throw an exception with null string", () -> {
			expect(() -> { new StringMatcher(null).empty();}).toThrow(IllegalArgumentException.class);
		});
		
		it("should throw an exception", () -> {
			expect(() -> { new StringMatcher("a").empty();}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception", () -> {
			new StringMatcher("").empty();
		});
	});
	
	describe("when call startsWith()", () -> {
		
		it("should throw an exception with null string", () -> {
			expect(() -> { new StringMatcher(null).startsWith("abc");}).toThrow(IllegalArgumentException.class);
		});
		
		it("should throw an exception", () -> {
			expect(() -> { new StringMatcher("bca").startsWith("abc");}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception", () -> {
			new StringMatcher("abc").startsWith("abc");
			new StringMatcher("abcd").startsWith("abc");
		});
	});
	
}}
