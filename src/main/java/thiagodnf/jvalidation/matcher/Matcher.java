package thiagodnf.jvalidation.matcher;

public abstract class Matcher {

	protected IllegalArgumentException getException(String message, Object... args) {
		return new IllegalArgumentException(String.format(message, args));
	}
}
