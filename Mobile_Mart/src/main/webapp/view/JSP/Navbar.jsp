<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/view/CSS/index.css" />
<style>
.profile_image {
	border-radius: 50%;
	width: 40px;
	height: 40px;
	object-fit: cover;
	margin-left: 20px;
}

.nav_link.active {
	background-color: black;
	color: white;
	padding: 10px;
}
</style>
</head>
<body>
	<nav class="nav">
		<div class="container nav_container">
			<a href="${pageContext.request.contextPath}/ShowProduct"
				class="nav_logo">Mobile Mart</a>
			<%
			if (session.getAttribute("userId") != null) {
			%>
			<ul class="nav_list">
				<li class="nav_item"><a
					href="${pageContext.request.contextPath}/ShowProduct"
					class="nav_link">Home</a></li>
				<li class="nav_item"><a
					href="${pageContext.request.contextPath}/view/JSP/AboutUs.jsp"
					class="nav_link">About Us</a></li>
				<li class="nav_item"><a
					href="${pageContext.request.contextPath}/UserOrders"
					class="nav_link">My Orders</a></li>
			</ul>
			<div class="nav_items">
				<div class="nav_items">
					<form id="searchForm"
						action="${pageContext.request.contextPath}/SearchProduct"
						method="post" class="nav_form">
						<input type="text" class="nav_input" name="searchKeyword"
							placeholder="Search now.." />
					</form>
					<a href="${pageContext.request.contextPath}/ShowCart"> <img
						src="${pageContext.request.contextPath}/assets/cart.png" alt=""
						class="cart" />
					</a>
				</div>
				<a href="${pageContext.request.contextPath}/logout" class="authbtn">Logout</a>
				<a href="${pageContext.request.contextPath}/viewProfile"> <img
					src="${pageContext.request.contextPath}/images/${sessionScope.userImage}"
					alt="User Profile" class="profile_image" />
				</a>
				<%
				} else {
				%>
				<a href="${pageContext.request.contextPath}/view/JSP/Register.jsp"
					class="authbtn">Sign Up</a>
				<%
				}
				%>
			</div>
		</div>
	</nav>

	<script>
		// Get the current page URL
		var currentPageUrl = window.location.href;

		// Get all navigation links
		var navLinks = document.querySelectorAll('.nav_link');

		// Iterate through each navigation link
		navLinks.forEach(function(link) {
			// If the link's href matches the current page URL
			if (link.href === currentPageUrl) {
				// Add the 'active' class to the link
				link.classList.add('active');
			}
		});
	</script>
</body>

</html>
