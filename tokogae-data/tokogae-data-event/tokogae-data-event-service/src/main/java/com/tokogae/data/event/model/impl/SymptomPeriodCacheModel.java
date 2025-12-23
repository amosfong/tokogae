/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.MVCCModel;

import com.tokogae.data.event.model.SymptomPeriod;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SymptomPeriod in entity cache.
 *
 * @author Amos Fong
 * @generated
 */
public class SymptomPeriodCacheModel
	implements CacheModel<SymptomPeriod>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SymptomPeriodCacheModel)) {
			return false;
		}

		SymptomPeriodCacheModel symptomPeriodCacheModel =
			(SymptomPeriodCacheModel)object;

		if ((symptomId == symptomPeriodCacheModel.symptomId) &&
			(mvccVersion == symptomPeriodCacheModel.mvccVersion)) {

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
		StringBundler sb = new StringBundler(19);

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
		sb.append(", name=");
		sb.append(name);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SymptomPeriod toEntityModel() {
		SymptomPeriodImpl symptomPeriodImpl = new SymptomPeriodImpl();

		symptomPeriodImpl.setMvccVersion(mvccVersion);
		symptomPeriodImpl.setSymptomId(symptomId);
		symptomPeriodImpl.setCompanyId(companyId);
		symptomPeriodImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			symptomPeriodImpl.setCreateDate(null);
		}
		else {
			symptomPeriodImpl.setCreateDate(new Date(createDate));
		}

		symptomPeriodImpl.setSubjectId(subjectId);

		if (name == null) {
			symptomPeriodImpl.setName("");
		}
		else {
			symptomPeriodImpl.setName(name);
		}

		if (startDate == Long.MIN_VALUE) {
			symptomPeriodImpl.setStartDate(null);
		}
		else {
			symptomPeriodImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			symptomPeriodImpl.setEndDate(null);
		}
		else {
			symptomPeriodImpl.setEndDate(new Date(endDate));
		}

		symptomPeriodImpl.resetOriginalValues();

		return symptomPeriodImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();

		symptomId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();

		subjectId = objectInput.readLong();
		name = objectInput.readUTF();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		objectOutput.writeLong(symptomId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(subjectId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);
	}

	public long mvccVersion;
	public long symptomId;
	public long companyId;
	public long userId;
	public long createDate;
	public long subjectId;
	public String name;
	public long startDate;
	public long endDate;

}