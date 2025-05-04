/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.account.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;Subject&quot; database table.
 *
 * @author Amos Fong
 * @see Subject
 * @generated
 */
public class SubjectTable extends BaseTable<SubjectTable> {

	public static final SubjectTable INSTANCE = new SubjectTable();

	public final Column<SubjectTable, Long> mvccVersion = createColumn(
		"mvccVersion", Long.class, Types.BIGINT, Column.FLAG_NULLITY);
	public final Column<SubjectTable, Long> subjectId = createColumn(
		"subjectId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<SubjectTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SubjectTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SubjectTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SubjectTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SubjectTable, String> firstName = createColumn(
		"firstName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SubjectTable, String> lastName = createColumn(
		"lastName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SubjectTable, String> displayName = createColumn(
		"displayName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SubjectTable, Boolean> male = createColumn(
		"male", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<SubjectTable, Date> birthday = createColumn(
		"birthday", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private SubjectTable() {
		super("Subject", SubjectTable::new);
	}

}