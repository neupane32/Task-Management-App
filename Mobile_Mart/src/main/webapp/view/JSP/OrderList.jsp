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
	<jsp:include page="AdminNavbar.jsp"></jsp:include>
	<h2 style="text-align: center; padding: 1rem 0;">Order List</h2>

	<table border="1">
		<thead>
			<tr>
				<th>Order ID</th>
				<th>Customer Name</th>
				<th>Product Name</th>
				<th>Order Date</th>
				<th>Product Price</th>
				<th>Status</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<%
			List<Order> orders = (List) request.getAttribute("orderList");
			for (Order order : orders) {
			%>
			<tr>
				<td><%=order.getOrderId()%></td>
				<td><%=order.getCustomerName()%></td>
				<td><%=order.getProductName()%></td>
				<td><%=order.getOrderDate()%></td>
				<td>Rs :<%=order.getProductPrice()%>/-
				</td>
				<td class="status"><%=order.getStatus()%></td>
				<td>
					<form action="${pageContext.request.contextPath}/UpdateStatus"
						method="post">
						<input type="hidden" name="orderId"
							value="<%=order.getOrderId()%>"> <input
							class="action-btn" type="submit" value="Delivered">
					</form>
				</td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
