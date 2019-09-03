<%@page import="com.Admin.dao.CustomerDao"%>
<jsp:useBean id="u" class="com.Admin.bean.Customer"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
CustomerDao.delete(u);
response.sendRedirect("viewcus.jsp");
%>