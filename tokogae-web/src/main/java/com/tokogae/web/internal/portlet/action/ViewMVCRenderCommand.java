/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.web.internal.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.WebKeys;

import com.tokogae.account.service.SubjectService;
import com.tokogae.data.event.model.DataEventFactory;
import com.tokogae.data.event.service.FoodItemLocalService;
import com.tokogae.data.event.service.SymptomLocalService;
import com.tokogae.web.internal.constants.TokogaePortletKeys;
import com.tokogae.web.internal.display.context.HomeDisplayContext;

import jakarta.portlet.PortletException;
import jakarta.portlet.RenderRequest;
import jakarta.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Amos Fong
 */
@Component(
	property = {
		"jakarta.portlet.name=" + TokogaePortletKeys.TOKOGAE,
		"mvc.command.name=/", "mvc.command.name=/tokogae/view"
	},
	service = MVCRenderCommand.class
)
public class ViewMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		HomeDisplayContext homeDisplayContext = new HomeDisplayContext(
			_dataEventFactory, _foodItemLocalService, renderRequest,
			renderResponse, _subjectService, _symptomLocalService);

		renderRequest.setAttribute(
			WebKeys.PORTLET_DISPLAY_CONTEXT, homeDisplayContext);

		return "/home/view.jsp";
	}

	@Reference
	private DataEventFactory _dataEventFactory;

	@Reference
	private FoodItemLocalService _foodItemLocalService;

	@Reference
	private SubjectService _subjectService;

	@Reference
	private SymptomLocalService _symptomLocalService;

}