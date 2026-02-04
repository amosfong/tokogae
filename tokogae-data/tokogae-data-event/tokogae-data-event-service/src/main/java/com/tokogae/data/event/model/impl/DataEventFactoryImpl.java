/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.model.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;

import com.tokogae.data.event.model.DataEvent;
import com.tokogae.data.event.model.DataEventFactory;
import com.tokogae.data.event.model.Exercise;
import com.tokogae.data.event.model.FoodItem;
import com.tokogae.data.event.model.Sleep;
import com.tokogae.data.event.model.Symptom;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.osgi.service.component.annotations.Component;

/**
 * @author Amos Fong
 */
@Component(service = DataEventFactory.class)
public class DataEventFactoryImpl implements DataEventFactory {

	public DataEvent create(Document document) throws Exception {
		DataEvent dataEvent = new DataEventImpl();

		dataEvent.setCompanyId(
			GetterUtil.getLong(document.get(Field.COMPANY_ID)));
		dataEvent.setPrimaryKey(document.get(Field.ENTRY_CLASS_PK));

		if (Validator.isNotNull(document.get("endDate"))) {
			dataEvent.setEndDate(document.getDate("endDate"));
		}

		if (Validator.isNotNull(document.get("occurDate"))) {
			dataEvent.setOccurDate(document.getDate("occurDate"));
		}

		if (Validator.isNotNull(document.get("startDate"))) {
			dataEvent.setStartDate(document.getDate("startDate"));
		}

		dataEvent.setSubjectId(GetterUtil.getLong(document.get("subjectId")));
		dataEvent.setSummary(document.get("summary"));

		return dataEvent;
	}

	public DataEvent create(Exercise exercise) {
		DataEvent dataEvent = new DataEventImpl();

		dataEvent.setAttributes(_getAttributes(exercise));
		dataEvent.setCompanyId(exercise.getCompanyId());
		dataEvent.setClassName(Exercise.class.getName());
		dataEvent.setClassPK(exercise.getExerciseId());
		dataEvent.setOccurDate(
			new Date(
				exercise.getOccurDayBaseTime() +
					Math.abs(exercise.getOccurDayNativeTime())));
		dataEvent.setSubjectId(exercise.getSubjectId());

		StringBundler sb = new StringBundler();

		sb.append(exercise.getQuantityLabel());
		sb.append(StringPool.SPACE);
		sb.append(exercise.getQuantityUnit());
		sb.append(StringPool.SPACE);
		sb.append(exercise.getName());

		dataEvent.setSummary(sb.toString());

		return dataEvent;
	}

	public DataEvent create(FoodItem foodItem) {
		DataEvent dataEvent = new DataEventImpl();

		dataEvent.setAttributes(_getAttributes(foodItem));
		dataEvent.setCompanyId(foodItem.getCompanyId());
		dataEvent.setClassName(FoodItem.class.getName());
		dataEvent.setClassPK(foodItem.getFoodItemId());
		dataEvent.setOccurDate(
			new Date(
				foodItem.getOccurDayBaseTime() +
					Math.abs(foodItem.getOccurDayNativeTime())));
		dataEvent.setSubjectId(foodItem.getSubjectId());

		StringBundler sb = new StringBundler();

		sb.append(foodItem.getQuantityLabel());
		sb.append(StringPool.SPACE);
		sb.append(foodItem.getQuantityUnit());
		sb.append(StringPool.SPACE);
		sb.append(foodItem.getName());

		dataEvent.setSummary(sb.toString());

		return dataEvent;
	}

	public DataEvent create(Sleep sleep) {
		DataEvent dataEvent = new DataEventImpl();

		dataEvent.setAttributes(_getAttributes(sleep));
		dataEvent.setCompanyId(sleep.getCompanyId());
		dataEvent.setClassName(Sleep.class.getName());
		dataEvent.setClassPK(sleep.getSleepId());
		dataEvent.setOccurDate(
			new Date(
				sleep.getOccurDayBaseTime() +
					Math.abs(sleep.getOccurDayNativeTime())));
		dataEvent.setSubjectId(sleep.getSubjectId());

		StringBundler sb = new StringBundler();

		sb.append("Sleep for ");
		sb.append(sleep.getDuration());

		dataEvent.setSummary(sb.toString());

		return dataEvent;
	}

	public DataEvent create(Symptom symptom) {
		DataEvent dataEvent = new DataEventImpl();

		dataEvent.setAttributes(_getAttributes(symptom));
		dataEvent.setCompanyId(symptom.getCompanyId());
		dataEvent.setClassName(Symptom.class.getName());
		dataEvent.setClassPK(symptom.getSymptomId());

		Date occurDate = new Date(
			symptom.getOccurDayBaseTime() +
				Math.abs(symptom.getOccurDayNativeTime()));

		dataEvent.setOccurDate(occurDate);

		if (symptom.getDuration() > 0) {
			dataEvent.setStartDate(occurDate);
			dataEvent.setEndDate(
				new Date(occurDate.getTime() + symptom.getDuration()));
		}

		dataEvent.setSubjectId(symptom.getSubjectId());

		StringBundler sb = new StringBundler();

		sb.append(symptom.getIntensityLevelLabel());
		sb.append(StringPool.SPACE);
		sb.append(symptom.getName());
		sb.append(" on ");
		sb.append(symptom.getAffectedArea());

		dataEvent.setSummary(sb.toString());

		return dataEvent;
	}

	private Map<String, Object> _getAttributes(BaseModel<?> baseModel) {
		Map<String, Object> attributes = baseModel.getModelAttributes();

		Set<String> keys = attributes.keySet();

		keys.retainAll(_attributeNames);

		return attributes;
	}

	private Set<String> _attributeNames = new HashSet<String>() {
		{
			add("affectedArea");
			add("brand");
			add("duration");
			add("intensityLevel");
			add("locationOfOrigin");
			add("name");
			add("occurDayBaseTime");
			add("occurDayNativeTime");
			add("quantity");
			add("quantityUnit");
		}
	};

}