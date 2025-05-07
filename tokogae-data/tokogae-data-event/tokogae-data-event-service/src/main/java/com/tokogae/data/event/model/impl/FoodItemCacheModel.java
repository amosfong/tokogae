/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.MVCCModel;

import com.tokogae.data.event.model.FoodItem;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FoodItem in entity cache.
 *
 * @author Amos Fong
 * @generated
 */
public class FoodItemCacheModel
	implements CacheModel<FoodItem>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FoodItemCacheModel)) {
			return false;
		}

		FoodItemCacheModel foodItemCacheModel = (FoodItemCacheModel)object;

		if ((foodItemId == foodItemCacheModel.foodItemId) &&
			(mvccVersion == foodItemCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, foodItemId);

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
		sb.append(", foodItemId=");
		sb.append(foodItemId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", locationOfOrigin=");
		sb.append(locationOfOrigin);
		sb.append(", brand=");
		sb.append(brand);
		sb.append(", quantity=");
		sb.append(quantity);
		sb.append(", quantityUnit=");
		sb.append(quantityUnit);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FoodItem toEntityModel() {
		FoodItemImpl foodItemImpl = new FoodItemImpl();

		foodItemImpl.setMvccVersion(mvccVersion);
		foodItemImpl.setFoodItemId(foodItemId);
		foodItemImpl.setCompanyId(companyId);
		foodItemImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			foodItemImpl.setCreateDate(null);
		}
		else {
			foodItemImpl.setCreateDate(new Date(createDate));
		}

		if (name == null) {
			foodItemImpl.setName("");
		}
		else {
			foodItemImpl.setName(name);
		}

		if (locationOfOrigin == null) {
			foodItemImpl.setLocationOfOrigin("");
		}
		else {
			foodItemImpl.setLocationOfOrigin(locationOfOrigin);
		}

		if (brand == null) {
			foodItemImpl.setBrand("");
		}
		else {
			foodItemImpl.setBrand(brand);
		}

		foodItemImpl.setQuantity(quantity);

		if (quantityUnit == null) {
			foodItemImpl.setQuantityUnit("");
		}
		else {
			foodItemImpl.setQuantityUnit(quantityUnit);
		}

		foodItemImpl.resetOriginalValues();

		return foodItemImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();

		foodItemId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		name = objectInput.readUTF();
		locationOfOrigin = objectInput.readUTF();
		brand = objectInput.readUTF();

		quantity = objectInput.readLong();
		quantityUnit = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		objectOutput.writeLong(foodItemId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (locationOfOrigin == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(locationOfOrigin);
		}

		if (brand == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(brand);
		}

		objectOutput.writeLong(quantity);

		if (quantityUnit == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(quantityUnit);
		}
	}

	public long mvccVersion;
	public long foodItemId;
	public long companyId;
	public long userId;
	public long createDate;
	public String name;
	public String locationOfOrigin;
	public String brand;
	public long quantity;
	public String quantityUnit;

}