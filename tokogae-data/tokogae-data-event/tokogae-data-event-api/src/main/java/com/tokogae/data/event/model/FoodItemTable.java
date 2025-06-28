/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;TOKOGAEData_FoodItem&quot; database table.
 *
 * @author Amos Fong
 * @see FoodItem
 * @generated
 */
public class FoodItemTable extends BaseTable<FoodItemTable> {

	public static final FoodItemTable INSTANCE = new FoodItemTable();

	public final Column<FoodItemTable, Long> mvccVersion = createColumn(
		"mvccVersion", Long.class, Types.BIGINT, Column.FLAG_NULLITY);
	public final Column<FoodItemTable, Long> foodItemId = createColumn(
		"foodItemId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<FoodItemTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FoodItemTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FoodItemTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FoodItemTable, Long> subjectId = createColumn(
		"subjectId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FoodItemTable, Long> occurDay = createColumn(
		"occurDay", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FoodItemTable, Integer> occurDaySegment = createColumn(
		"occurDaySegment", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<FoodItemTable, Long> occurTime = createColumn(
		"occurTime", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FoodItemTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FoodItemTable, String> locationOfOrigin = createColumn(
		"locationOfOrigin", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FoodItemTable, String> brand = createColumn(
		"brand", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FoodItemTable, Long> quantity = createColumn(
		"quantity", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FoodItemTable, String> quantityUnit = createColumn(
		"quantityUnit", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private FoodItemTable() {
		super("TOKOGAEData_FoodItem", FoodItemTable::new);
	}

}