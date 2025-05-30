/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.account.internal.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import com.tokogae.account.model.Subject;
import com.tokogae.account.permission.SubjectPermission;
import com.tokogae.account.service.SubjectLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Amos Fong
 */
@Component(immediate = true, service = SubjectPermission.class)
public class SubjectPermissionImpl implements SubjectPermission {

	public void check(
			PermissionChecker permissionChecker, long subjectId,
			String actionId)
		throws PortalException {

		Subject subject = _subjectLocalService.getSubject(subjectId);

		check(permissionChecker, subject, actionId);
	}

	public void check(
			PermissionChecker permissionChecker, Subject subject,
			String actionId)
		throws PortalException {

		if (subject.getUserId() != permissionChecker.getUserId()) {
			throw new PrincipalException();
		}
	}

	public boolean contains(
			PermissionChecker permissionChecker, long subjectId,
			String actionId)
		throws PortalException {

		Subject subject = _subjectLocalService.getSubject(subjectId);

		return contains(permissionChecker, subject, actionId);
	}

	public boolean contains(
		PermissionChecker permissionChecker, Subject subject, String actionId) {

		if (subject.getUserId() == permissionChecker.getUserId()) {
			return true;
		}

		return false;
	}

	@Reference
	private SubjectLocalService _subjectLocalService;

}