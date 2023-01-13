<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter un employee</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">

</head>
<%@ include file="/../std/navbar.jsp"%>
</head>
<body>
	<form action="registreemp" method="post">


		<!-- Section: Design Block -->
		<section class="text-center">
			<!-- Background image -->
			<div class="p-5 bg-image"
				style="background-image: url('https://mdbootstrap.com/img/new/textures/full/171.jpg'); height: 300px;"></div>
			<!-- Background image -->
			<div class="container">

				<div class="card mx-4 mx-md-5 shadow-5-strong"
					style="margin-top: -100px; background: hsla(0, 0%, 100%, 0.8); backdrop-filter: blur(30px);">
					<div class="card-body py-5 px-md-5">

						<div class="row d-flex justify-content-center">
							<div class="col-lg-8">
								<h2 class="fw-bold mb-5">Enregistrement d'un Employee</h2>
								<form>
									<!-- 2 column grid layout with text inputs for the first and last names -->
									<div class="row">
										<div class="col-md-6 mb-4">
											<div class="form-outline">
												<input type="text" name="firstName" id="form3Example1"
													class="form-control" placeholder="FirstName" /> <label
													class="form-label" for="form3Example1"></label>
											</div>
										</div>
										<div class="col-md-6 mb-4">
											<div class="form-outline">
												<input type="text" name="lastName" id="form3Example2"
													class="form-control" placeholder="LastName" /> <label
													class="form-label" for="form3Example2"></label>
											</div>
										</div>
									</div>

									<!-- title input -->
									<div class="form-outline mb-4">
										<input type="text" name="title" id="form3Example3"
											class="form-control" placeholder="title" /> <label
											class="form-label" for="form3Example3"></label>
									</div>
									<!-- startdate input -->
									

									<div class="form-outline mb-4">
										<input type="date" name="startdate" id="form3Example3" class="form-control" placeholder="starttdate"  min="2023-01-01" /> 
											<label class="form-label" for="form3Example3"> </label>
									</div>

									
									<!-- Submit button -->
									<button type="submit" class="btn btn-primary btn-block mb-4">
										Ajouter</button>


								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>

	</form>


</body>
</body>
</html>