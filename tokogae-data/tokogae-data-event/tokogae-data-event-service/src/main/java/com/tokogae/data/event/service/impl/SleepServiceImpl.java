/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;

import com.tokogae.account.permission.SubjectPermission;
import com.tokogae.data.event.model.Sleep;
import com.tokogae.data.event.service.base.SleepServiceBaseImpl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Amos Fong
 */
@Component(
	property = {
		"json.web.service.context.name=tokogaedata",
		"json.web.service.context.path=Sleep"
	},
	service = AopService.class
)
public class SleepServiceImpl extends SleepServiceBaseImpl {

	public Sleep addSleep(
			long subjectId, long phraseId, long occurDayBaseTime,
			long occurDayNativeTime, long duration)
		throws PortalException {

		_subjectPermission.check(
			getPermissionChecker(), subjectId, ActionKeys.UPDATE);

		return sleepLocalService.addSleep(
			getUserId(), subjectId, phraseId, occurDayBaseTime,
			occurDayNativeTime, duration);
	}

	@Override
	public Sleep deleteSleep(long sleepId) throws PortalException {
		Sleep sleep = sleepLocalService.getSleep(sleepId);

		_subjectPermission.check(
			getPermissionChecker(), sleep.getSubjectId(), ActionKeys.UPDATE);

		return sleepLocalService.deleteSleep(sleepId);
	}

	public Sleep updateSleep(
			long sleepId, long occurDayBaseTime, long occurDayNativeTime,
			long duration)
		throws PortalException {

		Sleep sleep = sleepLocalService.getSleep(sleepId);

		_subjectPermission.check(
			getPermissionChecker(), sleep.getSubjectId(), ActionKeys.UPDATE);

		return sleepLocalService.updateSleep(
			sleepId, occurDayBaseTime, occurDayNativeTime, duration);
	}

	@Reference
	private SubjectPermission _subjectPermission;

}