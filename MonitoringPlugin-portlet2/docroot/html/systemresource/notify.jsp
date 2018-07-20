<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<portlet:defineObjects />
<%@ page pageEncoding="UTF-8"%>
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
			<span>2</span>
		</div>
	</div>



</div>
<div class="notify">
	<ul>
		<li><a><span style="font-size:15px;">Ram đã vượt ngưỡng cho phép</span><br/><span style="font-size:12px; margin-left:50%;">2018-07-20 9:00</span></a></li>
		<li><a><span style="font-size:15px;">CPU đã vượt ngưỡng cho phép</span><br/><span style="font-size:12px; margin-left:50%;">2018-07-20 9:00</span></a></li>
	</ul>
</div>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript"> 

    $(document).ready(function(){ 
    		$('#openNavRight').addClass('rotate'); 
    	    setTimeout(timeOut(),3000);
function timeOut(){
	$('#openNavRight').removeClass('rotate')
}
    }); 

</script> 