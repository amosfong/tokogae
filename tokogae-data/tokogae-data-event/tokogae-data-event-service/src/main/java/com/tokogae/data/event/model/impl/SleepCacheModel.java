/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.MVCCModel;

import com.tokogae.data.event.model.Sleep;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Sleep in entity cache.
 *
 * @author Amos Fong
 * @generated
 */
public class SleepCacheModel
	implements CacheModel<Sleep>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SleepCacheModel)) {
			return false;
		}

		SleepCacheModel sleepCacheModel = (SleepCacheModel)object;

		if ((sleepId == sleepCacheModel.sleepId) &&
			(mvccVersion == sleepCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, sleepId);

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
		StringBundler sb = new StringBundler(21);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", sleepId=");
		sb.append(sleepId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", subjectId=");
		sb.append(subjectId);
		sb.append(", occurDay=");
		sb.append(occurDay);
		sb.append(", occurDaySegment=");
		sb.append(occurDaySegment);
		sb.append(", occurTime=");
		sb.append(occurTime);
		sb.append(", duration=");
		sb.append(duration);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Sleep toEntityModel() {
		SleepImpl sleepImpl = new SleepImpl();

		sleepImpl.setMvccVersion(mvccVersion);
		sleepImpl.setSleepId(sleepId);
		sleepImpl.setCompanyId(companyId);
		sleepImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			sleepImpl.setCreateDate(null);
		}
		else {
			sleepImpl.setCreateDate(new Date(createDate));
		}

		sleepImpl.setSubjectId(subjectId);
		sleepImpl.setOccurDay(occurDay);
		sleepImpl.setOccurDaySegment(occurDaySegment);
		sleepImpl.setOccurTime(occurTime);
		sleepImpl.setDuration(duration);

		sleepImpl.resetOriginalValues();

		return sleepImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();

		sleepId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();

		subjectId = objectInput.readLong();

		occurDay = objectInput.readLong();

		occurDaySegment = objectInput.readInt();

		occurTime = objectInput.readLong();

		duration = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		objectOutput.writeLong(sleepId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(subjectId);

		objectOutput.writeLong(occurDay);

		objectOutput.writeInt(occurDaySegment);

		objectOutput.writeLong(occurTime);

		objectOutput.writeLong(duration);
	}

	public long mvccVersion;
	public long sleepId;
	public long companyId;
	public long userId;
	public long createDate;
	public long subjectId;
	public long occurDay;
	public int occurDaySegment;
	public long occurTime;
	public long duration;

}