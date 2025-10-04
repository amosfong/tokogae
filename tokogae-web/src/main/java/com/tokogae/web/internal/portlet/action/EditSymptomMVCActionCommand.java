/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.web.internal.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;

import com.tokogae.data.event.exception.NoSuchSymptomException;
import com.tokogae.data.event.service.SymptomService;
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
		"mvc.command.name=/tokogae/edit_symptom"
	},
	service = MVCActionCommand.class
)
public class EditSymptomMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
			if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
				_updateSymptom(actionRequest);
			}
		}
		catch (NoSuchSymptomException noSuchSymptomException) {
			SessionErrors.add(actionRequest, noSuchSymptomException.getClass());
		}
	}

	private void _updateSymptom(ActionRequest actionRequest) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		DateFormat dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd", themeDisplay.getTimeZone());

		long symptomId = ParamUtil.getLong(actionRequest, "symptomId");

		long subjectId = ParamUtil.getLong(actionRequest, "subjectId");
		Date occurDayDate = ParamUtil.getDate(
			actionRequest, "occurDay", dateFormat, null);
		int occurDaySegment = ParamUtil.getInteger(
			actionRequest, "occurDaySegment");
		long occurTime = ParamUtil.getLong(actionRequest, "occurTime");
		String name = ParamUtil.getString(actionRequest, "name");
		String affectedArea = ParamUtil.getString(
			actionRequest, "affectedArea");
		boolean extended = ParamUtil.getBoolean(actionRequest, "extended");
		Date startDate = ParamUtil.getDate(
			actionRequest, "startDate", dateFormat, null);
		Date endDate = ParamUtil.getDate(
			actionRequest, "endDate", dateFormat, null);
		int intensityLevel = ParamUtil.getInteger(
			actionRequest, "intensityLevel");

		long occurDayTime = 0;

		if (occurDayDate != null) {
			occurDayTime = occurDayDate.getTime();
		}

		if (symptomId <= 0) {
			_symptomService.addSymptom(
				subjectId, occurDayTime, occurDaySegment, occurTime, name,
				affectedArea, extended, startDate, endDate, intensityLevel);
		}
		else {
			_symptomService.updateSymptom(
				symptomId, occurDayTime, occurDaySegment, occurTime, name,
				affectedArea, extended, startDate, endDate, intensityLevel);
		}
	}

	@Reference
	private Portal _portal;

	@Reference
	private SymptomService _symptomService;

}