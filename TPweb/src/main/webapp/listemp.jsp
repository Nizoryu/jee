<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des employees</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
</head>
<body>
	<div class="container">
		<a class="btn btn-primary m-4" href="/TPweb/list" role="button">Actualiser la liste</a>
		<a class="btn btn-primary m-4" href="/TPweb/addemp.jsp" role="button">Enregistrer un employee la liste</a>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th><span class="custom-checkbox"> <input
							type="checkbox" id="selectAll"> <label for="selectAll"></label>
					</span></th>
					<th>ID</th>
					<th>firstName</th>
					<th>lastName</th>
					<th>title</th>
					<th>startDate</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${employees}" var="emp">
					<tr>
						<td><span class="custom-checkbox"> <input
								type="checkbox" id="checkbox1" name="options[]" value="1">
								<label for="checkbox1"></label>
						</span></td>
						<td>${emp.empId }</td>
						<td>${emp.firstName }</td>
						<td>${emp.lastName }</td>
						<td>${emp.title }</td>
						<td>${emp.startDate }</td>
						<td><a href="editEmployeeModal" class="edit"
							data-toggle="modal"><i class="bi bi-pencil-square"></i></a> <a
							href="#deleteEmployeeModal" class="delete" data-toggle="modal"><i
								class="bi bi-x-square-fill"></i></a> <input type="hidden" name="id"
							id="id" value="${emp.empId }"></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>