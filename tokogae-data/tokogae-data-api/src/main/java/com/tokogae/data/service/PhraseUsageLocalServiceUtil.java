/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.tokogae.data.model.PhraseUsage;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for PhraseUsage. This utility wraps
 * <code>com.tokogae.data.service.impl.PhraseUsageLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Amos Fong
 * @see PhraseUsageLocalService
 * @generated
 */
public class PhraseUsageLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.tokogae.data.service.impl.PhraseUsageLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static PhraseUsage addPhraseUsage(
		long userId, long phraseId, String className, long classPK,
		int attributesHashCode) {

		return getService().addPhraseUsage(
			userId, phraseId, className, classPK, attributesHashCode);
	}

	/**
	 * Adds the phrase usage to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PhraseUsageLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param phraseUsage the phrase usage
	 * @return the phrase usage that was added
	 */
	public static PhraseUsage addPhraseUsage(PhraseUsage phraseUsage) {
		return getService().addPhraseUsage(phraseUsage);
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
	 * Creates a new phrase usage with the primary key. Does not add the phrase usage to the database.
	 *
	 * @param phraseUsageId the primary key for the new phrase usage
	 * @return the new phrase usage
	 */
	public static PhraseUsage createPhraseUsage(long phraseUsageId) {
		return getService().createPhraseUsage(phraseUsageId);
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
	 * Deletes the phrase usage with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PhraseUsageLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param phraseUsageId the primary key of the phrase usage
	 * @return the phrase usage that was removed
	 * @throws PortalException if a phrase usage with the primary key could not be found
	 */
	public static PhraseUsage deletePhraseUsage(long phraseUsageId)
		throws PortalException {

		return getService().deletePhraseUsage(phraseUsageId);
	}

	public static PhraseUsage deletePhraseUsage(long classNameId, long classPK)
		throws PortalException {

		return getService().deletePhraseUsage(classNameId, classPK);
	}

	/**
	 * Deletes the phrase usage from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PhraseUsageLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param phraseUsage the phrase usage
	 * @return the phrase usage that was removed
	 */
	public static PhraseUsage deletePhraseUsage(PhraseUsage phraseUsage) {
		return getService().deletePhraseUsage(phraseUsage);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tokogae.data.model.impl.PhraseUsageModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tokogae.data.model.impl.PhraseUsageModelImpl</code>.
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

	public static PhraseUsage fetchPhraseUsage(long phraseUsageId) {
		return getService().fetchPhraseUsage(phraseUsageId);
	}

	public static PhraseUsage fetchPhraseUsage(String className, long classPK) {
		return getService().fetchPhraseUsage(className, classPK);
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
	 * Returns the phrase usage with the primary key.
	 *
	 * @param phraseUsageId the primary key of the phrase usage
	 * @return the phrase usage
	 * @throws PortalException if a phrase usage with the primary key could not be found
	 */
	public static PhraseUsage getPhraseUsage(long phraseUsageId)
		throws PortalException {

		return getService().getPhraseUsage(phraseUsageId);
	}

	/**
	 * Returns a range of all the phrase usages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tokogae.data.model.impl.PhraseUsageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phrase usages
	 * @param end the upper bound of the range of phrase usages (not inclusive)
	 * @return the range of phrase usages
	 */
	public static List<PhraseUsage> getPhraseUsages(int start, int end) {
		return getService().getPhraseUsages(start, end);
	}

	public static List<PhraseUsage> getPhraseUsages(
			long phraseId, int start, int end)
		throws PortalException {

		return getService().getPhraseUsages(phraseId, start, end);
	}

	/**
	 * Returns the number of phrase usages.
	 *
	 * @return the number of phrase usages
	 */
	public static int getPhraseUsagesCount() {
		return getService().getPhraseUsagesCount();
	}

	public static PhraseUsage updatePhraseUsage(
			long phraseUsageId, int attributesHashCode)
		throws PortalException {

		return getService().updatePhraseUsage(
			phraseUsageId, attributesHashCode);
	}

	/**
	 * Updates the phrase usage in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PhraseUsageLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param phraseUsage the phrase usage
	 * @return the phrase usage that was updated
	 */
	public static PhraseUsage updatePhraseUsage(PhraseUsage phraseUsage) {
		return getService().updatePhraseUsage(phraseUsage);
	}

	public static PhraseUsageLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<PhraseUsageLocalService> _serviceSnapshot =
		new Snapshot<>(
			PhraseUsageLocalServiceUtil.class, PhraseUsageLocalService.class);

}