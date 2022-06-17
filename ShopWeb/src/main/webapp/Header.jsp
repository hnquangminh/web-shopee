<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="./css/index.css" />
<nav class="navbar navbar-expand-lg navbar-light">
	<div class="container px-4 px-lg-5">
		<a href="home" class="navbar-brand" href="#"> <img
			src="./img/logo-shopee-inkythuatso-2-01-24-14-52-10.png" alt="shopee"
			width="100" height="65" />
		</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-md-2">
				<li class="nav-item"><a href="home" class="nav-link active"
					aria-current="page" href="#!">Trang Chủ</a></li>

				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
					role="button" data-bs-toggle="dropdown" aria-expanded="false">Danh
						Mục Sản Phẩm</a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
						<c:forEach items="${cardC}" var="ct">
							<li><a class="dropdown-item" href="category?cid=${ct.cid}">${ct.cname}</a></li>
						</c:forEach>
					</ul></li>
				<li class="nav-item"><a class="nav-link" href="manager">Manager
						Product </a></li>
				<c:if test="${sessionScope.acc !=null }">
					<li class="nav-item"><a class="nav-link" href="#">Hello
							${sessionScope.acc.user} </a></li>
					<li class="nav-item"><a class="nav-link" href="logout">Logout
					</a></li>
				</c:if>
				<c:if test="${sessionScope.acc ==null }">
					<li class="nav-item"><a class="nav-link" href="Login.jsp">Login
					
				</c:if>
				<li class="nav-item"><a class="nav-link" href="login">SIGN
						UP </a></li>
			</ul>
			<div class="d-flex">
				<form style="margin-right: 30px" action="search" method="post"
					class=form-inlinemy-2my-sm-0">
					<div class="input-group input-group-sm">
						<input value="${searchname}" name="search" type="text"
							class="form-control" aria-label="Small"
							aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
						<div class="input-group-append">
							<button type="submit" class="btn btn-danger btn-number ">
								<i class="fa fa-search"></i>
							</button>
						</div>
					</div>
				</form>
				<form style="margin-top: 4px; margin-right: 5px" action="#"
					method="post">
					<c:set var="size" value="${sessionScope.size}" />
					<a class="btn btn-outline-dark btn-sm ml-3" href="addcart"> <i
						class="fa fa-shopping-cart"></i> Cart <input name="number"
						class="badge bg-dark text-white ms-1 rounded-pill" value="" />
						${size}
					</a>
				</form>
			</div>
		</div>
	</div>
</nav>
<header
	style="background-image: url(./img/imagin5.jpg) !important; height: 100%; width: 100%; background-repeat: no-repeat; background-size: cover"
	class="py-5">
	<div class="container px-4 px-lg-5 my-5">
		<div class="text-center">
			<h1 class="display-4 fw-bolder text-black">NGÀY HỘI SALE SẬP SÀN</h1>
			<b style="color: black; font-size: 30px" class="lead fw-normal mb-0">SĂN
				QUÀ 0Đ</b>
		</div>
	</div>
</header>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
