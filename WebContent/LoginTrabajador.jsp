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

<%@ include file="FormLogout.jsp" %>

<c:forEach items="${proyectos_list}" var="pi">
<tr>
<td>${pi.title}</td>
<td>${pi.name}</td>
<td>${pi.status}</td>
<td>${pi.numeroTrabajadores}</td>
<td>${pi.numeroHorasTrabajadas}</td>
<td>${pi.numeroHorasTotales}</td>
</tr>
</c:forEach>



</body>
</html>