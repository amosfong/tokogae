/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.model.impl;

import com.tokogae.constants.DaySegments;
import com.tokogae.data.event.model.DataEvent;
import com.tokogae.data.event.model.DataEventFactory;
import com.tokogae.data.event.model.FoodItem;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * @author Amos Fong
 */
@Component(service = DataEventFactory.class)
public class DataEventFactoryImpl implements DataEventFactory {
	/*
		public DataEvent create(Document document) throws Exception {
			DataEvent dataEvent = new DataEventImpl();

			dataEvent.setCompanyId(
				GetterUtil.getLong(document.get(Field.COMPANY_ID)));
			dataEvent.setPrimaryKey(document.get(Field.ENTRY_CLASS_PK));

			if (Validator.isNotNull(document.get("occurDate"))) {
				dataEvent.setOccurDate(document.getDate("occurDate"));
			}

			String className = dataEvent.getClassName();

			if (className.equals(FoodItem.class.getName())) {
				FoodItem foodItem = _foodItemLocalService.getFoodItem(dataEvent.getClassPK());

				dataEvent.setOriginalObject(foodItem);
			}

			return dataEvent;
		}

	*/
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

		return dataEvent;
	}

}