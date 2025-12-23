/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;

import com.tokogae.account.service.SubjectLocalService;
import com.tokogae.data.event.model.SymptomPeriod;
import com.tokogae.data.event.service.base.SymptomPeriodLocalServiceBaseImpl;

import java.util.Date;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Amos Fong
 */
@Component(
	property = "model.class.name=com.tokogae.data.event.model.SymptomPeriod",
	service = AopService.class
)
public class SymptomPeriodLocalServiceImpl
	extends SymptomPeriodLocalServiceBaseImpl {

	public SymptomPeriod addSymptomPeriod(
			long userId, long subjectId, String name, Date startDate,
			Date endDate)
		throws PortalException {

		_subjectLocalService.getSubject(subjectId);

		long symptomPeriodId = counterLocalService.increment();

		SymptomPeriod symptomPeriod = symptomPeriodPersistence.create(
			symptomPeriodId);

		symptomPeriod.setUserId(userId);
		symptomPeriod.setSubjectId(subjectId);
		symptomPeriod.setName(name);
		symptomPeriod.setStartDate(startDate);
		symptomPeriod.setEndDate(endDate);

		return symptomPeriodPersistence.update(symptomPeriod);
	}

	@Override
	public SymptomPeriod deleteSymptomPeriod(long symptomPeriodId)
		throws PortalException {

		return symptomPeriodPersistence.remove(symptomPeriodId);
	}

	public SymptomPeriod updateSymptomPeriod(
			long symptomPeriodId, String name, Date startDate, Date endDate)
		throws PortalException {

		SymptomPeriod symptomPeriod = symptomPeriodPersistence.findByPrimaryKey(
			symptomPeriodId);

		symptomPeriod.setName(name);
		symptomPeriod.setStartDate(startDate);
		symptomPeriod.setEndDate(endDate);

		return symptomPeriodPersistence.update(symptomPeriod);
	}

	@Reference
	private SubjectLocalService _subjectLocalService;

}