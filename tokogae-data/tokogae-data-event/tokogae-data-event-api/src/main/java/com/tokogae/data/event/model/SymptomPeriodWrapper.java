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
 * This class is a wrapper for {@link SymptomPeriod}.
 * </p>
 *
 * @author Amos Fong
 * @see SymptomPeriod
 * @generated
 */
public class SymptomPeriodWrapper
	extends BaseModelWrapper<SymptomPeriod>
	implements ModelWrapper<SymptomPeriod>, SymptomPeriod {

	public SymptomPeriodWrapper(SymptomPeriod symptomPeriod) {
		super(symptomPeriod);
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
		attributes.put("name", getName());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());

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
	}

	@Override
	public SymptomPeriod cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this symptom period.
	 *
	 * @return the company ID of this symptom period
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this symptom period.
	 *
	 * @return the create date of this symptom period
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the end date of this symptom period.
	 *
	 * @return the end date of this symptom period
	 */
	@Override
	public Date getEndDate() {
		return model.getEndDate();
	}

	/**
	 * Returns the mvcc version of this symptom period.
	 *
	 * @return the mvcc version of this symptom period
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the name of this symptom period.
	 *
	 * @return the name of this symptom period
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this symptom period.
	 *
	 * @return the primary key of this symptom period
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the start date of this symptom period.
	 *
	 * @return the start date of this symptom period
	 */
	@Override
	public Date getStartDate() {
		return model.getStartDate();
	}

	/**
	 * Returns the subject ID of this symptom period.
	 *
	 * @return the subject ID of this symptom period
	 */
	@Override
	public long getSubjectId() {
		return model.getSubjectId();
	}

	/**
	 * Returns the symptom ID of this symptom period.
	 *
	 * @return the symptom ID of this symptom period
	 */
	@Override
	public long getSymptomId() {
		return model.getSymptomId();
	}

	/**
	 * Returns the user ID of this symptom period.
	 *
	 * @return the user ID of this symptom period
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this symptom period.
	 *
	 * @return the user uuid of this symptom period
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
	 * Sets the company ID of this symptom period.
	 *
	 * @param companyId the company ID of this symptom period
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this symptom period.
	 *
	 * @param createDate the create date of this symptom period
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the end date of this symptom period.
	 *
	 * @param endDate the end date of this symptom period
	 */
	@Override
	public void setEndDate(Date endDate) {
		model.setEndDate(endDate);
	}

	/**
	 * Sets the mvcc version of this symptom period.
	 *
	 * @param mvccVersion the mvcc version of this symptom period
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the name of this symptom period.
	 *
	 * @param name the name of this symptom period
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this symptom period.
	 *
	 * @param primaryKey the primary key of this symptom period
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the start date of this symptom period.
	 *
	 * @param startDate the start date of this symptom period
	 */
	@Override
	public void setStartDate(Date startDate) {
		model.setStartDate(startDate);
	}

	/**
	 * Sets the subject ID of this symptom period.
	 *
	 * @param subjectId the subject ID of this symptom period
	 */
	@Override
	public void setSubjectId(long subjectId) {
		model.setSubjectId(subjectId);
	}

	/**
	 * Sets the symptom ID of this symptom period.
	 *
	 * @param symptomId the symptom ID of this symptom period
	 */
	@Override
	public void setSymptomId(long symptomId) {
		model.setSymptomId(symptomId);
	}

	/**
	 * Sets the user ID of this symptom period.
	 *
	 * @param userId the user ID of this symptom period
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this symptom period.
	 *
	 * @param userUuid the user uuid of this symptom period
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
	protected SymptomPeriodWrapper wrap(SymptomPeriod symptomPeriod) {
		return new SymptomPeriodWrapper(symptomPeriod);
	}

}