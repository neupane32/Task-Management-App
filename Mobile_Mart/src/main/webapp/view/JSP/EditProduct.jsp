<%@page import="model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/view/CSS/index.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/view/CSS/editProduct.css">
<title>Edit Product</title>
</head>
<body>
	<jsp:include page="AdminNavbar.jsp"></jsp:include>
	<%
	Product product = (Product) request.getAttribute("product");
	%>
	<form action="${pageContext.request.contextPath}/updateProduct"
		method="post" enctype="multipart/form-data">
		<input type="text" id="productName" name="product-id" value="<%=product.getId()%>" hidden>
		<label for="productName">Product Name:</label> <input type="text"
			id="productName" name="product-name" value="<%=product.getName()%>"
			required><br> <label for="productDescription">Product
			Description:</label>
		<textarea id="productDescription" name="product-description" required><%=product.getDescription()%></textarea>
		<br> <label for="productPrice">Product Price:</label> <input
			type="number" id="productPrice" name="product-price"
			value="<%=product.getPrice()%>" step="0.01" required><br>
		<label for="productStock">Product Stock:</label> <input type="number"
			id="productStock" name="product-stock"
			value="<%=product.getStock()%>" required><br> <input
			type="text" id="oldImage" name="old-image"
			value="<%=product.getProductImage()%>" hidden> <label
			for="productImage">Product Image:</label> <input type="file"
			id="productImage" name="product-image" accept="image/*"
			onchange="onImageChange()"><br> <img id="imagePreview"
			src="${pageContext.request.contextPath}/images/<%=product.getProductImage()%>"
			height="100px" width="100px" /> <input type="submit"
			value="Update Product">

	</form>

	<jsp:include page="Footer.jsp"></jsp:include>
	<script type="text/javascript">
		function onImageChange() {
			var imageChooser = document.getElementById("productImage");
			var imagePreview = document.getElementById("imagePreview");
			imagePreview.src = URL.createObjectURL(imageChooser.files[0]);
		}
	</script>
</body>
</html>