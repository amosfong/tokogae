/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;TOKOGAEData_SymptomPeriod&quot; database table.
 *
 * @author Amos Fong
 * @see SymptomPeriod
 * @generated
 */
public class SymptomPeriodTable extends BaseTable<SymptomPeriodTable> {

	public static final SymptomPeriodTable INSTANCE = new SymptomPeriodTable();

	public final Column<SymptomPeriodTable, Long> mvccVersion = createColumn(
		"mvccVersion", Long.class, Types.BIGINT, Column.FLAG_NULLITY);
	public final Column<SymptomPeriodTable, Long> symptomId = createColumn(
		"symptomId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<SymptomPeriodTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SymptomPeriodTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SymptomPeriodTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SymptomPeriodTable, Long> subjectId = createColumn(
		"subjectId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SymptomPeriodTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SymptomPeriodTable, Date> startDate = createColumn(
		"startDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SymptomPeriodTable, Date> endDate = createColumn(
		"endDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private SymptomPeriodTable() {
		super("TOKOGAEData_SymptomPeriod", SymptomPeriodTable::new);
	}

}