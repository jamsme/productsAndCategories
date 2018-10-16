<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Category Page</title>
	<style>
	
		h3:nth-child(2) {
			margin: 0;
		}
		
	</style>
</head>
<body>
	<h2><c:out value="${category.name}"/> Category</h2>
	
	<h3>Products:</h3>
	<hr>
	<c:forEach items="${getProducts}" var="p">
		<ul>
			<li><c:out value="${p.name}"/></li>
		</ul>
	</c:forEach>
	
	<form:form action="/addProduct/${category.id}" method="post" modelAttribute="category">
		<h3><form:label path="products">Add Product:</form:label></h3>
			<form:select path="products">
				<c:forEach items="${prods}" var="p">
					<p><form:option value="${p.id}"><c:out value="${p.name}"/></form:option></p>
				</c:forEach>
			</form:select>
		<input type="submit" value="Add">
	</form:form>
</body>
</html>
