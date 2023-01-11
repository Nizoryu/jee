<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-light bg-primary bg-gradient">
		<div class="fw-bold">
			<p>Bonjour ${firstName}</p>
		</div>
		<a class="navbar-brand" href="logout"> <i
			class="bi bi-box-arrow-left"></i>
		</a>

		<c:choose>
			<c:when test="${not empty sessionScope.email}">
				<li class="nav-item me-3 me-lg-0" id="login.jsp" name="login">
					<a class="nav-link text-white" href="/Projetlogin/log"> <span
						class="d-grid gap-2 d-lg-inline-block">Se connecter</span>
				</a>
				</li>
			</c:when>
			<c:otherwise>
				<li class="nav-item me-3 me-lg-0" id="logout-link"><a
					class="nav-link text-white" href="/Projetlogin/logout"> <span
						class="d-grid gap-2 d-lg-inline-block">Se déconnecter</span>
				</a></li>
			</c:otherwise>
		</c:choose>

	</nav>
</body>
</html>