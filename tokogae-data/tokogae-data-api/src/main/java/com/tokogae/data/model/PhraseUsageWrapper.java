/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PhraseUsage}.
 * </p>
 *
 * @author Amos Fong
 * @see PhraseUsage
 * @generated
 */
public class PhraseUsageWrapper
	extends BaseModelWrapper<PhraseUsage>
	implements ModelWrapper<PhraseUsage>, PhraseUsage {

	public PhraseUsageWrapper(PhraseUsage phraseUsage) {
		super(phraseUsage);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("phraseUsageId", getPhraseUsageId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("phraseId", getPhraseId());
		attributes.put("classNameId", getClassNameId());
		attributes.put("classPK", getClassPK());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		Long phraseUsageId = (Long)attributes.get("phraseUsageId");

		if (phraseUsageId != null) {
			setPhraseUsageId(phraseUsageId);
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

		Long phraseId = (Long)attributes.get("phraseId");

		if (phraseId != null) {
			setPhraseId(phraseId);
		}

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}
	}

	@Override
	public PhraseUsage cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the fully qualified class name of this phrase usage.
	 *
	 * @return the fully qualified class name of this phrase usage
	 */
	@Override
	public String getClassName() {
		return model.getClassName();
	}

	/**
	 * Returns the class name ID of this phrase usage.
	 *
	 * @return the class name ID of this phrase usage
	 */
	@Override
	public long getClassNameId() {
		return model.getClassNameId();
	}

	/**
	 * Returns the class pk of this phrase usage.
	 *
	 * @return the class pk of this phrase usage
	 */
	@Override
	public long getClassPK() {
		return model.getClassPK();
	}

	/**
	 * Returns the company ID of this phrase usage.
	 *
	 * @return the company ID of this phrase usage
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this phrase usage.
	 *
	 * @return the create date of this phrase usage
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the mvcc version of this phrase usage.
	 *
	 * @return the mvcc version of this phrase usage
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the phrase ID of this phrase usage.
	 *
	 * @return the phrase ID of this phrase usage
	 */
	@Override
	public long getPhraseId() {
		return model.getPhraseId();
	}

	/**
	 * Returns the phrase usage ID of this phrase usage.
	 *
	 * @return the phrase usage ID of this phrase usage
	 */
	@Override
	public long getPhraseUsageId() {
		return model.getPhraseUsageId();
	}

	/**
	 * Returns the primary key of this phrase usage.
	 *
	 * @return the primary key of this phrase usage
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this phrase usage.
	 *
	 * @return the user ID of this phrase usage
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this phrase usage.
	 *
	 * @return the user uuid of this phrase usage
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	@Override
	public void setClassName(String className) {
		model.setClassName(className);
	}

	/**
	 * Sets the class name ID of this phrase usage.
	 *
	 * @param classNameId the class name ID of this phrase usage
	 */
	@Override
	public void setClassNameId(long classNameId) {
		model.setClassNameId(classNameId);
	}

	/**
	 * Sets the class pk of this phrase usage.
	 *
	 * @param classPK the class pk of this phrase usage
	 */
	@Override
	public void setClassPK(long classPK) {
		model.setClassPK(classPK);
	}

	/**
	 * Sets the company ID of this phrase usage.
	 *
	 * @param companyId the company ID of this phrase usage
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this phrase usage.
	 *
	 * @param createDate the create date of this phrase usage
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the mvcc version of this phrase usage.
	 *
	 * @param mvccVersion the mvcc version of this phrase usage
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the phrase ID of this phrase usage.
	 *
	 * @param phraseId the phrase ID of this phrase usage
	 */
	@Override
	public void setPhraseId(long phraseId) {
		model.setPhraseId(phraseId);
	}

	/**
	 * Sets the phrase usage ID of this phrase usage.
	 *
	 * @param phraseUsageId the phrase usage ID of this phrase usage
	 */
	@Override
	public void setPhraseUsageId(long phraseUsageId) {
		model.setPhraseUsageId(phraseUsageId);
	}

	/**
	 * Sets the primary key of this phrase usage.
	 *
	 * @param primaryKey the primary key of this phrase usage
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this phrase usage.
	 *
	 * @param userId the user ID of this phrase usage
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this phrase usage.
	 *
	 * @param userUuid the user uuid of this phrase usage
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
	protected PhraseUsageWrapper wrap(PhraseUsage phraseUsage) {
		return new PhraseUsageWrapper(phraseUsage);
	}

}