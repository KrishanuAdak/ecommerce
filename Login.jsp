<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="refresh" content="30"/>
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<style>

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
input[type="checkbox"]{
width:20px;
margin-left:10px;
}
body{
background-image:url('https://media.istockphoto.com/id/1449490038/photo/online-shopping-and-e-commerce-technology-concept-shopper-using-computer-laptop-to-input.jpg?s=2048x2048&w=is&k=20&c=3Pmwqsxiy2XTePmajfBQyz2KcnC27QtzaFxNmBD9al0=');
background-size:auto;
background-repeat:no-repeat;
}
#myDIV {
border:1px solid green;
box-shadow:3px 3px 3px black;
margin:40px 40px;
  background: red;
  animation: mymove 5s infinite;
}

@keyframes mymove {
  from {background-color: white;
  color:black;}
  to {background-color:black ;
  color:white;}
}
</style>

</head>
<body>
<%
        Cookie[] cookies=request.getCookies();
		String savedUserName="";
		String savedEmail="";
		String savedPassword="";
		if(cookies!=null)
		{
			for(Cookie c:cookies)
			{
				if("USERNAME".equals(c.getName()))
				{
					savedUserName=c.getValue();					
				}
				if("EMAIL".equals(c.getName()))
				{
					savedEmail=c.getValue();
				}
				if("PASSWORD".equals(c.getName()))
				{
					savedPassword=c.getValue();
				}
			}
		}

%>

<h4 class="text-center;">Login Yourself First</h4>
<div id="myDIV">
<form action="CustomerServlet" method="post">
<div>
<label for="username">Username</label><br>
<input type="text" placeholder="Enter Name" name="name" value=
"<%=savedUserName %>"required> 
</div>

<div>
<label for="email">Email</label><br>
<input type="email" placeholder="Enter Email" name="uemail" value="<%=savedEmail %>" required>
</div>

<div>
<label for="username">Password</label><br>
<input type="password" placeholder="Enter Password" name="upassword" value="<%=savedPassword %>" required>
</div>



<input type="checkbox" name="remember" value="true">
<label for="remember" style="color:white">Remember me</label>

<div>
<button type="submit" class="btn btn-outline-success" onclick= "myFunction()">Submit</button>
</div>
</form>
</div>
  <p id="para" style="color:red;text-align:center"><%= session.getAttribute("Error-msg") != null ? session.getAttribute("Error-msg") : "" %></p>
<h4 class="text-center">Didn't have an account?<a href="Register.jsp" style="text-decoration:none;color:red;">Register Here</a></h4>

<h6 style="text-align:center;color:white;">or</h6>
<div style="display:flex;justify-content:center;align-items:center" id="showEmailButton">
<button type="button" class="btn btn-primary" onclick="myFunc()">Login with Mobile OTP</button>
</div>
<div style="display:flex;justify-content:center;align-items:center" id="showOtpButton">
<button type="button" class="btn btn-primary" onclick="myFunc2()">Login with Email OTP</button>
</div>

<!-- Mobile Verification -->
<div style="display:none;justify-content:center;align-items:center;" id="emailLogin" >
  <form action="GenerateOTPServlet" method="post">
        <label for="email">Enter Your Mobile Number:</label>
        <input type="text" name="phone" pattern="[6-9]{1}[0-9]{9}" maxlength="10" required>
        <div style="display:flex;justify-content:center;align-items:center">
        <button type="submit" value="Send OTP" class="btn btn-success text-center">Send OTP</button>
        </div>
    </form>
  
</div>

<!-- email Verification -->
<div style="display:none;justify-content:center;align-items:center;" id="emailOtp" >
    <form action="EmailOTP" method="post">
        Email: <input type="email" name="email" required>
        <button type="submit" class="btn btn-success text-center">Submit OTP </button>
    </form>
    </div>


<%
if(session.getAttribute("Error-otp-msg")!=null)
		{
%>
    <p id="para" style="color:red;text-align:center">
    Phone Number is not registered
    </p>
    <%
    }
    %>


<script>
function myFunc()
{
	document.getElementById("myDIV").style.display="none";
	document.getElementById("emailLogin").style.display='block';
	document.getElementById("showEmailButton").style.display='none';
	document.getElementById("emailOtp").style.display='none';
	document.getElementById("showOtpButton").style.display='none';
}
function myFunc2()
{
	document.getElementById("myDIV").style.display="none";
	document.getElementById("emailLogin").style.display='none';
	document.getElementById("showEmailButton").style.display='none';
	document.getElementById("emailOtp").style.display='block';
	document.getElementById("showOtpButton").style.display='none';
	
}
setTimeout(function() {
    const messageElement = document.getElementById('para');
    messageElement.style.opacity = '0';
    setTimeout(function() {
        messageElement.style.display = 'none';
    }, 1000);
}, 2000);


</script>
</body>
</html>