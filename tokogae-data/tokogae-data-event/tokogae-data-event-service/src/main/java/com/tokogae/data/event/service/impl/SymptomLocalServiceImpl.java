/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;

import com.tokogae.account.service.SubjectLocalService;
import com.tokogae.data.event.model.Symptom;
import com.tokogae.data.event.service.base.SymptomLocalServiceBaseImpl;

import java.util.Date;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Amos Fong
 */
@Component(
	property = "model.class.name=com.tokogae.data.event.model.Symptom",
	service = AopService.class
)
public class SymptomLocalServiceImpl extends SymptomLocalServiceBaseImpl {

	public Symptom addSymptom(
			long userId, long subjectId, long occurDay, int occurDaySegment,
			long occurTime, String name, String affectedArea, Date startDate,
			Date endDate, int intensityLevel)
		throws PortalException {

		_subjectLocalService.getSubject(subjectId);

		long symptomId = counterLocalService.increment();

		Symptom symptom = symptomPersistence.create(symptomId);

		symptom.setUserId(userId);
		symptom.setSubjectId(subjectId);
		symptom.setOccurDay(occurDay);
		symptom.setOccurDaySegment(occurDaySegment);
		symptom.setOccurTime(occurTime);
		symptom.setName(name);
		symptom.setAffectedArea(affectedArea);
		symptom.setStartDate(startDate);
		symptom.setEndDate(endDate);
		symptom.setIntensityLevel(intensityLevel);

		return symptomPersistence.update(symptom);
	}

	public Symptom updateSymptom(
			long symptomId, long occurDay, int occurDaySegment, long occurTime,
			String name, String affectedArea, Date startDate, Date endDate,
			int intensityLevel)
		throws PortalException {

		Symptom symptom = symptomPersistence.findByPrimaryKey(symptomId);

		symptom.setOccurDay(occurDay);
		symptom.setOccurDaySegment(occurDaySegment);
		symptom.setOccurTime(occurTime);
		symptom.setName(name);
		symptom.setAffectedArea(affectedArea);
		symptom.setStartDate(startDate);
		symptom.setEndDate(endDate);
		symptom.setIntensityLevel(intensityLevel);

		return symptomPersistence.update(symptom);
	}

	@Reference
	private SubjectLocalService _subjectLocalService;

}