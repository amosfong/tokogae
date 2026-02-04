/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.module.service.Snapshot;

import com.tokogae.data.event.model.Exercise;

/**
 * Provides the remote service utility for Exercise. This utility wraps
 * <code>com.tokogae.data.event.service.impl.ExerciseServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Amos Fong
 * @see ExerciseService
 * @generated
 */
public class ExerciseServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.tokogae.data.event.service.impl.ExerciseServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Exercise addExercise(
			long subjectId, long phraseId, long occurDayBaseTime,
			long occurDayNativeTime, String name, long duration,
			double quantity, String quantityUnit)
		throws PortalException {

		return getService().addExercise(
			subjectId, phraseId, occurDayBaseTime, occurDayNativeTime, name,
			duration, quantity, quantityUnit);
	}

	public static Exercise deleteExercise(long exerciseId)
		throws PortalException {

		return getService().deleteExercise(exerciseId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static Exercise updateExercise(
			long exerciseId, long occurDayBaseTime, long occurDayNativeTime,
			String name, long duration, double quantity, String quantityUnit)
		throws PortalException {

		return getService().updateExercise(
			exerciseId, occurDayBaseTime, occurDayNativeTime, name, duration,
			quantity, quantityUnit);
	}

	public static ExerciseService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<ExerciseService> _serviceSnapshot =
		new Snapshot<>(ExerciseServiceUtil.class, ExerciseService.class);

}