/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */
package com.tokogae.account.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Amos Fong
 */
public class NoSuchSubjectException extends NoSuchModelException {

	public NoSuchSubjectException() {
	}

	public NoSuchSubjectException(String msg) {
		super(msg);
	}

	public NoSuchSubjectException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchSubjectException(Throwable throwable) {
		super(throwable);
	}

}