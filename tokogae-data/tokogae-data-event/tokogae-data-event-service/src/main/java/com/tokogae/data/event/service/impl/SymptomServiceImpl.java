/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;

import com.tokogae.account.permission.SubjectPermission;
import com.tokogae.data.event.model.Symptom;
import com.tokogae.data.event.service.base.SymptomServiceBaseImpl;

import java.util.Date;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Amos Fong
 */
@Component(
	property = {
		"json.web.service.context.name=tokogae_data",
		"json.web.service.context.path=Symptom"
	},
	service = AopService.class
)
public class SymptomServiceImpl extends SymptomServiceBaseImpl {

	public Symptom addSymptom(
			long subjectId, long occurDay, int occurDaySegment, long occurTime,
			String name, String affectedArea, Date startDate, Date endDate,
			int intensityLevel)
		throws PortalException {

		_subjectPermission.check(
			getPermissionChecker(), subjectId, ActionKeys.UPDATE);

		return symptomLocalService.addSymptom(
			getUserId(), subjectId, occurDay, occurDaySegment, occurTime, name,
			affectedArea, startDate, endDate, intensityLevel);
	}

	public Symptom deleteSymptom(long symptomId) throws PortalException {
		Symptom symptom = symptomLocalService.getSymptom(symptomId);

		_subjectPermission.check(
			getPermissionChecker(), symptom.getSubjectId(), ActionKeys.UPDATE);

		return symptomLocalService.deleteSymptom(symptomId);
	}

	public Symptom updateSymptom(
			long symptomId, long occurDay, int occurDaySegment, long occurTime,
			String name, String affectedArea, Date startDate, Date endDate,
			int intensityLevel)
		throws PortalException {

		Symptom symptom = symptomLocalService.getSymptom(symptomId);

		_subjectPermission.check(
			getPermissionChecker(), symptom.getSubjectId(), ActionKeys.UPDATE);

		return symptomLocalService.updateSymptom(
			symptomId, occurDay, occurDaySegment, occurTime, name, affectedArea,
			startDate, endDate, intensityLevel);
	}

	@Reference
	private SubjectPermission _subjectPermission;

}