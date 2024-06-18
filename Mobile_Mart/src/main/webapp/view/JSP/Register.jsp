<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script src="https://unpkg.com/scrollreveal"></script>
<!-- Link Swiper's CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/view/CSS/index.css" />
	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/view/CSS/register.css" />
<title>Mobile Mart</title>
</head>
<body>
	<jsp:include page="Navbar.jsp"></jsp:include>
	<section class="header">
		<div class="container">
			<div class="auth-container">
				
				<div class="auth-content">
					<%
					String error = request.getParameter("error");
					if (error != null && !error.isEmpty()) {
					%>
					<div class="error-message">
						<%=error%>
					</div>
					<%
					}
					%>

					<form action="${pageContext.request.contextPath}/userRegister"
						class="form-container" method="post" enctype="multipart/form-data">
						<h2 class="form-title">Register</h2>
						<br />
						<div class="form-group">
							<input type="text" placeholder="Name" name="name"
								class="form-input" required /> <input type="text"
								placeholder="Address" name="address" class="form-input" required />
						</div>
						<div class="form-group">
							<input type="text" placeholder="Phone" name="phone"
								class="form-input" required /> <input type="email"
								placeholder="Email" name="email" class="form-input" required />
						</div>
						<div class="form-group">
							<input type="password" placeholder="Password" name="pass1"
								class="form-input" required /> <input type="password"
								placeholder="Confirm Password" name="pass2" class="form-input"
								required />
						</div>

						<div class="form-group">
							 <input type="file" id="userPhoto" name="userPhoto"
								accept="image/*" class="form-input" />
						</div>
						<button type="submit" class="form-submit">Register</button>
						<span class="form-auth-text"> Already have an account? <a
							href="${pageContext.request.contextPath}/view/JSP/UserLogin.jsp"
							class="form-auth-link">Login</a></span>
					</form>

				</div>
			</div>
		</div>
	</section>
	<jsp:include page="Footer.jsp"></jsp:include>
	<script
		src="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/app.js"></script>
</body>
</html>
