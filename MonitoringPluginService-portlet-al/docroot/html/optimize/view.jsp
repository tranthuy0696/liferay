<%@page import="com.nlu.model.JvmOption"%>
<%@page import="com.nlu.service.JvmService"%>
<%@ include file="/html/alarm/init.jsp"%>
<%@ page pageEncoding="UTF-8"%>
<%
	JvmService jvm = new JvmService();
	JvmOption jvmOp = jvm.getInfo();
	JvmOption jvmSg = jvm.getJvmSuggest();
%>
<portlet:actionURL name="setJvm1" var="actionURLByPortletTagInfo1">
</portlet:actionURL>
<aui:form action="${actionURLByPortletTagInfo1}" method="post"><aui:button type="submit" value="Ghi lại"></aui:button></aui:form>
<portlet:actionURL name="setJvm" var="actionURLByPortletTagInfo">
</portlet:actionURL>
<aui:form action="${actionURLByPortletTagInfo}" method="post">
	<aui:container fluid="false">
		<h3 class="text-center">Cấu hình thông số Jvm</h3>
		<aui:row>
			<aui:col span="4">
				<h5>Xmx</h5>
				<p>
					Đề nghị:<i style="color: red"><%=jvmSg.getXmx()%></i>
				</p>


			</aui:col>
			<aui:col span="8">
				<aui:input name="xmx" label="" value='<%=jvmOp.getXmx()%>'>
				</aui:input>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="4">
				<h5>Xms</h5>
				<p>
					Đề nghị:<i style="color: red"><%=jvmSg.getXms()%></i>
				</p>
			</aui:col>
			<aui:col span="8">
				<aui:input name="xms" label="" value='<%=jvmOp.getXms()%>'>
				</aui:input>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="4">
				<h5>NewSize</h5>
				<p>
					Đề nghị:<i style="color: red"><%=jvmSg.getNewSize()%></i>
				</p>
			</aui:col>
			<aui:col span="8">
				<aui:input name="newSize" label="" value='<%=jvmOp.getNewSize()%>'>
				</aui:input>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="4">
				<h5>MaxNewSize</h5>
				<p>
					Đề nghị:<i style="color: red"><%=jvmSg.getMaxNewSize()%></i>
				</p>
			</aui:col>
			<aui:col span="8">
				<aui:input name="maxNewSize" label=""
					value='<%=jvmOp.getMaxNewSize()%>'>
				</aui:input>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="4">
				<h5>MaxPermSize</h5>
				<p>
					Đề nghị:<i style="color: red"><%=jvmSg.getMaxPermSize()%></i>
				</p>
			</aui:col>
			<aui:col span="8">
				<aui:input name="maxPermSize" label=""
					value='<%=jvmOp.getMaxPermSize()%>'>
				</aui:input>
			</aui:col>
		</aui:row>
		<aui:button type="submit" value="Ghi lại"></aui:button>
	</aui:container>

</aui:form>
