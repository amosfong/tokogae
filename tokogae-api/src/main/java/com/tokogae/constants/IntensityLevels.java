/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.constants;

/**
 * @author Amos Fong
 */
public interface IntensityLevels {

	public static int MAJOR = 2;

	public static int MILD = 3;

	public static int MODERATE = 4;

	public static int NONE = 0;

	public static int SEVERE = 1;

	public static int[] VALUES = {
		NONE, MILD, MODERATE, MAJOR, SEVERE, IntensityLevels.VERY_SEVERE
	};

	public static int VERY_SEVERE = 5;

	public static String getLabel(int intensityLevel) {
		if (intensityLevel == MAJOR) {
			return "major";
		}
		else if (intensityLevel == MILD) {
			return "mild";
		}
		else if (intensityLevel == MODERATE) {
			return "moderate";
		}
		else if (intensityLevel == NONE) {
			return "none";
		}
		else if (intensityLevel == SEVERE) {
			return "severe";
		}
		else if (intensityLevel == VERY_SEVERE) {
			return "very-severe";
		}

		return "";
	}

}