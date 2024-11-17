<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="DAO.OrderDAO,DAO.CustomerDAO,java.util.*,MODEL.Order" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<jsp:include page="header.jsp" flush="true"/>  
<table class="table" style="border:1px solid black;margin:auto;box-shadow:5px 5px black;">

  <thead>
    <tr>


      <th scope="col">Product Name</th>
       <th scope="col">Product Price</th>
       <th scope="col">Order Status</th>
       <th scope="col">Order Date </th>
    </tr>
  </thead>
  <tbody class="table-group-divider">
    <%


String name=(String) session.getAttribute("username");
    String otp_name=(String) session.getAttribute("otp-name"); 
CustomerDAO dao=new CustomerDAO();
int r=0;
if(name!=null)
{
 r=dao.getIdOfCustomer(name);
}
else{
 r=dao.getIdOfCustomer(otp_name);
}
OrderDAO dao1=new OrderDAO();
List<Order> lists=dao1.ViewOrders(r);
for(Order x:lists)
{
%>
<tr>


      <td><%=x.product_name %>  </td>
      <td><%=x.customer_id %></td>

      <td>Confirmed</td>
      <td><%=x.order_date %>
  
</tr>
<%
}
%>
  </tbody>
</table>

	



</body>
</html>