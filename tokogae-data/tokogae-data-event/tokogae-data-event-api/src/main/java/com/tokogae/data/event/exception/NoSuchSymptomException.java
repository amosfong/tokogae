/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */
package com.tokogae.data.event.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Amos Fong
 */
public class NoSuchSymptomException extends NoSuchModelException {

	public NoSuchSymptomException() {
	}

	public NoSuchSymptomException(String msg) {
		super(msg);
	}

	public NoSuchSymptomException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchSymptomException(Throwable throwable) {
		super(throwable);
	}

}