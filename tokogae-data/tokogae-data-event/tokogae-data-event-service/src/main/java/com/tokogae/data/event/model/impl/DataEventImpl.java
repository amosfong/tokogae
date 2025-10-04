/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.model.impl;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;

import com.tokogae.data.event.model.DataEvent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Locale;

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

	public Date getEndDate() {
		return _endDate;
	}

	public boolean getExtended() {
		return _extended;
	}

	public Date getOccurDate() {
		return _occurDate;
	}

	public String getOccurDateLabel(Locale locale) {
		if (_extended) {
			if ((_endDate == null) && (_startDate == null)) {
				return LanguageUtil.get(locale, "ongoing");
			}

			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

			StringBundler sb = new StringBundler();

			if (_startDate != null) {
				sb.append(dateFormat.format(getStartDate()));
			}
			else {
				sb.append("?");
			}

			sb.append(" - ");

			if (_endDate != null) {
				sb.append(dateFormat.format(getEndDate()));
			}
			else {
				sb.append(LanguageUtil.get(locale, "ongoing"));
			}

			return sb.toString();
		}

		return LanguageUtil.format(
			locale, "x-ago",
			new Object[] {
				LanguageUtil.getTimeDescription(
					locale, _getTimeDelta(getOccurDate()), true)
			},
			false);
	}

	public String getPrimaryKey() {
		return _className + StringPool.POUND + _classPK;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public long getSubjectId() {
		return _subjectId;
	}

	public String getSummary() {
		return _summary;
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

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public void setExtended(boolean extended) {
		_extended = extended;
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

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public void setSubjectId(long subjectId) {
		_subjectId = subjectId;
	}

	public void setSummary(String summary) {
		_summary = summary;
	}

	private long _getTimeDelta(Date date) {
		if (date.before(new Date())) {
			return System.currentTimeMillis() - date.getTime();
		}

		return date.getTime() - System.currentTimeMillis();
	}

	private String _className;
	private long _classPK;
	private long _companyId;
	private Date _endDate;
	private boolean _extended;
	private Date _occurDate;
	private Object _originalObject;
	private Date _startDate;
	private long _subjectId;
	private String _summary;

}