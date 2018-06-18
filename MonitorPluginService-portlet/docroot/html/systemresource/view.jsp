<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />
<portlet:actionURL name="method1" var="actionURLByPortletTagURL">
</portlet:actionURL>
<form action="${actionURLByPortletTagURL}" method="post">
    <input type="submit" value="Submit"> 
</form>
