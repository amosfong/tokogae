/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Exercise}.
 * </p>
 *
 * @author Amos Fong
 * @see Exercise
 * @generated
 */
public class ExerciseWrapper
	extends BaseModelWrapper<Exercise>
	implements Exercise, ModelWrapper<Exercise> {

	public ExerciseWrapper(Exercise exercise) {
		super(exercise);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("exerciseId", getExerciseId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("subjectId", getSubjectId());
		attributes.put("occurDayBaseTime", getOccurDayBaseTime());
		attributes.put("occurDayNativeTime", getOccurDayNativeTime());
		attributes.put("name", getName());
		attributes.put("duration", getDuration());
		attributes.put("quantity", getQuantity());
		attributes.put("quantityUnit", getQuantityUnit());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		Long exerciseId = (Long)attributes.get("exerciseId");

		if (exerciseId != null) {
			setExerciseId(exerciseId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long subjectId = (Long)attributes.get("subjectId");

		if (subjectId != null) {
			setSubjectId(subjectId);
		}

		Long occurDayBaseTime = (Long)attributes.get("occurDayBaseTime");

		if (occurDayBaseTime != null) {
			setOccurDayBaseTime(occurDayBaseTime);
		}

		Long occurDayNativeTime = (Long)attributes.get("occurDayNativeTime");

		if (occurDayNativeTime != null) {
			setOccurDayNativeTime(occurDayNativeTime);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long duration = (Long)attributes.get("duration");

		if (duration != null) {
			setDuration(duration);
		}

		Double quantity = (Double)attributes.get("quantity");

		if (quantity != null) {
			setQuantity(quantity);
		}

		String quantityUnit = (String)attributes.get("quantityUnit");

		if (quantityUnit != null) {
			setQuantityUnit(quantityUnit);
		}
	}

	@Override
	public Exercise cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this exercise.
	 *
	 * @return the company ID of this exercise
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this exercise.
	 *
	 * @return the create date of this exercise
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the duration of this exercise.
	 *
	 * @return the duration of this exercise
	 */
	@Override
	public long getDuration() {
		return model.getDuration();
	}

	/**
	 * Returns the exercise ID of this exercise.
	 *
	 * @return the exercise ID of this exercise
	 */
	@Override
	public long getExerciseId() {
		return model.getExerciseId();
	}

	/**
	 * Returns the mvcc version of this exercise.
	 *
	 * @return the mvcc version of this exercise
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the name of this exercise.
	 *
	 * @return the name of this exercise
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the occur day base time of this exercise.
	 *
	 * @return the occur day base time of this exercise
	 */
	@Override
	public long getOccurDayBaseTime() {
		return model.getOccurDayBaseTime();
	}

	/**
	 * Returns the occur day native time of this exercise.
	 *
	 * @return the occur day native time of this exercise
	 */
	@Override
	public long getOccurDayNativeTime() {
		return model.getOccurDayNativeTime();
	}

	/**
	 * Returns the primary key of this exercise.
	 *
	 * @return the primary key of this exercise
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the quantity of this exercise.
	 *
	 * @return the quantity of this exercise
	 */
	@Override
	public double getQuantity() {
		return model.getQuantity();
	}

	@Override
	public String getQuantityLabel() {
		return model.getQuantityLabel();
	}

	/**
	 * Returns the quantity unit of this exercise.
	 *
	 * @return the quantity unit of this exercise
	 */
	@Override
	public String getQuantityUnit() {
		return model.getQuantityUnit();
	}

	/**
	 * Returns the subject ID of this exercise.
	 *
	 * @return the subject ID of this exercise
	 */
	@Override
	public long getSubjectId() {
		return model.getSubjectId();
	}

	/**
	 * Returns the user ID of this exercise.
	 *
	 * @return the user ID of this exercise
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this exercise.
	 *
	 * @return the user uuid of this exercise
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this exercise.
	 *
	 * @param companyId the company ID of this exercise
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this exercise.
	 *
	 * @param createDate the create date of this exercise
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the duration of this exercise.
	 *
	 * @param duration the duration of this exercise
	 */
	@Override
	public void setDuration(long duration) {
		model.setDuration(duration);
	}

	/**
	 * Sets the exercise ID of this exercise.
	 *
	 * @param exerciseId the exercise ID of this exercise
	 */
	@Override
	public void setExerciseId(long exerciseId) {
		model.setExerciseId(exerciseId);
	}

	/**
	 * Sets the mvcc version of this exercise.
	 *
	 * @param mvccVersion the mvcc version of this exercise
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the name of this exercise.
	 *
	 * @param name the name of this exercise
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the occur day base time of this exercise.
	 *
	 * @param occurDayBaseTime the occur day base time of this exercise
	 */
	@Override
	public void setOccurDayBaseTime(long occurDayBaseTime) {
		model.setOccurDayBaseTime(occurDayBaseTime);
	}

	/**
	 * Sets the occur day native time of this exercise.
	 *
	 * @param occurDayNativeTime the occur day native time of this exercise
	 */
	@Override
	public void setOccurDayNativeTime(long occurDayNativeTime) {
		model.setOccurDayNativeTime(occurDayNativeTime);
	}

	/**
	 * Sets the primary key of this exercise.
	 *
	 * @param primaryKey the primary key of this exercise
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the quantity of this exercise.
	 *
	 * @param quantity the quantity of this exercise
	 */
	@Override
	public void setQuantity(double quantity) {
		model.setQuantity(quantity);
	}

	/**
	 * Sets the quantity unit of this exercise.
	 *
	 * @param quantityUnit the quantity unit of this exercise
	 */
	@Override
	public void setQuantityUnit(String quantityUnit) {
		model.setQuantityUnit(quantityUnit);
	}

	/**
	 * Sets the subject ID of this exercise.
	 *
	 * @param subjectId the subject ID of this exercise
	 */
	@Override
	public void setSubjectId(long subjectId) {
		model.setSubjectId(subjectId);
	}

	/**
	 * Sets the user ID of this exercise.
	 *
	 * @param userId the user ID of this exercise
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this exercise.
	 *
	 * @param userUuid the user uuid of this exercise
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected ExerciseWrapper wrap(Exercise exercise) {
		return new ExerciseWrapper(exercise);
	}

}