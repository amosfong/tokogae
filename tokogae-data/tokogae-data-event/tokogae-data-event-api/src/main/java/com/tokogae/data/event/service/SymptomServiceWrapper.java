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

	@Override
	public com.tokogae.data.event.model.Symptom addSymptom(
			long subjectId, long phraseId, long occurDayBaseTime,
			long occurDayNativeTime, long duration, String name,
			String affectedArea, int intensityLevel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _symptomService.addSymptom(
			subjectId, phraseId, occurDayBaseTime, occurDayNativeTime, duration,
			name, affectedArea, intensityLevel);
	}

	@Override
	public com.tokogae.data.event.model.Symptom deleteSymptom(long symptomId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _symptomService.deleteSymptom(symptomId);
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
	public com.tokogae.data.event.model.Symptom updateSymptom(
			long symptomId, long occurDayBaseTime, long occurDayNativeTime,
			long duration, String name, String affectedArea, int intensityLevel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _symptomService.updateSymptom(
			symptomId, occurDayBaseTime, occurDayNativeTime, duration, name,
			affectedArea, intensityLevel);
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