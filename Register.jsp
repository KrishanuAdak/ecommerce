<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<style>
form{
border:1px solid green;
box-shadow:3px 3px 3px black;
margin:40px 40px;
}
label{
letter-spacing:0.3rem;
}
input{
width:100%;
height:40px;
border-radius:6px;}
div{
padding:10px;
}
</style>
</head>
<body>
<h4 class="text-center">Register Yourself</h4>
<form action="CustomerServlet" method="get">
<div>
<label for="name">Username</label><br>
<input type="text" name="name" placeholder="Enter your name" required>
</div>
<div>
<label for="email">Email</label><br>
<input type="email" name="email" placeholder="Enter your email" required>
</div>
<div>
<label for="password">Password</label><br>
<input type="password" name="password" placeholder="Enter your password" required>
</div>
<div>
<label for="address">Address</label><br>
<input type="text" name="address" placeholder="Enter your address" required>
</div>
<div>
<button type="submit" class="btn btn-outline-success text-center">Register</button>
</div>
</form>
</body>
</html>