/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.module.service.Snapshot;

import com.tokogae.data.event.model.Symptom;

/**
 * Provides the remote service utility for Symptom. This utility wraps
 * <code>com.tokogae.data.event.service.impl.SymptomServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Amos Fong
 * @see SymptomService
 * @generated
 */
public class SymptomServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.tokogae.data.event.service.impl.SymptomServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Symptom addSymptom(
			long subjectId, long occurDayBaseTime, long occurDayNativeTime,
			long duration, String name, String affectedArea, int intensityLevel)
		throws PortalException {

		return getService().addSymptom(
			subjectId, occurDayBaseTime, occurDayNativeTime, duration, name,
			affectedArea, intensityLevel);
	}

	public static Symptom deleteSymptom(long symptomId) throws PortalException {
		return getService().deleteSymptom(symptomId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static Symptom updateSymptom(
			long symptomId, long occurDayBaseTime, long occurDayNativeTime,
			long duration, String name, String affectedArea, int intensityLevel)
		throws PortalException {

		return getService().updateSymptom(
			symptomId, occurDayBaseTime, occurDayNativeTime, duration, name,
			affectedArea, intensityLevel);
	}

	public static SymptomService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<SymptomService> _serviceSnapshot =
		new Snapshot<>(SymptomServiceUtil.class, SymptomService.class);

}