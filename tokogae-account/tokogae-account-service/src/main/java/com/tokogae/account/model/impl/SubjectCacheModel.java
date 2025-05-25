/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.account.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.MVCCModel;

import com.tokogae.account.model.Subject;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Subject in entity cache.
 *
 * @author Amos Fong
 * @generated
 */
public class SubjectCacheModel
	implements CacheModel<Subject>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SubjectCacheModel)) {
			return false;
		}

		SubjectCacheModel subjectCacheModel = (SubjectCacheModel)object;

		if ((subjectId == subjectCacheModel.subjectId) &&
			(mvccVersion == subjectCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, subjectId);

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
		StringBundler sb = new StringBundler(23);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", subjectId=");
		sb.append(subjectId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", displayName=");
		sb.append(displayName);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", birthday=");
		sb.append(birthday);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Subject toEntityModel() {
		SubjectImpl subjectImpl = new SubjectImpl();

		subjectImpl.setMvccVersion(mvccVersion);
		subjectImpl.setSubjectId(subjectId);
		subjectImpl.setCompanyId(companyId);
		subjectImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			subjectImpl.setCreateDate(null);
		}
		else {
			subjectImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			subjectImpl.setModifiedDate(null);
		}
		else {
			subjectImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (firstName == null) {
			subjectImpl.setFirstName("");
		}
		else {
			subjectImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			subjectImpl.setLastName("");
		}
		else {
			subjectImpl.setLastName(lastName);
		}

		if (displayName == null) {
			subjectImpl.setDisplayName("");
		}
		else {
			subjectImpl.setDisplayName(displayName);
		}

		subjectImpl.setGender(gender);

		if (birthday == Long.MIN_VALUE) {
			subjectImpl.setBirthday(null);
		}
		else {
			subjectImpl.setBirthday(new Date(birthday));
		}

		subjectImpl.resetOriginalValues();

		return subjectImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();

		subjectId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		displayName = objectInput.readUTF();

		gender = objectInput.readInt();
		birthday = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		objectOutput.writeLong(subjectId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (firstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (displayName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(displayName);
		}

		objectOutput.writeInt(gender);
		objectOutput.writeLong(birthday);
	}

	public long mvccVersion;
	public long subjectId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String firstName;
	public String lastName;
	public String displayName;
	public int gender;
	public long birthday;

}