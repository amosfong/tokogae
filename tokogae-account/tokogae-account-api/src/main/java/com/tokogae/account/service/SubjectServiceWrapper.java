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
	public java.util.List<com.tokogae.account.model.Subject> getSubjects(
		long userId, int start, int end) {

		return _subjectService.getSubjects(userId, start, end);
	}

	@Override
	public int getSubjectsCount(long userId) {
		return _subjectService.getSubjectsCount(userId);
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