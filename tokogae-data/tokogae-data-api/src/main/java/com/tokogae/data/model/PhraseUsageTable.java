/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;TOKOGAEData_PhraseUsage&quot; database table.
 *
 * @author Amos Fong
 * @see PhraseUsage
 * @generated
 */
public class PhraseUsageTable extends BaseTable<PhraseUsageTable> {

	public static final PhraseUsageTable INSTANCE = new PhraseUsageTable();

	public final Column<PhraseUsageTable, Long> mvccVersion = createColumn(
		"mvccVersion", Long.class, Types.BIGINT, Column.FLAG_NULLITY);
	public final Column<PhraseUsageTable, Long> phraseUsageId = createColumn(
		"phraseUsageId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<PhraseUsageTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PhraseUsageTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PhraseUsageTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PhraseUsageTable, Long> phraseId = createColumn(
		"phraseId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PhraseUsageTable, Long> classNameId = createColumn(
		"classNameId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PhraseUsageTable, Long> classPK = createColumn(
		"classPK", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PhraseUsageTable, Integer> attributesHashCode =
		createColumn(
			"attributesHashCode", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);

	private PhraseUsageTable() {
		super("TOKOGAEData_PhraseUsage", PhraseUsageTable::new);
	}

}