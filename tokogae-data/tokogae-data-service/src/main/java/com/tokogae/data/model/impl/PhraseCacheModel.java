/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.MVCCModel;

import com.tokogae.data.model.Phrase;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Phrase in entity cache.
 *
 * @author Amos Fong
 * @generated
 */
public class PhraseCacheModel
	implements CacheModel<Phrase>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PhraseCacheModel)) {
			return false;
		}

		PhraseCacheModel phraseCacheModel = (PhraseCacheModel)object;

		if ((phraseId == phraseCacheModel.phraseId) &&
			(mvccVersion == phraseCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, phraseId);

		return HashUtil.hash(hashCode, mvccVersion);
	}

	@Override
	public long getMvccVersion() {
		return mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", phraseId=");
		sb.append(phraseId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", text=");
		sb.append(text);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Phrase toEntityModel() {
		PhraseImpl phraseImpl = new PhraseImpl();

		phraseImpl.setMvccVersion(mvccVersion);
		phraseImpl.setPhraseId(phraseId);
		phraseImpl.setCompanyId(companyId);

		if (text == null) {
			phraseImpl.setText("");
		}
		else {
			phraseImpl.setText(text);
		}

		phraseImpl.resetOriginalValues();

		return phraseImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();

		phraseId = objectInput.readLong();

		companyId = objectInput.readLong();
		text = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		objectOutput.writeLong(phraseId);

		objectOutput.writeLong(companyId);

		if (text == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(text);
		}
	}

	public long mvccVersion;
	public long phraseId;
	public long companyId;
	public String text;

}