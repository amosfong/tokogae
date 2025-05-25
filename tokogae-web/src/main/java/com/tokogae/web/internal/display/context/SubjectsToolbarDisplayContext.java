/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.web.internal.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.SearchContainerManagementToolbarDisplayContext;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenuBuilder;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemBuilder;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Amos Fong
 */
public class SubjectsToolbarDisplayContext
	extends SearchContainerManagementToolbarDisplayContext {

	public SubjectsToolbarDisplayContext(
			HttpServletRequest httpServletRequest,
			LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse,
			SubjectsDisplayContext subjectsDisplayContext)
		throws Exception {

		super(
			httpServletRequest, liferayPortletRequest, liferayPortletResponse,
			subjectsDisplayContext.getSearchContainer());
	}

	@Override
	public List<DropdownItem> getActionDropdownItems() {
		return DropdownItemList.of(
			DropdownItemBuilder.putData(
				"action", "deleteSubject"
			).putData(
				"deleteSubjectURL",
				PortletURLBuilder.createActionURL(
					liferayPortletResponse
				).setActionName(
					"/tokogae/delete_subject"
				).setCMD(
					Constants.DELETE
				).setNavigation(
					getNavigation()
				).buildString()
			).setIcon(
				"trash"
			).setLabel(
				LanguageUtil.get(httpServletRequest, "delete")
			).setQuickAction(
				true
			).build());
	}

	@Override
	public String getClearResultsURL() {
		return PortletURLBuilder.create(
			getPortletURL()
		).setKeywords(
			StringPool.BLANK
		).buildString();
	}

	@Override
	public String getComponentId() {
		return "subjectsManagementToolbar";
	}

	@Override
	public CreationMenu getCreationMenu() {
		return CreationMenuBuilder.addPrimaryDropdownItem(
			dropdownItem -> {
				ThemeDisplay themeDisplay =
					(ThemeDisplay)httpServletRequest.getAttribute(
						WebKeys.THEME_DISPLAY);

				dropdownItem.setHref(
					liferayPortletResponse.createRenderURL(),
					"mvcRenderCommandName", "/tokogae/edit_subject", "redirect",
					themeDisplay.getURLCurrent());

				dropdownItem.setLabel(
					LanguageUtil.get(httpServletRequest, "add-subject"));
			}
		).build();
	}

	@Override
	public String getSearchContainerId() {
		return "subjects";
	}

	@Override
	public Boolean isShowCreationMenu() {
		return true;
	}

}