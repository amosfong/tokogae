/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.tokogae.data.event.model.SymptomPeriod;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the symptom period service. This utility wraps <code>com.tokogae.data.event.service.persistence.impl.SymptomPeriodPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Amos Fong
 * @see SymptomPeriodPersistence
 * @generated
 */
public class SymptomPeriodUtil {

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
	public static void clearCache(SymptomPeriod symptomPeriod) {
		getPersistence().clearCache(symptomPeriod);
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
	public static Map<Serializable, SymptomPeriod> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SymptomPeriod> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SymptomPeriod> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SymptomPeriod> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SymptomPeriod> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SymptomPeriod update(SymptomPeriod symptomPeriod) {
		return getPersistence().update(symptomPeriod);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SymptomPeriod update(
		SymptomPeriod symptomPeriod, ServiceContext serviceContext) {

		return getPersistence().update(symptomPeriod, serviceContext);
	}

	/**
	 * Caches the symptom period in the entity cache if it is enabled.
	 *
	 * @param symptomPeriod the symptom period
	 */
	public static void cacheResult(SymptomPeriod symptomPeriod) {
		getPersistence().cacheResult(symptomPeriod);
	}

	/**
	 * Caches the symptom periods in the entity cache if it is enabled.
	 *
	 * @param symptomPeriods the symptom periods
	 */
	public static void cacheResult(List<SymptomPeriod> symptomPeriods) {
		getPersistence().cacheResult(symptomPeriods);
	}

	/**
	 * Creates a new symptom period with the primary key. Does not add the symptom period to the database.
	 *
	 * @param symptomId the primary key for the new symptom period
	 * @return the new symptom period
	 */
	public static SymptomPeriod create(long symptomId) {
		return getPersistence().create(symptomId);
	}

	/**
	 * Removes the symptom period with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param symptomId the primary key of the symptom period
	 * @return the symptom period that was removed
	 * @throws NoSuchSymptomPeriodException if a symptom period with the primary key could not be found
	 */
	public static SymptomPeriod remove(long symptomId)
		throws com.tokogae.data.event.exception.NoSuchSymptomPeriodException {

		return getPersistence().remove(symptomId);
	}

	public static SymptomPeriod updateImpl(SymptomPeriod symptomPeriod) {
		return getPersistence().updateImpl(symptomPeriod);
	}

	/**
	 * Returns the symptom period with the primary key or throws a <code>NoSuchSymptomPeriodException</code> if it could not be found.
	 *
	 * @param symptomId the primary key of the symptom period
	 * @return the symptom period
	 * @throws NoSuchSymptomPeriodException if a symptom period with the primary key could not be found
	 */
	public static SymptomPeriod findByPrimaryKey(long symptomId)
		throws com.tokogae.data.event.exception.NoSuchSymptomPeriodException {

		return getPersistence().findByPrimaryKey(symptomId);
	}

	/**
	 * Returns the symptom period with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param symptomId the primary key of the symptom period
	 * @return the symptom period, or <code>null</code> if a symptom period with the primary key could not be found
	 */
	public static SymptomPeriod fetchByPrimaryKey(long symptomId) {
		return getPersistence().fetchByPrimaryKey(symptomId);
	}

	/**
	 * Returns all the symptom periods.
	 *
	 * @return the symptom periods
	 */
	public static List<SymptomPeriod> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the symptom periods.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SymptomPeriodModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of symptom periods
	 * @param end the upper bound of the range of symptom periods (not inclusive)
	 * @return the range of symptom periods
	 */
	public static List<SymptomPeriod> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the symptom periods.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SymptomPeriodModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of symptom periods
	 * @param end the upper bound of the range of symptom periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of symptom periods
	 */
	public static List<SymptomPeriod> findAll(
		int start, int end,
		OrderByComparator<SymptomPeriod> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the symptom periods.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SymptomPeriodModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of symptom periods
	 * @param end the upper bound of the range of symptom periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of symptom periods
	 */
	public static List<SymptomPeriod> findAll(
		int start, int end, OrderByComparator<SymptomPeriod> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the symptom periods from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of symptom periods.
	 *
	 * @return the number of symptom periods
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SymptomPeriodPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(SymptomPeriodPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile SymptomPeriodPersistence _persistence;

}