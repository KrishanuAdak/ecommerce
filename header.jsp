<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="DAO.CartDAO,DAO.CustomerDAO,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<style>
.navbar{
	display:flex;
	justify-content:space-between;
	
	background-color:black;
	color:white;


}
a{
text-decoration:none;
}
b{
color:red;
}

h4{
color:white;
}
h4:hover{
color:grey;
}

</style>
<%String name=(String) session.getAttribute("username"); 
String otp_name=(String) session.getAttribute("otp-name"); 
CustomerDAO d=new CustomerDAO();
int id=d.getIdOfCustomer(name);
CartDAO dao=new CartDAO();
int id2=d.getIdOfCustomer(otp_name);
int x=0;

String r="";

if(session.getAttribute("username")==null)
{
	r=otp_name;
	x=dao.getRowCount(id2);
	
}
else{
	r=name;
	x=dao.getRowCount(id);
}


%>

<div class="navbar">
<div>

<a href="Home.jsp"><h4>Shopping store</h4></a>
</div>
<div class="right">

<div>

<a href="Cart.jsp" style="text-decoration:none"><h4> Your Cart<b>(<%=x %>)</b></h4></a>

</div>

<div>
<a href="Account.jsp"><h4>Your Account</h4></a>
</div>
<div>
<a href="ViewOrders.jsp"><h4>View Orders</h4></a>
</div>

<div>
<h4><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSqJ64OjHJ2GXpTZqsuJAVI3Epg3WqQUZFE9eGt-Tj4sw&s" height="40px" style="border-radius:20px" width="40px"><span>
<%=r
%>
</span></h4></div>
</div>
<div>

  <a href="LogoutServlets"><h4>Logout</h4></a>

</div>
</div>

</body>
</html>