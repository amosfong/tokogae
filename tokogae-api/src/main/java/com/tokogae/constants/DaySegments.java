/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.constants;

/**
 * @author Amos Fong
 */
public interface DaySegments {

	public static int AFTERNOON = 1;

	public static int EARLY_MORNING = 2;

	public static int MORNING = 3;

	public static int NIGHT = 4;

	public static int[] VALUES = {AFTERNOON, EARLY_MORNING, MORNING, NIGHT};

	public static String getLabel(int daySegment) {
		if (daySegment == AFTERNOON) {
			return "afternoon";
		}
		else if (daySegment == EARLY_MORNING) {
			return "early-morning";
		}
		else if (daySegment == MORNING) {
			return "morning";
		}
		else if (daySegment == NIGHT) {
			return "night";
		}

		return "";
	}

}