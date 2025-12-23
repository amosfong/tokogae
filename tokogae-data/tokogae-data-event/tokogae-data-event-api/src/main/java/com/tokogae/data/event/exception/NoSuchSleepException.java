/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Amos Fong
 */
public class NoSuchSleepException extends NoSuchModelException {

	public NoSuchSleepException() {
	}

	public NoSuchSleepException(String msg) {
		super(msg);
	}

	public NoSuchSleepException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchSleepException(Throwable throwable) {
		super(throwable);
	}

}