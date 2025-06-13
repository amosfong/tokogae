/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.web.internal.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;

import com.tokogae.account.exception.NoSuchSubjectException;
import com.tokogae.account.service.SubjectService;
import com.tokogae.web.internal.constants.TokogaePortletKeys;

import jakarta.portlet.ActionRequest;
import jakarta.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Amos Fong
 */
@Component(
	property = {
		"jakarta.portlet.name=" + TokogaePortletKeys.TOKOGAE,
		"mvc.command.name=/tokogae/delete_subject"
	},
	service = MVCActionCommand.class
)
public class DeleteSubjectMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		try {
			long subjectId = ParamUtil.getLong(actionRequest, "subjectId");

			_subjectService.deleteSubject(subjectId);
		}
		catch (NoSuchSubjectException noSuchSubjectException) {
			SessionErrors.add(actionRequest, noSuchSubjectException.getClass());
		}
	}

	@Reference
	private SubjectService _subjectService;

}