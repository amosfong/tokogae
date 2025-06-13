/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.web.internal.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import com.tokogae.account.exception.NoSuchSubjectException;
import com.tokogae.account.service.SubjectService;
import com.tokogae.web.internal.constants.TokogaePortletKeys;

import jakarta.portlet.ActionRequest;
import jakarta.portlet.ActionResponse;

import java.util.Date;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Amos Fong
 */
@Component(
	property = {
		"jakarta.portlet.name=" + TokogaePortletKeys.TOKOGAE,
		"mvc.command.name=/tokogae/edit_subject"
	},
	service = MVCActionCommand.class
)
public class EditSubjectMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
			if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
				_updateSubject(actionRequest);
			}
		}
		catch (NoSuchSubjectException noSuchSubjectException) {
			SessionErrors.add(actionRequest, noSuchSubjectException.getClass());
		}
	}

	private void _updateSubject(ActionRequest actionRequest) throws Exception {
		long subjectId = ParamUtil.getLong(actionRequest, "subjectId");

		String firstName = ParamUtil.getString(actionRequest, "firstName");
		String lastName = ParamUtil.getString(actionRequest, "lastName");
		String displayName = ParamUtil.getString(actionRequest, "displayName");
		int gender = ParamUtil.getInteger(actionRequest, "gender");

		int birthdayMonth = ParamUtil.getInteger(
			actionRequest, "birthdayMonth");
		int birthdayDay = ParamUtil.getInteger(actionRequest, "birthdayDay");
		int birthdayYear = ParamUtil.getInteger(actionRequest, "birthdayYear");

		Date birthday = PortalUtil.getDate(
			birthdayMonth, birthdayDay, birthdayYear);

		if (subjectId <= 0) {
			_subjectService.addSubject(
				firstName, lastName, displayName, gender, birthday);
		}
		else {
			_subjectService.updateSubject(
				subjectId, firstName, lastName, displayName, gender, birthday);
		}
	}

	@Reference
	private SubjectService _subjectService;

}