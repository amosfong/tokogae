/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.web.internal.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import com.tokogae.data.event.exception.NoSuchSleepException;
import com.tokogae.data.event.service.SleepService;
import com.tokogae.web.internal.constants.TokogaePortletKeys;

import jakarta.portlet.ActionRequest;
import jakarta.portlet.ActionResponse;

import java.text.DateFormat;

import java.util.Date;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Amos Fong
 */
@Component(
	property = {
		"jakarta.portlet.name=" + TokogaePortletKeys.TOKOGAE,
		"mvc.command.name=/tokogae/edit_sleep"
	},
	service = MVCActionCommand.class
)
public class EditSleepMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
			if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
				_updateSleep(actionRequest);
			}
		}
		catch (NoSuchSleepException noSuchSleepException) {
			SessionErrors.add(actionRequest, noSuchSleepException.getClass());
		}
	}

	private void _updateSleep(ActionRequest actionRequest) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		DateFormat dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd", themeDisplay.getTimeZone());

		long sleepId = ParamUtil.getLong(actionRequest, "sleepId");

		Date occurDayDate = ParamUtil.getDate(
			actionRequest, "occurDay", dateFormat, null);
		int occurDaySegment = ParamUtil.getInteger(
			actionRequest, "occurDaySegment");
		long occurTime = ParamUtil.getLong(actionRequest, "occurTime");
		long duration = ParamUtil.getLong(actionRequest, "duration");

		long occurDayTime = 0;

		if (occurDayDate != null) {
			occurDayTime = occurDayDate.getTime();
		}

		if (sleepId <= 0) {
			_sleepService.addSleep(
				getSubjectId(actionRequest), occurDayTime, occurDaySegment,
				occurTime, duration);
		}
		else {
			_sleepService.updateSleep(
				sleepId, occurDayTime, occurDaySegment, occurTime, duration);
		}
	}

	@Reference
	private SleepService _sleepService;

}