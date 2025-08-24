/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.model.impl;

import org.apache.commons.math3.fraction.Fraction;

/**
 * @author Amos Fong
 */
public class ExerciseImpl extends ExerciseBaseImpl {

	public String getQuantityLabel() {
		Fraction fraction = new Fraction(getQuantity());

		return fraction.toString();
	}

}