<%@ include file="/html/alarm/init.jsp"%>
<%@ page pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>
.help-block {
	color: red;
}

select.span4.selectpicker {
	height: 36px !important;
	border-radius: 5px !important;
}

select.span3.selectpicker {
	height: 36px !important;
	border-radius: 5px !important;
}

input.span4 {
	height: 36px !important;
	border-radius: 5px !important;
}

input.span3 {
	height: 36px !important;
	border-radius: 5px !important;
}
</style>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<div class="container" style="margin-top: 20px;">
	<div class="text-center">Thiet lap thong so</div>
	<aui:form name="form-ram">
		<aui:row>
			<aui:col span="4">
				<aui:select name="ramStart" label="Từ" required="true" cssClass="span12">
					<%
						for(int i=0;i<24;i++){
					%>
					<aui:option value="<%=i%>"><%=i%> Giờ</aui:option>
					<%
						}
					%>
				</aui:select>
			</aui:col>

			<aui:col span="4">
				<aui:select name="ramEnd" label="Đến " required="true" cssClass="span12">
					<%
						for(int i=0;i<24;i++){
					%>
					<aui:option value="<%=i%>"><%=i%> Giờ</aui:option>
					<%
						}
					%>
				</aui:select>
			</aui:col>

			<aui:col span="3">
				<aui:input name="ramValue" required="true" label="Giá trị"
					placeholder="Giá trị (GB)" cssClass="span12"></aui:input>
			</aui:col>
			<aui:col span="1">
				<aui:button cssClass="btn-success" name="saveModal" value="Thêm"
					class="" onclick="addRam()"></aui:button>
			</aui:col>

		</aui:row>

	</aui:form>
	<div id="infoRam"></div>
	<div>
		<label>CPU</label>
	</div>

	<div class="row">
		<input type="text" name="startDate" class="span4" id="cpuStart">
		<input type="text" name="endDate" class="span4" id="cpuEnd"> <input
			type="text" name="value" class="span4" id="cpuValue">
		<button id="addcpu">Add</button>
	</div>
	<div>
		<label>Heap</label>
	</div>

	<div class="row">
		<input type="text" name="startDate" class="span4" id="heapStart">
		<input type="text" name="endDate" class="span4" id="heapEnd">
		<input type="text" name="value" class="span4" id="heapValue">
		<button id="addheap">Add</button>
	</div>
	<div>
		<label>Non-Heap</label>
	</div>

	<div class="row">
		<input type="text" name="startDate" class="span4" id="nonheapStart">
		<input type="text" name="endDate" class="span4" id="nonheapEnd">
		<input type="text" name="value" class="span4" id="nonheapValue">
		<button id="addnonheap">Add</button>
	</div>
</div>

<aui:script use="aui-node,aui-io-plugin-deprecated,liferay-util-window, liferay-portlet-url">
var listRam = [];
Liferay.provide(window, 'addRam',
		function() {
			var formValidator = Liferay.Form
					.get('<portlet:namespace />form-ram').formValidator;
			formValidator.validate();
			if (!formValidator.hasErrors()) {
				
				var startDate = A.one('#<portlet:namespace />ramStart').val();
				var endDate = A.one('#<portlet:namespace />ramEnd').val();
				var value = A.one('#<portlet:namespace />ramValue').val();
				listRam.push({
					start : startDate,
					end : endDate,
					value : value
				});
				addGui();
				
}
});
function addGui(){
	var b="";
	var a="aui";
	if(listRam.length>0){
		b="<auiform name=\"ram_alarm\">";
	}
	$.each(listRam, function(i){
		var tmp="<row>";
		b+=tmp;
		tmp="<col span=\"4\">";
		b+=tmp;
		tmp="<input name=\"ramStart"+i+"\" cssClass=\"span12\" value=\""+listRam[i].start+"\" disabled></input>";
		b+=tmp;
		tmp="</col>";
		b+=tmp;
		tmp="<col span=\"4\">";
		b+=tmp;
		tmp="<input name=\"ramEnd"+i+"\" cssClass=\"span12\" value=\""+listRam[i].end+"\" disabled></input>";
		b+=tmp;
		tmp="</col>";
		b+=tmp;
		tmp="<col span=\"3\">";
		b+=tmp;
		tmp="<input name=\"ramValue"+i+"\" cssClass=\"span12\" value=\""+listRam[i].value+"\" disabled></input>";
		b+=tmp;
		tmp="</col>";
		b+=tmp;
		 tmp="<button onclick=\"removeRam("+i+")\" class=\"btn btn-danger\">Xóa</button>";
		 b+=tmp;
		tmp="</row>";
		b+=tmp;
		
	});
	if(listRam.length>0){
		b+="</form>";
	}
	console.log(b);
	     $('#infoRam').html(b);
}

</aui:script>