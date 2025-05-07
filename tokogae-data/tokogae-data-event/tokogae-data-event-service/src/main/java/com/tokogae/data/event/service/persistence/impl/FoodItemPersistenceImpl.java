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

import com.tokogae.data.event.exception.NoSuchFoodItemException;
import com.tokogae.data.event.model.FoodItem;
import com.tokogae.data.event.model.FoodItemTable;
import com.tokogae.data.event.model.impl.FoodItemImpl;
import com.tokogae.data.event.model.impl.FoodItemModelImpl;
import com.tokogae.data.event.service.persistence.FoodItemPersistence;
import com.tokogae.data.event.service.persistence.FoodItemUtil;
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
 * The persistence implementation for the food item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Amos Fong
 * @generated
 */
@Component(service = FoodItemPersistence.class)
public class FoodItemPersistenceImpl
	extends BasePersistenceImpl<FoodItem> implements FoodItemPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FoodItemUtil</code> to access the food item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FoodItemImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public FoodItemPersistenceImpl() {
		setModelClass(FoodItem.class);

		setModelImplClass(FoodItemImpl.class);
		setModelPKClass(long.class);

		setTable(FoodItemTable.INSTANCE);
	}

	/**
	 * Caches the food item in the entity cache if it is enabled.
	 *
	 * @param foodItem the food item
	 */
	@Override
	public void cacheResult(FoodItem foodItem) {
		entityCache.putResult(
			FoodItemImpl.class, foodItem.getPrimaryKey(), foodItem);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the food items in the entity cache if it is enabled.
	 *
	 * @param foodItems the food items
	 */
	@Override
	public void cacheResult(List<FoodItem> foodItems) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (foodItems.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (FoodItem foodItem : foodItems) {
			if (entityCache.getResult(
					FoodItemImpl.class, foodItem.getPrimaryKey()) == null) {

				cacheResult(foodItem);
			}
		}
	}

	/**
	 * Clears the cache for all food items.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FoodItemImpl.class);

		finderCache.clearCache(FoodItemImpl.class);
	}

	/**
	 * Clears the cache for the food item.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FoodItem foodItem) {
		entityCache.removeResult(FoodItemImpl.class, foodItem);
	}

	@Override
	public void clearCache(List<FoodItem> foodItems) {
		for (FoodItem foodItem : foodItems) {
			entityCache.removeResult(FoodItemImpl.class, foodItem);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FoodItemImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(FoodItemImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new food item with the primary key. Does not add the food item to the database.
	 *
	 * @param foodItemId the primary key for the new food item
	 * @return the new food item
	 */
	@Override
	public FoodItem create(long foodItemId) {
		FoodItem foodItem = new FoodItemImpl();

		foodItem.setNew(true);
		foodItem.setPrimaryKey(foodItemId);

		foodItem.setCompanyId(CompanyThreadLocal.getCompanyId());

		return foodItem;
	}

	/**
	 * Removes the food item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param foodItemId the primary key of the food item
	 * @return the food item that was removed
	 * @throws NoSuchFoodItemException if a food item with the primary key could not be found
	 */
	@Override
	public FoodItem remove(long foodItemId) throws NoSuchFoodItemException {
		return remove((Serializable)foodItemId);
	}

	/**
	 * Removes the food item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the food item
	 * @return the food item that was removed
	 * @throws NoSuchFoodItemException if a food item with the primary key could not be found
	 */
	@Override
	public FoodItem remove(Serializable primaryKey)
		throws NoSuchFoodItemException {

		Session session = null;

		try {
			session = openSession();

			FoodItem foodItem = (FoodItem)session.get(
				FoodItemImpl.class, primaryKey);

			if (foodItem == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFoodItemException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(foodItem);
		}
		catch (NoSuchFoodItemException noSuchEntityException) {
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
	protected FoodItem removeImpl(FoodItem foodItem) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(foodItem)) {
				foodItem = (FoodItem)session.get(
					FoodItemImpl.class, foodItem.getPrimaryKeyObj());
			}

			if (foodItem != null) {
				session.delete(foodItem);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (foodItem != null) {
			clearCache(foodItem);
		}

		return foodItem;
	}

	@Override
	public FoodItem updateImpl(FoodItem foodItem) {
		boolean isNew = foodItem.isNew();

		if (!(foodItem instanceof FoodItemModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(foodItem.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(foodItem);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in foodItem proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FoodItem implementation " +
					foodItem.getClass());
		}

		FoodItemModelImpl foodItemModelImpl = (FoodItemModelImpl)foodItem;

		if (isNew && (foodItem.getCreateDate() == null)) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				foodItem.setCreateDate(date);
			}
			else {
				foodItem.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(foodItem);
			}
			else {
				foodItem = (FoodItem)session.merge(foodItem);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(FoodItemImpl.class, foodItem, false, true);

		if (isNew) {
			foodItem.setNew(false);
		}

		foodItem.resetOriginalValues();

		return foodItem;
	}

	/**
	 * Returns the food item with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the food item
	 * @return the food item
	 * @throws NoSuchFoodItemException if a food item with the primary key could not be found
	 */
	@Override
	public FoodItem findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFoodItemException {

		FoodItem foodItem = fetchByPrimaryKey(primaryKey);

		if (foodItem == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFoodItemException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return foodItem;
	}

	/**
	 * Returns the food item with the primary key or throws a <code>NoSuchFoodItemException</code> if it could not be found.
	 *
	 * @param foodItemId the primary key of the food item
	 * @return the food item
	 * @throws NoSuchFoodItemException if a food item with the primary key could not be found
	 */
	@Override
	public FoodItem findByPrimaryKey(long foodItemId)
		throws NoSuchFoodItemException {

		return findByPrimaryKey((Serializable)foodItemId);
	}

	/**
	 * Returns the food item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param foodItemId the primary key of the food item
	 * @return the food item, or <code>null</code> if a food item with the primary key could not be found
	 */
	@Override
	public FoodItem fetchByPrimaryKey(long foodItemId) {
		return fetchByPrimaryKey((Serializable)foodItemId);
	}

	/**
	 * Returns all the food items.
	 *
	 * @return the food items
	 */
	@Override
	public List<FoodItem> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the food items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FoodItemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of food items
	 * @param end the upper bound of the range of food items (not inclusive)
	 * @return the range of food items
	 */
	@Override
	public List<FoodItem> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the food items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FoodItemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of food items
	 * @param end the upper bound of the range of food items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of food items
	 */
	@Override
	public List<FoodItem> findAll(
		int start, int end, OrderByComparator<FoodItem> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the food items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FoodItemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of food items
	 * @param end the upper bound of the range of food items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of food items
	 */
	@Override
	public List<FoodItem> findAll(
		int start, int end, OrderByComparator<FoodItem> orderByComparator,
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

		List<FoodItem> list = null;

		if (useFinderCache) {
			list = (List<FoodItem>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FOODITEM);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FOODITEM;

				sql = sql.concat(FoodItemModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<FoodItem>)QueryUtil.list(
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
	 * Removes all the food items from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FoodItem foodItem : findAll()) {
			remove(foodItem);
		}
	}

	/**
	 * Returns the number of food items.
	 *
	 * @return the number of food items
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_FOODITEM);

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
		return "foodItemId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FOODITEM;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FoodItemModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the food item persistence.
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

		FoodItemUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		FoodItemUtil.setPersistence(null);

		entityCache.removeCache(FoodItemImpl.class.getName());
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

	private static final String _SQL_SELECT_FOODITEM =
		"SELECT foodItem FROM FoodItem foodItem";

	private static final String _SQL_COUNT_FOODITEM =
		"SELECT COUNT(foodItem) FROM FoodItem foodItem";

	private static final String _ORDER_BY_ENTITY_ALIAS = "foodItem.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FoodItem exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		FoodItemPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}