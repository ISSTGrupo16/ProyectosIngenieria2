<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Vista del trabajador</title>
	</head>
	<body>
	<h2>Vista del trabajador</h2>
		<p>Nombre: ${trabajador.name}</p>
			<p>Email: ${trabajador.email}</p>
	<%@ include file="FormLogout.jsp" %>
	
	<h3>Mis proyectos</h3>
			<table border=1>
				<tr>
					<th>Nombre proyecto</th>
					<th>Nombre de gestor</th>
					<th>Estado</th>
					<th>Nº Trabajadores</th>
					<th>Horas Trabajadas</th>
					<th>Horas Totales Asignadas</th>
					<th>Añadir horas</th>
				</tr>
	
				<c:forEach items="${proyectos_list}" var="pi">
				<tr>
					<td>${pi.title}</td>
					<td>${pi.name}</td>
					<td>${pi.status}</td>
					<td>${pi.numeroTrabajadores}</td>
					<td>${pi.numeroHorasTrabajadas}</td>
					<td>${pi.numeroHorasTotales}</td>
					<td>
					<c:if test="${pi.status != 2}">
						<form action="HorasProyectoServlet">
							<input type="hidden" name="proyecto" value=${pi.title} />
							<input type ="submit"> Añadir horas Trabajadas </input>
						</form>
					</c:if>
					</td>
				</tr>
				</c:forEach>
			</table>
	</body>
</html>