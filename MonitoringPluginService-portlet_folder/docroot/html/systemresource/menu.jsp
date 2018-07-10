

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
<portlet:renderURL var="reportURL">
	<portlet:param name="mvcPath" value="/html/systemresource/directory.jsp" />
</portlet:renderURL>
<portlet:renderURL var="networkURL">
	<portlet:param name="mvcPath" value="/html/systemresource/network.jsp" />
</portlet:renderURL>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
  body {
    margin: 0;
    font-family: Arial, Helvetica, sans-serif;
  }

  .topnav {
    overflow: hidden;
    background-color: #fff;
    border-bottom: 1px solid #ddd;
    width: 100%;
    box-shadow: 0px 3px 3px #F0F3F5;
    margin-bottom: 10px;
  }
 
  .topnav a {
    float: left;
    display: block;
    color: #000;
    text-align: center;
    padding: 18px 20px;
    text-decoration: none;
    font-size: 15px;
  }

  .topnav a:hover {
    background-color: #22A8E2;
    color: white;
    text-decoration: none;
  }

/*   .active { */
/*     background-color: #22A8E2; */
/*     color: white; */
/*   } */

  .topnav .icon {
    display: none;
  }

  @media screen and (max-width: 600px) {
    .topnav a:not(:first-child) {display: none;}
    .topnav a.icon {
      float: right;
      display: block;
    }
  }

  @media screen and (max-width: 600px) {
    .topnav.responsive {position: relative;}
    .topnav.responsive .icon {
      position: absolute;
      right: 0;
      top: 0;
    }
    .topnav.responsive a {
      float: none;
      display: block;
      text-align: left;
    }
  }
  </style>
	<div class="topnav" id="myTopnav">
    <a href="${memoryURL}">MEMORY</a>
    <a href="${cpuURL}">CPU</a>
    <a href="${heapURL}">HEAP</a>
    <a href="${nonheapURL}">NON-HEAP</a>
    <a href="#">Ổ ĐĨA</a>
    <a href="${sessionrequestURL}">SESSION REQUEST</a>
    <a href="${networkURL}">NETWORK</a>
    <a href="${reportURL}">THƯ MỤC</a>
    <a href="javascript:void(0);" class="icon" onclick="myFunction()">
      <i class="fa fa-bars"></i>
    </a>
  </div>
  
   <script>
  function myFunction() {
      var x = document.getElementById("myTopnav");
      if (x.className === "topnav") {
          x.className += " responsive";
      } else {
          x.className = "topnav";
      }
  }
  </script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
  
<script src="https://www.amcharts.com/lib/3/amcharts.js"></script>
<script src="https://www.amcharts.com/lib/3/serial.js"></script>
<script src="https://www.amcharts.com/lib/3/plugins/export/export.min.js"></script>
<link rel="stylesheet" href="https://www.amcharts.com/lib/3/plugins/export/export.css" type="text/css" media="all" />
<script src="https://www.amcharts.com/lib/3/themes/light.js"></script>