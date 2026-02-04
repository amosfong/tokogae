/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FoodItemService}.
 *
 * @author Amos Fong
 * @see FoodItemService
 * @generated
 */
public class FoodItemServiceWrapper
	implements FoodItemService, ServiceWrapper<FoodItemService> {

	public FoodItemServiceWrapper() {
		this(null);
	}

	public FoodItemServiceWrapper(FoodItemService foodItemService) {
		_foodItemService = foodItemService;
	}

	@Override
	public com.tokogae.data.event.model.FoodItem addFoodItem(
			long subjectId, long phraseId, long occurDayBaseTime,
			long occurDayNativeTime, String name, String locationOfOrigin,
			String brand, double quantity, String quantityUnit)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _foodItemService.addFoodItem(
			subjectId, phraseId, occurDayBaseTime, occurDayNativeTime, name,
			locationOfOrigin, brand, quantity, quantityUnit);
	}

	@Override
	public com.tokogae.data.event.model.FoodItem deleteFoodItem(long foodItemId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _foodItemService.deleteFoodItem(foodItemId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _foodItemService.getOSGiServiceIdentifier();
	}

	@Override
	public com.tokogae.data.event.model.FoodItem updateFoodItem(
			long foodItemId, long occurDayBaseTime, long occurDayNativeTime,
			String name, String locationOfOrigin, String brand, double quantity,
			String quantityUnit)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _foodItemService.updateFoodItem(
			foodItemId, occurDayBaseTime, occurDayNativeTime, name,
			locationOfOrigin, brand, quantity, quantityUnit);
	}

	@Override
	public FoodItemService getWrappedService() {
		return _foodItemService;
	}

	@Override
	public void setWrappedService(FoodItemService foodItemService) {
		_foodItemService = foodItemService;
	}

	private FoodItemService _foodItemService;

}