package test.org.jvalidation;

import static com.mscharhag.oleaster.matcher.Matchers.expect;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.describe;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.it;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.beforeEach;

import org.junit.runner.RunWith;
import org.jvalidation.Assertive;
import static org.jvalidation.Assertive.require;
import static org.jvalidation.Assertive.ensure;

import com.mscharhag.oleaster.runner.OleasterRunner;

@RunWith(OleasterRunner.class)
public class AssertiveTest {
	
	private Assertive assertive;
	
{
	describe("when call require()", () -> {
		
		it("should return no null object with isObject()", () -> {
			expect(require(null)).toBeNotNull();
		});
	});
	
	describe("when call ensure()", () -> {
		
		it("should return no null object with isObject()", () -> {
			expect(ensure(null)).toBeNotNull();
		});
	});
	
	describe("when null as passed as input", () -> {
		
		beforeEach(() -> {
			assertive = new Assertive(null);
		});
		
		it("should throw an exception with isInteger()", () -> {
			expect(() -> { assertive.isInteger();}).toThrow(IllegalArgumentException.class);
		});
		
		it("should throw an exception with isDouble()", () -> {
			expect(() -> { assertive.isDouble();}).toThrow(IllegalArgumentException.class);
		});
		
		it("should return no null object with isObject()", () -> {
			expect(assertive.isObject()).toBeNotNull();
		});
		
		it("should throw an exception with isString()", () -> {
			expect(() -> { assertive.isString();}).toThrow(IllegalArgumentException.class);
		});
	});
	
	describe("when an integer as passed as input", () -> {
		
		beforeEach(() -> {
			assertive = new Assertive(2);
		});
		
		it("should return no null object when", () -> {
			expect(assertive.isInteger()).toBeNotNull();
		});
		
		it("should throw an exception with isDouble()", () -> {
			expect(() -> { assertive.isDouble();}).toThrow(IllegalArgumentException.class);
		});
		
		it("should throw an exception with isString()", () -> {
			expect(() -> { assertive.isString();}).toThrow(IllegalArgumentException.class);
		});
	});
		
	describe("when an double as passed as input", () -> {
		
		beforeEach(() -> {
			assertive = new Assertive(2.2);
		});
		
		it("should return no null object when", () -> {
			expect(assertive.isDouble()).toBeNotNull();
		});
		
		it("should throw an exception with isDouble()", () -> {
			expect(() -> { assertive.isInteger();}).toThrow(IllegalArgumentException.class);
		});
		
		it("should throw an exception with isString()", () -> {
			expect(() -> { assertive.isString();}).toThrow(IllegalArgumentException.class);
		});
	});
	
	describe("when use the correct inputs", () -> {
		
		it("should return not null object)", () -> {
			expect(new Assertive("abc").isString()).toBeNotNull();
			expect(new Assertive('a').isChar()).toBeNotNull();
		});
	});
	
	describe("when use the invalid inputs", () -> {

		it("should throw an exception with isDouble()", () -> {
			expect(() -> { new Assertive("a").isChar();}).toThrow(IllegalArgumentException.class);
		});
	});
		
}}
