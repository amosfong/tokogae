/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;Symptom&quot; database table.
 *
 * @author Amos Fong
 * @see Symptom
 * @generated
 */
public class SymptomTable extends BaseTable<SymptomTable> {

	public static final SymptomTable INSTANCE = new SymptomTable();

	public final Column<SymptomTable, Long> mvccVersion = createColumn(
		"mvccVersion", Long.class, Types.BIGINT, Column.FLAG_NULLITY);
	public final Column<SymptomTable, Long> symptomId = createColumn(
		"symptomId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<SymptomTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SymptomTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SymptomTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SymptomTable, Long> occurDay = createColumn(
		"occurDay", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SymptomTable, Integer> occurDaySegment = createColumn(
		"occurDaySegment", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<SymptomTable, Long> occurTime = createColumn(
		"occurTime", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SymptomTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SymptomTable, Date> startDate = createColumn(
		"startDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SymptomTable, Date> endDate = createColumn(
		"endDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SymptomTable, Integer> intensityLevel = createColumn(
		"intensityLevel", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);

	private SymptomTable() {
		super("Symptom", SymptomTable::new);
	}

}