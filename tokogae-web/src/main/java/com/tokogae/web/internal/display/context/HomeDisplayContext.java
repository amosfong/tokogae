/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.web.internal.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.TabsItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.TabsItemListBuilder;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.QueryConfig;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.FastDateFormatFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.kernel.util.WebKeys;

import com.tokogae.account.model.Subject;
import com.tokogae.account.service.SubjectService;
import com.tokogae.constants.DaySegments;
import com.tokogae.data.event.model.DataEvent;
import com.tokogae.data.event.model.DataEventFactory;
import com.tokogae.data.event.service.ExerciseLocalService;
import com.tokogae.data.event.service.FoodItemLocalService;
import com.tokogae.data.event.service.SymptomLocalService;

import jakarta.portlet.RenderRequest;
import jakarta.portlet.RenderResponse;

import jakarta.servlet.http.HttpServletRequest;

import java.text.Format;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Amos Fong
 */
public class HomeDisplayContext {

	public HomeDisplayContext(
		DataEventFactory dataEventFactory,
		ExerciseLocalService exerciseLocalService,
		FoodItemLocalService foodItemLocalService, RenderRequest renderRequest,
		RenderResponse renderResponse, SubjectService subjectService,
		SymptomLocalService symptomLocalService) {

		_dataEventFactory = dataEventFactory;
		_exerciseLocalService = exerciseLocalService;
		_foodItemLocalService = foodItemLocalService;
		_renderRequest = renderRequest;
		_renderResponse = renderResponse;
		_subjectService = subjectService;
		_symptomLocalService = symptomLocalService;

		_httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);

		_themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		_format = FastDateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd", _themeDisplay.getTimeZone());
	}

	public String getCurrentOccurDay() {
		return _format.format(new Date());
	}

	public SearchContainer<DataEvent> getDataEventsSearchContainer()
		throws Exception {

		SearchContainer<DataEvent> dataEventsSearchContainer =
			new SearchContainer(
				_renderRequest,
				PortletURLUtil.getCurrent(_renderRequest, _renderResponse),
				null, "no-data-events-were-found");

		dataEventsSearchContainer.setId("dataEvents");

		String orderByCol = ParamUtil.getString(
			_renderRequest, "orderByCol", "sortDate");

		dataEventsSearchContainer.setOrderByCol(orderByCol);

		String orderByType = ParamUtil.getString(
			_renderRequest, "orderByType", "asc");

		dataEventsSearchContainer.setOrderByType(orderByType);

		SearchContext searchContext = new SearchContext();

		searchContext.setCompanyId(_themeDisplay.getCompanyId());

		List<Subject> subjects = getSubjects();

		long[] subjectIds = new long[subjects.size()];

		for (int i = 0; i < subjects.size(); i++) {
			Subject subject = subjects.get(0);

			subjectIds[i] = subject.getSubjectId();
		}

		searchContext.setAttribute("subjectIds", subjectIds);

		searchContext.setEnd(dataEventsSearchContainer.getEnd());
		searchContext.setStart(dataEventsSearchContainer.getStart());

		boolean ascending = false;

		if (orderByType.equals("asc")) {
			ascending = true;
		}

		Sort sort = new Sort(Field.getSortableFieldName(orderByCol), ascending);

		searchContext.setSorts(sort);

		QueryConfig queryConfig = searchContext.getQueryConfig();

		queryConfig.addSelectedFieldNames(
			"endDate", "extended", "occurDate", "startDate", "summary");

		Indexer<DataEvent> indexer = IndexerRegistryUtil.getIndexer(
			DataEvent.class);

		Hits hits = indexer.search(searchContext);

		dataEventsSearchContainer.setResultsAndTotal(
			() -> {
				List<DataEvent> dataEvents = new ArrayList<>();

				for (Document document : hits.getDocs()) {
					dataEvents.add(_dataEventFactory.create(document));
				}

				return dataEvents;
			},
			hits.getLength());

		return dataEventsSearchContainer;
	}

	public List<Subject> getSubjects() throws PortalException {
		return _subjectService.getSubjects(
			_themeDisplay.getUserId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<TabsItem> getTabsItems() {
		return TabsItemListBuilder.add(
			tabsItem -> {
				tabsItem.setActive(true);
				tabsItem.setLabel(
					LanguageUtil.get(_httpServletRequest, "food"));
			}
		).add(
			tabsItem -> tabsItem.setLabel(
				LanguageUtil.get(_httpServletRequest, "symptoms"))
		).add(
			tabsItem -> tabsItem.setLabel(
				LanguageUtil.get(_httpServletRequest, "exercise"))
		).build();
	}

	public Map<Integer, List<DataEvent>> getTodaysDataEventsMap()
		throws Exception {

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
		searchContext.setStart(0);

		Sort sort = new Sort(Field.getSortableFieldName("occurDate"), false);

		searchContext.setSorts(sort);

		QueryConfig queryConfig = searchContext.getQueryConfig();

		queryConfig.addSelectedFieldNames("occurDate", "summary");

		Indexer<DataEvent> indexer = IndexerRegistryUtil.getIndexer(
			DataEvent.class);

		Hits hits = indexer.search(searchContext);

		Map<Integer, List<DataEvent>> dataEventsMap = new HashMap<>();

		for (Document document : hits.getDocs()) {
			DataEvent dataEvent = _dataEventFactory.create(document);

			int daySegment = DaySegments.NONE;

			if (dataEvent.getOccurDate() != null) {
				Calendar dataEventCalendar = Calendar.getInstance(
					_themeDisplay.getTimeZone());

				dataEventCalendar.setTime(dataEvent.getOccurDate());

				long dataEventDayTime = _getTimeinMilliseconds(
					dataEventCalendar);

				daySegment = DaySegments.getDaySegment(dataEventDayTime);
			}

			List<DataEvent> dataEvents = dataEventsMap.get(daySegment);

			if (dataEvents == null) {
				dataEvents = new ArrayList<>();

				dataEventsMap.put(daySegment, dataEvents);
			}

			dataEvents.add(dataEvent);
		}

		return dataEventsMap;
	}

	private long _getTimeinMilliseconds(Calendar cal) {
		return (cal.get(Calendar.HOUR_OF_DAY) * Time.HOUR) +
			(cal.get(Calendar.MINUTE) * Time.MINUTE) +
				(cal.get(Calendar.SECOND) * Time.SECOND) +
					cal.get(Calendar.MILLISECOND);
	}

	private DataEventFactory _dataEventFactory;
	private ExerciseLocalService _exerciseLocalService;
	private FoodItemLocalService _foodItemLocalService;
	private Format _format;
	private final HttpServletRequest _httpServletRequest;
	private final RenderRequest _renderRequest;
	private final RenderResponse _renderResponse;
	private SubjectService _subjectService;
	private SymptomLocalService _symptomLocalService;
	private final ThemeDisplay _themeDisplay;

}