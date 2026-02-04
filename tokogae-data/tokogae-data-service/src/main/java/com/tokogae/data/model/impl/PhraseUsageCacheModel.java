/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.MVCCModel;

import com.tokogae.data.model.PhraseUsage;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PhraseUsage in entity cache.
 *
 * @author Amos Fong
 * @generated
 */
public class PhraseUsageCacheModel
	implements CacheModel<PhraseUsage>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PhraseUsageCacheModel)) {
			return false;
		}

		PhraseUsageCacheModel phraseUsageCacheModel =
			(PhraseUsageCacheModel)object;

		if ((phraseUsageId == phraseUsageCacheModel.phraseUsageId) &&
			(mvccVersion == phraseUsageCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, phraseUsageId);

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
		StringBundler sb = new StringBundler(19);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", phraseUsageId=");
		sb.append(phraseUsageId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", phraseId=");
		sb.append(phraseId);
		sb.append(", classNameId=");
		sb.append(classNameId);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append(", attributesHashCode=");
		sb.append(attributesHashCode);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PhraseUsage toEntityModel() {
		PhraseUsageImpl phraseUsageImpl = new PhraseUsageImpl();

		phraseUsageImpl.setMvccVersion(mvccVersion);
		phraseUsageImpl.setPhraseUsageId(phraseUsageId);
		phraseUsageImpl.setCompanyId(companyId);
		phraseUsageImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			phraseUsageImpl.setCreateDate(null);
		}
		else {
			phraseUsageImpl.setCreateDate(new Date(createDate));
		}

		phraseUsageImpl.setPhraseId(phraseId);
		phraseUsageImpl.setClassNameId(classNameId);
		phraseUsageImpl.setClassPK(classPK);
		phraseUsageImpl.setAttributesHashCode(attributesHashCode);

		phraseUsageImpl.resetOriginalValues();

		return phraseUsageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();

		phraseUsageId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();

		phraseId = objectInput.readLong();

		classNameId = objectInput.readLong();

		classPK = objectInput.readLong();

		attributesHashCode = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		objectOutput.writeLong(phraseUsageId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(phraseId);

		objectOutput.writeLong(classNameId);

		objectOutput.writeLong(classPK);

		objectOutput.writeInt(attributesHashCode);
	}

	public long mvccVersion;
	public long phraseUsageId;
	public long companyId;
	public long userId;
	public long createDate;
	public long phraseId;
	public long classNameId;
	public long classPK;
	public int attributesHashCode;

}