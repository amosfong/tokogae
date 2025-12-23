/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.tokogae.data.event.model.Sleep;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the sleep service. This utility wraps <code>com.tokogae.data.event.service.persistence.impl.SleepPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Amos Fong
 * @see SleepPersistence
 * @generated
 */
public class SleepUtil {

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
	public static void clearCache(Sleep sleep) {
		getPersistence().clearCache(sleep);
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
	public static Map<Serializable, Sleep> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Sleep> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Sleep> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Sleep> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Sleep> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Sleep update(Sleep sleep) {
		return getPersistence().update(sleep);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Sleep update(Sleep sleep, ServiceContext serviceContext) {
		return getPersistence().update(sleep, serviceContext);
	}

	/**
	 * Caches the sleep in the entity cache if it is enabled.
	 *
	 * @param sleep the sleep
	 */
	public static void cacheResult(Sleep sleep) {
		getPersistence().cacheResult(sleep);
	}

	/**
	 * Caches the sleeps in the entity cache if it is enabled.
	 *
	 * @param sleeps the sleeps
	 */
	public static void cacheResult(List<Sleep> sleeps) {
		getPersistence().cacheResult(sleeps);
	}

	/**
	 * Creates a new sleep with the primary key. Does not add the sleep to the database.
	 *
	 * @param sleepId the primary key for the new sleep
	 * @return the new sleep
	 */
	public static Sleep create(long sleepId) {
		return getPersistence().create(sleepId);
	}

	/**
	 * Removes the sleep with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sleepId the primary key of the sleep
	 * @return the sleep that was removed
	 * @throws NoSuchSleepException if a sleep with the primary key could not be found
	 */
	public static Sleep remove(long sleepId)
		throws com.tokogae.data.event.exception.NoSuchSleepException {

		return getPersistence().remove(sleepId);
	}

	public static Sleep updateImpl(Sleep sleep) {
		return getPersistence().updateImpl(sleep);
	}

	/**
	 * Returns the sleep with the primary key or throws a <code>NoSuchSleepException</code> if it could not be found.
	 *
	 * @param sleepId the primary key of the sleep
	 * @return the sleep
	 * @throws NoSuchSleepException if a sleep with the primary key could not be found
	 */
	public static Sleep findByPrimaryKey(long sleepId)
		throws com.tokogae.data.event.exception.NoSuchSleepException {

		return getPersistence().findByPrimaryKey(sleepId);
	}

	/**
	 * Returns the sleep with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sleepId the primary key of the sleep
	 * @return the sleep, or <code>null</code> if a sleep with the primary key could not be found
	 */
	public static Sleep fetchByPrimaryKey(long sleepId) {
		return getPersistence().fetchByPrimaryKey(sleepId);
	}

	/**
	 * Returns all the sleeps.
	 *
	 * @return the sleeps
	 */
	public static List<Sleep> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the sleeps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SleepModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sleeps
	 * @param end the upper bound of the range of sleeps (not inclusive)
	 * @return the range of sleeps
	 */
	public static List<Sleep> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the sleeps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SleepModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sleeps
	 * @param end the upper bound of the range of sleeps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sleeps
	 */
	public static List<Sleep> findAll(
		int start, int end, OrderByComparator<Sleep> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sleeps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SleepModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sleeps
	 * @param end the upper bound of the range of sleeps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sleeps
	 */
	public static List<Sleep> findAll(
		int start, int end, OrderByComparator<Sleep> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the sleeps from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of sleeps.
	 *
	 * @return the number of sleeps
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SleepPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(SleepPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile SleepPersistence _persistence;

}