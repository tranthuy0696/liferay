<%@include file="init.jsp"%>


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
<portlet:resourceURL id="cpu" var="memoryAjax"></portlet:resourceURL>
<portlet:resourceURL id="reportCPU" var="cpuReport"></portlet:resourceURL>
<!-- 	<div class="container"> -->
		<!-- 	menu -->
			<div class="wholepage">
	<jsp:include page="menu.jsp"></jsp:include>

	<div class="main">
		<div class="menutop">
			<div id="openNav" onclick="openSidebar()">&#9776;</div>
			<div id="openNavRight" onclick="openNotify()"><i class="fa fa-bell"></i>
			<div id="number"><span>0</span></div>
			</div> 
			

			
		</div>
		<div class="notify">
		<ul>
		<li><a>Ram notify</a></li>
		</ul>
		</div>
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
					<div id="container" style="min-width: 310px; height:600px; margin: 0 auto"></div>
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
	          borderColor: "rgba(62,179,220,1)",
	          backgroundColor: "rgba(62,179,220,0.2)",
	          pointBackgroundColor: "rgba(62,179,220,1)",
	          pointBorderColor:"#fff",
	    
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
	                            display: true,
	                             scaleLabel: {
	                                display: true,
	                                labelString: 'CPU usage(%)'
	                            },
	                            ticks: {
	                                beginAtZero: true,
	                                stepSize: 20,
	                                max: 100
	                            }
	                        }]
	                },
	    title: {
	      display: true,
	      text: 'CPU',
	    },

	  };
		var myChart=new Chart(ctx, {
	  type: 'line',data: data, options:options
	  
	});
		getRealtime();
		function getRealtime(){
		var updateInterval = 1000;
		var getCPU = function() {
			var cpu = 0;
			AUI().use('aui-io-request', function(A) {
				A.io.request('${memoryAjax}', {
					method : 'post',
					on : {
						success : function(A, id, obj) {
							cpu = obj.responseText;
							
							   $('#memoryUsage').html('CPU usage: '+ cpu +'%');
							data.datasets[0].data.push(cpu);
						     data.datasets[0].data.shift();
						}
					}
				});
			});
		}
		
		var updateChart = function() {
 			getCPU();
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
			Highcharts.setOptions({
				  global: {
				    useUTC: false
				  }
				});
			AUI().use('aui-io-request', function(A) {
				 var chartData = [];
				A.io.request('${cpuReport}', {
					method : 'get',
					dataType : 'json',
					on : {
						success : function(A, id, obj) {
							 var data = [];
								dataReport = JSON.parse(obj.responseText);
//								dataReport=dt;
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
								          text: 'CPU Monitoring'
								        },
								        subtitle: {
								          text: 'CPU usage'
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
								          name: 'CPU usage',
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
 		$('#tab-nav').click(function(){
			 $('a[data-toggle="tab"]').on('shown.bs.tab', function(e){
				 var target=$(e.target).attr("href");
				  //realtime
				  if((target=='#tab1')){
					  getRealtime();
				  }
				  else{
					  $("#container").hide();
					  getReport();
				  }
			 });
		});
	}
</script>
