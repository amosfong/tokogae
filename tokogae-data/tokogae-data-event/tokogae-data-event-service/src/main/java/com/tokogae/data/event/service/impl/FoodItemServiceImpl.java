/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;

import com.tokogae.data.event.model.FoodItem;
import com.tokogae.data.event.service.base.FoodItemServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Amos Fong
 */
@Component(
	property = {
		"json.web.service.context.name=tokogae_data",
		"json.web.service.context.path=FoodItem"
	},
	service = AopService.class
)
public class FoodItemServiceImpl extends FoodItemServiceBaseImpl {

	public FoodItem addFoodItem(
			long subjectId, long phraseId, long occurDayBaseTime,
			long occurDayNativeTime, String name, String locationOfOrigin,
			String brand, double quantity, String quantityUnit)
		throws PortalException {

		return foodItemLocalService.addFoodItem(
			getUserId(), subjectId, phraseId, occurDayBaseTime,
			occurDayNativeTime, name, locationOfOrigin, brand, quantity,
			quantityUnit);
	}

	public FoodItem deleteFoodItem(long foodItemId) throws PortalException {
		return foodItemLocalService.deleteFoodItem(foodItemId);
	}

	public FoodItem updateFoodItem(
			long foodItemId, long occurDayBaseTime, long occurDayNativeTime,
			String name, String locationOfOrigin, String brand, double quantity,
			String quantityUnit)
		throws PortalException {

		return foodItemLocalService.updateFoodItem(
			foodItemId, occurDayBaseTime, occurDayNativeTime, name,
			locationOfOrigin, brand, quantity, quantityUnit);
	}

}