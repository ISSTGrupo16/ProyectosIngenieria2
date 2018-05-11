<form action="FormNuevosTrabajadoresServlet">


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<h3 name=proyecto>${proyecto} trabajadores</h3>


<html>

<h1>Elección de trabajadores</h1>

<h3 name=trabajador_num>Ha seleccionado ${trabajador_num} trabajadores</h3>

<c:forEach var="i" begin="1" end="${trabajador_num}" >

<h3>Trabajador ${i} :

<select name="${i}">
	<option value="" disabled selected>Elija un trabajador</option>
	<c:forEach items="${trabajador_list}" var="ti">
	<option value=${ti.email}>${ti.name}-${ti.email}</option>
	</c:forEach>
</select></h3>
</c:forEach>

<h1><button type="submit">Aceptar</button></h1>


</body>
</html>

</form>