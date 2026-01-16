/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;TOKOGAEData_Phrase&quot; database table.
 *
 * @author Amos Fong
 * @see Phrase
 * @generated
 */
public class PhraseTable extends BaseTable<PhraseTable> {

	public static final PhraseTable INSTANCE = new PhraseTable();

	public final Column<PhraseTable, Long> mvccVersion = createColumn(
		"mvccVersion", Long.class, Types.BIGINT, Column.FLAG_NULLITY);
	public final Column<PhraseTable, Long> phraseId = createColumn(
		"phraseId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<PhraseTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PhraseTable, String> text = createColumn(
		"text_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private PhraseTable() {
		super("TOKOGAEData_Phrase", PhraseTable::new);
	}

}