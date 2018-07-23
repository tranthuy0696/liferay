<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.util.Portal"%>
<%@page import="com.nlu.util.SystemUtil"%>
<%@include file="init.jsp"%>
<%@ page pageEncoding="UTF-8"%>
<portlet:resourceURL id="resetAlarm" var="resetAlarm"></portlet:resourceURL>
<%
SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>
<style>
.chart{
hieght:500px;}
</style>
<!-- <div class="container"> -->
		<!-- 	menu -->
		<div class="wholepage">
	<jsp:include page="menu.jsp"></jsp:include>

	<div class="main">
		<jsp:include page="notify.jsp"></jsp:include>
		<div class="container">
        <div class="content">
        	<%HttpServletRequest hsr=PortalUtil.getHttpServletRequest(renderRequest);
        	String time=hsr.getParameter("time");
        	String name=hsr.getParameter("nameAlarm");
        	String value=hsr.getParameter("value");
        	%>
        	<h2 class="text-center"><%=df.format(new Date(Long.parseLong(time))) %></h2>
        	<aui:input type="hidden" value="<%=time%>" name="time"></aui:input>
        	<aui:input type="hidden" value="<%=name%>" name="name"></aui:input>
        	<aui:input type="hidden" value="<%=value%>" name="value"></aui:input>
        	<div class="row">
        	<div class="span1"><label>Xem thêm: </label></div>
			<div class="span2">
			<%if(name !="Memory"){ %>
			<label>Memory </label><input type="checkbox" name="checkRam" id="checkRam">
			</div>
			<%} %>
			<%if(!name.equals("Cpu")){ %>
			<div class="span2">
			<label>Cpu </label><input type="checkbox" name="cpu" id="checkCpu">
			</div>
			<%} %>
			<%if(name !="Heap"){ %>
			<div class="span2">
			<label>Heap </label><input type="checkbox" name="heap" id="checkHeap">
			</div>
			<%} %>
			<%if(name !="Non-Heap"){ %>
			<div class="span2">
			<label>Non-Heap </label><input type="checkbox" name="nonheap" id="checkNonHeap">
			</div>
			<%} %>
			<%if(name !="Session-Request"){ %>
			<div class="span2">
			<label>Session Request </label><input type="checkbox" name="session" id="checkSession">
			</div>
			<%} %>
        	</div>
        	
        	
        	
        	<div class="row chart">
        	
        	</div>
        </div>
        </div>
	</div>
		</div>
		
<script>
   $(document).ready(function(){
	   var value;
	   var time = $("#<portlet:namespace />time").val();
		 var name = $("#<portlet:namespace />name").val();
		 var value = $("#<portlet:namespace />value").val();
		AUI().use('aui-io-request', function(A) {
			A.io.request('${resetAlarm}', {
				method : 'get',
				dataType : 'json',
				data : {
					<portlet:namespace />time : time,
					<portlet:namespace />name : name
				},
				on : {
					success : function(A, id, obj) {
						dataChart=[];
						dataChart.push(Number(value));
						cate=[];
						cate.push(name);
						$('.chart').append('<div id="'+name+'"></div>');
						Highcharts.chart(name, {
					    	 
					        chart: {
					          marginBottom: 120,
					          reflow: false,
					          marginLeft: 50,
					          marginRight: 20,
					           zoomType: 'x',
					        },
					        credits: {
					          enabled: false
					        },
					        title: {
					          text: name+' Usage Alarm'
					        },
					        subtitle: {
					          text: ''
					        },
					        xAxis: {
//				 	          type: 'datetime',
				               categories: [name],
									title: {
				                            text: name
				                        },
				                        labels: {
				                         enabled:false,
				                        }
					        },
					        yAxis: {
					          title: {
					            text: null
					          },
					          labels: {
					              format: '{value}'
					            },
					          min:0,
					          maxZoom: 0.1,
					            plotLines: [{
					      value: 0,
					      width: 1,
					      color: '#808080'
					    }]
					        },
					        
					    tooltip: {
					    	shared: true
					  },
					  legend: {
						  enabled: false
					  },
					        plotOptions: {
					        area: {
					          marker: {
					            radius: 2
					          },
					          lineWidth: 1,
					          states: {
					            hover: {
					              lineWidth: 1
					            }
					          },
					          threshold: null
					        }
					      },
					        series: [{
					          type: 'column',
					          name: name,
					          data: dataChart,
					          lineColor: Highcharts.getOptions().color="rgba(62,179,220,1)",
					          color: Highcharts.getOptions().color="rgba(62,179,220,1)",
					        }],

					        exporting: {
					          enabled: false
					        }

					      });
					}
				}
			});
   });
	
   });
</script>