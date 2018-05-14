<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Crear Usuario</title>
</head>
<body>

<h2>Crear Usuario</h2>

<form action="FormNuevoUsuarioServlet">

<input type="text" name="email" placeholder="Email" />
<input type="text" name="name" placeholder="Nombre completo" />
<input type="password" name="password" placeholder="password" />
<select name="tipo">
<option value="" disabled selected>Elija un el tipo de trabajador</option>
<option value="RRHH">RRHH</option>
<option value="Gestor">Gestor</option>
<option value="Trabajador">Trabajador</option>
</select>

<button type="submit"> Crear Usuario</button>

</form>

</body>
</html>