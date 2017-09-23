<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Signin Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link href="assets/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="signin.css" rel="stylesheet">
</head>

<body>
	<div class="container">
		<%
			if (request.getAttribute("error") != null) {
		%>
		<div class="col-md-12">
			<div class="alert alert-danger">
				<p><%=request.getAttribute("error")%></p>
			</div>
		</div>
		<%
			}
		%>
		<%
			if (request.getAttribute("mensaje") != null) {
		%>
		<div class="col-md-12">
			<div class="alert alert-info">
				<p><%=request.getAttribute("mensaje")%></p>
			</div>
		</div>
		<%
			}
		%>
		
		<form action="/OfertaPaqueteWeb/Menu" method="POST"
			class="col-md-4 col-md-push-3">
			
			<h2 class="form-signin-heading">Oferta Paquetes</h2>
			

	
			<button name="accion" value="Agencia" class="btn btn-lg btn-primary btn-block"
				type="submit"> Agencias
			
			</button>

			<button name="accion" value="Paquete" class="btn btn-lg btn-primary btn-block"
				type="submit"> Paquetes
				
			</button>

		</form>
	</div>
	<!-- /container -->
</body>
</html>
