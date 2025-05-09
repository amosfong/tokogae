/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.tokogae.data.event.model.Symptom;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the symptom service. This utility wraps <code>com.tokogae.data.event.service.persistence.impl.SymptomPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Amos Fong
 * @see SymptomPersistence
 * @generated
 */
public class SymptomUtil {

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
	public static void clearCache(Symptom symptom) {
		getPersistence().clearCache(symptom);
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
	public static Map<Serializable, Symptom> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Symptom> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Symptom> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Symptom> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Symptom> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Symptom update(Symptom symptom) {
		return getPersistence().update(symptom);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Symptom update(
		Symptom symptom, ServiceContext serviceContext) {

		return getPersistence().update(symptom, serviceContext);
	}

	/**
	 * Caches the symptom in the entity cache if it is enabled.
	 *
	 * @param symptom the symptom
	 */
	public static void cacheResult(Symptom symptom) {
		getPersistence().cacheResult(symptom);
	}

	/**
	 * Caches the symptoms in the entity cache if it is enabled.
	 *
	 * @param symptoms the symptoms
	 */
	public static void cacheResult(List<Symptom> symptoms) {
		getPersistence().cacheResult(symptoms);
	}

	/**
	 * Creates a new symptom with the primary key. Does not add the symptom to the database.
	 *
	 * @param symptomId the primary key for the new symptom
	 * @return the new symptom
	 */
	public static Symptom create(long symptomId) {
		return getPersistence().create(symptomId);
	}

	/**
	 * Removes the symptom with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param symptomId the primary key of the symptom
	 * @return the symptom that was removed
	 * @throws NoSuchSymptomException if a symptom with the primary key could not be found
	 */
	public static Symptom remove(long symptomId)
		throws com.tokogae.data.event.exception.NoSuchSymptomException {

		return getPersistence().remove(symptomId);
	}

	public static Symptom updateImpl(Symptom symptom) {
		return getPersistence().updateImpl(symptom);
	}

	/**
	 * Returns the symptom with the primary key or throws a <code>NoSuchSymptomException</code> if it could not be found.
	 *
	 * @param symptomId the primary key of the symptom
	 * @return the symptom
	 * @throws NoSuchSymptomException if a symptom with the primary key could not be found
	 */
	public static Symptom findByPrimaryKey(long symptomId)
		throws com.tokogae.data.event.exception.NoSuchSymptomException {

		return getPersistence().findByPrimaryKey(symptomId);
	}

	/**
	 * Returns the symptom with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param symptomId the primary key of the symptom
	 * @return the symptom, or <code>null</code> if a symptom with the primary key could not be found
	 */
	public static Symptom fetchByPrimaryKey(long symptomId) {
		return getPersistence().fetchByPrimaryKey(symptomId);
	}

	/**
	 * Returns all the symptoms.
	 *
	 * @return the symptoms
	 */
	public static List<Symptom> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the symptoms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SymptomModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of symptoms
	 * @param end the upper bound of the range of symptoms (not inclusive)
	 * @return the range of symptoms
	 */
	public static List<Symptom> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the symptoms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SymptomModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of symptoms
	 * @param end the upper bound of the range of symptoms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of symptoms
	 */
	public static List<Symptom> findAll(
		int start, int end, OrderByComparator<Symptom> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the symptoms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SymptomModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of symptoms
	 * @param end the upper bound of the range of symptoms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of symptoms
	 */
	public static List<Symptom> findAll(
		int start, int end, OrderByComparator<Symptom> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the symptoms from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of symptoms.
	 *
	 * @return the number of symptoms
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SymptomPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(SymptomPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile SymptomPersistence _persistence;

}