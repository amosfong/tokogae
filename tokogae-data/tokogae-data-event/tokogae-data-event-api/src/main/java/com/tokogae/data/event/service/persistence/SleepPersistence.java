/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.tokogae.data.event.exception.NoSuchSleepException;
import com.tokogae.data.event.model.Sleep;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the sleep service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Amos Fong
 * @see SleepUtil
 * @generated
 */
@ProviderType
public interface SleepPersistence extends BasePersistence<Sleep> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SleepUtil} to access the sleep persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the sleep in the entity cache if it is enabled.
	 *
	 * @param sleep the sleep
	 */
	public void cacheResult(Sleep sleep);

	/**
	 * Caches the sleeps in the entity cache if it is enabled.
	 *
	 * @param sleeps the sleeps
	 */
	public void cacheResult(java.util.List<Sleep> sleeps);

	/**
	 * Creates a new sleep with the primary key. Does not add the sleep to the database.
	 *
	 * @param sleepId the primary key for the new sleep
	 * @return the new sleep
	 */
	public Sleep create(long sleepId);

	/**
	 * Removes the sleep with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sleepId the primary key of the sleep
	 * @return the sleep that was removed
	 * @throws NoSuchSleepException if a sleep with the primary key could not be found
	 */
	public Sleep remove(long sleepId) throws NoSuchSleepException;

	public Sleep updateImpl(Sleep sleep);

	/**
	 * Returns the sleep with the primary key or throws a <code>NoSuchSleepException</code> if it could not be found.
	 *
	 * @param sleepId the primary key of the sleep
	 * @return the sleep
	 * @throws NoSuchSleepException if a sleep with the primary key could not be found
	 */
	public Sleep findByPrimaryKey(long sleepId) throws NoSuchSleepException;

	/**
	 * Returns the sleep with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sleepId the primary key of the sleep
	 * @return the sleep, or <code>null</code> if a sleep with the primary key could not be found
	 */
	public Sleep fetchByPrimaryKey(long sleepId);

	/**
	 * Returns all the sleeps.
	 *
	 * @return the sleeps
	 */
	public java.util.List<Sleep> findAll();

	/**
	 * Returns a range of all the sleeps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SleepModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sleeps
	 * @param end the upper bound of the range of sleeps (not inclusive)
	 * @return the range of sleeps
	 */
	public java.util.List<Sleep> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the sleeps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SleepModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sleeps
	 * @param end the upper bound of the range of sleeps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sleeps
	 */
	public java.util.List<Sleep> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Sleep>
			orderByComparator);

	/**
	 * Returns an ordered range of all the sleeps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SleepModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sleeps
	 * @param end the upper bound of the range of sleeps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sleeps
	 */
	public java.util.List<Sleep> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Sleep>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the sleeps from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of sleeps.
	 *
	 * @return the number of sleeps
	 */
	public int countAll();

}