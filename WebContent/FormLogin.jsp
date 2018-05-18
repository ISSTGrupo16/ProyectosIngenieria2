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
	</head>
	<body>
		<form action="LoginServlet">
			<h1>Gestión de proyectos de ingeniería</h1>
			<h2>
			<h2>Email:</h2>
			<input type="text" name="email" placeholder="email" />
			</h2>
			
			<h2>
			<h2>Contraseña:</h2>
			<input type="password" name = "password" placeholder="password"/>
			</h2>
			
			<h2><button type="submit">Login</button></h2>
			
			
		</form>
		
	</body>
</html>