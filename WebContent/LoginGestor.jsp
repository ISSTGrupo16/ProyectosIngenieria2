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
	<title>Vista de gestor</title>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<a class="navbar-brand" href="LoginGestor.jsp">Bienvenido, ${gestor.name}</a>
		</div>
		<%@ include file="FormLogout.jsp" %>
	</nav>

	<button>
		<a href="FormProyecto1Servlet">Crear nuevo proyecto de ingeniería</a>
	</button>


	<h3>Listado de proyectos</h3>

	<table class="table">
		<tr>
			<th>Nombre proyecto</th>
			<th>Estado</th>
			<th>Nº Trabajadores</th>
			<th>Horas Trabajadas</th>
			<th>Horas Totales</th>
		</tr>

		<c:forEach items="${gestor.advisedProyectos}" var="pi">
			<tr>
				<td>${pi.title}</td>
				<td><c:if test="${pi.status == 1}">
						En Proceso
					</c:if> <c:if test="${pi.status == 2}">
						Finalizado
					</c:if></td>
				<td>${pi.numeroTrabajadores}</td>
				<td>${pi.numeroHorasTrabajadas}</td>
				<td>${pi.numeroHorasTotales}</td>
				<c:if test="${pi.status == 1}">
					<td>
						<form action="FormNuevoTrabajadorServlet">
							<input type="hidden" name="title" value="${pi.title}" /> 
							<button type="submit">Añadir Trabajador</button>
						</form>
					</td>
				</c:if>
				<c:if test="${pi.status == 1}">
					<td>
						<form action="FinalizaProyectoServlet">
							<input type="hidden" name="proyecto_title" value="${pi.title}" />
							<button type="submit">Finalizar Proyecto</button>
						</form>
					</td>
				</c:if>
			</tr>
		</c:forEach>
	</table>

</body>
</html>