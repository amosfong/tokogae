/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.source.formatter;

import com.liferay.portal.kernel.util.ListUtil;

import com.tokogae.source.formatter.check.CopyrightCheck;
import com.tokogae.source.formatter.util.FileUtil;
import com.tokogae.source.formatter.util.SourceFormatterUtil;

import java.util.List;

/**
 * @author Amos Fong
 */
public class SourceFormatter {

	public static void main(String[] args) throws Exception {
		try {
			SourceFormatter sourceFormatter = new SourceFormatter("./");

			sourceFormatter.format();
		}
		catch (Exception exception) {
			exception.printStackTrace();

			System.exit(1);
		}
	}

	public SourceFormatter(String baseDirName) {
		_baseDirName = baseDirName;
	}

	public void format() throws Exception {
		_init();

		CopyrightCheck copyrightCheck = new CopyrightCheck(_baseDirName);

		for (String fileName : _allFileNames) {
			String content = FileUtil.read(fileName);

			String newContent = copyrightCheck.check(fileName, content);

			if (!newContent.equals(content)) {
				System.out.println("Updated: " + fileName);

				FileUtil.write(fileName, newContent);
			}
		}
	}

	private void _init() throws Exception {
		_sourceFormatterExcludes.addDefaultExcludeSyntaxPatterns(
			ListUtil.fromArray(
				new ExcludeSyntaxPattern(ExcludeSyntax.GLOB, "**/.git/**"),
				new ExcludeSyntaxPattern(ExcludeSyntax.GLOB, "**/.gradle/**"),
				new ExcludeSyntaxPattern(ExcludeSyntax.GLOB, "**/.idea/**"),
				new ExcludeSyntaxPattern(ExcludeSyntax.GLOB, "**/.m2/**"),
				new ExcludeSyntaxPattern(ExcludeSyntax.GLOB, "**/.settings/**"),
				new ExcludeSyntaxPattern(ExcludeSyntax.GLOB, "**/bin/**"),
				new ExcludeSyntaxPattern(ExcludeSyntax.GLOB, "**/classes/**"),
				new ExcludeSyntaxPattern(
					ExcludeSyntax.GLOB, "**/liferay-theme.json"),
				new ExcludeSyntaxPattern(
					ExcludeSyntax.GLOB, "**/npm-shrinkwrap.json"),
				new ExcludeSyntaxPattern(
					ExcludeSyntax.GLOB, "**/package-lock.json"),
				new ExcludeSyntaxPattern(
					ExcludeSyntax.GLOB, "**/test-classes/**"),
				new ExcludeSyntaxPattern(
					ExcludeSyntax.GLOB, "**/test-coverage/**"),
				new ExcludeSyntaxPattern(
					ExcludeSyntax.GLOB, "**/test-results/**"),
				new ExcludeSyntaxPattern(ExcludeSyntax.GLOB, "**/tmp/**"),
				new ExcludeSyntaxPattern(
					ExcludeSyntax.GLOB, "**/node_modules_cache/**"),
				new ExcludeSyntaxPattern(
					ExcludeSyntax.REGEX,
					".*/frontend-theme-unstyled/.*/_unstyled/css/clay/.+"),
				new ExcludeSyntaxPattern(
					ExcludeSyntax.REGEX,
					".*/frontend-theme-unstyled/.*/_unstyled/images/(aui|" +
						"clay|lexicon)/.+"),
				new ExcludeSyntaxPattern(
					ExcludeSyntax.REGEX,
					".*/tests?/.*/?dependencies/.+\\.(jar|lar|war|zip)/.+"),
				new ExcludeSyntaxPattern(
					ExcludeSyntax.REGEX,
					"^((?!/frontend-js-node-shims/src/).)*/node_modules/.*"),
				new ExcludeSyntaxPattern(
					ExcludeSyntax.REGEX, "^((?!/src/).)*/build/.*")));

		_allFileNames = SourceFormatterUtil.scanForFileNames(
			_baseDirName, new String[0], new String[] {"**/*.java"},
			_sourceFormatterExcludes);
	}

	private List<String> _allFileNames;
	private String _baseDirName;
	private final SourceFormatterExcludes _sourceFormatterExcludes =
		new SourceFormatterExcludes();

}