/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.account.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import com.tokogae.account.model.Subject;

/**
 * @author Amos Fong
 */
public interface SubjectPermission {

	public void check(
			PermissionChecker permissionChecker, long subjectId,
			String actionId)
		throws PortalException;

	public void check(
			PermissionChecker permissionChecker, Subject subject,
			String actionId)
		throws PortalException;

	public boolean contains(
			PermissionChecker permissionChecker, long subjectId,
			String actionId)
		throws PortalException;

	public boolean contains(
		PermissionChecker permissionChecker, Subject subject, String actionId);

}