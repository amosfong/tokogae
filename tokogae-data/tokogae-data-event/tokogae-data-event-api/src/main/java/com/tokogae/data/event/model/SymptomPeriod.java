/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the SymptomPeriod service. Represents a row in the &quot;TOKOGAEData_SymptomPeriod&quot; database table, with each column mapped to a property of this class.
 *
 * @author Amos Fong
 * @see SymptomPeriodModel
 * @generated
 */
@ImplementationClassName("com.tokogae.data.event.model.impl.SymptomPeriodImpl")
@ProviderType
public interface SymptomPeriod extends PersistedModel, SymptomPeriodModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.tokogae.data.event.model.impl.SymptomPeriodImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<SymptomPeriod, Long> SYMPTOM_ID_ACCESSOR =
		new Accessor<SymptomPeriod, Long>() {

			@Override
			public Long get(SymptomPeriod symptomPeriod) {
				return symptomPeriod.getSymptomId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<SymptomPeriod> getTypeClass() {
				return SymptomPeriod.class;
			}

		};

}