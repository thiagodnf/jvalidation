package test.org.jvalidation;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.jvalidation.Assertive;

public class AssertiveTest {
	
	@Test
	public void shouldThrowAnException() {

		assertThrows(IllegalArgumentException.class, () -> {
			new Assertive(2.0).isInteger();
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Assertive(2).isDouble();
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Assertive("It is not a integer").isInteger();
		});
	}
	
	@Test
	public void shouldReturnANotNullObject() {
		assertNotNull(new Assertive(2).isInteger());
		assertNotNull(new Assertive(null).isObject());
		assertNotNull(new Assertive(2.0).isDouble());
	}
}
