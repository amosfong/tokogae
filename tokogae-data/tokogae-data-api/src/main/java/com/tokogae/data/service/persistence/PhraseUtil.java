/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.tokogae.data.model.Phrase;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the phrase service. This utility wraps <code>com.tokogae.data.service.persistence.impl.PhrasePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Amos Fong
 * @see PhrasePersistence
 * @generated
 */
public class PhraseUtil {

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
	public static void clearCache(Phrase phrase) {
		getPersistence().clearCache(phrase);
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
	public static Map<Serializable, Phrase> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Phrase> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Phrase> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Phrase> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Phrase> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Phrase update(Phrase phrase) {
		return getPersistence().update(phrase);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Phrase update(Phrase phrase, ServiceContext serviceContext) {
		return getPersistence().update(phrase, serviceContext);
	}

	/**
	 * Returns the phrase where text = &#63; or throws a <code>NoSuchPhraseException</code> if it could not be found.
	 *
	 * @param text the text
	 * @return the matching phrase
	 * @throws NoSuchPhraseException if a matching phrase could not be found
	 */
	public static Phrase findByText(String text)
		throws com.tokogae.data.exception.NoSuchPhraseException {

		return getPersistence().findByText(text);
	}

	/**
	 * Returns the phrase where text = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param text the text
	 * @return the matching phrase, or <code>null</code> if a matching phrase could not be found
	 */
	public static Phrase fetchByText(String text) {
		return getPersistence().fetchByText(text);
	}

	/**
	 * Returns the phrase where text = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param text the text
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching phrase, or <code>null</code> if a matching phrase could not be found
	 */
	public static Phrase fetchByText(String text, boolean useFinderCache) {
		return getPersistence().fetchByText(text, useFinderCache);
	}

	/**
	 * Removes the phrase where text = &#63; from the database.
	 *
	 * @param text the text
	 * @return the phrase that was removed
	 */
	public static Phrase removeByText(String text)
		throws com.tokogae.data.exception.NoSuchPhraseException {

		return getPersistence().removeByText(text);
	}

	/**
	 * Returns the number of phrases where text = &#63;.
	 *
	 * @param text the text
	 * @return the number of matching phrases
	 */
	public static int countByText(String text) {
		return getPersistence().countByText(text);
	}

	/**
	 * Caches the phrase in the entity cache if it is enabled.
	 *
	 * @param phrase the phrase
	 */
	public static void cacheResult(Phrase phrase) {
		getPersistence().cacheResult(phrase);
	}

	/**
	 * Caches the phrases in the entity cache if it is enabled.
	 *
	 * @param phrases the phrases
	 */
	public static void cacheResult(List<Phrase> phrases) {
		getPersistence().cacheResult(phrases);
	}

	/**
	 * Creates a new phrase with the primary key. Does not add the phrase to the database.
	 *
	 * @param phraseId the primary key for the new phrase
	 * @return the new phrase
	 */
	public static Phrase create(long phraseId) {
		return getPersistence().create(phraseId);
	}

	/**
	 * Removes the phrase with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param phraseId the primary key of the phrase
	 * @return the phrase that was removed
	 * @throws NoSuchPhraseException if a phrase with the primary key could not be found
	 */
	public static Phrase remove(long phraseId)
		throws com.tokogae.data.exception.NoSuchPhraseException {

		return getPersistence().remove(phraseId);
	}

	public static Phrase updateImpl(Phrase phrase) {
		return getPersistence().updateImpl(phrase);
	}

	/**
	 * Returns the phrase with the primary key or throws a <code>NoSuchPhraseException</code> if it could not be found.
	 *
	 * @param phraseId the primary key of the phrase
	 * @return the phrase
	 * @throws NoSuchPhraseException if a phrase with the primary key could not be found
	 */
	public static Phrase findByPrimaryKey(long phraseId)
		throws com.tokogae.data.exception.NoSuchPhraseException {

		return getPersistence().findByPrimaryKey(phraseId);
	}

	/**
	 * Returns the phrase with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param phraseId the primary key of the phrase
	 * @return the phrase, or <code>null</code> if a phrase with the primary key could not be found
	 */
	public static Phrase fetchByPrimaryKey(long phraseId) {
		return getPersistence().fetchByPrimaryKey(phraseId);
	}

	/**
	 * Returns all the phrases.
	 *
	 * @return the phrases
	 */
	public static List<Phrase> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the phrases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhraseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phrases
	 * @param end the upper bound of the range of phrases (not inclusive)
	 * @return the range of phrases
	 */
	public static List<Phrase> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the phrases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhraseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phrases
	 * @param end the upper bound of the range of phrases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of phrases
	 */
	public static List<Phrase> findAll(
		int start, int end, OrderByComparator<Phrase> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the phrases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhraseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phrases
	 * @param end the upper bound of the range of phrases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of phrases
	 */
	public static List<Phrase> findAll(
		int start, int end, OrderByComparator<Phrase> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the phrases from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of phrases.
	 *
	 * @return the number of phrases
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PhrasePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(PhrasePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile PhrasePersistence _persistence;

}