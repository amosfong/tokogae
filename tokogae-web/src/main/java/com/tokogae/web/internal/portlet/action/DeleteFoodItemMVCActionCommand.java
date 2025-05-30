/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.web.internal.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;

import com.tokogae.data.event.exception.NoSuchFoodItemException;
import com.tokogae.data.event.service.FoodItemService;
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
		"mvc.command.name=/tokogae/delete_food_item"
	},
	service = MVCActionCommand.class
)
public class DeleteFoodItemMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		try {
			long foodItemId = ParamUtil.getLong(actionRequest, "foodItemId");

			_foodItemService.deleteFoodItem(foodItemId);
		}
		catch (NoSuchFoodItemException noSuchFoodItemException) {
			SessionErrors.add(
				actionRequest, noSuchFoodItemException.getClass());
		}
	}

	@Reference
	private FoodItemService _foodItemService;

}