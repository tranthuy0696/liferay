<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
String searchDate = ParamUtil.getString(request, "date");
%>

