/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link FoodItemLocalService}.
 *
 * @author Amos Fong
 * @see FoodItemLocalService
 * @generated
 */
public class FoodItemLocalServiceWrapper
	implements FoodItemLocalService, ServiceWrapper<FoodItemLocalService> {

	public FoodItemLocalServiceWrapper() {
		this(null);
	}

	public FoodItemLocalServiceWrapper(
		FoodItemLocalService foodItemLocalService) {

		_foodItemLocalService = foodItemLocalService;
	}

	/**
	 * Adds the food item to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FoodItemLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param foodItem the food item
	 * @return the food item that was added
	 */
	@Override
	public com.tokogae.data.event.model.FoodItem addFoodItem(
		com.tokogae.data.event.model.FoodItem foodItem) {

		return _foodItemLocalService.addFoodItem(foodItem);
	}

	@Override
	public com.tokogae.data.event.model.FoodItem addFoodItem(
			long userId, long subjectId, long occurDay, int occurDaySegment,
			long occurTime, String name, String locationOfOrigin, String brand,
			double quantity, String quantityUnit)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _foodItemLocalService.addFoodItem(
			userId, subjectId, occurDay, occurDaySegment, occurTime, name,
			locationOfOrigin, brand, quantity, quantityUnit);
	}

	/**
	 * Creates a new food item with the primary key. Does not add the food item to the database.
	 *
	 * @param foodItemId the primary key for the new food item
	 * @return the new food item
	 */
	@Override
	public com.tokogae.data.event.model.FoodItem createFoodItem(
		long foodItemId) {

		return _foodItemLocalService.createFoodItem(foodItemId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _foodItemLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the food item from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FoodItemLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param foodItem the food item
	 * @return the food item that was removed
	 */
	@Override
	public com.tokogae.data.event.model.FoodItem deleteFoodItem(
		com.tokogae.data.event.model.FoodItem foodItem) {

		return _foodItemLocalService.deleteFoodItem(foodItem);
	}

	/**
	 * Deletes the food item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FoodItemLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param foodItemId the primary key of the food item
	 * @return the food item that was removed
	 * @throws PortalException if a food item with the primary key could not be found
	 */
	@Override
	public com.tokogae.data.event.model.FoodItem deleteFoodItem(long foodItemId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _foodItemLocalService.deleteFoodItem(foodItemId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _foodItemLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _foodItemLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _foodItemLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _foodItemLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _foodItemLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tokogae.data.event.model.impl.FoodItemModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _foodItemLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tokogae.data.event.model.impl.FoodItemModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _foodItemLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _foodItemLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _foodItemLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.tokogae.data.event.model.FoodItem fetchFoodItem(
		long foodItemId) {

		return _foodItemLocalService.fetchFoodItem(foodItemId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _foodItemLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the food item with the primary key.
	 *
	 * @param foodItemId the primary key of the food item
	 * @return the food item
	 * @throws PortalException if a food item with the primary key could not be found
	 */
	@Override
	public com.tokogae.data.event.model.FoodItem getFoodItem(long foodItemId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _foodItemLocalService.getFoodItem(foodItemId);
	}

	/**
	 * Returns a range of all the food items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tokogae.data.event.model.impl.FoodItemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of food items
	 * @param end the upper bound of the range of food items (not inclusive)
	 * @return the range of food items
	 */
	@Override
	public java.util.List<com.tokogae.data.event.model.FoodItem> getFoodItems(
		int start, int end) {

		return _foodItemLocalService.getFoodItems(start, end);
	}

	/**
	 * Returns the number of food items.
	 *
	 * @return the number of food items
	 */
	@Override
	public int getFoodItemsCount() {
		return _foodItemLocalService.getFoodItemsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _foodItemLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _foodItemLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _foodItemLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the food item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FoodItemLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param foodItem the food item
	 * @return the food item that was updated
	 */
	@Override
	public com.tokogae.data.event.model.FoodItem updateFoodItem(
		com.tokogae.data.event.model.FoodItem foodItem) {

		return _foodItemLocalService.updateFoodItem(foodItem);
	}

	@Override
	public com.tokogae.data.event.model.FoodItem updateFoodItem(
			long foodItemId, long occurDay, int occurDaySegment, long occurTime,
			String name, String locationOfOrigin, String brand, double quantity,
			String quantityUnit)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _foodItemLocalService.updateFoodItem(
			foodItemId, occurDay, occurDaySegment, occurTime, name,
			locationOfOrigin, brand, quantity, quantityUnit);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _foodItemLocalService.getBasePersistence();
	}

	@Override
	public FoodItemLocalService getWrappedService() {
		return _foodItemLocalService;
	}

	@Override
	public void setWrappedService(FoodItemLocalService foodItemLocalService) {
		_foodItemLocalService = foodItemLocalService;
	}

	private FoodItemLocalService _foodItemLocalService;

}