/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.module.service.Snapshot;

import com.tokogae.data.event.model.Sleep;

/**
 * Provides the remote service utility for Sleep. This utility wraps
 * <code>com.tokogae.data.event.service.impl.SleepServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Amos Fong
 * @see SleepService
 * @generated
 */
public class SleepServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.tokogae.data.event.service.impl.SleepServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Sleep addSleep(
			long subjectId, long occurDay, int occurDaySegment, long occurTime,
			long duration)
		throws PortalException {

		return getService().addSleep(
			subjectId, occurDay, occurDaySegment, occurTime, duration);
	}

	public static Sleep deleteSleep(long sleepId) throws PortalException {
		return getService().deleteSleep(sleepId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static Sleep updateSleep(
			long sleepId, long occurDay, int occurDaySegment, long occurTime,
			long duration)
		throws PortalException {

		return getService().updateSleep(
			sleepId, occurDay, occurDaySegment, occurTime, duration);
	}

	public static SleepService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<SleepService> _serviceSnapshot =
		new Snapshot<>(SleepServiceUtil.class, SleepService.class);

}