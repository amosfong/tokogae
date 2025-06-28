<%--
/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<portlet:actionURL name="/tokogae/edit_subject" var="editSubjectURL" />

<liferay-frontend:edit-form
	action="<%= editSubjectURL %>"
	enctype="multipart/form-data"
	method="post"
	name="fm"
>
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value='<%= ParamUtil.getString(request, "redirect") %>' />

	<liferay-frontend:edit-form-body>
		<aui:model-context bean="<%= (Subject)request.getAttribute(TokogaeWebKeys.SUBJECT) %>" model="<%= Subject.class %>" />

		<liferay-frontend:fieldset
			collapsed="<%= false %>"
			collapsible="<%= true %>"
			label="details"
		>
			<aui:input cssClass="lfr-input-text-container" name="firstName" />

			<aui:input cssClass="lfr-textarea-container" name="lastName" />

			<aui:input cssClass="lfr-textarea-container" name="displayName" />
		</liferay-frontend:fieldset>
	</liferay-frontend:edit-form-body>

	<liferay-frontend:edit-form-footer>
		<liferay-frontend:edit-form-buttons />
	</liferay-frontend:edit-form-footer>
</liferay-frontend:edit-form>