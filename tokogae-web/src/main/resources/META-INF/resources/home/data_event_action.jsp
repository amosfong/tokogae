<%--
/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
HomeDisplayContext homeDisplayContext = (HomeDisplayContext)request.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

DataEvent dataEvent = (DataEvent)row.getObject();
%>

<liferay-ui:icon-menu
	direction="left-side"
	icon="<%= StringPool.BLANK %>"
	markupView="lexicon"
	message="<%= StringPool.BLANK %>"
	showWhenSingleIcon="<%= true %>"
>
	<liferay-ui:icon
		message="edit"
		url="<%= homeDisplayContext.getEditDataEventURL(dataEvent) %>"
	/>

	<portlet:actionURL name="/tokogae/delete_data_event" var="deleteDataEventURL">
		<portlet:param name="redirect" value="<%= currentURL %>" />
		<portlet:param name="className" value="<%= dataEvent.getClassName() %>" />
		<portlet:param name="classPK" value="<%= String.valueOf(dataEvent.getClassPK()) %>" />
	</portlet:actionURL>

	<liferay-ui:icon-delete
		url="<%= deleteDataEventURL %>"
	/>
</liferay-ui:icon-menu>