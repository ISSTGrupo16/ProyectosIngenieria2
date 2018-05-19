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
		<ul class="navbar navbar-dark">
  			<span class="navbar-brand mb-0 h1">Gestión de proyectos de ingeniería</span>
		</ul>
		
		<form class="needs-validation" action="LoginServlet">
			<div class="form-group">
			<Label for="email">Dirección email</label>
			<input type="text" class="form-control" name="email" placeholder="email" />
			</div>
			
			<div class="form-group">
			<label for="password">Contraseña</label>
			<input type="password" class="form-control" name = "password" placeholder="password"/>
			</div>
			<button type="submit" class="btn btn-primary ">Login</button>
			
		</form>
		
	</body>
</html>