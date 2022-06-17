<%@page import="entity.Product"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<link rel="stylesheet" href="./css/detailProduct.css" />
<title>Detail Product</title>
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;400;500;600;700&display=swap"
	rel="stylesheet" />
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<div class="card">
		<div class="container-fliud">
			<div class="wrapper row">
				<div class="preview col-md-6">
					<div class="preview-pic tab-content">
						<div class="tab-pane active" id="pic-1">
							<img src="${pro.getImagine()}" />
						</div>
						<div class="tab-pane" id="pic-2">
							<img src="${pro.getImagine()}" />
						</div>
						<div class="tab-pane" id="pic-3">
							<img src="${pro.getImagine()}" />
						</div>
						<div class="tab-pane" id="pic-4">
							<img src="${pro.getImagine()}" />
						</div>
						<div class="tab-pane" id="pic-5">
							<img src="${pro.getImagine()}" />
						</div>
					</div>
					<ul class="preview-thumbnail nav nav-tabs">
						<li class="active"><a data-target="#pic-1" data-toggle="tab"><img
								src="${pro.getImagine()}" /></a></li>
						<li><a data-target="#pic-2" data-toggle="tab"><img
								src="${pro.getImagine()}" /></a></li>
						<li><a data-target="#pic-3" data-toggle="tab"><img
								src="${pro.getImagine()}" /></a></li>
						<li><a data-target="#pic-4" data-toggle="tab"><img
								src="${pro.getImagine()}" /></a></li>
						<li><a data-target="#pic-5" data-toggle="tab"><img
								src="${pro.getImagine()}" /></a></li>
					</ul>
				</div>
				<div class="details col-md-6">
					<h3 class="product-title">${pro.getTitle()}</h3>
					<div class="rating">
						<div class="stars">
							<span class="fa fa-star checked"></span> <span
								class="fa fa-star checked"></span> <span
								class="fa fa-star checked"></span> <span class="fa fa-star"></span>
							<span class="fa fa-star"></span>
						</div>
					</div>
					<p class="product-description">${pro.getDescription()}</p>
					<h4 class="price">
						Giá Sản Phẩm: <span>${pro.getPrice()} VNĐ</span>
					</h4>
					<h5 class="sizes">
						sizes: <span class="size" data-toggle="tooltip" title="small">s</span>
						<span class="size" data-toggle="tooltip" title="medium">m</span> <span
							class="size" data-toggle="tooltip" title="large">l</span> <span
							class="size" data-toggle="tooltip" title="xtra large">xl</span>
					</h5>
					<h5 class="colors">
						colors: <span class="color orange not-available"
							data-toggle="tooltip" title="Not In store"></span> <span
							class="color green"></span> <span class="color blue"></span>
					</h5>
					<div class="action">
							<a href="addcart?id=${pro.getId()}" class="add-to-cart btn btn-primary"
								type="button"">Mua Ngay</a>
							<button class="like btn btn-default" type="button">
								<span class="fa fa-heart"></span>
							</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>