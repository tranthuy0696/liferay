

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<portlet:defineObjects />
<%@ page pageEncoding="UTF-8"%>
<portlet:renderURL var="memoryURL">
	<portlet:param name="mvcPath" value="/html/systemresource/view.jsp" />
</portlet:renderURL>
<portlet:renderURL var="cpuURL">
	<portlet:param name="mvcPath" value="/html/systemresource/cpu.jsp" />
</portlet:renderURL>
<portlet:renderURL var="heapURL">
	<portlet:param name="mvcPath" value="/html/systemresource/heap.jsp" />
</portlet:renderURL>
<portlet:renderURL var="nonheapURL">
	<portlet:param name="mvcPath" value="/html/systemresource/nonheap.jsp" />
</portlet:renderURL>
<portlet:renderURL var="sessionrequestURL">
	<portlet:param name="mvcPath" value="/html/systemresource/sessionrequest.jsp" />
</portlet:renderURL>
<portlet:renderURL var="directoryURL">
	<portlet:param name="mvcPath" value="/html/systemresource/directory.jsp" />
</portlet:renderURL>
<portlet:renderURL var="networkURL">
	<portlet:param name="mvcPath" value="/html/systemresource/network.jsp" />
</portlet:renderURL>
<portlet:renderURL var="reportURL">
	<portlet:param name="mvcPath" value="/html/systemresource/report.jsp" />
</portlet:renderURL>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"  href="<%=request.getContextPath()%>/css/styleside.css">
<div class="menu">
<ul>
   <li><a href="${memoryURL}">MEMORY</a></li>
    <li><a href="${cpuURL}">CPU</a></li>
    <li><a href="${heapURL}">HEAP</a></li>
    <li><a href="${nonheapURL}">NON-HEAP</a></li>
    <li><a href="#">Ổ ĐĨA</a></li>
    <li><a href="${sessionrequestURL}">SESSION REQUEST</a></li>
    <li><a href="${networkURL}">NETWORK</a></li>
    <li><a href="${directoryURL}">THƯ MỤC</a></li>
     <li><a href="${reportURL}">THỐNG KÊ</a></li>
</ul>
  </div>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
  		


<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>