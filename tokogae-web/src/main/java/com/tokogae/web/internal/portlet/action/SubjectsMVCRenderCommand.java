/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.web.internal.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.WebKeys;

import com.tokogae.account.service.SubjectService;
import com.tokogae.web.internal.constants.TokogaePortletKeys;
import com.tokogae.web.internal.display.context.SubjectsDisplayContext;

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
		"mvc.command.name=/tokogae/subjects"
	},
	service = MVCRenderCommand.class
)
public class SubjectsMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		SubjectsDisplayContext subjectsDisplayContext =
			new SubjectsDisplayContext(
				renderRequest, renderResponse, _subjectService);

		renderRequest.setAttribute(
			WebKeys.PORTLET_DISPLAY_CONTEXT, subjectsDisplayContext);

		return "/accounts/view_subjects.jsp";
	}

	@Reference
	private SubjectService _subjectService;

}