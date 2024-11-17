<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<style>
.firstrow{
display:flex;
justify-content:center;
align-items:center;
gap:20px;

}
.items{
border:1px solid black;
text-align:center;
box-shadow:3px 3px 3px black;
border-radius:3px;
height:150px;
width:250px;
}
.items:hover{
background-color:grey;
cursor:pointer;
}
.secondrow {
display:flex;
justify-content:center;
align-items:center;
gap:20px;
margin-top:20px;

}
</style>
<body>
<jsp:include page="header.jsp" flush="true"/>  
<h3 style="text-align:center;">Your Accounts</h3>
<div class="main" style="margin-top:50px;">

<div class="firstrow">

<div class="items">
<a href="PersonalDetails.jsp" style="text-decoration:none;color:black">
<img src="https://cdn-icons-png.freepik.com/256/447/447031.png" height="45px" width="50px" style="margin-top:10px">
<h4 style="text-align:center">Your Address</h4>
<p>View,Change Or Update your delivered Address </p>
</a>
</div>

<div class="items">
<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRVux2wtF3KSXQu0jPym0FhpnLA-OjeTrDtfw&s" height="45px" width="50px" style="margin-top:10px">
<h4>Your Payments</h4>
<p>UPI,Debit Card,Credit Card,EMI </p>
</div>

<div class="items">
<a href="ViewOrders.jsp" style="text-decoration:none;color:black">
<img src="https://cdn-icons-png.flaticon.com/512/3496/3496156.png" height="45px" width="50px" style="margin-top:10px">
<h4>View Your Orders</h4>
<p>Return,Exchange,Cancel your Orders</p>
</a>
</div>

</div>

<div class="secondrow">

<div class="items">
<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS37ib3HrRI0sysZK_ghs0Jh7ZX7uCDQ4I3gA&s" height="45px" width="50px" style="margin-top:10px"> 
<h4>Login,Security</h4>
<p>Change your Phone Number,username</p>
</div>

<div class="items">
<img src="https://static.thenounproject.com/png/252514-200.png" height="45px" width="50px" style="margin-top:10px">
<h4>Your Business Account</h4>
<p>Explore the chances </p>
</div>

<div class="items">
<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTXjZ5aVLnORTeP7U55lREvFSUOE9CRCup8gQ&s"  height="45px" width="50px" style="margin-top:10px">
<h4>Offers & Coupons</h4>
<p>Win and get huge discount </p>
</div>

</div>

</div>
</body>
</html>