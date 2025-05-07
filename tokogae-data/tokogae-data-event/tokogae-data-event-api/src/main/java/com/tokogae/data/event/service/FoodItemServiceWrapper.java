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
	public FoodItemService getWrappedService() {
		return _foodItemService;
	}

	@Override
	public void setWrappedService(FoodItemService foodItemService) {
		_foodItemService = foodItemService;
	}

	private FoodItemService _foodItemService;

}