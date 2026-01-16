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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;

import com.tokogae.data.exception.NoSuchPhraseException;
import com.tokogae.data.model.Phrase;
import com.tokogae.data.model.PhraseTable;
import com.tokogae.data.model.impl.PhraseImpl;
import com.tokogae.data.model.impl.PhraseModelImpl;
import com.tokogae.data.service.persistence.PhrasePersistence;
import com.tokogae.data.service.persistence.PhraseUtil;
import com.tokogae.data.service.persistence.impl.constants.TOKOGAEDataPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the phrase service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Amos Fong
 * @generated
 */
@Component(service = PhrasePersistence.class)
public class PhrasePersistenceImpl
	extends BasePersistenceImpl<Phrase> implements PhrasePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PhraseUtil</code> to access the phrase persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PhraseImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByText;

	/**
	 * Returns the phrase where text = &#63; or throws a <code>NoSuchPhraseException</code> if it could not be found.
	 *
	 * @param text the text
	 * @return the matching phrase
	 * @throws NoSuchPhraseException if a matching phrase could not be found
	 */
	@Override
	public Phrase findByText(String text) throws NoSuchPhraseException {
		Phrase phrase = fetchByText(text);

		if (phrase == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("text=");
			sb.append(text);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchPhraseException(sb.toString());
		}

		return phrase;
	}

	/**
	 * Returns the phrase where text = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param text the text
	 * @return the matching phrase, or <code>null</code> if a matching phrase could not be found
	 */
	@Override
	public Phrase fetchByText(String text) {
		return fetchByText(text, true);
	}

	/**
	 * Returns the phrase where text = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param text the text
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching phrase, or <code>null</code> if a matching phrase could not be found
	 */
	@Override
	public Phrase fetchByText(String text, boolean useFinderCache) {
		text = Objects.toString(text, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {text};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByText, finderArgs, this);
		}

		if (result instanceof Phrase) {
			Phrase phrase = (Phrase)result;

			if (!Objects.equals(text, phrase.getText())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_PHRASE_WHERE);

			boolean bindText = false;

			if (text.isEmpty()) {
				sb.append(_FINDER_COLUMN_TEXT_TEXT_3);
			}
			else {
				bindText = true;

				sb.append(_FINDER_COLUMN_TEXT_TEXT_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindText) {
					queryPos.add(text);
				}

				List<Phrase> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByText, finderArgs, list);
					}
				}
				else {
					Phrase phrase = list.get(0);

					result = phrase;

					cacheResult(phrase);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Phrase)result;
		}
	}

	/**
	 * Removes the phrase where text = &#63; from the database.
	 *
	 * @param text the text
	 * @return the phrase that was removed
	 */
	@Override
	public Phrase removeByText(String text) throws NoSuchPhraseException {
		Phrase phrase = findByText(text);

		return remove(phrase);
	}

	/**
	 * Returns the number of phrases where text = &#63;.
	 *
	 * @param text the text
	 * @return the number of matching phrases
	 */
	@Override
	public int countByText(String text) {
		Phrase phrase = fetchByText(text);

		if (phrase == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_TEXT_TEXT_2 = "phrase.text = ?";

	private static final String _FINDER_COLUMN_TEXT_TEXT_3 =
		"(phrase.text IS NULL OR phrase.text = '')";

	public PhrasePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("text", "text_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Phrase.class);

		setModelImplClass(PhraseImpl.class);
		setModelPKClass(long.class);

		setTable(PhraseTable.INSTANCE);
	}

	/**
	 * Caches the phrase in the entity cache if it is enabled.
	 *
	 * @param phrase the phrase
	 */
	@Override
	public void cacheResult(Phrase phrase) {
		entityCache.putResult(PhraseImpl.class, phrase.getPrimaryKey(), phrase);

		finderCache.putResult(
			_finderPathFetchByText, new Object[] {phrase.getText()}, phrase);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the phrases in the entity cache if it is enabled.
	 *
	 * @param phrases the phrases
	 */
	@Override
	public void cacheResult(List<Phrase> phrases) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (phrases.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Phrase phrase : phrases) {
			if (entityCache.getResult(
					PhraseImpl.class, phrase.getPrimaryKey()) == null) {

				cacheResult(phrase);
			}
		}
	}

	/**
	 * Clears the cache for all phrases.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PhraseImpl.class);

		finderCache.clearCache(PhraseImpl.class);
	}

	/**
	 * Clears the cache for the phrase.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Phrase phrase) {
		entityCache.removeResult(PhraseImpl.class, phrase);
	}

	@Override
	public void clearCache(List<Phrase> phrases) {
		for (Phrase phrase : phrases) {
			entityCache.removeResult(PhraseImpl.class, phrase);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(PhraseImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PhraseImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(PhraseModelImpl phraseModelImpl) {
		Object[] args = new Object[] {phraseModelImpl.getText()};

		finderCache.putResult(_finderPathFetchByText, args, phraseModelImpl);
	}

	/**
	 * Creates a new phrase with the primary key. Does not add the phrase to the database.
	 *
	 * @param phraseId the primary key for the new phrase
	 * @return the new phrase
	 */
	@Override
	public Phrase create(long phraseId) {
		Phrase phrase = new PhraseImpl();

		phrase.setNew(true);
		phrase.setPrimaryKey(phraseId);

		phrase.setCompanyId(CompanyThreadLocal.getCompanyId());

		return phrase;
	}

	/**
	 * Removes the phrase with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param phraseId the primary key of the phrase
	 * @return the phrase that was removed
	 * @throws NoSuchPhraseException if a phrase with the primary key could not be found
	 */
	@Override
	public Phrase remove(long phraseId) throws NoSuchPhraseException {
		return remove((Serializable)phraseId);
	}

	/**
	 * Removes the phrase with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the phrase
	 * @return the phrase that was removed
	 * @throws NoSuchPhraseException if a phrase with the primary key could not be found
	 */
	@Override
	public Phrase remove(Serializable primaryKey) throws NoSuchPhraseException {
		Session session = null;

		try {
			session = openSession();

			Phrase phrase = (Phrase)session.get(PhraseImpl.class, primaryKey);

			if (phrase == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPhraseException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(phrase);
		}
		catch (NoSuchPhraseException noSuchEntityException) {
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
	protected Phrase removeImpl(Phrase phrase) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(phrase)) {
				phrase = (Phrase)session.get(
					PhraseImpl.class, phrase.getPrimaryKeyObj());
			}

			if (phrase != null) {
				session.delete(phrase);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (phrase != null) {
			clearCache(phrase);
		}

		return phrase;
	}

	@Override
	public Phrase updateImpl(Phrase phrase) {
		boolean isNew = phrase.isNew();

		if (!(phrase instanceof PhraseModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(phrase.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(phrase);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in phrase proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Phrase implementation " +
					phrase.getClass());
		}

		PhraseModelImpl phraseModelImpl = (PhraseModelImpl)phrase;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(phrase);
			}
			else {
				phrase = (Phrase)session.merge(phrase);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(PhraseImpl.class, phraseModelImpl, false, true);

		cacheUniqueFindersCache(phraseModelImpl);

		if (isNew) {
			phrase.setNew(false);
		}

		phrase.resetOriginalValues();

		return phrase;
	}

	/**
	 * Returns the phrase with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the phrase
	 * @return the phrase
	 * @throws NoSuchPhraseException if a phrase with the primary key could not be found
	 */
	@Override
	public Phrase findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPhraseException {

		Phrase phrase = fetchByPrimaryKey(primaryKey);

		if (phrase == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPhraseException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return phrase;
	}

	/**
	 * Returns the phrase with the primary key or throws a <code>NoSuchPhraseException</code> if it could not be found.
	 *
	 * @param phraseId the primary key of the phrase
	 * @return the phrase
	 * @throws NoSuchPhraseException if a phrase with the primary key could not be found
	 */
	@Override
	public Phrase findByPrimaryKey(long phraseId) throws NoSuchPhraseException {
		return findByPrimaryKey((Serializable)phraseId);
	}

	/**
	 * Returns the phrase with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param phraseId the primary key of the phrase
	 * @return the phrase, or <code>null</code> if a phrase with the primary key could not be found
	 */
	@Override
	public Phrase fetchByPrimaryKey(long phraseId) {
		return fetchByPrimaryKey((Serializable)phraseId);
	}

	/**
	 * Returns all the phrases.
	 *
	 * @return the phrases
	 */
	@Override
	public List<Phrase> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the phrases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhraseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phrases
	 * @param end the upper bound of the range of phrases (not inclusive)
	 * @return the range of phrases
	 */
	@Override
	public List<Phrase> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the phrases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhraseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phrases
	 * @param end the upper bound of the range of phrases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of phrases
	 */
	@Override
	public List<Phrase> findAll(
		int start, int end, OrderByComparator<Phrase> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the phrases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhraseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phrases
	 * @param end the upper bound of the range of phrases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of phrases
	 */
	@Override
	public List<Phrase> findAll(
		int start, int end, OrderByComparator<Phrase> orderByComparator,
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

		List<Phrase> list = null;

		if (useFinderCache) {
			list = (List<Phrase>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PHRASE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PHRASE;

				sql = sql.concat(PhraseModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Phrase>)QueryUtil.list(
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
	 * Removes all the phrases from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Phrase phrase : findAll()) {
			remove(phrase);
		}
	}

	/**
	 * Returns the number of phrases.
	 *
	 * @return the number of phrases
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PHRASE);

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
		return "phraseId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PHRASE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PhraseModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the phrase persistence.
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

		_finderPathFetchByText = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByText",
			new String[] {String.class.getName()}, new String[] {"text_"},
			true);

		PhraseUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		PhraseUtil.setPersistence(null);

		entityCache.removeCache(PhraseImpl.class.getName());
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

	private static final String _SQL_SELECT_PHRASE =
		"SELECT phrase FROM Phrase phrase";

	private static final String _SQL_SELECT_PHRASE_WHERE =
		"SELECT phrase FROM Phrase phrase WHERE ";

	private static final String _SQL_COUNT_PHRASE =
		"SELECT COUNT(phrase) FROM Phrase phrase";

	private static final String _SQL_COUNT_PHRASE_WHERE =
		"SELECT COUNT(phrase) FROM Phrase phrase WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "phrase.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Phrase exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Phrase exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PhrasePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"text"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}