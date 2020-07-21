<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	${errorMessage}

	<c:forEach items="${books}" var="item">
	<p>
	Books
	Id: <c:out value="${item.id }" />
	ISBN: <c:out value="${item.isbn }" />
	Title: <c:out value="${item.title}" />
	Publisher: <c:out value="${item.publisher}" />
	Year: <c:out value="${item.year}" />
	Available: <c:out value="${item.available}" />
		<p>
			Subject Names:
			<c:forEach items="${item.bookSubjects}" var="subject">
				<c:out value="${subject.name }" />
			</c:forEach>
	</c:forEach>


	<a href='/'> Back to home</a>
	<br />
</body>
</html>