/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.account.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.module.service.Snapshot;

import com.tokogae.account.model.Subject;

import java.util.List;

/**
 * Provides the remote service utility for Subject. This utility wraps
 * <code>com.tokogae.account.service.impl.SubjectServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Amos Fong
 * @see SubjectService
 * @generated
 */
public class SubjectServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.tokogae.account.service.impl.SubjectServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Subject addSubject(
			String firstName, String lastName, String displayName, int gender,
			java.util.Date birthday)
		throws PortalException {

		return getService().addSubject(
			firstName, lastName, displayName, gender, birthday);
	}

	public static Subject deleteSubject(long subjectId) throws PortalException {
		return getService().deleteSubject(subjectId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static Subject getSubject(long subjectId) throws PortalException {
		return getService().getSubject(subjectId);
	}

	public static List<Subject> getSubjects(long userId, int start, int end) {
		return getService().getSubjects(userId, start, end);
	}

	public static int getSubjectsCount(long userId) {
		return getService().getSubjectsCount(userId);
	}

	public static Subject updateSubject(
			long subjectId, String firstName, String lastName,
			String displayName, int gender, java.util.Date birthday)
		throws PortalException {

		return getService().updateSubject(
			subjectId, firstName, lastName, displayName, gender, birthday);
	}

	public static SubjectService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<SubjectService> _serviceSnapshot =
		new Snapshot<>(SubjectServiceUtil.class, SubjectService.class);

}