
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- https://mvnrepository.com/artifact/javax.servlet.jsp.jstl/javax.servlet.jsp.jstl-api -->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<!--begin of menu-->
	<nav class="navbar navbar-expand-md navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="home">Shoes</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarsExampleDefault"
				aria-controls="navbarsExampleDefault" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse justify-content-end"
				id="navbarsExampleDefault">
				<ul class="navbar-nav m-auto">
					<c:if test="${sessionScope.accSession.isSell == 1}">
						<li class="nav-item"><a class="nav-link" href="manager">ManagerProduct</a></li>
					</c:if>
					<c:if test="${sessionScope.accSession.isAdmin == 1}">
						<li class="nav-item"><a class="nav-link" href="#">ManagerAccount</a></li>
					</c:if>
					<c:if test="${sessionScope.accSession != null}">
						<li class="nav-item"><a class="nav-link" href="#">Hello
								${sessionScope.accSession.user}</a></li>
						<li class="nav-item"><a class="nav-link" href="logout">Logout</a>
						</li>
					</c:if>
					<c:if test="${sessionScope.accSession == null}">
						<li class="nav-item"><a class="nav-link" href="Login.jsp">Login</a>
						</li>
					</c:if>
				</ul>
				<form action="search" method="post" class="form-inline my-2 my-lg-0">
					<div class="input-group input-group-sm">
						<input value="${txtS}" name="txt" type="text" class="form-control"
							aria-label="Small" aria-describedby="inputGroup-sizing-sm"
							placeholder="Search...">
						<div class="input-group-append">
							<button type="submit" class="btn btn-secondary btn-number">
								<i class="fa fa-search"></i>
							</button>
						</div>
					</div>
					<a class="btn btn-success btn-sm ml-3" href="show"> <i
						class="fa fa-shopping-cart"></i> Cart
						<%-- <span
						class="badge badge-light">${count}</span>  --%>
														
					</a>
				</form>
			</div>
		</div>
	</nav>
	<section class="jumbotron text-center">
		<div class="container">
			<h1 class="jumbotron-heading">Siêu thị giày chất lượng cao</h1>
			<p class="lead text-muted mb-0">Uy tín tạo nên thương hiệu với
				hơn 10 năm cung cấp các sản phầm giày nhập từ Trung Quốc</p>
		</div>
	</section>
	<!--end of menu-->
	<div class="container">
		<div class="row">
			<div class="col">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="home">Home</a></li>
						<li class="breadcrumb-item"><a href="home">Category</a></li>
						<li class="breadcrumb-item active" aria-current="#">Sub-category</li>
					</ol>
				</nav>
			</div>
		</div>
	</div>
</body>
</html>

