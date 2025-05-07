/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.tokogae.data.event.model.FoodItem;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the food item service. This utility wraps <code>com.tokogae.data.event.service.persistence.impl.FoodItemPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Amos Fong
 * @see FoodItemPersistence
 * @generated
 */
public class FoodItemUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(FoodItem foodItem) {
		getPersistence().clearCache(foodItem);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, FoodItem> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<FoodItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FoodItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FoodItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FoodItem> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FoodItem update(FoodItem foodItem) {
		return getPersistence().update(foodItem);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FoodItem update(
		FoodItem foodItem, ServiceContext serviceContext) {

		return getPersistence().update(foodItem, serviceContext);
	}

	/**
	 * Caches the food item in the entity cache if it is enabled.
	 *
	 * @param foodItem the food item
	 */
	public static void cacheResult(FoodItem foodItem) {
		getPersistence().cacheResult(foodItem);
	}

	/**
	 * Caches the food items in the entity cache if it is enabled.
	 *
	 * @param foodItems the food items
	 */
	public static void cacheResult(List<FoodItem> foodItems) {
		getPersistence().cacheResult(foodItems);
	}

	/**
	 * Creates a new food item with the primary key. Does not add the food item to the database.
	 *
	 * @param foodItemId the primary key for the new food item
	 * @return the new food item
	 */
	public static FoodItem create(long foodItemId) {
		return getPersistence().create(foodItemId);
	}

	/**
	 * Removes the food item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param foodItemId the primary key of the food item
	 * @return the food item that was removed
	 * @throws NoSuchFoodItemException if a food item with the primary key could not be found
	 */
	public static FoodItem remove(long foodItemId)
		throws com.tokogae.data.event.exception.NoSuchFoodItemException {

		return getPersistence().remove(foodItemId);
	}

	public static FoodItem updateImpl(FoodItem foodItem) {
		return getPersistence().updateImpl(foodItem);
	}

	/**
	 * Returns the food item with the primary key or throws a <code>NoSuchFoodItemException</code> if it could not be found.
	 *
	 * @param foodItemId the primary key of the food item
	 * @return the food item
	 * @throws NoSuchFoodItemException if a food item with the primary key could not be found
	 */
	public static FoodItem findByPrimaryKey(long foodItemId)
		throws com.tokogae.data.event.exception.NoSuchFoodItemException {

		return getPersistence().findByPrimaryKey(foodItemId);
	}

	/**
	 * Returns the food item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param foodItemId the primary key of the food item
	 * @return the food item, or <code>null</code> if a food item with the primary key could not be found
	 */
	public static FoodItem fetchByPrimaryKey(long foodItemId) {
		return getPersistence().fetchByPrimaryKey(foodItemId);
	}

	/**
	 * Returns all the food items.
	 *
	 * @return the food items
	 */
	public static List<FoodItem> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the food items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FoodItemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of food items
	 * @param end the upper bound of the range of food items (not inclusive)
	 * @return the range of food items
	 */
	public static List<FoodItem> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the food items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FoodItemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of food items
	 * @param end the upper bound of the range of food items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of food items
	 */
	public static List<FoodItem> findAll(
		int start, int end, OrderByComparator<FoodItem> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the food items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FoodItemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of food items
	 * @param end the upper bound of the range of food items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of food items
	 */
	public static List<FoodItem> findAll(
		int start, int end, OrderByComparator<FoodItem> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the food items from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of food items.
	 *
	 * @return the number of food items
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FoodItemPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(FoodItemPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile FoodItemPersistence _persistence;

}