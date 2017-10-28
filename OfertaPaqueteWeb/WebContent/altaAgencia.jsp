<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="UTF-8">
<title>Alta de Agencia</title>

<!-- Bootstrap core CSS -->
<link href="assets/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="assets/js/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>Alta de Agencia</h1>
		<br />
		<br />
		<form action="/OfertaPaqueteWeb/AltaAgencia" method="POST"
				class="col-sm-4">

			<!-- NOMBRE -->
			<div class="row form-group">
				<div class="col-sm-12  form-group">
					<label for="txtNombre">Nombre:</label> 
					<input type="text" name="txtNombre" c 	lass="form-control input-sm" id="txtNombre" />
				</div>
			</div>
			
			<!-- DIRECCION -->
			<div class="row form-group">
				<div class="col-sm-12  form-group">
					<label for="txtDireccion">Direccion:</label> 
					<input type="text" name="txtDireccion"	class="form-control input-sm" id="txtDireccion" />
				</div>
			</div>

			<!-- EMAIL -->
			<div class="row form-group">
				<div class="col-sm-6  form-group">
					<label for="txtemail">Email:</label> 
					<input type="text" name="txtemail" class="form-control input-sm" id="txtMail"  />
				</div>
			</div>
			
			<button name="accion" class="btn btn-lg btn-primary" type="submit">Guardar</button>
		<br />
		<br />
		</form>
		<!-- BOTONES -->
		<div class="row form-group">

			
			
			
			
			<form action="/OfertaPaqueteWeb/Volver2" method="POST"
				class="col-sm-4">
				<button name="accion" class="btn btn-lg btn-primary" type="submit">Cancelar</button>
			</form>
		</div>
	</div>
</body>
</html>