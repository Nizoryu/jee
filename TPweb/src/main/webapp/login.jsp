<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
</head>
<body class="bg-light ">

	<form action="login" method="post">
	<!-- Section: Design Block -->
			<section class="text-center">
				<!-- Background image -->
				<div class="p-5 bg-image"
					style="background-image: url('https://mdbootstrap.com/img/new/textures/full/171.jpg'); height: 300px;"></div>
				<!-- Background image -->

<div class="container">
				<div class="card mx-4 mx-md-5  shadow-5-strong"
					style="margin-top: -100px; background: hsla(0, 0%, 100%, 0.8); backdrop-filter: blur(30px);">
					<div class="card-body py-5 px-md-5">

						<div class="row d-flex justify-content-center">
							<div class="col">
								<h2 class="fw-bold mb-5">Connection</h2>
								<form>
									<!-- Email input -->
									<div class="form-outline mb-4">
										<input type="email" name="email" id="form3Example3"
											class="form-control" placeholder="Email" /> <label
											class="form-label" for="form3Example3"> </label>
									</div>

									<!-- Password input -->
									<div class="form-outline mb-4">
										<input type="password" name="password" id="form3Example4"
											class="form-control" placeholder="Password" /> <label
											class="form-label" for="form3Example4"></label>
									</div>

									<!-- Submit button -->
									<button type="submit" class="btn btn-primary btn-block mb-4">
										Connection</button>



								</form>
								<a class="  m-4" href="/TPweb/addUser.html" role="button">Ajouter
									un utilisateur</a>
							</div>
						</div>
					</div>
				</div>
				</div>
			</section>
	
	</form>
</body>
</html>