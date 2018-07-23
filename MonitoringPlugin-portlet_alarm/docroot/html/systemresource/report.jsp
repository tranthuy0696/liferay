<%@page import="java.util.List"%>
<%@page import="com.nlu.service.GetDataService"%>
<%@page import="com.nlu.util.SystemUtil"%>
<%@include file="init.jsp"%>
<%@ page pageEncoding="UTF-8"%>

<%
	double maxMemory=SystemUtil.getMaxMemory();
    double maxMemoryGB = SystemUtil.convertByteToGB(maxMemory);
    double maxHeapMB = SystemUtil.convertByteToMB(SystemUtil.getMaxHeapMemory());
    double maxNonHeapMB = SystemUtil.convertByteToMB(SystemUtil.getNonMaxHeapMemory());
    GetDataService getDataService=new GetDataService();
    List<String> listDate=getDataService.getListDate();
%>
<style>
.chart{
width:100%; height:450px; margin: 0 auto; display: none;
}
</style>
<portlet:resourceURL id="allreport" var="allreport"></portlet:resourceURL>
	<div class="wholepage">
	<jsp:include page="menu.jsp"></jsp:include>

	<div class="main">
		<jsp:include page="notify.jsp"></jsp:include>
        <div class="container">
        <div class="content">
			<div class="text-center">
					<aui:select name="dateType" label="Chọn ngày" id="chonNgay">
					<aui:option label="<%=listDate.get(listDate.size()-1) %>" value="<%=listDate.get(listDate.size()-1) %>" selected="true" />
					<%for(int i=listDate.size()-2;i>-1;i--){ %>
						<aui:option label="<%=listDate.get(i) %>" value="<%=listDate.get(i) %>" />
					<%} %>
					</aui:select>
			</div>
			<div class="row">
			<div class="span2 offset1">
			<label>Memory </label><input type="checkbox" name="checkRam" id="checkRam">
			</div>
			<div class="span1">
			<label>Cpu </label><input type="checkbox" name="cpu" id="checkCpu">
			</div>
			<div class="span2">
			<label>Heap </label><input type="checkbox" name="heap" id="checkHeap">
			</div>
			<div class="span2">
			<label>Non-Heap </label><input type="checkbox" name="nonheap" id="checkNonHeap">
			</div>
			<div class="span2">
			<label>Network </label><input type="checkbox" name="network" id="checkNetwork">
			</div>
			<div class="span2">
			<label>Session Request </label><input type="checkbox" name="session" id="checkSession">
			</div>
			</div>
			</div>
			<div id="result">
				<div id="memory" class="chart"></div>
				<div id="cpu" class="chart"></div>
				<div id="heap" class="chart"></div>
				<div id="nonheap" class="chart"></div>
				<div id="network" class="chart"></div>
				<div id="sessionrequest" class="chart"></div>
			</div>
			</div>
        	</div>
        	
        </div>
<script type="text/javascript">
// var ramReport=[];
// var cpuReport=[];
// var heapReport=[];
// var nonHeapReport=[];
// var sessionReport=[];
// var networkReport=[];
 var dataRam=[];
 var dataCpu=[];
 var dataHeap=[];
 var dataNonHeap=[];
 var dataNetworkDown=[];
	var dataNetworkUp=[];
	 var dataSessionLogin=[];
		var dataSessionLogout=[];
report();
$("#<portlet:namespace />chonNgay").change(function () {  
	report();


});
$("#checkRam").click(function(){
	drawRam();
});
$('#checkCpu').click(function(){
	drawCpu();
});
$('#checkHeap').click(function(){
	drawHeap();
});
$('#checkNonHeap').click(function(){
	drawNonHeap();
});
$('#checkNetwork').click(function(){
	drawNetwork();
});
$('#checkSession').click(function(){
	drawSessionRequest();
});

