<%@ page language="java"
	contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	${errorMessage}</br>
	
	<c:forEach items = "${author} " var="item">
	Author Id<c:out value = "$(item.id)"/><p>
	Author Name<c:out value = "$(item.name)"/><p>
	</c:forEach>
 
	<a href='/'> Back to home</a>
	<br />
</body>
</html>