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
<portlet:resourceURL id="allreport" var="allreport"></portlet:resourceURL>
	<div class="wholepage">
	<jsp:include page="menu.jsp"></jsp:include>

	<div class="main">
		<jsp:include page="notify.jsp"></jsp:include>
        <div class="content">
			<div class="text-center">
					<aui:select name="dateType" label="Chọn ngày" id="chonNgay">
					<aui:option label="<%=listDate.get(listDate.size()-1) %>" value="<%=listDate.get(listDate.size()-1) %>" selected="true" />
					<%for(int i=listDate.size()-2;i>-1;i--){ %>
						<aui:option label="<%=listDate.get(i) %>" value="<%=listDate.get(i) %>" />
					<%} %>
					</aui:select>
			</div>
			<div id="date" class="text-center" style="font-size:20px"></div>
			<div id="result">
			<div class="row">
			<div class="span6">
			<div id="memory" style="width:100%; height:500px; margin: 0 auto"></div>
			</div>
			<div class="span6">
			<div id="cpu" style="width:100%; height:500px; margin: 0 auto"></div>
			</div>
			</div>
			<div class="row">
			<div class="span6">
			<div id="heap" style="width:100%; height:500px; margin: 0 auto"></div>
			</div>
			<div class="span6">
				<div id="nonheap" style="width:100%; height:500px; margin: 0 auto"></div>
			</div>
			<div class="row">
			<div class="span6">
			<div id="network" style="width:100%; height:500px; margin: 0 auto"></div>
			</div>
			<div class="span6">
			<div id="sessionrequest" style="width:100%; height:500px; margin: 0 auto"></div>
			</div>
			</div>
			</div>
        	</div>
        	<div style="height:600px"> <span id="loading" style="color: blue; font-size: 100px;display: none; margin-left:45%; height:600px;"> <i class="fa fa-spinner fa-spin"></i></span></div>
        	
        </div>
	</div>
		</div>
<script>
report();
$("#<portlet:namespace />chonNgay").change(function () {  
	report();


});
function report(){
	 var selectedDate = $("#<portlet:namespace />chonNgay option:selected").val();
	 $("#loading").show();
	 $("#result").hide();
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
						
						 dataReport = JSON.parse(obj.responseText);
						 var ramReport=dataReport.ramReport;
						 var cpuReport=dataReport.cpuReport;
						 var heapReport=dataReport.heapReport;
						 var nonHeapReport=dataReport.nonheapReport;
						 var sessionReport=dataReport.sessionReport;
						 var networkReport=dataReport.networkReport;
						 
						 $("#loading").hide();
						 $("#result").show();
						 
						 var dataRam=[];
							$.each(ramReport, function (i) {
                                dataRam.push([ramReport[i].x, ramReport[i].y]);
							});
							
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
//							           labels: {
//							           format: '{value:%Y-%m-%d %H:%M}'
//							  }
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

						      }); // return chart
						      
							 var dataCpu=[];
								$.each(cpuReport, function (i) {
	                                dataCpu.push([cpuReport[i].x, cpuReport[i].y]);
								});
								      
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
//							           labels: {
//							           format: '{value:%Y-%m-%d %H:%M}'
//							  }
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

							      }); // return chart
							      
								 var dataHeap=[];
									$.each(heapReport, function (i) {
		                                dataHeap.push([heapReport[i].x, heapReport[i].y]);
									});
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
//								           labels: {
//								           format: '{value:%Y-%m-%d %H:%M}'
//								  }
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

								      }); // return chart
								      
								      
									 var dataNonHeap=[];
										$.each(nonHeapReport, function (i) {
											dataNonHeap.push([nonHeapReport[i].x, nonHeapReport[i].y]);
										});
										
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
//									           labels: {
//									           format: '{value:%Y-%m-%d %H:%M}'
//									  }
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
										
										//session report
										 var dataSessionLogin=[];
										var dataSessionLogout=[];
											$.each(sessionReport, function (i) {
												dataSessionLogin.push([sessionReport[i].x, sessionReport[i].y1]);
												dataSessionLogout.push([sessionReport[i].x, sessionReport[i].y2]);
											});
											
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
											          
//											           labels: {
//											           format: '{value:%Y-%m-%d %H:%M}'
//											  }
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
//												          max: 100,
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
//				 								    layout: 'vertical',
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
											 
											 
											 var dataNetworkDown=[];
												var dataNetworkUp=[];
													$.each(networkReport, function (i) {
														dataNetworkDown.push([networkReport[i].x, networkReport[i].y1]);
														dataNetworkUp.push([networkReport[i].x, networkReport[i].y2]);
													});
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
//												           labels: {
//												           format: '{value:%Y-%m-%d %H:%M}'
//												  }
												        },
												        yAxis: {
												          title: {
												            text: null
												          },
												          labels: {
												              format: '{value} kbps'
												            },
//				 								          max: 120,
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
//				 									    layout: 'vertical',
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
													          pointStart: dataNetworkUp,
													          pointInterval: 2000,
													          data: dataNetworkDown,
													          lineColor: Highcharts.getOptions().color="rgba(255, 102, 0,1)",
													          color: Highcharts.getOptions().color="rgba(255, 102, 0,1)"
													        }],

												        exporting: {
												          enabled: true
												        }

												      }); // return chart
					}
				}
		 });
	 });
					}
</script>




