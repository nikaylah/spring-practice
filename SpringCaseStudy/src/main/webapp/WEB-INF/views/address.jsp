<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>description</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<!-- create a form to add new contact -->
	<form action="savedescription" method="post">
		<div class="form-group">
			<label for="i1">ID</label> <input type="text" class="form-control"
				name="descriptionId" id="i1" placeholder="Enter ID">
		</div>
		
		<div class="form-group">
			<label for="i2">description</label> <input type="text" class="form-control"
				name="descriptionName" id="i2" placeholder="Enter description">
		</div>
		
		<div class="form-group">
			<label for="i3">Select City</label> <input type="text" class="form-control"
				name="city" id="i3" placeholder="Enter City">
		</div>
		
		<div class="form-group">
			<label for="i4">Select State</label> <input type="text" class="form-control"
				name="state" id="i4" placeholder="Enter State">
		</div>
		
		<div class="form-group">
			<label for="i5">Select Country</label> <input type="text" class="form-control"
				name="country" id="i5" placeholder="Enter Country">
		</div>
		
		
		<input type="submit" value="Add description" class="btn btn-success">
	</form>
	<!-- create a Table to display all Contacts -->
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">description</th>
				<th scope="col">City</th>
				<th scope="col">State</th>
				<th scope="col">Country</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${description}" var="description">
				<tr>
					<th scope="row">${description.descriptionId }</th>
					<td>${description.descriptionName }</td>
					<td>${description.city }</td>
					<td>${description.state }</td>
					<td>${description.country }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>