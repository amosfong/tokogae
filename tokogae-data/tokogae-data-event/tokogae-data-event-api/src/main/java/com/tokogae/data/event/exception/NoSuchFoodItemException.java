/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */
package com.tokogae.data.event.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Amos Fong
 */
public class NoSuchFoodItemException extends NoSuchModelException {

	public NoSuchFoodItemException() {
	}

	public NoSuchFoodItemException(String msg) {
		super(msg);
	}

	public NoSuchFoodItemException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchFoodItemException(Throwable throwable) {
		super(throwable);
	}

}