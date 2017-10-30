<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="UTF-8">
<title>Oferta Paquetes</title>

<!-- Bootstrap core CSS -->
<link href="assets/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="assets/js/jquery.min.js"></script>
</head>
<script type="text/javascript">

    window.addEventListener('load', inicio, false);

    function inicio() {
        document.getElementById("formulario1").addEventListener('submit', validar, false);
    }

    function validar(evt) {
        var nombre = document.getElementById("txtNombre").value;
        var direccion = document.getElementById("txtDireccion").value;
        var email = document.getElementById("txtemail").value;
        if (nombre.lenght.value < 1) {
            alert('Debe cargar un nombre');
        }
        else{
       		 if (direccion.lenght.value < 1) {
         		   alert('Debe cargar una direccion');
     	     }
     	     else{
     	          if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3,4})+$/.test(email)){
  						alert("La direcci�n de email " + email + " es correcta.");
  		 		  } 
  		  		  else {
   	 		  			alert("La direcci�n de email es incorrecta.");
 				 }
     	     
     	     }
        
        }

        
    }

</script>


<body>
	<div class="container">
		<h1>Alta de Agencia</h1>
		<br />
		<br />
		<form action="/OfertaPaqueteWeb/AltaAgencia" method="POST" id="formulario1"	class="col-sm-4">

			<!-- NOMBRE -->
			<div class="row form-group">
				<div class="col-sm-12  form-group">
					<label for="txtNombre">Nombre:</label> 
					<input type="text" name="txtNombre" class="form-control input-sm" id="txtNombre" />
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
			
			<button name="accion" value="guardar" class="btn btn-lg btn-primary" type="submit">Guardar</button>
			<button name="accion" value="cancelar" class="btn btn-lg btn-primary" type="submit">Cancelar</button>

		<br />
		<br />
		</form>
		<br>
	</div>
</body>
</html>