/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.tokogae.data.exception.NoSuchPhraseException;
import com.tokogae.data.model.Phrase;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the phrase service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Amos Fong
 * @see PhraseUtil
 * @generated
 */
@ProviderType
public interface PhrasePersistence extends BasePersistence<Phrase> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PhraseUtil} to access the phrase persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the phrase where text = &#63; or throws a <code>NoSuchPhraseException</code> if it could not be found.
	 *
	 * @param text the text
	 * @return the matching phrase
	 * @throws NoSuchPhraseException if a matching phrase could not be found
	 */
	public Phrase findByText(String text) throws NoSuchPhraseException;

	/**
	 * Returns the phrase where text = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param text the text
	 * @return the matching phrase, or <code>null</code> if a matching phrase could not be found
	 */
	public Phrase fetchByText(String text);

	/**
	 * Returns the phrase where text = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param text the text
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching phrase, or <code>null</code> if a matching phrase could not be found
	 */
	public Phrase fetchByText(String text, boolean useFinderCache);

	/**
	 * Removes the phrase where text = &#63; from the database.
	 *
	 * @param text the text
	 * @return the phrase that was removed
	 */
	public Phrase removeByText(String text) throws NoSuchPhraseException;

	/**
	 * Returns the number of phrases where text = &#63;.
	 *
	 * @param text the text
	 * @return the number of matching phrases
	 */
	public int countByText(String text);

	/**
	 * Caches the phrase in the entity cache if it is enabled.
	 *
	 * @param phrase the phrase
	 */
	public void cacheResult(Phrase phrase);

	/**
	 * Caches the phrases in the entity cache if it is enabled.
	 *
	 * @param phrases the phrases
	 */
	public void cacheResult(java.util.List<Phrase> phrases);

	/**
	 * Creates a new phrase with the primary key. Does not add the phrase to the database.
	 *
	 * @param phraseId the primary key for the new phrase
	 * @return the new phrase
	 */
	public Phrase create(long phraseId);

	/**
	 * Removes the phrase with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param phraseId the primary key of the phrase
	 * @return the phrase that was removed
	 * @throws NoSuchPhraseException if a phrase with the primary key could not be found
	 */
	public Phrase remove(long phraseId) throws NoSuchPhraseException;

	public Phrase updateImpl(Phrase phrase);

	/**
	 * Returns the phrase with the primary key or throws a <code>NoSuchPhraseException</code> if it could not be found.
	 *
	 * @param phraseId the primary key of the phrase
	 * @return the phrase
	 * @throws NoSuchPhraseException if a phrase with the primary key could not be found
	 */
	public Phrase findByPrimaryKey(long phraseId) throws NoSuchPhraseException;

	/**
	 * Returns the phrase with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param phraseId the primary key of the phrase
	 * @return the phrase, or <code>null</code> if a phrase with the primary key could not be found
	 */
	public Phrase fetchByPrimaryKey(long phraseId);

	/**
	 * Returns all the phrases.
	 *
	 * @return the phrases
	 */
	public java.util.List<Phrase> findAll();

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
	public java.util.List<Phrase> findAll(int start, int end);

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
	public java.util.List<Phrase> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Phrase>
			orderByComparator);

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
	public java.util.List<Phrase> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Phrase>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the phrases from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of phrases.
	 *
	 * @return the number of phrases
	 */
	public int countAll();

}