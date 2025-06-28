/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;TOKOGAEData_Exercise&quot; database table.
 *
 * @author Amos Fong
 * @see Exercise
 * @generated
 */
public class ExerciseTable extends BaseTable<ExerciseTable> {

	public static final ExerciseTable INSTANCE = new ExerciseTable();

	public final Column<ExerciseTable, Long> mvccVersion = createColumn(
		"mvccVersion", Long.class, Types.BIGINT, Column.FLAG_NULLITY);
	public final Column<ExerciseTable, Long> exerciseId = createColumn(
		"exerciseId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ExerciseTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ExerciseTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ExerciseTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ExerciseTable, Long> occurDay = createColumn(
		"occurDay", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ExerciseTable, Integer> occurDaySegment = createColumn(
		"occurDaySegment", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ExerciseTable, Long> occurTime = createColumn(
		"occurTime", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ExerciseTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ExerciseTable, Integer> type = createColumn(
		"type_", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ExerciseTable, Integer> duration = createColumn(
		"duration", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ExerciseTable, Integer> intensityLevel = createColumn(
		"intensityLevel", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ExerciseTable, Integer> quantity = createColumn(
		"quantity", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);

	private ExerciseTable() {
		super("TOKOGAEData_Exercise", ExerciseTable::new);
	}

}