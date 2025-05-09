/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SymptomService}.
 *
 * @author Amos Fong
 * @see SymptomService
 * @generated
 */
public class SymptomServiceWrapper
	implements ServiceWrapper<SymptomService>, SymptomService {

	public SymptomServiceWrapper() {
		this(null);
	}

	public SymptomServiceWrapper(SymptomService symptomService) {
		_symptomService = symptomService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _symptomService.getOSGiServiceIdentifier();
	}

	@Override
	public SymptomService getWrappedService() {
		return _symptomService;
	}

	@Override
	public void setWrappedService(SymptomService symptomService) {
		_symptomService = symptomService;
	}

	private SymptomService _symptomService;

}