/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.web.internal.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import com.tokogae.account.model.Subject;
import com.tokogae.account.service.SubjectService;
import com.tokogae.web.internal.constants.TokogaePortletKeys;
import com.tokogae.web.internal.constants.TokogaeWebKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Amos Fong
 */
@Component(
	property = {
		"javax.portlet.name=" + TokogaePortletKeys.TOKOGAE,
		"mvc.command.name=/tokogae/edit_subject"
	},
	service = MVCRenderCommand.class
)
public class EditSubjectMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		long subjectId = ParamUtil.getLong(renderRequest, "subjectId");

		if (subjectId > 0) {
			try {
				Subject subject = _subjectService.getSubject(subjectId);

				renderRequest.setAttribute(TokogaeWebKeys.SUBJECT, subject);
			}
			catch (Exception exception) {
				throw new PortletException(exception);
			}
		}

		return "/accounts/edit_subject.jsp";
	}

	@Reference
	private SubjectService _subjectService;

}