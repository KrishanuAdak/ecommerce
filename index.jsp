<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="DAO.ProductDAO,MODEL.Product,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<style>
* {
box-sizing: border-box;
}
body {
font-family: Verdana, sans-serif;
}
.mySlides
 {
 display: none;
 }
img {
vertical-align: middle;
height:100vh;
width:100%;
}



input{
width:350px;
height:50px;
border-radius:10px;
}
.navbar{
background-color:white;
color:black;
height:100px;

}
.navbar:hover{
border-bottom:2px solid black;
box-shadow:2px 2px 2px  black;
}
div:first-child{
padding:10px;
}
.body{
display:flex;
justify-content:center;
align-items:center;
flex-wrap:wrap;
gap:20px;
}
.image-class{
width:270px;
height:250px;
}
</style>

</head>
<body>

<div class="navbar">
<div>
<h2>Snitch</h2>
<p>Explore your shoppings</p>
</div>
<div>
<input type="search" placeholder="Search your products" name="search-bar">
<button type="search" class="btn btn-success" style="height:47px;">Search</button>
</div>


<div>
<h2><a href="Login.jsp" style="text-decoration:none;color:black">Login</a></h2>
</div>

</div>
<div class="off" style="display:flex;justify-content:space-between;align-items:center;margin:30px 30px;">
<div style="background-color:blue;color:white;font-size:30px;width:60%;height:90px;">
<h3 style="text-align:center;"><strong>FLAT 400 OFF</strong></h3>
</div>
<div style="width:40%;background-color:black;color:white;height:90px;">
<h4 style="text-align:center;margin-top:20px;">On Your First Purchase <br>
<i class="fa-solid fa-shop"></i> via this App</h4>
</div>
</div>

<div style="margin:30px 30px;">
<img src="https://cdn.pixabay.com/photo/2021/07/10/15/45/online-shop-6401739_1280.png">
</div>

<div class="body">
<%
try{
ProductDAO dao=new ProductDAO();
ArrayList<Product> lists=dao.viewProducts();
for(Product x:lists)
{
%>

<div class="card" style="width: 18rem;">
  <img src="<%=x.image %>" name="img"  class="image-class">
 
  <div class="card-body">

  
  </div>
  <ul class="list-group list-group-flush">

  </ul>

  <div class="card-body" style="display:flex;gap:10px;">
  
     
     <form action="Cart" method="post"> 
     <input type="hidden"  name="customer_id" value="1">
     
         <input type="hidden" name="id" value="<%=x.product_id %>">
     
      <input type="hidden" name="price" value="<%=x.price %>">
      <input type="hidden" name="image" value="<%=x.image %>">
      <button type="submit" class="btn btn-outline-success">Add To Cart</button>
      </form>

       <form action="Cart" method="get">
        <input type="hidden" name="id" value=<%=x.product_id %>>
        <button type="submit" class="btn btn-outline-danger">Buy Now</button>
        </form>

  </div>
  
</div>
<%
}
}
catch(Exception e)
{
}
%>
</div>



</body>
</html>