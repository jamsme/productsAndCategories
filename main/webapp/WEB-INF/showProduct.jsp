<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>       
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Product Page</title>
	<style>
	
		h3:nth-child(2) {
			margin: 0;
		}
		
	</style>
</head>
<body>
	<h2><c:out value="${product.name}"/> Product</h2>
	<h3>Categories</h3>
	<hr>
	<c:forEach items="${categories}" var="c">
		<ul>
			<li><c:out value="${c.name}"/></li>
		</ul>
	</c:forEach>
	
	<form:form action="/addCategory/${product.id}" method="post" modelAttribute="product">
		<h3><form:label path="categories">Add Category:</form:label></h3>
			<form:select path="categories">
				<c:forEach items="${allCategories}" var="a">
					<p><form:option value="${a.id}"><c:out value="${a.name}"/></form:option></p>
				</c:forEach>
			</form:select>
		<input type="submit" value="Add">
	</form:form>
	
</body>
</html>