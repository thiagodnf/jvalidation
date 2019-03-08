package test.org.jvalidation.matcher.number;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.jvalidation.Assertive.require;

import org.junit.jupiter.api.Test;
import org.jvalidation.matcher.number.DoubleMatcher;

public class DoubleMatcherTest {
	
	@Test
	public void shouldThrowAnException() {

		assertThrows(IllegalArgumentException.class, () -> {
			new DoubleMatcher(2.0).equalTo(10);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new DoubleMatcher(12.0).equalTo(10);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			require(2.0).isDouble().greaterThan(10);		
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			require(2.0).isDouble().greaterThanOrEqualTo(10);		
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			require(10.0).isDouble().lessThan(2);		
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			require(10.0).isDouble().lessThanOrEqualTo(2);		
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			require(9.0).isDouble().between(10, 20);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			require(21.0).isDouble().between(10, 20);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			require(3.0).isDouble().negative();
		});
		assertThrows(IllegalArgumentException.class, () -> {
			require(-3.0).isDouble().not().negative();
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			require(-2.0).isDouble().positive();
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new DoubleMatcher(2.0).not().positive();
		});
	}
	
	@Test
	public void shouldNotThrowAnException() {
		
		require(10.0).isDouble().equalTo(10);
		
		require(11.0).isDouble().greaterThan(10);
		require(11.0).isDouble().greaterThanOrEqualTo(11);
		require(12.0).isDouble().greaterThanOrEqualTo(11);
		
		require(2.0).isDouble().lessThan(10);
		require(2.0).isDouble().lessThanOrEqualTo(2);
		require(1.0).isDouble().lessThanOrEqualTo(2);
		
		require(10.0).isDouble().between(10, 20);
		require(11.0).isDouble().between(10, 20);
		require(19.0).isDouble().between(10, 20);
		require(20.0).isDouble().between(10, 20);
		
		require(0.0).isDouble().positive();
		require(1.0).isDouble().positive();
		require(-1.0).isDouble().not().positive();
		require(-10.0).isDouble().not().positive();
		
		require(-1.0).isDouble().negative();
		require(-10.0).isDouble().negative();
		require(1.0).isDouble().not().negative();
		require(0.0).isDouble().not().negative();
		
	}
}
