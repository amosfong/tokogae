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
	public ExerciseService getWrappedService() {
		return _exerciseService;
	}

	@Override
	public void setWrappedService(ExerciseService exerciseService) {
		_exerciseService = exerciseService;
	}

	private ExerciseService _exerciseService;

}