package test.org.jvalidation.matcher.object;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.jvalidation.Assertive.require;
import static org.jvalidation.Matchers.nullValue;

import org.junit.jupiter.api.Test;
import org.jvalidation.matcher.object.NullValue;

public class NullValueTest {
	
	@Test
	public void shouldReturnTrue() {
		assertTrue(new NullValue().execute(null));
	}
	
	@Test
	public void shouldReturnFalse() {
		assertFalse(new NullValue().execute(new Integer(2)));
	}
	
	@Test
	public void shouldThrowAnExceptionWhenTheTargetIsInvalid() {
		
		assertThrows(NullPointerException.class, () -> {
			require(new Integer(2), nullValue());
		});
	}
}
