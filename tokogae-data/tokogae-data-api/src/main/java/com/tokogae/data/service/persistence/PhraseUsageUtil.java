/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.tokogae.data.model.PhraseUsage;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the phrase usage service. This utility wraps <code>com.tokogae.data.service.persistence.impl.PhraseUsagePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Amos Fong
 * @see PhraseUsagePersistence
 * @generated
 */
public class PhraseUsageUtil {

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
	public static void clearCache(PhraseUsage phraseUsage) {
		getPersistence().clearCache(phraseUsage);
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
	public static Map<Serializable, PhraseUsage> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PhraseUsage> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PhraseUsage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PhraseUsage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PhraseUsage> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PhraseUsage update(PhraseUsage phraseUsage) {
		return getPersistence().update(phraseUsage);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PhraseUsage update(
		PhraseUsage phraseUsage, ServiceContext serviceContext) {

		return getPersistence().update(phraseUsage, serviceContext);
	}

	/**
	 * Returns all the phrase usages where phraseId = &#63;.
	 *
	 * @param phraseId the phrase ID
	 * @return the matching phrase usages
	 */
	public static List<PhraseUsage> findByPhraseId(long phraseId) {
		return getPersistence().findByPhraseId(phraseId);
	}

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
	public static List<PhraseUsage> findByPhraseId(
		long phraseId, int start, int end) {

		return getPersistence().findByPhraseId(phraseId, start, end);
	}

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
	public static List<PhraseUsage> findByPhraseId(
		long phraseId, int start, int end,
		OrderByComparator<PhraseUsage> orderByComparator) {

		return getPersistence().findByPhraseId(
			phraseId, start, end, orderByComparator);
	}

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
	public static List<PhraseUsage> findByPhraseId(
		long phraseId, int start, int end,
		OrderByComparator<PhraseUsage> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPhraseId(
			phraseId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first phrase usage in the ordered set where phraseId = &#63;.
	 *
	 * @param phraseId the phrase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phrase usage
	 * @throws NoSuchPhraseUsageException if a matching phrase usage could not be found
	 */
	public static PhraseUsage findByPhraseId_First(
			long phraseId, OrderByComparator<PhraseUsage> orderByComparator)
		throws com.tokogae.data.exception.NoSuchPhraseUsageException {

		return getPersistence().findByPhraseId_First(
			phraseId, orderByComparator);
	}

	/**
	 * Returns the first phrase usage in the ordered set where phraseId = &#63;.
	 *
	 * @param phraseId the phrase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phrase usage, or <code>null</code> if a matching phrase usage could not be found
	 */
	public static PhraseUsage fetchByPhraseId_First(
		long phraseId, OrderByComparator<PhraseUsage> orderByComparator) {

		return getPersistence().fetchByPhraseId_First(
			phraseId, orderByComparator);
	}

	/**
	 * Returns the last phrase usage in the ordered set where phraseId = &#63;.
	 *
	 * @param phraseId the phrase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phrase usage
	 * @throws NoSuchPhraseUsageException if a matching phrase usage could not be found
	 */
	public static PhraseUsage findByPhraseId_Last(
			long phraseId, OrderByComparator<PhraseUsage> orderByComparator)
		throws com.tokogae.data.exception.NoSuchPhraseUsageException {

		return getPersistence().findByPhraseId_Last(
			phraseId, orderByComparator);
	}

	/**
	 * Returns the last phrase usage in the ordered set where phraseId = &#63;.
	 *
	 * @param phraseId the phrase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phrase usage, or <code>null</code> if a matching phrase usage could not be found
	 */
	public static PhraseUsage fetchByPhraseId_Last(
		long phraseId, OrderByComparator<PhraseUsage> orderByComparator) {

		return getPersistence().fetchByPhraseId_Last(
			phraseId, orderByComparator);
	}

	/**
	 * Returns the phrase usages before and after the current phrase usage in the ordered set where phraseId = &#63;.
	 *
	 * @param phraseUsageId the primary key of the current phrase usage
	 * @param phraseId the phrase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next phrase usage
	 * @throws NoSuchPhraseUsageException if a phrase usage with the primary key could not be found
	 */
	public static PhraseUsage[] findByPhraseId_PrevAndNext(
			long phraseUsageId, long phraseId,
			OrderByComparator<PhraseUsage> orderByComparator)
		throws com.tokogae.data.exception.NoSuchPhraseUsageException {

		return getPersistence().findByPhraseId_PrevAndNext(
			phraseUsageId, phraseId, orderByComparator);
	}

	/**
	 * Removes all the phrase usages where phraseId = &#63; from the database.
	 *
	 * @param phraseId the phrase ID
	 */
	public static void removeByPhraseId(long phraseId) {
		getPersistence().removeByPhraseId(phraseId);
	}

	/**
	 * Returns the number of phrase usages where phraseId = &#63;.
	 *
	 * @param phraseId the phrase ID
	 * @return the number of matching phrase usages
	 */
	public static int countByPhraseId(long phraseId) {
		return getPersistence().countByPhraseId(phraseId);
	}

	/**
	 * Returns the phrase usage where classNameId = &#63; and classPK = &#63; or throws a <code>NoSuchPhraseUsageException</code> if it could not be found.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @return the matching phrase usage
	 * @throws NoSuchPhraseUsageException if a matching phrase usage could not be found
	 */
	public static PhraseUsage findByC_C(long classNameId, long classPK)
		throws com.tokogae.data.exception.NoSuchPhraseUsageException {

		return getPersistence().findByC_C(classNameId, classPK);
	}

	/**
	 * Returns the phrase usage where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @return the matching phrase usage, or <code>null</code> if a matching phrase usage could not be found
	 */
	public static PhraseUsage fetchByC_C(long classNameId, long classPK) {
		return getPersistence().fetchByC_C(classNameId, classPK);
	}

	/**
	 * Returns the phrase usage where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching phrase usage, or <code>null</code> if a matching phrase usage could not be found
	 */
	public static PhraseUsage fetchByC_C(
		long classNameId, long classPK, boolean useFinderCache) {

		return getPersistence().fetchByC_C(
			classNameId, classPK, useFinderCache);
	}

	/**
	 * Removes the phrase usage where classNameId = &#63; and classPK = &#63; from the database.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @return the phrase usage that was removed
	 */
	public static PhraseUsage removeByC_C(long classNameId, long classPK)
		throws com.tokogae.data.exception.NoSuchPhraseUsageException {

		return getPersistence().removeByC_C(classNameId, classPK);
	}

	/**
	 * Returns the number of phrase usages where classNameId = &#63; and classPK = &#63;.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @return the number of matching phrase usages
	 */
	public static int countByC_C(long classNameId, long classPK) {
		return getPersistence().countByC_C(classNameId, classPK);
	}

	/**
	 * Returns all the phrase usages where companyId = &#63; and classNameId = &#63; and attributesHashCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param attributesHashCode the attributes hash code
	 * @return the matching phrase usages
	 */
	public static List<PhraseUsage> findByC_C_AHC(
		long companyId, long classNameId, int attributesHashCode) {

		return getPersistence().findByC_C_AHC(
			companyId, classNameId, attributesHashCode);
	}

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
	public static List<PhraseUsage> findByC_C_AHC(
		long companyId, long classNameId, int attributesHashCode, int start,
		int end) {

		return getPersistence().findByC_C_AHC(
			companyId, classNameId, attributesHashCode, start, end);
	}

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
	public static List<PhraseUsage> findByC_C_AHC(
		long companyId, long classNameId, int attributesHashCode, int start,
		int end, OrderByComparator<PhraseUsage> orderByComparator) {

		return getPersistence().findByC_C_AHC(
			companyId, classNameId, attributesHashCode, start, end,
			orderByComparator);
	}

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
	public static List<PhraseUsage> findByC_C_AHC(
		long companyId, long classNameId, int attributesHashCode, int start,
		int end, OrderByComparator<PhraseUsage> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByC_C_AHC(
			companyId, classNameId, attributesHashCode, start, end,
			orderByComparator, useFinderCache);
	}

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
	public static PhraseUsage findByC_C_AHC_First(
			long companyId, long classNameId, int attributesHashCode,
			OrderByComparator<PhraseUsage> orderByComparator)
		throws com.tokogae.data.exception.NoSuchPhraseUsageException {

		return getPersistence().findByC_C_AHC_First(
			companyId, classNameId, attributesHashCode, orderByComparator);
	}

	/**
	 * Returns the first phrase usage in the ordered set where companyId = &#63; and classNameId = &#63; and attributesHashCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param attributesHashCode the attributes hash code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phrase usage, or <code>null</code> if a matching phrase usage could not be found
	 */
	public static PhraseUsage fetchByC_C_AHC_First(
		long companyId, long classNameId, int attributesHashCode,
		OrderByComparator<PhraseUsage> orderByComparator) {

		return getPersistence().fetchByC_C_AHC_First(
			companyId, classNameId, attributesHashCode, orderByComparator);
	}

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
	public static PhraseUsage findByC_C_AHC_Last(
			long companyId, long classNameId, int attributesHashCode,
			OrderByComparator<PhraseUsage> orderByComparator)
		throws com.tokogae.data.exception.NoSuchPhraseUsageException {

		return getPersistence().findByC_C_AHC_Last(
			companyId, classNameId, attributesHashCode, orderByComparator);
	}

	/**
	 * Returns the last phrase usage in the ordered set where companyId = &#63; and classNameId = &#63; and attributesHashCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param attributesHashCode the attributes hash code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phrase usage, or <code>null</code> if a matching phrase usage could not be found
	 */
	public static PhraseUsage fetchByC_C_AHC_Last(
		long companyId, long classNameId, int attributesHashCode,
		OrderByComparator<PhraseUsage> orderByComparator) {

		return getPersistence().fetchByC_C_AHC_Last(
			companyId, classNameId, attributesHashCode, orderByComparator);
	}

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
	public static PhraseUsage[] findByC_C_AHC_PrevAndNext(
			long phraseUsageId, long companyId, long classNameId,
			int attributesHashCode,
			OrderByComparator<PhraseUsage> orderByComparator)
		throws com.tokogae.data.exception.NoSuchPhraseUsageException {

		return getPersistence().findByC_C_AHC_PrevAndNext(
			phraseUsageId, companyId, classNameId, attributesHashCode,
			orderByComparator);
	}

	/**
	 * Removes all the phrase usages where companyId = &#63; and classNameId = &#63; and attributesHashCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param attributesHashCode the attributes hash code
	 */
	public static void removeByC_C_AHC(
		long companyId, long classNameId, int attributesHashCode) {

		getPersistence().removeByC_C_AHC(
			companyId, classNameId, attributesHashCode);
	}

	/**
	 * Returns the number of phrase usages where companyId = &#63; and classNameId = &#63; and attributesHashCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param attributesHashCode the attributes hash code
	 * @return the number of matching phrase usages
	 */
	public static int countByC_C_AHC(
		long companyId, long classNameId, int attributesHashCode) {

		return getPersistence().countByC_C_AHC(
			companyId, classNameId, attributesHashCode);
	}

	/**
	 * Caches the phrase usage in the entity cache if it is enabled.
	 *
	 * @param phraseUsage the phrase usage
	 */
	public static void cacheResult(PhraseUsage phraseUsage) {
		getPersistence().cacheResult(phraseUsage);
	}

	/**
	 * Caches the phrase usages in the entity cache if it is enabled.
	 *
	 * @param phraseUsages the phrase usages
	 */
	public static void cacheResult(List<PhraseUsage> phraseUsages) {
		getPersistence().cacheResult(phraseUsages);
	}

	/**
	 * Creates a new phrase usage with the primary key. Does not add the phrase usage to the database.
	 *
	 * @param phraseUsageId the primary key for the new phrase usage
	 * @return the new phrase usage
	 */
	public static PhraseUsage create(long phraseUsageId) {
		return getPersistence().create(phraseUsageId);
	}

	/**
	 * Removes the phrase usage with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param phraseUsageId the primary key of the phrase usage
	 * @return the phrase usage that was removed
	 * @throws NoSuchPhraseUsageException if a phrase usage with the primary key could not be found
	 */
	public static PhraseUsage remove(long phraseUsageId)
		throws com.tokogae.data.exception.NoSuchPhraseUsageException {

		return getPersistence().remove(phraseUsageId);
	}

	public static PhraseUsage updateImpl(PhraseUsage phraseUsage) {
		return getPersistence().updateImpl(phraseUsage);
	}

	/**
	 * Returns the phrase usage with the primary key or throws a <code>NoSuchPhraseUsageException</code> if it could not be found.
	 *
	 * @param phraseUsageId the primary key of the phrase usage
	 * @return the phrase usage
	 * @throws NoSuchPhraseUsageException if a phrase usage with the primary key could not be found
	 */
	public static PhraseUsage findByPrimaryKey(long phraseUsageId)
		throws com.tokogae.data.exception.NoSuchPhraseUsageException {

		return getPersistence().findByPrimaryKey(phraseUsageId);
	}

	/**
	 * Returns the phrase usage with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param phraseUsageId the primary key of the phrase usage
	 * @return the phrase usage, or <code>null</code> if a phrase usage with the primary key could not be found
	 */
	public static PhraseUsage fetchByPrimaryKey(long phraseUsageId) {
		return getPersistence().fetchByPrimaryKey(phraseUsageId);
	}

	/**
	 * Returns all the phrase usages.
	 *
	 * @return the phrase usages
	 */
	public static List<PhraseUsage> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<PhraseUsage> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<PhraseUsage> findAll(
		int start, int end, OrderByComparator<PhraseUsage> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<PhraseUsage> findAll(
		int start, int end, OrderByComparator<PhraseUsage> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the phrase usages from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of phrase usages.
	 *
	 * @return the number of phrase usages
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PhraseUsagePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(PhraseUsagePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile PhraseUsagePersistence _persistence;

}