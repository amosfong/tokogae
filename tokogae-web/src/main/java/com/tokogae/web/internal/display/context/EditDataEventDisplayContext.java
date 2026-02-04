/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.web.internal.display.context;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;

import com.tokogae.account.service.SubjectService;
import com.tokogae.constants.DaySegments;
import com.tokogae.data.event.model.DataEvent;
import com.tokogae.data.event.model.DataEventFactory;
import com.tokogae.data.event.model.Exercise;
import com.tokogae.data.event.model.FoodItem;
import com.tokogae.data.event.model.Sleep;
import com.tokogae.data.event.model.Symptom;
import com.tokogae.data.event.service.ExerciseLocalService;
import com.tokogae.data.event.service.FoodItemLocalService;
import com.tokogae.data.event.service.SleepLocalService;
import com.tokogae.data.event.service.SymptomLocalService;

import jakarta.portlet.RenderRequest;
import jakarta.portlet.RenderResponse;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Amos Fong
 */
public class EditDataEventDisplayContext extends HomeDisplayContext {

	public EditDataEventDisplayContext(
			DataEventFactory dataEventFactory,
			ExerciseLocalService exerciseLocalService,
			FoodItemLocalService foodItemLocalService,
			RenderRequest renderRequest, RenderResponse renderResponse,
			SleepLocalService sleepLocalService, SubjectService subjectService,
			SymptomLocalService symptomLocalService)
		throws Exception {

		super(
			dataEventFactory, exerciseLocalService, foodItemLocalService,
			renderRequest, renderResponse, sleepLocalService, subjectService,
			symptomLocalService);

		_className = ParamUtil.getString(renderRequest, "className");
		_classPK = ParamUtil.getLong(renderRequest, "classPK");

		if (_classPK > 0) {
			if (_className.equals(Exercise.class.getName())) {
				_dataEvent = dataEventFactory.create(
					exerciseLocalService.getExercise(_classPK));
			}
			else if (_className.equals(FoodItem.class.getName())) {
				_dataEvent = dataEventFactory.create(
					foodItemLocalService.getFoodItem(_classPK));
			}
			else if (_className.equals(Sleep.class.getName())) {
				_dataEvent = dataEventFactory.create(
					sleepLocalService.getSleep(_classPK));
			}
			else if (_className.equals(Symptom.class.getName())) {
				_dataEvent = dataEventFactory.create(
					symptomLocalService.getSymptom(_classPK));
			}
		}

		if (_dataEvent != null) {
			_dataEventAttributes = _dataEvent.getAttributes();
		}
		else {
			_dataEventAttributes = new HashMap<>();
		}
	}

	public String getAffectedArea() {
		return GetterUtil.getString(_dataEventAttributes.get("affectedArea"));
	}

	public List<String> getDataEventClassNames() {
		return _dataEventClassNames;
	}

	public long getDuration() {
		return GetterUtil.getLong(_dataEventAttributes.get("duration"));
	}

	public int getIntensityLevel() {
		return GetterUtil.getInteger(_dataEventAttributes.get("intensity"), 1);
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

	public String getName() {
		return GetterUtil.getString(_dataEventAttributes.get("name"));
	}

	public String getOccurDay() {
		if (_dataEvent != null) {
			long occurDayBaseTime = GetterUtil.getLong(
				_dataEventAttributes.get("occurDayBaseTime"));

			return format.format(new Date(occurDayBaseTime));
		}

		return getCurrentOccurDay();
	}

	public int getOccurDaySegment() {
		if (_dataEvent != null) {
			long occurDayNativeTime = GetterUtil.getLong(
				_dataEventAttributes.get("occurDayNativeTime"));

			return DaySegments.getDaySegment(Math.abs(occurDayNativeTime));
		}

		return DaySegments.getDaySegment(getNativeTime(new Date()));
	}

	public int getQuantity() {
		return GetterUtil.getInteger(_dataEventAttributes.get("quantity"), 1);
	}

	public String getQuantityUnit() {
		return GetterUtil.getString(_dataEventAttributes.get("quantityUnit"));
	}

	public String getTitle() {
		if (_dataEvent != null) {
			return StringBundler.concat(
				LanguageUtil.get(
					themeDisplay.getLocale(), "update-" + getLabel(_className)),
				": ", _dataEvent.getSummary());
		}

		return LanguageUtil.get(themeDisplay.getLocale(), "add-event");
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
	private long _classPK;
	private DataEvent _dataEvent;
	private Map<String, Object> _dataEventAttributes;
	private List<String> _dataEventClassNames = new ArrayList<String>() {
		{
			add(Exercise.class.getName());
			add(FoodItem.class.getName());
			add(Sleep.class.getName());
			add(Symptom.class.getName());
		}
	};

}