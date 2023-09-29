
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- Left Page --%>
	<div class="col-sm-3">
		<div class="card bg-light mb-3">
			<div class="card-header bg-primary text-white text-uppercase">
				<i class="fa fa-list"></i> Categories
			</div>
			<ul class="list-group category_block">
				<c:forEach items="${listCC}" var="o">
					<li class="list-group-item text-white ${tag == o.cid ? "active":""}"><a
						href="category?cid=${o.cid}">${o.cname}</a></li>
				</c:forEach>

			</ul>
		</div>
		<div class="card bg-light mb-3">
			<div class="card-header bg-success text-white text-uppercase">Last
				product</div>
			<div class="card-body">
				<img class="img-fluid" src="${last.image}" />
				<h5 class="card-title">${last.name}</h5>
				<p class="card-text">${last.title}</p>
				<p class="bloc_left_price">${last.price}$</p>
			</div>
		</div>
	</div>

</body>
</html>