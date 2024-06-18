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
	href="path/to/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/view/CSS/index.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/view/CSS/about.css">
<title>Mobile Mart</title>
</head>
<body>
	<jsp:include page="Navbar.jsp"></jsp:include>
	<div class="about-section">
		<div class="content-container">
			<div class="about-content">
				<h3 class="about-title">About Us</h3>
				<p class="about-text">
					<strong>Welcome to Mobile Mart</strong>, your one-stop destination
					for the latest in mobile technology. Established in 2023, we pride
					ourselves in offering a curated selection of devices that cater to
					every tech enthusiast's needs. Our mission is to empower our
					customers with the tools they need to navigate the digital world,
					ensuring they stay ahead in the fast-paced tech industry. At Mobile
					Mart, we believe in the power of community and the importance of
					providing exceptional customer service. Join us in this exciting
					journey as we continue to revolutionize the mobile technology
					landscape.
				</p>
				<h2>Contact Information</h2>
				<br> Phone: +977 9805339948 <br> <br> Email:
				mobilemart@gmail.com <br> <br>
				<div class="contact-form">
					<h2>Send Us a Message</h2>
					<br>
					<form id="messageForm">
						<input type="text" placeholder="Your Name" required> <input
							type="text" placeholder="Your Email" required> <input
							type="text" placeholder="Your Message" required>
						<button type="submit" class="aboutusbtn">Send Message</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>
	<script
		src="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.js"></script>
</body>
</html>
