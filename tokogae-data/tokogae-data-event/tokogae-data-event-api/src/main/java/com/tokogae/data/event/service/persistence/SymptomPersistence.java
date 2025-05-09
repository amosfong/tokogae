/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.tokogae.data.event.exception.NoSuchSymptomException;
import com.tokogae.data.event.model.Symptom;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the symptom service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Amos Fong
 * @see SymptomUtil
 * @generated
 */
@ProviderType
public interface SymptomPersistence extends BasePersistence<Symptom> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SymptomUtil} to access the symptom persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the symptom in the entity cache if it is enabled.
	 *
	 * @param symptom the symptom
	 */
	public void cacheResult(Symptom symptom);

	/**
	 * Caches the symptoms in the entity cache if it is enabled.
	 *
	 * @param symptoms the symptoms
	 */
	public void cacheResult(java.util.List<Symptom> symptoms);

	/**
	 * Creates a new symptom with the primary key. Does not add the symptom to the database.
	 *
	 * @param symptomId the primary key for the new symptom
	 * @return the new symptom
	 */
	public Symptom create(long symptomId);

	/**
	 * Removes the symptom with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param symptomId the primary key of the symptom
	 * @return the symptom that was removed
	 * @throws NoSuchSymptomException if a symptom with the primary key could not be found
	 */
	public Symptom remove(long symptomId) throws NoSuchSymptomException;

	public Symptom updateImpl(Symptom symptom);

	/**
	 * Returns the symptom with the primary key or throws a <code>NoSuchSymptomException</code> if it could not be found.
	 *
	 * @param symptomId the primary key of the symptom
	 * @return the symptom
	 * @throws NoSuchSymptomException if a symptom with the primary key could not be found
	 */
	public Symptom findByPrimaryKey(long symptomId)
		throws NoSuchSymptomException;

	/**
	 * Returns the symptom with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param symptomId the primary key of the symptom
	 * @return the symptom, or <code>null</code> if a symptom with the primary key could not be found
	 */
	public Symptom fetchByPrimaryKey(long symptomId);

	/**
	 * Returns all the symptoms.
	 *
	 * @return the symptoms
	 */
	public java.util.List<Symptom> findAll();

	/**
	 * Returns a range of all the symptoms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SymptomModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of symptoms
	 * @param end the upper bound of the range of symptoms (not inclusive)
	 * @return the range of symptoms
	 */
	public java.util.List<Symptom> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the symptoms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SymptomModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of symptoms
	 * @param end the upper bound of the range of symptoms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of symptoms
	 */
	public java.util.List<Symptom> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Symptom>
			orderByComparator);

	/**
	 * Returns an ordered range of all the symptoms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SymptomModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of symptoms
	 * @param end the upper bound of the range of symptoms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of symptoms
	 */
	public java.util.List<Symptom> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Symptom>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the symptoms from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of symptoms.
	 *
	 * @return the number of symptoms
	 */
	public int countAll();

}