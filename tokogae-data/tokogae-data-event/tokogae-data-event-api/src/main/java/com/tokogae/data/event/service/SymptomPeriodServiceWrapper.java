/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SymptomPeriodService}.
 *
 * @author Amos Fong
 * @see SymptomPeriodService
 * @generated
 */
public class SymptomPeriodServiceWrapper
	implements ServiceWrapper<SymptomPeriodService>, SymptomPeriodService {

	public SymptomPeriodServiceWrapper() {
		this(null);
	}

	public SymptomPeriodServiceWrapper(
		SymptomPeriodService symptomPeriodService) {

		_symptomPeriodService = symptomPeriodService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _symptomPeriodService.getOSGiServiceIdentifier();
	}

	@Override
	public SymptomPeriodService getWrappedService() {
		return _symptomPeriodService;
	}

	@Override
	public void setWrappedService(SymptomPeriodService symptomPeriodService) {
		_symptomPeriodService = symptomPeriodService;
	}

	private SymptomPeriodService _symptomPeriodService;

}