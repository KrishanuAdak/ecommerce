<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<style>
body{
background-image:url('https://media.istockphoto.com/id/1449490038/photo/online-shopping-and-e-commerce-technology-concept-shopper-using-computer-laptop-to-input.jpg?s=2048x2048&w=is&k=20&c=3Pmwqsxiy2XTePmajfBQyz2KcnC27QtzaFxNmBD9al0=');
background-size:auto;
background-repeat:no-repeat;
}
label{
letter-spacing:0.3rem;
}

input[type="text"],input[type="email"],input[type="password"]{
width:100%;
height:40px;
border-radius:6px;
}
h4{
color:white;
text-align:center;
}
div{
padding:10px;
}
</style>
<body>
<%
if(session.getAttribute("OTP-MESSAGE")!=null)
{
%>
<div id="otp">
<form action="GenerateOTPServlet" method="get">
<label>Enter the OTP</label>
<input type="text" placeholder="Enter the otp" name="otp_entered">
<button type="submit" class="btn btn-success">Submit</button>
</form>
</div>
    <p id="Wrong-otp-msg" style="color:red;text-align:center">
      <%= session.getAttribute("Wrong-otp-msg") != null ? session.getAttribute("Wrong-otp-msg") : "" %>
    </p>

<%
}%>
<script>
setTimeout(function() {
    const messageElement = document.getElementById('Wrong-otp-msg');
    messageElement.style.opacity = '0';
    setTimeout(function() {
        messageElement.style.display = 'none';
    }, 1000);
}, 2000);</script>
</body>
</html>