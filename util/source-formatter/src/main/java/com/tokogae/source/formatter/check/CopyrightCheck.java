/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.source.formatter.check;

import com.tokogae.source.formatter.util.FileUtil;

/**
 * @author Amos Fong
 */
public class CopyrightCheck {

	public CopyrightCheck(String baseDir) {
		_copyrightTxt = FileUtil.read(baseDir + "/copyright.txt");
	}

	public String check(String fileName, String content) throws Exception {
		int x = content.indexOf("/**\n * SPDX");

		if (x == -1) {
			System.out.println("Missing copyright: " + fileName);

			return content;
		}

		int y = content.indexOf("*/", 2);

		String copyright = content.substring(0, y);

		if (!copyright.equals(_copyrightTxt)) {
			return _copyrightTxt + content.substring(y + 2);
		}

		return content;
	}

	private final String _copyrightTxt;

}