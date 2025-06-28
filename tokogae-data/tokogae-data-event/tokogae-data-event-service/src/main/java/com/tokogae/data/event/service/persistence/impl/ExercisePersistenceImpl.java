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
import com.liferay.portal.kernel.util.SetUtil;

import com.tokogae.data.event.exception.NoSuchExerciseException;
import com.tokogae.data.event.model.Exercise;
import com.tokogae.data.event.model.ExerciseTable;
import com.tokogae.data.event.model.impl.ExerciseImpl;
import com.tokogae.data.event.model.impl.ExerciseModelImpl;
import com.tokogae.data.event.service.persistence.ExercisePersistence;
import com.tokogae.data.event.service.persistence.ExerciseUtil;
import com.tokogae.data.event.service.persistence.impl.constants.TOKOGAEDataPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the exercise service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Amos Fong
 * @generated
 */
@Component(service = ExercisePersistence.class)
public class ExercisePersistenceImpl
	extends BasePersistenceImpl<Exercise> implements ExercisePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ExerciseUtil</code> to access the exercise persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ExerciseImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public ExercisePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("type", "type_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Exercise.class);

		setModelImplClass(ExerciseImpl.class);
		setModelPKClass(long.class);

		setTable(ExerciseTable.INSTANCE);
	}

	/**
	 * Caches the exercise in the entity cache if it is enabled.
	 *
	 * @param exercise the exercise
	 */
	@Override
	public void cacheResult(Exercise exercise) {
		entityCache.putResult(
			ExerciseImpl.class, exercise.getPrimaryKey(), exercise);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the exercises in the entity cache if it is enabled.
	 *
	 * @param exercises the exercises
	 */
	@Override
	public void cacheResult(List<Exercise> exercises) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (exercises.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Exercise exercise : exercises) {
			if (entityCache.getResult(
					ExerciseImpl.class, exercise.getPrimaryKey()) == null) {

				cacheResult(exercise);
			}
		}
	}

	/**
	 * Clears the cache for all exercises.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ExerciseImpl.class);

		finderCache.clearCache(ExerciseImpl.class);
	}

	/**
	 * Clears the cache for the exercise.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Exercise exercise) {
		entityCache.removeResult(ExerciseImpl.class, exercise);
	}

	@Override
	public void clearCache(List<Exercise> exercises) {
		for (Exercise exercise : exercises) {
			entityCache.removeResult(ExerciseImpl.class, exercise);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ExerciseImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ExerciseImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new exercise with the primary key. Does not add the exercise to the database.
	 *
	 * @param exerciseId the primary key for the new exercise
	 * @return the new exercise
	 */
	@Override
	public Exercise create(long exerciseId) {
		Exercise exercise = new ExerciseImpl();

		exercise.setNew(true);
		exercise.setPrimaryKey(exerciseId);

		exercise.setCompanyId(CompanyThreadLocal.getCompanyId());

		return exercise;
	}

	/**
	 * Removes the exercise with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param exerciseId the primary key of the exercise
	 * @return the exercise that was removed
	 * @throws NoSuchExerciseException if a exercise with the primary key could not be found
	 */
	@Override
	public Exercise remove(long exerciseId) throws NoSuchExerciseException {
		return remove((Serializable)exerciseId);
	}

	/**
	 * Removes the exercise with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the exercise
	 * @return the exercise that was removed
	 * @throws NoSuchExerciseException if a exercise with the primary key could not be found
	 */
	@Override
	public Exercise remove(Serializable primaryKey)
		throws NoSuchExerciseException {

		Session session = null;

		try {
			session = openSession();

			Exercise exercise = (Exercise)session.get(
				ExerciseImpl.class, primaryKey);

			if (exercise == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchExerciseException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(exercise);
		}
		catch (NoSuchExerciseException noSuchEntityException) {
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
	protected Exercise removeImpl(Exercise exercise) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(exercise)) {
				exercise = (Exercise)session.get(
					ExerciseImpl.class, exercise.getPrimaryKeyObj());
			}

			if (exercise != null) {
				session.delete(exercise);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (exercise != null) {
			clearCache(exercise);
		}

		return exercise;
	}

	@Override
	public Exercise updateImpl(Exercise exercise) {
		boolean isNew = exercise.isNew();

		if (!(exercise instanceof ExerciseModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(exercise.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(exercise);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in exercise proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Exercise implementation " +
					exercise.getClass());
		}

		ExerciseModelImpl exerciseModelImpl = (ExerciseModelImpl)exercise;

		if (isNew && (exercise.getCreateDate() == null)) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				exercise.setCreateDate(date);
			}
			else {
				exercise.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(exercise);
			}
			else {
				exercise = (Exercise)session.merge(exercise);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(ExerciseImpl.class, exercise, false, true);

		if (isNew) {
			exercise.setNew(false);
		}

		exercise.resetOriginalValues();

		return exercise;
	}

	/**
	 * Returns the exercise with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the exercise
	 * @return the exercise
	 * @throws NoSuchExerciseException if a exercise with the primary key could not be found
	 */
	@Override
	public Exercise findByPrimaryKey(Serializable primaryKey)
		throws NoSuchExerciseException {

		Exercise exercise = fetchByPrimaryKey(primaryKey);

		if (exercise == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchExerciseException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return exercise;
	}

	/**
	 * Returns the exercise with the primary key or throws a <code>NoSuchExerciseException</code> if it could not be found.
	 *
	 * @param exerciseId the primary key of the exercise
	 * @return the exercise
	 * @throws NoSuchExerciseException if a exercise with the primary key could not be found
	 */
	@Override
	public Exercise findByPrimaryKey(long exerciseId)
		throws NoSuchExerciseException {

		return findByPrimaryKey((Serializable)exerciseId);
	}

	/**
	 * Returns the exercise with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param exerciseId the primary key of the exercise
	 * @return the exercise, or <code>null</code> if a exercise with the primary key could not be found
	 */
	@Override
	public Exercise fetchByPrimaryKey(long exerciseId) {
		return fetchByPrimaryKey((Serializable)exerciseId);
	}

	/**
	 * Returns all the exercises.
	 *
	 * @return the exercises
	 */
	@Override
	public List<Exercise> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the exercises.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExerciseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of exercises
	 * @param end the upper bound of the range of exercises (not inclusive)
	 * @return the range of exercises
	 */
	@Override
	public List<Exercise> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the exercises.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExerciseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of exercises
	 * @param end the upper bound of the range of exercises (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of exercises
	 */
	@Override
	public List<Exercise> findAll(
		int start, int end, OrderByComparator<Exercise> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the exercises.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExerciseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of exercises
	 * @param end the upper bound of the range of exercises (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of exercises
	 */
	@Override
	public List<Exercise> findAll(
		int start, int end, OrderByComparator<Exercise> orderByComparator,
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

		List<Exercise> list = null;

		if (useFinderCache) {
			list = (List<Exercise>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EXERCISE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EXERCISE;

				sql = sql.concat(ExerciseModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Exercise>)QueryUtil.list(
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
	 * Removes all the exercises from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Exercise exercise : findAll()) {
			remove(exercise);
		}
	}

	/**
	 * Returns the number of exercises.
	 *
	 * @return the number of exercises
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EXERCISE);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "exerciseId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EXERCISE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ExerciseModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the exercise persistence.
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

		ExerciseUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		ExerciseUtil.setPersistence(null);

		entityCache.removeCache(ExerciseImpl.class.getName());
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

	private static final String _SQL_SELECT_EXERCISE =
		"SELECT exercise FROM Exercise exercise";

	private static final String _SQL_COUNT_EXERCISE =
		"SELECT COUNT(exercise) FROM Exercise exercise";

	private static final String _ORDER_BY_ENTITY_ALIAS = "exercise.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Exercise exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		ExercisePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"type"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}