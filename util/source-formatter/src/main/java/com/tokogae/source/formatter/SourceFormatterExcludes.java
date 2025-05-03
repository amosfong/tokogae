/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.source.formatter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Hugo Huijser
 */
public class SourceFormatterExcludes {

	public void addDefaultExcludeSyntaxPatterns(
		List<ExcludeSyntaxPattern> defaultExcludeSyntaxPatterns) {

		_defaultExcludeSyntaxPatterns.addAll(defaultExcludeSyntaxPatterns);
	}

	public void addExcludeSyntaxPatterns(
		String propertiesFileLocation,
		List<ExcludeSyntaxPattern> excludeSyntaxPatterns) {

		_excludeSyntaxPatternsMap.put(
			propertiesFileLocation, excludeSyntaxPatterns);
	}

	public Set<ExcludeSyntaxPattern> getDefaultExcludeSyntaxPatterns() {
		return _defaultExcludeSyntaxPatterns;
	}

	public Map<String, List<ExcludeSyntaxPattern>>
		getExcludeSyntaxPatternsMap() {

		return _excludeSyntaxPatternsMap;
	}

	private final Set<ExcludeSyntaxPattern> _defaultExcludeSyntaxPatterns =
		new HashSet<>();
	private final Map<String, List<ExcludeSyntaxPattern>>
		_excludeSyntaxPatternsMap = new HashMap<>();

}