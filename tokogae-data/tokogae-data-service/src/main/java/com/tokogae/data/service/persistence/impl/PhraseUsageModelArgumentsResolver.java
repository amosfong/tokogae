/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import com.tokogae.data.model.PhraseUsageTable;
import com.tokogae.data.model.impl.PhraseUsageImpl;
import com.tokogae.data.model.impl.PhraseUsageModelImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from PhraseUsage.
 *
 * @author Amos Fong
 * @generated
 */
@Component(
	property = {
		"class.name=com.tokogae.data.model.impl.PhraseUsageImpl",
		"table.name=TOKOGAEData_PhraseUsage"
	},
	service = ArgumentsResolver.class
)
public class PhraseUsageModelArgumentsResolver implements ArgumentsResolver {

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

		PhraseUsageModelImpl phraseUsageModelImpl =
			(PhraseUsageModelImpl)baseModel;

		long columnBitmask = phraseUsageModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(phraseUsageModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					phraseUsageModelImpl.getColumnBitmask(columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(phraseUsageModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return PhraseUsageImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return PhraseUsageTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		PhraseUsageModelImpl phraseUsageModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = phraseUsageModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = phraseUsageModelImpl.getColumnValue(columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}