<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
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
/* div#menu { */
/* 	margin-left: 1.5%; */
/* } */

canvas#browser {
    height: 400px !important;
}

canvas#login{
    height: 400px !important;
}

canvas#os {
    height: 400px !important;
}
</style>
<portlet:resourceURL id="sessionRequestReport" var="sessionRequestReport"></portlet:resourceURL>
<portlet:resourceURL id="sessionrequest" var="memoryAjax"></portlet:resourceURL>
<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/html/systemresource/sessionrequest.jsp" />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL varImpl="searchURL">
    <portlet:param name="mvcPath" value="/html/systemresource/sessionrequest.jsp" />
</liferay-portlet:renderURL>
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
					<div id="containerRealTime" style="width:100%; height:600px; margin: 0 auto"></div>
					<div id="memoryUsage" class="text-center">
					</div>
					</div>
					<div class="tab-pane" id="tab2">
	<div id="container" style="width:100%; height:650px; margin: 0 auto"></div>

</div>
					</div>
				</div>
        </div>
	</div>
		</div>
		
		
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
<!-- <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script> -->
<!-- 	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script> -->
<script>
	window.onload = function() {
	var loginBefore=0;
	var logoutBefore=0;
		getRealtime();
		getRealtime();
		function getRealtime(){
			Highcharts.setOptions({
				  global: {
				    useUTC: false
				  }
				});
				Highcharts.chart('containerRealTime', {
				  chart: {
				    type: 'column',
				    animation: Highcharts.svg, // don't animate in old IE
				    marginRight: 10,
				    events: {
				      load: function () {

				        // set up the updating of the chart each second
				        var seriesLogin = this.series[0];
				          var seriesLogout = this.series[1];
				        setInterval(function () {
				        	var sessionRequest = 0;
				        	 var x = (new Date()).getTime();
							AUI().use('aui-io-request', function(A) {
								A.io.request('${memoryAjax}', {
									method : 'post',
									on : {
										success : function(A, id, obj) {
											sessionRequest = JSON.parse(obj.responseText);
											
											if(loginBefore!=sessionRequest.numberLogin || logoutBefore !=sessionRequest.numberLogout){
												  $('#memoryUsage').html('Login: '+ sessionRequest.numberLogin+'<br/>'+'Logout: '+sessionRequest.numberLogin);
										    seriesLogin.addPoint([x, sessionRequest.numberLogin], true, true);
										    seriesLogout.addPoint([x, sessionRequest.numberLogout], true, true);
											loginBefore=sessionRequest.numberLogin;
											logoutBefore=sessionRequest.numberLogout;	
											}
										}
									}
								});
							});
				        }, 1000);
				      }
				    }
				  },
				  title: {
				    text: 'Session Request'
				  },
				  xAxis: {
				    type: 'datetime',
				    tickPixelInterval: 150
				  },
				  yAxis: {
											          title: {
											        	  text: 'Number session login and logout'
											          },
											          stackLabels: {
													    //  enabled: true,
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
												  //  layout: 'vertical',
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
											        	column: 
											        	{stacking: 'normal',
													      dataLabels: {
														     //   enabled: true,
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
				  exporting: {
				    enabled: false
				  },
				  series: [{
				    name: 'Login',
				    lineColor: Highcharts.getOptions().color="rgba(62,179,220,1)",
			          color: Highcharts.getOptions().color="rgba(62,179,220,1)",
				    data: (function () {
				      // generate an array of random data
				      var data = [],
				        time = (new Date()).getTime(),
				        i;
				   for (i = -15; i <= 0; i += 1) {
				        data.push({
				          x: time + i * 1000,
				          y: 0
				        });
				      }
				   
				      return data;
				    }())
				  },
				          {
				    name: 'Logout',
				    lineColor: Highcharts.getOptions().color="rgba(255, 102, 0,1)",
			          color: Highcharts.getOptions().color="rgba(255, 102, 0,1)",
				    data: (function () {
				      // generate an array of random data
				      var data = [],
				        time = (new Date()).getTime(),
				        i;
				   for (i = -15; i <= 0; i += 1) {
				        data.push({
				          x: time + i * 1000,
				          y: 0
				        });
				      }
				   
				      return data;
				    }())
				  }]
				});

			}
		function getReport(){
			Highcharts.setOptions({
				  global: {
				    useUTC: false
				  }
				});
			 AUI().use('aui-io-request', function(A) {
			 A.io.request('${sessionRequestReport}', {
					method : 'get',
					dataType : 'json',
					on : {
						success : function(A, id, obj) {
							var dataLogin = [];
							 var dataLogout=[];
								dataReport = JSON.parse(obj.responseText);
								$.each(dataReport, function (i) {
                         dataLogin.push([dataReport[i].x, dataReport[i].y1]);
                         dataLogout.push([dataReport[i].x, dataReport[i].y2]);
								});
								var detailChart;

							    // create the detail chart
							    function createDetail(masterChart) {

							      // prepare the detail chart
							      var detailDataLogin = [];
							      var detailDataLogout=[];
							       var detailStartLogin = dataLogin[0][0];
							      var detailStartLogout=dataLogout[0][0];

							      $.each(masterChart.series[0].data, function () {
							        if (this.x >= detailStartLogin) {
							          detailDataLogin.push(this.y);
							        }
							      });
							      $.each(masterChart.series[1].data, function () {
								        if (this.x >= detailStartLogout) {
								        	detailDataLogout.push(this.y);
								        }
								      });
								      

							      // create a detail chart referenced by a global variable
							      //thanh trên
							      detailChart = Highcharts.chart('detail-container', {
							    	 
							        chart: {
							        	 type: 'column',
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
							        	 text: 'Session Request Monitoring'
							        },
							        xAxis: {
							        	 type: 'datetime',
							          
//							           labels: {
//							           format: '{value:%Y-%m-%d %H:%M}'
//							  }
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
//								          max: 100,
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
// 								    layout: 'vertical',
								    align: 'left',
								    x:100,
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
							          pointStart: detailStartLogin,
							          pointInterval: 2000,
							          data: detailDataLogin,
							          lineColor: Highcharts.getOptions().color="rgba(62,179,220,1)",
							          color: Highcharts.getOptions().color="rgba(62,179,220,1)",
							        
							        },
							        {
								          name: 'Logout',
								          pointStart: detailStartLogout,
								          pointInterval: 2000,
								          data: detailDataLogout,
								          lineColor: Highcharts.getOptions().color="rgba(255, 102, 0,1)",
								          color: Highcharts.getOptions().color="rgba(255, 102, 0,1)",
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
							        	type:'column',
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
							                detailDataLogin = [],
							                detailDataLogout=[],
							                xAxis = this.xAxis[0];

							              // reverse engineer the last part of the data
							              $.each(this.series[0].data, function () {
							                if (this.x > min && this.x < max) {
							                  detailDataLogin.push([this.x, this.y]);
							                }
							              });
							              $.each(this.series[1].data, function () {
								                if (this.x > min && this.x < max) {
								                  detailDataLogout.push([this.x, this.y]);
								                }
								              });


							              // move the plot bands to reflect the new detail span
							              xAxis.removePlotBand('mask-before');
							              xAxis.addPlotBand({
							                id: 'mask-before',
							                from: dataLogin[0][0],
							                to: min,
							                color: 'rgba(0, 0, 0, 0.2)'
							              });

							              xAxis.removePlotBand('mask-after');
							              xAxis.addPlotBand({
							                id: 'mask-after',
							                from: max,
							                to: dataLogout[0][0],
							                color: 'rgba(0, 0, 0, 0.2)'
							              });


							              detailChart.series[0].setData(detailDataLogin);
							              detailChart.series[1].setData(detailDataLogout);

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
							            from: dataLogin[0][0],
							            to: dataLogin[dataLogin.length - 1][0],
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
							          min: 0,
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
							          name: 'login',
							          pointInterval: 2000,
							          pointStart: dataLogin[0][0],
							          data: dataLogin,
							          lineColor: Highcharts.getOptions().color="rgba(62,179,220,1)",
							          color: Highcharts.getOptions().color="rgba(62,179,220,1)",
							        },
							        {
								          name: 'Logout',
								          pointInterval:2000,
								          pointStart: dataLogout[0][0],
								          data: dataLogout,
								          lineColor: Highcharts.getOptions().color="rgba(255, 102, 0,1)",
								          color: Highcharts.getOptions().color="rgba(255, 102, 0,1)",
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
				  if(target=='#tab1'){
					  getRealtime();
				  }
				  else{
					  getReport();
				  }
			 });
		});
		
	}
</script>
