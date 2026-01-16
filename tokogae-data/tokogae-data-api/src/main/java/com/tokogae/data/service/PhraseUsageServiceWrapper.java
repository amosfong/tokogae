/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PhraseUsageService}.
 *
 * @author Amos Fong
 * @see PhraseUsageService
 * @generated
 */
public class PhraseUsageServiceWrapper
	implements PhraseUsageService, ServiceWrapper<PhraseUsageService> {

	public PhraseUsageServiceWrapper() {
		this(null);
	}

	public PhraseUsageServiceWrapper(PhraseUsageService phraseUsageService) {
		_phraseUsageService = phraseUsageService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _phraseUsageService.getOSGiServiceIdentifier();
	}

	@Override
	public PhraseUsageService getWrappedService() {
		return _phraseUsageService;
	}

	@Override
	public void setWrappedService(PhraseUsageService phraseUsageService) {
		_phraseUsageService = phraseUsageService;
	}

	private PhraseUsageService _phraseUsageService;

}