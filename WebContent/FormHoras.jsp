<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Añadir horas de trabajo</title>
	</head>
	<body>
		<h2>Añadir horas al proyecto ${proyecto_horas.title} ${proyecto_horas.numeroHorasTrabajadas}</h2>
		<form action="HorasServlet">
			<h3>Horas de inicio del trabajo: <input type="datetime-local"  min="2018-01-01T00" max="2050-01-01T00" name="hora_inicio" value="${hoy_dia}" step="3600"></h3>
			<h3>Horas de finalización del trabajo: <input type="datetime-local" min="2018-01-01T00" max="2050-01-01T00" name="hora_fin" value="${hoy_dia2}" step="3600"> </h3>
			<input type = "submit" value="Confirmar"/>
		</form>
	</body>
</html>