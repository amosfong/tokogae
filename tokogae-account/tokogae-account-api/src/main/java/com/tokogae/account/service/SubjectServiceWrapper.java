/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.account.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SubjectService}.
 *
 * @author Amos Fong
 * @see SubjectService
 * @generated
 */
public class SubjectServiceWrapper
	implements ServiceWrapper<SubjectService>, SubjectService {

	public SubjectServiceWrapper() {
		this(null);
	}

	public SubjectServiceWrapper(SubjectService subjectService) {
		_subjectService = subjectService;
	}

	@Override
	public com.tokogae.account.model.Subject addSubject(
			String firstName, String lastName, String displayName, int gender,
			java.util.Date birthday)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subjectService.addSubject(
			firstName, lastName, displayName, gender, birthday);
	}

	@Override
	public com.tokogae.account.model.Subject deleteSubject(long subjectId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subjectService.deleteSubject(subjectId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _subjectService.getOSGiServiceIdentifier();
	}

	@Override
	public com.tokogae.account.model.Subject getSubject(long subjectId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subjectService.getSubject(subjectId);
	}

	@Override
	public java.util.List<com.tokogae.account.model.Subject> getSubjects(
		long userId, int start, int end) {

		return _subjectService.getSubjects(userId, start, end);
	}

	@Override
	public int getSubjectsCount(long userId) {
		return _subjectService.getSubjectsCount(userId);
	}

	@Override
	public com.tokogae.account.model.Subject updateSubject(
			long subjectId, String firstName, String lastName,
			String displayName, int gender, java.util.Date birthday)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subjectService.updateSubject(
			subjectId, firstName, lastName, displayName, gender, birthday);
	}

	@Override
	public SubjectService getWrappedService() {
		return _subjectService;
	}

	@Override
	public void setWrappedService(SubjectService subjectService) {
		_subjectService = subjectService;
	}

	private SubjectService _subjectService;

}