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
 * This class is a wrapper for {@link Sleep}.
 * </p>
 *
 * @author Amos Fong
 * @see Sleep
 * @generated
 */
public class SleepWrapper
	extends BaseModelWrapper<Sleep> implements ModelWrapper<Sleep>, Sleep {

	public SleepWrapper(Sleep sleep) {
		super(sleep);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("sleepId", getSleepId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("subjectId", getSubjectId());
		attributes.put("occurDay", getOccurDay());
		attributes.put("occurDaySegment", getOccurDaySegment());
		attributes.put("occurTime", getOccurTime());
		attributes.put("duration", getDuration());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		Long sleepId = (Long)attributes.get("sleepId");

		if (sleepId != null) {
			setSleepId(sleepId);
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

		Long duration = (Long)attributes.get("duration");

		if (duration != null) {
			setDuration(duration);
		}
	}

	@Override
	public Sleep cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this sleep.
	 *
	 * @return the company ID of this sleep
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this sleep.
	 *
	 * @return the create date of this sleep
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the duration of this sleep.
	 *
	 * @return the duration of this sleep
	 */
	@Override
	public long getDuration() {
		return model.getDuration();
	}

	/**
	 * Returns the mvcc version of this sleep.
	 *
	 * @return the mvcc version of this sleep
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the occur day of this sleep.
	 *
	 * @return the occur day of this sleep
	 */
	@Override
	public long getOccurDay() {
		return model.getOccurDay();
	}

	/**
	 * Returns the occur day segment of this sleep.
	 *
	 * @return the occur day segment of this sleep
	 */
	@Override
	public int getOccurDaySegment() {
		return model.getOccurDaySegment();
	}

	/**
	 * Returns the occur time of this sleep.
	 *
	 * @return the occur time of this sleep
	 */
	@Override
	public long getOccurTime() {
		return model.getOccurTime();
	}

	/**
	 * Returns the primary key of this sleep.
	 *
	 * @return the primary key of this sleep
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sleep ID of this sleep.
	 *
	 * @return the sleep ID of this sleep
	 */
	@Override
	public long getSleepId() {
		return model.getSleepId();
	}

	/**
	 * Returns the subject ID of this sleep.
	 *
	 * @return the subject ID of this sleep
	 */
	@Override
	public long getSubjectId() {
		return model.getSubjectId();
	}

	/**
	 * Returns the user ID of this sleep.
	 *
	 * @return the user ID of this sleep
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this sleep.
	 *
	 * @return the user uuid of this sleep
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
	 * Sets the company ID of this sleep.
	 *
	 * @param companyId the company ID of this sleep
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this sleep.
	 *
	 * @param createDate the create date of this sleep
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the duration of this sleep.
	 *
	 * @param duration the duration of this sleep
	 */
	@Override
	public void setDuration(long duration) {
		model.setDuration(duration);
	}

	/**
	 * Sets the mvcc version of this sleep.
	 *
	 * @param mvccVersion the mvcc version of this sleep
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the occur day of this sleep.
	 *
	 * @param occurDay the occur day of this sleep
	 */
	@Override
	public void setOccurDay(long occurDay) {
		model.setOccurDay(occurDay);
	}

	/**
	 * Sets the occur day segment of this sleep.
	 *
	 * @param occurDaySegment the occur day segment of this sleep
	 */
	@Override
	public void setOccurDaySegment(int occurDaySegment) {
		model.setOccurDaySegment(occurDaySegment);
	}

	/**
	 * Sets the occur time of this sleep.
	 *
	 * @param occurTime the occur time of this sleep
	 */
	@Override
	public void setOccurTime(long occurTime) {
		model.setOccurTime(occurTime);
	}

	/**
	 * Sets the primary key of this sleep.
	 *
	 * @param primaryKey the primary key of this sleep
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sleep ID of this sleep.
	 *
	 * @param sleepId the sleep ID of this sleep
	 */
	@Override
	public void setSleepId(long sleepId) {
		model.setSleepId(sleepId);
	}

	/**
	 * Sets the subject ID of this sleep.
	 *
	 * @param subjectId the subject ID of this sleep
	 */
	@Override
	public void setSubjectId(long subjectId) {
		model.setSubjectId(subjectId);
	}

	/**
	 * Sets the user ID of this sleep.
	 *
	 * @param userId the user ID of this sleep
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this sleep.
	 *
	 * @param userUuid the user uuid of this sleep
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
	protected SleepWrapper wrap(Sleep sleep) {
		return new SleepWrapper(sleep);
	}

}