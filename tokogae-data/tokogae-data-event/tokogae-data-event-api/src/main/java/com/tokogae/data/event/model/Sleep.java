/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Sleep service. Represents a row in the &quot;TOKOGAEData_Sleep&quot; database table, with each column mapped to a property of this class.
 *
 * @author Amos Fong
 * @see SleepModel
 * @generated
 */
@ImplementationClassName("com.tokogae.data.event.model.impl.SleepImpl")
@ProviderType
public interface Sleep extends PersistedModel, SleepModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.tokogae.data.event.model.impl.SleepImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Sleep, Long> SLEEP_ID_ACCESSOR =
		new Accessor<Sleep, Long>() {

			@Override
			public Long get(Sleep sleep) {
				return sleep.getSleepId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Sleep> getTypeClass() {
				return Sleep.class;
			}

		};

}