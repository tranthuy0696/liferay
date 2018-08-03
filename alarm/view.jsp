<%@page import="com.nlu.util.SystemUtil"%>
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
#infoRam{
background: #F4F2F2;}
#infoCpu{
background: #F4F2F2;}
#infoHeap{
background: #F4F2F2;}
#infoNonHeap{
background: #F4F2F2;}
#infoSession{
background: #F4F2F2;}


</style>
<%double maxMemory=SystemUtil.getMaxMemory();
double maxMemoryGB = SystemUtil.convertByteToGB(maxMemory);
double maxHeapMB = SystemUtil.convertByteToMB(SystemUtil.getMaxHeapMemory());
double maxNonHeapMB = SystemUtil.convertByteToMB(SystemUtil.getNonMaxHeapMemory()); %>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<portlet:resourceURL id="setupAlarm" var="setupAlarm"></portlet:resourceURL>
<div class="container" style="margin-top: 20px;">
	<div class="text-center" style="font-size:25px;">Thiết lập thông số</div>
	<div><label>Memory: </label></div>
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
					placeholder="(GB)" cssClass="span12">
					 <aui:validator name="number"></aui:validator>
					 <aui:validator name="validateValue"></aui:validator>
					</aui:input>
			</aui:col>
			<aui:col span="1">
				<aui:button cssClass="btn-success" name="saveModal" value="Thêm"
					class="" onclick="addRam()" style="margin-top:20px"></aui:button>
			</aui:col>

		</aui:row>

	</aui:form>
	<div class="help-block text-center ramerr"></div>
	<div id="infoRam"></div>
	<div><label>CPU: </label></div>
	<aui:form name="form-cpu">
		<aui:row>
			<aui:col span="4">
				<aui:select name="cpuStart" label="Từ" required="true" cssClass="span12">
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
				<aui:select name="cpuEnd" label="Đến " required="true" cssClass="span12">
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
				<aui:input name="cpuValue" required="true" label="Giá trị"
					placeholder="Giá trị <=100(%)" cssClass="span12">
					 <aui:validator name="number"></aui:validator>
					 <aui:validator name="validateValue"></aui:validator>
					</aui:input>
			</aui:col>
			<aui:col span="1">
				<aui:button cssClass="btn-success" name="saveModal" value="Thêm"
					class="" onclick="addCpu()" style="margin-top:20px"></aui:button>
			</aui:col>

		</aui:row>

	</aui:form>
	<div id="infoCpu"></div>
	<div><label>Heap: </label></div>
	<aui:form name="form-heap">
		<aui:row>
			<aui:col span="4">
				<aui:select name="heapStart" label="Từ" required="true" cssClass="span12">
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
				<aui:select name="heapEnd" label="Đến " required="true" cssClass="span12">
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
				<aui:input name="heapValue" required="true" label="Giá trị"
					placeholder="(MB)" cssClass="span12">
					 <aui:validator name="number"></aui:validator>
					 <aui:validator name="validateValue"></aui:validator>
					</aui:input>
			</aui:col>
			<aui:col span="1">
				<aui:button cssClass="btn-success" name="saveModal" value="Thêm"
					class="" onclick="addHeap()" style="margin-top:20px"></aui:button>
			</aui:col>

		</aui:row>

	</aui:form>
	<div id="infoHeap"></div>
	<div><label>Non-Heap: </label></div>
	<aui:form name="form-nonHeap">
		<aui:row>
			<aui:col span="4">
				<aui:select name="nonHeapStart" label="Từ" required="true" cssClass="span12">
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
				<aui:select name="nonHeapEnd" label="Đến " required="true" cssClass="span12">
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
				<aui:input name="nonHeapValue" required="true" label="Giá trị"
					placeholder="(MB)" cssClass="span12">
					 <aui:validator name="number"></aui:validator>
					 <aui:validator name="validateValue"></aui:validator>
					</aui:input>
			</aui:col>
			<aui:col span="1">
				<aui:button cssClass="btn-success" name="saveModal" value="Thêm"
					class="" onclick="addNonHeap()" style="margin-top:20px"></aui:button>
			</aui:col>

		</aui:row>

	</aui:form>
	<div id="infoNonHeap"></div>
	<div><label>Session: </label></div>
	<aui:form name="form-session">
		<aui:row>
			<aui:col span="4">
				<aui:select name="sessionStart" label="Từ" required="true" cssClass="span12">
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
				<aui:select name="sessionEnd" label="Đến " required="true" cssClass="span12">
					<%
						for(int i=0;i<24;i++){
					%>
					<aui:option value="<%=i%>"><%=i%> Giờ</aui:option>
					<%
						}
					%>x`
				</aui:select>
			</aui:col>

			<aui:col span="3">
				<aui:input name="sessionValue" required="true" label="Giá trị"
					placeholder="" cssClass="span12">
					 <aui:validator name="number"></aui:validator>
					  <aui:validator name="validateValue"></aui:validator>
					</aui:input>
			</aui:col>
			<aui:col span="1">
				<aui:button cssClass="btn-success" name="saveModal" value="Thêm"
					class="" onclick="addSession()" style="margin-top:20px"></aui:button>
			</aui:col>

		</aui:row>

	</aui:form>
	<div class="help-block text-center sessionerr"></div>
	<div id="infoSession"></div>
	<div class="text-center">
	<button onclick="submit()" class="btn btn-success" type="button">Ghi lại</button>
	</div>
</div>
<aui:script use="aui-node,aui-io-plugin-deprecated,liferay-util-window, liferay-portlet-url">
var listRam = [];
var listCpu=[];
var listHeap=[];
var listNonHeap=[];
var listSession=[];
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
Liferay.provide(window, 'addHeap',
		function() {
			var formValidator = Liferay.Form
					.get('<portlet:namespace />form-heap').formValidator;
			formValidator.validate();
			if (!formValidator.hasErrors()) {
				
				var startDate = A.one('#<portlet:namespace />heapStart').val();
				var endDate = A.one('#<portlet:namespace />heapEnd').val();
				var value = A.one('#<portlet:namespace />heapValue').val();
				listHeap.push({
					start : startDate,
					end : endDate,
					value : value
				});
				addGuiHeap();
				
}
});
Liferay.provide(window, 'addNonHeap',
		function() {
			var formValidator = Liferay.Form
					.get('<portlet:namespace />form-nonHeap').formValidator;
			formValidator.validate();
			if (!formValidator.hasErrors()) {
				
				var startDate = A.one('#<portlet:namespace />nonHeapStart').val();
				var endDate = A.one('#<portlet:namespace />nonHeapEnd').val();
				var value = A.one('#<portlet:namespace />nonHeapValue').val();
				listNonHeap.push({
					start : startDate,
					end : endDate,
					value : value
				});
				addGuiNonHeap();
				
}
});
Liferay.provide(window, 'addCpu',
		function() {
			var formValidator = Liferay.Form
					.get('<portlet:namespace />form-cpu').formValidator;
			formValidator.validate();
			if (!formValidator.hasErrors()) {
				
				var startDate = A.one('#<portlet:namespace />cpuStart').val();
				var endDate = A.one('#<portlet:namespace />cpuEnd').val();
				var value = A.one('#<portlet:namespace />cpuValue').val();
				listCpu.push({
					start : startDate,
					end : endDate,
					value : value
				});
				addGuiCpu();
				
}
});
Liferay.provide(window, 'addSession',
		function() {
			var formValidator = Liferay.Form
					.get('<portlet:namespace />form-session').formValidator;
			formValidator.validate();
			if (!formValidator.hasErrors()) {
				var boo=false;
				var startDate = A.one('#<portlet:namespace />sessionStart').val();
				var endDate = A.one('#<portlet:namespace />sessionEnd').val();
				var value = A.one('#<portlet:namespace />sessionValue').val();
				for(var i=0; i<listSession.length && !boo;i++){
					if(!((startDate>=listSession((i).end)||endDate<=listSession[i].start)&& endDate>startDate)){
						boo=true;
						$('.sessionerr').append('Khoảng khung giờ từ '+startDate+' - '+endDate+' đã tồn tại');
					}
				}
				if(!boo){
					$('.sessionerr').append('');
				listSession.push({
					start : startDate,
					end : endDate,
					value : value
				});
				addGuiSession();
				}
}
});
Liferay.provide(window, 'addGui',
		function() {
	var b="";
	b+="<form id=\"ram_form_info\" name=\"ram_form_info\">";
	b+="<table class=\"table table-hover\">";
	b+="<tr>";
	b+="<th>#</th>"
	b+="<th>Giờ bắt đầu</th>";
	b+="<th>Giờ kết thúc</th>";
	b+="<th>Gía trị</th>";
	b+="<th>Xóa</th>";
	b+="</tr>";
	$.each(listRam, function(i){
		b+="<tr>";
		b+="<td>";
		b+=(i+1);
		b+="</td>";
		b+="<td>";
		 b+="<input type=\"text\" name=\"<portlet:namespace />ramStart"+i+"\" value=\""+listRam[i].start+"\" disabled>";
		b+="</td>";
		b+="<td>";
		 b+="<input type=\"text\" name=\"<portlet:namespace />ramEnd"+i+"\" value=\""+listRam[i].end+"\"disabled>";
		b+="</td>";
		b+="<td>";
		b+="<input type=\"text\" name=\"<portlet:namespace />ramValue"+i+"\" value=\""+listRam[i].value+"\"disabled>";
		b+="</td>";
		b+="<td>";
		b+="<button onclick=\"removeRam("+i+")\" class=\"btn btn-danger\" type=\"button\">Xóa</button>";
		b+="</td>";
		b+="</tr>";
	});
	b+="</table>";
	b+="</form>";
	if(listRam.length==0){
		b="";
	}
	     $('#infoRam').html(b);
});

Liferay.provide(window, 'addGuiCpu',
		function() {
	var b="";
	b+="<form id=\"cpu_form_info\" name=\"cpu_form_info\">";
	b+="<table class=\"table table-hover\">";
	b+="<tr>";
	b+="<th>#</th>"
	b+="<th>Giờ bắt đầu</th>";
	b+="<th>Giờ kết thúc</th>";
	b+="<th>Gía trị</th>";
	b+="<th>Xóa</th>";
	b+="</tr>";
	$.each(listCpu, function(i){
		b+="<tr>";
		b+="<td>";
		b+=(i+1);
		b+="</td>";
		b+="<td>";
		 b+="<input type=\"text\" name=\"<portlet:namespace />cpuStart"+i+"\" value=\""+listCpu[i].start+"\" disabled>";
		b+="</td>";
		b+="<td>";
		 b+="<input type=\"text\" name=\"<portlet:namespace />cpuEnd"+i+"\" value=\""+listCpu[i].end+"\"disabled>";
		b+="</td>";
		b+="<td>";
		b+="<input type=\"text\" name=\"<portlet:namespace />cpuValue"+i+"\" value=\""+listCpu[i].value+"\"disabled>";
		b+="</td>";
		b+="<td>";
		b+="<button onclick=\"removeCpu("+i+")\" class=\"btn btn-danger\" type=\"button\">Xóa</button>";
		b+="</td>";
		b+="</tr>";
	});
	b+="</table>";
	b+="</form>";
	if(listCpu.length==0){
		b="";
	}
	     $('#infoCpu').html(b);
});
Liferay.provide(window, 'addGuiHeap',
		function() {
	var b="";
	b+="<form id=\"heap_form_info\" name=\"heap_form_info\">";
	b+="<table class=\"table table-hover\">";
	b+="<tr>";
	b+="<th>#</th>"
	b+="<th>Giờ bắt đầu</th>";
	b+="<th>Giờ kết thúc</th>";
	b+="<th>Gía trị</th>";
	b+="<th>Xóa</th>";
	b+="</tr>";
	$.each(listHeap, function(i){
		b+="<tr>";
		b+="<td>";
		b+=(i+1);
		b+="</td>";
		b+="<td>";
		 b+="<input type=\"text\" name=\"<portlet:namespace />heapStart"+i+"\" value=\""+listHeap[i].start+"\" disabled>";
		b+="</td>";
		b+="<td>";
		 b+="<input type=\"text\" name=\"<portlet:namespace />heapEnd"+i+"\" value=\""+listHeap[i].end+"\"disabled>";
		b+="</td>";
		b+="<td>";
		b+="<input type=\"text\" name=\"<portlet:namespace />heapValue"+i+"\" value=\""+listHeap[i].value+"\"disabled>";
		b+="</td>";
		b+="<td>";
		b+="<button onclick=\"removeHeap("+i+")\" class=\"btn btn-danger\" type=\"button\">Xóa</button>";
		b+="</td>";
		b+="</tr>";
	});
	b+="</table>";
	b+="</form>";
	if(listHeap.length==0){
		b="";
	}
	     $('#infoHeap').html(b);
});
Liferay.provide(window, 'addGuiNonHeap',
		function() {
	var b="";
	b+="<form id=\"nonHeap_form_info\" name=\"nonHeap_form_info\">";
	b+="<table class=\"table table-hover\">";
	b+="<tr>";
	b+="<th>#</th>"
	b+="<th>Giờ bắt đầu</th>";
	b+="<th>Giờ kết thúc</th>";
	b+="<th>Gía trị</th>";
	b+="<th>Xóa</th>";
	b+="</tr>";
	$.each(listNonHeap, function(i){
		b+="<tr>";
		b+="<td>";
		b+=(i+1);
		b+="</td>";
		b+="<td>";
		 b+="<input type=\"text\" name=\"<portlet:namespace />nonHeapStart"+i+"\" value=\""+listNonHeap[i].start+"\" disabled>";
		b+="</td>";
		b+="<td>";
		 b+="<input type=\"text\" name=\"<portlet:namespace />nonHeapEnd"+i+"\" value=\""+listNonHeap[i].end+"\"disabled>";
		b+="</td>";
		b+="<td>";
		b+="<input type=\"text\" name=\"<portlet:namespace />nonHeapValue"+i+"\" value=\""+listNonHeap[i].value+"\"disabled>";
		b+="</td>";
		b+="<td>";
		b+="<button onclick=\"removeNonHeap("+i+")\" class=\"btn btn-danger\" type=\"button\">Xóa</button>";
		b+="</td>";
		b+="</tr>";
	});
	b+="</table>";
	b+="</form>";
	if(listNonHeap.length==0){
		b="";
	}
	     $('#infoNonHeap').html(b);
});
Liferay.provide(window, 'addGuiSession',
		function() {
	var b="";
	b+="<form id=\"session_form_info\" name=\"session_form_info\">";
	b+="<table class=\"table table-hover\">";
	b+="<tr>";
	b+="<th>#</th>"
	b+="<th>Giờ bắt đầu</th>";
	b+="<th>Giờ kết thúc</th>";
	b+="<th>Gía trị</th>";
	b+="<th>Xóa</th>";
	b+="</tr>";
	$.each(listSession, function(i){
		b+="<tr>";
		b+="<td>";
		b+=(i+1);
		b+="</td>";
		b+="<td>";
		 b+="<input type=\"text\" name=\"<portlet:namespace />sessionStart"+i+"\" value=\""+listSession[i].start+"\" disabled>";
		b+="</td>";
		b+="<td>";
		 b+="<input type=\"text\" name=\"<portlet:namespace />sessionEnd"+i+"\" value=\""+listSession[i].end+"\"disabled>";
		b+="</td>";
		b+="<td>";
		b+="<input type=\"text\" name=\"<portlet:namespace />sessionValue"+i+"\" value=\""+listSession[i].value+"\"disabled>";
		b+="</td>";
		b+="<td>";
		b+="<button onclick=\"removeSession("+i+")\" class=\"btn btn-danger\" type=\"button\">Xóa</button>";
		b+="</td>";
		b+="</tr>";
	});
	b+="</table>";
	b+="</form>";
	if(listSession.length==0){
		b="";
	}
	     $('#infoSession').html(b);
});
Liferay.provide(window, 'removeRam',
		function(i) {
	listRam.splice(i,1);
	addGui(listRam);
});
Liferay.provide(window, 'removeCpu',
		function(i) {
	listCpu.splice(i,1);
	addGuiCpu(listCpu);
});
Liferay.provide(window, 'removeHeap',
		function(i) {
	listHeap.splice(i,1);
	addGuiHeap(listHeap);
});
Liferay.provide(window, 'removeNonHeap',
		function(i) {
	listNonHeap.splice(i,1);
	addGuiNonHeap(listNonHeap);
});
Liferay.provide(window, 'removeSession',
		function(i) {
	listSession.splice(i,1);
	addGuiSession(listSession);
});
Liferay.provide(window, 'submit', function(){
	AUI().use('aui-io-request', function(A) {
		var dataToSend = {
			    ram:[],
			    cpu:[],
			    heap:[],
			    nonheap:[],
			    session:[]
			};
			var ram=[];
			var cpu=[];
			var heap=[];
			var nonHeap=[];
			var session=[];
		$.each(listRam, function(i){
			ram.push({start:listRam[i].start,end:listRam[i].end,value:listRam[i].value});
		});
		$.each(listCpu, function(i){
			cpu.push({start:listCpu[i].start,end:listCpu[i].end,value:listCpu[i].value});
		});
		$.each(listHeap, function(i){
			heap.push({start:listHeap[i].start,end:listHeap[i].end,value:listHeap[i].value});
		});
		$.each(listNonHeap, function(i){
			nonHeap.push({start:listNonHeap[i].start,end:listNonHeap[i].end,value:listNonHeap[i].value});
		});
		$.each(listSession, function(i){
			session.push({start:listSession[i].start,end:listSession[i].end,value:listSession[i].value});
		});
		dataToSend.ram=ram;
		dataToSend.cpu=cpu;
		dataToSend.heap=heap;
		dataToSend.nonheap=nonHeap;
		dataToSend.session=session;
		A.io.request('${setupAlarm}', {
			method : 'get',
			dataType : 'json',
			data:{
				<portlet:namespace />dataSend:JSON.stringify(dataToSend)
			},
			on : {
				success : function(A, id, obj) {
					alert('success');
				}
			}
		});
	});
});
AUI().ready('aui-base', function(A) {
	var DEFAULTS_FORM_VALIDATOR = A.config.FormValidator;
	A.mix(DEFAULTS_FORM_VALIDATOR.RULES, {
		validateValue : function(val, fieldNode, ruleValue) {
			return (val>=0);
		},

	}, true);
	A.mix(DEFAULTS_FORM_VALIDATOR.STRINGS, {
		validateValue : 'Giá trị >=0',
	}, true);
});
</aui:script>