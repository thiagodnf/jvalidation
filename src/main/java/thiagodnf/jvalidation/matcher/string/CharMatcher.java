package thiagodnf.jvalidation.matcher.string;

import thiagodnf.jvalidation.matcher.Matcher;

public class CharMatcher extends Matcher {

	protected char target;

	public CharMatcher(char target) {
		this.target = target;
	}

	public CharMatcher vowel() {

		if ("AEIOUaeiou".indexOf(target) != -1) {
			return this;
		}

		throw getException("Expected a vowel char but it was %s", target);
	}

	public CharMatcher consonant() {

		if ("AEIOUaeiou".indexOf(target) == -1) {
			return this;
		}

		throw getException("Expected a consonant char but it was %s", target);
	}
}
