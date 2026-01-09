/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;

import com.tokogae.data.event.model.Exercise;
import com.tokogae.data.event.service.base.ExerciseServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Amos Fong
 */
@Component(
	property = {
		"json.web.service.context.name=tokogae_data",
		"json.web.service.context.path=Exercise"
	},
	service = AopService.class
)
public class ExerciseServiceImpl extends ExerciseServiceBaseImpl {

	public Exercise addExercise(
			long subjectId, long occurDayBaseTime, long occurDayNativeTime,
			String name, long duration, double quantity, String quantityUnit)
		throws PortalException {

		return exerciseLocalService.addExercise(
			getUserId(), subjectId, occurDayBaseTime, occurDayNativeTime, name,
			duration, quantity, quantityUnit);
	}

	public Exercise deleteExercise(long exerciseId) throws PortalException {
		return exerciseLocalService.deleteExercise(exerciseId);
	}

	public Exercise updateExercise(
			long exerciseId, long occurDayBaseTime, long occurDayNativeTime,
			String name, long duration, double quantity, String quantityUnit)
		throws PortalException {

		return exerciseLocalService.updateExercise(
			exerciseId, occurDayBaseTime, occurDayNativeTime, name, duration,
			quantity, quantityUnit);
	}

}