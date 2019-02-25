package test.org.jvalidation.matcher.list;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.jvalidation.Assertive.require;
import static org.jvalidation.Matchers.size;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.jvalidation.matcher.list.Size;

public class SizeTest {
	
	@Test
	public void shouldThrowsAndExceptionWithNull() {
		
		assertThrows(NullPointerException.class, () -> {
			new Size(2).execute(null);
		});
	}
	
	@Test
	public void shouldThrowAnExceptionWhenTheTargetIsInvalid() {
		
		assertThrows(Exception.class, () -> {
			require(Arrays.asList(1), size(2));
		});
	}
	
	@Test
	public void shouldReturnTrueWithValidTarget() {
		assertTrue(new Size(1).execute(Arrays.asList(1)));
	}
	
	@Test
	public void shouldReturnFalseWithInvValidTarget() {
		assertFalse(new Size(1).execute(Arrays.asList(2,2)));
	}	
}
