package test.org.jvalidation.matcher.string;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.jvalidation.Assertive.require;
import static org.jvalidation.Matchers.empty;

import org.junit.jupiter.api.Test;
import org.jvalidation.matcher.string.Empty;

public class EmptyTest {
	
	@Test
	public void shouldThrowsAndExceptionWithNull() {
		
		assertThrows(NullPointerException.class, () -> {
			new Empty().execute(null);
		});
	}
	
	@Test
	public void shouldReturnTrueForTheCorrectInteger() {
		assertTrue(new Empty().execute(""));
		assertTrue(new Empty().execute("  "));
	}
	
	@Test
	public void shouldReturnFalseForTheInCorrectInteger() {
		assertFalse(new Empty().execute("a"));
	}
	
	@Test
	public void shouldThrowAnExceptionWhenTheTargetIsInvalid() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			require("a", empty());
		});
	}
}
