/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.account.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import com.tokogae.account.model.SubjectTable;
import com.tokogae.account.model.impl.SubjectImpl;
import com.tokogae.account.model.impl.SubjectModelImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from Subject.
 *
 * @author Amos Fong
 * @generated
 */
@Component(
	property = {
		"class.name=com.tokogae.account.model.impl.SubjectImpl",
		"table.name=TOKOGAE_Subject"
	},
	service = ArgumentsResolver.class
)
public class SubjectModelArgumentsResolver implements ArgumentsResolver {

	@Override
	public Object[] getArguments(
		FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
		boolean original) {

		String[] columnNames = finderPath.getColumnNames();

		if ((columnNames == null) || (columnNames.length == 0)) {
			if (baseModel.isNew()) {
				return new Object[0];
			}

			return null;
		}

		SubjectModelImpl subjectModelImpl = (SubjectModelImpl)baseModel;

		long columnBitmask = subjectModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(subjectModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |= subjectModelImpl.getColumnBitmask(
					columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(subjectModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return SubjectImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return SubjectTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		SubjectModelImpl subjectModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = subjectModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = subjectModelImpl.getColumnValue(columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}