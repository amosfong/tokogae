/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import com.tokogae.data.event.model.ExerciseTable;
import com.tokogae.data.event.model.impl.ExerciseImpl;
import com.tokogae.data.event.model.impl.ExerciseModelImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from Exercise.
 *
 * @author Amos Fong
 * @generated
 */
@Component(
	property = {
		"class.name=com.tokogae.data.event.model.impl.ExerciseImpl",
		"table.name=Exercise"
	},
	service = ArgumentsResolver.class
)
public class ExerciseModelArgumentsResolver implements ArgumentsResolver {

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

		ExerciseModelImpl exerciseModelImpl = (ExerciseModelImpl)baseModel;

		long columnBitmask = exerciseModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(exerciseModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |= exerciseModelImpl.getColumnBitmask(
					columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(exerciseModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return ExerciseImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return ExerciseTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		ExerciseModelImpl exerciseModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = exerciseModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = exerciseModelImpl.getColumnValue(columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}