<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="DAO.ProductDAO,java.util.*,MODEL.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<style>
.body{
border:1px solid transparent;
display:flex;
justify-content:center;
align-items:center;
}
</style>
<div class="body" style="display:flex;justify-content:center;gap:20px;align-items:center;flex-wrap:wrap">
<%
try{
ProductDAO dao=new ProductDAO();

ArrayList<Product> li=dao.showElectronicProducts();

for(Product x:li)
{
%>
<div class="card" style="width: 18rem;">
  <img src=<%=x.image %> name="img" class="card-img-top" height="300px">
  <div class="card-body">
    <h5 class="card-title" name="name"><strong><%=x.product_name %></strong></h5>
    <p class="card-text"><%=x.product_desc %></p>
  </div>
  <ul class="list-group list-group-flush">
    <li class="list-group-item" name="price"><%=x.price %></li>
  </ul>
  <div class="card-body" style="display:flex;gap:30px;">
  <form action="Cart" method="post">
    
      <input type="hidden" name="id" value=<%=x.product_id %>>
      <input type="hidden" name="name" value="<%=x.product_name %>">    
      <input type="hidden" name="price" value="<%=x.price %>">
      <input type="hidden" name="image" value="<%=x.image %>">
  
  
    <button type="submit" class="btn btn-outline-success">Add To Cart</button>
    </form>
     <form action="Cart" method="get">

                  <input type="hidden" name="id" value=<%=x.product_id %>>
                  <input type="hidden" name="name" value=<%=x.product_name %>>
                  <input type="hidden" name="price" value=<%=x.price %>>
       <a href="PaymentFirst.jsp"> <button type="submit" class="btn btn-outline-primary">Buy Now</button></a>
       </form>
 
  </div>
</div>



<%
}
}
catch(Exception e)
{
	e.printStackTrace();
}
%>
</div>
</body>
</html>