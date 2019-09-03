<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show The Insertion</title>
</head>
<body>

<%@page import="com.Admin.dao.CustomerDao,com.Admin.bean.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Welcome to the world of Global Logic</h1>
<%
Cookie ck[] =request.getCookies();
for(int i=0;i<ck.length;i++){
out.print("<br>"+"Cookie Name:\t" +ck[i].getName()+"\t"+"Cookie Value: "+ck[i].getValue());
}
%>

<%
List<Customer> list=CustomerDao.getAllRecords();
request.setAttribute("list",list);
%>

<table border="1" width="90%">
<tr><th>Id</th><th>Fname</th><th>Lname</th><th>Age</th><th>Gender</th><th>Edit</th><th>Delete</th></tr>
<c:forEach items="${list}" var="u">

	<tr>
	<td>${u.getId()}</td>
	<td>${u.getFname()}</td>
	<td>${u.getLname()}</td>
	<td>${u.getAge()}</td>
	<td>${u.getGender()}</td>
	<td><a href="editform.jsp?id=${u.getId()}">Edit</a></td>
	<td><a href="deletecus.jsp?id=${u.getId()}">Delete</a></td>
	</tr>
</c:forEach>
</table>
<br/><a href="addcusform.jsp">Add New User</a>

</body>
</html>