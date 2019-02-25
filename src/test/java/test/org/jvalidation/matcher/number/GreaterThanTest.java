package test.org.jvalidation.matcher.number;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.jvalidation.Assertive.require;
import static org.jvalidation.Matchers.greaterThan;
import static org.jvalidation.Matchers.not;

import org.junit.jupiter.api.Test;
import org.jvalidation.matcher.number.GreaterThan;

public class GreaterThanTest {
	
	@Test
	public void shouldReturnTrueForTheCorrectInteger() {
		assertTrue(new GreaterThan(1).execute(2));
	}
	
	@Test
	public void shouldReturnTrueForTheCorrectDouble() {
		assertTrue(new GreaterThan(1.0).execute(2.0));
	}
	
	@Test
	public void shouldReturnTrueForTheCorrectLong() {
		assertTrue(new GreaterThan(1L).execute(2L));
	}
	
	@Test
	public void shouldReturnFalseForTheInCorrectInteger() {
		assertFalse(new GreaterThan(2).execute(1));
		assertFalse(new GreaterThan(2).execute(2));
	}
	
	@Test
	public void shouldReturnFalseForTheInCorrectDouble() {
		assertFalse(new GreaterThan(2.0).execute(1.0));
		assertFalse(new GreaterThan(2.0).execute(2.0));
	}
	
	@Test
	public void shouldReturnFalseForTheInCorrectLong() {
		assertFalse(new GreaterThan(2L).execute(1L));
		assertFalse(new GreaterThan(2L).execute(2L));
	}
	
	@Test
	public void shouldThrowAnExceptionWhenTheTargetIsInvalid() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			require(1, greaterThan(2));
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			require(5, not(greaterThan(2)));
		});
	}
}
