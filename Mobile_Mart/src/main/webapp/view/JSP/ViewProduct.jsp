<%@page import="model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page import="java.util.Date"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath}/view/CSS/product.css">
<title>Mobile Mart - Admin Products</title>
</head>
<body>
	<jsp:include page="AdminNavbar.jsp"></jsp:include>

	<div class="product-table">
		<table>
			<thead>
				<tr>
					<th>Image</th>
					<th>Name</th>
					<th>Description</th>
					<th>Price</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<%
				List<Product> productList = (List) request.getAttribute("productList");
				if (productList != null && !productList.isEmpty()) {
					for (Product pmModel : productList) {
				%>
				<tr>
					<td class="product-image"><img
						src="${pageContext.request.contextPath}/images/<%=pmModel.getProductImage()%>">
					</td>
					<td><%=pmModel.getName()%></td>
					<td><%=pmModel.getDescription()%></td>
					<td>Rs <%=pmModel.getPrice()%></td>
					<td>
						<div class="product-actions">
							<a
								href="${pageContext.request.contextPath}/editProduct?productId=<%=pmModel.getId()%>">
								<button class="edit-btn">Edit</button>
							</a> <a
								href="${pageContext.request.contextPath}/deleteProduct?productId=<%=pmModel.getId()%>">
								<button class="delete-btn">Delete</button>
							</a>
						</div>
					</td>
				</tr>
				<%
				}
				} else {
				%>
				<tr>
					<td colspan="5" class="no-products">
						<h2>No products available</h2>
						<p>Click the button below to add a new product:</p> <a
						href="${pageContext.request.contextPath}/view/JSP/AddProduct.jsp"
						class="btn">Add New Product</a>
					</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>

	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
