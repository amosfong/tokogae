/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.service.persistence.impl;

import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;

import com.tokogae.data.service.persistence.PhraseUsageFinder;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Amos Fong
 */
@Component(service = PhraseUsageFinder.class)
public class PhraseUsageFinderImpl
	extends PhraseUsageFinderBaseImpl implements PhraseUsageFinder {

	public static final String FIND_BY_TOP_USAGE =
		PhraseUsageFinder.class.getName() + ".findByTopUsage";

	public List<Long> findByTopUsage(long phraseId, int start, int end) {
		Session session = null;

		try {
			session = openSession();

			String sql = _customSQL.get(getClass(), FIND_BY_TOP_USAGE);

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar("phraseUsageId", Type.LONG);

			QueryPos qPos = QueryPos.getInstance(sqlQuery);

			qPos.add(phraseId);

			return (List<Long>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Reference
	private CustomSQL _customSQL;

}