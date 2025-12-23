/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link SymptomPeriodLocalService}.
 *
 * @author Amos Fong
 * @see SymptomPeriodLocalService
 * @generated
 */
public class SymptomPeriodLocalServiceWrapper
	implements ServiceWrapper<SymptomPeriodLocalService>,
			   SymptomPeriodLocalService {

	public SymptomPeriodLocalServiceWrapper() {
		this(null);
	}

	public SymptomPeriodLocalServiceWrapper(
		SymptomPeriodLocalService symptomPeriodLocalService) {

		_symptomPeriodLocalService = symptomPeriodLocalService;
	}

	@Override
	public com.tokogae.data.event.model.SymptomPeriod addSymptomPeriod(
			long userId, long subjectId, String name, java.util.Date startDate,
			java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _symptomPeriodLocalService.addSymptomPeriod(
			userId, subjectId, name, startDate, endDate);
	}

	/**
	 * Adds the symptom period to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SymptomPeriodLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param symptomPeriod the symptom period
	 * @return the symptom period that was added
	 */
	@Override
	public com.tokogae.data.event.model.SymptomPeriod addSymptomPeriod(
		com.tokogae.data.event.model.SymptomPeriod symptomPeriod) {

		return _symptomPeriodLocalService.addSymptomPeriod(symptomPeriod);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _symptomPeriodLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new symptom period with the primary key. Does not add the symptom period to the database.
	 *
	 * @param symptomId the primary key for the new symptom period
	 * @return the new symptom period
	 */
	@Override
	public com.tokogae.data.event.model.SymptomPeriod createSymptomPeriod(
		long symptomId) {

		return _symptomPeriodLocalService.createSymptomPeriod(symptomId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _symptomPeriodLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the symptom period with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SymptomPeriodLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param symptomId the primary key of the symptom period
	 * @return the symptom period that was removed
	 * @throws PortalException if a symptom period with the primary key could not be found
	 */
	@Override
	public com.tokogae.data.event.model.SymptomPeriod deleteSymptomPeriod(
			long symptomId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _symptomPeriodLocalService.deleteSymptomPeriod(symptomId);
	}

	/**
	 * Deletes the symptom period from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SymptomPeriodLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param symptomPeriod the symptom period
	 * @return the symptom period that was removed
	 */
	@Override
	public com.tokogae.data.event.model.SymptomPeriod deleteSymptomPeriod(
		com.tokogae.data.event.model.SymptomPeriod symptomPeriod) {

		return _symptomPeriodLocalService.deleteSymptomPeriod(symptomPeriod);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _symptomPeriodLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _symptomPeriodLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _symptomPeriodLocalService.dynamicQuery();
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

		return _symptomPeriodLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tokogae.data.event.model.impl.SymptomPeriodModelImpl</code>.
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

		return _symptomPeriodLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tokogae.data.event.model.impl.SymptomPeriodModelImpl</code>.
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

		return _symptomPeriodLocalService.dynamicQuery(
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

		return _symptomPeriodLocalService.dynamicQueryCount(dynamicQuery);
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

		return _symptomPeriodLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.tokogae.data.event.model.SymptomPeriod fetchSymptomPeriod(
		long symptomId) {

		return _symptomPeriodLocalService.fetchSymptomPeriod(symptomId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _symptomPeriodLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _symptomPeriodLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _symptomPeriodLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _symptomPeriodLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the symptom period with the primary key.
	 *
	 * @param symptomId the primary key of the symptom period
	 * @return the symptom period
	 * @throws PortalException if a symptom period with the primary key could not be found
	 */
	@Override
	public com.tokogae.data.event.model.SymptomPeriod getSymptomPeriod(
			long symptomId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _symptomPeriodLocalService.getSymptomPeriod(symptomId);
	}

	/**
	 * Returns a range of all the symptom periods.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tokogae.data.event.model.impl.SymptomPeriodModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of symptom periods
	 * @param end the upper bound of the range of symptom periods (not inclusive)
	 * @return the range of symptom periods
	 */
	@Override
	public java.util.List<com.tokogae.data.event.model.SymptomPeriod>
		getSymptomPeriods(int start, int end) {

		return _symptomPeriodLocalService.getSymptomPeriods(start, end);
	}

	/**
	 * Returns the number of symptom periods.
	 *
	 * @return the number of symptom periods
	 */
	@Override
	public int getSymptomPeriodsCount() {
		return _symptomPeriodLocalService.getSymptomPeriodsCount();
	}

	@Override
	public com.tokogae.data.event.model.SymptomPeriod updateSymptomPeriod(
			long symptomPeriodId, String name, java.util.Date startDate,
			java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _symptomPeriodLocalService.updateSymptomPeriod(
			symptomPeriodId, name, startDate, endDate);
	}

	/**
	 * Updates the symptom period in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SymptomPeriodLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param symptomPeriod the symptom period
	 * @return the symptom period that was updated
	 */
	@Override
	public com.tokogae.data.event.model.SymptomPeriod updateSymptomPeriod(
		com.tokogae.data.event.model.SymptomPeriod symptomPeriod) {

		return _symptomPeriodLocalService.updateSymptomPeriod(symptomPeriod);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _symptomPeriodLocalService.getBasePersistence();
	}

	@Override
	public SymptomPeriodLocalService getWrappedService() {
		return _symptomPeriodLocalService;
	}

	@Override
	public void setWrappedService(
		SymptomPeriodLocalService symptomPeriodLocalService) {

		_symptomPeriodLocalService = symptomPeriodLocalService;
	}

	private SymptomPeriodLocalService _symptomPeriodLocalService;

}