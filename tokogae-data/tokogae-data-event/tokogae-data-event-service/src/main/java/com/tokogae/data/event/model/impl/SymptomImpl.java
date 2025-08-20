/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.model.impl;

import com.tokogae.constants.IntensityLevels;

/**
 * @author Amos Fong
 */
public class SymptomImpl extends SymptomBaseImpl {

	public String getIntensityLevelLabel() {
		return IntensityLevels.getLabel(getIntensityLevel());
	}

}