/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.web.internal.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.WebKeys;

import com.tokogae.account.service.SubjectService;
import com.tokogae.data.event.model.DataEventFactory;
import com.tokogae.data.event.service.ExerciseLocalService;
import com.tokogae.data.event.service.FoodItemLocalService;
import com.tokogae.data.event.service.SymptomLocalService;
import com.tokogae.web.internal.constants.TokogaePortletKeys;
import com.tokogae.web.internal.display.context.EditDataEventDisplayContext;

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
		"mvc.command.name=/tokogae/edit_data_event"
	},
	service = MVCRenderCommand.class
)
public class EditDataEventMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		EditDataEventDisplayContext editDataEventDisplayContext =
			new EditDataEventDisplayContext(
				_dataEventFactory, _exerciseLocalService, _foodItemLocalService,
				renderRequest, renderResponse, _subjectService,
				_symptomLocalService);

		renderRequest.setAttribute(
			WebKeys.PORTLET_DISPLAY_CONTEXT, editDataEventDisplayContext);

		return "/home/edit_data_event.jsp";
	}

	@Reference
	private DataEventFactory _dataEventFactory;

	@Reference
	private ExerciseLocalService _exerciseLocalService;

	@Reference
	private FoodItemLocalService _foodItemLocalService;

	@Reference
	private SubjectService _subjectService;

	@Reference
	private SymptomLocalService _symptomLocalService;

}