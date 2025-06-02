/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.web.internal.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;

import com.tokogae.data.event.exception.NoSuchSymptomException;
import com.tokogae.data.event.service.SymptomService;
import com.tokogae.web.internal.constants.TokogaePortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Amos Fong
 */
@Component(
	property = {
		"javax.portlet.name=" + TokogaePortletKeys.TOKOGAE,
		"mvc.command.name=/tokogae/edit_symptom"
	},
	service = MVCActionCommand.class
)
public class EditSymptomMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
			if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
				_updateSymptom(actionRequest);
			}
		}
		catch (NoSuchSymptomException noSuchSymptomException) {
			SessionErrors.add(actionRequest, noSuchSymptomException.getClass());
		}
	}

	private void _updateSymptom(ActionRequest actionRequest) throws Exception {
		long symptomId = ParamUtil.getLong(actionRequest, "symptomId");

		long subjectId = ParamUtil.getLong(actionRequest, "subjectId");
		long occurDay = ParamUtil.getLong(actionRequest, "occurDay");
		int occurDaySegment = ParamUtil.getInteger(
			actionRequest, "occurDaySegment");
		long occurTime = ParamUtil.getLong(actionRequest, "occurTime");
		String name = ParamUtil.getString(actionRequest, "name");
		String affectedArea = ParamUtil.getString(
			actionRequest, "affectedArea");
		int intensityLevel = ParamUtil.getInteger(
			actionRequest, "intensityLevel");

		if (symptomId <= 0) {
			_symptomService.addSymptom(
				subjectId, occurDay, occurDaySegment, occurTime, name,
				affectedArea, null, null, intensityLevel);
		}
		else {
			_symptomService.updateSymptom(
				symptomId, occurDay, occurDaySegment, occurTime, name,
				affectedArea, null, null, intensityLevel);
		}
	}

	@Reference
	private SymptomService _symptomService;

}