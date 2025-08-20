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

	<div class="col-md-3">
		<clay:sheet>
			<h2 class="sheet-title">
				<liferay-ui:message key="today" />
			</h2>

			<%
			Map<Integer, List<DataEvent>> dataEventsMap = homeDisplayContext.getTodaysDataEventsMap();

			for (int daySegment : DaySegments.VALUES) {
			%>

			<ul class="list-group">
				<li class="list-group-header">
					<liferay-ui:message key="<%= DaySegments.getLabel(daySegment) %>" />
				</li>

				<%
				if (!dataEventsMap.containsKey(daySegment)) {
					continue;
				}

				for (DataEvent dataEvent : dataEventsMap.get(daySegment)) {
				%>

					<li class="list-group-item py-0">
						<%= dataEvent.getSummary() %>
					</li>

			<%
				}
			}
			%>

			</ul>
		</clay:sheet>
	</div>

	<div class="col-md-7">
		<clay:tabs
			tabsItems="<%= homeDisplayContext.getTabsItems() %>"
		>
			<clay:tabs-panel>
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

							<aui:select helpMessage="Early Morning:12am-6am Morning:6am-12pm Afternoon:12pm-6pm Night:6pm-12am" id="occurDaySegment" label="day-segment" name="occurDaySegment">

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
			</clay:tabs-panel>

			<clay:tabs-panel>
				<portlet:actionURL name="/tokogae/edit_symptom" var="editSymptomURL" />

				<liferay-frontend:edit-form
					action="<%= editSymptomURL %>"
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

							<aui:select helpMessage="Early Morning:12am-6am Morning:6am-12pm Afternoon:12pm-6pm Night:6pm-12am" id="occurDaySegment" label="day-segment" name="occurDaySegment">

								<%
								for (int daySegment : DaySegments.VALUES) {
								%>

									<aui:option label="<%= DaySegments.getLabel(daySegment) %>" value="<%= daySegment %>" />

								<%
								}
								%>

							</aui:select>

							<aui:input name="name" />

							<aui:input name="affectedArea" />

							<aui:select label="intensity" name="intensityLevel">

								<%
								for (int intensityLevel : IntensityLevels.VALUES) {
								%>

									<aui:option label="<%= IntensityLevels.getLabel(intensityLevel) %>" value="<%= intensityLevel %>" />

								<%
								}
								%>

							</aui:select>
						</liferay-frontend:fieldset>
					</liferay-frontend:edit-form-body>

					<liferay-frontend:edit-form-footer>
						<liferay-frontend:edit-form-buttons />
					</liferay-frontend:edit-form-footer>
				</liferay-frontend:edit-form>
			</clay:tabs-panel>
		</clay:tabs>
	</div>
</div>