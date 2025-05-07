/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import com.tokogae.data.event.model.FoodItemTable;
import com.tokogae.data.event.model.impl.FoodItemImpl;
import com.tokogae.data.event.model.impl.FoodItemModelImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from FoodItem.
 *
 * @author Amos Fong
 * @generated
 */
@Component(
	property = {
		"class.name=com.tokogae.data.event.model.impl.FoodItemImpl",
		"table.name=FoodItem"
	},
	service = ArgumentsResolver.class
)
public class FoodItemModelArgumentsResolver implements ArgumentsResolver {

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

		FoodItemModelImpl foodItemModelImpl = (FoodItemModelImpl)baseModel;

		long columnBitmask = foodItemModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(foodItemModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |= foodItemModelImpl.getColumnBitmask(
					columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(foodItemModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return FoodItemImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return FoodItemTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		FoodItemModelImpl foodItemModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = foodItemModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = foodItemModelImpl.getColumnValue(columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}