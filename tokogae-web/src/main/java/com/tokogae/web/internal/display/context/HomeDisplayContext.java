/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.web.internal.display.context;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.FastDateFormatFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;

import com.tokogae.account.model.Subject;
import com.tokogae.account.service.SubjectService;
import com.tokogae.data.event.model.DataEvent;
import com.tokogae.data.event.model.DataEventFactory;
import com.tokogae.data.event.model.FoodItem;
import com.tokogae.data.event.service.FoodItemLocalService;

import jakarta.portlet.RenderRequest;
import jakarta.portlet.RenderResponse;

import jakarta.servlet.http.HttpServletRequest;

import java.text.Format;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Amos Fong
 */
public class HomeDisplayContext {

	public HomeDisplayContext(
		DataEventFactory dataEventFactory,
		FoodItemLocalService foodItemLocalService, RenderRequest renderRequest,
		RenderResponse renderResponse, SubjectService subjectService) {

		_dataEventFactory = dataEventFactory;
		_foodItemLocalService = foodItemLocalService;
		_renderRequest = renderRequest;
		_renderResponse = renderResponse;
		_subjectService = subjectService;

		_httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);

		_themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		_format = FastDateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd", _themeDisplay.getTimeZone());
	}

	public String getCurrentOccurDay() {
		return _format.format(new Date());
	}

	public List<Subject> getSubjects() throws PortalException {
		return _subjectService.getSubjects(
			_themeDisplay.getUserId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<DataEvent> getTodaysDataEvents() throws Exception {
		Indexer<DataEvent> indexer = IndexerRegistryUtil.getIndexer(
			DataEvent.class);

		SearchContext searchContext = new SearchContext();

		searchContext.setCompanyId(_themeDisplay.getCompanyId());

		Calendar calendar = Calendar.getInstance(_themeDisplay.getTimeZone());

		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		searchContext.setAttribute("minOccurDate", calendar.getTime());

		calendar.add(Calendar.DATE, 1);

		searchContext.setAttribute("maxOccurDate", calendar.getTime());

		List<Subject> subjects = getSubjects();

		long[] subjectIds = new long[subjects.size()];

		for (int i = 0; i < subjects.size(); i++) {
			Subject subject = subjects.get(0);

			subjectIds[i] = subject.getSubjectId();
		}

		searchContext.setAttribute("subjectIds", subjectIds);

		searchContext.setEnd(1000);
		searchContext.setStart(1);

		Sort sort = new Sort("occurDay", false);

		searchContext.setSorts(sort);

		Hits hits = indexer.search(searchContext);

		List<DataEvent> dataEvents = new ArrayList<>();

		for (Document document : hits.getDocs()) {
			String[] primaryKeyArray = StringUtil.split(
				document.get(Field.ENTRY_CLASS_PK), StringPool.POUND);

			String className = primaryKeyArray[0];
			long classPK = GetterUtil.getLong(primaryKeyArray[1]);

			if (className.equals(FoodItem.class.getName())) {
				FoodItem foodItem = _foodItemLocalService.getFoodItem(classPK);

				dataEvents.add(_dataEventFactory.create(foodItem));
			}
		}

		return dataEvents;
	}

	private DataEventFactory _dataEventFactory;
	private FoodItemLocalService _foodItemLocalService;
	private Format _format;
	private final HttpServletRequest _httpServletRequest;
	private final RenderRequest _renderRequest;
	private final RenderResponse _renderResponse;
	private SubjectService _subjectService;
	private final ThemeDisplay _themeDisplay;

}