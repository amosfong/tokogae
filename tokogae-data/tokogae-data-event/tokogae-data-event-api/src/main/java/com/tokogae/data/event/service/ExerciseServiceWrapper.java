/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ExerciseService}.
 *
 * @author Amos Fong
 * @see ExerciseService
 * @generated
 */
public class ExerciseServiceWrapper
	implements ExerciseService, ServiceWrapper<ExerciseService> {

	public ExerciseServiceWrapper() {
		this(null);
	}

	public ExerciseServiceWrapper(ExerciseService exerciseService) {
		_exerciseService = exerciseService;
	}

	@Override
	public com.tokogae.data.event.model.Exercise addExercise(
			long subjectId, long occurDay, int occurDaySegment, long occurTime,
			String name, long duration, double quantity, String quantityUnit)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _exerciseService.addExercise(
			subjectId, occurDay, occurDaySegment, occurTime, name, duration,
			quantity, quantityUnit);
	}

	@Override
	public com.tokogae.data.event.model.Exercise deleteExercise(long exerciseId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _exerciseService.deleteExercise(exerciseId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _exerciseService.getOSGiServiceIdentifier();
	}

	@Override
	public com.tokogae.data.event.model.Exercise updateExercise(
			long exerciseId, long occurDay, int occurDaySegment, long occurTime,
			String name, long duration, double quantity, String quantityUnit)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _exerciseService.updateExercise(
			exerciseId, occurDay, occurDaySegment, occurTime, name, duration,
			quantity, quantityUnit);
	}

	@Override
	public ExerciseService getWrappedService() {
		return _exerciseService;
	}

	@Override
	public void setWrappedService(ExerciseService exerciseService) {
		_exerciseService = exerciseService;
	}

	private ExerciseService _exerciseService;

}