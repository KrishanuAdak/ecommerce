<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<h4 style="text-align:center">Select Your Payment Method</h4>
<div class="pay" >
<form action="CreditCard.jsp">

<div class="creditDebit" style="display:flex;justify-content:center;align-items:center;gap:30px;">
<label for="credit">Credit Card</label>
<input type="radio" name="card" value="Credit Card">

<label for="debit">Debit Card</label>
<input type="radio" name="card" value="Debit Card">
</div>
<div style="display:flex;justify-content:center;align-items:center;margin-top:40px;">
<button class="btn btn-success">Pay Securely</button>
</div>
</form>
<form action="NetBanking.jsp">
<div class="another" style="display:flex;justify-content:center;align-items:center;margin-top:40px;">
<label for="Net Banking">Net Banking</label>
<select name="netbanking">
  <option disabled selected value=""> -- select an option -- </option>
<option value="HdfcBank">HDFC Bank </option>
<option value="SbiBank">SBI Bank </option>
<option value="KanaraBank">Kanara Bank </option>
<option value="IdfcBank">IDFC Bank </option>
</select>
</div>
<div style="display:flex;justify-content:center;align-items:center;margin-top:40px;">
<button class="btn btn-success">Pay Securely</button>
</div>
</form>

</div>

</body>
</html>