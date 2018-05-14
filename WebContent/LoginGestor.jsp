<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vista del gestor del proyecto</title>
</head>
<body>

	<h2>Vista del gestor del proyecto</h2>

	<p>Nombre: ${gestor.name}</p>
	<p>Email: ${gestor.email}</p>

	<button>
		<a href="FormProyecto1Servlet">Crear nuevo proyecto de ingeniería</a>
	</button>


	<h3>Listado de proyectos</h3>

	<table border=1>
		<tr>
			<th>Nombre proyecto</th>
			<th>Nombre de gestor</th>

			<th>Estado</th>
			<th>Nº Trabajadores</th>
			<th>Horas Trabajadas</th>
			<th>Horas Totales</th>
			<th>Info</th>
		</tr>

		<c:forEach items="${gestor.advisedProyectos}" var="pi">
			<tr>
				<td>${pi.title}</td>
				<td>${pi.name}</td>

				<td>${pi.status}</td>
				<td>${pi.numeroTrabajadores}</td>
				<td>${pi.numeroHorasTrabajadas}</td>
				<td>${pi.numeroHorasTotales}</td>

				<c:if test="${pi.status == 1}">
				</c:if>
				</td>
				<td><c:if test="${pi.status >= 4}">
						<a href="ServeFileServlet">Descargar memoria</a>
					</c:if></td>
				<td><c:if test="${pi.status == 4}">
					</c:if></td>
				<td><c:if test="${pi.status == 6 }">
						<a href="ServeFileServlet">Descargar memoria</a>
					</c:if></td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>