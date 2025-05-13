<%--
/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
SubjectsDisplayContext subjectsDisplayContext = (SubjectsDisplayContext)request.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);
%>

<liferay-ui:search-container
	searchContainer="<%= subjectsDisplayContext.getSearchContainer() %>"
>
	<liferay-ui:search-container-row
		className="com.tokogae.account.model.Subject"
		keyProperty="subjectId"
		modelVar="Subject"
	>
		<liferay-ui:search-container-column-text
			property="displayName"
		/>

		<liferay-ui:search-container-column-date
			property="firstName"
		/>

		<liferay-ui:search-container-column-date
			property="lastName"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator
		markupView="lexicon"
	/>
</liferay-ui:search-container>