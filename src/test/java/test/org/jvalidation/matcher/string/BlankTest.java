package test.org.jvalidation.matcher.string;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.jvalidation.Assertive.require;
import static org.jvalidation.Matchers.blank;

import org.junit.jupiter.api.Test;
import org.jvalidation.matcher.string.Blank;

public class BlankTest {
	
	@Test
	public void shouldReturnTrueForTheCorrectInteger() {
		assertTrue(new Blank().execute(""));
		assertTrue(new Blank().execute("  "));
		assertTrue(new Blank().execute(null));
	}
	
	@Test
	public void shouldReturnFalseForTheInCorrectInteger() {
		assertFalse(new Blank().execute("a"));
	}
	
	@Test
	public void shouldThrowAnExceptionWhenTheTargetIsInvalid() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			require("a", blank());
		});
	}
}
