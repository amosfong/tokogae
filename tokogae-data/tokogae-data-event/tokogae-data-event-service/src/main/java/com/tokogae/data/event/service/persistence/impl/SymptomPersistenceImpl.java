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

import com.tokogae.data.event.exception.NoSuchSymptomException;
import com.tokogae.data.event.model.Symptom;
import com.tokogae.data.event.model.SymptomTable;
import com.tokogae.data.event.model.impl.SymptomImpl;
import com.tokogae.data.event.model.impl.SymptomModelImpl;
import com.tokogae.data.event.service.persistence.SymptomPersistence;
import com.tokogae.data.event.service.persistence.SymptomUtil;
import com.tokogae.data.event.service.persistence.impl.constants.TOKOGAE_DataPersistenceConstants;

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
 * The persistence implementation for the symptom service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Amos Fong
 * @generated
 */
@Component(service = SymptomPersistence.class)
public class SymptomPersistenceImpl
	extends BasePersistenceImpl<Symptom> implements SymptomPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SymptomUtil</code> to access the symptom persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SymptomImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public SymptomPersistenceImpl() {
		setModelClass(Symptom.class);

		setModelImplClass(SymptomImpl.class);
		setModelPKClass(long.class);

		setTable(SymptomTable.INSTANCE);
	}

	/**
	 * Caches the symptom in the entity cache if it is enabled.
	 *
	 * @param symptom the symptom
	 */
	@Override
	public void cacheResult(Symptom symptom) {
		entityCache.putResult(
			SymptomImpl.class, symptom.getPrimaryKey(), symptom);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the symptoms in the entity cache if it is enabled.
	 *
	 * @param symptoms the symptoms
	 */
	@Override
	public void cacheResult(List<Symptom> symptoms) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (symptoms.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Symptom symptom : symptoms) {
			if (entityCache.getResult(
					SymptomImpl.class, symptom.getPrimaryKey()) == null) {

				cacheResult(symptom);
			}
		}
	}

	/**
	 * Clears the cache for all symptoms.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SymptomImpl.class);

		finderCache.clearCache(SymptomImpl.class);
	}

	/**
	 * Clears the cache for the symptom.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Symptom symptom) {
		entityCache.removeResult(SymptomImpl.class, symptom);
	}

	@Override
	public void clearCache(List<Symptom> symptoms) {
		for (Symptom symptom : symptoms) {
			entityCache.removeResult(SymptomImpl.class, symptom);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(SymptomImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SymptomImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new symptom with the primary key. Does not add the symptom to the database.
	 *
	 * @param symptomId the primary key for the new symptom
	 * @return the new symptom
	 */
	@Override
	public Symptom create(long symptomId) {
		Symptom symptom = new SymptomImpl();

		symptom.setNew(true);
		symptom.setPrimaryKey(symptomId);

		symptom.setCompanyId(CompanyThreadLocal.getCompanyId());

		return symptom;
	}

	/**
	 * Removes the symptom with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param symptomId the primary key of the symptom
	 * @return the symptom that was removed
	 * @throws NoSuchSymptomException if a symptom with the primary key could not be found
	 */
	@Override
	public Symptom remove(long symptomId) throws NoSuchSymptomException {
		return remove((Serializable)symptomId);
	}

	/**
	 * Removes the symptom with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the symptom
	 * @return the symptom that was removed
	 * @throws NoSuchSymptomException if a symptom with the primary key could not be found
	 */
	@Override
	public Symptom remove(Serializable primaryKey)
		throws NoSuchSymptomException {

		Session session = null;

		try {
			session = openSession();

			Symptom symptom = (Symptom)session.get(
				SymptomImpl.class, primaryKey);

			if (symptom == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSymptomException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(symptom);
		}
		catch (NoSuchSymptomException noSuchEntityException) {
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
	protected Symptom removeImpl(Symptom symptom) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(symptom)) {
				symptom = (Symptom)session.get(
					SymptomImpl.class, symptom.getPrimaryKeyObj());
			}

			if (symptom != null) {
				session.delete(symptom);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (symptom != null) {
			clearCache(symptom);
		}

		return symptom;
	}

	@Override
	public Symptom updateImpl(Symptom symptom) {
		boolean isNew = symptom.isNew();

		if (!(symptom instanceof SymptomModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(symptom.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(symptom);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in symptom proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Symptom implementation " +
					symptom.getClass());
		}

		SymptomModelImpl symptomModelImpl = (SymptomModelImpl)symptom;

		if (isNew && (symptom.getCreateDate() == null)) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				symptom.setCreateDate(date);
			}
			else {
				symptom.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(symptom);
			}
			else {
				symptom = (Symptom)session.merge(symptom);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(SymptomImpl.class, symptom, false, true);

		if (isNew) {
			symptom.setNew(false);
		}

		symptom.resetOriginalValues();

		return symptom;
	}

	/**
	 * Returns the symptom with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the symptom
	 * @return the symptom
	 * @throws NoSuchSymptomException if a symptom with the primary key could not be found
	 */
	@Override
	public Symptom findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSymptomException {

		Symptom symptom = fetchByPrimaryKey(primaryKey);

		if (symptom == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSymptomException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return symptom;
	}

	/**
	 * Returns the symptom with the primary key or throws a <code>NoSuchSymptomException</code> if it could not be found.
	 *
	 * @param symptomId the primary key of the symptom
	 * @return the symptom
	 * @throws NoSuchSymptomException if a symptom with the primary key could not be found
	 */
	@Override
	public Symptom findByPrimaryKey(long symptomId)
		throws NoSuchSymptomException {

		return findByPrimaryKey((Serializable)symptomId);
	}

	/**
	 * Returns the symptom with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param symptomId the primary key of the symptom
	 * @return the symptom, or <code>null</code> if a symptom with the primary key could not be found
	 */
	@Override
	public Symptom fetchByPrimaryKey(long symptomId) {
		return fetchByPrimaryKey((Serializable)symptomId);
	}

	/**
	 * Returns all the symptoms.
	 *
	 * @return the symptoms
	 */
	@Override
	public List<Symptom> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Symptom> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Symptom> findAll(
		int start, int end, OrderByComparator<Symptom> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<Symptom> findAll(
		int start, int end, OrderByComparator<Symptom> orderByComparator,
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

		List<Symptom> list = null;

		if (useFinderCache) {
			list = (List<Symptom>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SYMPTOM);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SYMPTOM;

				sql = sql.concat(SymptomModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Symptom>)QueryUtil.list(
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
	 * Removes all the symptoms from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Symptom symptom : findAll()) {
			remove(symptom);
		}
	}

	/**
	 * Returns the number of symptoms.
	 *
	 * @return the number of symptoms
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SYMPTOM);

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
		return _SQL_SELECT_SYMPTOM;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SymptomModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the symptom persistence.
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

		SymptomUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		SymptomUtil.setPersistence(null);

		entityCache.removeCache(SymptomImpl.class.getName());
	}

	@Override
	@Reference(
		target = TOKOGAE_DataPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = TOKOGAE_DataPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = TOKOGAE_DataPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_SYMPTOM =
		"SELECT symptom FROM Symptom symptom";

	private static final String _SQL_COUNT_SYMPTOM =
		"SELECT COUNT(symptom) FROM Symptom symptom";

	private static final String _ORDER_BY_ENTITY_ALIAS = "symptom.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Symptom exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		SymptomPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}