<%@ include file="/html/alarm/init.jsp"%>
<%@ page pageEncoding="UTF-8"%>
<portlet:actionURL name="getApi" var="actionURLByPortletTagURL3">
</portlet:actionURL>
<form action="${actionURLByPortletTagURL3}" method="post">
	<input type="submit" value="getAPI">
</form>
<portlet:actionURL name="getUrl" var="actionURLByPortletTagURLRam">
</portlet:actionURL>
<form action="${actionURLByPortletTagURLRam}" method="post">
	<input type="submit" value="getRam">
</form>
<ul class="cd-accordion-menu animated">
	<li class="has-children"><input type="checkbox" name="sub-group-1"
		id="sub-group-1"> <label for="sub-group-1">multi-level-accordion-menu-master(7)</label>
		<ul>
			<li class="has-children"><input type="checkbox"
				name="sub-group-2" id="sub-group-2"> <label
				for="sub-group-2">css(2)</label>
				<ul>
					<li><a href="#0">reset.css</a></li>
					<li><a href="#0">style.css</a></li>
				</ul>
			<li class="has-children"><input type="checkbox"
				name="sub-group-2" id="sub-group-2"> <label
				for="sub-group-2">img(1)</label>
				<ul>
					<li><a href="#0">cd-icons.svg</a></li>
				</ul>
			<li><a href="#0">index.html</a></li>
			<li class="has-children"><input type="checkbox"
				name="sub-group-2" id="sub-group-2"> <label
				for="sub-group-2">js(3)</label>
				<ul>
					<li><a href="#0">jquery-2.1.4.js</a></li>
					<li><a href="#0">main.js</a></li>
					<li><a href="#0">modernizr.js</a></li>
				</ul>
			<li><a href="#0">README.md</a></li>
			<li><a href="#0">textFoler.html</a></li>
			<li class="has-children"><input type="checkbox"
				name="sub-group-2" id="sub-group-2"> <label
				for="sub-group-2">tmp(0)</label>
		</ul>
</ul>