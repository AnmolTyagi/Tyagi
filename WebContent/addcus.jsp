<%@page import="com.Admin.dao.CustomerDao"%>
<jsp:useBean id="u" class="com.Admin.bean.Customer"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
int i=CustomerDao.save(u);
if(i>0){
response.sendRedirect("addcus-success.jsp");
}else{
response.sendRedirect("addcus-error.jsp");
}
%>