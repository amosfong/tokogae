/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.model.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringUtil;

import com.tokogae.data.event.model.DataEvent;
import com.tokogae.data.event.model.Exercise;
import com.tokogae.data.event.model.FoodItem;
import com.tokogae.data.event.model.Symptom;

import java.util.Date;

/**
 * @author Amos Fong
 */
public class DataEventImpl implements DataEvent {

	public DataEventImpl() {
	}

	public String getClassName() {
		return _className;
	}

	public long getClassPK() {
		return _classPK;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public Date getOccurDate() {
		return _occurDate;
	}

	public String getPrimaryKey() {
		return _className + StringPool.POUND + _classPK;
	}

	public long getSubjectId() {
		return _subjectId;
	}

	public String getSummary() {
		if (_className.equals(Exercise.class.getName())) {
			Exercise exercise = (Exercise)_originalObject;

			StringBundler sb = new StringBundler();

			sb.append(exercise.getQuantityLabel());
			sb.append(StringPool.SPACE);
			sb.append(exercise.getQuantityUnit());
			sb.append(StringPool.SPACE);
			sb.append(exercise.getName());

			return sb.toString();
		}
		else if (_className.equals(FoodItem.class.getName())) {
			FoodItem foodItem = (FoodItem)_originalObject;

			StringBundler sb = new StringBundler();

			sb.append(foodItem.getQuantityLabel());
			sb.append(StringPool.SPACE);
			sb.append(foodItem.getQuantityUnit());
			sb.append(StringPool.SPACE);
			sb.append(foodItem.getName());

			return sb.toString();
		}
		else if (_className.equals(Symptom.class.getName())) {
			Symptom symptom = (Symptom)_originalObject;

			StringBundler sb = new StringBundler();

			sb.append(symptom.getIntensityLevelLabel());
			sb.append(StringPool.SPACE);
			sb.append(symptom.getName());
			sb.append(StringPool.SPACE);
			sb.append(" on ");
			sb.append(StringPool.SPACE);
			sb.append(symptom.getAffectedArea());

			return sb.toString();
		}

		return StringPool.BLANK;
	}

	public void setClassName(String className) {
		_className = className;
	}

	public void setClassPK(long classPK) {
		_classPK = classPK;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public void setOccurDate(Date occurDate) {
		_occurDate = occurDate;
	}

	public void setOriginalObject(Object originalObject) {
		_originalObject = originalObject;
	}

	public void setPrimaryKey(String primaryKey) {
		String[] primaryKeyArray = StringUtil.split(
			primaryKey, StringPool.POUND);

		_className = primaryKeyArray[0];
		_classPK = GetterUtil.getLong(primaryKeyArray[1]);
	}

	public void setSubjectId(long subjectId) {
		_subjectId = subjectId;
	}

	private String _className;
	private long _classPK;
	private long _companyId;
	private Date _occurDate;
	private Object _originalObject;
	private long _subjectId;

}