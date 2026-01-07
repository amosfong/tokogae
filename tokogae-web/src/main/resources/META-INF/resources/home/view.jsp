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

			List<DataEvent> ongoingDataEvents = dataEventsMap.get(DaySegments.NONE);
			%>

			<c:if test="<%= ongoingDataEvents != null %>">
				<ul class="list-group">
					<li class="list-group-header">
						<liferay-ui:message key="ongoing-events" />
					</li>

					<%
					for (DataEvent dataEvent : ongoingDataEvents) {
					%>

						<li class="list-group-item py-0">
							<%= dataEvent.getSummary() %>
						</li>

					<%
					}
					%>

				</ul>
			</c:if>

			<%
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

						<liferay-ui:icon
							icon="pencil"
							url="<%= homeDisplayContext.getEditDataEventURL(dataEvent) %>"
						/>
					</li>

			<%
				}
			}
			%>

			</ul>
		</clay:sheet>
	</div>

	<div class="col-md-7">
		<p>
			<aui:a href="<%= homeDisplayContext.getEditDataEventURL(Exercise.class.getName()) %>"><%= homeDisplayContext.getAddLabel(Exercise.class.getName()) %></aui:a>
		</p>

		<p>
			<aui:a href="<%= homeDisplayContext.getEditDataEventURL(FoodItem.class.getName()) %>"><%= homeDisplayContext.getAddLabel(FoodItem.class.getName()) %></aui:a>
		</p>

		<p>
			<aui:a href="<%= homeDisplayContext.getEditDataEventURL(Sleep.class.getName()) %>"><%= homeDisplayContext.getAddLabel(Sleep.class.getName()) %></aui:a>
		</p>

		<p>
			<aui:a href="<%= homeDisplayContext.getEditDataEventURL(Symptom.class.getName()) %>"><%= homeDisplayContext.getAddLabel(Symptom.class.getName()) %></aui:a>
		</p>
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