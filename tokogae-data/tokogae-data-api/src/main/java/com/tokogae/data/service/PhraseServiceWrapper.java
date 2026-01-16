/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PhraseService}.
 *
 * @author Amos Fong
 * @see PhraseService
 * @generated
 */
public class PhraseServiceWrapper
	implements PhraseService, ServiceWrapper<PhraseService> {

	public PhraseServiceWrapper() {
		this(null);
	}

	public PhraseServiceWrapper(PhraseService phraseService) {
		_phraseService = phraseService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _phraseService.getOSGiServiceIdentifier();
	}

	@Override
	public PhraseService getWrappedService() {
		return _phraseService;
	}

	@Override
	public void setWrappedService(PhraseService phraseService) {
		_phraseService = phraseService;
	}

	private PhraseService _phraseService;

}