/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Amos Fong
 */
public class NoSuchExerciseException extends NoSuchModelException {

	public NoSuchExerciseException() {
	}

	public NoSuchExerciseException(String msg) {
		super(msg);
	}

	public NoSuchExerciseException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchExerciseException(Throwable throwable) {
		super(throwable);
	}

}