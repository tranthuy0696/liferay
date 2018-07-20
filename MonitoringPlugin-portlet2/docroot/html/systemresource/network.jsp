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
div#menu {
	margin-left: 1.5%;
}
</style>
<portlet:resourceURL id="network" var="networkAjax"></portlet:resourceURL>
<portlet:resourceURL id="networkReport" var="networkReport"></portlet:resourceURL>
<!-- 	<div class="container"> -->
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
		var down = [];
		var lable = [];
		var up=[];
		var lableUp=[];
		//dataPoints. 
		for (var i = 0; i < 60; i++) {
			down.push(0);
			lable.push(i);
			up.push(0);
			
		}
		var ctx=document.getElementById("myChart").getContext("2d");
	    var data={
	    labels: lable,
	    datasets: [{ 
	        data: down,
	        label: "Down",
	          borderColor: "rgba(62,179,220,1)",
	          backgroundColor: "rgba(62,179,220,0.2)",
	          pointBackgroundColor: "rgba(62,179,220,1)",
	          pointBorderColor:"#fff",
	          borderWidth: 2,
	            showLine: true, 
	    
	      },
	      { 
		        data: up,
		        label: "Up",
		          borderColor: "rgba(255, 102, 0,1)",
		          backgroundColor: "rgba(255, 102, 0,0.2)",
		          pointBackgroundColor: "rgba(255, 102, 0,1)",
		          pointBorderColor:"#fff",
		          borderWidth: 2,
		            showLine: true, 
		    
		      }
	    ]
	  };
	  var options={  elements:{
      point: {radius: 0}
      },
	     animation: false,
	      responsive: true,
	                legend: {
	                    //position: 'bottom',
	                    display: true,	
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
	                                labelString: 'Network (Kbps)'
	                            },
	                            ticks: {
	                                beginAtZero: true,
	                               // stepSize: 20,
	                               max: 120
	                            }
	                        }]
	                },
	    title: {
	      display: true,
	      text: 'Network',
	    },

	  };
		var myChart=new Chart(ctx, {
	  type: 'line',data: data, options:options
	  
	});
		getRealtime();
		function getRealtime(){
		var updateInterval = 1000;
		var getNetwork = function() {
			var cpu = 0;
			AUI().use('aui-io-request', function(A) {
				A.io.request('${networkAjax}', {
					method : 'post',
					on : {
						success : function(A, id, obj) {
// 							cpu = obj.responseText;
							network=JSON.parse(obj.responseText);
							   $('#memoryUsage').html('Down: '+ network.rx+'(kbps)' +'<br>'+"Up: "+network.tx+'(kbps)');
							data.datasets[0].data.push(network.rx);
						     data.datasets[0].data.shift();
						     data.datasets[1].data.push(network.tx);
						     data.datasets[1].data.shift();
						     
						}
					}
				});
			});
		}
		
		var updateChart = function() {
			getNetwork();
			 var myChart= new Chart(ctx, {type: 'line',

				  data:data, options:options
				  
				});

			// update chart after specified time. 

		};
 		setInterval(function() {
 			updateChart();
 		}, updateInterval);
		}
		getReport();
 		function getReport() {
			$("#loading").show();
			Highcharts.setOptions({
				  global: {
				    useUTC: false
				  }
				});
			AUI().use('aui-io-request', function(A) {
				 var chartData = [];
				A.io.request('${networkReport}', {
					method : 'get',
					dataType : 'json',
					on : {
						success : function(A, id, obj) {
							 var dataDown = [];
							 var dataUp=[];
								dataReport = JSON.parse(obj.responseText);
//								dataReport=dt;
console.log(dataReport);
								$.each(dataReport, function (i) {
                          dataDown.push([dataReport[i].x, dataReport[i].y1]);
                          dataUp.push([dataReport[i].x, dataReport[i].y2]);
								});
								 $("#loading").hide();
								 $("#container").show();
								 var detailChart;

								    // create the detail chart
								    function createDetail(masterChart) {

								      // prepare the detail chart
								      var detailData = [];
								      var detailDataUp=[];
								       var detailStart = dataDown[0][0];
								      var detailStartUp=dataUp[0][0];

								      $.each(masterChart.series[0].data, function () {
								        if (this.x >= detailStart) {
								          detailData.push(this.y);
								        }
								      });
								      $.each(masterChart.series[1].data, function () {
									        if (this.x >= detailStartUp) {
									        	detailDataUp.push(this.y);
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
								          text: 'Network Monitoring'
								        },
								        subtitle: {
								          text: 'The speed of receiving and sending'
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
								              format: '{value} kbps'
								            },
// 								          max: 120,
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
// 									    layout: 'vertical',
									    align: 'left',
									    x:100,
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
								          pointStart: detailStart,
								          pointInterval: 2000,
								          data: detailData,
								          lineColor: Highcharts.getOptions().color="rgba(62,179,220,1)",
								          color: Highcharts.getOptions().color="rgba(62,179,220,1)",
								        },
								        {
									          type: 'area',
									          name: 'Up',
									          pointStart: detailStartUp,
									          pointInterval: 2000,
									          data: detailDataUp,
									          lineColor: Highcharts.getOptions().color="rgba(255, 102, 0,1)",
									          color: Highcharts.getOptions().color="rgba(255, 102, 0,1)"
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
								                detailDataUp=[],
								                xAxis = this.xAxis[0];

								              // reverse engineer the last part of the data
								              $.each(this.series[0].data, function () {
								                if (this.x > min && this.x < max) {
								                  detailData.push([this.x, this.y]);
								                }
								              });
								              $.each(this.series[1].data, function () {
									                if (this.x > min && this.x < max) {
									                  detailDataUp.push([this.x, this.y]);
									                }
									              });


								              // move the plot bands to reflect the new detail span
								              xAxis.removePlotBand('mask-before');
								              xAxis.addPlotBand({
								                id: 'mask-before',
								                from: dataDown[0][0],
								                to: min,
								                color: 'rgba(0, 0, 0, 0.2)'
								              });

								              xAxis.removePlotBand('mask-after');
								              xAxis.addPlotBand({
								                id: 'mask-after',
								                from: max,
								                to: dataDown[0][0],
								                color: 'rgba(0, 0, 0, 0.2)'
								              });


								              detailChart.series[0].setData(detailData);
								              detailChart.series[1].setData(detailDataUp);

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
								            from: dataDown[0][0],
								            to: dataDown[dataDown.length - 1][0],
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
								          name: 'Down',
								          pointInterval: 2000,
								          pointStart: dataDown[0][0],
								          data: dataDown,
								          lineColor: Highcharts.getOptions().color="rgba(62,179,220,1)",
								          color: Highcharts.getOptions().color="rgba(62,179,220,1)",
								         
								        },
								        {
									          type: 'area',
									          name: 'Up',
									          pointInterval: 2000,
									          pointStart: dataUp[0][0],
									          data: dataUp,
									          lineColor: Highcharts.getOptions().color="rgba(255, 102, 0,1)",
									          color: Highcharts.getOptions().color="rgba(255, 102, 0,1)"
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
//  		$('#tab-nav').click(function(){
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
