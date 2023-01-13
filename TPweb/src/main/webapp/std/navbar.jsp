<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<nav class="navbar navbar-light shadow-lg p-3 mx-5 fixed-top rounded"
		style="background: hsla(0, 0%, 57%, 0.404)">
		<div class="container-fluid ">
			<div class="fw-bold">
				<h6>${user.firstName} ${user.lastName}</h6>
				<h6>Privilège: ${user.roleName}</h6>
				
			</div>

			<c:choose>
				<c:when test="${not empty sessionScope.email}">
					
						<a class="nav-link text-white" href="/Projetlogin/login"> <span
							class="d-grid gap-2 d-lg-inline-block">Se connecter</span>
							<i class="bi bi-box-arrow-in-right" style="font-size: 1.5rem"></i>
					</a>				
				</c:when>
				<c:otherwise>
					<a		class="nav-link text-white" href="/TPweb/logout"> <span
							class="d-grid gap-2 d-lg-inline-block"></span> <i
							class="bi bi-box-arrow-left"style="font-size: 1.5rem"></i></a>
				</c:otherwise>
			</c:choose>
		</div>
	</nav>
