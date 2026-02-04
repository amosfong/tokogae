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

import com.tokogae.data.event.model.Exercise;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for Exercise. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Amos Fong
 * @see ExerciseServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ExerciseService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.tokogae.data.event.service.impl.ExerciseServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the exercise remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link ExerciseServiceUtil} if injection and service tracking are not available.
	 */
	public Exercise addExercise(
			long subjectId, long phraseId, long occurDayBaseTime,
			long occurDayNativeTime, String name, long duration,
			double quantity, String quantityUnit)
		throws PortalException;

	public Exercise deleteExercise(long exerciseId) throws PortalException;

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	public Exercise updateExercise(
			long exerciseId, long occurDayBaseTime, long occurDayNativeTime,
			String name, long duration, double quantity, String quantityUnit)
		throws PortalException;

}