/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.module.service.Snapshot;

import com.tokogae.data.event.model.FoodItem;

/**
 * Provides the remote service utility for FoodItem. This utility wraps
 * <code>com.tokogae.data.event.service.impl.FoodItemServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Amos Fong
 * @see FoodItemService
 * @generated
 */
public class FoodItemServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.tokogae.data.event.service.impl.FoodItemServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static FoodItem addFoodItem(
			long subjectId, long phraseId, long occurDayBaseTime,
			long occurDayNativeTime, String name, String locationOfOrigin,
			String brand, double quantity, String quantityUnit)
		throws PortalException {

		return getService().addFoodItem(
			subjectId, phraseId, occurDayBaseTime, occurDayNativeTime, name,
			locationOfOrigin, brand, quantity, quantityUnit);
	}

	public static FoodItem deleteFoodItem(long foodItemId)
		throws PortalException {

		return getService().deleteFoodItem(foodItemId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static FoodItem updateFoodItem(
			long foodItemId, long occurDayBaseTime, long occurDayNativeTime,
			String name, String locationOfOrigin, String brand, double quantity,
			String quantityUnit)
		throws PortalException {

		return getService().updateFoodItem(
			foodItemId, occurDayBaseTime, occurDayNativeTime, name,
			locationOfOrigin, brand, quantity, quantityUnit);
	}

	public static FoodItemService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<FoodItemService> _serviceSnapshot =
		new Snapshot<>(FoodItemServiceUtil.class, FoodItemService.class);

}