function report(){
	 dataRam=[];
	 dataCpu=[];
	 dataHeap=[];
	 dataNonHeap=[];
	 dataNetworkDown=[];
	 dataNetworkUp=[];
	 dataSessionLogin=[];
	 dataSessionLogout=[];
	 var selectedDate = $("#<portlet:namespace />chonNgay option:selected").val();
	 Highcharts.setOptions({
		  global: {
		    useUTC: false
		  }
		});
	 AUI().use('aui-io-request', function(A) {
		 A.io.request('${allreport}', {
				method : 'get',
				data : {
					<portlet:namespace />date : selectedDate
				},
				dataType : 'json',
				on : {
					success : function(A, id, obj) {
						
						 var dataReport = JSON.parse(obj.responseText);
						  var ramReport=dataReport.ramReport;
						  var cpuReport=dataReport.cpuReport;
						  var heapReport=dataReport.heapReport;
						  var nonHeapReport=dataReport.nonheapReport;
						  var sessionReport=dataReport.sessionReport;
						  var networkReport=dataReport.networkReport;
						 
						 
// 						 var dataRam=[];
							$.each(ramReport, function (i) {
                                dataRam.push([ramReport[i].x, ramReport[i].y]);
							});
								drawRam();
							
						      
// 							 var dataCpu=[];
								$.each(cpuReport, function (i) {
	                                dataCpu.push([cpuReport[i].x, cpuReport[i].y]);
								});
									drawCpu();
								
							      
// 								 var dataHeap=[];
									$.each(heapReport, function (i) {
		                                dataHeap.push([heapReport[i].x, heapReport[i].y]);
									});
										drawHeap();
									
								      
								      
// 									 var dataNonHeap=[];
										$.each(nonHeapReport, function (i) {
											dataNonHeap.push([nonHeapReport[i].x, nonHeapReport[i].y]);
										});
										drawNonHeap();
									
										
										//session report
// 										 var dataSessionLogin=[];
// 										var dataSessionLogout=[];
											$.each(sessionReport, function (i) {
												dataSessionLogin.push([sessionReport[i].x, sessionReport[i].y1]);
												dataSessionLogout.push([sessionReport[i].x, sessionReport[i].y2]);
											});
											drawSessionRequest();
											
											 
											 
// 											 var dataNetworkDown=[];
// 												var dataNetworkUp=[];
													$.each(networkReport, function (i) {
														dataNetworkDown.push([networkReport[i].x, networkReport[i].y1]);
														dataNetworkUp.push([networkReport[i].x, networkReport[i].y2]);
													});
													drawNetwork();
													
					}
				}
		 });
	 });
					}
					
					
					function drawRam(){
						if(document.getElementById("checkRam").checked){
							$('#memory').show();
							
						Highcharts.chart('memory', {
					    	 
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
					          text: 'Memory Monitoring'
					        },
					        subtitle: {
					          text: 'Memory usage'
					        },
					        xAxis: {
					          type: 'datetime',
					        },
					        yAxis: {
					          title: {
					            text: null
					          },
					          labels: {
					              format: '{value} GB'
					            },
					          max: <%=maxMemoryGB%>,
					          min:0,
					          maxZoom: 0.1,
					            plotLines: [{
					      value: 0,
					      width: 1,
					      color: '#808080'
					    }]
					        },
					        
					    tooltip: {
					    formatter: function () {
					      return '<b>' + this.series.name + '</b><br/>' +
					        Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
					        Highcharts.numberFormat(this.y, 2)+"GB";
					    }
					  },
					        legend: {
					          enabled: false
					        },
					        plotOptions: {
					        area: {
					          fillColor: {
					            linearGradient: {
					              x1: 0,
					              y1: 0,
					              x2: 0,
					              y2: 1
					            },
					            stops: [
					              [0, Highcharts.getOptions().colors[0]],
					              [1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
					            ]
					          },
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
					          type: 'area',
					          name: 'Memory usage',
					          pointStart: dataRam[0][0],
					          pointInterval: 2000,
					          data: dataRam
					        }],

					        exporting: {
					          enabled: true
					        }

					      }); 
					}
						else{
							$('#memory').hide();
						}
					}
					function drawCpu(){
						if(document.getElementById('checkCpu').checked){
							$('#cpu').show();
						Highcharts.chart('cpu', {
					    	 
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
					          text: 'CPU Monitoring'
					        },
					        subtitle: {
					          text: 'CPU usage'
					        },
					        xAxis: {
					          type: 'datetime',
					        },
					        yAxis: {
					          title: {
					            text: null
					          },
					          labels: {
					              format: '{value} %'
					            },
					          max: 100,
					          min:0,
					          maxZoom: 0.1,
					            plotLines: [{
					      value: 0,
					      width: 1,
					      color: '#808080'
					    }]
					        },
					        
					    tooltip: {
					    formatter: function () {
					      return '<b>' + this.series.name + '</b><br/>' +
					        Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
					        Highcharts.numberFormat(this.y, 2)+"%";
					    }
					  },
					        legend: {
					          enabled: false
					        },
					        plotOptions: {
					        area: {
					          fillColor: {
					            linearGradient: {
					              x1: 0,
					              y1: 0,
					              x2: 0,
					              y2: 1
					            },
					            stops: [
					              [0, Highcharts.getOptions().colors[0]],
					              [1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
					            ]
					          },
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
					          type: 'area',
					          name: 'CPU usage',
					          pointStart: dataCpu[0][0],
					          pointInterval: 2000,
					          data: dataCpu
					        }],

					        exporting: {
					          enabled: true
					        }

					      }); 
					}
						else{
							$('#cpu').hide();
						}
					}
					function drawHeap(){
						if(document.getElementById('checkHeap').checked){
							$('#heap').show();
							Highcharts.chart('heap', {
						    	 
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
						          text: 'Heap Monitoring'
						        },
						        subtitle: {
						          text: 'Heap usage'
						        },
						        xAxis: {
						          type: 'datetime',
						        },
						        yAxis: {
						          title: {
						            text: null
						          },
						          labels: {
						              format: '{value} MB'
						            },
						          max: <%=maxHeapMB%>,
						          min:0,
						          maxZoom: 0.1,
						            plotLines: [{
						      value: 0,
						      width: 1,
						      color: '#808080'
						    }]
						        },
						        
						    tooltip: {
						    formatter: function () {
						      return '<b>' + this.series.name + '</b><br/>' +
						        Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
						        Highcharts.numberFormat(this.y, 2)+"MB";
						    }
						  },
						        legend: {
						          enabled: false
						        },
						        plotOptions: {
						        area: {
						          fillColor: {
						            linearGradient: {
						              x1: 0,
						              y1: 0,
						              x2: 0,
						              y2: 1
						            },
						            stops: [
						              [0, Highcharts.getOptions().colors[0]],
						              [1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
						            ]
						          },
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
						          type: 'area',
						          name: 'Heap usage',
						          pointStart: dataHeap[0][0],
						          pointInterval: 2000,
						          data: dataHeap
						        }],

						        exporting: {
						          enabled: true
						        }

						      }); 
						}
						else{
							$('#heap').hide();
						}
					}
					function drawNonHeap(){
						if(document.getElementById('checkNonHeap').checked){
							$('#nonheap').show();
							Highcharts.chart('nonheap', {
						    	 
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
						          text: 'Non-Heap Monitoring'
						        },
						        subtitle: {
						          text: 'Non-Heap usage'
						        },
						        xAxis: {
						          type: 'datetime',
						        },
						        yAxis: {
						          title: {
						            text: null
						          },
						          labels: {
						              format: '{value} MB'
						            },
						          max: <%=maxNonHeapMB%>,
						          min:0,
						          maxZoom: 0.1,
						            plotLines: [{
						      value: 0,
						      width: 1,
						      color: '#808080'
						    }]
						        },
						        
						    tooltip: {
						    formatter: function () {
						      return '<b>' + this.series.name + '</b><br/>' +
						        Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
						        Highcharts.numberFormat(this.y, 2)+"MB";
						    }
						  },
						        legend: {
						          enabled: false
						        },
						        plotOptions: {
						        area: {
						          fillColor: {
						            linearGradient: {
						              x1: 0,
						              y1: 0,
						              x2: 0,
						              y2: 1
						            },
						            stops: [
						              [0, Highcharts.getOptions().colors[0]],
						              [1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
						            ]
						          },
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
						          type: 'area',
						          name: 'Non-Heap usage',
						          pointStart: dataNonHeap[0][0],
						          pointInterval: 2000,
						          data: dataNonHeap
						        }],

						        exporting: {
						          enabled: true
						        }

						      });
						}
						else{
							$('#nonheap').hide();
						}
						
					}
					function drawSessionRequest(){
						if(document.getElementById('checkSession').checked){
							$('#sessionrequest').show();
							 Highcharts.chart('sessionrequest', {
						    	 
							        chart: {
							        	 type: 'column',
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
							        	 text: 'Session Request Monitoring'
							        },
							        xAxis: {
							        	 type: 'datetime',
							        },
							        yAxis: {
							          title: {
							        	  text: 'Number session login and logout'
							          },
							          stackLabels: {
									      enabled: true,
									      style: {
									        fontWeight: 'bold',
									        color: (Highcharts.theme && Highcharts.theme.textColor) || 'red'
									      }
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
								    align: 'left',
								    x:10,
								    verticalAlign: 'top',
								    y: 0,
								    floating: true,
								    borderColor: '#CCC',
								    borderWidth: 1,
								    shadow: false,
								    backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'
								  },
							        plotOptions: {
							        	column: 
							        	{stacking: 'normal',
									      dataLabels: {
										        enabled: true,
										        color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'white'
										      },
							         
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
							          name: 'Login',
							          pointStart: dataSessionLogin[0][0],
							          pointInterval: 2000,
							          data: dataSessionLogin,
							          lineColor: Highcharts.getOptions().color="rgba(62,179,220,1)",
							          color: Highcharts.getOptions().color="rgba(62,179,220,1)",
							        
							        },
							        {
								          name: 'Logout',
								          pointStart: dataSessionLogout[0][0],
								          pointInterval: 2000,
								          data: dataSessionLogout,
								          lineColor: Highcharts.getOptions().color="rgba(255, 102, 0,1)",
								          color: Highcharts.getOptions().color="rgba(255, 102, 0,1)",
								        }],

							        exporting: {
							          enabled: true
							        }

							      });
						}
						else{
							$('#sessionrequest').hide();
						}
						
					}
					function drawNetwork(){
						if(document.getElementById('checkNetwork').checked){
							$('#network').show();
							Highcharts.chart('network', {
						    	 
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
						          text: 'Network Monitoring'
						        },
						        subtitle: {
						          text: 'The speed of receiving and sending'
						        },
						        xAxis: {
						          type: 'datetime',
						        },
						        yAxis: {
						          title: {
						            text: null
						          },
						          labels: {
						              format: '{value} kbps'
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
							    align: 'left',
							    x:10,
							    verticalAlign: 'top',
							    y: 0,
							    floating: true,
							    backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF',
							    borderColor: '#CCC',
							    borderWidth: 1,
							    shadow: false
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
						          type: 'area',
						          name: 'Down',
						          pointStart: dataNetworkDown[0][0],
						          pointInterval: 2000,
						          data: dataNetworkDown,
						          lineColor: Highcharts.getOptions().color="rgba(62,179,220,1)",
						          color: Highcharts.getOptions().color="rgba(62,179,220,1)",
						        },
						        {
							          type: 'area',
							          name: 'Up',
							          pointStart: dataNetworkUp[0][0],
							          pointInterval: 2000,
							          data: dataNetworkUp,
							          lineColor: Highcharts.getOptions().color="rgba(255, 102, 0,1)",
							          color: Highcharts.getOptions().color="rgba(255, 102, 0,1)"
							        }],

						        exporting: {
						          enabled: true
						        }

						      });
						}
						else{
							$('#network').hide();
						}
						
					}
</script>




