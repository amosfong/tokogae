/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;

import com.tokogae.data.event.model.Symptom;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for Symptom. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Amos Fong
 * @see SymptomServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface SymptomService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.tokogae.data.event.service.impl.SymptomServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the symptom remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link SymptomServiceUtil} if injection and service tracking are not available.
	 */
	public Symptom addSymptom(
			long subjectId, long occurDay, int occurDaySegment, long occurTime,
			String name, String affectedArea, Date startDate, Date endDate,
			int intensityLevel)
		throws PortalException;

	public Symptom deleteSymptom(long symptomId) throws PortalException;

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	public Symptom updateSymptom(
			long symptomId, long occurDay, int occurDaySegment, long occurTime,
			String name, String affectedArea, Date startDate, Date endDate,
			int intensityLevel)
		throws PortalException;

}