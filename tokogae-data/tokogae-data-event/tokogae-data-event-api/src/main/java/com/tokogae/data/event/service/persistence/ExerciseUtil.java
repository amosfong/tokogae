/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.tokogae.data.event.model.Exercise;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the exercise service. This utility wraps <code>com.tokogae.data.event.service.persistence.impl.ExercisePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Amos Fong
 * @see ExercisePersistence
 * @generated
 */
public class ExerciseUtil {

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
	public static void clearCache(Exercise exercise) {
		getPersistence().clearCache(exercise);
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
	public static Map<Serializable, Exercise> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Exercise> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Exercise> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Exercise> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Exercise> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Exercise update(Exercise exercise) {
		return getPersistence().update(exercise);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Exercise update(
		Exercise exercise, ServiceContext serviceContext) {

		return getPersistence().update(exercise, serviceContext);
	}

	/**
	 * Caches the exercise in the entity cache if it is enabled.
	 *
	 * @param exercise the exercise
	 */
	public static void cacheResult(Exercise exercise) {
		getPersistence().cacheResult(exercise);
	}

	/**
	 * Caches the exercises in the entity cache if it is enabled.
	 *
	 * @param exercises the exercises
	 */
	public static void cacheResult(List<Exercise> exercises) {
		getPersistence().cacheResult(exercises);
	}

	/**
	 * Creates a new exercise with the primary key. Does not add the exercise to the database.
	 *
	 * @param exerciseId the primary key for the new exercise
	 * @return the new exercise
	 */
	public static Exercise create(long exerciseId) {
		return getPersistence().create(exerciseId);
	}

	/**
	 * Removes the exercise with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param exerciseId the primary key of the exercise
	 * @return the exercise that was removed
	 * @throws NoSuchExerciseException if a exercise with the primary key could not be found
	 */
	public static Exercise remove(long exerciseId)
		throws com.tokogae.data.event.exception.NoSuchExerciseException {

		return getPersistence().remove(exerciseId);
	}

	public static Exercise updateImpl(Exercise exercise) {
		return getPersistence().updateImpl(exercise);
	}

	/**
	 * Returns the exercise with the primary key or throws a <code>NoSuchExerciseException</code> if it could not be found.
	 *
	 * @param exerciseId the primary key of the exercise
	 * @return the exercise
	 * @throws NoSuchExerciseException if a exercise with the primary key could not be found
	 */
	public static Exercise findByPrimaryKey(long exerciseId)
		throws com.tokogae.data.event.exception.NoSuchExerciseException {

		return getPersistence().findByPrimaryKey(exerciseId);
	}

	/**
	 * Returns the exercise with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param exerciseId the primary key of the exercise
	 * @return the exercise, or <code>null</code> if a exercise with the primary key could not be found
	 */
	public static Exercise fetchByPrimaryKey(long exerciseId) {
		return getPersistence().fetchByPrimaryKey(exerciseId);
	}

	/**
	 * Returns all the exercises.
	 *
	 * @return the exercises
	 */
	public static List<Exercise> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the exercises.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExerciseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of exercises
	 * @param end the upper bound of the range of exercises (not inclusive)
	 * @return the range of exercises
	 */
	public static List<Exercise> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the exercises.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExerciseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of exercises
	 * @param end the upper bound of the range of exercises (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of exercises
	 */
	public static List<Exercise> findAll(
		int start, int end, OrderByComparator<Exercise> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the exercises.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExerciseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of exercises
	 * @param end the upper bound of the range of exercises (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of exercises
	 */
	public static List<Exercise> findAll(
		int start, int end, OrderByComparator<Exercise> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the exercises from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of exercises.
	 *
	 * @return the number of exercises
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ExercisePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(ExercisePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile ExercisePersistence _persistence;

}