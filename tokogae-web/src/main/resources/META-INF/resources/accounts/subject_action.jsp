<%--
/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Subject subject = (Subject)row.getObject();
%>

<liferay-ui:icon-menu
	direction="left-side"
	icon="<%= StringPool.BLANK %>"
	markupView="lexicon"
	message="<%= StringPool.BLANK %>"
	showWhenSingleIcon="<%= true %>"
>
	<portlet:renderURL var="editSubjectURL">
		<portlet:param name="mvcRenderCommandName" value="/tokogae/edit_subject" />
		<portlet:param name="backURL" value="<%= currentURL %>" />
		<portlet:param name="subjectId" value="<%= String.valueOf(subject.getSubjectId()) %>" />
	</portlet:renderURL>

	<liferay-ui:icon
		message="edit"
		url="<%= editSubjectURL %>"
	/>

	<portlet:actionURL name="/tokogae/delete_subject" var="deleteSubjectURL">
		<portlet:param name="redirect" value="<%= currentURL %>" />
		<portlet:param name="subjectId" value="<%= String.valueOf(subject.getSubjectId()) %>" />
	</portlet:actionURL>

	<liferay-ui:icon-delete
		url="<%= deleteSubjectURL %>"
	/>
</liferay-ui:icon-menu>