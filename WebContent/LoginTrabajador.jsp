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
	
	<h3>Mis contratos</h3>
			<table border=1>
				<tr>
					<th>Nombre proyecto</th>
					<th>Gestor</th>
					<th>Estado</th>
					<th>Horas Asignadas</th>
					<th>Horas Trabajadas</th>
				</tr>
	
				<c:forEach items="${contratos_list}" var="co">
				<tr>
					<td>${co.proyecto.title}</td>
					<td>${co.proyecto.name}</td>
					<td>
					<c:if test="${co.proyecto.status == 1}">
						En Proceso
					</c:if>
					<c:if test="${co.proyecto.status == 2}">
						Finalizado
					</c:if>
					</td>
					<td>${co.horasAsignadas}</td>
					<td>${co.horasTrabajadas}</td>
					<c:if test="${co.proyecto.status != 2}">
					<td>
						<form action="HorasProyectoServlet">
							<input type="hidden" name="proyecto" value=${co.proyecto.title} />
							<input type="submit" value="Añadir Horas"/>
						</form>
						</td>
					</c:if>
				</tr>
				</c:forEach>
			</table>
	
	<h3>Mis proyectos</h3>
			<table border=1>
				<tr>
					<th>Nombre proyecto</th>
					<th>Nombre de gestor</th>
					<th>Estado</th>
					<th>Nº Trabajadores</th>
					<th>Horas Trabajadas</th>
					<th>Horas Totales Asignadas</th>
				</tr>
	
				<c:forEach items="${proyectos_list}" var="pi">
				<tr>
					<td>${pi.title}</td>
					<td>${pi.name}</td>
					<td>
					<c:if test="${pi.status == 1}">
						En Proceso
					</c:if>
					<c:if test="${pi.status == 2}">
						Finalizado
					</c:if>
					</td>
					<td>${pi.numeroTrabajadores}</td>
					<td>${pi.numeroHorasTrabajadas}</td>
					<td>${pi.numeroHorasTotales}</td>
				</tr>
				</c:forEach>
			</table>
	</body>
</html>