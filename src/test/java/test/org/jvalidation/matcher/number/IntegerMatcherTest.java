package test.org.jvalidation.matcher.number;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.jvalidation.Assertive.require;

import org.junit.jupiter.api.Test;

public class IntegerMatcherTest {
	
	@Test
	public void shouldThrowAnException() {

		assertThrows(IllegalArgumentException.class, () -> {
			require(11).isInteger().equalTo(10);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			require(2).isInteger().greaterThan(10);		
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			require(2).isInteger().greaterThanOrEqualTo(10);		
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			require(10).isInteger().lessThan(2);		
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			require(10).isInteger().lessThanOrEqualTo(2);		
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			require(9).isInteger().between(10, 20);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			require(21).isInteger().between(10, 20);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			require(3).isInteger().even();
		});
		assertThrows(IllegalArgumentException.class, () -> {
			require(2).isInteger().odd();
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			require(3).isInteger().negative();
		});
		assertThrows(IllegalArgumentException.class, () -> {
			require(-2).isInteger().positive();
		});
	}
	
	@Test
	public void shouldNotThrowAnException() {
		
		require(10).isInteger().equalTo(10);
		
		require(11).isInteger().greaterThan(10);
		require(11).isInteger().greaterThanOrEqualTo(11);
		require(12).isInteger().greaterThanOrEqualTo(11);
		
		require(2).isInteger().lessThan(10);
		require(2).isInteger().lessThanOrEqualTo(2);
		require(1).isInteger().lessThanOrEqualTo(2);
		
		require(10).isInteger().between(10, 20);
		require(11).isInteger().between(10, 20);
		require(19).isInteger().between(10, 20);
		require(20).isInteger().between(10, 20);
		
		require(2).isInteger().even();
		require(4).isInteger().even();
		require(1).isInteger().not().even();
		require(3).isInteger().not().even();
		
		require(1).isInteger().odd();
		require(3).isInteger().odd();
		require(2).isInteger().not().odd();
		require(4).isInteger().not().odd();
		
		require(0).isInteger().positive();
		require(1).isInteger().positive();
		require(-1).isInteger().not().positive();
		require(-10).isInteger().not().positive();
		
		require(-1).isInteger().negative();
		require(-10).isInteger().negative();
		require(1).isInteger().not().negative();
		require(0).isInteger().not().negative();
		
	}
}
