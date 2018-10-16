<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>       
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Product</title>
</head>
<body>
	<h2>New Product</h2>
	<form:form action="/product" method="post" modelAttribute="product">
		<h3><form:label path="name">Name</form:label></h3>
		<form:input path="name"/>
		<h3><form:label path="description">Description</form:label></h3>
		<form:textarea path="description"/>
		<h3><form:label path="price">Price</form:label></h3>
		<form:input type="number" path="price"/>
		<input type="submit" value="Create">
	</form:form>
</body>
</html>