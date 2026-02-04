/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.web.internal.portlet.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.kernel.util.WebKeys;

import com.tokogae.web.internal.constants.TokogaePortletKeys;

import jakarta.portlet.ActionRequest;
import jakarta.portlet.PortletPreferences;

import jakarta.servlet.http.HttpServletRequest;

import java.text.DateFormat;

import java.util.Calendar;
import java.util.Date;

import org.osgi.service.component.annotations.Reference;

/**
 * @author Amos Fong
 */
public abstract class BaseMVCActionCommand
	extends com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand {

	public long getBaseTime(ActionRequest actionRequest, Date date) {
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		Calendar calendar = Calendar.getInstance(themeDisplay.getTimeZone());

		calendar.setTime(date);

		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTimeInMillis();
	}

	protected long getNativeTime(ActionRequest actionRequest, Date date) {
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		Calendar calendar = Calendar.getInstance(themeDisplay.getTimeZone());

		calendar.setTime(date);

		return (calendar.get(Calendar.HOUR_OF_DAY) * Time.HOUR) +
			(calendar.get(Calendar.MINUTE) * Time.MINUTE) +
				(calendar.get(Calendar.SECOND) * Time.SECOND) +
					calendar.get(Calendar.MILLISECOND);
	}

	protected long getOccurDayBaseTime(ActionRequest actionRequest)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		String occurDay = ParamUtil.getString(actionRequest, "occurDay");

		DateFormat dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd", themeDisplay.getTimeZone());

		Date occurDayBaseDate = dateFormat.parse(occurDay);

		return occurDayBaseDate.getTime();
	}

	protected long getSubjectId(ActionRequest actionRequest)
		throws PortalException {

		HttpServletRequest httpServletRequest = portal.getHttpServletRequest(
			actionRequest);

		PortletPreferences portletPreferences =
			portletPreferencesFactory.getPortletPreferences(
				httpServletRequest, TokogaePortletKeys.TOKOGAE);

		return GetterUtil.getLong(
			portletPreferences.getValue("subjectId", StringPool.BLANK));
	}

	@Reference
	protected Portal portal;

	@Reference
	protected PortletPreferencesFactory portletPreferencesFactory;

}