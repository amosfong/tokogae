/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Exercise service. Represents a row in the &quot;TOKOGAEData_Exercise&quot; database table, with each column mapped to a property of this class.
 *
 * @author Amos Fong
 * @see ExerciseModel
 * @generated
 */
@ImplementationClassName("com.tokogae.data.event.model.impl.ExerciseImpl")
@ProviderType
public interface Exercise extends ExerciseModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.tokogae.data.event.model.impl.ExerciseImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Exercise, Long> EXERCISE_ID_ACCESSOR =
		new Accessor<Exercise, Long>() {

			@Override
			public Long get(Exercise exercise) {
				return exercise.getExerciseId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Exercise> getTypeClass() {
				return Exercise.class;
			}

		};

}