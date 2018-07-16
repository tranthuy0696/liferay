<%@ include file="/html/alarm/init.jsp"%>
<%@ page pageEncoding="UTF-8"%>
<style>
.help-block{
color:red;}
select.span4.selectpicker{
height:36px !important;
border-radius:5px !important; }
select.span3.selectpicker{
height:36px !important;
border-radius:5px !important; 
}	
input.span4{
height:36px !important;
border-radius:5px !important; }
input.span3{
height:36px !important;
border-radius:5px !important; }
</style>
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<div class="container" style="margin-top: 20px;">
		<div class="text-center">Thiet lap thong so</div>
	<div><label>Ram</label></div>

	<div class="row">
	<select class="span4 selectpicker" id="ramStart">
		<option value="-1">Giờ bắt đầu</option>
		<%for(int i=0;i<24;i++){ %>
		<option value="<%=i%>"><%=i %> Giờ</option>
		<%} %>
		
	</select>
	<select class="span4 selectpicker" id="ramEnd">
		<option value="-1">Giờ kết thúc</option>
		<%for(int i=0;i<24;i++){ %>
		<option value="<%=i%>"><%=i %> Giờ</option>
		<%} %>
		
	</select>
		<select class="span3 selectpicker" id="ramValue">
		<option value="-1">Giá trị</option>
		<%for(int i=1;i<101;i++){ %>
		<option value="<%=i%>"><%=i %> %</option>
		<%} %>
	</select>
		<button id="addRam" class="btn btn-primary" style="margin-top:-8px;">Thêm</button>
	</div>
	<div id="infoRam"></div>
	<div><label>CPU</label></div>

	<div class="row">
		 <input type="text" name="startDate" class="span4" id="cpuStart">
	<input type="text" name="endDate" class="span4" id="cpuEnd">
	<input type="text" name="value" class="span4" id="cpuValue">
	<button id="addcpu">Add</button>
	</div>
	<div><label>Heap</label></div>

	<div class="row">
		<input type="text" name="startDate" class="span4" id="heapStart">
	<input type="text" name="endDate" class="span4" id="heapEnd">
	<input type="text" name="value" class="span4" id="heapValue">
	<button id="addheap">Add</button>
	</div>
	<div><label>Non-Heap</label></div>

	<div class="row">
		 <input type="text" name="startDate" class="span4" id="nonheapStart">
	<input type="text" name="endDate" class="span4" id="nonheapEnd">
	<input type="text" name="value" class="span4" id="nonheapValue">
	<button id="addnonheap">Add</button>
	</div>
</div>
<script type="text/javascript">
	var listRam=[];
$( "#addRam" ).click(function() {
	alert('ok');
	var startDate=$('#ramStart').val();
	var endDate=$('#ramEnd').val();
	var value=$('#ramValue').val();
	listRam.push({start: startDate, end:endDate, value: value});
	console.log(listRam);
	
	
addGui();
$('#ramStart').val('-1');
$('#ramEnd').val('-1');
$('#ramValue').val('-1');
});	
function removeRam(i){
	console.log(i);
	listRam.splice(i,1);
	addGui(listRam);
}
function addGui(){
	var b="";
	$.each(listRam, function(i){
		 b+="<div class=\"row\">";
		 b+="<input type=\"text\" name=\"ramStart"+i+"\" class=\"span4\" value=\""+listRam[i].start+"\" disabled>";
			 b+="<input type=\"text\" name=\"ramEnd"+i+"\" class=\"span4\" value=\""+listRam[i].end+"\"disabled>";
			 b+="<input type=\"text\" name=\"ramValue"+i+"\" class=\"span3\" value=\""+listRam[i].value+"\"disabled>";
			 b+="<button onclick=\"removeRam("+i+")\" class=\"btn btn-danger\" style=\"margin-top:-8px;\">Xóa</button>";
			 b+="</div>";
		
	});
	     $('#infoRam').html(b);
}

</script>