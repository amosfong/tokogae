<%--
/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
HomeDisplayContext homeDisplayContext = (HomeDisplayContext)request.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);
%>

<div class="row">
	<div class="col-md-2">
		<liferay-util:include page="/sidebar.jsp" servletContext="<%= application %>" />
	</div>

	<div class="col-md-10">
		<liferay-ui:search-container
			searchContainer="<%= homeDisplayContext.getDataEventsSearchContainer() %>"
		>
			<liferay-ui:search-container-row
				className="com.tokogae.data.event.model.DataEvent"
				escapedModel="<%= true %>"
				modelVar="dataEvent"
			>
				<liferay-ui:search-container-column-date
					name="occur-date"
					value="<%= dataEvent.getOccurDate() %>"
				/>

				<liferay-ui:search-container-column-text
					name="summary"
					value="<%= dataEvent.getSummary() %>"
				/>

				<liferay-ui:search-container-column-jsp
					align="right"
					cssClass="entry-action"
					path="/home/data_event_action.jsp"
				/>
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator
				markupView="lexicon"
			/>
		</liferay-ui:search-container>
	</div>
</div>