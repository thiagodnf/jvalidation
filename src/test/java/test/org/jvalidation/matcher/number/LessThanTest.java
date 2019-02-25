package test.org.jvalidation.matcher.number;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.jvalidation.Assertive.require;
import static org.jvalidation.Matchers.lessThan;

import org.junit.jupiter.api.Test;
import org.jvalidation.matcher.number.LessThan;

public class LessThanTest {
	
	@Test
	public void shouldReturnTrueForTheCorrectInteger() {
		assertTrue(new LessThan(2).execute(1));
	}
	
	@Test
	public void shouldReturnTrueForTheCorrectDouble() {
		assertTrue(new LessThan(2.0).execute(1.0));
	}
	
	@Test
	public void shouldReturnTrueForTheCorrectLong() {
		assertTrue(new LessThan(2L).execute(1L));
	}
	
	@Test
	public void shouldReturnFalseForTheInCorrectInteger() {
		assertFalse(new LessThan(1).execute(2));
		assertFalse(new LessThan(2).execute(2));
	}
	
	@Test
	public void shouldReturnFalseForTheInCorrectDouble() {
		assertFalse(new LessThan(1.0).execute(2.0));
		assertFalse(new LessThan(2.0).execute(2.0));
	}
	
	@Test
	public void shouldReturnFalseForTheInCorrectLong() {
		assertFalse(new LessThan(1L).execute(2L));
		assertFalse(new LessThan(2L).execute(2L));
	}
	
	@Test
	public void shouldThrowAnExceptionWhenTheTargetIsInvalid() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			require(2, lessThan(1));
		});
	}
}
