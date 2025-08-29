/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.web.internal.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;

import com.tokogae.data.event.exception.NoSuchExerciseException;
import com.tokogae.data.event.exception.NoSuchFoodItemException;
import com.tokogae.data.event.exception.NoSuchSymptomException;
import com.tokogae.data.event.model.Exercise;
import com.tokogae.data.event.model.FoodItem;
import com.tokogae.data.event.model.Symptom;
import com.tokogae.data.event.service.ExerciseService;
import com.tokogae.data.event.service.FoodItemService;
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
		"mvc.command.name=/tokogae/delete_data_event"
	},
	service = MVCActionCommand.class
)
public class DeleteDataEventMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		try {
			String className = ParamUtil.getString(actionRequest, "className");
			long classPK = ParamUtil.getLong(actionRequest, "classPK");

			if (className.equals(Exercise.class.getName())) {
				_exerciseService.deleteExercise(classPK);
			}
			else if (className.equals(FoodItem.class.getName())) {
				_foodItemService.deleteFoodItem(classPK);
			}
			else if (className.equals(Symptom.class.getName())) {
				_symptomService.deleteSymptom(classPK);
			}
		}
		catch (Throwable throwable) {
			if (throwable instanceof NoSuchExerciseException ||
				throwable instanceof NoSuchFoodItemException ||
				throwable instanceof NoSuchSymptomException) {

				SessionErrors.add(actionRequest, throwable.getClass());
			}
			else {
				throw throwable;
			}
		}
	}

	@Reference
	private ExerciseService _exerciseService;

	@Reference
	private FoodItemService _foodItemService;

	@Reference
	private SymptomService _symptomService;

}