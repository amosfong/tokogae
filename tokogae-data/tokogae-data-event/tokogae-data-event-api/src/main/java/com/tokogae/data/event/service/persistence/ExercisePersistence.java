/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.tokogae.data.event.exception.NoSuchExerciseException;
import com.tokogae.data.event.model.Exercise;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the exercise service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Amos Fong
 * @see ExerciseUtil
 * @generated
 */
@ProviderType
public interface ExercisePersistence extends BasePersistence<Exercise> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ExerciseUtil} to access the exercise persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the exercise in the entity cache if it is enabled.
	 *
	 * @param exercise the exercise
	 */
	public void cacheResult(Exercise exercise);

	/**
	 * Caches the exercises in the entity cache if it is enabled.
	 *
	 * @param exercises the exercises
	 */
	public void cacheResult(java.util.List<Exercise> exercises);

	/**
	 * Creates a new exercise with the primary key. Does not add the exercise to the database.
	 *
	 * @param exerciseId the primary key for the new exercise
	 * @return the new exercise
	 */
	public Exercise create(long exerciseId);

	/**
	 * Removes the exercise with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param exerciseId the primary key of the exercise
	 * @return the exercise that was removed
	 * @throws NoSuchExerciseException if a exercise with the primary key could not be found
	 */
	public Exercise remove(long exerciseId) throws NoSuchExerciseException;

	public Exercise updateImpl(Exercise exercise);

	/**
	 * Returns the exercise with the primary key or throws a <code>NoSuchExerciseException</code> if it could not be found.
	 *
	 * @param exerciseId the primary key of the exercise
	 * @return the exercise
	 * @throws NoSuchExerciseException if a exercise with the primary key could not be found
	 */
	public Exercise findByPrimaryKey(long exerciseId)
		throws NoSuchExerciseException;

	/**
	 * Returns the exercise with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param exerciseId the primary key of the exercise
	 * @return the exercise, or <code>null</code> if a exercise with the primary key could not be found
	 */
	public Exercise fetchByPrimaryKey(long exerciseId);

	/**
	 * Returns all the exercises.
	 *
	 * @return the exercises
	 */
	public java.util.List<Exercise> findAll();

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
	public java.util.List<Exercise> findAll(int start, int end);

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
	public java.util.List<Exercise> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Exercise>
			orderByComparator);

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
	public java.util.List<Exercise> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Exercise>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the exercises from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of exercises.
	 *
	 * @return the number of exercises
	 */
	public int countAll();

}