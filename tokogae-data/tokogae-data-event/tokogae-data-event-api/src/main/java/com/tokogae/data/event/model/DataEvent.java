/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.model;

import java.util.Date;
import java.util.Locale;

/**
 * @author Amos Fong
 */
public interface DataEvent {

	public String getClassName();

	public long getClassPK();

	public long getCompanyId();

	public Date getEndDate();

	public Date getOccurDate();

	public String getOccurDateLabel(Locale locale);

	public Object getOriginalObject();

	public String getPrimaryKey();

	public Date getStartDate();

	public long getSubjectId();

	public String getSummary();

	public void setClassName(String className);

	public void setClassPK(long classPK);

	public void setCompanyId(long companyId);

	public void setEndDate(Date endDate);

	public void setOccurDate(Date occurDate);

	public void setOriginalObject(Object originalObject);

	public void setPrimaryKey(String primaryKey);

	public void setStartDate(Date startDate);

	public void setSubjectId(long subjectId);

	public void setSummary(String summary);

}