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
		<title>Vista de trabajador</title>
	</head>
	<body>
		<nav class="navbar navbar-default">
			<div class="navbar-header">
				<a class="navbar-brand" href="LoginTrabajador.jsp">Bienvenido, ${trabajador.name}</a>
			</div>
			<%@ include file="FormLogout.jsp" %>
		</nav>
		
		<div class="panel panel-info">
		
			<div class="panel-heading">Mis contratos</div>
			
			<table class="table">
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
						<div class="progress">
	  						<div class="progress-bar" role="progressbar" aria-valuenow="${(co.horasTrabajadas/co.horasAsignadas)*100}" aria-valuemin="0" aria-valuemax="100" style="width: ${(co.horasTrabajadas/co.horasAsignadas)*100}%;">
	    					<span class="sr-only">${(co.horasTrabajadas/co.horasAsignadas)*100}% Complete</span>
							</div>
						</div>
					</c:if>
					<c:if test="${co.proyecto.status == 2}">
						<li class="list-group-item list-group-item-success" role="alert">Finalizado</li>
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
		</div>
	
		<div class="panel panel-info">
			<div class="panel-heading">Proyectos de los que forma parte</div>
			<table class="table">
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
						<div class="progress">
	  						<div class="progress-bar" role="progressbar" aria-valuenow="${(pi.numeroHorasTrabajadas/pi.numeroHorasTotales)*100}" aria-valuemin="0" aria-valuemax="100" style="width: ${(pi.numeroHorasTrabajadas/pi.numeroHorasTotales)*100}%;">
	    					<span class="sr-only">${(pi.numeroHorasTrabajadas/pi.numeroHorasTotales)*100}% Complete</span>
							</div>
						</div>
					</c:if>
					<c:if test="${pi.status == 2}">
						<li class="list-group-item list-group-item-success" role="alert">Finalizado</li>
					</c:if>
					</td>
					<td>${pi.numeroTrabajadores}</td>
					<td>${pi.numeroHorasTrabajadas}</td>
					<td>${pi.numeroHorasTotales}</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>