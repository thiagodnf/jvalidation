package test.org.jvalidation.matcher.string;

import static com.mscharhag.oleaster.matcher.Matchers.expect;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.describe;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.it;

import org.junit.runner.RunWith;

import com.mscharhag.oleaster.runner.OleasterRunner;

import thiagodnf.jvalidation.matcher.string.CharMatcher;

@RunWith(OleasterRunner.class)
public class CharMatcherTest {{
	
	describe("when call consonant()", () -> {
		
		it("should throw an exception", () -> {
			expect(() -> { new CharMatcher('a').consonant();}).toThrow(IllegalArgumentException.class);
			expect(() -> { new CharMatcher('e').consonant();}).toThrow(IllegalArgumentException.class);
			expect(() -> { new CharMatcher('i').consonant();}).toThrow(IllegalArgumentException.class);
			expect(() -> { new CharMatcher('o').consonant();}).toThrow(IllegalArgumentException.class);
			expect(() -> { new CharMatcher('u').consonant();}).toThrow(IllegalArgumentException.class);
			expect(() -> { new CharMatcher('A').consonant();}).toThrow(IllegalArgumentException.class);
			expect(() -> { new CharMatcher('E').consonant();}).toThrow(IllegalArgumentException.class);
			expect(() -> { new CharMatcher('I').consonant();}).toThrow(IllegalArgumentException.class);
			expect(() -> { new CharMatcher('O').consonant();}).toThrow(IllegalArgumentException.class);
			expect(() -> { new CharMatcher('U').consonant();}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception", () -> {
			new CharMatcher('b').consonant();
			new CharMatcher('c').consonant();
		});
	});
	
	describe("when call vowel()", () -> {
		
		it("should throw an exception", () -> {
			expect(() -> { new CharMatcher('b').vowel();}).toThrow(IllegalArgumentException.class);
			expect(() -> { new CharMatcher('d').vowel();}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception", () -> {
			new CharMatcher('a').vowel();
			new CharMatcher('e').vowel();
			new CharMatcher('i').vowel();
			new CharMatcher('o').vowel();
			new CharMatcher('u').vowel();
			new CharMatcher('A').vowel();
			new CharMatcher('E').vowel();
			new CharMatcher('I').vowel();
			new CharMatcher('O').vowel();
			new CharMatcher('U').vowel();
		});
	});
	
	
	
}}
