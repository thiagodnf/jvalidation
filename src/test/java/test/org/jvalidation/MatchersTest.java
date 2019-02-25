package test.org.jvalidation;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.Test;
import org.jvalidation.Matchers;

public class MatchersTest {
	
	@Test
	public void shouldThrowAnExceptionWhenInstantiateThisClass() {

		final Class<?> cls = Matchers.class;
		
		final Constructor<?> c = cls.getDeclaredConstructors()[0];
		
		c.setAccessible(true);

		assertThrows(InvocationTargetException.class, () -> {
			c.newInstance((Object[]) null);
		});
	}
}
