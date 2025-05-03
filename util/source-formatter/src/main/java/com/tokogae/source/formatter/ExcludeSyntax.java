/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.source.formatter;

/**
 * @author Peter Shin
 */
public enum ExcludeSyntax {

	GLOB("glob"), REGEX("regex");

	public static ExcludeSyntax parse(String value) {
		String globValue = GLOB.getValue();

		if (globValue.equals(value)) {
			return GLOB;
		}

		String regexValue = REGEX.getValue();

		if (regexValue.equals(value)) {
			return REGEX;
		}

		throw new IllegalArgumentException("Invalid value " + value);
	}

	public String getValue() {
		return _value;
	}

	@Override
	public String toString() {
		return _value;
	}

	private ExcludeSyntax(String value) {
		_value = value;
	}

	private final String _value;

}