/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import com.tokogae.data.exception.NoSuchPhraseUsageException;
import com.tokogae.data.model.PhraseUsage;
import com.tokogae.data.model.PhraseUsageTable;
import com.tokogae.data.model.impl.PhraseUsageImpl;
import com.tokogae.data.model.impl.PhraseUsageModelImpl;
import com.tokogae.data.service.persistence.PhraseUsagePersistence;
import com.tokogae.data.service.persistence.PhraseUsageUtil;
import com.tokogae.data.service.persistence.impl.constants.TOKOGAEDataPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the phrase usage service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Amos Fong
 * @generated
 */
@Component(service = PhraseUsagePersistence.class)
public class PhraseUsagePersistenceImpl
	extends BasePersistenceImpl<PhraseUsage> implements PhraseUsagePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PhraseUsageUtil</code> to access the phrase usage persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PhraseUsageImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByPhraseId;
	private FinderPath _finderPathWithoutPaginationFindByPhraseId;
	private FinderPath _finderPathCountByPhraseId;

	/**
	 * Returns all the phrase usages where phraseId = &#63;.
	 *
	 * @param phraseId the phrase ID
	 * @return the matching phrase usages
	 */
	@Override
	public List<PhraseUsage> findByPhraseId(long phraseId) {
		return findByPhraseId(
			phraseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<PhraseUsage> findByPhraseId(long phraseId, int start, int end) {
		return findByPhraseId(phraseId, start, end, null);
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
	@Override
	public List<PhraseUsage> findByPhraseId(
		long phraseId, int start, int end,
		OrderByComparator<PhraseUsage> orderByComparator) {

		return findByPhraseId(phraseId, start, end, orderByComparator, true);
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
	@Override
	public List<PhraseUsage> findByPhraseId(
		long phraseId, int start, int end,
		OrderByComparator<PhraseUsage> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPhraseId;
				finderArgs = new Object[] {phraseId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPhraseId;
			finderArgs = new Object[] {phraseId, start, end, orderByComparator};
		}

		List<PhraseUsage> list = null;

		if (useFinderCache) {
			list = (List<PhraseUsage>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PhraseUsage phraseUsage : list) {
					if (phraseId != phraseUsage.getPhraseId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_PHRASEUSAGE_WHERE);

			sb.append(_FINDER_COLUMN_PHRASEID_PHRASEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PhraseUsageModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(phraseId);

				list = (List<PhraseUsage>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first phrase usage in the ordered set where phraseId = &#63;.
	 *
	 * @param phraseId the phrase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phrase usage
	 * @throws NoSuchPhraseUsageException if a matching phrase usage could not be found
	 */
	@Override
	public PhraseUsage findByPhraseId_First(
			long phraseId, OrderByComparator<PhraseUsage> orderByComparator)
		throws NoSuchPhraseUsageException {

		PhraseUsage phraseUsage = fetchByPhraseId_First(
			phraseId, orderByComparator);

		if (phraseUsage != null) {
			return phraseUsage;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("phraseId=");
		sb.append(phraseId);

		sb.append("}");

		throw new NoSuchPhraseUsageException(sb.toString());
	}

	/**
	 * Returns the first phrase usage in the ordered set where phraseId = &#63;.
	 *
	 * @param phraseId the phrase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phrase usage, or <code>null</code> if a matching phrase usage could not be found
	 */
	@Override
	public PhraseUsage fetchByPhraseId_First(
		long phraseId, OrderByComparator<PhraseUsage> orderByComparator) {

		List<PhraseUsage> list = findByPhraseId(
			phraseId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last phrase usage in the ordered set where phraseId = &#63;.
	 *
	 * @param phraseId the phrase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phrase usage
	 * @throws NoSuchPhraseUsageException if a matching phrase usage could not be found
	 */
	@Override
	public PhraseUsage findByPhraseId_Last(
			long phraseId, OrderByComparator<PhraseUsage> orderByComparator)
		throws NoSuchPhraseUsageException {

		PhraseUsage phraseUsage = fetchByPhraseId_Last(
			phraseId, orderByComparator);

		if (phraseUsage != null) {
			return phraseUsage;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("phraseId=");
		sb.append(phraseId);

		sb.append("}");

		throw new NoSuchPhraseUsageException(sb.toString());
	}

	/**
	 * Returns the last phrase usage in the ordered set where phraseId = &#63;.
	 *
	 * @param phraseId the phrase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phrase usage, or <code>null</code> if a matching phrase usage could not be found
	 */
	@Override
	public PhraseUsage fetchByPhraseId_Last(
		long phraseId, OrderByComparator<PhraseUsage> orderByComparator) {

		int count = countByPhraseId(phraseId);

		if (count == 0) {
			return null;
		}

		List<PhraseUsage> list = findByPhraseId(
			phraseId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public PhraseUsage[] findByPhraseId_PrevAndNext(
			long phraseUsageId, long phraseId,
			OrderByComparator<PhraseUsage> orderByComparator)
		throws NoSuchPhraseUsageException {

		PhraseUsage phraseUsage = findByPrimaryKey(phraseUsageId);

		Session session = null;

		try {
			session = openSession();

			PhraseUsage[] array = new PhraseUsageImpl[3];

			array[0] = getByPhraseId_PrevAndNext(
				session, phraseUsage, phraseId, orderByComparator, true);

			array[1] = phraseUsage;

			array[2] = getByPhraseId_PrevAndNext(
				session, phraseUsage, phraseId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PhraseUsage getByPhraseId_PrevAndNext(
		Session session, PhraseUsage phraseUsage, long phraseId,
		OrderByComparator<PhraseUsage> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PHRASEUSAGE_WHERE);

		sb.append(_FINDER_COLUMN_PHRASEID_PHRASEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(PhraseUsageModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(phraseId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(phraseUsage)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PhraseUsage> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the phrase usages where phraseId = &#63; from the database.
	 *
	 * @param phraseId the phrase ID
	 */
	@Override
	public void removeByPhraseId(long phraseId) {
		for (PhraseUsage phraseUsage :
				findByPhraseId(
					phraseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(phraseUsage);
		}
	}

	/**
	 * Returns the number of phrase usages where phraseId = &#63;.
	 *
	 * @param phraseId the phrase ID
	 * @return the number of matching phrase usages
	 */
	@Override
	public int countByPhraseId(long phraseId) {
		FinderPath finderPath = _finderPathCountByPhraseId;

		Object[] finderArgs = new Object[] {phraseId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PHRASEUSAGE_WHERE);

			sb.append(_FINDER_COLUMN_PHRASEID_PHRASEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(phraseId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PHRASEID_PHRASEID_2 =
		"phraseUsage.phraseId = ?";

	private FinderPath _finderPathWithPaginationFindByC_C;
	private FinderPath _finderPathWithoutPaginationFindByC_C;
	private FinderPath _finderPathCountByC_C;

	/**
	 * Returns all the phrase usages where classNameId = &#63; and classPK = &#63;.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @return the matching phrase usages
	 */
	@Override
	public List<PhraseUsage> findByC_C(long classNameId, long classPK) {
		return findByC_C(
			classNameId, classPK, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the phrase usages where classNameId = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhraseUsageModelImpl</code>.
	 * </p>
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param start the lower bound of the range of phrase usages
	 * @param end the upper bound of the range of phrase usages (not inclusive)
	 * @return the range of matching phrase usages
	 */
	@Override
	public List<PhraseUsage> findByC_C(
		long classNameId, long classPK, int start, int end) {

		return findByC_C(classNameId, classPK, start, end, null);
	}

	/**
	 * Returns an ordered range of all the phrase usages where classNameId = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhraseUsageModelImpl</code>.
	 * </p>
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param start the lower bound of the range of phrase usages
	 * @param end the upper bound of the range of phrase usages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching phrase usages
	 */
	@Override
	public List<PhraseUsage> findByC_C(
		long classNameId, long classPK, int start, int end,
		OrderByComparator<PhraseUsage> orderByComparator) {

		return findByC_C(
			classNameId, classPK, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the phrase usages where classNameId = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhraseUsageModelImpl</code>.
	 * </p>
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param start the lower bound of the range of phrase usages
	 * @param end the upper bound of the range of phrase usages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching phrase usages
	 */
	@Override
	public List<PhraseUsage> findByC_C(
		long classNameId, long classPK, int start, int end,
		OrderByComparator<PhraseUsage> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByC_C;
				finderArgs = new Object[] {classNameId, classPK};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByC_C;
			finderArgs = new Object[] {
				classNameId, classPK, start, end, orderByComparator
			};
		}

		List<PhraseUsage> list = null;

		if (useFinderCache) {
			list = (List<PhraseUsage>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PhraseUsage phraseUsage : list) {
					if ((classNameId != phraseUsage.getClassNameId()) ||
						(classPK != phraseUsage.getClassPK())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_PHRASEUSAGE_WHERE);

			sb.append(_FINDER_COLUMN_C_C_CLASSNAMEID_2);

			sb.append(_FINDER_COLUMN_C_C_CLASSPK_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PhraseUsageModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(classNameId);

				queryPos.add(classPK);

				list = (List<PhraseUsage>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first phrase usage in the ordered set where classNameId = &#63; and classPK = &#63;.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phrase usage
	 * @throws NoSuchPhraseUsageException if a matching phrase usage could not be found
	 */
	@Override
	public PhraseUsage findByC_C_First(
			long classNameId, long classPK,
			OrderByComparator<PhraseUsage> orderByComparator)
		throws NoSuchPhraseUsageException {

		PhraseUsage phraseUsage = fetchByC_C_First(
			classNameId, classPK, orderByComparator);

		if (phraseUsage != null) {
			return phraseUsage;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("classNameId=");
		sb.append(classNameId);

		sb.append(", classPK=");
		sb.append(classPK);

		sb.append("}");

		throw new NoSuchPhraseUsageException(sb.toString());
	}

	/**
	 * Returns the first phrase usage in the ordered set where classNameId = &#63; and classPK = &#63;.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phrase usage, or <code>null</code> if a matching phrase usage could not be found
	 */
	@Override
	public PhraseUsage fetchByC_C_First(
		long classNameId, long classPK,
		OrderByComparator<PhraseUsage> orderByComparator) {

		List<PhraseUsage> list = findByC_C(
			classNameId, classPK, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last phrase usage in the ordered set where classNameId = &#63; and classPK = &#63;.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phrase usage
	 * @throws NoSuchPhraseUsageException if a matching phrase usage could not be found
	 */
	@Override
	public PhraseUsage findByC_C_Last(
			long classNameId, long classPK,
			OrderByComparator<PhraseUsage> orderByComparator)
		throws NoSuchPhraseUsageException {

		PhraseUsage phraseUsage = fetchByC_C_Last(
			classNameId, classPK, orderByComparator);

		if (phraseUsage != null) {
			return phraseUsage;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("classNameId=");
		sb.append(classNameId);

		sb.append(", classPK=");
		sb.append(classPK);

		sb.append("}");

		throw new NoSuchPhraseUsageException(sb.toString());
	}

	/**
	 * Returns the last phrase usage in the ordered set where classNameId = &#63; and classPK = &#63;.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phrase usage, or <code>null</code> if a matching phrase usage could not be found
	 */
	@Override
	public PhraseUsage fetchByC_C_Last(
		long classNameId, long classPK,
		OrderByComparator<PhraseUsage> orderByComparator) {

		int count = countByC_C(classNameId, classPK);

		if (count == 0) {
			return null;
		}

		List<PhraseUsage> list = findByC_C(
			classNameId, classPK, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the phrase usages before and after the current phrase usage in the ordered set where classNameId = &#63; and classPK = &#63;.
	 *
	 * @param phraseUsageId the primary key of the current phrase usage
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next phrase usage
	 * @throws NoSuchPhraseUsageException if a phrase usage with the primary key could not be found
	 */
	@Override
	public PhraseUsage[] findByC_C_PrevAndNext(
			long phraseUsageId, long classNameId, long classPK,
			OrderByComparator<PhraseUsage> orderByComparator)
		throws NoSuchPhraseUsageException {

		PhraseUsage phraseUsage = findByPrimaryKey(phraseUsageId);

		Session session = null;

		try {
			session = openSession();

			PhraseUsage[] array = new PhraseUsageImpl[3];

			array[0] = getByC_C_PrevAndNext(
				session, phraseUsage, classNameId, classPK, orderByComparator,
				true);

			array[1] = phraseUsage;

			array[2] = getByC_C_PrevAndNext(
				session, phraseUsage, classNameId, classPK, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PhraseUsage getByC_C_PrevAndNext(
		Session session, PhraseUsage phraseUsage, long classNameId,
		long classPK, OrderByComparator<PhraseUsage> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PHRASEUSAGE_WHERE);

		sb.append(_FINDER_COLUMN_C_C_CLASSNAMEID_2);

		sb.append(_FINDER_COLUMN_C_C_CLASSPK_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(PhraseUsageModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(classNameId);

		queryPos.add(classPK);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(phraseUsage)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PhraseUsage> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the phrase usages where classNameId = &#63; and classPK = &#63; from the database.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 */
	@Override
	public void removeByC_C(long classNameId, long classPK) {
		for (PhraseUsage phraseUsage :
				findByC_C(
					classNameId, classPK, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(phraseUsage);
		}
	}

	/**
	 * Returns the number of phrase usages where classNameId = &#63; and classPK = &#63;.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @return the number of matching phrase usages
	 */
	@Override
	public int countByC_C(long classNameId, long classPK) {
		FinderPath finderPath = _finderPathCountByC_C;

		Object[] finderArgs = new Object[] {classNameId, classPK};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PHRASEUSAGE_WHERE);

			sb.append(_FINDER_COLUMN_C_C_CLASSNAMEID_2);

			sb.append(_FINDER_COLUMN_C_C_CLASSPK_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(classNameId);

				queryPos.add(classPK);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_C_CLASSNAMEID_2 =
		"phraseUsage.classNameId = ? AND ";

	private static final String _FINDER_COLUMN_C_C_CLASSPK_2 =
		"phraseUsage.classPK = ?";

	public PhraseUsagePersistenceImpl() {
		setModelClass(PhraseUsage.class);

		setModelImplClass(PhraseUsageImpl.class);
		setModelPKClass(long.class);

		setTable(PhraseUsageTable.INSTANCE);
	}

	/**
	 * Caches the phrase usage in the entity cache if it is enabled.
	 *
	 * @param phraseUsage the phrase usage
	 */
	@Override
	public void cacheResult(PhraseUsage phraseUsage) {
		entityCache.putResult(
			PhraseUsageImpl.class, phraseUsage.getPrimaryKey(), phraseUsage);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the phrase usages in the entity cache if it is enabled.
	 *
	 * @param phraseUsages the phrase usages
	 */
	@Override
	public void cacheResult(List<PhraseUsage> phraseUsages) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (phraseUsages.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (PhraseUsage phraseUsage : phraseUsages) {
			if (entityCache.getResult(
					PhraseUsageImpl.class, phraseUsage.getPrimaryKey()) ==
						null) {

				cacheResult(phraseUsage);
			}
		}
	}

	/**
	 * Clears the cache for all phrase usages.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PhraseUsageImpl.class);

		finderCache.clearCache(PhraseUsageImpl.class);
	}

	/**
	 * Clears the cache for the phrase usage.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PhraseUsage phraseUsage) {
		entityCache.removeResult(PhraseUsageImpl.class, phraseUsage);
	}

	@Override
	public void clearCache(List<PhraseUsage> phraseUsages) {
		for (PhraseUsage phraseUsage : phraseUsages) {
			entityCache.removeResult(PhraseUsageImpl.class, phraseUsage);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(PhraseUsageImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PhraseUsageImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new phrase usage with the primary key. Does not add the phrase usage to the database.
	 *
	 * @param phraseUsageId the primary key for the new phrase usage
	 * @return the new phrase usage
	 */
	@Override
	public PhraseUsage create(long phraseUsageId) {
		PhraseUsage phraseUsage = new PhraseUsageImpl();

		phraseUsage.setNew(true);
		phraseUsage.setPrimaryKey(phraseUsageId);

		phraseUsage.setCompanyId(CompanyThreadLocal.getCompanyId());

		return phraseUsage;
	}

	/**
	 * Removes the phrase usage with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param phraseUsageId the primary key of the phrase usage
	 * @return the phrase usage that was removed
	 * @throws NoSuchPhraseUsageException if a phrase usage with the primary key could not be found
	 */
	@Override
	public PhraseUsage remove(long phraseUsageId)
		throws NoSuchPhraseUsageException {

		return remove((Serializable)phraseUsageId);
	}

	/**
	 * Removes the phrase usage with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the phrase usage
	 * @return the phrase usage that was removed
	 * @throws NoSuchPhraseUsageException if a phrase usage with the primary key could not be found
	 */
	@Override
	public PhraseUsage remove(Serializable primaryKey)
		throws NoSuchPhraseUsageException {

		Session session = null;

		try {
			session = openSession();

			PhraseUsage phraseUsage = (PhraseUsage)session.get(
				PhraseUsageImpl.class, primaryKey);

			if (phraseUsage == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPhraseUsageException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(phraseUsage);
		}
		catch (NoSuchPhraseUsageException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected PhraseUsage removeImpl(PhraseUsage phraseUsage) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(phraseUsage)) {
				phraseUsage = (PhraseUsage)session.get(
					PhraseUsageImpl.class, phraseUsage.getPrimaryKeyObj());
			}

			if (phraseUsage != null) {
				session.delete(phraseUsage);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (phraseUsage != null) {
			clearCache(phraseUsage);
		}

		return phraseUsage;
	}

	@Override
	public PhraseUsage updateImpl(PhraseUsage phraseUsage) {
		boolean isNew = phraseUsage.isNew();

		if (!(phraseUsage instanceof PhraseUsageModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(phraseUsage.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(phraseUsage);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in phraseUsage proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PhraseUsage implementation " +
					phraseUsage.getClass());
		}

		PhraseUsageModelImpl phraseUsageModelImpl =
			(PhraseUsageModelImpl)phraseUsage;

		if (isNew && (phraseUsage.getCreateDate() == null)) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				phraseUsage.setCreateDate(date);
			}
			else {
				phraseUsage.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(phraseUsage);
			}
			else {
				phraseUsage = (PhraseUsage)session.merge(phraseUsage);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PhraseUsageImpl.class, phraseUsageModelImpl, false, true);

		if (isNew) {
			phraseUsage.setNew(false);
		}

		phraseUsage.resetOriginalValues();

		return phraseUsage;
	}

	/**
	 * Returns the phrase usage with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the phrase usage
	 * @return the phrase usage
	 * @throws NoSuchPhraseUsageException if a phrase usage with the primary key could not be found
	 */
	@Override
	public PhraseUsage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPhraseUsageException {

		PhraseUsage phraseUsage = fetchByPrimaryKey(primaryKey);

		if (phraseUsage == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPhraseUsageException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return phraseUsage;
	}

	/**
	 * Returns the phrase usage with the primary key or throws a <code>NoSuchPhraseUsageException</code> if it could not be found.
	 *
	 * @param phraseUsageId the primary key of the phrase usage
	 * @return the phrase usage
	 * @throws NoSuchPhraseUsageException if a phrase usage with the primary key could not be found
	 */
	@Override
	public PhraseUsage findByPrimaryKey(long phraseUsageId)
		throws NoSuchPhraseUsageException {

		return findByPrimaryKey((Serializable)phraseUsageId);
	}

	/**
	 * Returns the phrase usage with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param phraseUsageId the primary key of the phrase usage
	 * @return the phrase usage, or <code>null</code> if a phrase usage with the primary key could not be found
	 */
	@Override
	public PhraseUsage fetchByPrimaryKey(long phraseUsageId) {
		return fetchByPrimaryKey((Serializable)phraseUsageId);
	}

	/**
	 * Returns all the phrase usages.
	 *
	 * @return the phrase usages
	 */
	@Override
	public List<PhraseUsage> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<PhraseUsage> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<PhraseUsage> findAll(
		int start, int end, OrderByComparator<PhraseUsage> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<PhraseUsage> findAll(
		int start, int end, OrderByComparator<PhraseUsage> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<PhraseUsage> list = null;

		if (useFinderCache) {
			list = (List<PhraseUsage>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PHRASEUSAGE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PHRASEUSAGE;

				sql = sql.concat(PhraseUsageModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PhraseUsage>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the phrase usages from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PhraseUsage phraseUsage : findAll()) {
			remove(phraseUsage);
		}
	}

	/**
	 * Returns the number of phrase usages.
	 *
	 * @return the number of phrase usages
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PHRASEUSAGE);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "phraseUsageId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PHRASEUSAGE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PhraseUsageModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the phrase usage persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByPhraseId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPhraseId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"phraseId"}, true);

		_finderPathWithoutPaginationFindByPhraseId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPhraseId",
			new String[] {Long.class.getName()}, new String[] {"phraseId"},
			true);

		_finderPathCountByPhraseId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPhraseId",
			new String[] {Long.class.getName()}, new String[] {"phraseId"},
			false);

		_finderPathWithPaginationFindByC_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_C",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"classNameId", "classPK"}, true);

		_finderPathWithoutPaginationFindByC_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_C",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"classNameId", "classPK"}, true);

		_finderPathCountByC_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_C",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"classNameId", "classPK"}, false);

		PhraseUsageUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		PhraseUsageUtil.setPersistence(null);

		entityCache.removeCache(PhraseUsageImpl.class.getName());
	}

	@Override
	@Reference(
		target = TOKOGAEDataPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = TOKOGAEDataPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = TOKOGAEDataPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PHRASEUSAGE =
		"SELECT phraseUsage FROM PhraseUsage phraseUsage";

	private static final String _SQL_SELECT_PHRASEUSAGE_WHERE =
		"SELECT phraseUsage FROM PhraseUsage phraseUsage WHERE ";

	private static final String _SQL_COUNT_PHRASEUSAGE =
		"SELECT COUNT(phraseUsage) FROM PhraseUsage phraseUsage";

	private static final String _SQL_COUNT_PHRASEUSAGE_WHERE =
		"SELECT COUNT(phraseUsage) FROM PhraseUsage phraseUsage WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "phraseUsage.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PhraseUsage exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PhraseUsage exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PhraseUsagePersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}