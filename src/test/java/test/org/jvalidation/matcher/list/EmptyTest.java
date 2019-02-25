package test.org.jvalidation.matcher.list;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.jvalidation.Assertive.require;
import static org.jvalidation.Matchers.empty;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.jvalidation.matcher.list.Empty;

public class EmptyTest {
	
	@Test
	public void shouldThrowsAndExceptionWithNull() {
		
		assertThrows(NullPointerException.class, () -> {
			new Empty().execute(null);
		});
	}
	
	@Test
	public void shouldThrowsAnExceptionWhenTheTargetIsInvalid() {
		
		assertThrows(Exception.class, () -> {
			require(Arrays.asList(1), empty());
		});
	}
	
	@Test
	public void shouldReturnTrueWithValidTarget() {
		assertTrue(new Empty().execute(Arrays.asList()));
	}
	
	@Test
	public void shouldReturnFalseWithInvValidTarget() {
		assertFalse(new Empty().execute(Arrays.asList(2)));
	}		
}
