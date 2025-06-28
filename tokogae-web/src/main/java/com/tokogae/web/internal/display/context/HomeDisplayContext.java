/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.web.internal.display.context;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.FastDateFormatFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;

import com.tokogae.account.model.Subject;
import com.tokogae.account.service.SubjectService;

import jakarta.portlet.RenderRequest;
import jakarta.portlet.RenderResponse;

import java.text.Format;

import java.util.Date;
import java.util.List;

/**
 * @author Amos Fong
 */
public class HomeDisplayContext {

	public HomeDisplayContext(
		RenderRequest renderRequest, RenderResponse renderResponse,
		SubjectService subjectService) {

		_renderRequest = renderRequest;
		_renderResponse = renderResponse;
		_subjectService = subjectService;

		_themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		_format = FastDateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd", _themeDisplay.getTimeZone());
	}

	public String getCurrentOccurDay() {
		return _format.format(new Date());
	}

	public List<Subject> getSubjects() throws PortalException {
		return _subjectService.getSubjects(
			_themeDisplay.getUserId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	private Format _format;
	private final RenderRequest _renderRequest;
	private final RenderResponse _renderResponse;
	private SubjectService _subjectService;
	private final ThemeDisplay _themeDisplay;

}