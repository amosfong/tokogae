/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Symptom service. Represents a row in the &quot;TOKOGAEData_Symptom&quot; database table, with each column mapped to a property of this class.
 *
 * @author Amos Fong
 * @see SymptomModel
 * @generated
 */
@ImplementationClassName("com.tokogae.data.event.model.impl.SymptomImpl")
@ProviderType
public interface Symptom extends PersistedModel, SymptomModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.tokogae.data.event.model.impl.SymptomImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Symptom, Long> SYMPTOM_ID_ACCESSOR =
		new Accessor<Symptom, Long>() {

			@Override
			public Long get(Symptom symptom) {
				return symptom.getSymptomId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Symptom> getTypeClass() {
				return Symptom.class;
			}

		};

	public String getIntensityLevelLabel();

}