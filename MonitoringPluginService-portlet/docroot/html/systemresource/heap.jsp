<%@page import="com.nlu.util.SystemUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<portlet:defineObjects />

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
</style>
<%long maxHeap=SystemUtil.getMaxHeapMemory(); %>
<portlet:resourceURL id="heap" var="memoryAjax"></portlet:resourceURL>
<div class="row">
<div class="span3" id="menu">
		<jsp:include page="menu.jsp"></jsp:include>
	</div>
	<div class="span9" id="chart">
		<div class="tabbable">
			<!-- Only required for left/right tabs -->
			<ul class="nav nav-tabs">
				<li class="active"><a href="#tab1" data-toggle="tab">Real Time</a></li>
				<li><a href="#tab2" data-toggle="tab">Thống kê</a></li>
			</ul>
			<div class="tab-content">
				<div class="tab-pane active" id="tab1">
					<div id="chartContainer" style="height: 300px; width: 100%;"></div>
				</div>
				<div class="tab-pane" id="tab2">
					<p>Search container</p>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
	window.onload = function() {
		var dpss = [];
		//dataPoints. 
		for (var i = 0; i < 60; i++) {
			dpss.push({
				x : i,
				y : 0
			});
		}
		var chart = new CanvasJS.Chart("chartContainer", {
			title : {
				text : "Heap"
			},
			axisX : {
				title : "60 seconds",
				display : false
			},
			axisY : {
				title : "Heap usage(bytes)",
				maximum : <%=maxHeap%>,
				minimum : 0,
				display : false

			},
			data : [ {
				type : "area",
				dataPoints : dpss
			} ]
		});

		chart.render();
		var updateInterval = 1000;
		var getMemory = function() {
				var memory=0;
			AUI().use('aui-io-request', function(A) {
				A.io.request('${memoryAjax}', {
					method : 'post',
					on : {
						success : function(A, id, obj) {
							memory=parseInt(obj.responseText);
							dpss.push({
								x : 59,
								y : memory
							});
						}
					}
				});	
			});
		}
		
		var updateChart = function() {
			for (var i = 0; i < 60; i++) {
				dpss[i].x = i - 1;
			}
			dpss.shift();
			getMemory();
			chart.render();

			// update chart after specified time. 

		};
		setInterval(function() {
			updateChart()
		}, updateInterval);
	}
</script>
