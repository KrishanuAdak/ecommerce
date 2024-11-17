<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="DAO.CartDAO,DAO.CouponDAO,DAO.CustomerDAO,DAO.OrderDAO,MODEL.Cart,MODEL.coupon,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add to cart page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</head>
<body>

<jsp:include page="header.jsp" flush="true"/>  

<style>
.collapsible {

  color: blue;
  cursor: pointer;
  padding: 18px;

  border: none;

  outline: none;
  font-size: 15px;
}

.active, .collapsible:hover {
  background-color:white;
}

.content {
  padding: 0 18px;
  max-height: 0;
  overflow: hidden;
  transition: max-height 0.2s ease-out;
  background-color: #f1f1f1;
}
a{
text-decoration:none;
}
.Cart_table{
display:flex;
justify-content:center;
align-items:center;
margin:40px 40px;
}
.button button{
width:30px;}
</style>
<%
boolean b=false;
response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
if(session.getAttribute("username")==null&&  session.getAttribute("otp-name")==null )
{
	response.sendRedirect("Login.jsp");
}
String name=(String) session.getAttribute("username");
String otp_name=(String) session.getAttribute("otp-name"); 
CartDAO dao=new CartDAO();
int id=0;
CustomerDAO d=new CustomerDAO();
String add="";
add=d.getAddress(name);
if(name==null)
{
 id=d.getIdOfCustomer(otp_name);
}
else{
	id=d.getIdOfCustomer(name);
	
}
OrderDAO order=new OrderDAO();
int num_order=order.numberOfOrders(id);
Set<Cart> lists=dao.showProducts(id);
int sum=dao.getSumOfAllProducts(id);
int xee=0;
CouponDAO dao1=new CouponDAO();

CartDAO daoCart=new CartDAO();


if(session.getAttribute("Checked")!=null || session.getAttribute("STORED")!=null)
{
	session.removeAttribute("FOR_STORE");
}



int cart_count=daoCart.getRowCount(id);
%>
<h3 style="text-align:center;color:blue">Check out Your Cart</h3>
<%if(session.getAttribute("Error-cart-msg")!=null) 
{
%>
<div id="error-cart-msg">
 <p id="para" style="color:red;text-align:center"><%= session.getAttribute("Error-cart-msg") != null ? session.getAttribute("Error-cart-msg") : "" %></p>
</div>
<%
}%>
<div class="Cart_table">
<table class="table" style="border:1px solid black;margin:auto;box-shadow:5px 5px black;">
  <thead>
    <tr>
      <th scope="col">Product Name</th>
      <th scope="col">Product Price</th>
      <th scope="col">Product Image</th>
      <th scope="col">Quantity</th>
      <th scope="col">Action</th> 
    </tr>
  </thead>
  <tbody class="table-group-divider">
  <%
  for(Cart x:lists)
  {
	 
	  %>

	  <tr>
      <td><%=x.product_name %>  </td>
      <td><%=x.product_price %></td>
      <td><img src="<%=x.product_image %>" height="150px" width="200px"></td>
      <td>
      <div class="button" style="display:flex;padding:10px;gap:5px;">
          <div style="display:flex;padding:10px;gap:5px;">
          <form action="productServlets" method="post">
      <input type="hidden" name="customer_id" value="<%=id %>">
      <input type="hidden" value="<%=x.product_id %>" name="product_id">
      <button type="submit">+</button>
          </form>
          </div>
         <div>
         <h5><%=dao.getQuantityByProduct(x.product_id,id) %></h5>
         </div>
         <div style="display:flex;padding:10px;gap:5px;">
          <form action="CartButton" method="post">
      <input type="hidden" name="customer_id" value="<%=id %>">
      <input type="hidden" value="<%=x.product_id %>" name="product_id">
      <button type="submit">-</button>
          </form>
           </div>
      </div>
      </td>
      <td>    
      <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" >Delete</button>
      <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
      <div class="modal-content">
      <div class="modal-header">
      <h5 class="modal-title" id="exampleModalLabel">Move from Cart</h5>
      <button type="button" class="close" data-dismiss="modal" aria-label="Close">
      <span aria-hidden="true">&times;</span>
      </button>
      </div>
      <div class="modal-body">
        Are you sure you want to move the item from cart or delete the item from the cart?
      </div>
      <div class="modal-footer">
      <button type="button" class="btn btn-secondary" data-dismiss="modal">Move to wishlist</button>
      <form action="LogoutServlets" method="post">
           <input type="hidden" name="delete" value=<%=x.product_id %>>           
           <button type="submit" class="btn btn-primary">Delete Item</button>
      </form>
      </div>
    </div>
  </div>
</div> 
     
      </td>  
 
      </tr>
	  <%
	  
  } 
  %>
  </tbody>
</table>
</div>
     

<h4 style="text-align:center;color:black;margin-top:20px;">
Total Pay:


	<%=sum %>
	
	









</h4>
<div style="display:flex;justify-content:center">
<%
int x=dao.getRowCount(id);

if(x>0)
{
%>
<form action="FinalPage.jsp">
<input type="hidden" name="customer_id" value=<%=id %>>
<button type="submit" class="btn btn-dark">
  Proceed to Pay
</button>
</form>

<%
}
%>
</div>
<script>
setTimeout(function() {
    const messageElement = document.getElementById('error-cart-msg');
    messageElement.style.opacity = '0';
    setTimeout(function() {
        messageElement.style.display = 'none';
    }, 1000);
}, 2000);

</script>








</body>
</html>