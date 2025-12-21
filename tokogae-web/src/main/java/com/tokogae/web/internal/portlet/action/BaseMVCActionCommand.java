/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.web.internal.portlet.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactory;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Portal;

import com.tokogae.web.internal.constants.TokogaePortletKeys;

import jakarta.portlet.ActionRequest;
import jakarta.portlet.PortletPreferences;

import jakarta.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Reference;

/**
 * @author Amos Fong
 */
public abstract class BaseMVCActionCommand
	extends com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand {

	protected long getSubjectId(ActionRequest actionRequest)
		throws PortalException {

		HttpServletRequest httpServletRequest = portal.getHttpServletRequest(
			actionRequest);

		PortletPreferences portletPreferences =
			portletPreferencesFactory.getPortletPreferences(
				httpServletRequest, TokogaePortletKeys.TOKOGAE);

		return GetterUtil.getLong(
			portletPreferences.getValue("subjectId", StringPool.BLANK));
	}

	@Reference
	protected Portal portal;

	@Reference
	protected PortletPreferencesFactory portletPreferencesFactory;

}