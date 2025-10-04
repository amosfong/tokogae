/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.constants;

/**
 * @author Amos Fong
 */
public interface DaySegments {

	public static int AFTERNOON = 1;

	public static final long AFTERNOON_TIME = 57600000;

	public static int EARLY_MORNING = 2;

	public static final long EARLY_MORNING_TIME = 0;

	public static int MORNING = 3;

	public static final long MORNING_TIME = 28800000;

	public static int NIGHT = 4;

	public static final long NIGHT_TIME = 86400000;

	public static int NONE = -1;

	public static int[] VALUES = {EARLY_MORNING, MORNING, AFTERNOON, NIGHT};

	public static int getDaySegment(long dayTime) {
		if (dayTime < MORNING_TIME) {
			return EARLY_MORNING;
		}

		if ((dayTime >= MORNING_TIME) && (dayTime < AFTERNOON_TIME)) {
			return MORNING;
		}

		if ((dayTime >= AFTERNOON_TIME) && (dayTime < NIGHT_TIME)) {
			return AFTERNOON;
		}

		return NIGHT;
	}

	public static long getDayTime(int daySegment) {
		if (daySegment == AFTERNOON) {
			return AFTERNOON_TIME;
		}
		else if (daySegment == EARLY_MORNING) {
			return EARLY_MORNING_TIME;
		}
		else if (daySegment == MORNING) {
			return MORNING_TIME;
		}
		else if (daySegment == NIGHT) {
			return NIGHT_TIME;
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

	public static boolean isDaySegment(int daySegment, long dayTime) {
		if (daySegment == EARLY_MORNING) {
			if (dayTime < MORNING_TIME) {
				return true;
			}
		}
		else if (daySegment == MORNING) {
			if ((dayTime >= MORNING_TIME) && (dayTime < AFTERNOON_TIME)) {
				return true;
			}
		}
		else if (daySegment == AFTERNOON) {
			if ((dayTime >= AFTERNOON_TIME) && (dayTime < NIGHT_TIME)) {
				return true;
			}
		}
		else if (daySegment == NIGHT) {
			if (dayTime >= NIGHT_TIME) {
				return true;
			}
		}

		return false;
	}

}