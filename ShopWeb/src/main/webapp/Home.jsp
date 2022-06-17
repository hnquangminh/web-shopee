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
<title>Web Shop</title>
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;400;500;600;700&display=swap"
	rel="stylesheet" />
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
	<section class="card-product" style="background-color: #eee;">
		<div class="container py-5">
			<div class="row">
				<c:forEach items="${card}" var="pr">
					<div class="col-md-6 col-lg-4 mb-4 mb-md-0">
						<div class="card">
							<div class="d-flex justify-content-between p-3">
								<p class="lead mb-0">${pr.name}</p>
							</div>
							<img style="width: 350px; height:300px" src="${pr.imagine}" class="card-img-top" alt="Shoes" />
							<div class="card-body">

								<div class="d-flex justify-content-between mb-3">
									<h5 class="mb-0">${pr.title}</h5>
									<h5 class="text-dark mb-0">${pr.price}<span>VNĐ</span>
									</h5>
								</div>
								<div class="d-flex justify-content-between mb-2">

									<div class="ms-auto text-warning">
										<i class="fa fa-star"></i> <i class="fas fa-star"></i> <i
											class="fas fa-star"></i> <i class="fas fa-star"></i> <i
											class="fas fa-star-half-alt"></i>
									</div>
								</div>
								 <hr class="my-0" />
								<div class="card-body">
									<div
										class="d-flex justify-content-between align-items-center pb-2 mb-1">
										<a href="detailproduct?pri=${pr.id}" class="text-dark fw-bold">View Product</a>
										<a href="addcart?id=${pr.id}" type="button" class="btn btn-primary">Buy now</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</section>
	<jsp:include page="Footer.jsp"></jsp:include>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>

</body>
</html>