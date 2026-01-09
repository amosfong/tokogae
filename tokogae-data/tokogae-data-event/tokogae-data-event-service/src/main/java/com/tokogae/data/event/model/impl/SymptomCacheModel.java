/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.MVCCModel;

import com.tokogae.data.event.model.Symptom;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Symptom in entity cache.
 *
 * @author Amos Fong
 * @generated
 */
public class SymptomCacheModel
	implements CacheModel<Symptom>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SymptomCacheModel)) {
			return false;
		}

		SymptomCacheModel symptomCacheModel = (SymptomCacheModel)object;

		if ((symptomId == symptomCacheModel.symptomId) &&
			(mvccVersion == symptomCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, symptomId);

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
		StringBundler sb = new StringBundler(25);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", symptomId=");
		sb.append(symptomId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", subjectId=");
		sb.append(subjectId);
		sb.append(", occurDayBaseTime=");
		sb.append(occurDayBaseTime);
		sb.append(", occurDayNativeTime=");
		sb.append(occurDayNativeTime);
		sb.append(", duration=");
		sb.append(duration);
		sb.append(", name=");
		sb.append(name);
		sb.append(", affectedArea=");
		sb.append(affectedArea);
		sb.append(", intensityLevel=");
		sb.append(intensityLevel);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Symptom toEntityModel() {
		SymptomImpl symptomImpl = new SymptomImpl();

		symptomImpl.setMvccVersion(mvccVersion);
		symptomImpl.setSymptomId(symptomId);
		symptomImpl.setCompanyId(companyId);
		symptomImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			symptomImpl.setCreateDate(null);
		}
		else {
			symptomImpl.setCreateDate(new Date(createDate));
		}

		symptomImpl.setSubjectId(subjectId);
		symptomImpl.setOccurDayBaseTime(occurDayBaseTime);
		symptomImpl.setOccurDayNativeTime(occurDayNativeTime);
		symptomImpl.setDuration(duration);

		if (name == null) {
			symptomImpl.setName("");
		}
		else {
			symptomImpl.setName(name);
		}

		if (affectedArea == null) {
			symptomImpl.setAffectedArea("");
		}
		else {
			symptomImpl.setAffectedArea(affectedArea);
		}

		symptomImpl.setIntensityLevel(intensityLevel);

		symptomImpl.resetOriginalValues();

		return symptomImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();

		symptomId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();

		subjectId = objectInput.readLong();

		occurDayBaseTime = objectInput.readLong();

		occurDayNativeTime = objectInput.readLong();

		duration = objectInput.readLong();
		name = objectInput.readUTF();
		affectedArea = objectInput.readUTF();

		intensityLevel = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		objectOutput.writeLong(symptomId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(subjectId);

		objectOutput.writeLong(occurDayBaseTime);

		objectOutput.writeLong(occurDayNativeTime);

		objectOutput.writeLong(duration);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (affectedArea == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(affectedArea);
		}

		objectOutput.writeInt(intensityLevel);
	}

	public long mvccVersion;
	public long symptomId;
	public long companyId;
	public long userId;
	public long createDate;
	public long subjectId;
	public long occurDayBaseTime;
	public long occurDayNativeTime;
	public long duration;
	public String name;
	public String affectedArea;
	public int intensityLevel;

}