/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.account.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;

import com.tokogae.account.model.Subject;
import com.tokogae.account.service.base.SubjectLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Amos Fong
 */
@Component(
	property = "model.class.name=com.tokogae.account.model.Subject",
	service = AopService.class
)
public class SubjectLocalServiceImpl extends SubjectLocalServiceBaseImpl {

	public Subject addSubject(
		long userId, String firstName, String lastName, String displayName,
		int gender, Date birthday) {

		long subjectId = counterLocalService.increment();

		Subject subject = subjectPersistence.create(subjectId);

		subject.setUserId(userId);
		subject.setFirstName(firstName);
		subject.setLastName(lastName);
		subject.setDisplayName(displayName);
		subject.setGender(gender);
		subject.setBirthday(birthday);

		return subjectPersistence.update(subject);
	}

	public Subject deleteSubject(long subjectId) throws PortalException {
		return subjectPersistence.remove(subjectId);
	}

	public Subject getSubject(long subjectId) throws PortalException {
		return subjectPersistence.findByPrimaryKey(subjectId);
	}

	public List<Subject> getSubjects(long userId, int start, int end) {
		return subjectPersistence.findByUserId(userId, start, end);
	}

	public int getSubjectsCount(long userId) {
		return subjectPersistence.countByUserId(userId);
	}

	public Subject updateSubject(
			long subjectId, String firstName, String lastName,
			String displayName, int gender, Date birthday)
		throws PortalException {

		Subject subject = subjectPersistence.findByPrimaryKey(subjectId);

		subject.setFirstName(firstName);
		subject.setLastName(lastName);
		subject.setDisplayName(displayName);
		subject.setGender(gender);
		subject.setBirthday(birthday);

		return subjectPersistence.update(subject);
	}

}