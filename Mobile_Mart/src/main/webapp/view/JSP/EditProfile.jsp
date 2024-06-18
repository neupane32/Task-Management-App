<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/view/CSS/profile.css" />
<title>User Profile</title>
</head>
<body>
	<jsp:include page="Navbar.jsp"></jsp:include>
	<section class="header">
		<div class="container">
			<div class="auth-container">
				<%
				User user = (User) request.getAttribute("user");
				String updateMsg = (String) session.getAttribute("updateMsg");
				session.removeAttribute("updateMsg");
				%>
				<div class="auth-content">
					<form action="${pageContext.request.contextPath}/updateProfile"
						class="form-container" method="post" enctype="multipart/form-data">
						<h2 class="form-title">User Profile</h2>
						<%
						if (updateMsg != null) {
						%>
						<div  style="color: #22bb33;">
							<%=updateMsg%>
						</div>

						<%
						}
						%>
						<br />
						<div class="form-group">
							<input type="text" placeholder="Name" name="name"
								class="form-input" value="<%=user.getName()%>" required /> <input
								type="text" placeholder="Address" name="address"
								class="form-input" value="<%=user.getAddress()%>" required />
						</div>
						<div class="form-group">
							<input type="text" placeholder="Phone" name="phone"
								class="form-input" value="<%=user.getPhone()%>" required /> <input
								type="email" placeholder="Email" name="email" class="form-input"
								value="<%=user.getEmail()%>" hidden />
						</div>
						<input type="text" placeholder="role" name="role"
							class="form-input" value="<%=user.getRole()%>" hidden /> <input
							type="password" placeholder="Password" name="pass1"
							class="form-input" hidden /> <input type="password"
							placeholder="Confirm Password" name="pass2" class="form-input"
							hidden /> <input type="text" id="oldImage" name="old-image"
							value="<%=user.getPhotoPath()%>" hidden>

						<div class="form-group">
							<input type="file" id="userImage" name="user-image"
								accept="image/*" onchange="onImageChange()"> <img
								id="imagePreview"
								src="${pageContext.request.contextPath}/images/<%=user.getPhotoPath() %>"
								height="100px" width="100px" />
						</div>
						<button type="submit" class="form-submit">Update Profile</button>
					</form>
				</div>
			</div>
		</div>
	</section>
	<jsp:include page="Footer.jsp"></jsp:include>
	<script type="text/javascript">
		function onImageChange() {
			var imageChooser = document.getElementById("userImage");
			var imagePreview = document.getElementById("imagePreview");
			imagePreview.src = URL.createObjectURL(imageChooser.files[0]);
		}
	</script>
</body>
</html>
