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

import com.tokogae.data.event.exception.NoSuchSleepException;
import com.tokogae.data.event.model.Sleep;
import com.tokogae.data.event.model.SleepTable;
import com.tokogae.data.event.model.impl.SleepImpl;
import com.tokogae.data.event.model.impl.SleepModelImpl;
import com.tokogae.data.event.service.persistence.SleepPersistence;
import com.tokogae.data.event.service.persistence.SleepUtil;
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
 * The persistence implementation for the sleep service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Amos Fong
 * @generated
 */
@Component(service = SleepPersistence.class)
public class SleepPersistenceImpl
	extends BasePersistenceImpl<Sleep> implements SleepPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SleepUtil</code> to access the sleep persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SleepImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public SleepPersistenceImpl() {
		setModelClass(Sleep.class);

		setModelImplClass(SleepImpl.class);
		setModelPKClass(long.class);

		setTable(SleepTable.INSTANCE);
	}

	/**
	 * Caches the sleep in the entity cache if it is enabled.
	 *
	 * @param sleep the sleep
	 */
	@Override
	public void cacheResult(Sleep sleep) {
		entityCache.putResult(SleepImpl.class, sleep.getPrimaryKey(), sleep);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the sleeps in the entity cache if it is enabled.
	 *
	 * @param sleeps the sleeps
	 */
	@Override
	public void cacheResult(List<Sleep> sleeps) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (sleeps.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Sleep sleep : sleeps) {
			if (entityCache.getResult(SleepImpl.class, sleep.getPrimaryKey()) ==
					null) {

				cacheResult(sleep);
			}
		}
	}

	/**
	 * Clears the cache for all sleeps.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SleepImpl.class);

		finderCache.clearCache(SleepImpl.class);
	}

	/**
	 * Clears the cache for the sleep.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Sleep sleep) {
		entityCache.removeResult(SleepImpl.class, sleep);
	}

	@Override
	public void clearCache(List<Sleep> sleeps) {
		for (Sleep sleep : sleeps) {
			entityCache.removeResult(SleepImpl.class, sleep);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(SleepImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SleepImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new sleep with the primary key. Does not add the sleep to the database.
	 *
	 * @param sleepId the primary key for the new sleep
	 * @return the new sleep
	 */
	@Override
	public Sleep create(long sleepId) {
		Sleep sleep = new SleepImpl();

		sleep.setNew(true);
		sleep.setPrimaryKey(sleepId);

		sleep.setCompanyId(CompanyThreadLocal.getCompanyId());

		return sleep;
	}

	/**
	 * Removes the sleep with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sleepId the primary key of the sleep
	 * @return the sleep that was removed
	 * @throws NoSuchSleepException if a sleep with the primary key could not be found
	 */
	@Override
	public Sleep remove(long sleepId) throws NoSuchSleepException {
		return remove((Serializable)sleepId);
	}

	/**
	 * Removes the sleep with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sleep
	 * @return the sleep that was removed
	 * @throws NoSuchSleepException if a sleep with the primary key could not be found
	 */
	@Override
	public Sleep remove(Serializable primaryKey) throws NoSuchSleepException {
		Session session = null;

		try {
			session = openSession();

			Sleep sleep = (Sleep)session.get(SleepImpl.class, primaryKey);

			if (sleep == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSleepException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(sleep);
		}
		catch (NoSuchSleepException noSuchEntityException) {
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
	protected Sleep removeImpl(Sleep sleep) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(sleep)) {
				sleep = (Sleep)session.get(
					SleepImpl.class, sleep.getPrimaryKeyObj());
			}

			if (sleep != null) {
				session.delete(sleep);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (sleep != null) {
			clearCache(sleep);
		}

		return sleep;
	}

	@Override
	public Sleep updateImpl(Sleep sleep) {
		boolean isNew = sleep.isNew();

		if (!(sleep instanceof SleepModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(sleep.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(sleep);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in sleep proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Sleep implementation " +
					sleep.getClass());
		}

		SleepModelImpl sleepModelImpl = (SleepModelImpl)sleep;

		if (isNew && (sleep.getCreateDate() == null)) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				sleep.setCreateDate(date);
			}
			else {
				sleep.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(sleep);
			}
			else {
				sleep = (Sleep)session.merge(sleep);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(SleepImpl.class, sleep, false, true);

		if (isNew) {
			sleep.setNew(false);
		}

		sleep.resetOriginalValues();

		return sleep;
	}

	/**
	 * Returns the sleep with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sleep
	 * @return the sleep
	 * @throws NoSuchSleepException if a sleep with the primary key could not be found
	 */
	@Override
	public Sleep findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSleepException {

		Sleep sleep = fetchByPrimaryKey(primaryKey);

		if (sleep == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSleepException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return sleep;
	}

	/**
	 * Returns the sleep with the primary key or throws a <code>NoSuchSleepException</code> if it could not be found.
	 *
	 * @param sleepId the primary key of the sleep
	 * @return the sleep
	 * @throws NoSuchSleepException if a sleep with the primary key could not be found
	 */
	@Override
	public Sleep findByPrimaryKey(long sleepId) throws NoSuchSleepException {
		return findByPrimaryKey((Serializable)sleepId);
	}

	/**
	 * Returns the sleep with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sleepId the primary key of the sleep
	 * @return the sleep, or <code>null</code> if a sleep with the primary key could not be found
	 */
	@Override
	public Sleep fetchByPrimaryKey(long sleepId) {
		return fetchByPrimaryKey((Serializable)sleepId);
	}

	/**
	 * Returns all the sleeps.
	 *
	 * @return the sleeps
	 */
	@Override
	public List<Sleep> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Sleep> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Sleep> findAll(
		int start, int end, OrderByComparator<Sleep> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<Sleep> findAll(
		int start, int end, OrderByComparator<Sleep> orderByComparator,
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

		List<Sleep> list = null;

		if (useFinderCache) {
			list = (List<Sleep>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SLEEP);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SLEEP;

				sql = sql.concat(SleepModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Sleep>)QueryUtil.list(
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
	 * Removes all the sleeps from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Sleep sleep : findAll()) {
			remove(sleep);
		}
	}

	/**
	 * Returns the number of sleeps.
	 *
	 * @return the number of sleeps
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SLEEP);

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
		return "sleepId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SLEEP;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SleepModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the sleep persistence.
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

		SleepUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		SleepUtil.setPersistence(null);

		entityCache.removeCache(SleepImpl.class.getName());
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

	private static final String _SQL_SELECT_SLEEP =
		"SELECT sleep FROM Sleep sleep";

	private static final String _SQL_COUNT_SLEEP =
		"SELECT COUNT(sleep) FROM Sleep sleep";

	private static final String _ORDER_BY_ENTITY_ALIAS = "sleep.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Sleep exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		SleepPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}