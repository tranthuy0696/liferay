<%@page import="com.nlu.util.SystemUtil"%>
<%@include file="init.jsp"%>
<%@ page pageEncoding="UTF-8"%>
<portlet:resourceURL id="re" var="memoryReport"></portlet:resourceURL>
<script src="https://www.amcharts.com/lib/3/amcharts.js"></script>
<script src="https://www.amcharts.com/lib/3/serial.js"></script>
<script src="https://www.amcharts.com/lib/3/plugins/export/export.min.js"></script>
<link rel="stylesheet" href="https://www.amcharts.com/lib/3/plugins/export/export.css" type="text/css" media="all" />
<script src="https://www.amcharts.com/lib/3/themes/light.js"></script>
<%
	double maxMemory=SystemUtil.getMaxMemory();
    double maxMemoryGB = SystemUtil.convertByteToGB(maxMemory);
%>
<div id="chartdiv" style="width	: 100%;height: 700px;"></div>
<script>
AUI().use('aui-io-request', function(A) {
	 var chartData = [];
	A.io.request('${memoryReport}', {
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
				 $(".chart-container").show();
				var chart = AmCharts.makeChart("chartdiv", {
				    "type": "serial",
				    "theme": "light",
				    "marginRight": 80,
				    "autoMarginOffset": 20,
				    "marginTop": 7,
				   "dataDateFormat": "YYYY-MM-DD JJ:NN:SS",
				   "titles": [
				      		{
				      			"text": "Chart Title",
				      			"size": 18
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
				        "balloonText": "[[value]] GB",
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
				    "maximum": <%=maxMemoryGB%>,
				    "title":"Memory usage (GB)"
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
</script>