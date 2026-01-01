/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.web.internal.display.context;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import com.tokogae.account.service.SubjectService;
import com.tokogae.data.event.model.DataEventFactory;
import com.tokogae.data.event.model.Exercise;
import com.tokogae.data.event.model.FoodItem;
import com.tokogae.data.event.model.Sleep;
import com.tokogae.data.event.model.Symptom;
import com.tokogae.data.event.service.ExerciseLocalService;
import com.tokogae.data.event.service.FoodItemLocalService;
import com.tokogae.data.event.service.SymptomLocalService;

import jakarta.portlet.RenderRequest;
import jakarta.portlet.RenderResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Amos Fong
 */
public class EditDataEventDisplayContext extends HomeDisplayContext {

	public EditDataEventDisplayContext(
		DataEventFactory dataEventFactory,
		ExerciseLocalService exerciseLocalService,
		FoodItemLocalService foodItemLocalService, RenderRequest renderRequest,
		RenderResponse renderResponse, SubjectService subjectService,
		SymptomLocalService symptomLocalService) {

		super(
			dataEventFactory, exerciseLocalService, foodItemLocalService,
			renderRequest, renderResponse, subjectService, symptomLocalService);

		_className = ParamUtil.getString(renderRequest, "className");
	}

	public List<String> getDataEventClassNames() {
		return _dataEventClassNames;
	}

	public String getLabel(String className) {
		if (className.equals(Exercise.class.getName())) {
			return "exercise";
		}
		else if (className.equals(FoodItem.class.getName())) {
			return "food";
		}
		else if (className.equals(Sleep.class.getName())) {
			return "sleep";
		}
		else if (className.equals(Symptom.class.getName())) {
			return "symptom";
		}

		return StringPool.BLANK;
	}

	public boolean isClassName(String className) {
		if (Validator.isNull(_className) &&
			className.equals(FoodItem.class.getName())) {

			return true;
		}

		if (_className.equals(className)) {
			return true;
		}

		return false;
	}

	public boolean isExerciseEvent() {
		return isClassName(Exercise.class.getName());
	}

	public boolean isFoodItemEvent() {
		return isClassName(FoodItem.class.getName());
	}

	public boolean isSleepEvent() {
		return isClassName(Sleep.class.getName());
	}

	public boolean isSymptomEvent() {
		return isClassName(Symptom.class.getName());
	}

	private String _className;
	private List<String> _dataEventClassNames = new ArrayList<String>() {
		{
			add(Exercise.class.getName());
			add(FoodItem.class.getName());
			add(Sleep.class.getName());
			add(Symptom.class.getName());
		}
	};

}