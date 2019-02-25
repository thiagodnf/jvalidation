package test.org.jvalidation.matcher.list;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.jvalidation.Assertive.require;
import static org.jvalidation.Matchers.emptyList;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.jvalidation.matcher.list.EmptyList;

public class EmptyListTest {
	
	@Test
	public void shouldThrowsAndExceptionWithNull() {
		
		assertThrows(NullPointerException.class, () -> {
			new EmptyList().execute(null);
		});
	}
	
	@Test
	public void shouldThrowsAnExceptionWhenTheTargetIsInvalid() {
		
		assertThrows(Exception.class, () -> {
			require(Arrays.asList(1), emptyList());
		});
	}
	
	@Test
	public void shouldReturnTrueWithValidTarget() {
		assertTrue(new EmptyList().execute(Arrays.asList()));
	}
	
	@Test
	public void shouldReturnFalseWithInvValidTarget() {
		assertFalse(new EmptyList().execute(Arrays.asList(2)));
	}		
}
