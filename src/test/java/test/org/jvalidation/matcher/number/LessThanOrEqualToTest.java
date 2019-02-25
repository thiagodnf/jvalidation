package test.org.jvalidation.matcher.number;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.jvalidation.Assertive.require;
import static org.jvalidation.Matchers.lessThanOrEqualTo;

import org.junit.jupiter.api.Test;
import org.jvalidation.matcher.number.LessThanOrEqualTo;

public class LessThanOrEqualToTest {
	
	@Test
	public void shouldReturnTrueForTheCorrectInteger() {
		assertTrue(new LessThanOrEqualTo(2).execute(1));
		assertTrue(new LessThanOrEqualTo(2).execute(2));
	}
	
	@Test
	public void shouldReturnTrueForTheCorrectDouble() {
		assertTrue(new LessThanOrEqualTo(2.0).execute(1.0));
		assertTrue(new LessThanOrEqualTo(2.0).execute(2.0));
	}
	
	@Test
	public void shouldReturnTrueForTheCorrectLong() {
		assertTrue(new LessThanOrEqualTo(2L).execute(1L));
		assertTrue(new LessThanOrEqualTo(2L).execute(2L));
	}
	
	@Test
	public void shouldReturnFalseForTheInCorrectInteger() {
		assertFalse(new LessThanOrEqualTo(1).execute(2));
	}
	
	@Test
	public void shouldReturnFalseForTheInCorrectDouble() {
		assertFalse(new LessThanOrEqualTo(1.0).execute(2.0));
	}
	
	@Test
	public void shouldReturnFalseForTheInCorrectLong() {
		assertFalse(new LessThanOrEqualTo(1L).execute(2L));
	}
	
	@Test
	public void shouldThrowAnExceptionWhenTheTargetIsInvalid() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			require(2, lessThanOrEqualTo(1));
		});
	}
}
