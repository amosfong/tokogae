<%--
/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<ul>
	<li>
		<portlet:actionURL name="/tokogae/update_subject" var="updateSubjectURL">
			<portlet:param name="redirect" value="<%= currentURL %>" />
		</portlet:actionURL>

		<aui:form action="<%= updateSubjectURL %>" name="subjectForm">
			<aui:select id="subjectId" label="subject" name="subjectId" onchange='<%= liferayPortletResponse.getNamespace() + "updateSubject(event);" %>'>
				<c:if test="<%= selectedSubjectId <= 0 %>">
					<aui:option label="" value="" />
				</c:if>

				<%
				HomeDisplayContext homeDisplayContext = (HomeDisplayContext)request.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);

				for (Subject subject : homeDisplayContext.getSubjects()) {
				%>

					<aui:option label="<%= subject.getDisplayName() %>" selected="<%= subject.getSubjectId() == selectedSubjectId %>" value="<%= subject.getSubjectId() %>" />

				<%
				}
				%>

			</aui:select>
		</aui:form>

		<%
		PortletURL homeURL = PortletURLBuilder.createRenderURL(
			renderResponse
		).setMVCRenderCommandName(
			"/tokogae/view"
		).buildPortletURL();
		%>

		<a href="<%= homeURL.toString() %>">Home</a>
	</li>
	<li>

		<%
		PortletURL viewSubjectsURL = PortletURLBuilder.createRenderURL(
			renderResponse
		).setMVCRenderCommandName(
			"/tokogae/subjects"
		).buildPortletURL();
		%>

		<a href="<%= viewSubjectsURL.toString() %>">Subjects</a>
	</li>
	<li>

		<%
		PortletURL viewDataEventsURL = PortletURLBuilder.createRenderURL(
			renderResponse
		).setMVCRenderCommandName(
			"/tokogae/view_data_events"
		).buildPortletURL();
		%>

		<a href="<%= viewDataEventsURL.toString() %>">All Events</a>
	</li>
	<li>
		<a href="#">Account Settings</a>
	</li>
</ul>

<aui:script>
	function <portlet:namespace />updateSubject() {
		var subjectForm = document.getElementById(
			'<portlet:namespace />subjectForm'
		);

		subjectForm.submit();
	}
</aui:script>