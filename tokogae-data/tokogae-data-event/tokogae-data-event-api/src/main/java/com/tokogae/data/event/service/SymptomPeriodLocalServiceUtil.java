/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.tokogae.data.event.model.SymptomPeriod;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for SymptomPeriod. This utility wraps
 * <code>com.tokogae.data.event.service.impl.SymptomPeriodLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Amos Fong
 * @see SymptomPeriodLocalService
 * @generated
 */
public class SymptomPeriodLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.tokogae.data.event.service.impl.SymptomPeriodLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static SymptomPeriod addSymptomPeriod(
			long userId, long subjectId, String name, java.util.Date startDate,
			java.util.Date endDate)
		throws PortalException {

		return getService().addSymptomPeriod(
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
	public static SymptomPeriod addSymptomPeriod(SymptomPeriod symptomPeriod) {
		return getService().addSymptomPeriod(symptomPeriod);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new symptom period with the primary key. Does not add the symptom period to the database.
	 *
	 * @param symptomId the primary key for the new symptom period
	 * @return the new symptom period
	 */
	public static SymptomPeriod createSymptomPeriod(long symptomId) {
		return getService().createSymptomPeriod(symptomId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	public static SymptomPeriod deleteSymptomPeriod(long symptomId)
		throws PortalException {

		return getService().deleteSymptomPeriod(symptomId);
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
	public static SymptomPeriod deleteSymptomPeriod(
		SymptomPeriod symptomPeriod) {

		return getService().deleteSymptomPeriod(symptomPeriod);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static SymptomPeriod fetchSymptomPeriod(long symptomId) {
		return getService().fetchSymptomPeriod(symptomId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the symptom period with the primary key.
	 *
	 * @param symptomId the primary key of the symptom period
	 * @return the symptom period
	 * @throws PortalException if a symptom period with the primary key could not be found
	 */
	public static SymptomPeriod getSymptomPeriod(long symptomId)
		throws PortalException {

		return getService().getSymptomPeriod(symptomId);
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
	public static List<SymptomPeriod> getSymptomPeriods(int start, int end) {
		return getService().getSymptomPeriods(start, end);
	}

	/**
	 * Returns the number of symptom periods.
	 *
	 * @return the number of symptom periods
	 */
	public static int getSymptomPeriodsCount() {
		return getService().getSymptomPeriodsCount();
	}

	public static SymptomPeriod updateSymptomPeriod(
			long symptomPeriodId, String name, java.util.Date startDate,
			java.util.Date endDate)
		throws PortalException {

		return getService().updateSymptomPeriod(
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
	public static SymptomPeriod updateSymptomPeriod(
		SymptomPeriod symptomPeriod) {

		return getService().updateSymptomPeriod(symptomPeriod);
	}

	public static SymptomPeriodLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<SymptomPeriodLocalService> _serviceSnapshot =
		new Snapshot<>(
			SymptomPeriodLocalServiceUtil.class,
			SymptomPeriodLocalService.class);

}