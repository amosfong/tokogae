/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Amos Fong
 */
public class NoSuchPhraseException extends NoSuchModelException {

	public NoSuchPhraseException() {
	}

	public NoSuchPhraseException(String msg) {
		super(msg);
	}

	public NoSuchPhraseException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchPhraseException(Throwable throwable) {
		super(throwable);
	}

}