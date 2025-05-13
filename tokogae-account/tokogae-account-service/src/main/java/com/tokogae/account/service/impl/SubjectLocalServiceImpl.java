/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.account.service.impl;

import com.liferay.portal.aop.AopService;

import com.tokogae.account.model.Subject;
import com.tokogae.account.service.base.SubjectLocalServiceBaseImpl;

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

	public List<Subject> getSubjects(long userId, int start, int end) {
		return subjectPersistence.findByUserId(userId, start, end);
	}

	public int getSubjectsCount(long userId) {
		return subjectPersistence.countByUserId(userId);
	}

}