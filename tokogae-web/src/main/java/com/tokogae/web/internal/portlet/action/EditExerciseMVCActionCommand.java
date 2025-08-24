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
import com.liferay.portal.kernel.util.WebKeys;

import com.tokogae.data.event.exception.NoSuchExerciseException;
import com.tokogae.data.event.service.ExerciseService;
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
		"mvc.command.name=/tokogae/edit_exercise"
	},
	service = MVCActionCommand.class
)
public class EditExerciseMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
			if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
				_updateExercise(actionRequest);
			}
		}
		catch (NoSuchExerciseException noSuchExerciseException) {
			SessionErrors.add(
				actionRequest, noSuchExerciseException.getClass());
		}
	}

	private void _updateExercise(ActionRequest actionRequest) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long exerciseId = ParamUtil.getLong(actionRequest, "exerciseId");

		long subjectId = ParamUtil.getLong(actionRequest, "subjectId");

		String occurDayString = ParamUtil.getString(actionRequest, "occurDay");

		DateFormat dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd", themeDisplay.getTimeZone());

		Date occurDayDate = dateFormat.parse(occurDayString);

		int occurDaySegment = ParamUtil.getInteger(
			actionRequest, "occurDaySegment");
		long occurTime = ParamUtil.getLong(actionRequest, "occurTime");

		String name = ParamUtil.getString(actionRequest, "name");
		long duration = ParamUtil.getLong(actionRequest, "duration");
		double quantity = ParamUtil.getDouble(actionRequest, "quantity");
		String quantityUnit = ParamUtil.getString(
			actionRequest, "quantityUnit");

		if (exerciseId <= 0) {
			_exerciseService.addExercise(
				subjectId, occurDayDate.getTime(), occurDaySegment, occurTime,
				name, duration, quantity, quantityUnit);
		}
		else {
			_exerciseService.updateExercise(
				exerciseId, occurDayDate.getTime(), occurDaySegment, occurTime,
				name, duration, quantity, quantityUnit);
		}
	}

	@Reference
	private ExerciseService _exerciseService;

}