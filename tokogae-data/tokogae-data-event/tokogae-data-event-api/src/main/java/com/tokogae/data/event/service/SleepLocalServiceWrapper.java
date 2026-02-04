/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link SleepLocalService}.
 *
 * @author Amos Fong
 * @see SleepLocalService
 * @generated
 */
public class SleepLocalServiceWrapper
	implements ServiceWrapper<SleepLocalService>, SleepLocalService {

	public SleepLocalServiceWrapper() {
		this(null);
	}

	public SleepLocalServiceWrapper(SleepLocalService sleepLocalService) {
		_sleepLocalService = sleepLocalService;
	}

	@Override
	public com.tokogae.data.event.model.Sleep addSleep(
			long userId, long subjectId, long phraseId, long occurDayBaseTime,
			long occurDayNativeTime, long duration)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sleepLocalService.addSleep(
			userId, subjectId, phraseId, occurDayBaseTime, occurDayNativeTime,
			duration);
	}

	/**
	 * Adds the sleep to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SleepLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sleep the sleep
	 * @return the sleep that was added
	 */
	@Override
	public com.tokogae.data.event.model.Sleep addSleep(
		com.tokogae.data.event.model.Sleep sleep) {

		return _sleepLocalService.addSleep(sleep);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sleepLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new sleep with the primary key. Does not add the sleep to the database.
	 *
	 * @param sleepId the primary key for the new sleep
	 * @return the new sleep
	 */
	@Override
	public com.tokogae.data.event.model.Sleep createSleep(long sleepId) {
		return _sleepLocalService.createSleep(sleepId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sleepLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the sleep with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SleepLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sleepId the primary key of the sleep
	 * @return the sleep that was removed
	 * @throws PortalException if a sleep with the primary key could not be found
	 */
	@Override
	public com.tokogae.data.event.model.Sleep deleteSleep(long sleepId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sleepLocalService.deleteSleep(sleepId);
	}

	/**
	 * Deletes the sleep from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SleepLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sleep the sleep
	 * @return the sleep that was removed
	 */
	@Override
	public com.tokogae.data.event.model.Sleep deleteSleep(
		com.tokogae.data.event.model.Sleep sleep) {

		return _sleepLocalService.deleteSleep(sleep);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _sleepLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _sleepLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _sleepLocalService.dynamicQuery();
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

		return _sleepLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tokogae.data.event.model.impl.SleepModelImpl</code>.
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

		return _sleepLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tokogae.data.event.model.impl.SleepModelImpl</code>.
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

		return _sleepLocalService.dynamicQuery(
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

		return _sleepLocalService.dynamicQueryCount(dynamicQuery);
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

		return _sleepLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.tokogae.data.event.model.Sleep fetchSleep(long sleepId) {
		return _sleepLocalService.fetchSleep(sleepId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _sleepLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _sleepLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _sleepLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sleepLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the sleep with the primary key.
	 *
	 * @param sleepId the primary key of the sleep
	 * @return the sleep
	 * @throws PortalException if a sleep with the primary key could not be found
	 */
	@Override
	public com.tokogae.data.event.model.Sleep getSleep(long sleepId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sleepLocalService.getSleep(sleepId);
	}

	/**
	 * Returns a range of all the sleeps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tokogae.data.event.model.impl.SleepModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sleeps
	 * @param end the upper bound of the range of sleeps (not inclusive)
	 * @return the range of sleeps
	 */
	@Override
	public java.util.List<com.tokogae.data.event.model.Sleep> getSleeps(
		int start, int end) {

		return _sleepLocalService.getSleeps(start, end);
	}

	/**
	 * Returns the number of sleeps.
	 *
	 * @return the number of sleeps
	 */
	@Override
	public int getSleepsCount() {
		return _sleepLocalService.getSleepsCount();
	}

	@Override
	public com.tokogae.data.event.model.Sleep updateSleep(
			long sleepId, long occurDayBaseTime, long occurDayNativeTime,
			long duration)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sleepLocalService.updateSleep(
			sleepId, occurDayBaseTime, occurDayNativeTime, duration);
	}

	/**
	 * Updates the sleep in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SleepLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sleep the sleep
	 * @return the sleep that was updated
	 */
	@Override
	public com.tokogae.data.event.model.Sleep updateSleep(
		com.tokogae.data.event.model.Sleep sleep) {

		return _sleepLocalService.updateSleep(sleep);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _sleepLocalService.getBasePersistence();
	}

	@Override
	public SleepLocalService getWrappedService() {
		return _sleepLocalService;
	}

	@Override
	public void setWrappedService(SleepLocalService sleepLocalService) {
		_sleepLocalService = sleepLocalService;
	}

	private SleepLocalService _sleepLocalService;

}