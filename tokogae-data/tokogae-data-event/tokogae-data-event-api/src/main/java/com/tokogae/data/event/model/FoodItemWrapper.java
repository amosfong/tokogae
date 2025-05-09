/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link FoodItem}.
 * </p>
 *
 * @author Amos Fong
 * @see FoodItem
 * @generated
 */
public class FoodItemWrapper
	extends BaseModelWrapper<FoodItem>
	implements FoodItem, ModelWrapper<FoodItem> {

	public FoodItemWrapper(FoodItem foodItem) {
		super(foodItem);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("foodItemId", getFoodItemId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("occurDay", getOccurDay());
		attributes.put("occurDaySegment", getOccurDaySegment());
		attributes.put("occurTime", getOccurTime());
		attributes.put("name", getName());
		attributes.put("locationOfOrigin", getLocationOfOrigin());
		attributes.put("brand", getBrand());
		attributes.put("quantity", getQuantity());
		attributes.put("quantityUnit", getQuantityUnit());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		Long foodItemId = (Long)attributes.get("foodItemId");

		if (foodItemId != null) {
			setFoodItemId(foodItemId);
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

		Long occurDay = (Long)attributes.get("occurDay");

		if (occurDay != null) {
			setOccurDay(occurDay);
		}

		Integer occurDaySegment = (Integer)attributes.get("occurDaySegment");

		if (occurDaySegment != null) {
			setOccurDaySegment(occurDaySegment);
		}

		Long occurTime = (Long)attributes.get("occurTime");

		if (occurTime != null) {
			setOccurTime(occurTime);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String locationOfOrigin = (String)attributes.get("locationOfOrigin");

		if (locationOfOrigin != null) {
			setLocationOfOrigin(locationOfOrigin);
		}

		String brand = (String)attributes.get("brand");

		if (brand != null) {
			setBrand(brand);
		}

		Long quantity = (Long)attributes.get("quantity");

		if (quantity != null) {
			setQuantity(quantity);
		}

		String quantityUnit = (String)attributes.get("quantityUnit");

		if (quantityUnit != null) {
			setQuantityUnit(quantityUnit);
		}
	}

	@Override
	public FoodItem cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the brand of this food item.
	 *
	 * @return the brand of this food item
	 */
	@Override
	public String getBrand() {
		return model.getBrand();
	}

	/**
	 * Returns the company ID of this food item.
	 *
	 * @return the company ID of this food item
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this food item.
	 *
	 * @return the create date of this food item
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the food item ID of this food item.
	 *
	 * @return the food item ID of this food item
	 */
	@Override
	public long getFoodItemId() {
		return model.getFoodItemId();
	}

	/**
	 * Returns the location of origin of this food item.
	 *
	 * @return the location of origin of this food item
	 */
	@Override
	public String getLocationOfOrigin() {
		return model.getLocationOfOrigin();
	}

	/**
	 * Returns the mvcc version of this food item.
	 *
	 * @return the mvcc version of this food item
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the name of this food item.
	 *
	 * @return the name of this food item
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the occur day of this food item.
	 *
	 * @return the occur day of this food item
	 */
	@Override
	public long getOccurDay() {
		return model.getOccurDay();
	}

	/**
	 * Returns the occur day segment of this food item.
	 *
	 * @return the occur day segment of this food item
	 */
	@Override
	public int getOccurDaySegment() {
		return model.getOccurDaySegment();
	}

	/**
	 * Returns the occur time of this food item.
	 *
	 * @return the occur time of this food item
	 */
	@Override
	public long getOccurTime() {
		return model.getOccurTime();
	}

	/**
	 * Returns the primary key of this food item.
	 *
	 * @return the primary key of this food item
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the quantity of this food item.
	 *
	 * @return the quantity of this food item
	 */
	@Override
	public long getQuantity() {
		return model.getQuantity();
	}

	/**
	 * Returns the quantity unit of this food item.
	 *
	 * @return the quantity unit of this food item
	 */
	@Override
	public String getQuantityUnit() {
		return model.getQuantityUnit();
	}

	/**
	 * Returns the user ID of this food item.
	 *
	 * @return the user ID of this food item
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this food item.
	 *
	 * @return the user uuid of this food item
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the brand of this food item.
	 *
	 * @param brand the brand of this food item
	 */
	@Override
	public void setBrand(String brand) {
		model.setBrand(brand);
	}

	/**
	 * Sets the company ID of this food item.
	 *
	 * @param companyId the company ID of this food item
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this food item.
	 *
	 * @param createDate the create date of this food item
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the food item ID of this food item.
	 *
	 * @param foodItemId the food item ID of this food item
	 */
	@Override
	public void setFoodItemId(long foodItemId) {
		model.setFoodItemId(foodItemId);
	}

	/**
	 * Sets the location of origin of this food item.
	 *
	 * @param locationOfOrigin the location of origin of this food item
	 */
	@Override
	public void setLocationOfOrigin(String locationOfOrigin) {
		model.setLocationOfOrigin(locationOfOrigin);
	}

	/**
	 * Sets the mvcc version of this food item.
	 *
	 * @param mvccVersion the mvcc version of this food item
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the name of this food item.
	 *
	 * @param name the name of this food item
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the occur day of this food item.
	 *
	 * @param occurDay the occur day of this food item
	 */
	@Override
	public void setOccurDay(long occurDay) {
		model.setOccurDay(occurDay);
	}

	/**
	 * Sets the occur day segment of this food item.
	 *
	 * @param occurDaySegment the occur day segment of this food item
	 */
	@Override
	public void setOccurDaySegment(int occurDaySegment) {
		model.setOccurDaySegment(occurDaySegment);
	}

	/**
	 * Sets the occur time of this food item.
	 *
	 * @param occurTime the occur time of this food item
	 */
	@Override
	public void setOccurTime(long occurTime) {
		model.setOccurTime(occurTime);
	}

	/**
	 * Sets the primary key of this food item.
	 *
	 * @param primaryKey the primary key of this food item
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the quantity of this food item.
	 *
	 * @param quantity the quantity of this food item
	 */
	@Override
	public void setQuantity(long quantity) {
		model.setQuantity(quantity);
	}

	/**
	 * Sets the quantity unit of this food item.
	 *
	 * @param quantityUnit the quantity unit of this food item
	 */
	@Override
	public void setQuantityUnit(String quantityUnit) {
		model.setQuantityUnit(quantityUnit);
	}

	/**
	 * Sets the user ID of this food item.
	 *
	 * @param userId the user ID of this food item
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this food item.
	 *
	 * @param userUuid the user uuid of this food item
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
	protected FoodItemWrapper wrap(FoodItem foodItem) {
		return new FoodItemWrapper(foodItem);
	}

}