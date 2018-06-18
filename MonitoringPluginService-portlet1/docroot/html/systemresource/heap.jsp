<%@page import="com.nlu.util.SystemUtil"%>
<%@include file="init.jsp"%>
<%@ page pageEncoding="UTF-8"%>


<%
   double maxHeapMB = SystemUtil.convertByteToMB(SystemUtil.getMaxHeapMemory());
%>
<portlet:resourceURL id="heap" var="memoryAjax"></portlet:resourceURL>
<div class="container">
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
						<aui:select name="dateType" label="Chọn ngày" id="chonNgay">
						<aui:option label="Ngày hiện tại" value="TODAY" selected="true" />
						<aui:option label="1 ngày trước" value="ONE_DATE_AGO" />
						<aui:option label="2 ngày trước" value="TWO_DATE_AGO" />
						<aui:option label="3 ngày trước" value="THREE_DATE_AGO" />
						<aui:option label="4 ngày trước" value="FOUR_DATE_AGO" />
						<aui:option label="5 ngày trước" value="FIVE_DATE_AGO" />
						<aui:option label="6 ngày trước" value="SIX_DATE_AGO" />
					</aui:select>
						<div class="chart-container" style="position: relative;height:70vh; width:76vw">
    					<canvas id="report" width="493" height="220" style="display: block; width: 493px; height: 220px;">
    					</canvas>
  				 	   </div>
					</div>
				</div>
			</div>
		</div>
<script>
	window.onload = function() {
		var dpss = [];
		var lable = [];
		//dataPoints. 
		for (var i = 0; i < 60; i++) {
			dpss.push(0);
			lable.push(i);
		}
		var ctx=document.getElementById("myChart").getContext("2d");
	    var data={
	    labels: lable,
	    datasets: [{ 
	        data: dpss,
	        label: "Memory",
	          yAxisID: '1',
	          borderColor: "rgba(62,179,220,1)",
	          backgroundColor: "rgba(62,179,220,0.2)",
	          pointBackgroundColor: "rgba(62,179,220,1)",
	          pointBorderColor:"#fff",
	    
	      },
	      { 
	        label: "Africa",
	          yAxisID: '2',
	      }
	    ]
	  };
	  var options={  elements:{
      point: {radius: 0, hoverRadius: 5,hitRadius: 5,borderColor:  'rgba(0,0,0,0.1)', backgroundColor: 'rgb(255, 255, 255)'}
      },
	     animation: false,
	      responsive: true,
	                legend: {
	                    //position: 'bottom',
	                    display: false,
	                },
	       scales: {
	                    xAxes: [{
	                            display: true,
	                            xScaleSteps: 20,
	                            scaleLabel: {
	                                display: true,
	                                xScaleStepWidth: 20,
	                                labelString: '60s'
	                            },
	                            ticks: {
	                                beginAtZero: true,
	                                stepSize: 20,
	                                autoSkip: true,
	                                autoSkipPadding: 20
	                            
	                            }
	                        }],
	                    yAxes: [{
	                             id: '1',
	                            display: true,
	                            position: "left",
	                             scaleLabel: {
	                                display: true,
	                                labelString: 'Heap usage(%)'
	                            },
	                            ticks: {
	                                beginAtZero: true,
	                                stepSize: 20,
	                                max: 100
	                            }
	                        },
	                        {
	                             id: '2',
	                             position: "right",
	                            display: true,
	                             scaleLabel: {
	                                display: true,
	                                labelString: 'Heap usage(MB)'
	                            },
	                            ticks: {
	                                beginAtZero: true,
	                                max: <%=maxHeapMB%>,
	                                autoSkip: true,
	                            },
	                            gridLines:{
	                            	display: false
	                            }
	                        }]
	                },
	    title: {
	      display: true,
	      text: 'Heap',
	    },

	  };
		var myChart=new Chart(ctx, {
	  type: 'line',data: data, options:options
	  
	});
		var updateInterval = 1000;
		var getMemory = function() {
			var memory = 0;
			AUI().use('aui-io-request', function(A) {
				A.io.request('${memoryAjax}', {
					method : 'post',
					on : {
						success : function(A, id, obj) {
							memory = JSON.parse(obj.responseText);
							
							   $('#memoryUsage').text('Heap Usage: '+ memory.percentUsage +'% ('+memory.dataUsage+' MB)');
							data.datasets[0].data.push(Math.round(memory.percentUsage));
						     data.datasets[0].data.shift();
						}
					}
				});
			});
		}
		
		var updateChart = function() {
 			getMemory();
			 var myChart= new Chart(ctx, {type: 'line',

				  data:data, options:options
				  
				});

			// update chart after specified time. 

		};
 		setInterval(function() {
 			updateChart();
 		}, updateInterval);
	}
</script>
