package test.org.jvalidation.matcher.number;

import static com.mscharhag.oleaster.matcher.Matchers.expect;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.beforeEach;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.describe;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.it;

import org.junit.runner.RunWith;
import org.jvalidation.matcher.number.DoubleMatcher;
import org.jvalidation.matcher.number.IntegerMatcher;

import com.mscharhag.oleaster.runner.OleasterRunner;

@RunWith(OleasterRunner.class)
public class DoubleMatcherTest {

	private DoubleMatcher matcher;
	
{

	describe("when call equalTo()", () -> {
		
		beforeEach(() -> {
			matcher = new DoubleMatcher(0);
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
			matcher = new DoubleMatcher(10);
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
			matcher = new DoubleMatcher(10);
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
			matcher = new DoubleMatcher(10);
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
			matcher = new DoubleMatcher(10);
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
			matcher = new DoubleMatcher(9);
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
	
	describe("when call negative()", () -> {
		
		it("should throw an exception", () -> {
			expect(() -> { new DoubleMatcher(0).negative();}).toThrow(IllegalArgumentException.class);
			expect(() -> { new DoubleMatcher(1).negative();}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception", () -> {
			new DoubleMatcher(-1).negative();
			new DoubleMatcher(-2).negative();
		});
	});
	
	describe("when call positive()", () -> {
		
		it("should throw an exception", () -> {
			expect(() -> { new DoubleMatcher(-1).positive();}).toThrow(IllegalArgumentException.class);
			expect(() -> { new DoubleMatcher(-2).positive();}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception", () -> {
			new DoubleMatcher(0).positive();
			new DoubleMatcher(1).positive();
		});
	});
	
	describe("when call closeTo()", () -> {
		
		it("should throw an exception", () -> {
			expect(() -> { new DoubleMatcher(10).closeTo(9.6,0.2);}).toThrow(IllegalArgumentException.class);
		});
		
		it("should not throw an exception with positive values", () -> {
			new DoubleMatcher(10).closeTo(9.8, 0.21);
			new DoubleMatcher(9.6).closeTo(9.8, 0.21);
			new DoubleMatcher(10).closeTo(10.2, 0.21);
			new DoubleMatcher(10).closeTo(10, 0.21);
		});
		
		it("should not throw an exception with negatives values", () -> {
			new DoubleMatcher(-10).closeTo(-9.8, 0.21);
			new DoubleMatcher(-9.6).closeTo(-9.8, 0.2);
		});
	});
	
	describe("when call multiple conditions at the same time", () -> {
		
		describe("with positive() and greaterThan()", () -> {
			
			it("should throw an exception", () -> {
				expect(() -> { new IntegerMatcher(-1).positive().greaterThan(10);}).toThrow(IllegalArgumentException.class);
				expect(() -> { new IntegerMatcher(8).positive().greaterThan(10);}).toThrow(IllegalArgumentException.class);
			});
			
			it("should not throw an exception", () -> {
				new IntegerMatcher(12).positive().greaterThan(10);
				new IntegerMatcher(14).positive().greaterThan(10);
			});
		});
	});
}}
