/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.tokogae.data.event.exception.NoSuchFoodItemException;
import com.tokogae.data.event.model.FoodItem;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the food item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Amos Fong
 * @see FoodItemUtil
 * @generated
 */
@ProviderType
public interface FoodItemPersistence extends BasePersistence<FoodItem> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FoodItemUtil} to access the food item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the food item in the entity cache if it is enabled.
	 *
	 * @param foodItem the food item
	 */
	public void cacheResult(FoodItem foodItem);

	/**
	 * Caches the food items in the entity cache if it is enabled.
	 *
	 * @param foodItems the food items
	 */
	public void cacheResult(java.util.List<FoodItem> foodItems);

	/**
	 * Creates a new food item with the primary key. Does not add the food item to the database.
	 *
	 * @param foodItemId the primary key for the new food item
	 * @return the new food item
	 */
	public FoodItem create(long foodItemId);

	/**
	 * Removes the food item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param foodItemId the primary key of the food item
	 * @return the food item that was removed
	 * @throws NoSuchFoodItemException if a food item with the primary key could not be found
	 */
	public FoodItem remove(long foodItemId) throws NoSuchFoodItemException;

	public FoodItem updateImpl(FoodItem foodItem);

	/**
	 * Returns the food item with the primary key or throws a <code>NoSuchFoodItemException</code> if it could not be found.
	 *
	 * @param foodItemId the primary key of the food item
	 * @return the food item
	 * @throws NoSuchFoodItemException if a food item with the primary key could not be found
	 */
	public FoodItem findByPrimaryKey(long foodItemId)
		throws NoSuchFoodItemException;

	/**
	 * Returns the food item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param foodItemId the primary key of the food item
	 * @return the food item, or <code>null</code> if a food item with the primary key could not be found
	 */
	public FoodItem fetchByPrimaryKey(long foodItemId);

	/**
	 * Returns all the food items.
	 *
	 * @return the food items
	 */
	public java.util.List<FoodItem> findAll();

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
	public java.util.List<FoodItem> findAll(int start, int end);

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
	public java.util.List<FoodItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FoodItem>
			orderByComparator);

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
	public java.util.List<FoodItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FoodItem>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the food items from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of food items.
	 *
	 * @return the number of food items
	 */
	public int countAll();

}