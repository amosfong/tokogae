<%--
/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
EditDataEventDisplayContext editDataEventDisplayContext = (EditDataEventDisplayContext)request.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);
%>

<div class="row">
	<div class="col-md-2">
		<liferay-util:include page="/sidebar.jsp" servletContext="<%= application %>" />
	</div>

	<div class="col-md-10">
		<portlet:actionURL name="/tokogae/edit_data_event" var="editDataEventURL" />

		<liferay-frontend:edit-form
			action="<%= editDataEventURL %>"
			enctype="multipart/form-data"
			method="post"
			name="fm1"
		>
			<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
			<aui:input name="redirect" type="hidden" value='<%= ParamUtil.getString(request, "redirect") %>' />

			<aui:select label="event-type" name="className" onChange="window.location = event.target[event.target.selectedIndex].getAttribute('data-url')">

				<%
				for (String className : editDataEventDisplayContext.getDataEventClassNames()) {
				%>

					<aui:option data-url="<%= editDataEventDisplayContext.getEditDataEventURL(className) %>" label="<%= editDataEventDisplayContext.getLabel(className) %>" selected="<%= editDataEventDisplayContext.isClassName(className) %>" useModelValue="<%= false %>" value="<%= className %>" />

				<%
				}
				%>

			</aui:select>

			<liferay-frontend:edit-form-body>
				<liferay-frontend:fieldset
					collapsed="<%= false %>"
					collapsible="<%= false %>"
					label="date"
				>
					<aui:input name="occurDay" value="<%= editDataEventDisplayContext.getCurrentOccurDay() %>" />

					<aui:select helpMessage="Early Morning:12am-6am Morning:6am-12pm Afternoon:12pm-6pm Night:6pm-12am" id="occurDaySegment" label="day-segment" name="occurDaySegment">

						<%
						for (int daySegment : DaySegments.VALUES) {
						%>

							<aui:option label="<%= DaySegments.getLabel(daySegment) %>" value="<%= daySegment %>" />

						<%
						}
						%>

					</aui:select>
				</liferay-frontend:fieldset>

				<liferay-frontend:fieldset
					collapsed="<%= false %>"
					collapsible="<%= true %>"
					label="details"
				>
					<c:choose>
						<c:when test="<%= editDataEventDisplayContext.isExerciseEvent() %>">
							<aui:input name="name" />

							<aui:input name="duration" />

							<aui:select id="quantityUnit" label="quantity-unit" name="quantityUnit">

								<%
								for (String quantityUnit : QuantityUnits.EXERCISE_VALUES) {
								%>

									<aui:option label="<%= quantityUnit %>" value="<%= quantityUnit %>" />

								<%
								}
								%>

							</aui:select>

							<aui:input name="quantity" value="1" />
						</c:when>
						<c:when test="<%= editDataEventDisplayContext.isFoodItemEvent() %>">
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
						</c:when>
						<c:when test="<%= editDataEventDisplayContext.isSleepEvent() %>">
							<aui:input name="duration" />
						</c:when>
						<c:when test="<%= editDataEventDisplayContext.isSymptomEvent() %>">
							<aui:input name="duration" />

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
						</c:when>
					</c:choose>
				</liferay-frontend:fieldset>
			</liferay-frontend:edit-form-body>

			<liferay-frontend:edit-form-footer>
				<liferay-frontend:edit-form-buttons />
			</liferay-frontend:edit-form-footer>
		</liferay-frontend:edit-form>
	</div>
</div>

<aui:script>
	Liferay.provide(
		window,
		'<portlet:namespace />toggleField',
		function(fieldId, disabled) {
			var field = AUI().one('#<portlet:namespace />' + fieldId);

			field.attr('disabled', disabled);

			if (disabled) {
				field.addClass('disabled');
			}
			else {
				field.removeClass('disabled');
			}

			var label = field.attr('labels').first();

			if (label) {
				if (disabled) {
					label.addClass('disabled');
				}
				else {
					label.removeClass('disabled');
				}
			}
		},
		['aui-base']
	);

	Liferay.provide(
		window,
		'<portlet:namespace />toggleExtended',
		function(checked) {
			<portlet:namespace />toggleField('symptomOccurDay', checked);
			<portlet:namespace />toggleField('symptomOccurDaySegment', checked);

			<portlet:namespace />toggleField('startDate', !checked);
			<portlet:namespace />toggleField('endDate', !checked);
		},
		['aui-base']
	);
</aui:script>