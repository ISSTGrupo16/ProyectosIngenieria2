<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="css/bootstrap.min.css">   		
    <script src="js/bootstrap.min.js"></script> 
	<title>Crear Usuario</title>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<a class="navbar-brand" href="FormCrearUsuario.jsp">Creando nuevo usuario</a>
		</div>
		<%@ include file="FormLogout.jsp" %>
	</nav>
		

<form action="FormNuevoUsuarioServlet" class="needs-validationsssss">
	<label for="email"><br/>Email</label>
	<input class="form-control" type="text" name="email" placeholder="Email" />
	<label for="name"><br/>Nombre Completo del usuario</label>
	<input class="form-control" type="text" name="name" placeholder="Nombre completo" />
	<label for="password"><br/>Contraseña</label>
	<input  class="form-control" type="password" name="password" placeholder="password" />
	<label for="tipo"><br/>Tipo de trabajador</label>
	<select class="form-control" name="tipo">
	<option value="" disabled selected>Elija un el tipo de trabajador</option>
	<option value="RRHH">RRHH</option>
	<option value="Gestor">Gestor</option>
	<option value="Trabajador">Trabajador</option>
</select>
<br/><br/>
<button  class="btn btn-primary"type="submit"> Crear Usuario</button>

</form>

</body>
</html>