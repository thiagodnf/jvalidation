package test.org.jvalidation.matcher.collection;

import static com.mscharhag.oleaster.matcher.Matchers.expect;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.describe;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.it;

import java.util.Arrays;

import org.junit.runner.RunWith;

import com.mscharhag.oleaster.runner.OleasterRunner;

import thiagodnf.jvalidation.matcher.collection.ListMatcher;

@RunWith(OleasterRunner.class)
public class ListMatcherTest {{
	
	describe("when call nullValue()", () -> {
		
		it("should throw an exception", () -> {
			expect(() -> { new ListMatcher(Arrays.asList()).nullValue();}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception", () -> {
			new ListMatcher(null).nullValue();
		});
	});
	
	describe("when call notNullValue()", () -> {
		
		it("should throw an exception", () -> {
			expect(() -> { new ListMatcher(null).notNull();}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception", () -> {
			new ListMatcher(Arrays.asList()).notNull();
		});
	});
	
	describe("when call empty()", () -> {
		
		it("should throw an exception with null string", () -> {
			expect(() -> { new ListMatcher(null).empty();}).toThrow(IllegalArgumentException.class);
		});
		
		it("should throw an exception", () -> {
			expect(() -> { new ListMatcher(Arrays.asList(1)).empty();}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception", () -> {
			new ListMatcher(Arrays.asList()).empty();
		});
	});

	describe("when call notEmpty()", () -> {
		
		it("should throw an exception with null target", () -> {
			expect(() -> { new ListMatcher(null).notEmpty();}).toThrow(IllegalArgumentException.class);
		});
		
		it("should throw an exception", () -> {
			expect(() -> { new ListMatcher(Arrays.asList()).notEmpty();}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception", () -> {
			new ListMatcher(Arrays.asList(1)).notEmpty();
		});
	});
	
	describe("when call size()", () -> {
		
		it("should throw an exception", () -> {
			expect(() -> { new ListMatcher(Arrays.asList(1,2,3)).size(2);}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception", () -> {
			new ListMatcher(Arrays.asList()).size(0);
			new ListMatcher(Arrays.asList(1)).size(1);
			new ListMatcher(Arrays.asList(1,2)).size(2);
		});
	});
	
	describe("when call maxSize()", () -> {
		
		it("should throw an exception", () -> {
			expect(() -> { new ListMatcher(Arrays.asList(1,2,3)).maxSize(2);}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception", () -> {
			new ListMatcher(Arrays.asList()).maxSize(3);
			new ListMatcher(Arrays.asList(1)).maxSize(3);
			new ListMatcher(Arrays.asList(1,2)).maxSize(3);
			new ListMatcher(Arrays.asList(1,2,3)).maxSize(3);
		});
	});
	
	describe("when call minSize()", () -> {
		
		it("should throw an exception", () -> {
			expect(() -> { new ListMatcher(Arrays.asList(1)).minSize(2);}).toThrow(IllegalArgumentException.class);
			expect(() -> { new ListMatcher(Arrays.asList()).minSize(2);}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception", () -> {
			new ListMatcher(Arrays.asList(1,2)).minSize(2);
			new ListMatcher(Arrays.asList(1,2,3)).minSize(2);
		});
	});
	
	describe("when call contains()", () -> {
		
		it("should throw an exception", () -> {
			expect(() -> { new ListMatcher(Arrays.asList(1)).contains(2);}).toThrow(IllegalArgumentException.class);
			expect(() -> { new ListMatcher(Arrays.asList()).contains(2);}).toThrow(IllegalArgumentException.class);
			expect(() -> { new ListMatcher(Arrays.asList("a")).contains("b");}).toThrow(IllegalArgumentException.class);
			expect(() -> { new ListMatcher(Arrays.asList('b', 'c')).contains("b");}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception", () -> {
			new ListMatcher(Arrays.asList(1,2)).contains(2);
			new ListMatcher(Arrays.asList(1,2,3)).contains(2);
			new ListMatcher(Arrays.asList("a", "b")).contains("a");
			new ListMatcher(Arrays.asList(2.1, 3.4)).contains(2.1);
			new ListMatcher(Arrays.asList('b', 'c')).contains('b');
		});
	});
}}
