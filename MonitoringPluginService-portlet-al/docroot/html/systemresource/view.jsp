<%@page import="com.nlu.util.SystemUtil"%>
<%@include file="init.jsp"%>
<%@ page pageEncoding="UTF-8"%>
<portlet:defineObjects />
<portlet:resourceURL id="memory" var="memoryAjax"></portlet:resourceURL>
<portlet:resourceURL id="re" var="memoryReport"></portlet:resourceURL>
<%
	double maxMemory=SystemUtil.getMaxMemory();
    double maxMemoryGB = SystemUtil.convertByteToGB(maxMemory);
    String re=request.getHeader("User-Agent");
    System.out.println(re);
%>
<!-- <div class="container"> -->
		<!-- 	menu -->
		<div class="wholepage">
	<jsp:include page="menu.jsp"></jsp:include>

	<div class="main">
		<jsp:include page="notify.jsp"></jsp:include>
        <div class="content">
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
					<div id="container" style="width: 100%; height:600px; margin: 0 auto"></div>
  				 	<div style="height:600px"> <span id="loading" style="color: blue; font-size: 100px;display: none; margin-left:45%; height:600px;"> <i class="fa fa-spinner fa-spin"></i></span></div>
					</div>
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
	        label: "Memory",
	          yAxisID: '2',
	      }
	    ]
	  };
	 
	  var options={  
			  elements:{
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
	                                labelString: 'Memory usage(%)'
	                            },
	                            ticks: {
	                                beginAtZero: true,
	                                stepSize: 20,
	                                max: 100
	                            },
	                            gridLines:{
	                            	display: false
	                            }
	                        },
	                        {
	                             id: '2',
	                             position: "right",
	                            display: true,
	                             scaleLabel: {
	                                display: true,
	                                labelString: 'Memory usage(GB)'
	                            },
	                            ticks: {
	                                beginAtZero: true,
	                                stepSize: 0.8,
	                                max: <%=maxMemoryGB%>,
	                                autoSkip: true,
	                            }
	                        }]
	                },
	    title: {
	      display: true,
	      text: 'Memory',
	    },

	  };
	    
	 
	  var myChart=new Chart(ctx, {
				  type: 'line',data: data, options:options
				  
				});
	 getRealtime();
		function getRealtime(){
			data.datasets[0].data=dpss;
			data.labels=lable;
			 var updateInterval = 1000;
				var getMemory = function() {
					var memory = 0;
					AUI().use('aui-io-request', function(A) {
						A.io.request('${memoryAjax}', {
							method : 'post',
							on : {
								success : function(A, id, obj) {
									memory = JSON.parse(obj.responseText);
									
									   $('#memoryUsage').html('Memory Usage: '+ memory.percentUsage +'% ('+memory.dataUsage+' GB)');
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
				};
				setInterval(function() {
					updateChart();
				}, updateInterval);
		}
		getReport();
				function getReport() {
					 $("#container").hide();
					$("#loading").show();
					Highcharts.setOptions({
						  global: {
						    useUTC: false
						  }
						});

					AUI().use('aui-io-request', function(A) {
						
						A.io.request('${memoryReport}', {
							method : 'get',
							dataType : 'json',
							on : {
								success : function(A, id, obj) {
									 var data = [];
									dataReport = JSON.parse(obj.responseText);
// 									dataReport=dt;
									$.each(dataReport, function (i) {
                                    data.push([dataReport[i].x, dataReport[i].y]);
									});
									 $("#loading").hide();
									 $("#container").show();
									 var detailChart;

									    // create the detail chart
									    function createDetail(masterChart) {

									      // prepare the detail chart
									      var detailData = [],
									        detailStart = data[0][0];

									      $.each(masterChart.series[0].data, function () {
									        if (this.x >= detailStart) {
									          detailData.push(this.y);
									        }
									      });

									      // create a detail chart referenced by a global variable
									      //thanh trên
									      detailChart = Highcharts.chart('detail-container', {
									    	 
									        chart: {
									          marginBottom: 120,
									          reflow: false,
									          marginLeft: 50,
									          marginRight: 20,
									           zoomType: 'x',
									          style: {
									            position: 'absolute',
									            
									          },
									          height: 600
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
// 									           labels: {
// 									           format: '{value:%Y-%m-%d %H:%M}'
// 									  }
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
									          pointStart: detailStart,
									          pointInterval: 2000,
									          data: detailData
									        }],

									        exporting: {
									          enabled: true
									        }

									      }); // return chart
									    }

									    // create the master chart
									    function createMaster() {
									      Highcharts.chart('master-container', {
									        chart: {
									          reflow: false,
									          borderWidth: 0,
									          backgroundColor: null,
									          marginLeft: 50,
									          marginRight: 20,
									          zoomType: 'x',
									          events: {

									            // listen to the selection event on the master chart to update the
									            // extremes of the detail chart
									            selection: function (event) {
									              var extremesObject = event.xAxis[0],
									                min = extremesObject.min,
									                max = extremesObject.max,
									                detailData = [],
									                xAxis = this.xAxis[0];

									              // reverse engineer the last part of the data
									              $.each(this.series[0].data, function () {
									                if (this.x > min && this.x < max) {
									                  detailData.push([this.x, this.y]);
									                }
									              });

									              // move the plot bands to reflect the new detail span
									              xAxis.removePlotBand('mask-before');
									              xAxis.addPlotBand({
									                id: 'mask-before',
									                from: data[0][0],
									                to: min,
									                color: 'rgba(0, 0, 0, 0.2)'
									              });

									              xAxis.removePlotBand('mask-after');
									              xAxis.addPlotBand({
									                id: 'mask-after',
									                from: max,
									                to: data[0][0],
									                color: 'rgba(0, 0, 0, 0.2)'
									              });


									              detailChart.series[0].setData(detailData);

									              return false;
									            }
									          }
									        },
									        title: {
									          text: null
									        },
									        xAxis: {
									          type: 'datetime',//date of x duoi,
									          labels: {
									    format: '{value:%Y-%m-%d}'
									  },
									          showLastTickLabel: true,
									          //maxZoom: 14 * 24 * 3600000, // fourteen days
									          plotBands: [{
									            id: 'mask-before',
									            from: data[0][0],
									            to: data[data.length - 1][0],
									            color: 'rgba(0, 0, 0, 0.2)'
									          }],
									          title: {
									            text: null
									          }
									        },
									        yAxis: {
									          gridLineWidth: 0,
									          labels: {
									            enabled: false
									          },
									          title: {
									            text: null
									          },
									          min: 0.6,
									          showFirstLabel: false
									        },
									         tooltip: {
									    formatter: function () {
									      return false;
									    }
									  },
									        legend: {
									          enabled: false
									        },
									        credits: {
									          enabled: false
									        },
									        //data thanh duoi
									        plotOptions: {
									          series: {
									            fillColor: {
									              linearGradient: [0, 0, 0, 70],
									              stops: [
									                [0, Highcharts.getOptions().colors[0]],
									                [1, 'rgba(255,255,255,0)']
									              ]
									            },
									            lineWidth: 1,
									            marker: {
									              enabled: false
									            },
									            shadow: false,
									            states: {
									              hover: {
									                lineWidth: 1
									              }
									            },
									            enableMouseTracking: false
									          }
									        },
									//thanh duoi
									        series: [{
									          type: 'area',
									          name: 'Memory usage',
									          pointInterval: 2000,
									          pointStart: data[0][0],
									          data: data
									        }],

									        exporting: {
									          enabled: false
									        }

									      }, function (masterChart) {
									        createDetail(masterChart);
									      }); // return chart instance
									    }

									    // make the container smaller and add a second container for the master chart
									    var $container = $('#container')
									      .css('position', 'relative');

									    $('<div id="detail-container">')
									      .appendTo($container);

									    $('<div id="master-container">')
									      .css({
									        position: 'absolute',
									        top: 500,
									        height: 150,
									        width: '100%'
									      
									      })
									        .appendTo($container);

									    // create master and in its callback, create the detail chart
									    createMaster();
						                }
									 }
									});
									});

					}
// 			  $("#<portlet:namespace />chonNgay").change(function() {
// 				  data.datasets[1].data=[];
// 					data.labels=[];
// 					$(".chart-container").hide();
// 					getReport();

// 				});
		
// 		$('#tab-nav').click(function(){
// 			 $('a[data-toggle="tab"]').on('shown.bs.tab', function(e){
// 				 var target=$(e.target).attr("href");
// 				  //realtime
// 				  if((target=='#tab1')){
// 					  getRealtime();
// 				  }
// 				  else{
// 					  $("#container").hide();
// 					  getReport();
// 				  }
// 			 });
// 		});
	}
	  
	
	
</script>
