<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>       
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Category</title>
</head>
<body>
	<h2>New Category</h2>
	<form:form action="/category" method="post" modelAttribute="category">
		<h3><form:label path="name">Name</form:label></h3>
		<form:input path="name"/>
		<input type="submit" value="Create">
	</form:form>
</body>
</html>