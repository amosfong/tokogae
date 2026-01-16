/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Phrase service. Represents a row in the &quot;TOKOGAEData_Phrase&quot; database table, with each column mapped to a property of this class.
 *
 * @author Amos Fong
 * @see PhraseModel
 * @generated
 */
@ImplementationClassName("com.tokogae.data.model.impl.PhraseImpl")
@ProviderType
public interface Phrase extends PersistedModel, PhraseModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.tokogae.data.model.impl.PhraseImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Phrase, Long> PHRASE_ID_ACCESSOR =
		new Accessor<Phrase, Long>() {

			@Override
			public Long get(Phrase phrase) {
				return phrase.getPhraseId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Phrase> getTypeClass() {
				return Phrase.class;
			}

		};

}