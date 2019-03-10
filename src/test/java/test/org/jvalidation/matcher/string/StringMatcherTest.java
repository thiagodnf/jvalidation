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
	
	describe("when call endsWith()", () -> {
		
		it("should throw an exception with null target", () -> {
			expect(() -> { new StringMatcher(null).endsWith("abc");}).toThrow(IllegalArgumentException.class);
		});
		
		it("should throw an exception", () -> {
			expect(() -> { new StringMatcher("abcd").endsWith("abc");}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception", () -> {
			new StringMatcher("abc").endsWith("abc");
			new StringMatcher("dabc").endsWith("abc");
		});
	});
	
	describe("when call contains()", () -> {
		
		it("should throw an exception with null target", () -> {
			expect(() -> { new StringMatcher(null).contains("abc");}).toThrow(IllegalArgumentException.class);
		});
		
		it("should throw an exception", () -> {
			expect(() -> { new StringMatcher("adbcd").contains("abc");}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception", () -> {
			new StringMatcher("abc").contains("abc");
			new StringMatcher("dabce").contains("abc");
		});
	});
	
	describe("when call matches()", () -> {
		
		it("should throw an exception with null target", () -> {
			expect(() -> { new StringMatcher(null).matches("(abc)*");}).toThrow(IllegalArgumentException.class);
		});
		
		it("should throw an exception", () -> {
			expect(() -> { new StringMatcher("adbcd").matches("(abc)*");}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception", () -> {
			new StringMatcher("").matches("(abc)*");
			new StringMatcher("abc").matches("(abc)*");
			new StringMatcher("abcabc").matches("(abc)*");
		});
	});
	
	describe("when call length()", () -> {
		
		it("should throw an exception with null target", () -> {
			expect(() -> { new StringMatcher(null).length(2);}).toThrow(IllegalArgumentException.class);
		});
		
		it("should throw an exception", () -> {
			expect(() -> { new StringMatcher("abc").length(4);}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception", () -> {
			new StringMatcher("ab").length(2);
			new StringMatcher("abc").length(3);
			new StringMatcher("").length(0);
		});
	});
	
	describe("when call notEmpty()", () -> {
		
		it("should throw an exception with null target", () -> {
			expect(() -> { new StringMatcher(null).notEmpty();}).toThrow(IllegalArgumentException.class);
		});
		
		it("should throw an exception", () -> {
			expect(() -> { new StringMatcher("").notEmpty();}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception", () -> {
			new StringMatcher("a").notEmpty();
		});
	});
	
	describe("when call email()", () -> {
		
		it("should throw an exception with null target", () -> {
			expect(() -> { new StringMatcher(null).email();}).toThrow(IllegalArgumentException.class);
		});
		
		it("should throw an exception", () -> {
			expect(() -> { new StringMatcher("").email();}).toThrow(IllegalArgumentException.class);
			expect(() -> { new StringMatcher("@domain.com").email();}).toThrow(IllegalArgumentException.class);
			expect(() -> { new StringMatcher("domain.com@").email();}).toThrow(IllegalArgumentException.class);
			expect(() -> { new StringMatcher("user'name@domain.co.in").email();}).toThrow(IllegalArgumentException.class);
			expect(() -> { new StringMatcher("user?name@domain.co.in").email();}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception", () -> {
			new StringMatcher("user@domain.com").email();
			new StringMatcher("user@domain.co.in").email();
			new StringMatcher("user1@domain.com").email();
			new StringMatcher("user.name@domain.com").email();
			new StringMatcher("user_name@domain.co.in").email();
			new StringMatcher("user-name@domain.co.in").email();
			new StringMatcher("user@domaincom").email();
		});
	});

	describe("when call blank()", () -> {
		
		it("should throw an exception", () -> {
			expect(() -> { new StringMatcher("a").blank();}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception", () -> {
			new StringMatcher("").blank();
			new StringMatcher(null).blank();
		});
	});
	
	describe("when call notBlank()", () -> {
		
		it("should throw an exception", () -> {
			expect(() -> { new StringMatcher("").notBlank();}).toThrow(IllegalArgumentException.class);
			expect(() -> { new StringMatcher(null).notBlank();}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception", () -> {
			new StringMatcher("a").notBlank();
		});
	});
	
	describe("when call maxLength()", () -> {
		
		it("should throw an exception", () -> {
			expect(() -> { new StringMatcher("123").maxLength(2);}).toThrow(IllegalArgumentException.class);
			expect(() -> { new StringMatcher("1234").maxLength(2);}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception", () -> {
			new StringMatcher("").maxLength(3);
			new StringMatcher("1").maxLength(3);
			new StringMatcher("12").maxLength(3);
			new StringMatcher("123").maxLength(3);
		});
	});
	
	describe("when call minLength()", () -> {
		
		it("should throw an exception", () -> {
			expect(() -> { new StringMatcher("1").minLength(2);}).toThrow(IllegalArgumentException.class);
			expect(() -> { new StringMatcher("").minLength(2);}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception", () -> {
			new StringMatcher("12").minLength(2);
			new StringMatcher("123").minLength(2);
		});
	});
	
	describe("when call nullValue()", () -> {
		
		it("should throw an exception", () -> {
			expect(() -> { new StringMatcher("2").nullValue();}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception", () -> {
			new StringMatcher(null).nullValue();
		});
	});
	
	describe("when call notNullValue()", () -> {
		
		it("should throw an exception", () -> {
			expect(() -> { new StringMatcher(null).notNull();}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception", () -> {
			new StringMatcher("2").notNull();
		});
	});
	
	describe("when call multiple conditions at the same time", () -> {
		
		describe("with notNull(), notEmpty() and length()", () -> {
			
			it("should not throw an exception", () -> {
				new StringMatcher("test").notNull().notEmpty().length(4);
			});
		});
	});
	
}}
