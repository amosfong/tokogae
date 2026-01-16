/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the PhraseUsage service. Represents a row in the &quot;TOKOGAEData_PhraseUsage&quot; database table, with each column mapped to a property of this class.
 *
 * @author Amos Fong
 * @see PhraseUsageModel
 * @generated
 */
@ImplementationClassName("com.tokogae.data.model.impl.PhraseUsageImpl")
@ProviderType
public interface PhraseUsage extends PersistedModel, PhraseUsageModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.tokogae.data.model.impl.PhraseUsageImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<PhraseUsage, Long> PHRASE_USAGE_ID_ACCESSOR =
		new Accessor<PhraseUsage, Long>() {

			@Override
			public Long get(PhraseUsage phraseUsage) {
				return phraseUsage.getPhraseUsageId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<PhraseUsage> getTypeClass() {
				return PhraseUsage.class;
			}

		};

}