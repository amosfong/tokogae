/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.MVCCModel;

import com.tokogae.data.event.model.Exercise;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Exercise in entity cache.
 *
 * @author Amos Fong
 * @generated
 */
public class ExerciseCacheModel
	implements CacheModel<Exercise>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ExerciseCacheModel)) {
			return false;
		}

		ExerciseCacheModel exerciseCacheModel = (ExerciseCacheModel)object;

		if ((exerciseId == exerciseCacheModel.exerciseId) &&
			(mvccVersion == exerciseCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, exerciseId);

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
		StringBundler sb = new StringBundler(27);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", exerciseId=");
		sb.append(exerciseId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", occurDay=");
		sb.append(occurDay);
		sb.append(", occurDaySegment=");
		sb.append(occurDaySegment);
		sb.append(", occurTime=");
		sb.append(occurTime);
		sb.append(", name=");
		sb.append(name);
		sb.append(", type=");
		sb.append(type);
		sb.append(", duration=");
		sb.append(duration);
		sb.append(", intensityLevel=");
		sb.append(intensityLevel);
		sb.append(", quantity=");
		sb.append(quantity);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Exercise toEntityModel() {
		ExerciseImpl exerciseImpl = new ExerciseImpl();

		exerciseImpl.setMvccVersion(mvccVersion);
		exerciseImpl.setExerciseId(exerciseId);
		exerciseImpl.setCompanyId(companyId);
		exerciseImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			exerciseImpl.setCreateDate(null);
		}
		else {
			exerciseImpl.setCreateDate(new Date(createDate));
		}

		exerciseImpl.setOccurDay(occurDay);
		exerciseImpl.setOccurDaySegment(occurDaySegment);
		exerciseImpl.setOccurTime(occurTime);

		if (name == null) {
			exerciseImpl.setName("");
		}
		else {
			exerciseImpl.setName(name);
		}

		exerciseImpl.setType(type);
		exerciseImpl.setDuration(duration);
		exerciseImpl.setIntensityLevel(intensityLevel);
		exerciseImpl.setQuantity(quantity);

		exerciseImpl.resetOriginalValues();

		return exerciseImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();

		exerciseId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();

		occurDay = objectInput.readLong();

		occurDaySegment = objectInput.readInt();

		occurTime = objectInput.readLong();
		name = objectInput.readUTF();

		type = objectInput.readInt();

		duration = objectInput.readInt();

		intensityLevel = objectInput.readInt();

		quantity = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		objectOutput.writeLong(exerciseId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(occurDay);

		objectOutput.writeInt(occurDaySegment);

		objectOutput.writeLong(occurTime);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeInt(type);

		objectOutput.writeInt(duration);

		objectOutput.writeInt(intensityLevel);

		objectOutput.writeInt(quantity);
	}

	public long mvccVersion;
	public long exerciseId;
	public long companyId;
	public long userId;
	public long createDate;
	public long occurDay;
	public int occurDaySegment;
	public long occurTime;
	public String name;
	public int type;
	public int duration;
	public int intensityLevel;
	public int quantity;

}