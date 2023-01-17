<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Erreur</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
</head>
<%@ include file="/../std/navbar.jsp"%>
<body class="bg-light bg-gradient ">


	<!-- Section: Design Block -->
	<section class="text-center">
		<!-- Background image -->
		<div class="p-5 bg-image"
			style="background-image: url('https://mdbootstrap.com/img/new/textures/full/171.jpg'); height: 300px;"></div>

		<div class="container">
			<div class="card mx-4 mx-md-5  shadow-5-strong"
				style="margin-top: -100px; background: hsla(0, 0%, 100%, 0.8); backdrop-filter: blur(30px);">
				<div class="card-body py-5 px-md-5">

					<div class="row d-flex justify-content-center">
						<div class="col">
							<h2 class="fw-bold mb-5">Vous n'êtes pas connecté</h2>
							<h6 class="fw-bold mb-5">Pour accéder à la requête, connecté vous devez être</h6>

						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
<div class="fixed-bottom">
<%@ include file="/../std/footer.html"%>
</div>
</html>