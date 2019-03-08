package test.org.jvalidation.matcher.object;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.jvalidation.matcher.object.ObjectMatcher;

public class ObjectMatcherTest {
	
	@Test
	public void shouldThrowAnException() {

		assertThrows(IllegalArgumentException.class, () -> {
			new ObjectMatcher(2).nullValue();
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new ObjectMatcher(null).not().nullValue();
		});
		
	}
	
	@Test
	public void shouldNotThrowAnException() {
		new ObjectMatcher(null).nullValue();
		new ObjectMatcher(2).not().nullValue();
	}
}
