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
		<title>Vista de recursos humanos</title>
	</head>
	<body>
		<nav class="navbar navbar-default">
			<div class="navbar-header">
				<a class="navbar-brand" href="LoginRRHH.jsp">Bienvenido, ${rrhh.name}</a>
			</div>
			<%@ include file="FormLogout.jsp" %>
		</nav>
		
		<button><a href="FormCrearUsuario.jsp">Crear Usuario</a></button>
		<div> 
		<br/>
		</div>
		<div class="panel panel-default" border>
			<div class="panel-heading">Listado de proyectos</div>
			
			<table class="table" >
				<tr>
					<th>Nombre proyecto</th>
					<th>Nombre de gestor</th>
					<th>Estado</th>
					<th>Nº Trabajadores</th>
					<th>Horas Trabajadas</th>
					<th>Horas Totales</th>
				</tr>
				
				<c:forEach items="${proyecto_list}" var="pi">
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
						<c:if test="${pi.status >= 2}">
							<td>
								<form action="DescargarInformeServlet">
									<input type="hidden" name="title" value="${pi.title}"/>
									<button type="submit">Descargar Informe</button>
								</form>
							</td>
						</c:if>
						<c:if test="${pi.status < 2}">
							<td>
								<div class="progress">
			  						<div class="progress-bar" role="progressbar" aria-valuenow="${(pi.numeroHorasTrabajadas/pi.numeroHorasTotales)*100}" aria-valuemin="0" aria-valuemax="100" style="width: ${(pi.numeroHorasTrabajadas/pi.numeroHorasTotales)*100}%;">
			    					<span class="sr-only">${(pi.numeroHorasTrabajadas/pi.numeroHorasTotales)*100}% Complete</span>
									</div>
								</div>
							</td>
						</c:if>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>