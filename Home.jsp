<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="DAO.ProductDAO,DAO.CustomerDAO,MODEL.Product,MODEL.Product_Fashion,java.util.*" %>
    <%@ page import="jakarta.servlet.http.HttpSession" %>
    <%
      response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
    String xe=(String) session.getAttribute("username");
    System.out.println(xe);
    CustomerDAO daoq=new CustomerDAO();
    int r=daoq.getIdOfCustomer(xe);
    
    
    
      if(session.getAttribute("username")==null && session.getAttribute("otp-name")==null)
      {
    	
    	  response.sendRedirect("Login.jsp");
    	 
      }
    %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<jsp:include page="header.jsp" flush="true"/>  
<%
int count=0;
%>
<style>
image:hover{
optacity:1
}
html {
  scroll-behavior: smooth;
}
.navbar{
	display:flex;
	justify-content:space-around;
	
	background-color:black;
	color:white;
	height:70px;

}
.right{
	display:flex;

	gap:20px;
}
h2{
	cursor:pointer;
}
h2:hover{
	color:green;
}

.body{
border:1px solid transparent;

display:flex;
justify-content:center;
align-items:center;
}
table,td,tr{
border:1px solid green;
}
body{
background-color:white;
}
ul{
display:flex;
	justify-content:center;
	align-items:center;
	gap:20px;
}
li{
list-style:none;
}
a{
text-decoration:none;
list-style:none;
color:black;
}
body {
  margin: 0;
}
img:hover{
cursor:pointer;
}
h3 {
  width: 100%;
}
h3 {
  text-align: right;
  animation: left_to_right 10s linear infinite;
 
}
@keyframes left_to_right {
  from {
    margin-left: -100%;
  }
  to {
    margin-left: 0;
   
  }
}
input[type="search"]{
width:400px;
height:39px;
}
</style>
<div id="scroll-container">
  <h3 style="background-color:lightgrey">Hurry Up!! Sell is going | offers are Just knocking you!!</h3>
</div>
 
<div style="display:flex;justify-content:center;align-items:center;">
<form action="SearchBar.jsp?name=?" method="get">
<input type="search" placeholder="Search for Products" name="search">
<button type="submit" class="btn btn-outline-success">Search</button>
</form>
</div>
    
    
   
<div id="show" style="display:flex;flex-wrap:wrap;justify-content:center;align-items:center;margin:20px 20px;gap:10px;">
<%

ProductDAO dao=new ProductDAO();
String h=request.getParameter("search");
ArrayList<Product> lists=dao.viewProducts();
for(Product e:lists)
{
	%>
	<div class="card" style="width:18rem;">
	<a href="ProductDetails.jsp?id=<%=e.product_id %>">
       <img class="card-img-top" src="<%=e.image %>" alt="Card image cap" style="width:250px;height:200px;margin:10px 20px;">
     <div class="card-body">
     <hr>
         <h5 class="card-title"><%=e.product_name %></h5>
         <p class="card-text"><%=e.price %></p>
         <p class="card-text"><%=e.product_desc %></p>
     </div>
     </a>

      </div>



	
<%
}
%>	
</div>
<div>
<a href="#show">Back to top</a>
</div>

<div class="footer">
<div class="one">
</div>
<div class="two">
</div>
<div class="three">
</div>
<div class="four">
</div>

</div>
</body>
</html>