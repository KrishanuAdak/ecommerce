<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="DAO.CustomerDAO,java.util.*,MODEL.Customer" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<%
String name=(String)session.getAttribute("username");
String e=(String) session.getAttribute("email");
String passw=(String) session.getAttribute("password");
CustomerDAO dao=new CustomerDAO();
String x=dao.getAddress(name);
%>
<div style="display:flex;justify-content:center;align-items:center;margin:40px 40px;">
<div class="card" style="width: 18rem;display:flex;justify-content:center;align-items:center">
  <img src="https://images.rawpixel.com/image_png_800/cHJpdmF0ZS9sci9pbWFnZXMvd2Vic2l0ZS8yMDIzLTAxL3JtNjA5LXNvbGlkaWNvbi13LTAwMi1wLnBuZw.png" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">Your Name : <%=name %></h5>
    <p class="card-text"><b>Your Email</b> : <%=e %></p>
        <p class="card-text"><b>Your Password</b> : <%=passw %></p>
           <a href="#" class="btn btn-outline-primary">Update Your Pasword</a>
          <p class="card-text">Your Address : <%=x %></p>   
           <a href="#" class="btn btn-outline-primary">Update Your Address</a>
  </div>
</div>
</div>



</body>
</html>