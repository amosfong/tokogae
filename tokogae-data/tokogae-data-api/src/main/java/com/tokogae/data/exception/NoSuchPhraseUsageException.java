/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Amos Fong
 */
public class NoSuchPhraseUsageException extends NoSuchModelException {

	public NoSuchPhraseUsageException() {
	}

	public NoSuchPhraseUsageException(String msg) {
		super(msg);
	}

	public NoSuchPhraseUsageException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchPhraseUsageException(Throwable throwable) {
		super(throwable);
	}

}