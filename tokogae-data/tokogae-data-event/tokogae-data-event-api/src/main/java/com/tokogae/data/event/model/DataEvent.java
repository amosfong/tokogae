/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.model;

import java.util.Date;

/**
 * @author Amos Fong
 */
public interface DataEvent {

	public String getClassName();

	public long getClassPK();

	public long getCompanyId();

	public Date getOccurDate();

	public String getPrimaryKey();

	public long getSubjectId();

	public String getSummary();

	public void setClassName(String className);

	public void setClassPK(long classPK);

	public void setCompanyId(long companyId);

	public void setOccurDate(Date occurDate);

	public void setOriginalObject(Object originalObject);

	public void setPrimaryKey(String primaryKey);

	public void setSubjectId(long subjectId);

	public void setSummary(String summary);

}