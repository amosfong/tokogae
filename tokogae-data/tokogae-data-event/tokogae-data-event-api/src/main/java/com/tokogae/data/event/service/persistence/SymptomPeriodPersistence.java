/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.tokogae.data.event.exception.NoSuchSymptomPeriodException;
import com.tokogae.data.event.model.SymptomPeriod;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the symptom period service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Amos Fong
 * @see SymptomPeriodUtil
 * @generated
 */
@ProviderType
public interface SymptomPeriodPersistence
	extends BasePersistence<SymptomPeriod> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SymptomPeriodUtil} to access the symptom period persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the symptom period in the entity cache if it is enabled.
	 *
	 * @param symptomPeriod the symptom period
	 */
	public void cacheResult(SymptomPeriod symptomPeriod);

	/**
	 * Caches the symptom periods in the entity cache if it is enabled.
	 *
	 * @param symptomPeriods the symptom periods
	 */
	public void cacheResult(java.util.List<SymptomPeriod> symptomPeriods);

	/**
	 * Creates a new symptom period with the primary key. Does not add the symptom period to the database.
	 *
	 * @param symptomId the primary key for the new symptom period
	 * @return the new symptom period
	 */
	public SymptomPeriod create(long symptomId);

	/**
	 * Removes the symptom period with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param symptomId the primary key of the symptom period
	 * @return the symptom period that was removed
	 * @throws NoSuchSymptomPeriodException if a symptom period with the primary key could not be found
	 */
	public SymptomPeriod remove(long symptomId)
		throws NoSuchSymptomPeriodException;

	public SymptomPeriod updateImpl(SymptomPeriod symptomPeriod);

	/**
	 * Returns the symptom period with the primary key or throws a <code>NoSuchSymptomPeriodException</code> if it could not be found.
	 *
	 * @param symptomId the primary key of the symptom period
	 * @return the symptom period
	 * @throws NoSuchSymptomPeriodException if a symptom period with the primary key could not be found
	 */
	public SymptomPeriod findByPrimaryKey(long symptomId)
		throws NoSuchSymptomPeriodException;

	/**
	 * Returns the symptom period with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param symptomId the primary key of the symptom period
	 * @return the symptom period, or <code>null</code> if a symptom period with the primary key could not be found
	 */
	public SymptomPeriod fetchByPrimaryKey(long symptomId);

	/**
	 * Returns all the symptom periods.
	 *
	 * @return the symptom periods
	 */
	public java.util.List<SymptomPeriod> findAll();

	/**
	 * Returns a range of all the symptom periods.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SymptomPeriodModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of symptom periods
	 * @param end the upper bound of the range of symptom periods (not inclusive)
	 * @return the range of symptom periods
	 */
	public java.util.List<SymptomPeriod> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the symptom periods.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SymptomPeriodModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of symptom periods
	 * @param end the upper bound of the range of symptom periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of symptom periods
	 */
	public java.util.List<SymptomPeriod> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SymptomPeriod>
			orderByComparator);

	/**
	 * Returns an ordered range of all the symptom periods.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SymptomPeriodModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of symptom periods
	 * @param end the upper bound of the range of symptom periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of symptom periods
	 */
	public java.util.List<SymptomPeriod> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SymptomPeriod>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the symptom periods from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of symptom periods.
	 *
	 * @return the number of symptom periods
	 */
	public int countAll();

}