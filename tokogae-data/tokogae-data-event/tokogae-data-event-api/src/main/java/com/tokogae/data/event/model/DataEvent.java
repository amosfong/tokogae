/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.model;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * @author Amos Fong
 */
public interface DataEvent {

	public Object getAttribute(String key);

	public Map<String, Object> getAttributes();

	public int getAttributesHashCode();

	public String getClassName();

	public long getClassPK();

	public long getCompanyId();

	public Date getEndDate();

	public Date getOccurDate();

	public String getOccurDateLabel(Locale locale);

	public String getPrimaryKey();

	public Date getStartDate();

	public long getSubjectId();

	public String getSummary();

	public void setAttributes(Map<String, Object> attributes);

	public void setClassName(String className);

	public void setClassPK(long classPK);

	public void setCompanyId(long companyId);

	public void setEndDate(Date endDate);

	public void setOccurDate(Date occurDate);

	public void setPrimaryKey(String primaryKey);

	public void setStartDate(Date startDate);

	public void setSubjectId(long subjectId);

	public void setSummary(String summary);

}