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
	width: 50px;
	height: 50px;
	object-fit: cover;
	margin-left: 10px;
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
			<a href="" class="nav_logo">Mobile Mart</a>
			<ul class="nav_list">
				<li class="nav_item"><a
					href="${pageContext.request.contextPath}/viewproduct"
					class="nav_link">View Product</a></li> &nbsp &nbsp &nbsp &nbsp
				<li class="nav_item"><a
					href="${pageContext.request.contextPath}/view/JSP/AddProduct.jsp"
					class="nav_link">Add Product</a></li>
				<li class="nav_item"><a
					href="${pageContext.request.contextPath}/showOrders"
					class="nav_link">Track Orders</a></li>
			</ul>

			<div class="nav_items">
				<%
				if (session.getAttribute("userId") != null) {
				%>
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