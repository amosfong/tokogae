/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.model.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
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

		dataEvent.setCompanyId(exercise.getCompanyId());
		dataEvent.setClassName(Exercise.class.getName());
		dataEvent.setClassPK(exercise.getExerciseId());
		dataEvent.setOccurDate(
			new Date(
				exercise.getOccurDayBaseTime() +
					Math.abs(exercise.getOccurDayNativeTime())));
		dataEvent.setOriginalObject(exercise);
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

		dataEvent.setCompanyId(foodItem.getCompanyId());
		dataEvent.setClassName(FoodItem.class.getName());
		dataEvent.setClassPK(foodItem.getFoodItemId());
		dataEvent.setOccurDate(
			new Date(
				foodItem.getOccurDayBaseTime() +
					Math.abs(foodItem.getOccurDayNativeTime())));
		dataEvent.setOriginalObject(foodItem);
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

		dataEvent.setCompanyId(sleep.getCompanyId());
		dataEvent.setClassName(Sleep.class.getName());
		dataEvent.setClassPK(sleep.getSleepId());
		dataEvent.setOccurDate(
			new Date(
				sleep.getOccurDayBaseTime() +
					Math.abs(sleep.getOccurDayNativeTime())));
		dataEvent.setOriginalObject(sleep);
		dataEvent.setSubjectId(sleep.getSubjectId());

		StringBundler sb = new StringBundler();

		sb.append("Sleep for ");
		sb.append(sleep.getDuration());

		dataEvent.setSummary(sb.toString());

		return dataEvent;
	}

	public DataEvent create(Symptom symptom) {
		DataEvent dataEvent = new DataEventImpl();

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

		dataEvent.setOriginalObject(symptom);
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

}