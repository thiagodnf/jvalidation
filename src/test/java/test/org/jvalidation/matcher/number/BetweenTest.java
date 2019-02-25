package test.org.jvalidation.matcher.number;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.jvalidation.Assertive.require;
import static org.jvalidation.Matchers.between;

import org.junit.jupiter.api.Test;
import org.jvalidation.matcher.number.Between;

public class BetweenTest {
	
	@Test
	public void shouldReturnTrueForTheCorrectInteger() {
		assertTrue(new Between(2,4).execute(2));
		assertTrue(new Between(2,4).execute(3));
		assertTrue(new Between(2,4).execute(4));
		assertTrue(new Between(2,4).execute(2.1));
		assertTrue(new Between(2.5,4.5).execute(2.5));
		assertTrue(new Between(2.5,4.5).execute(4.5));
	}
	
	@Test
	public void shouldReturnFalseForTheInCorrectDouble() {
		assertFalse(new Between(2,4).execute(5));
		assertFalse(new Between(2,4).execute(1));
		assertFalse(new Between(2,4).execute(1.9));
	}
	
	@Test
	public void shouldThrowAnExceptionWhenTheTargetIsInvalid() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			require(1, between(2,4));
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			require(5, between(2,4));
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			require(1.9, between(2,4));
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			require(2.4, between(2.5, 4.5));
		});
	}
}
