<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="DAO.*,java.util.*,MODEL.*"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Product</title>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<style>
.details{
display:flex;

}
.image{
width:80%;
}

#img{
width:400px;
height:400px;
}
* {
  box-sizing: border-box;
}

body {
  margin: 0;
  font-family: Arial;
}

/* The grid: Four equal columns that floats next to each other */
.column {
  float: left;
  width: 150px;
  height:200px;
  padding: 5px;

}
.row{
margin-left:30px;
}

/* Style the images inside the grid */
.column img {
  opacity: 0.8; 
  cursor: pointer; 
}

.column img:hover {
  opacity: 1;
  display:block;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* The expanding image container */
.container {
  position: relative;
  display: none;
  margin-top:20px;
  width:600px;
  height:400px;
  float:left;
  margin-left:10px;
}
</style>
<body>
<jsp:include page="header.jsp" flush="true"/>  
<%
String xe=(String) session.getAttribute("username");

CustomerDAO daoq=new CustomerDAO();
int rw=daoq.getIdOfCustomer(xe);
String search=request.getParameter("search");
ProductDAO dao=new ProductDAO();
ArrayList<Product_Details_Search> lists=dao.getProductBySearch(search);
int r=dao.getIdOfProduct(search);
Product_detailsDAO dao1=new Product_detailsDAO();
ArrayList<Product_Image_details> list=dao1.showImagesById(r);
%>
 <div class="details" style="margin-top:30px;">
     <div class="image">
  <%
  for(Product_Image_details e:list)
  {	  
  %> 
      <div class="row">
  <div class="column">
    <img src="<%=e.image1 %>"  style="width:100%" onclick="myFunction(this);">   
  </div>
  <div class="column">
    <img src="<%=e.image2 %>"  style="width:100%" onclick="myFunction(this);">
  </div>
  <div class="column">
    <img src="<%=e.image3 %>" style="width:100%" onclick="myFunction(this);">
  </div>
  <div class="column">
    <img src="<%=e.image4 %>"  style="width:100%" onclick="myFunction(this);">
  </div>
      </div>

     <div class="container">

  <img id="expandedImg" style="width:100%">
  <div id="imgtext"></div>
</div>
  
  <%
  }
  %>
  </div>
  <div class="body">
    <%
    ArrayList<Product_Details_Search> li=dao.getProductBySearch(search);
for(Product_Details_Search x:li)
{
%>

        <h5 class="card-title" style="font-size:36px"><%=x.name %></h5>
        <p class="card-text" style="font-size:26px">INR <%=x.price %></p>
        <p class="card-text" style="font-size:22px">(incl. of all taxes)</p>
        <h6><i class="fa-thin fa-badge-percent"></i>Get this for INR 799 on miminum order of 2500</h6>
        <div style="margin-top:20px">
        <form>
        <button style="width:95%"><i class="fa-regular fa-heart"></i>Add Your Wishlist</button>
        </form>
        </div>
           <div style="margin-top:20px">
        <form action="Cart" method="post">
             <input type="hidden" name="id" value="<%=r%>">
             <input type="hidden" name="name" value="<%=x.name    %>">
             <input type="hidden" name="price" value="<%=x.price  %>">
             <input type="hidden" name="image" value="<%=x.image_Search  %>">
             <input type="hidden" name="customer_id" value=<%=rw %>>
             <button style="width:95%"><i class="fa-solid fa-cart-shopping"></i>Add To Cart</button>
        </form>
        </div>
        <div style="padding:10px;float:left">
        <div>
        <h6 class="card-text" style="font-size:18px;">Product Description</h6>
        
        </div>
        
        <div>
        <h6 class="card-text" style="font-size:18px;">Origin Of Product</h6>
        <%=x.origin %>
        </div>       
        </div>
    
       
       

   
<%
}
%>
    
    </div>
 </div>   


 
 
 <script>
 function myFunction(imgs) {
	  var expandImg = document.getElementById("expandedImg");
	  var imgText = document.getElementById("imgtext");
	  expandImg.src = imgs.src;
	  imgText.innerHTML = imgs.alt;
	  expandImg.parentElement.style.display = "block";
	}
 </script>





</body>
</html>