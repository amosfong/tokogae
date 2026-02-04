/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SleepService}.
 *
 * @author Amos Fong
 * @see SleepService
 * @generated
 */
public class SleepServiceWrapper
	implements ServiceWrapper<SleepService>, SleepService {

	public SleepServiceWrapper() {
		this(null);
	}

	public SleepServiceWrapper(SleepService sleepService) {
		_sleepService = sleepService;
	}

	@Override
	public com.tokogae.data.event.model.Sleep addSleep(
			long subjectId, long phraseId, long occurDayBaseTime,
			long occurDayNativeTime, long duration)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sleepService.addSleep(
			subjectId, phraseId, occurDayBaseTime, occurDayNativeTime,
			duration);
	}

	@Override
	public com.tokogae.data.event.model.Sleep deleteSleep(long sleepId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sleepService.deleteSleep(sleepId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _sleepService.getOSGiServiceIdentifier();
	}

	@Override
	public com.tokogae.data.event.model.Sleep updateSleep(
			long sleepId, long occurDayBaseTime, long occurDayNativeTime,
			long duration)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sleepService.updateSleep(
			sleepId, occurDayBaseTime, occurDayNativeTime, duration);
	}

	@Override
	public SleepService getWrappedService() {
		return _sleepService;
	}

	@Override
	public void setWrappedService(SleepService sleepService) {
		_sleepService = sleepService;
	}

	private SleepService _sleepService;

}