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

import com.tokogae.constants.DaySegments;
import com.tokogae.data.event.model.DataEvent;
import com.tokogae.data.event.model.DataEventFactory;
import com.tokogae.data.event.model.Exercise;
import com.tokogae.data.event.model.FoodItem;
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

		long occurTime = 0;

		if (exercise.getOccurTime() > 0) {
			occurTime = exercise.getOccurTime();
		}
		else {
			occurTime = DaySegments.getDayTime(exercise.getOccurDaySegment());
		}

		dataEvent.setOccurDate(new Date(exercise.getOccurDay() + occurTime));

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

		long occurTime = 0;

		if (foodItem.getOccurTime() > 0) {
			occurTime = foodItem.getOccurTime();
		}
		else {
			occurTime = DaySegments.getDayTime(foodItem.getOccurDaySegment());
		}

		dataEvent.setOccurDate(new Date(foodItem.getOccurDay() + occurTime));

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

	public DataEvent create(Symptom symptom) {
		DataEvent dataEvent = new DataEventImpl();

		dataEvent.setCompanyId(symptom.getCompanyId());
		dataEvent.setClassName(Symptom.class.getName());
		dataEvent.setClassPK(symptom.getSymptomId());

		long occurTime = 0;

		if (symptom.getOccurTime() > 0) {
			occurTime = symptom.getOccurTime();
		}
		else {
			occurTime = DaySegments.getDayTime(symptom.getOccurDaySegment());
		}

		Date occurDate = new Date(symptom.getOccurDay() + occurTime);

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