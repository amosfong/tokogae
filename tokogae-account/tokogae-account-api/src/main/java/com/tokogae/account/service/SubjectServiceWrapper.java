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
	public SubjectService getWrappedService() {
		return _subjectService;
	}

	@Override
	public void setWrappedService(SubjectService subjectService) {
		_subjectService = subjectService;
	}

	private SubjectService _subjectService;

}