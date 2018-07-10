<%@ include file="/html/alarm/init.jsp"%>
<%@ page pageEncoding="UTF-8"%>
<aui:form cssClass="wrapfrm-Registry" name="fm" method="post"
	enctype="multipart/form-data">
	<aui:container fluid="false">
		<h1 style="float: inherit;">Thiết lập thông số cảnh báo</h1>
		<aui:row>
			<aui:col span="6">
				<p>Ram(%)</p>
			</aui:col>
			<aui:col span="6">
				<aui:input name="ram" label="">
				</aui:input>
			</aui:col>

		</aui:row>
		<aui:row>
			<aui:col span="6">
				<p>CPU(%)</p>
			</aui:col>
			<aui:col span="6">
				<aui:input name="cpu" label="">
				</aui:input>
			</aui:col>

		</aui:row>
		<aui:row>
			<aui:col span="6">
				<p>Heap(%)</p>
			</aui:col>
			<aui:col span="6">
				<aui:input name="nonHeap" label="">
				</aui:input>
			</aui:col>

		</aui:row>
		<aui:row>
			<aui:col span="6">
				<p>NonHeap(%)</p>
			</aui:col>
			<aui:col span="6">
				<aui:input name="heap" label="">
				</aui:input>
			</aui:col>

		</aui:row>
		<h3>Thông tin nhận cảnh báo</h3>
		<aui:row>
			<aui:col span="6">
				<aui:input name="nonHeap" label="Tên">
				</aui:input>
			</aui:col>
			<aui:col span="6">
				<aui:input name="nonHeap" label="Email">
				</aui:input>
			</aui:col>

		</aui:row>
		<aui:button type="submit" ></aui:button>
	</aui:container>
</aui:form>