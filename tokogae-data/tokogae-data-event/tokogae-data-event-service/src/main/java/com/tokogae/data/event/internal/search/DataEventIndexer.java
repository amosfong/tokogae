/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.internal.search;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.IndexWriterHelper;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.filter.TermsFilter;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.search.filter.FilterBuilders;

import com.tokogae.data.event.model.DataEvent;
import com.tokogae.data.event.model.DataEventFactory;
import com.tokogae.data.event.model.FoodItem;
import com.tokogae.data.event.service.FoodItemLocalService;

import jakarta.portlet.PortletRequest;
import jakarta.portlet.PortletResponse;

import java.util.Locale;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Amos Fong
 */
@Component(service = Indexer.class)
public class DataEventIndexer extends BaseIndexer<DataEvent> {

	public static final String CLASS_NAME = DataEvent.class.getName();

	public DataEventIndexer() {
		setDefaultSelectedFieldNames(
			Field.COMPANY_ID, Field.ENTRY_CLASS_NAME, Field.ENTRY_CLASS_PK,
			Field.MODIFIED_DATE, Field.NAME, Field.UID);
		setFilterSearch(true);
		setPermissionAware(true);
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	public boolean isPermissionAware() {
		return false;
	}

	@Override
	public boolean isStagingAware() {
		return false;
	}

	@Override
	public void postProcessContextBooleanFilter(
			BooleanFilter contextBooleanFilter, SearchContext searchContext)
		throws Exception {

		long[] subjectIds = GetterUtil.getLongValues(
			searchContext.getAttribute("subjectIds"), null);

		TermsFilter termsFilter = new TermsFilter("subjectId");

		termsFilter.addValues(ArrayUtil.toStringArray(subjectIds));

		contextBooleanFilter.add(termsFilter, BooleanClauseOccur.MUST);
	}

	@Override
	public void postProcessSearchQuery(
			BooleanQuery searchQuery, BooleanFilter fullQueryBooleanFilter,
			SearchContext searchContext)
		throws Exception {
	}

	@Activate
	protected void activate(BundleContext bundleContext) {
	}

	@Deactivate
	protected void deactivate() {
	}

	@Override
	protected void doDelete(DataEvent dataEvent) throws Exception {
		deleteDocument(dataEvent.getCompanyId(), dataEvent.getPrimaryKey());
	}

	@Override
	protected Document doGetDocument(DataEvent dataEvent) throws Exception {
		if (_log.isDebugEnabled()) {
			_log.debug("Indexing data event " + dataEvent);
		}

		Document document = newDocument();

		document.addUID(DataEvent.class.getName(), dataEvent.getPrimaryKey());
		document.addKeyword(Field.ENTRY_CLASS_NAME, DataEvent.class.getName());
		document.addKeyword(Field.ENTRY_CLASS_PK, dataEvent.getPrimaryKey());
		document.addKeyword("companyId", dataEvent.getCompanyId());
		document.addKeyword("subjectId", dataEvent.getSubjectId());
		document.addDate("occurDate", dataEvent.getOccurDate());

		return document;
	}

	@Override
	protected Summary doGetSummary(
		Document document, Locale locale, String snippet,
		PortletRequest portletRequest, PortletResponse portletResponse) {

		Summary summary = createSummary(
			document, Field.ENTRY_CLASS_PK, "summary");

		summary.setMaxContentLength(200);

		return summary;
	}

	@Override
	protected void doReindex(DataEvent dataEvent) throws Exception {
		_indexWriterHelper.updateDocument(
			dataEvent.getCompanyId(), getDocument(dataEvent));
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		if (className.equals(FoodItem.class.getName())) {
			FoodItem foodItem = _foodItemLocalService.getFoodItem(classPK);

			doReindex(_dataEventFactory.create(foodItem));
		}
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		//long companyId = GetterUtil.getLong(ids[0]);

		// get fooditems and reindex

	}

	private static final Log _log = LogFactoryUtil.getLog(
		DataEventIndexer.class);

	@Reference
	private DataEventFactory _dataEventFactory;

	@Reference
	private FilterBuilders _filterBuilders;

	@Reference
	private FoodItemLocalService _foodItemLocalService;

	@Reference
	private IndexWriterHelper _indexWriterHelper;

}