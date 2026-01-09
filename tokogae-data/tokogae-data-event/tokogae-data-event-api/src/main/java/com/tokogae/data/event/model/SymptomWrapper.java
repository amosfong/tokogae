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
 * This class is a wrapper for {@link Symptom}.
 * </p>
 *
 * @author Amos Fong
 * @see Symptom
 * @generated
 */
public class SymptomWrapper
	extends BaseModelWrapper<Symptom>
	implements ModelWrapper<Symptom>, Symptom {

	public SymptomWrapper(Symptom symptom) {
		super(symptom);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("symptomId", getSymptomId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("subjectId", getSubjectId());
		attributes.put("occurDayBaseTime", getOccurDayBaseTime());
		attributes.put("occurDayNativeTime", getOccurDayNativeTime());
		attributes.put("duration", getDuration());
		attributes.put("name", getName());
		attributes.put("affectedArea", getAffectedArea());
		attributes.put("intensityLevel", getIntensityLevel());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		Long symptomId = (Long)attributes.get("symptomId");

		if (symptomId != null) {
			setSymptomId(symptomId);
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

		Long duration = (Long)attributes.get("duration");

		if (duration != null) {
			setDuration(duration);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String affectedArea = (String)attributes.get("affectedArea");

		if (affectedArea != null) {
			setAffectedArea(affectedArea);
		}

		Integer intensityLevel = (Integer)attributes.get("intensityLevel");

		if (intensityLevel != null) {
			setIntensityLevel(intensityLevel);
		}
	}

	@Override
	public Symptom cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the affected area of this symptom.
	 *
	 * @return the affected area of this symptom
	 */
	@Override
	public String getAffectedArea() {
		return model.getAffectedArea();
	}

	/**
	 * Returns the company ID of this symptom.
	 *
	 * @return the company ID of this symptom
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this symptom.
	 *
	 * @return the create date of this symptom
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the duration of this symptom.
	 *
	 * @return the duration of this symptom
	 */
	@Override
	public long getDuration() {
		return model.getDuration();
	}

	/**
	 * Returns the intensity level of this symptom.
	 *
	 * @return the intensity level of this symptom
	 */
	@Override
	public int getIntensityLevel() {
		return model.getIntensityLevel();
	}

	@Override
	public String getIntensityLevelLabel() {
		return model.getIntensityLevelLabel();
	}

	/**
	 * Returns the mvcc version of this symptom.
	 *
	 * @return the mvcc version of this symptom
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the name of this symptom.
	 *
	 * @return the name of this symptom
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the occur day base time of this symptom.
	 *
	 * @return the occur day base time of this symptom
	 */
	@Override
	public long getOccurDayBaseTime() {
		return model.getOccurDayBaseTime();
	}

	/**
	 * Returns the occur day native time of this symptom.
	 *
	 * @return the occur day native time of this symptom
	 */
	@Override
	public long getOccurDayNativeTime() {
		return model.getOccurDayNativeTime();
	}

	/**
	 * Returns the primary key of this symptom.
	 *
	 * @return the primary key of this symptom
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the subject ID of this symptom.
	 *
	 * @return the subject ID of this symptom
	 */
	@Override
	public long getSubjectId() {
		return model.getSubjectId();
	}

	/**
	 * Returns the symptom ID of this symptom.
	 *
	 * @return the symptom ID of this symptom
	 */
	@Override
	public long getSymptomId() {
		return model.getSymptomId();
	}

	/**
	 * Returns the user ID of this symptom.
	 *
	 * @return the user ID of this symptom
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this symptom.
	 *
	 * @return the user uuid of this symptom
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
	 * Sets the affected area of this symptom.
	 *
	 * @param affectedArea the affected area of this symptom
	 */
	@Override
	public void setAffectedArea(String affectedArea) {
		model.setAffectedArea(affectedArea);
	}

	/**
	 * Sets the company ID of this symptom.
	 *
	 * @param companyId the company ID of this symptom
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this symptom.
	 *
	 * @param createDate the create date of this symptom
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the duration of this symptom.
	 *
	 * @param duration the duration of this symptom
	 */
	@Override
	public void setDuration(long duration) {
		model.setDuration(duration);
	}

	/**
	 * Sets the intensity level of this symptom.
	 *
	 * @param intensityLevel the intensity level of this symptom
	 */
	@Override
	public void setIntensityLevel(int intensityLevel) {
		model.setIntensityLevel(intensityLevel);
	}

	/**
	 * Sets the mvcc version of this symptom.
	 *
	 * @param mvccVersion the mvcc version of this symptom
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the name of this symptom.
	 *
	 * @param name the name of this symptom
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the occur day base time of this symptom.
	 *
	 * @param occurDayBaseTime the occur day base time of this symptom
	 */
	@Override
	public void setOccurDayBaseTime(long occurDayBaseTime) {
		model.setOccurDayBaseTime(occurDayBaseTime);
	}

	/**
	 * Sets the occur day native time of this symptom.
	 *
	 * @param occurDayNativeTime the occur day native time of this symptom
	 */
	@Override
	public void setOccurDayNativeTime(long occurDayNativeTime) {
		model.setOccurDayNativeTime(occurDayNativeTime);
	}

	/**
	 * Sets the primary key of this symptom.
	 *
	 * @param primaryKey the primary key of this symptom
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the subject ID of this symptom.
	 *
	 * @param subjectId the subject ID of this symptom
	 */
	@Override
	public void setSubjectId(long subjectId) {
		model.setSubjectId(subjectId);
	}

	/**
	 * Sets the symptom ID of this symptom.
	 *
	 * @param symptomId the symptom ID of this symptom
	 */
	@Override
	public void setSymptomId(long symptomId) {
		model.setSymptomId(symptomId);
	}

	/**
	 * Sets the user ID of this symptom.
	 *
	 * @param userId the user ID of this symptom
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this symptom.
	 *
	 * @param userUuid the user uuid of this symptom
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
	protected SymptomWrapper wrap(Symptom symptom) {
		return new SymptomWrapper(symptom);
	}

}