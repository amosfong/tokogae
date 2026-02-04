/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.web.internal.portlet.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;

import com.tokogae.data.event.exception.NoSuchExerciseException;
import com.tokogae.data.event.exception.NoSuchFoodItemException;
import com.tokogae.data.event.exception.NoSuchSleepException;
import com.tokogae.data.event.exception.NoSuchSymptomException;
import com.tokogae.data.event.model.Exercise;
import com.tokogae.data.event.model.FoodItem;
import com.tokogae.data.event.model.Sleep;
import com.tokogae.data.event.model.Symptom;
import com.tokogae.data.event.service.ExerciseService;
import com.tokogae.data.event.service.FoodItemService;
import com.tokogae.data.event.service.SleepService;
import com.tokogae.data.event.service.SymptomService;
import com.tokogae.web.internal.constants.TokogaePortletKeys;

import jakarta.portlet.ActionRequest;
import jakarta.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Amos Fong
 */
@Component(
	property = {
		"jakarta.portlet.name=" + TokogaePortletKeys.TOKOGAE,
		"mvc.command.name=/tokogae/edit_data_event"
	},
	service = MVCActionCommand.class
)
public class EditDataEventMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
			if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
				String className = ParamUtil.getString(
					actionRequest, "className");

				if (className.equals(Exercise.class.getName())) {
					_updateExercise(actionRequest);
				}
				else if (className.equals(FoodItem.class.getName())) {
					_updateFoodItem(actionRequest);
				}
				else if (className.equals(Sleep.class.getName())) {
					_updateSleep(actionRequest);
				}
				else if (className.equals(Symptom.class.getName())) {
					_updateSymptom(actionRequest);
				}
			}
		}
		catch (Exception exception) {
			if (exception instanceof NoSuchExerciseException ||
				exception instanceof NoSuchFoodItemException ||
				exception instanceof NoSuchSleepException ||
				exception instanceof NoSuchSymptomException) {

				SessionErrors.add(actionRequest, exception.getClass());
			}
			else {
				_log.error(exception, exception);

				throw exception;
			}
		}
	}

	private void _updateExercise(ActionRequest actionRequest) throws Exception {
		long classPK = ParamUtil.getLong(actionRequest, "classPK");

		long phraseId = ParamUtil.getLong(actionRequest, "phraseId");
		long occurDayBaseTime = getOccurDayBaseTime(actionRequest);
		long occurDayNativeTime = ParamUtil.getLong(
			actionRequest, "occurDayNativeTime");
		String name = ParamUtil.getString(actionRequest, "name");
		long duration = ParamUtil.getLong(actionRequest, "duration");
		double quantity = ParamUtil.getDouble(actionRequest, "quantity");
		String quantityUnit = ParamUtil.getString(
			actionRequest, "quantityUnit");

		if (classPK <= 0) {
			_exerciseService.addExercise(
				getSubjectId(actionRequest), phraseId, occurDayBaseTime,
				occurDayNativeTime, name, duration, quantity, quantityUnit);
		}
		else {
			_exerciseService.updateExercise(
				classPK, occurDayBaseTime, occurDayNativeTime, name, duration,
				quantity, quantityUnit);
		}
	}

	private void _updateFoodItem(ActionRequest actionRequest) throws Exception {
		long classPK = ParamUtil.getLong(actionRequest, "classPK");

		long phraseId = ParamUtil.getLong(actionRequest, "phraseId");
		long occurDayBaseTime = getOccurDayBaseTime(actionRequest);
		long occurDayNativeTime = ParamUtil.getLong(
			actionRequest, "occurDayNativeTime");
		String name = ParamUtil.getString(actionRequest, "name");
		String locationOfOrigin = ParamUtil.getString(
			actionRequest, "locationOfOrigin");
		String brand = ParamUtil.getString(actionRequest, "brand");
		double quantity = ParamUtil.getDouble(actionRequest, "quantity");
		String quantityUnit = ParamUtil.getString(
			actionRequest, "quantityUnit");

		if (classPK <= 0) {
			_foodItemService.addFoodItem(
				getSubjectId(actionRequest), phraseId, occurDayBaseTime,
				occurDayNativeTime, name, locationOfOrigin, brand, quantity,
				quantityUnit);
		}
		else {
			_foodItemService.updateFoodItem(
				classPK, occurDayBaseTime, occurDayNativeTime, name,
				locationOfOrigin, brand, quantity, quantityUnit);
		}
	}

	private void _updateSleep(ActionRequest actionRequest) throws Exception {
		long classPK = ParamUtil.getLong(actionRequest, "classPK");

		long phraseId = ParamUtil.getLong(actionRequest, "phraseId");
		long occurDayBaseTime = getOccurDayBaseTime(actionRequest);
		long occurDayNativeTime = ParamUtil.getLong(
			actionRequest, "occurDayNativeTime");
		long duration = ParamUtil.getLong(actionRequest, "duration");

		if (classPK <= 0) {
			_sleepService.addSleep(
				getSubjectId(actionRequest), phraseId, occurDayBaseTime,
				occurDayNativeTime, duration);
		}
		else {
			_sleepService.updateSleep(
				classPK, occurDayBaseTime, occurDayNativeTime, duration);
		}
	}

	private void _updateSymptom(ActionRequest actionRequest) throws Exception {
		long classPK = ParamUtil.getLong(actionRequest, "classPK");

		long phraseId = ParamUtil.getLong(actionRequest, "phraseId");
		long occurDayBaseTime = getOccurDayBaseTime(actionRequest);
		long occurDayNativeTime = ParamUtil.getLong(
			actionRequest, "occurDayNativeTime");
		String name = ParamUtil.getString(actionRequest, "name");
		String affectedArea = ParamUtil.getString(
			actionRequest, "affectedArea");
		long duration = ParamUtil.getLong(actionRequest, "duration");
		int intensityLevel = ParamUtil.getInteger(
			actionRequest, "intensityLevel");

		if (classPK <= 0) {
			_symptomService.addSymptom(
				getSubjectId(actionRequest), phraseId, occurDayBaseTime,
				occurDayNativeTime, duration, name, affectedArea,
				intensityLevel);
		}
		else {
			_symptomService.updateSymptom(
				classPK, occurDayBaseTime, occurDayNativeTime, duration, name,
				affectedArea, intensityLevel);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		EditDataEventMVCActionCommand.class);

	@Reference
	private ExerciseService _exerciseService;

	@Reference
	private FoodItemService _foodItemService;

	@Reference
	private SleepService _sleepService;

	@Reference
	private SymptomService _symptomService;

}