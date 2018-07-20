<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@include file="init.jsp" %>
<%@ page pageEncoding="UTF-8"%>

<%
SearchContainer searchContainer = (SearchContainer)request.getAttribute("liferay-ui:search:searchContainer");
DisplayTerms displayTerms = searchContainer.getDisplayTerms();
%>
<liferay-ui:search-toggle buttonLabel="Employee Search" displayTerms="<%= displayTerms %>" id="toggle_id_employee_search">
<aui:input label="Date" name="date" placeholder="yyyy-mm-dd hh:mm:ss.s"/> <!-- If Id = 0 then set blank in field -->
</liferay-ui:search-toggle>