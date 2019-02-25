package test.org.jvalidation.matcher.number;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.jvalidation.Assertive.require;
import static org.jvalidation.Matchers.greaterThanOrEqualTo;

import org.junit.jupiter.api.Test;
import org.jvalidation.matcher.number.GreaterThanOrEqualTo;

public class GreaterThanOrEqualToTest {
	
	@Test
	public void shouldReturnTrueForTheCorrectInteger() {
		assertTrue(new GreaterThanOrEqualTo(1).execute(2));
		assertTrue(new GreaterThanOrEqualTo(2).execute(2));
	}
	
	@Test
	public void shouldReturnTrueForTheCorrectDouble() {
		assertTrue(new GreaterThanOrEqualTo(1.0).execute(2.0));
		assertTrue(new GreaterThanOrEqualTo(2.0).execute(2.0));
	}
	
	@Test
	public void shouldReturnTrueForTheCorrectLong() {
		assertTrue(new GreaterThanOrEqualTo(1L).execute(2L));
		assertTrue(new GreaterThanOrEqualTo(2L).execute(2L));
	}
	
	@Test
	public void shouldReturnFalseForTheInCorrectInteger() {
		assertFalse(new GreaterThanOrEqualTo(2).execute(1));
	}
	
	@Test
	public void shouldReturnFalseForTheInCorrectDouble() {
		assertFalse(new GreaterThanOrEqualTo(2.0).execute(1.0));
	}
	
	@Test
	public void shouldReturnFalseForTheInCorrectLong() {
		assertFalse(new GreaterThanOrEqualTo(2L).execute(1L));
	}
	
	@Test
	public void shouldThrowAnExceptionWhenTheTargetIsInvalid() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			require(1, greaterThanOrEqualTo(2));
		});
	}
}
