<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Product</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/CSS/AddProduct.css">
</head>
<body>
    <jsp:include page="AdminNavbar.jsp"></jsp:include>

    <div class="product-add-container">
        <form action="${pageContext.request.contextPath}/addProduct"
              method="POST" enctype="multipart/form-data">
            <h2 class="add-product-title">Add Product</h2>

            <div class="form-group">
                <label for="product-image" class="form-label">Product Image:</label>
                <input type="file" id="product-image" name="product-image" required>
            </div>

            <div class="form-group">
                <label for="product-name" class="form-label">Product Name:</label>
                <input type="text" id="product-name" name="product-name" required>
            </div>

            <div class="form-group">
                <label for="product-price" class="form-label">Price:</label>
                <input type="number" id="product-price" name="product-price" min="0" step="0.01" required>
            </div>

            <div class="form-group">
                <label for="product-description" class="form-label">Description:</label>
                <textarea id="product-description" name="product-description" rows="4" required></textarea>
            </div>

            <div class="form-group">
                <label for="product-stock" class="form-label">Stock:</label>
                <input type="number" id="product-stock" name="product-stock" min="0" required>
            </div>

            <button type="submit" class="add-product-button">Add Product</button>
        </form>
    </div>

    <jsp:include page="Footer.jsp"></jsp:include>
    <script src="${pageContext.request.contextPath}/js/app.js"></script>
</body>
</html>
