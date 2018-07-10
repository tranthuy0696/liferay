<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.Collections"%>
<%@page import="com.nlu.entity.model.SessionRequest"%>
<%@page import="java.util.List"%>
<%@page import="com.nlu.entity.service.SessionRequestLocalServiceUtil"%>
<%@include file="init.jsp"%>

<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<%@ page pageEncoding="UTF-8"%>
<style type="text/css">
html, body {
	height: 100%;
}

.row {
	height: 100%;
}

#columnchart_material div {
	height: 90%;
}
div#menu {
	margin-left: 1.5%;
}

canvas#browser {
    height: 400px !important;
}

canvas#login{
    height: 400px !important;
}

canvas#os {
    height: 400px !important;
}
</style>
<portlet:resourceURL id="sessionRequestReport" var="sessionRequestReport"></portlet:resourceURL>
<portlet:resourceURL id="sessionrequest" var="memoryAjax"></portlet:resourceURL>
<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/html/systemresource/sessionrequest.jsp" />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL varImpl="searchURL">
    <portlet:param name="mvcPath" value="/html/systemresource/sessionrequest.jsp" />
</liferay-portlet:renderURL>
		<!-- 	menu -->
			<jsp:include page="menu.jsp"></jsp:include>

			<div class="tabbable">
				<!-- Only required for left/right tabs -->
				<ul class="nav nav-tabs" id="tab-nav">
					<li class="active"><a href="#tab1" data-toggle="tab">Thực
							tế</a></li>
					<li><a href="#tab2" data-toggle="tab">Thống kê</a></li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane active" id="tab1">
					<div class="chart-container" style="position: relative;height:70vh; width:76vw">
    					<canvas id="myChart" width="493" height="220" style="display: block; width: 493px; height: 220px;">
    					</canvas>
  				   </div>
					<div>
					<h3 class="text-center" id="memoryUsage"></h3>
					</div>
					</div>
					<div class="tab-pane" id="tab2">
<!-- 					Thong ke 7 ngay -->
<div>

<div class="text-center">
					<aui:select name="dateType" label="Chọn ngày" id="chonNgay">
						<aui:option label="Ngày hiện tại" value="TODAY" selected="true" />
						<aui:option label="1 ngày trước" value="ONE_DATE_AGO" />
						<aui:option label="2 ngày trước" value="TWO_DATE_AGO" />
						<aui:option label="3 ngày trước" value="THREE_DATE_AGO" />
						<aui:option label="4 ngày trước" value="FOUR_DATE_AGO" />
						<aui:option label="5 ngày trước" value="FIVE_DATE_AGO" />
						<aui:option label="6 ngày trước" value="SIX_DATE_AGO" />
					</aui:select>
</div>
<div id="date" class="text-center" style="font-size:20px"></div>
<br>
<!-- browser -->
<div class="row">
				<div class="span4">
<!--     					<div class="chart-container" style="height:70vh; width:76vw"> -->
    					<canvas id="browser" style="width: 90%; height: 400px">
    					</canvas>
<!--   				   </div> -->
</div>
<div class="span4">
<!--     					<div class="chart-container" style="height:70vh; width:76vw"> -->
    					<canvas id="login" style="width: 90%; height: 400px">
    					</canvas>
<!--   				   </div> -->
</div>

<div class="span4">
<!--     					<div class="chart-container" style="height:70vh; width:76vw"> -->
    					<canvas id="os" style="width: 90%; height: 400px">
    					</canvas>
<!--   				   </div> -->
    					</div>
</div>
<br>
</div>
					<div>
					<aui:form action="<%=searchURL %>" method="post" name="fm">
					<liferay-portlet:renderURLParams varImpl="searchURL" />
						<liferay-ui:search-container delta="10" displayTerms="<%= new DisplayTerms(renderRequest) %>" deltaConfigurable="true" emptyResultsMessage="Sorry. There are no record to display." iteratorURL="<%=iteratorURL %>">
	<liferay-ui:search-form page="/html/systemresource/search.jsp" servletContext="<%= application %>" />
