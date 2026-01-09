/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ExerciseLocalService}.
 *
 * @author Amos Fong
 * @see ExerciseLocalService
 * @generated
 */
public class ExerciseLocalServiceWrapper
	implements ExerciseLocalService, ServiceWrapper<ExerciseLocalService> {

	public ExerciseLocalServiceWrapper() {
		this(null);
	}

	public ExerciseLocalServiceWrapper(
		ExerciseLocalService exerciseLocalService) {

		_exerciseLocalService = exerciseLocalService;
	}

	/**
	 * Adds the exercise to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExerciseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param exercise the exercise
	 * @return the exercise that was added
	 */
	@Override
	public com.tokogae.data.event.model.Exercise addExercise(
		com.tokogae.data.event.model.Exercise exercise) {

		return _exerciseLocalService.addExercise(exercise);
	}

	@Override
	public com.tokogae.data.event.model.Exercise addExercise(
			long userId, long subjectId, long occurDayBaseTime,
			long occurDayNativeTime, String name, long duration,
			double quantity, String quantityUnit)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _exerciseLocalService.addExercise(
			userId, subjectId, occurDayBaseTime, occurDayNativeTime, name,
			duration, quantity, quantityUnit);
	}

	/**
	 * Creates a new exercise with the primary key. Does not add the exercise to the database.
	 *
	 * @param exerciseId the primary key for the new exercise
	 * @return the new exercise
	 */
	@Override
	public com.tokogae.data.event.model.Exercise createExercise(
		long exerciseId) {

		return _exerciseLocalService.createExercise(exerciseId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _exerciseLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the exercise from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExerciseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param exercise the exercise
	 * @return the exercise that was removed
	 */
	@Override
	public com.tokogae.data.event.model.Exercise deleteExercise(
		com.tokogae.data.event.model.Exercise exercise) {

		return _exerciseLocalService.deleteExercise(exercise);
	}

	/**
	 * Deletes the exercise with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExerciseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param exerciseId the primary key of the exercise
	 * @return the exercise that was removed
	 * @throws PortalException if a exercise with the primary key could not be found
	 */
	@Override
	public com.tokogae.data.event.model.Exercise deleteExercise(long exerciseId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _exerciseLocalService.deleteExercise(exerciseId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _exerciseLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _exerciseLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _exerciseLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _exerciseLocalService.dynamicQuery();
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

		return _exerciseLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tokogae.data.event.model.impl.ExerciseModelImpl</code>.
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

		return _exerciseLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tokogae.data.event.model.impl.ExerciseModelImpl</code>.
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

		return _exerciseLocalService.dynamicQuery(
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

		return _exerciseLocalService.dynamicQueryCount(dynamicQuery);
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

		return _exerciseLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.tokogae.data.event.model.Exercise fetchExercise(
		long exerciseId) {

		return _exerciseLocalService.fetchExercise(exerciseId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _exerciseLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the exercise with the primary key.
	 *
	 * @param exerciseId the primary key of the exercise
	 * @return the exercise
	 * @throws PortalException if a exercise with the primary key could not be found
	 */
	@Override
	public com.tokogae.data.event.model.Exercise getExercise(long exerciseId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _exerciseLocalService.getExercise(exerciseId);
	}

	/**
	 * Returns a range of all the exercises.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tokogae.data.event.model.impl.ExerciseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of exercises
	 * @param end the upper bound of the range of exercises (not inclusive)
	 * @return the range of exercises
	 */
	@Override
	public java.util.List<com.tokogae.data.event.model.Exercise> getExercises(
		int start, int end) {

		return _exerciseLocalService.getExercises(start, end);
	}

	/**
	 * Returns the number of exercises.
	 *
	 * @return the number of exercises
	 */
	@Override
	public int getExercisesCount() {
		return _exerciseLocalService.getExercisesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _exerciseLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _exerciseLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _exerciseLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the exercise in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExerciseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param exercise the exercise
	 * @return the exercise that was updated
	 */
	@Override
	public com.tokogae.data.event.model.Exercise updateExercise(
		com.tokogae.data.event.model.Exercise exercise) {

		return _exerciseLocalService.updateExercise(exercise);
	}

	@Override
	public com.tokogae.data.event.model.Exercise updateExercise(
			long exerciseId, long occurDayBaseTime, long occurDayNativeTime,
			String name, long duration, double quantity, String quantityUnit)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _exerciseLocalService.updateExercise(
			exerciseId, occurDayBaseTime, occurDayNativeTime, name, duration,
			quantity, quantityUnit);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _exerciseLocalService.getBasePersistence();
	}

	@Override
	public ExerciseLocalService getWrappedService() {
		return _exerciseLocalService;
	}

	@Override
	public void setWrappedService(ExerciseLocalService exerciseLocalService) {
		_exerciseLocalService = exerciseLocalService;
	}

	private ExerciseLocalService _exerciseLocalService;

}