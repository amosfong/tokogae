/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.tokogae.data.exception.NoSuchPhraseUsageException;
import com.tokogae.data.model.PhraseUsage;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the phrase usage service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Amos Fong
 * @see PhraseUsageUtil
 * @generated
 */
@ProviderType
public interface PhraseUsagePersistence extends BasePersistence<PhraseUsage> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PhraseUsageUtil} to access the phrase usage persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the phrase usages where phraseId = &#63;.
	 *
	 * @param phraseId the phrase ID
	 * @return the matching phrase usages
	 */
	public java.util.List<PhraseUsage> findByPhraseId(long phraseId);

	/**
	 * Returns a range of all the phrase usages where phraseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhraseUsageModelImpl</code>.
	 * </p>
	 *
	 * @param phraseId the phrase ID
	 * @param start the lower bound of the range of phrase usages
	 * @param end the upper bound of the range of phrase usages (not inclusive)
	 * @return the range of matching phrase usages
	 */
	public java.util.List<PhraseUsage> findByPhraseId(
		long phraseId, int start, int end);

	/**
	 * Returns an ordered range of all the phrase usages where phraseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhraseUsageModelImpl</code>.
	 * </p>
	 *
	 * @param phraseId the phrase ID
	 * @param start the lower bound of the range of phrase usages
	 * @param end the upper bound of the range of phrase usages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching phrase usages
	 */
	public java.util.List<PhraseUsage> findByPhraseId(
		long phraseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhraseUsage>
			orderByComparator);

	/**
	 * Returns an ordered range of all the phrase usages where phraseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhraseUsageModelImpl</code>.
	 * </p>
	 *
	 * @param phraseId the phrase ID
	 * @param start the lower bound of the range of phrase usages
	 * @param end the upper bound of the range of phrase usages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching phrase usages
	 */
	public java.util.List<PhraseUsage> findByPhraseId(
		long phraseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhraseUsage>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first phrase usage in the ordered set where phraseId = &#63;.
	 *
	 * @param phraseId the phrase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phrase usage
	 * @throws NoSuchPhraseUsageException if a matching phrase usage could not be found
	 */
	public PhraseUsage findByPhraseId_First(
			long phraseId,
			com.liferay.portal.kernel.util.OrderByComparator<PhraseUsage>
				orderByComparator)
		throws NoSuchPhraseUsageException;

	/**
	 * Returns the first phrase usage in the ordered set where phraseId = &#63;.
	 *
	 * @param phraseId the phrase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phrase usage, or <code>null</code> if a matching phrase usage could not be found
	 */
	public PhraseUsage fetchByPhraseId_First(
		long phraseId,
		com.liferay.portal.kernel.util.OrderByComparator<PhraseUsage>
			orderByComparator);

	/**
	 * Returns the last phrase usage in the ordered set where phraseId = &#63;.
	 *
	 * @param phraseId the phrase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phrase usage
	 * @throws NoSuchPhraseUsageException if a matching phrase usage could not be found
	 */
	public PhraseUsage findByPhraseId_Last(
			long phraseId,
			com.liferay.portal.kernel.util.OrderByComparator<PhraseUsage>
				orderByComparator)
		throws NoSuchPhraseUsageException;

	/**
	 * Returns the last phrase usage in the ordered set where phraseId = &#63;.
	 *
	 * @param phraseId the phrase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phrase usage, or <code>null</code> if a matching phrase usage could not be found
	 */
	public PhraseUsage fetchByPhraseId_Last(
		long phraseId,
		com.liferay.portal.kernel.util.OrderByComparator<PhraseUsage>
			orderByComparator);

	/**
	 * Returns the phrase usages before and after the current phrase usage in the ordered set where phraseId = &#63;.
	 *
	 * @param phraseUsageId the primary key of the current phrase usage
	 * @param phraseId the phrase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next phrase usage
	 * @throws NoSuchPhraseUsageException if a phrase usage with the primary key could not be found
	 */
	public PhraseUsage[] findByPhraseId_PrevAndNext(
			long phraseUsageId, long phraseId,
			com.liferay.portal.kernel.util.OrderByComparator<PhraseUsage>
				orderByComparator)
		throws NoSuchPhraseUsageException;

	/**
	 * Removes all the phrase usages where phraseId = &#63; from the database.
	 *
	 * @param phraseId the phrase ID
	 */
	public void removeByPhraseId(long phraseId);

	/**
	 * Returns the number of phrase usages where phraseId = &#63;.
	 *
	 * @param phraseId the phrase ID
	 * @return the number of matching phrase usages
	 */
	public int countByPhraseId(long phraseId);

	/**
	 * Returns the phrase usage where classNameId = &#63; and classPK = &#63; or throws a <code>NoSuchPhraseUsageException</code> if it could not be found.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @return the matching phrase usage
	 * @throws NoSuchPhraseUsageException if a matching phrase usage could not be found
	 */
	public PhraseUsage findByC_C(long classNameId, long classPK)
		throws NoSuchPhraseUsageException;

	/**
	 * Returns the phrase usage where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @return the matching phrase usage, or <code>null</code> if a matching phrase usage could not be found
	 */
	public PhraseUsage fetchByC_C(long classNameId, long classPK);

	/**
	 * Returns the phrase usage where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching phrase usage, or <code>null</code> if a matching phrase usage could not be found
	 */
	public PhraseUsage fetchByC_C(
		long classNameId, long classPK, boolean useFinderCache);

	/**
	 * Removes the phrase usage where classNameId = &#63; and classPK = &#63; from the database.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @return the phrase usage that was removed
	 */
	public PhraseUsage removeByC_C(long classNameId, long classPK)
		throws NoSuchPhraseUsageException;

	/**
	 * Returns the number of phrase usages where classNameId = &#63; and classPK = &#63;.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @return the number of matching phrase usages
	 */
	public int countByC_C(long classNameId, long classPK);

	/**
	 * Returns all the phrase usages where companyId = &#63; and classNameId = &#63; and attributesHashCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param attributesHashCode the attributes hash code
	 * @return the matching phrase usages
	 */
	public java.util.List<PhraseUsage> findByC_C_AHC(
		long companyId, long classNameId, int attributesHashCode);

	/**
	 * Returns a range of all the phrase usages where companyId = &#63; and classNameId = &#63; and attributesHashCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhraseUsageModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param attributesHashCode the attributes hash code
	 * @param start the lower bound of the range of phrase usages
	 * @param end the upper bound of the range of phrase usages (not inclusive)
	 * @return the range of matching phrase usages
	 */
	public java.util.List<PhraseUsage> findByC_C_AHC(
		long companyId, long classNameId, int attributesHashCode, int start,
		int end);

	/**
	 * Returns an ordered range of all the phrase usages where companyId = &#63; and classNameId = &#63; and attributesHashCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhraseUsageModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param attributesHashCode the attributes hash code
	 * @param start the lower bound of the range of phrase usages
	 * @param end the upper bound of the range of phrase usages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching phrase usages
	 */
	public java.util.List<PhraseUsage> findByC_C_AHC(
		long companyId, long classNameId, int attributesHashCode, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhraseUsage>
			orderByComparator);

	/**
	 * Returns an ordered range of all the phrase usages where companyId = &#63; and classNameId = &#63; and attributesHashCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhraseUsageModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param attributesHashCode the attributes hash code
	 * @param start the lower bound of the range of phrase usages
	 * @param end the upper bound of the range of phrase usages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching phrase usages
	 */
	public java.util.List<PhraseUsage> findByC_C_AHC(
		long companyId, long classNameId, int attributesHashCode, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhraseUsage>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first phrase usage in the ordered set where companyId = &#63; and classNameId = &#63; and attributesHashCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param attributesHashCode the attributes hash code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phrase usage
	 * @throws NoSuchPhraseUsageException if a matching phrase usage could not be found
	 */
	public PhraseUsage findByC_C_AHC_First(
			long companyId, long classNameId, int attributesHashCode,
			com.liferay.portal.kernel.util.OrderByComparator<PhraseUsage>
				orderByComparator)
		throws NoSuchPhraseUsageException;

	/**
	 * Returns the first phrase usage in the ordered set where companyId = &#63; and classNameId = &#63; and attributesHashCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param attributesHashCode the attributes hash code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phrase usage, or <code>null</code> if a matching phrase usage could not be found
	 */
	public PhraseUsage fetchByC_C_AHC_First(
		long companyId, long classNameId, int attributesHashCode,
		com.liferay.portal.kernel.util.OrderByComparator<PhraseUsage>
			orderByComparator);

	/**
	 * Returns the last phrase usage in the ordered set where companyId = &#63; and classNameId = &#63; and attributesHashCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param attributesHashCode the attributes hash code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phrase usage
	 * @throws NoSuchPhraseUsageException if a matching phrase usage could not be found
	 */
	public PhraseUsage findByC_C_AHC_Last(
			long companyId, long classNameId, int attributesHashCode,
			com.liferay.portal.kernel.util.OrderByComparator<PhraseUsage>
				orderByComparator)
		throws NoSuchPhraseUsageException;

	/**
	 * Returns the last phrase usage in the ordered set where companyId = &#63; and classNameId = &#63; and attributesHashCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param attributesHashCode the attributes hash code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phrase usage, or <code>null</code> if a matching phrase usage could not be found
	 */
	public PhraseUsage fetchByC_C_AHC_Last(
		long companyId, long classNameId, int attributesHashCode,
		com.liferay.portal.kernel.util.OrderByComparator<PhraseUsage>
			orderByComparator);

	/**
	 * Returns the phrase usages before and after the current phrase usage in the ordered set where companyId = &#63; and classNameId = &#63; and attributesHashCode = &#63;.
	 *
	 * @param phraseUsageId the primary key of the current phrase usage
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param attributesHashCode the attributes hash code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next phrase usage
	 * @throws NoSuchPhraseUsageException if a phrase usage with the primary key could not be found
	 */
	public PhraseUsage[] findByC_C_AHC_PrevAndNext(
			long phraseUsageId, long companyId, long classNameId,
			int attributesHashCode,
			com.liferay.portal.kernel.util.OrderByComparator<PhraseUsage>
				orderByComparator)
		throws NoSuchPhraseUsageException;

	/**
	 * Removes all the phrase usages where companyId = &#63; and classNameId = &#63; and attributesHashCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param attributesHashCode the attributes hash code
	 */
	public void removeByC_C_AHC(
		long companyId, long classNameId, int attributesHashCode);

	/**
	 * Returns the number of phrase usages where companyId = &#63; and classNameId = &#63; and attributesHashCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param attributesHashCode the attributes hash code
	 * @return the number of matching phrase usages
	 */
	public int countByC_C_AHC(
		long companyId, long classNameId, int attributesHashCode);

	/**
	 * Caches the phrase usage in the entity cache if it is enabled.
	 *
	 * @param phraseUsage the phrase usage
	 */
	public void cacheResult(PhraseUsage phraseUsage);

	/**
	 * Caches the phrase usages in the entity cache if it is enabled.
	 *
	 * @param phraseUsages the phrase usages
	 */
	public void cacheResult(java.util.List<PhraseUsage> phraseUsages);

	/**
	 * Creates a new phrase usage with the primary key. Does not add the phrase usage to the database.
	 *
	 * @param phraseUsageId the primary key for the new phrase usage
	 * @return the new phrase usage
	 */
	public PhraseUsage create(long phraseUsageId);

	/**
	 * Removes the phrase usage with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param phraseUsageId the primary key of the phrase usage
	 * @return the phrase usage that was removed
	 * @throws NoSuchPhraseUsageException if a phrase usage with the primary key could not be found
	 */
	public PhraseUsage remove(long phraseUsageId)
		throws NoSuchPhraseUsageException;

	public PhraseUsage updateImpl(PhraseUsage phraseUsage);

	/**
	 * Returns the phrase usage with the primary key or throws a <code>NoSuchPhraseUsageException</code> if it could not be found.
	 *
	 * @param phraseUsageId the primary key of the phrase usage
	 * @return the phrase usage
	 * @throws NoSuchPhraseUsageException if a phrase usage with the primary key could not be found
	 */
	public PhraseUsage findByPrimaryKey(long phraseUsageId)
		throws NoSuchPhraseUsageException;

	/**
	 * Returns the phrase usage with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param phraseUsageId the primary key of the phrase usage
	 * @return the phrase usage, or <code>null</code> if a phrase usage with the primary key could not be found
	 */
	public PhraseUsage fetchByPrimaryKey(long phraseUsageId);

	/**
	 * Returns all the phrase usages.
	 *
	 * @return the phrase usages
	 */
	public java.util.List<PhraseUsage> findAll();

	/**
	 * Returns a range of all the phrase usages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhraseUsageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phrase usages
	 * @param end the upper bound of the range of phrase usages (not inclusive)
	 * @return the range of phrase usages
	 */
	public java.util.List<PhraseUsage> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the phrase usages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhraseUsageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phrase usages
	 * @param end the upper bound of the range of phrase usages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of phrase usages
	 */
	public java.util.List<PhraseUsage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhraseUsage>
			orderByComparator);

	/**
	 * Returns an ordered range of all the phrase usages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhraseUsageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phrase usages
	 * @param end the upper bound of the range of phrase usages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of phrase usages
	 */
	public java.util.List<PhraseUsage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhraseUsage>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the phrase usages from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of phrase usages.
	 *
	 * @return the number of phrase usages
	 */
	public int countAll();

}