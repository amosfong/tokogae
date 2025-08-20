<%--
/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */
--%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/clay" prefix="clay" %><%@
taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %><%@
taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="com.liferay.petra.string.StringPool" %><%@
page import="com.liferay.portal.kernel.dao.search.ResultRow" %><%@
page import="com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder" %><%@
page import="com.liferay.portal.kernel.util.Constants" %><%@
page import="com.liferay.portal.kernel.util.ParamUtil" %><%@
page import="com.liferay.portal.kernel.util.WebKeys" %>

<%@ page import="com.tokogae.account.model.Subject" %><%@
page import="com.tokogae.constants.DaySegments" %><%@
page import="com.tokogae.constants.IntensityLevels" %><%@
page import="com.tokogae.constants.QuantityUnits" %><%@
page import="com.tokogae.data.event.model.DataEvent" %><%@
page import="com.tokogae.web.internal.constants.TokogaeWebKeys" %><%@
page import="com.tokogae.web.internal.display.context.HomeDisplayContext" %><%@
page import="com.tokogae.web.internal.display.context.SubjectsDisplayContext" %><%@
page import="com.tokogae.web.internal.display.context.SubjectsToolbarDisplayContext" %>

<%@ page import="jakarta.portlet.PortletURL" %>

<%@ page import="java.util.List" %><%@
page import="java.util.Map" %>

<liferay-frontend:defineObjects />

<liferay-theme:defineObjects />

<portlet:defineObjects />