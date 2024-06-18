<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.Cart"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Cart</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/view/CSS/index.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/view/CSS/cart.css">
</head>
<body>
	<jsp:include page="Navbar.jsp"></jsp:include>
	<header>
		<h1>Shopping Cart</h1>
	</header>

	<main>
		<div class="cart-items">
			<%
			List<Cart> cartItems = (List) request.getAttribute("cartItems");
			if (cartItems != null && !cartItems.isEmpty()) {
				for (Cart cartItem : cartItems) {
			%>

			<div class="cart-item">
				<div class="item-details">
					<img
						src="${pageContext.request.contextPath}/images/<%=cartItem.getProductImage() %>"
						alt="Product Image">
					<div class="item-info">
						<h2><%=cartItem.getProductName()%></h2>
						<p>
							Price: Rs
							<%=cartItem.getProductPrice()%>
							/-
						</p>
						<p>
							Stock:
							<%=cartItem.getProductStock()%></p>
					</div>
				</div>

				<div class="item-actions">
					<form action="${pageContext.request.contextPath}/deleteCartItem"
						method="POST">
						<input type="hidden" name="cartId"
							value="<%=cartItem.getCartId()%>">
						<button type="submit" class="btn-remove">Delete</button>
					</form>
				</div>

			</div>
		</div>

		<div class="cart-summary">
			<h2>Cart Summary</h2>
			<p>
				Total Price: Rs :
				<%=cartItem.getProductPrice()%>
				/-
			</p>
			<form action="${pageContext.request.contextPath}/MakeOrder"
				method="POST">
				<input type="hidden" name="cartId" value="<%=cartItem.getCartId()%>">
				<button type="submit" class="btn-checkout">Checkout</button>
			</form>

		</div>
		<%
		}
		%>
		<%
		} else {
		%>
		<p>No Items Available</p>
		<%
		}
		%>
	</main>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
