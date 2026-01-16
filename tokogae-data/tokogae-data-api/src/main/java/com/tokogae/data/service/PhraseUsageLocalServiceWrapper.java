/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link PhraseUsageLocalService}.
 *
 * @author Amos Fong
 * @see PhraseUsageLocalService
 * @generated
 */
public class PhraseUsageLocalServiceWrapper
	implements PhraseUsageLocalService,
			   ServiceWrapper<PhraseUsageLocalService> {

	public PhraseUsageLocalServiceWrapper() {
		this(null);
	}

	public PhraseUsageLocalServiceWrapper(
		PhraseUsageLocalService phraseUsageLocalService) {

		_phraseUsageLocalService = phraseUsageLocalService;
	}

	@Override
	public com.tokogae.data.model.PhraseUsage addPhraseUsage(
		long userId, long phraseId, long classNameId, long classPK) {

		return _phraseUsageLocalService.addPhraseUsage(
			userId, phraseId, classNameId, classPK);
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
	@Override
	public com.tokogae.data.model.PhraseUsage addPhraseUsage(
		com.tokogae.data.model.PhraseUsage phraseUsage) {

		return _phraseUsageLocalService.addPhraseUsage(phraseUsage);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phraseUsageLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new phrase usage with the primary key. Does not add the phrase usage to the database.
	 *
	 * @param phraseUsageId the primary key for the new phrase usage
	 * @return the new phrase usage
	 */
	@Override
	public com.tokogae.data.model.PhraseUsage createPhraseUsage(
		long phraseUsageId) {

		return _phraseUsageLocalService.createPhraseUsage(phraseUsageId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phraseUsageLocalService.deletePersistedModel(persistedModel);
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
	@Override
	public com.tokogae.data.model.PhraseUsage deletePhraseUsage(
			long phraseUsageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phraseUsageLocalService.deletePhraseUsage(phraseUsageId);
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
	@Override
	public com.tokogae.data.model.PhraseUsage deletePhraseUsage(
		com.tokogae.data.model.PhraseUsage phraseUsage) {

		return _phraseUsageLocalService.deletePhraseUsage(phraseUsage);
	}

	@Override
	public void deletePhraseUsages(long classNameId, long classPK) {
		_phraseUsageLocalService.deletePhraseUsages(classNameId, classPK);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _phraseUsageLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _phraseUsageLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _phraseUsageLocalService.dynamicQuery();
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

		return _phraseUsageLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _phraseUsageLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _phraseUsageLocalService.dynamicQuery(
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

		return _phraseUsageLocalService.dynamicQueryCount(dynamicQuery);
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

		return _phraseUsageLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.tokogae.data.model.PhraseUsage fetchPhraseUsage(
		long phraseUsageId) {

		return _phraseUsageLocalService.fetchPhraseUsage(phraseUsageId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _phraseUsageLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _phraseUsageLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _phraseUsageLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phraseUsageLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the phrase usage with the primary key.
	 *
	 * @param phraseUsageId the primary key of the phrase usage
	 * @return the phrase usage
	 * @throws PortalException if a phrase usage with the primary key could not be found
	 */
	@Override
	public com.tokogae.data.model.PhraseUsage getPhraseUsage(long phraseUsageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phraseUsageLocalService.getPhraseUsage(phraseUsageId);
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
	@Override
	public java.util.List<com.tokogae.data.model.PhraseUsage> getPhraseUsages(
		int start, int end) {

		return _phraseUsageLocalService.getPhraseUsages(start, end);
	}

	@Override
	public java.util.List<com.tokogae.data.model.PhraseUsage> getPhraseUsages(
		long phraseId) {

		return _phraseUsageLocalService.getPhraseUsages(phraseId);
	}

	/**
	 * Returns the number of phrase usages.
	 *
	 * @return the number of phrase usages
	 */
	@Override
	public int getPhraseUsagesCount() {
		return _phraseUsageLocalService.getPhraseUsagesCount();
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
	@Override
	public com.tokogae.data.model.PhraseUsage updatePhraseUsage(
		com.tokogae.data.model.PhraseUsage phraseUsage) {

		return _phraseUsageLocalService.updatePhraseUsage(phraseUsage);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _phraseUsageLocalService.getBasePersistence();
	}

	@Override
	public PhraseUsageLocalService getWrappedService() {
		return _phraseUsageLocalService;
	}

	@Override
	public void setWrappedService(
		PhraseUsageLocalService phraseUsageLocalService) {

		_phraseUsageLocalService = phraseUsageLocalService;
	}

	private PhraseUsageLocalService _phraseUsageLocalService;

}