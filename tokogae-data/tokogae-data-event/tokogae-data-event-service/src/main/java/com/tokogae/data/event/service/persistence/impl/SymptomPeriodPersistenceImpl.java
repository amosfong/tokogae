/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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

import com.tokogae.data.event.exception.NoSuchSymptomPeriodException;
import com.tokogae.data.event.model.SymptomPeriod;
import com.tokogae.data.event.model.SymptomPeriodTable;
import com.tokogae.data.event.model.impl.SymptomPeriodImpl;
import com.tokogae.data.event.model.impl.SymptomPeriodModelImpl;
import com.tokogae.data.event.service.persistence.SymptomPeriodPersistence;
import com.tokogae.data.event.service.persistence.SymptomPeriodUtil;
import com.tokogae.data.event.service.persistence.impl.constants.TOKOGAEDataPersistenceConstants;

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
 * The persistence implementation for the symptom period service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Amos Fong
 * @generated
 */
@Component(service = SymptomPeriodPersistence.class)
public class SymptomPeriodPersistenceImpl
	extends BasePersistenceImpl<SymptomPeriod>
	implements SymptomPeriodPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SymptomPeriodUtil</code> to access the symptom period persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SymptomPeriodImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public SymptomPeriodPersistenceImpl() {
		setModelClass(SymptomPeriod.class);

		setModelImplClass(SymptomPeriodImpl.class);
		setModelPKClass(long.class);

		setTable(SymptomPeriodTable.INSTANCE);
	}

	/**
	 * Caches the symptom period in the entity cache if it is enabled.
	 *
	 * @param symptomPeriod the symptom period
	 */
	@Override
	public void cacheResult(SymptomPeriod symptomPeriod) {
		entityCache.putResult(
			SymptomPeriodImpl.class, symptomPeriod.getPrimaryKey(),
			symptomPeriod);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the symptom periods in the entity cache if it is enabled.
	 *
	 * @param symptomPeriods the symptom periods
	 */
	@Override
	public void cacheResult(List<SymptomPeriod> symptomPeriods) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (symptomPeriods.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SymptomPeriod symptomPeriod : symptomPeriods) {
			if (entityCache.getResult(
					SymptomPeriodImpl.class, symptomPeriod.getPrimaryKey()) ==
						null) {

				cacheResult(symptomPeriod);
			}
		}
	}

	/**
	 * Clears the cache for all symptom periods.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SymptomPeriodImpl.class);

		finderCache.clearCache(SymptomPeriodImpl.class);
	}

	/**
	 * Clears the cache for the symptom period.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SymptomPeriod symptomPeriod) {
		entityCache.removeResult(SymptomPeriodImpl.class, symptomPeriod);
	}

	@Override
	public void clearCache(List<SymptomPeriod> symptomPeriods) {
		for (SymptomPeriod symptomPeriod : symptomPeriods) {
			entityCache.removeResult(SymptomPeriodImpl.class, symptomPeriod);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(SymptomPeriodImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SymptomPeriodImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new symptom period with the primary key. Does not add the symptom period to the database.
	 *
	 * @param symptomId the primary key for the new symptom period
	 * @return the new symptom period
	 */
	@Override
	public SymptomPeriod create(long symptomId) {
		SymptomPeriod symptomPeriod = new SymptomPeriodImpl();

		symptomPeriod.setNew(true);
		symptomPeriod.setPrimaryKey(symptomId);

		symptomPeriod.setCompanyId(CompanyThreadLocal.getCompanyId());

		return symptomPeriod;
	}

	/**
	 * Removes the symptom period with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param symptomId the primary key of the symptom period
	 * @return the symptom period that was removed
	 * @throws NoSuchSymptomPeriodException if a symptom period with the primary key could not be found
	 */
	@Override
	public SymptomPeriod remove(long symptomId)
		throws NoSuchSymptomPeriodException {

		return remove((Serializable)symptomId);
	}

	/**
	 * Removes the symptom period with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the symptom period
	 * @return the symptom period that was removed
	 * @throws NoSuchSymptomPeriodException if a symptom period with the primary key could not be found
	 */
	@Override
	public SymptomPeriod remove(Serializable primaryKey)
		throws NoSuchSymptomPeriodException {

		Session session = null;

		try {
			session = openSession();

			SymptomPeriod symptomPeriod = (SymptomPeriod)session.get(
				SymptomPeriodImpl.class, primaryKey);

			if (symptomPeriod == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSymptomPeriodException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(symptomPeriod);
		}
		catch (NoSuchSymptomPeriodException noSuchEntityException) {
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
	protected SymptomPeriod removeImpl(SymptomPeriod symptomPeriod) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(symptomPeriod)) {
				symptomPeriod = (SymptomPeriod)session.get(
					SymptomPeriodImpl.class, symptomPeriod.getPrimaryKeyObj());
			}

			if (symptomPeriod != null) {
				session.delete(symptomPeriod);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (symptomPeriod != null) {
			clearCache(symptomPeriod);
		}

		return symptomPeriod;
	}

	@Override
	public SymptomPeriod updateImpl(SymptomPeriod symptomPeriod) {
		boolean isNew = symptomPeriod.isNew();

		if (!(symptomPeriod instanceof SymptomPeriodModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(symptomPeriod.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					symptomPeriod);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in symptomPeriod proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SymptomPeriod implementation " +
					symptomPeriod.getClass());
		}

		SymptomPeriodModelImpl symptomPeriodModelImpl =
			(SymptomPeriodModelImpl)symptomPeriod;

		if (isNew && (symptomPeriod.getCreateDate() == null)) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				symptomPeriod.setCreateDate(date);
			}
			else {
				symptomPeriod.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(symptomPeriod);
			}
			else {
				symptomPeriod = (SymptomPeriod)session.merge(symptomPeriod);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SymptomPeriodImpl.class, symptomPeriod, false, true);

		if (isNew) {
			symptomPeriod.setNew(false);
		}

		symptomPeriod.resetOriginalValues();

		return symptomPeriod;
	}

	/**
	 * Returns the symptom period with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the symptom period
	 * @return the symptom period
	 * @throws NoSuchSymptomPeriodException if a symptom period with the primary key could not be found
	 */
	@Override
	public SymptomPeriod findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSymptomPeriodException {

		SymptomPeriod symptomPeriod = fetchByPrimaryKey(primaryKey);

		if (symptomPeriod == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSymptomPeriodException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return symptomPeriod;
	}

	/**
	 * Returns the symptom period with the primary key or throws a <code>NoSuchSymptomPeriodException</code> if it could not be found.
	 *
	 * @param symptomId the primary key of the symptom period
	 * @return the symptom period
	 * @throws NoSuchSymptomPeriodException if a symptom period with the primary key could not be found
	 */
	@Override
	public SymptomPeriod findByPrimaryKey(long symptomId)
		throws NoSuchSymptomPeriodException {

		return findByPrimaryKey((Serializable)symptomId);
	}

	/**
	 * Returns the symptom period with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param symptomId the primary key of the symptom period
	 * @return the symptom period, or <code>null</code> if a symptom period with the primary key could not be found
	 */
	@Override
	public SymptomPeriod fetchByPrimaryKey(long symptomId) {
		return fetchByPrimaryKey((Serializable)symptomId);
	}

	/**
	 * Returns all the symptom periods.
	 *
	 * @return the symptom periods
	 */
	@Override
	public List<SymptomPeriod> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<SymptomPeriod> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<SymptomPeriod> findAll(
		int start, int end,
		OrderByComparator<SymptomPeriod> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<SymptomPeriod> findAll(
		int start, int end, OrderByComparator<SymptomPeriod> orderByComparator,
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

		List<SymptomPeriod> list = null;

		if (useFinderCache) {
			list = (List<SymptomPeriod>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SYMPTOMPERIOD);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SYMPTOMPERIOD;

				sql = sql.concat(SymptomPeriodModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SymptomPeriod>)QueryUtil.list(
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
	 * Removes all the symptom periods from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SymptomPeriod symptomPeriod : findAll()) {
			remove(symptomPeriod);
		}
	}

	/**
	 * Returns the number of symptom periods.
	 *
	 * @return the number of symptom periods
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SYMPTOMPERIOD);

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
		return "symptomId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SYMPTOMPERIOD;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SymptomPeriodModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the symptom period persistence.
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

		SymptomPeriodUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		SymptomPeriodUtil.setPersistence(null);

		entityCache.removeCache(SymptomPeriodImpl.class.getName());
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

	private static final String _SQL_SELECT_SYMPTOMPERIOD =
		"SELECT symptomPeriod FROM SymptomPeriod symptomPeriod";

	private static final String _SQL_COUNT_SYMPTOMPERIOD =
		"SELECT COUNT(symptomPeriod) FROM SymptomPeriod symptomPeriod";

	private static final String _ORDER_BY_ENTITY_ALIAS = "symptomPeriod.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SymptomPeriod exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		SymptomPeriodPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}