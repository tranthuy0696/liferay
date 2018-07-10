<%@page import="com.nlu.util.SystemUtil"%>
<%@include file="init.jsp"%>
<%@ page pageEncoding="UTF-8"%>


<%
   double maxHeapMB = SystemUtil.convertByteToMB(SystemUtil.getMaxHeapMemory());
%>
<portlet:resourceURL id="heap" var="memoryAjax"></portlet:resourceURL>
<portlet:resourceURL id="heapReport" var="heapReport"></portlet:resourceURL>
<!-- <div class="container"> -->
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
					<div style="height:650px;">
					<div class="chart-container" style="position: relative;height:70vh; width:82vw">
    					<canvas id="myChart" width="493" height="220" style="display: block; width: 493px; height: 220px;">
    					</canvas>
  				   </div>
					<div  class="text-center" id="memoryUsage" style="margin-top:50px; font-size:20px">
					</div>
					</div>
					</div>
					<div class="tab-pane" id="tab2">
					<div id="chartdiv" style="width	: 100%;height: 600px; position: relative;"></div>
  				 	<div style="height:600px"> <span id="loading" style="color: blue; font-size: 100px;display: none; margin-left:45%; height:600px;"> <i class="fa fa-spinner fa-spin"></i></span></div>
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
		getRealtime();
		function getRealtime(){
		var updateInterval = 1000;
		var getMemory = function() {
			var memory = 0;
			AUI().use('aui-io-request', function(A) {
				A.io.request('${memoryAjax}', {
					method : 'post',
					on : {
						success : function(A, id, obj) {
							memory = JSON.parse(obj.responseText);
							
							   $('#memoryUsage').html('Heap Usage: '+ memory.percentUsage +'% ('+memory.dataUsage+' MB)');
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
		function getReport() {
			$("#loading").show();
			AUI().use('aui-io-request', function(A) {
				 var chartData = [];
				A.io.request('${heapReport}', {
					method : 'get',
					dataType : 'json',
					on : {
						success : function(A, id, obj) {
							dt = JSON.parse(obj.responseText);
							dataReport=dt;
							$.each(dataReport, function (i) {
								  chartData.push({
							            date: dataReport[i].time,
							            visits: dataReport[i].value
							        });
							});
							 $("#loading").hide();
							 $("#chartdiv").show();
							var chart = AmCharts.makeChart("chartdiv", {
							    "type": "serial",
							    "theme": "light",
							    "marginRight": 80,
							    "autoMarginOffset": 20,
							    "marginTop": 7,
							   "dataDateFormat": "YYYY-MM-DD JJ:NN:SS",
							   "titles": [
							      		{
							      			"text": "Heap",
							      			"size": 20,
							      		}
							      	],
							    "dataProvider": chartData,
							    "valueAxes": [{
							        "axisAlpha": 0.2,
							        "dashLength": 1,
							        "position": "left"
							    }],
							    "mouseWheelZoomEnabled": true,
							    "graphs": [{
							        "id": "g1",
							        "balloonText": "[[value]] MB",
							        "bullet": "round",
							        "bulletBorderAlpha": 1,
							        "bulletColor": "#FFFFFF",
							        "hideBulletsCount": 50,
							        "title": "red line",
							        "valueField": "visits",
							        "useLineColorForBulletBorder": true,
							        //"balloonText": "<span style='font-size:18px;'>[[visits]] GB</span>",
							        "balloon":{
							            "drop":true,
							            //"dataDateFormat": 'YYYY-MM-DD JJ:NN:SS'
							        },
							          "type": "smoothedLine",
							           "fillAlphas": 0.2
							    }],
							    "chartScrollbar": {
							        "autoGridCount": true,
							        "graph": "g1",
							        "scrollbarHeight": 40,
							        "position":"bottom"
							    },
							    "chartCursor": {
							       "limitToGraph":"g1",
							       "categoryBalloonDateFormat": 'YYYY-MM-DD JJ:NN:SS'
							    },
							    "categoryField": "date",
							    "categoryAxis": {
							        "parseDates": true,
							        "axisColor": "#DADADA", //mau cua truc x
							        "dashLength": 1,
							        "minorGridEnabled": true,
							     //   "durationUnits": {DD:"d. ", hh:":", mm:":",ss:""},
							  //    "dataDateFormat": 'YYYY-MM-DD JJ:NN:SS',
							      "minPeriod": "ss"
							    },
							    "valueAxes": [{
							    "axisAlpha": 0.2,
							    "id": "v1",
							    "minimum": 0,
							    "maximum": <%=maxHeapMB%>,
							    "title":"Heap usage (MB)"
							 }],
							    "export": {
							        "enabled": true
							    }
							});
							chart.addListener("rendered", zoomChart);
							zoomChart();

							// this method is called when chart is first inited as we listen for "rendered" event
							function zoomChart() {
							    // different zoom methods can be used - zoomToIndexes, zoomToDates, zoomToCategoryValues
							    chart.zoomToIndexes(chartData.length - 40, chartData.length - 1);
							}
				                }
							 }
							});
							});

			}
//		  $("#<portlet:namespace />chonNgay").change(function() {
//			  data.datasets[1].data=[];
//				data.labels=[];
//				$(".chart-container").hide();
//				getReport();

//			});

$('#tab-nav').click(function(){
	 $('a[data-toggle="tab"]').on('shown.bs.tab', function(e){
		 var target=$(e.target).attr("href");
		  //realtime
		  if((target=='#tab1')){
			  getRealtime();
		  }
		  else{
			  $("#chartdiv").hide();
			  getReport();
		  }
	 });
});
	}
</script>
