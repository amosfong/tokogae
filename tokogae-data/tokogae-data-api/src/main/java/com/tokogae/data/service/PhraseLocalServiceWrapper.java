/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link PhraseLocalService}.
 *
 * @author Amos Fong
 * @see PhraseLocalService
 * @generated
 */
public class PhraseLocalServiceWrapper
	implements PhraseLocalService, ServiceWrapper<PhraseLocalService> {

	public PhraseLocalServiceWrapper() {
		this(null);
	}

	public PhraseLocalServiceWrapper(PhraseLocalService phraseLocalService) {
		_phraseLocalService = phraseLocalService;
	}

	/**
	 * Adds the phrase to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PhraseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param phrase the phrase
	 * @return the phrase that was added
	 */
	@Override
	public com.tokogae.data.model.Phrase addPhrase(
		com.tokogae.data.model.Phrase phrase) {

		return _phraseLocalService.addPhrase(phrase);
	}

	@Override
	public com.tokogae.data.model.Phrase addPhrase(String text) {
		return _phraseLocalService.addPhrase(text);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phraseLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new phrase with the primary key. Does not add the phrase to the database.
	 *
	 * @param phraseId the primary key for the new phrase
	 * @return the new phrase
	 */
	@Override
	public com.tokogae.data.model.Phrase createPhrase(long phraseId) {
		return _phraseLocalService.createPhrase(phraseId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phraseLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the phrase with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PhraseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param phraseId the primary key of the phrase
	 * @return the phrase that was removed
	 * @throws PortalException if a phrase with the primary key could not be found
	 */
	@Override
	public com.tokogae.data.model.Phrase deletePhrase(long phraseId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phraseLocalService.deletePhrase(phraseId);
	}

	/**
	 * Deletes the phrase from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PhraseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param phrase the phrase
	 * @return the phrase that was removed
	 */
	@Override
	public com.tokogae.data.model.Phrase deletePhrase(
		com.tokogae.data.model.Phrase phrase) {

		return _phraseLocalService.deletePhrase(phrase);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _phraseLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _phraseLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _phraseLocalService.dynamicQuery();
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

		return _phraseLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tokogae.data.model.impl.PhraseModelImpl</code>.
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

		return _phraseLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tokogae.data.model.impl.PhraseModelImpl</code>.
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

		return _phraseLocalService.dynamicQuery(
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

		return _phraseLocalService.dynamicQueryCount(dynamicQuery);
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

		return _phraseLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.tokogae.data.model.Phrase fetchPhrase(long phraseId) {
		return _phraseLocalService.fetchPhrase(phraseId);
	}

	@Override
	public com.tokogae.data.model.Phrase fetchPhraseByText(String text) {
		return _phraseLocalService.fetchPhraseByText(text);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _phraseLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _phraseLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _phraseLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phraseLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the phrase with the primary key.
	 *
	 * @param phraseId the primary key of the phrase
	 * @return the phrase
	 * @throws PortalException if a phrase with the primary key could not be found
	 */
	@Override
	public com.tokogae.data.model.Phrase getPhrase(long phraseId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phraseLocalService.getPhrase(phraseId);
	}

	/**
	 * Returns a range of all the phrases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tokogae.data.model.impl.PhraseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phrases
	 * @param end the upper bound of the range of phrases (not inclusive)
	 * @return the range of phrases
	 */
	@Override
	public java.util.List<com.tokogae.data.model.Phrase> getPhrases(
		int start, int end) {

		return _phraseLocalService.getPhrases(start, end);
	}

	/**
	 * Returns the number of phrases.
	 *
	 * @return the number of phrases
	 */
	@Override
	public int getPhrasesCount() {
		return _phraseLocalService.getPhrasesCount();
	}

	/**
	 * Updates the phrase in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PhraseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param phrase the phrase
	 * @return the phrase that was updated
	 */
	@Override
	public com.tokogae.data.model.Phrase updatePhrase(
		com.tokogae.data.model.Phrase phrase) {

		return _phraseLocalService.updatePhrase(phrase);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _phraseLocalService.getBasePersistence();
	}

	@Override
	public PhraseLocalService getWrappedService() {
		return _phraseLocalService;
	}

	@Override
	public void setWrappedService(PhraseLocalService phraseLocalService) {
		_phraseLocalService = phraseLocalService;
	}

	private PhraseLocalService _phraseLocalService;

}