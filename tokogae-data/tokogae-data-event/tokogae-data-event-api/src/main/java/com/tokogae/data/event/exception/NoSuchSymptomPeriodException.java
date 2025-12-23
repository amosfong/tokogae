/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Amos Fong
 */
public class NoSuchSymptomPeriodException extends NoSuchModelException {

	public NoSuchSymptomPeriodException() {
	}

	public NoSuchSymptomPeriodException(String msg) {
		super(msg);
	}

	public NoSuchSymptomPeriodException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchSymptomPeriodException(Throwable throwable) {
		super(throwable);
	}

}