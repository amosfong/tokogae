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
	<div class="col-md-3">
		<liferay-util:include page="/sidebar.jsp" servletContext="<%= application %>" />
	</div>

	<div class="col-md-9">
		<portlet:actionURL name="/tokogae/edit_food_item" var="editFoodItemURL" />

		<liferay-frontend:edit-form
			action="<%= editFoodItemURL %>"
			enctype="multipart/form-data"
			method="post"
			name="fm1"
		>
			<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
			<aui:input name="redirect" type="hidden" value='<%= ParamUtil.getString(request, "redirect") %>' />

			<aui:select id="subjectId" label="subject" name="subjectId">

				<%
				for (Subject subject : homeDisplayContext.getSubjects()) {
				%>

					<aui:option label="<%= subject.getDisplayName() %>" value="<%= subject.getSubjectId() %>" />

				<%
				}
				%>

			</aui:select>

			<liferay-frontend:edit-form-body>
				<liferay-frontend:fieldset
					collapsed="<%= false %>"
					collapsible="<%= true %>"
					label="details"
				>
					<aui:input name="occurDay" value="<%= homeDisplayContext.getCurrentOccurDay() %>" />

					<aui:select id="occurDaySegment" label="day-segment" name="occurDaySegment">

						<%
						for (int daySegment : DaySegments.VALUES) {
						%>

							<aui:option label="<%= DaySegments.getLabel(daySegment) %>" value="<%= daySegment %>" />

						<%
						}
						%>

					</aui:select>

					<aui:input name="name" />

					<aui:select id="quantityUnit" label="quantity-unit" name="quantityUnit">

						<%
						for (String quantityUnit : QuantityUnits.VALUES) {
						%>

							<aui:option label="<%= quantityUnit %>" value="<%= quantityUnit %>" />

						<%
						}
						%>

					</aui:select>

					<aui:input name="quantity" value="1" />
				</liferay-frontend:fieldset>
			</liferay-frontend:edit-form-body>

			<liferay-frontend:edit-form-footer>
				<liferay-frontend:edit-form-buttons />
			</liferay-frontend:edit-form-footer>
		</liferay-frontend:edit-form>

		<%
		List<DataEvent> dataEvents = homeDisplayContext.getTodaysDataEvents();

		for (DataEvent dataEvent : dataEvents) {
		%>

			<%= dataEvent.getSummary() %>

		<%
		}
		%>

	</div>
</div>