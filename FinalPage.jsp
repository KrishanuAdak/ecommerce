<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="DAO.CartDAO,DAO.CouponDAO,DAO.CustomerDAO,DAO.OrderDAO,MODEL.Cart,MODEL.*,java.util.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
     <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<style>
a:hover{
cursor:pointer;
text-decoration: underline;
}
input[type="text"]{
width:100%;
}

div{
padding:10px 10px;}
</style>
<body>
<%
String address_Id="";



String name=(String) session.getAttribute("username");
CustomerDAO dao=new CustomerDAO();

int customer_id=dao.getIdOfCustomer(name);

ArrayList<CustomerAddress> lists=null;
String add=dao.getAddress(name);
lists=dao.getDetailsById(customer_id);



%>
<h2 style="text-align:center">Confirmation Page</h2>
<div class="body">
<div class="address" style="margin:20px 20px;display:flex;justify-content:space-around;align-items:center;border-bottom:1px solid black">
<div style="padding:20px">
<h5>1</h5>
<h5> Delivery addresses</h5>
</div>
<div>
<%=add
%>
</div>
<div>

<a data-toggle="modal" data-target="#exampleModalCenter">
 Change Address
</a>
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Your addresses</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body" id="modal-body">
      
  
       <%
       if(request.getParameter("addressid")==null)
       {
     
       for(CustomerAddress x:lists)
       {
    	   System.out.println(x.id);
       %>
         <input type="radio" name="address"> <%=x.address1%>, <%=x.landmark %><%=x.village %>|<a href="#editAddress?addressid=<%=x.id %> " onclick="editAddress()" style="color:blue;">Edit address</a><br>
       
       <%
       }
       %>
  
 
 
      </div>
 
    


      
      <div id="editAddress" style="display:none" >
      <div style="">
  
     
      <div>

      <%
      if(request.getParameter("addressid")!=null)
      {
    	  address_Id=request.getParameter("addressid");
   	       ArrayList<CustomerAddress> list=dao.getAddressIdByCustomerName(customer_id, Integer.parseInt(address_Id));
   
      for(CustomerAddress e:list)
      {
    	  %>
    	<form action="EmailOTP" method="get">
    	<input type="hidden" name="customer_id" value="<%=customer_id %>">
    	  
      
      
      <h5>Update Your address</h5>
      </div>
      <div>
      Fields with an asterisk (*) are required
      </div>
      <div>
      <label>Country/Region *</label><br>
      <select name="country" style="width:130px">
      <option value="">Select country</option>
      <option value="ind">India</option>
      </select>
      </div>
      <div>
      Full name (First and Last name) *<br>
      <input type="text" name="name" value="<%=name  %>">
      </div>
      <div>
      Mobile number *
      <input type="text"  value="<%=dao.getPhoneNumberById(customer_id) %>" >
      </div>
      <div>
      Pincode *     
      <input type="text" name="pincode" value="<%=e.pincode %>">
      </div>
      
      
      <div>
      Flat, House no., Building, Company, Apartment *
      <input type="text" name="address1" value="<%=e.address1 %>">
      </div>
      
      <div>
      Flat, House no., Building, Company, Apartment *
      <input type="text" name="village" value="<%=e.village %>">
      </div>
      
      <div>
      Landmark
      <input type="text" name="landmark" value="<%=e.landmark %>">
      </div>
      <div>
      State *
      <input type="text" name="state" value="<%=e.state %>">
      </div>
      <button type="submit" class="btn btn-primary">Update Address</button>
      </form>
   
      
      <%
      }
      }
     
      
       
      
      %>
     
   
   
      </div>    
       
      </div>
     
      <div id="addAddress" style="display:none">
      <form action="EmailOTP" method="post">
      <input type="hidden" name="customer_id" value="<%=customer_id %>">
      <h6><a onclick="addAddress()">Add new address</a></h6>
      <div>
      Fields with an asterisk (*) are required
      </div>
      <div>
      <label>Country/Region *</label><br>
      <select name="country" style="width:130px">
      <option value="">Select country</option>
      <option value="ind">India</option>
      </select>
      </div>
      <div>
      Full name (First and Last name) *<br>
      <input type="text" name="name" value="<%=name  %>">
      </div>
      <div>
      Mobile number *
      <input type="text"  value="<%=dao.getPhoneNumberById(customer_id) %>" >
      </div>
      <div>
      Pincode *     
      <input type="text" name="pincode" >
      </div>
      
      
      <div>
      Flat, House no., Building, Company, Apartment *
      <input type="text" name="address1" >
      </div>
      
      <div>
      Flat, House no., Building, Company, Apartment *
      <input type="text" name="village" >
      </div>
      
      <div>
      Landmark
      <input type="text" name="landmark">
      </div>
      <div>
      State *
      <input type="text" name="state" >
      </div>
      <button type="submit" style="display:block">Add Address</button>
      </form>
      </div>
 
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>     
      </div>
    </div>
  </div>
</div>
</div>
</div>
<div>
</div>
<div>
</div>
<div>
</div>
</div>
<script>
function editAddress(){
	document.getElementById("addAddress").style.display='none';
	document.getElementById("editAddress").style.display='block';
	document.getElementById("modal-body").style.display='none';
	
}
function addAddress(){
	document.getElementById("editAddress").style.display='none';
	document.getElementById("modal-body").style.display='none';
	document.getElementById("addAddress").style.display='block';

	
}
</script>

</body>
</html>