<%@page import="entity.Product"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />
<link rel="stylesheet" href="./css/detailproduct.css" />
<title>Edit Product</title>
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;400;500;600;700&display=swap"
	rel="stylesheet" />
<link href="css/manager.css" rel="stylesheet" type="text/css" />
<style>
img {
	width: 200px;
	height: 120px;
}
</style>
</head>
<body>
		<div class="container">
			<form action="edit" method="post">
				<div class="modal-header">
					<h4 class="modal-title">Edit Product</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label>ID</label> <input value="${pro.id}" name="id" type="text"
							class="form-control" readonly required>
					</div>
					<div class="form-group">
						<label>Name</label> <input value="${pro.name}" name="name"
							type="text" class="form-control" required>
					</div>
					<div class="form-group">
						<label>Image</label> <input value="${pro.imagine}" name="imagine"
							type="text" class="form-control" required>
					</div>
					<div class="form-group">
						<label>Price</label> <input value="${pro.price}" name="price"
							type="text" class="form-control" required>
					</div>
					<div class="form-group">
						<label>Title</label>
						<textarea name="title" class="form-control" required>${pro.title}</textarea>
					</div>
					<div class="form-group">
						<label>Description</label>
						<textarea name="description" class="form-control" required>${pro.description}</textarea>
					</div>
				</div>
				<div class="modal-footer">
					<input type="submit" class="btn btn-success" value="Edit">
				</div>
			</form>
		</div>
		<script src="js/manager.js" type="text/javascript"></script>
</body>
</html>