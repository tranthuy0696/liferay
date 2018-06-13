

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<portlet:defineObjects />

<portlet:renderURL var="memoryURL">
	<portlet:param name="mvcPath" value="/html/systemresource/view.jsp" />
</portlet:renderURL>
<portlet:renderURL var="cpuURL">
	<portlet:param name="mvcPath" value="/html/systemresource/cpu.jsp" />
</portlet:renderURL>
<portlet:renderURL var="heapURL">
	<portlet:param name="mvcPath" value="/html/systemresource/heap.jsp" />
</portlet:renderURL>
<portlet:renderURL var="nonheapURL">
	<portlet:param name="mvcPath" value="/html/systemresource/nonheap.jsp" />
</portlet:renderURL>

<ul class="nav nav-tabs nav-stacked">
		<li><a href="${memoryURL}">Memory</a></li>
		<li><a href="${cpuURL}">Cpu</a></li>
		<li><a href="${heapURL}">JVM_Heap</a></li>
		<li><a href="${nonheapURL}">JVM_NonHeap</a></li>

	</ul>
