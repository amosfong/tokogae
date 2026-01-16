/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import com.tokogae.data.model.PhraseTable;
import com.tokogae.data.model.impl.PhraseImpl;
import com.tokogae.data.model.impl.PhraseModelImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from Phrase.
 *
 * @author Amos Fong
 * @generated
 */
@Component(
	property = {
		"class.name=com.tokogae.data.model.impl.PhraseImpl",
		"table.name=TOKOGAEData_Phrase"
	},
	service = ArgumentsResolver.class
)
public class PhraseModelArgumentsResolver implements ArgumentsResolver {

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

		PhraseModelImpl phraseModelImpl = (PhraseModelImpl)baseModel;

		long columnBitmask = phraseModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(phraseModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |= phraseModelImpl.getColumnBitmask(
					columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(phraseModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return PhraseImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return PhraseTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		PhraseModelImpl phraseModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = phraseModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = phraseModelImpl.getColumnValue(columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}