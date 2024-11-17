<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
 
</head>
<body>

<%String y=request.getParameter("netbanking"); %>
<h3 style="color:red;">Coming Soon!<%=y %></h3>
<% 

if(y.equalsIgnoreCase("hdfcBank"))
{%>
<%@include file="Bank.jsp" %>
<%} %>
</body>
</html>