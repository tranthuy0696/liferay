<%@page import="com.nlu.util.SystemUtil"%>
<%@include file="init.jsp"%>
<%@ page pageEncoding="UTF-8"%>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/reset.css">
<!-- CSS reset -->
<link rel="stylesheet"  href="<%=request.getContextPath()%>/css/style.css">
<!-- Resource style -->
<script src="<%=request.getContextPath()%>/js/modernizr.js"></script>
<portlet:resourceURL id="directory" var="directory"></portlet:resourceURL>
<!-- Modernizr -->
	<div class="wholepage">
	<jsp:include page="menu.jsp"></jsp:include>

	<div class="main">
			<jsp:include page="notify.jsp"></jsp:include>
        <div class="content">
        	<div class="container">
	<div id="event">
	</div>
	<div style="font-size: 20px" class="text-center" id="total"></div>
	<div id="directory"></div>
	</div>
        </div>
	</div>
		</div>


<script src="<%=request.getContextPath()%>/js/jquery-3.3.1.min.js"></script>
<script src="<%=request.getContextPath()%>/js/main.js"></script>
<script>
getRealtime();
var updateInterval = 1000;
function getRealtime(){
	 
// 		var getDirectoryInfo = function() {
			AUI().use('aui-io-request', function(A) {
				A.io.request('${directory}', {
					method : 'get',
					on : {
						success : function(A, id, obj) {
							directoryData = JSON.parse(obj.responseText);
							console.log(directoryData.status);
// 							if(directoryData.status){
							 event=directoryData.eventList;
							if(event.length >0){
							 var events="<ul>";
							 $.each(event, function (i) {
								  console.log(event);
								  events+="<li style=\"list-style-type: circle;\">"+event[i]+"</li>";
// 								  $('#event').append("<li>"+event[i]+"</li>");
							});
							 events+="</ul>";
							 console.log(events);
							 $('#event').html(events);
							}
							if(($('#total').html()=='')||event.length >0){
							
							 $('#total').html("<h2>Dung lượng: "+directoryData.size+" (KB)</h2>");
							 $('#directory').html(directoryData.contentGUI);
							}
						
						}
					}
				});
			});
	
}
setInterval(function() {
	getRealtime();
}, updateInterval);
</script>