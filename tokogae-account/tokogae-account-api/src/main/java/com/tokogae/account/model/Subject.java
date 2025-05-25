/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.account.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Subject service. Represents a row in the &quot;TOKOGAE_Subject&quot; database table, with each column mapped to a property of this class.
 *
 * @author Amos Fong
 * @see SubjectModel
 * @generated
 */
@ImplementationClassName("com.tokogae.account.model.impl.SubjectImpl")
@ProviderType
public interface Subject extends PersistedModel, SubjectModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.tokogae.account.model.impl.SubjectImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Subject, Long> SUBJECT_ID_ACCESSOR =
		new Accessor<Subject, Long>() {

			@Override
			public Long get(Subject subject) {
				return subject.getSubjectId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Subject> getTypeClass() {
				return Subject.class;
			}

		};

}