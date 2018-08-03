<%@page import="com.nlu.entity.model.Alarm"%>
<%@page import="java.util.List"%>
<%@page import="com.nlu.entity.service.AlarmInfoLocalServiceUtil"%>
<%@page import="com.nlu.entity.model.AlarmInfo"%>

<%@ include file="/html/alarm/init.jsp"%>
<%@ page pageEncoding="UTF-8"%>
<portlet:actionURL name="saveAlarm" var="actionURLByPortletTagURLRam">
</portlet:actionURL>
<portlet:actionURL name="saveInfo" var="actionURLByPortletTagInfo">
</portlet:actionURL>
<%
	List<AlarmInfo> ram = AlarmInfoLocalServiceUtil.findName("ram");
	List<AlarmInfo> cpu = AlarmInfoLocalServiceUtil.findName("cpu");
	List<AlarmInfo> heap = AlarmInfoLocalServiceUtil.findName("heap");
	List<AlarmInfo> nonHeap = AlarmInfoLocalServiceUtil.findName("nonHeap");
%>

<div class="tabbable">
	<!-- Only required for left/right tabs -->
	<ul class="nav nav-tabs" id="tab-nav">
		<li class="active"><a href="#tab1" data-toggle="tab">Thông
				tin cảnh báo</a></li>
		<li><a href="#tab2" data-toggle="tab">Thông tin người nhận</a></li>
	</ul>
	<div class="tab-content">
		<div class="tab-pane active" id="tab1">
			<aui:form action="${actionURLByPortletTagURLRam}" method="post"><aui:button type="submit"></aui:button></aui:form>
			
			<aui:row>
				<aui:col span="3">
					<p>Từ giờ</p>
					<select name="startHour" id="startHour">
						<c:forEach begin="0" end="23" var="gio">
							<option value="${gio}">${gio}h</option>
						</c:forEach>

					</select>
				</aui:col>
				<aui:col span="3">
					<p>Đến giờ</p>
					<select name="endHour" id="endHour">
						<c:forEach begin="0" end="23" var="gio">
							<option value="${gio}">${gio}h</option>
						</c:forEach>

					</select>
				</aui:col>
				<aui:col span="4">
					<p>Giá trị</p>
					<aui:input name="value" label="" id="value"></aui:input>
				</aui:col>
				<aui:col span="2">
					<button class="btn btn-primary" onClick="fnAjaxCall()"
						href="javascript:void('0')">Thêm</button>
					<button class="btn btn-primary">Xóa</button>
				</aui:col>

			</aui:row>
			<%-- 			<aui:form> --%>
			<%-- 				<aui:container fluid="false"> --%>
			<h1 style="float: inherit;">Thiết lập thông số cảnh báo</h1>
			<h5>Ram</h5>
			<div id="ram">
				<%-- 					<aui:row> --%>
				<%-- 						<aui:col span="3"> --%>
				<!-- 							<p>Từ giờ</p> -->
				<!-- 							<select name="startHour" id="startHour"> -->
				<%-- 								<c:forEach begin="0" end="23" var="gio"> --%>
				<%-- 									<option value="${gio}">${gio}h</option> --%>
				<%-- 								</c:forEach> --%>

				<!-- 							</select> -->
				<%-- 						</aui:col> --%>
				<%-- 						<aui:col span="3"> --%>
				<!-- 							<p>Đến giờ</p> -->
				<!-- 							<select name="endHour" id="endHour"> -->
				<%-- 								<c:forEach begin="0" end="23" var="gio"> --%>
				<%-- 									<option value="${gio}">${gio}h</option> --%>
				<%-- 								</c:forEach> --%>

				<!-- 							</select> -->
				<%-- 						</aui:col> --%>
				<%-- 						<aui:col span="4"> --%>
				<!-- 							<p>Giá trị</p> -->
				<%-- 							<aui:input name="value" label="" id="value"></aui:input> --%>
				<%-- 						</aui:col> --%>
				<%-- 						<aui:col span="2"> --%>
				<!-- 							<button class="btn btn-primary" onClick="fnAjaxCall()" href="javascript:void('0')">Thêm</button> -->
				<!-- 							<button class="btn btn-primary">Xóa</button> -->
				<%-- 						</aui:col> --%>

				<%-- 					</aui:row> --%>

			</div>

			<aui:row>

			</aui:row>
			<h5>Cpu</h5>
			<aui:row>



			</aui:row>
			<h5>Heap</h5>
			<aui:row>


			</aui:row>
			<h5>NonHeap</h5>
			<aui:row>



			</aui:row>
			<aui:button type="submit"></aui:button>
			<!-- 		<input type="submit" value="Submit">  -->

			<%-- 				</aui:container> --%>
			<%-- 			</aui:form> --%>
		</div>
		<div class="tab-pane" id="tab2">

			<aui:form action="${actionURLByPortletTagInfo}" method="post">
				<aui:container fluid="false">
					<h3>Thông tin nhận cảnh báo</h3>
					<aui:row>
						<aui:col span="4">
							<p>Ram</p>
							<div hidden="true">
								<aui:input type="number" name="ram"
									value='<%=!ram.isEmpty() ? ram.get(0).getPrimaryKey() : ""%>'></aui:input>
							</div>

						</aui:col>
						<aui:col span="8">
							<aui:input name="mailRam" label="Email"
								value='<%=!ram.isEmpty() ? ram.get(0).getMail() : ""%>'>
							</aui:input>
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col span="4">
							<p>Cpu</p>
							<div hidden="true">
								<aui:input type="number" name="cpu"
									value='<%=!cpu.isEmpty() ? cpu.get(0).getPrimaryKey() : ""%>'></aui:input>
							</div>
						</aui:col>
						<aui:col span="8">
							<aui:input name="mailCpu" label="Email"
								value='<%=!cpu.isEmpty() ? cpu.get(0).getMail() : ""%>'>
							</aui:input>
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col span="4">
							<p>Heap</p>
							<div hidden="true">
								<aui:input type="number" name="heap"
									value='<%=!heap.isEmpty() ? heap.get(0).getPrimaryKey() : ""%>'></aui:input>
							</div>
						</aui:col>
						<aui:col span="8">
							<aui:input name="mailHeap" label="Email"
								value='<%=!heap.isEmpty() ? heap.get(0).getMail() : ""%>'>
							</aui:input>
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col span="4">
							<p>NonHeap</p>
							<div hidden="true">
								<aui:input type="number" name="nonHeap"
									value='<%=!nonHeap.isEmpty() ? nonHeap.get(0).getPrimaryKey() : ""%>'></aui:input>
							</div>
						</aui:col>
						<aui:col span="8">
							<aui:input name="mailNonHeap" label="Email"
								value='<%=!nonHeap.isEmpty() ? nonHeap.get(0).getMail() : ""%>'>
							</aui:input>
						</aui:col>
					</aui:row>
					<aui:button type="submit"></aui:button>
				</aui:container>

			</aui:form>
		</div>
	</div>
</div>
<script>
	var list = [];
	function fnAjaxCall() {
		$('#ram').remove();
		alert('ok');
		var startHour = $('#startHour').val();
		alert(startHour);
		var endHour = $('#endHour').val();
		var value = $('#<portlet:namespace />value').val();
		console.log(startHour);
		console.log(endHour);
		console.log(value);
		list.push({
			name : 'ram',
			startHour : startHour,
			endHour : endHour,
			value : value
		});
		console.log(list);
		$.each(list, function(i) {
			alert(list[i]);
			$('#ram').html("<h2>hello</h2>");
		});
	}
</script>