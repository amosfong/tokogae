/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.web.internal.display.context;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import com.tokogae.account.model.Subject;
import com.tokogae.account.service.SubjectService;

import jakarta.portlet.PortletURL;
import jakarta.portlet.RenderRequest;
import jakarta.portlet.RenderResponse;

/**
 * @author Amos Fong
 */
public class SubjectsDisplayContext {

	public SubjectsDisplayContext(
		RenderRequest renderRequest, RenderResponse renderResponse,
		SubjectService subjectService) {

		_renderRequest = renderRequest;
		_renderResponse = renderResponse;
		_subjectService = subjectService;

		_themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);
	}

	public SearchContainer<Subject> getSearchContainer()
		throws PortalException {

		if (_searchContainer != null) {
			return _searchContainer;
		}

		_searchContainer = new SearchContainer(
			_renderRequest, null, null, "cur1", SearchContainer.DEFAULT_DELTA,
			_getPortletURL(), null, "no-subjects-were-found");

		_searchContainer.setResultsAndTotal(
			() -> _subjectService.getSubjects(
				_themeDisplay.getUserId(), _searchContainer.getStart(),
				_searchContainer.getEnd()),
			_subjectService.getSubjectsCount(_themeDisplay.getUserId()));

		return _searchContainer;
	}

	private PortletURL _getPortletURL() {
		if (_portletURL != null) {
			return _portletURL;
		}

		_portletURL = PortletURLBuilder.createRenderURL(
			_renderResponse
		).setMVCRenderCommandName(
			"/tokogae/edit_subject"
		).buildPortletURL();

		return _portletURL;
	}

	private PortletURL _portletURL;
	private final RenderRequest _renderRequest;
	private final RenderResponse _renderResponse;
	private SearchContainer<Subject> _searchContainer;
	private SubjectService _subjectService;
	private final ThemeDisplay _themeDisplay;

}