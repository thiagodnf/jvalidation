package test.org.jvalidation.matcher.number;

import static com.mscharhag.oleaster.matcher.Matchers.expect;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.beforeEach;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.describe;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.it;

import org.junit.runner.RunWith;
import org.jvalidation.matcher.number.IntegerMatcher;

import com.mscharhag.oleaster.runner.OleasterRunner;

@RunWith(OleasterRunner.class)
public class IntegerMatcherTest {

	private IntegerMatcher matcher;
	
{

	describe("when call equalTo()", () -> {
		
		beforeEach(() -> {
			matcher = new IntegerMatcher(0);
		});
		
		it("should throw an exception", () -> {
			expect(() -> { matcher.equalTo(1);}).toThrow(IllegalArgumentException.class);
			expect(() -> { matcher.equalTo(-1);}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception", () -> {
			matcher.equalTo(0);
		});
	});
	
	describe("when call greaterThan()", () -> {
		
		beforeEach(() -> {
			matcher = new IntegerMatcher(10);
		});
		
		it("should throw an exception", () -> {
			expect(() -> { matcher.greaterThan(10);}).toThrow(IllegalArgumentException.class);
			expect(() -> { matcher.greaterThan(20);}).toThrow(IllegalArgumentException.class);
			expect(() -> { matcher.greaterThan(30);}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception", () -> {
			matcher.greaterThan(0);
			matcher.greaterThan(9);
		});
	});
	
	describe("when call greaterThanOrEqualTo()", () -> {
		
		beforeEach(() -> {
			matcher = new IntegerMatcher(10);
		});
		
		it("should throw an exception", () -> {
			expect(() -> { matcher.greaterThanOrEqualTo(11);}).toThrow(IllegalArgumentException.class);
			expect(() -> { matcher.greaterThanOrEqualTo(20);}).toThrow(IllegalArgumentException.class);
			expect(() -> { matcher.greaterThanOrEqualTo(30);}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception", () -> {
			matcher.greaterThanOrEqualTo(0);
			matcher.greaterThanOrEqualTo(9);
			matcher.greaterThanOrEqualTo(10);
		});
	});
	
	describe("when call lessThan()", () -> {
		
		beforeEach(() -> {
			matcher = new IntegerMatcher(10);
		});
		
		it("should throw an exception", () -> {
			expect(() -> { matcher.lessThan(10);}).toThrow(IllegalArgumentException.class);
			expect(() -> { matcher.lessThan(9);}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception", () -> {
			matcher.lessThan(11);
		});
	});
	
	describe("when call lessThanOrEqualTo()", () -> {
		
		beforeEach(() -> {
			matcher = new IntegerMatcher(10);
		});
		
		it("should throw an exception", () -> {
			expect(() -> { matcher.lessThanOrEqualTo(8);}).toThrow(IllegalArgumentException.class);
			expect(() -> { matcher.lessThanOrEqualTo(9);}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception", () -> {
			matcher.lessThanOrEqualTo(10);
			matcher.lessThanOrEqualTo(11);
			matcher.lessThanOrEqualTo(12);
		});
	});
	
	describe("when call between()", () -> {
		
		beforeEach(() -> {
			matcher = new IntegerMatcher(9);
		});
		
		it("should throw an exception", () -> {
			expect(() -> { matcher.between(1 , 8);}).toThrow(IllegalArgumentException.class);
			expect(() -> { matcher.between(10, 12);}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception", () -> {
			matcher.between(8,20);
			matcher.between(9,20);
			matcher.between(1,9);
		});
	});
	
	describe("when call even()", () -> {
		
		it("should throw an exception", () -> {
			expect(() -> { new IntegerMatcher(1).even();}).toThrow(IllegalArgumentException.class);
			expect(() -> { new IntegerMatcher(3).even();}).toThrow(IllegalArgumentException.class);
		});
		
		it("should throw an exception with negative values", () -> {
			expect(() -> { new IntegerMatcher(-1).even();}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception", () -> {
			new IntegerMatcher(0).even();
			new IntegerMatcher(2).even();
		});
	});
	
	describe("when call odd()", () -> {
		
		it("should throw an exception", () -> {
			expect(() -> { new IntegerMatcher(0).odd();}).toThrow(IllegalArgumentException.class);
			expect(() -> { new IntegerMatcher(2).odd();}).toThrow(IllegalArgumentException.class);
		});
		
		it("should throw an exception with negative values", () -> {
			expect(() -> { new IntegerMatcher(-1).odd();}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception", () -> {
			new IntegerMatcher(1).odd();
			new IntegerMatcher(3).odd();
		});
	});
	
	describe("when call negative()", () -> {
		
		it("should throw an exception", () -> {
			expect(() -> { new IntegerMatcher(0).negative();}).toThrow(IllegalArgumentException.class);
			expect(() -> { new IntegerMatcher(1).negative();}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception", () -> {
			new IntegerMatcher(-1).negative();
			new IntegerMatcher(-2).negative();
		});
	});
	
	describe("when call positive()", () -> {
		
		it("should throw an exception", () -> {
			expect(() -> { new IntegerMatcher(-1).positive();}).toThrow(IllegalArgumentException.class);
			expect(() -> { new IntegerMatcher(-2).positive();}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception", () -> {
			new IntegerMatcher(0).positive();
			new IntegerMatcher(1).positive();
		});
	});
	
	describe("when call multiple conditions at the same time", () -> {
	
		describe("with even() and greaterThan()", () -> {
			
			it("should throw an exception", () -> {
				expect(() -> { new IntegerMatcher(8).even().greaterThan(10);}).toThrow(IllegalArgumentException.class);
				expect(() -> { new IntegerMatcher(6).even().greaterThan(10);}).toThrow(IllegalArgumentException.class);
			});
			
			it("should not throw an exception", () -> {
				new IntegerMatcher(12).even().greaterThan(10);
				new IntegerMatcher(14).even().greaterThan(10);
			});
		});
	});
}}
