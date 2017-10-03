<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

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
		<div class="col-md-12">
			<h1>Lista de Paquetes</h1>
			
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Id</th>
						<th>Nombre Paquete</th>
						<th>Destino</th>
						<th>Fecha salida</th>
						<th>Fecha regreso</th>
						<th>Estado</th>
						<th>Cupo</th>
						<th></th>


					</tr>
				</thead>
				<tbody>
				
						
					
				</tbody>
			</table>
			
			<br>
			
			
			<form action="/OfertaPaqueteWeb/Volver" method="POST" class="col-md-4 col-md-push-3">
				<button name="accion" value="Volver" class="btn btn-lg btn-primary btn-block" type="submit"> Volver</button>
			</form>
			
			<form action="/OfertaPaqueteWeb/Paquete" method="POST" class="col-md-4 col-md-push-3">
				<button name="accion" value="Volver" class="btn btn-lg btn-primary btn-block" type="submit"> Nuevo paquete</button>
			</form>

		</div>
	</div>
</body>
</html>
