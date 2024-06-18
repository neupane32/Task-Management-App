<%@page import="model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet"
	href="path/to/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/view/CSS/index.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/view/CSS/Home.css" />
<title>Mobile Mart</title>
</head>
<body>
	<jsp:include page="Navbar.jsp"></jsp:include>
	<div class="banner"
		style="background-image: url('./assets/header.png'); background-size: cover; background-position: center; background-repeat: no-repeat; height: 60vh;">
	</div>

	<div class="product-management">
		<div class="product-list">
			<%
			List<Product> products = (List) request.getAttribute("products");
			if (products != null && !products.isEmpty()) {
				for (Product product : products) {
			%>
			<div class="product-card">
				<img
					src="${pageContext.request.contextPath}//images/<%=product.getProductImage()%>"
					alt="${product.getName() }">
				<h3>
					Name :
					<%=product.getName()%></h3>
				<p>
					Review :
					<%=product.getDescription()%></p>
				<p>
					Price :
					<%=product.getPrice()%></p>
				<p>
					Stock :
					<%=product.getStock()%></p>
				<button type="submit"
					onclick="location.href='${pageContext.request.contextPath}/addToCart?productId=<%=product.getId()%>'">Add
					to Cart</button>
			</div>
			<%
			}
			%>
			<%
			} else {
			%>
			<p>No Products Available</p>
			<%
			}
			%>
		</div>
	</div>


	<jsp:include page="Footer.jsp"></jsp:include>

	<script
		src="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.js"></script>
</body>
</html>
