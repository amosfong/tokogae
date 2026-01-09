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

	public static final long EARLY_MORNING_TIME = 1;

	public static int MORNING = 3;

	public static final long MORNING_TIME = 28800000;

	public static int NIGHT = 4;

	public static final long NIGHT_TIME = 86400000;

	public static int NONE = -1;

	public static int[] VALUES = {EARLY_MORNING, MORNING, AFTERNOON, NIGHT};

	public static int getDaySegment(long dayNativeTime) {
		if (dayNativeTime < MORNING_TIME) {
			return EARLY_MORNING;
		}

		if ((dayNativeTime >= MORNING_TIME) &&
			(dayNativeTime < AFTERNOON_TIME)) {

			return MORNING;
		}

		if ((dayNativeTime >= AFTERNOON_TIME) && (dayNativeTime < NIGHT_TIME)) {
			return AFTERNOON;
		}

		return NIGHT;
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

	public static long getNativeTime(int daySegment) {
		if (daySegment == AFTERNOON) {
			return AFTERNOON_TIME * -1;
		}
		else if (daySegment == EARLY_MORNING) {
			return EARLY_MORNING_TIME * -1;
		}
		else if (daySegment == MORNING) {
			return MORNING_TIME * -1;
		}
		else if (daySegment == NIGHT) {
			return NIGHT_TIME * -1;
		}

		return 0;
	}

	public static boolean isDaySegment(int daySegment, long dayNativeTime) {
		if (daySegment == EARLY_MORNING) {
			if (dayNativeTime < MORNING_TIME) {
				return true;
			}
		}
		else if (daySegment == MORNING) {
			if ((dayNativeTime >= MORNING_TIME) &&
				(dayNativeTime < AFTERNOON_TIME)) {

				return true;
			}
		}
		else if (daySegment == AFTERNOON) {
			if ((dayNativeTime >= AFTERNOON_TIME) &&
				(dayNativeTime < NIGHT_TIME)) {

				return true;
			}
		}
		else if (daySegment == NIGHT) {
			if (dayNativeTime >= NIGHT_TIME) {
				return true;
			}
		}

		return false;
	}

}