<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Añadir Trabajadores</title>
</head>
<body>
	<form action="FormNuevosTrabajadoresServlet">

		<h1 name=proyecto>${proyecto.title}: Añadir trabajadores</h1>

		<h2>Elección de trabajadores</h2>
		<h3 name=trabajador_num>Ha seleccionado ${trabajador_num} trabajadores</h3>

		<c:forEach var="i" begin="1" end="${trabajador_num}">
			<h3>
				Trabajador ${i} : 
				<select name="${i}">
					<option value="" disabled selected>Elija un trabajador</option>
					<c:forEach items="${trabajadores_list}" var="ti">
						<option value=${ti.email}>${ti.name}-${ti.email}</option>
					</c:forEach>
				</select>
			</h3>
		</c:forEach>

		<h1>
			<button type="submit">Aceptar</button>
		</h1>
	</form>
</body>
</html>
