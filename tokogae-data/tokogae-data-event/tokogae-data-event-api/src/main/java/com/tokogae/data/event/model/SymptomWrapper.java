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
		attributes.put("occurDay", getOccurDay());
		attributes.put("occurDaySegment", getOccurDaySegment());
		attributes.put("occurTime", getOccurTime());
		attributes.put("name", getName());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
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

		Long occurDay = (Long)attributes.get("occurDay");

		if (occurDay != null) {
			setOccurDay(occurDay);
		}

		Integer occurDaySegment = (Integer)attributes.get("occurDaySegment");

		if (occurDaySegment != null) {
			setOccurDaySegment(occurDaySegment);
		}

		Long occurTime = (Long)attributes.get("occurTime");

		if (occurTime != null) {
			setOccurTime(occurTime);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
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
	 * Returns the end date of this symptom.
	 *
	 * @return the end date of this symptom
	 */
	@Override
	public Date getEndDate() {
		return model.getEndDate();
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
	 * Returns the occur day of this symptom.
	 *
	 * @return the occur day of this symptom
	 */
	@Override
	public long getOccurDay() {
		return model.getOccurDay();
	}

	/**
	 * Returns the occur day segment of this symptom.
	 *
	 * @return the occur day segment of this symptom
	 */
	@Override
	public int getOccurDaySegment() {
		return model.getOccurDaySegment();
	}

	/**
	 * Returns the occur time of this symptom.
	 *
	 * @return the occur time of this symptom
	 */
	@Override
	public long getOccurTime() {
		return model.getOccurTime();
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
	 * Returns the start date of this symptom.
	 *
	 * @return the start date of this symptom
	 */
	@Override
	public Date getStartDate() {
		return model.getStartDate();
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
	 * Sets the end date of this symptom.
	 *
	 * @param endDate the end date of this symptom
	 */
	@Override
	public void setEndDate(Date endDate) {
		model.setEndDate(endDate);
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
	 * Sets the occur day of this symptom.
	 *
	 * @param occurDay the occur day of this symptom
	 */
	@Override
	public void setOccurDay(long occurDay) {
		model.setOccurDay(occurDay);
	}

	/**
	 * Sets the occur day segment of this symptom.
	 *
	 * @param occurDaySegment the occur day segment of this symptom
	 */
	@Override
	public void setOccurDaySegment(int occurDaySegment) {
		model.setOccurDaySegment(occurDaySegment);
	}

	/**
	 * Sets the occur time of this symptom.
	 *
	 * @param occurTime the occur time of this symptom
	 */
	@Override
	public void setOccurTime(long occurTime) {
		model.setOccurTime(occurTime);
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
	 * Sets the start date of this symptom.
	 *
	 * @param startDate the start date of this symptom
	 */
	@Override
	public void setStartDate(Date startDate) {
		model.setStartDate(startDate);
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