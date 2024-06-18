<%@page import="model.Order"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Mobile Mart - Order List</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/view/CSS/trackOrder.css">
</head>
<body>
	<jsp:include page="Navbar.jsp"></jsp:include>

	<%
	List<Order> orders = (List) request.getAttribute("orderList");
	if (orders != null && !orders.isEmpty()) {
	%>
	<h2 style="text-align: center; padding: 1rem 0;">My Order List</h2>
	<table border="1">
		<thead>
			<tr>
				<th>Order ID</th>
				<th>Product Name</th>
				<th>Order Date</th>
				<th>Product Price</th>
				<th>Status</th>
				
			</tr>
		</thead>
		<tbody>
			<%
			for (Order order : orders) {
			%>
			<tr>
				<td><%=order.getOrderId()%></td>
				<td><%=order.getProductName()%></td>
				<td><%=order.getOrderDate()%></td>
				<td>Rs :<%=order.getProductPrice()%>/-
				</td>
				<td class="status"><%=order.getStatus()%></td>

			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<%
	} else {
	%>
	<p style="text-align: center; padding-top:150px;">No orders currently.</p>
	<%
	}
	%>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
