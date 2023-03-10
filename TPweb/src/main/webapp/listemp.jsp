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
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
</head>
<%@ include file="std/navbar.jsp"%>
<body>
	<!-- Background image -->
	<div class="p-5 bg-image"
		style="background-image: url('https://mdbootstrap.com/img/new/textures/full/171.jpg'); height: 300px;"></div>
	<div class="container">
		<div class="card mx-4 mx-md-5 shadow-5-strong "
			style="margin-top: -100px; background: hsla(0, 0%, 100%, 0.8); backdrop-filter: blur(30px);">
			<div class="card-body py-5 px-md-5">

				<div class="row d-flex justify-content-center">
					<div class="col" align="center">
						<h2 class="fw-bold mb-2">Liste employee</h2>
						<div align="center">
							<a class="btn btn-primary m-4" href="/TPweb/list" role="button">Actualiser
								la liste</a> <a class="btn btn-primary m-4" href="/TPweb/addemp.jsp"
								role="button">Enregistrer un employee</a>
						</div>
						<table class="table table-striped table-hover">
							<thead>
								<tr align="center">
									<th>ID</th>
									<th>firstName</th>
									<th>lastName</th>
									<th>title</th>
									<th>startDate</th>
									<th>Modification</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${employees}" var="emp">
									<tr align="center">
										<td>${emp.empId }</td>
										<td>${emp.firstName }</td>
										<td>${emp.lastName }</td>
										<td>${emp.title }</td>
										<td>${emp.startDate}</td>
										<td><a
											href="update?id=<c:out value="${emp.empId}"></c:out>"
											name="id" id="id" class="edit" data-toggle="modal"><i
												class="bi bi-pencil-square"></i></a> <a
											href="delete?id=<c:out value="${emp.empId}"></c:out>"
											class="delete" data-toggle="modal"><i
												class="bi bi-x-square-fill"></i></a> <input type="hidden"
											name="id" id="id"></td>

									</tr>
								</c:forEach>
							</tbody>
						</table>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>