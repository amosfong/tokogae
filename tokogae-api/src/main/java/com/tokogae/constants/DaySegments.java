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

	public static long getDayTime(int daySegment) {
		if (daySegment == AFTERNOON) {
			return 57600000;
		}
		else if (daySegment == EARLY_MORNING) {
			return 0;
		}
		else if (daySegment == MORNING) {
			return 28800000;
		}
		else if (daySegment == NIGHT) {
			return 86400000;
		}

		return 0;
	}

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