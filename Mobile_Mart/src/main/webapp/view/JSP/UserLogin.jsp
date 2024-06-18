<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script src="https://unpkg.com/scrollreveal"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/view/CSS/index.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/view/CSS/login.css">
<title>Mobile Mart</title>
</head>
<body>
	<jsp:include page="Navbar.jsp"></jsp:include>
	<section class="login-section">
		<div class="login-container">
			<div class="login-img">
				<img src="${pageContext.request.contextPath}/assets/auth-image.png"
					alt="" class="login-image" />
			</div>
			<div class="login-content">
				<form action="${pageContext.request.contextPath}/userLogin"
					class="login-form" method="POST">
					<h2 class="form-title">Sign In</h2>
					<br>
					<%
					String loginError = (String) session.getAttribute("loginError");
					if (loginError != null && !loginError.isEmpty()) {
					%>
					<div class="error-message">
						<i class="fas fa-exclamation-circle"></i> <span><%=loginError%></span>
					</div>
					<%
					session.removeAttribute("loginError");
					}
					%>
					<div class="input-group">
						<label for="username">Email</label> <input type="text"
							placeholder="Email or Phone" id="username" name="email"
							class="input-field" required />
					</div>
					<div class="input-group password-group">
						<label for="password">Password</label> <input type="password"
							placeholder="Password" id="password" name="password"
							class="input-field" required />
					</div>
					<br>
					<div class="input-group">
						<button type="submit" class="login-btn">Login</button>
					</div>
					<div class="links">
						<span class="auth-link">Don't have an account? <a
							href="${pageContext.request.contextPath}/view/JSP/Register.jsp"
							class="register-link">Register</a></span>
					</div>
				</form>
			</div>
		</div>
	</section>
	<jsp:include page="Footer.jsp"></jsp:include>
	<script
		src="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/app.js"></script>
</body>
</html>