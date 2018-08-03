<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletMode"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@include file="init.jsp"%>
<%@ page pageEncoding="UTF-8"%>
<portlet:resourceURL id="receiveAlarm" var="receiveAlarm"></portlet:resourceURL>

<style>
  .rotate{ 

             animation: skew 0.8s infinite; 

  transform: skew(40deg); 

  animation-direction: alternate; 

        } 

        @keyframes skew { 

  0% { 

    transform: skewX(40deg); 

  } 

  100% { 

    transform: skewX(-40deg); 

  } 

} 
</style>
<div class="menutop">
	<div id="openNav" onclick="openSidebar()">&#9776;</div>
	<div id="openNavRight" onclick="openNotify()">
		<i class="fa fa-bell"></i>
		<div id="number" style="color: red">
			<span id="numberAlarm"></span>
		</div>
	</div>



</div>
<div class="notify">
	<ul id="contentNotify">
	</ul>
</div>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript"> 

    $(document).ready(function(){ 
var numberAlarm=0;
var first=0;
getNotify();
setInterval(function() {
	getNotify();
}, 1000);
function getNotify(){
	AUI().use('aui-io-request', function(A) {
		A.io.request('${receiveAlarm}', {
			method : 'get',
			on : {
				success : function(A, id, obj) {
					
					dataAlarm=JSON.parse(obj.responseText);
						var alarmNew=[];
						var alarmOld=[];
						$.each(dataAlarm, function (i) {
						if(dataAlarm[i].status==false){
							alarmNew.push(dataAlarm[i]);
						}
						else{
							alarmOld.push(dataAlarm[i]);
						}
						if(alarmNew.length!=0){
						$('#numberAlarm').text(alarmNew.length);
						}
						else{
							$('#numberAlarm').text('');
						}
						});
						if(alarmNew.length != numberAlarm || ($('#numberAlarm').text()=='' && first==0)){
							first=1;
							var contentNotify='';
							contentNotify="<li><span style=\"font-size:12px\">Thông báo mới</span></li>";
							$.each(alarmNew, function(i){
								var date=new Date(alarmNew[i].time);
								contentNotify+="<li><a id="+i+" href=\"\"><span style=\"font-size:15px;\">"+alarmNew[i].name+" đã vượt ngưỡng cho phép "+alarmNew[i].value+"</span><br/><span style=\"font-size:12px; margin-left:45%;\">"+date.toGMTString()+"</span></a></li>";
 								//createRenderURL(alarmNew[i].time, alarmNew[i].name, i);
							});
							if(alarmNew.length==0){
								contentNotify+="<li><span style=\"font-size:12px; margin-left:20%;\">Không có thông báo mới<span></li>";
							}
							contentNotify+="<li><span style=\"font-size:12px\">Đã xem</span></li>";
							
							$.each(alarmOld, function(i){
								var date=new Date(alarmOld[i].time);
								var id=alarmNew.length+i;
								contentNotify+="<li><a id="+id+"><span style=\"font-size:15px;\">"+alarmOld[i].name+" đã vượt ngưỡng cho phép "+alarmOld[i].value+"</span><br/><span style=\"font-size:12px; margin-left:45%;\">"+date.toGMTString()+"</span></a></li>";
							});
							if(alarmOld.length==0){
								contentNotify+="<li><span style=\"font-size:12px; margin-left:20%;\">Không có thông báo đã xem<span></li>";
							}
							numberAlarm=alarmNew.length;
							$('#contentNotify').html(contentNotify);
							$.each(alarmNew, function(i){
								createRenderURL(alarmNew[i].time, alarmNew[i].name,alarmNew[i].value, i);
							});
							$.each(alarmOld, function(i){
								createRenderURL(alarmOld[i].time, alarmOld[i].name,alarmOld[i].value, alarmNew.length+i);
							});
						}
						if(dataAlarm.length==0){
							$('#contentNotify').html("<h5 class=\"text-center\">Không có thông báo nào</h5>");
						}
						
						
				}
				}
		});
	});
}
function createRenderURL(time, name,value, id){
	AUI().use('liferay-portlet-url', function(A) {
		var renderUrl1 = Liferay.PortletURL.createRenderURL();
		renderUrl1.setWindowState("<%=LiferayWindowState.NORMAL.toString() %>");
		renderUrl1.setParameter("time",time);
		renderUrl1.setParameter("nameAlarm",name);
		renderUrl1.setParameter("value",value);
		renderUrl1.setParameter('mvcPath', '/html/systemresource/AlarmDetail.jsp');
		renderUrl1.setPortletMode("<%=LiferayPortletMode.VIEW %>");
		renderUrl1.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
		 
		document.getElementById(''+id).setAttribute('href',renderUrl1.toString());
		});
}

    }); 

</script> 