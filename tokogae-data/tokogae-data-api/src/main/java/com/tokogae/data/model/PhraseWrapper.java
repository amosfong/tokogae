/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Phrase}.
 * </p>
 *
 * @author Amos Fong
 * @see Phrase
 * @generated
 */
public class PhraseWrapper
	extends BaseModelWrapper<Phrase> implements ModelWrapper<Phrase>, Phrase {

	public PhraseWrapper(Phrase phrase) {
		super(phrase);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("phraseId", getPhraseId());
		attributes.put("companyId", getCompanyId());
		attributes.put("text", getText());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		Long phraseId = (Long)attributes.get("phraseId");

		if (phraseId != null) {
			setPhraseId(phraseId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String text = (String)attributes.get("text");

		if (text != null) {
			setText(text);
		}
	}

	@Override
	public Phrase cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this phrase.
	 *
	 * @return the company ID of this phrase
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the mvcc version of this phrase.
	 *
	 * @return the mvcc version of this phrase
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the phrase ID of this phrase.
	 *
	 * @return the phrase ID of this phrase
	 */
	@Override
	public long getPhraseId() {
		return model.getPhraseId();
	}

	/**
	 * Returns the primary key of this phrase.
	 *
	 * @return the primary key of this phrase
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the text of this phrase.
	 *
	 * @return the text of this phrase
	 */
	@Override
	public String getText() {
		return model.getText();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this phrase.
	 *
	 * @param companyId the company ID of this phrase
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the mvcc version of this phrase.
	 *
	 * @param mvccVersion the mvcc version of this phrase
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the phrase ID of this phrase.
	 *
	 * @param phraseId the phrase ID of this phrase
	 */
	@Override
	public void setPhraseId(long phraseId) {
		model.setPhraseId(phraseId);
	}

	/**
	 * Sets the primary key of this phrase.
	 *
	 * @param primaryKey the primary key of this phrase
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the text of this phrase.
	 *
	 * @param text the text of this phrase
	 */
	@Override
	public void setText(String text) {
		model.setText(text);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected PhraseWrapper wrap(Phrase phrase) {
		return new PhraseWrapper(phrase);
	}

}