<%-- 	<liferay-ui:search-container-results --%>
<%-- 		results="<%= SessionRequestLocalServiceUtil.getSessionRequests(searchContainer.getStart(), searchContainer.getEnd()) %>" --%>
<%-- 		total="<%= SessionRequestLocalServiceUtil.getSessionRequestsCount() %>" --%>
<%-- 	/> --%>
<liferay-ui:search-container-results>

<%
DisplayTerms displayTerms =searchContainer.getDisplayTerms();
String keywords = displayTerms.getKeywords(); 
List<SessionRequest> sessionRequestList =  Collections.EMPTY_LIST;
if (displayTerms.isAdvancedSearch()) {//Advance Search
	System.out.println("search");
System.out.println("search date"+searchDate);
	sessionRequestList = SessionRequestLocalServiceUtil.searchSessionRequestByDate(searchDate);
	searchContainer.setTotal(sessionRequestList.size());
	searchContainer.setResults(ListUtil.subList(sessionRequestList,searchContainer.getStart(),searchContainer.getEnd()));
} 
else if(!Validator.isBlank(keywords)){//Basic Search
	sessionRequestList = SessionRequestLocalServiceUtil.searchSessionRequestByDate(keywords);
	searchContainer.setTotal(sessionRequestList.size());
	searchContainer.setResults(ListUtil.subList(sessionRequestList,searchContainer.getStart(),searchContainer.getEnd()));
}
else{//No Search
	System.out.println("no search");
	 sessionRequestList = SessionRequestLocalServiceUtil.getSessionRequests(0, SessionRequestLocalServiceUtil.getSessionRequestsCount());
	 searchContainer.setTotal(sessionRequestList.size());		 
	 searchContainer.setResults(ListUtil.subList(sessionRequestList,searchContainer.getStart(),searchContainer.getEnd()));
}
%>
  
</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.nlu.entity.model.SessionRequest"
		modelVar="aSessionRequest" indexVar="i"
	>
	<liferay-ui:search-container-column-text name="#"><%=i+1%></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text property="sessionId" name="Session Id"/>
		<liferay-ui:search-container-column-text property="ip" name="IP"/>
		<liferay-ui:search-container-column-text property="browser" name="Browser"/>


		<liferay-ui:search-container-column-text name="Trạng thái" value='<%=(aSessionRequest.isLogin()==false?"Logout":"Login")%>'/>

		<liferay-ui:search-container-column-text property="os" name="Hệ điều hành"/>


		<liferay-ui:search-container-column-text property="time" name="Thời gian"/>

		
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
</aui:form>
<!-- ket thuc thong ke 7 ngay -->
</div>
<!-- thong ke theo ngay -->



</div>
					</div>
				</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
