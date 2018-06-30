<%@ include file="/html/alarm/init.jsp"%>
<%@ page pageEncoding="UTF-8"%>
<portlet:actionURL name="getApi" var="actionURLByPortletTagURL3">
</portlet:actionURL>
<form action="${actionURLByPortletTagURL3}" method="post">
	<input type="submit" value="getAPI">
</form>
<portlet:actionURL name="getUrl" var="actionURLByPortletTagURLRam">
</portlet:actionURL>
<form action="${actionURLByPortletTagURLRam}" method="post">
	<input type="submit" value="getRam">
</form>