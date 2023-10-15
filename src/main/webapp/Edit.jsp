<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Edit Product</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-sm-6">
						<h2>
							Edit <b>Product</b>
						</h2>
					</div>
				</div>
			</div>
			<form action="editControl" method="post">
				<div class="modal-body">
					<div class="form-group">
						<label>ID <b>(can not change)</b></label> <input name="id"
							value="${detail.id}" type="text" class="form-control" readonly
							required>
					</div>
					<div class="form-group">
						<label>Name</label> <input name="name" value="${detail.name}"
							type="text" class="form-control" required>
					</div>
					<div class="form-group">
						<label>Image</label> <input name="image" value="${detail.image}"
							type="text" class="form-control" required>
					</div>
					<div class="form-group">
						<label>Price</label> <input name="price" value="${detail.price}"
							type="text" class="form-control" required>
					</div>
					<div class="form-group">
						<label>Title</label>
						<textarea name="title" class="form-control" rows="3" cols="40"
							required>${detail.title}</textarea>
					</div>
					<div class="form-group">
						<label>Description</label>
						<textarea name="description" class="form-control" rows="10"
							cols="40" required>${detail.description}</textarea>
					</div>
					<div class="form-group">
						<label>Category</label> <select name="category"
							class="form-select" aria-label="Default select example">
							<c:forEach items="${listCC}" var="o">
								<option value="${o.cid}">${o.cname}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="modal-footer">
					<input type="submit" class="btn btn-info" value="Save"> <a
						href="home" class="btn btn-success"><span>Back to home</span></a>
				</div>
			</form>

		</div>

	</div>
</body>
</html>