/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.web.internal.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import com.tokogae.data.event.exception.NoSuchFoodItemException;
import com.tokogae.data.event.service.FoodItemService;
import com.tokogae.web.internal.constants.TokogaePortletKeys;

import jakarta.portlet.ActionRequest;
import jakarta.portlet.ActionResponse;

import java.text.DateFormat;

import java.util.Date;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Amos Fong
 */
@Component(
	property = {
		"jakarta.portlet.name=" + TokogaePortletKeys.TOKOGAE,
		"mvc.command.name=/tokogae/edit_food_item"
	},
	service = MVCActionCommand.class
)
public class EditFoodItemMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
			if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
				_updateFoodItem(actionRequest);
			}
		}
		catch (NoSuchFoodItemException noSuchFoodItemException) {
			SessionErrors.add(
				actionRequest, noSuchFoodItemException.getClass());
		}
	}

	private void _updateFoodItem(ActionRequest actionRequest) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long foodItemId = ParamUtil.getLong(actionRequest, "foodItemId");

		long subjectId = ParamUtil.getLong(actionRequest, "subjectId");

		String occurDayString = ParamUtil.getString(actionRequest, "occurDay");

		DateFormat dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd", themeDisplay.getTimeZone());

		Date occurDayDate = dateFormat.parse(occurDayString);

		int occurDaySegment = ParamUtil.getInteger(
			actionRequest, "occurDaySegment");
		long occurTime = ParamUtil.getLong(actionRequest, "occurTime");
		String name = ParamUtil.getString(actionRequest, "name");
		String locationOfOrigin = ParamUtil.getString(
			actionRequest, "locationOfOrigin");
		String brand = ParamUtil.getString(actionRequest, "brand");
		double quantity = ParamUtil.getDouble(actionRequest, "quantity");
		String quantityUnit = ParamUtil.getString(
			actionRequest, "quantityUnit");

		if (foodItemId <= 0) {
			_foodItemService.addFoodItem(
				subjectId, occurDayDate.getTime(), occurDaySegment, occurTime,
				name, locationOfOrigin, brand, quantity, quantityUnit);
		}
		else {
			_foodItemService.addFoodItem(
				foodItemId, occurDayDate.getTime(), occurDaySegment, occurTime,
				name, locationOfOrigin, brand, quantity, quantityUnit);
		}
	}

	@Reference
	private FoodItemService _foodItemService;

}