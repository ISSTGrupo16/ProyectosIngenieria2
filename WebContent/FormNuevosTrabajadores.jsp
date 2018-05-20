<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="css/bootstrap.min.css">   		
    	<script src="js/bootstrap.min.js"></script>
		<title>Añadir Trabajadores</title>
	</head>
	<body>
		<nav class="navbar navbar-default">
			<div class="navbar-header">
				<a class="navbar-brand" href="FormNuevosTrabajadores.jsp">Añada trabajadores al proyecto ${proyecto.title}</a>
			</div>
		</nav>
	
	
		
		<form action="FormNuevosTrabajadoresServlet">
			<div class="page-header">
			  <h2>Ha seleccionado ${trabajador_num} trabajadores</h2>
			</div>
			
			<c:forEach var="i" begin="1" end="${trabajador_num}">
				<div class="form-group">
					<Label for="trabajador">Trabajador ${i} : </Label>
					<select class="form-control" name="${i}">
						<option value="" disabled selected>Elija un trabajador</option>
						<c:forEach items="${trabajadores_list}" var="ti">
							<option value=${ti.email}>${ti.name}-${ti.email}</option>
						</c:forEach>
					</select>
					Horas Asignadas:
					<input type="number" class="form-control" name="l${i}"></input>
				</div>	
			</c:forEach>
			<h1>
				<button type="submit" class="btn btn-primary">Aceptar</button>
			</h1>
		</form>
	</body>
</html>
