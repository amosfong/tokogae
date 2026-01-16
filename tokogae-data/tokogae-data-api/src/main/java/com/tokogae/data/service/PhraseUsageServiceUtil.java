/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.service;

import com.liferay.portal.kernel.module.service.Snapshot;

/**
 * Provides the remote service utility for PhraseUsage. This utility wraps
 * <code>com.tokogae.data.service.impl.PhraseUsageServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Amos Fong
 * @see PhraseUsageService
 * @generated
 */
public class PhraseUsageServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.tokogae.data.service.impl.PhraseUsageServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static PhraseUsageService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<PhraseUsageService> _serviceSnapshot =
		new Snapshot<>(PhraseUsageServiceUtil.class, PhraseUsageService.class);

}