<script>
	window.onload = function() {
	var loginBefore=0;
	var logoutBefore=0;
		var ctx=document.getElementById("myChart").getContext("2d");
		var data = {
			    labels: [
			        "Number session login",
			        "Number session logout"
			    ],
			    datasets: [
			        {
			            data: [loginBefore,logoutBefore],
			            backgroundColor: [
			                "#FD7F23",
			                "#399F34"
			            ]
			        }]
			};
		  var options={ 
			      responsive: true,
			                legend: {
			                    position: 'right',
			                },
			      
			    title: {
			      display: true,
			      text: 'Session request',
			    },

			  };
		var myChart=new Chart(ctx, {
	  type: 'pie',data: data, options: options
	  
	});
		getRealtime();
		function getRealtime(){
		var updateInterval = 1000;
		var getSessionRequest = function() {
			var sessionRequest = 0;
			AUI().use('aui-io-request', function(A) {
				A.io.request('${memoryAjax}', {
					method : 'post',
					on : {
						success : function(A, id, obj) {
							sessionRequest = JSON.parse(obj.responseText);
							if(loginBefore!=sessionRequest.numberLogin || logoutBefore !=sessionRequest.numberLogout){
							data.datasets[0].data.push(sessionRequest.numberLogin);
							data.datasets[0].data.push(sessionRequest.numberLogout);
						    data.datasets[0].data.shift();
						    data.datasets[0].data.shift();
						    loginBefore=sessionRequest.numberLogin;
						    logoutBefore=sessionRequest.numberLogout;
						    var myChart= new Chart(ctx, {type: 'pie',
								  data:data, options:options
								  
								});
							}
						}
					}
				});
			});
		}
		
		var updateChart = function() {
			getSessionRequest();
			


		};
 		setInterval(function() {
 			updateChart();
 		}, updateInterval);
		}
		var ctxBrowser=document.getElementById("browser").getContext("2d");
		var ctxOs=document.getElementById("os").getContext("2d");
		var ctxLogin=document.getElementById("login").getContext("2d");
		function getReport(){
			 var selectedDate = $("#<portlet:namespace />chonNgay option:selected").val();
			 AUI().use('aui-io-request', function(A) {
			 A.io.request('${sessionRequestReport}', {
					method : 'get',
					data : {
						<portlet:namespace />dateType : selectedDate
					},
					dataType : 'json',
					on : {
						success : function(A, id, obj) {
							sessionReport = JSON.parse(obj.responseText);
							console.log(sessionReport);
							$('#date').html('Ngày: '+sessionReport.date);
							browser=sessionReport.listBrowser;
							login=sessionReport.listLoginOut;
							os=sessionReport.listOs;
								lableBrowsers=[];
								dataBrowsers=[];
								lableLogins=[];
								dataLogins=[];
								lableOs=[];
								dataOs=[];
							$.each(browser, function (i) {
								lableBrowsers.push(browser[i].name);
								dataBrowsers.push(browser[i].number);
							});
							console.log(lableBrowsers);
							console.log(dataBrowsers);
							$.each(login, function (i) {
								lableLogins.push((login[i].name=="f")?"Logout":"Login");
								dataLogins.push(login[i].number);
							});
							$.each(os, function (i) {
								lableOs.push(os[i].name);
								dataOs.push(os[i].number);
							});
							var myBrowser=new Chart(ctxBrowser, {
								  type: 'pie',data: {
									    labels: lableBrowsers,
											    datasets: [
											        {
											            data: dataBrowsers,
											            backgroundColor: [ "#FD7F23", "#399F34","#2679B2","#FCBE75","#8E5EA2","#E01F27","#A7CEE2","#F99B9B"]
											        }
											        ]
											}, options: { 
// 											      responsive: true,
											      maintainAspectRatio: false,
									                legend: {
									                    position: 'bottom',
									                },
									      
									    title: {
									      display: true,
									      text: 'Web browser',
									      fontSize: 18
									                
									    },

									  }
								  
								});
							// Change the display size
							var myLogin=new Chart(ctxLogin, {
								  type: 'pie',data: {
									    labels: lableLogins,
											    datasets: [
											        {
											            data: dataLogins,
											            backgroundColor: ["#2679B2","#FCBE75","#8E5EA2", "#FD7F23", "#399F34","#E01F27","#A7CEE2","#F99B9B"]
											        }]
											}, options: { 
// 											      responsive: true,
											      maintainAspectRatio: false,
									                legend: {
									                    position: 'bottom',
									                },
									      
									    title: {
									      display: true,
									      text: 'Trạng thái',
									      fontSize: 18
									    },

									  }
								  
								});
							var myOs=new Chart(ctxOs, {
								  type: 'pie',data: {
									    labels: lableOs,
											    datasets: [
											        {
											            data: dataOs,
											            backgroundColor: ["#8E5EA2","#E01F27","#A7CEE2", "#FD7F23", "#399F34","#2679B2","#F99B9B","#FCBE75"]
											        }]
											}, options: { 
// 											      responsive: true,
											      maintainAspectRatio: false,
									                legend: {
									                    position: 'bottom',
									                },
									      
									    title: {
									      display: true,
									      text: 'Hệ điều hành',
									      fontSize: 18
									    },

									  }
								  
								});
							
						}
					}
				});
		});
		}
		$('#tab-nav').click(function(){
			 $('a[data-toggle="tab"]').on('shown.bs.tab', function(e){
				 var target=$(e.target).attr("href");
				  //realtime
				  if(target=='#tab1'){
					  getRealtime();
				  }
				  else{
					  getReport();
				  }
			 });
		});
	$("#<portlet:namespace />chonNgay").change(function () {  
		getReport();
	
	
	});
		
	}
</script>
