<%--
/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
PortletURL viewSubjectsURL = PortletURLBuilder.createRenderURL(
	renderResponse
).setMVCRenderCommandName(
	"/tokogae/subjects"
).buildPortletURL();
%>

<div class="row">
	<div class="col-md-3">
		<liferay-util:include page="/sidebar.jsp" servletContext="<%= application %>" />
	</div>

	<div class="col-md-9">

	</div>
<hr />

<h1 style="font-family: cursive; font-size: 50px; text-align: center;">
	Tree of Knowledege of Good and Evil
</h1>

<p>
	The Lord God took the man and put him in the garden of Eden to work it and keep it. And the Lord God commanded the man, saying, "You may surely eat of every tree of the garden, but of the tree of the knowledge of good and evil you shall not eat, for in the day that you eat of it you shall surely die."
</p>

<p>
	But the serpent said to the woman, "You will not surely die. For God knows that when you eat of it your eyes will be opened, and you will be like God, knowing good and evil."
</p>

<div style="text-align: right;">
	Genesis 2:15-17, 3:4-5
</div>

<hr />

<pre style="font-weight: bold; margin-left: 35%;">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;#####&nbsp;######&nbsp;###
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;####&nbsp;\/#|#@#&nbsp;|/####
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;#@##\/#/&nbsp;\||/##/_/@#/##
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;###@\&nbsp;\/#@#|/&nbsp;\/&nbsp;#&nbsp;###-##
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;##_\_#\_\##&nbsp;|&nbsp;#/#@#_/_###
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;#&nbsp;####&nbsp;#&nbsp;\&nbsp;/|&nbsp;/&nbsp;&nbsp;####-##
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;#@--@##`\&nbsp;|/,#@-@#-#@#-&nbsp;&nbsp;&nbsp;.o_,
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-#@###&nbsp;\|||/&nbsp;##@#--#--&nbsp;&nbsp;/
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|||&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\--
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|||
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|||
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/|||\
._..,..|/.,.\..,.-\\./-/\..,@.\|/.,@..,.,\/
</pre>

<hr />

<a href="<%= viewSubjectsURL.toString() %>">View Subjects</a>