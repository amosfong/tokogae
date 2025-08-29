<%--
/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<ul>
	<li>

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