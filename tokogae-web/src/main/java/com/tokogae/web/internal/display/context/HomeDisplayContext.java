/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.web.internal.display.context;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
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
import com.tokogae.data.event.model.Exercise;
import com.tokogae.data.event.model.FoodItem;
import com.tokogae.data.event.model.Sleep;
import com.tokogae.data.event.model.Symptom;
import com.tokogae.data.event.service.ExerciseLocalService;
import com.tokogae.data.event.service.FoodItemLocalService;
import com.tokogae.data.event.service.SleepLocalService;
import com.tokogae.data.event.service.SymptomLocalService;

import jakarta.portlet.PortletURL;
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
			FoodItemLocalService foodItemLocalService,
			RenderRequest renderRequest, RenderResponse renderResponse,
			SleepLocalService sleepLocalService, SubjectService subjectService,
			SymptomLocalService symptomLocalService)
		throws Exception {

		this.dataEventFactory = dataEventFactory;
		this.exerciseLocalService = exerciseLocalService;
		this.foodItemLocalService = foodItemLocalService;
		this.renderRequest = renderRequest;
		this.renderResponse = renderResponse;
		this.sleepLocalService = sleepLocalService;
		this.subjectService = subjectService;
		this.symptomLocalService = symptomLocalService;

		httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);

		themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		format = FastDateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd", themeDisplay.getTimeZone());
	}

	public String getAddLabel(String className) {
		String label = StringPool.BLANK;

		if (className.equals(Exercise.class.getName())) {
			label = "add-exercise";
		}
		else if (className.equals(FoodItem.class.getName())) {
			label = "add-food";
		}
		else if (className.equals(Sleep.class.getName())) {
			label = "add-sleep";
		}
		else if (className.equals(Symptom.class.getName())) {
			label = "add-symptom";
		}

		return LanguageUtil.get(themeDisplay.getLocale(), label);
	}

	public String getCurrentOccurDay() {
		return format.format(new Date());
	}

	public SearchContainer<DataEvent> getDataEventsSearchContainer()
		throws Exception {

		SearchContainer<DataEvent> dataEventsSearchContainer =
			new SearchContainer(
				renderRequest,
				PortletURLUtil.getCurrent(renderRequest, renderResponse), null,
				"no-data-events-were-found");

		dataEventsSearchContainer.setId("dataEvents");

		String orderByCol = ParamUtil.getString(
			renderRequest, "orderByCol", "sortDate");

		dataEventsSearchContainer.setOrderByCol(orderByCol);

		String orderByType = ParamUtil.getString(
			renderRequest, "orderByType", "asc");

		dataEventsSearchContainer.setOrderByType(orderByType);

		SearchContext searchContext = new SearchContext();

		searchContext.setCompanyId(themeDisplay.getCompanyId());

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
					dataEvents.add(dataEventFactory.create(document));
				}

				return dataEvents;
			},
			hits.getLength());

		return dataEventsSearchContainer;
	}

	public String getEditDataEventURL(DataEvent dataEvent) {
		PortletURL portletURL = PortletURLBuilder.createRenderURL(
			renderResponse
		).setMVCRenderCommandName(
			"/tokogae/edit_data_event"
		).setRedirect(
			PortalUtil.getCurrentURL(renderRequest)
		).setParameter(
			"className", dataEvent.getClassName()
		).setParameter(
			"classPK", dataEvent.getClassPK()
		).buildPortletURL();

		return portletURL.toString();
	}

	public String getEditDataEventURL(String className) {
		PortletURL portletURL = PortletURLBuilder.createRenderURL(
			renderResponse
		).setMVCRenderCommandName(
			"/tokogae/edit_data_event"
		).setParameter(
			"className", className
		).buildPortletURL();

		return portletURL.toString();
	}

	public List<Subject> getSubjects() throws PortalException {
		return subjectService.getSubjects(
			themeDisplay.getUserId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public Map<Integer, List<DataEvent>> getTodaysDataEventsMap()
		throws Exception {

		SearchContext searchContext = new SearchContext();

		searchContext.setCompanyId(themeDisplay.getCompanyId());

		Calendar calendar = Calendar.getInstance(themeDisplay.getTimeZone());

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
			DataEvent dataEvent = dataEventFactory.create(document);

			int daySegment = DaySegments.NONE;

			if (dataEvent.getOccurDate() != null) {
				Calendar dataEventCalendar = Calendar.getInstance(
					themeDisplay.getTimeZone());

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

	protected DataEventFactory dataEventFactory;
	protected ExerciseLocalService exerciseLocalService;
	protected FoodItemLocalService foodItemLocalService;
	protected Format format;
	protected final HttpServletRequest httpServletRequest;
	protected final RenderRequest renderRequest;
	protected final RenderResponse renderResponse;
	protected SleepLocalService sleepLocalService;
	protected SubjectService subjectService;
	protected SymptomLocalService symptomLocalService;
	protected final ThemeDisplay themeDisplay;

	private long _getTimeinMilliseconds(Calendar cal) {
		return (cal.get(Calendar.HOUR_OF_DAY) * Time.HOUR) +
			(cal.get(Calendar.MINUTE) * Time.MINUTE) +
				(cal.get(Calendar.SECOND) * Time.SECOND) +
					cal.get(Calendar.MILLISECOND);
	}

}