<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Form</title>
</head>
<body>
<%@page import="com.Admin.dao.CustomerDao,com.Admin.bean.Customer"%>

<%
String id=request.getParameter("id");
Customer u=CustomerDao.getRecordById(Integer.parseInt(id));
%>

<h1>Edit Form</h1>
<form action="editcus.jsp" method="post">
<input type="hidden" name="id" value="<%=u.getId() %>"/>
<table>
<tr><td>Fname:</td><td><input type="text" name="fname" value="<%= u.getFname()%>"/></td></tr>
<tr><td>Password:</td><td><input type="lname" name="lname" value="<%= u.getLname()%>"/></td></tr>
<tr><td>Age:</td><td><input type="number" name="age" value="<%= u.getAge()%>"/></td></tr>
<tr><td>Gender:</td><td><input type="radio" name="gender" value="male"/>Male <input type="radio" name="gender" value="female"/>Female </td></tr>


<tr><td colspan="2"><input type="submit" value="Edit User"/></td></tr>
</table>
</form>

</body>
</html>