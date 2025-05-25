/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.account.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;

import com.tokogae.account.model.Subject;
import com.tokogae.account.service.base.SubjectServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Amos Fong
 */
@Component(
	property = {
		"json.web.service.context.name=tokogae",
		"json.web.service.context.path=Subject"
	},
	service = AopService.class
)
public class SubjectServiceImpl extends SubjectServiceBaseImpl {

	public Subject addSubject(
			String firstName, String lastName, String displayName, int gender,
			Date birthday)
		throws PortalException {

		return subjectLocalService.addSubject(
			getUserId(), firstName, lastName, displayName, gender, birthday);
	}

	public Subject deleteSubject(long subjectId) throws PortalException {
		return subjectLocalService.deleteSubject(subjectId);
	}

	public Subject getSubject(long subjectId) throws PortalException {
		return subjectLocalService.getSubject(subjectId);
	}

	public List<Subject> getSubjects(long userId, int start, int end) {
		return subjectLocalService.getSubjects(userId, start, end);
	}

	public int getSubjectsCount(long userId) {
		return subjectLocalService.getSubjectsCount(userId);
	}

	public Subject updateSubject(
			long subjectId, String firstName, String lastName,
			String displayName, int gender, Date birthday)
		throws PortalException {

		return subjectLocalService.updateSubject(
			subjectId, firstName, lastName, displayName, gender, birthday);
	}

}