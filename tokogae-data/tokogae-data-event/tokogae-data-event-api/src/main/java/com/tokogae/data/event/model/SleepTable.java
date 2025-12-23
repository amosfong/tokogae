/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;TOKOGAEData_Sleep&quot; database table.
 *
 * @author Amos Fong
 * @see Sleep
 * @generated
 */
public class SleepTable extends BaseTable<SleepTable> {

	public static final SleepTable INSTANCE = new SleepTable();

	public final Column<SleepTable, Long> mvccVersion = createColumn(
		"mvccVersion", Long.class, Types.BIGINT, Column.FLAG_NULLITY);
	public final Column<SleepTable, Long> sleepId = createColumn(
		"sleepId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<SleepTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SleepTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SleepTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SleepTable, Long> subjectId = createColumn(
		"subjectId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SleepTable, Long> occurDay = createColumn(
		"occurDay", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SleepTable, Integer> occurDaySegment = createColumn(
		"occurDaySegment", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<SleepTable, Long> occurTime = createColumn(
		"occurTime", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SleepTable, Long> duration = createColumn(
		"duration", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private SleepTable() {
		super("TOKOGAEData_Sleep", SleepTable::new);
	}

}