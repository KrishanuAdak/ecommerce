<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="DAO.*,DAO.Product_detailsDAO,MODEL.*,java.util.*,MODEL.Product_Image_details" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
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
<div>
<jsp:include page="header.jsp" flush="true"/>  
</div>
<%
ProductDAO de=new ProductDAO();
String id_Url=request.getParameter("id");
ArrayList<Product> l=de.getById(Integer.parseInt(id_Url));
Product_detailsDAO dao=new Product_detailsDAO();
List<Product_details> li=dao.showDetailsById(Integer.parseInt(id_Url));
List<Product_Image_details> list=dao.showImagesById(Integer.parseInt(id_Url));
String xe=(String) session.getAttribute("username");
String otp_name=(String) session.getAttribute("otp-name"); 
int r=0;
CustomerDAO daoq=new CustomerDAO();
if(xe==null)
{
 r=daoq.getIdOfCustomer(otp_name);
}
else{
	 r=daoq.getIdOfCustomer(xe);
}
String img1="";
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
  <img id="expandedImg" style="width:100%" src="<%=e.image1%>">
  <div id="imgtext"><img src="<%=e.image1 %>"></div>
</div>
  
  <%
  }
  %>
  </div>
  <div class="body">
    <%
for(Product_details x:li)
{
%>

        <h5 class="card-title" style="font-size:36px"><%=x.product_name %></h5>
        <p class="card-text" style="font-size:26px">INR <%=x.product_price %></p>
        <p class="card-text" style="font-size:22px">(incl. of all taxes)</p>
        <h6><i class="fa-thin fa-badge-percent"></i>Get this for INR 799 on miminum order of 2500</h6>
        <div style="margin-top:20px">
        <form>
        <button style="width:95%;background-color:black;color:white;height:30px;border-radius:20px"><i class="fa-regular fa-heart"></i>Add Your Wishlist</button>
        </form>
        </div>
           <div style="margin-top:20px">
        <form action="Cart" method="post">
        <%
        for(Product i:l)
        {
        %>
             <input type="hidden" name="id" value="<%=x.product_id%>">
             <input type="hidden" name="name" value="<%=x.product_name    %>">
             <input type="hidden" name="price" value="<%=x.product_price  %>">
             <input type="hidden" name="image" value="<%=i.image %>">
             <input type="hidden" name="customer_id" value=<%=r %>>
             <button style="width:95%;background-color:black;color:white;height:30px;border-radius:20px"><i class="fa-solid fa-cart-shopping"></i>Add To Cart</button>
       
       <%
       }%> </form>
        </div>
        <div style="padding:10px;float:left">
        <div>
        <h6 class="card-text" style="font-size:18px;"><strong>Product Description</strong></h6>
        <%=x.product_description%>
        </div>
        
        <div>
        <h6 class="card-text" style="font-size:18px;"><strong>Origin Of Product</strong></h6>
        <%=x.product_origin %>
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