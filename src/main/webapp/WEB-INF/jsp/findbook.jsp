<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Find books</title>
</head>

<body>
	${errorMessage}
	${message}

	<form  method="post" action="findbook">
	<label for="subject">Subject</label><br>
	<input name="subject"/> <input type="Submit" /><br>
	</form>
	<form method="post" action="findbook">
	<label for="author">Author</label><br>
	<input name="author"/> <input type="Submit"/><br>
	</form>
	<form method="post" action="findbook">
	<label for="isbn">ISBN</label><br>
	<input name="isbn"/> <input type="Submit" /><br>
	</form>
	<form method="post" action="findbook">
	<label for="title">Book title</label><br>
	<input name="title"/> <input type="Submit"/><br>
	</form>
	<form method="post" action="findbook">
	<label for="publisher">Publisher</label><br>
	<input name="publisher"/> <input type="Submit"/><br>
	</form>
	<form method="post" action="findbook">
	<label for="year">Year</label><br>
	<input name="year"/> <input type="Submit" /><br>
	</form>
	<form method="post" action="findbook">
	<label for="available">Available</label><br>
	<input name="available"/> <input type="Submit" />
	</form>
	<p>
	
			<c:forEach items="${books}" var="item">
				<p>
					Book: Id:
					<c:out value="${item.id }" />
					ISBN:
					<c:out value="${item.isbn }" />
					Title:
					<c:out value="${item.title}" />
					Publisher:
					<c:out value="${item.publisher}" />
					Year:
					<c:out value="${item.year}" />
					Available:
					<c:out value="${item.available}" />
				<p>
					Subject:
					<c:forEach items="${item.bookSubjects}" var="subject">
						<c:out value="${subject.name}" />
					</c:forEach>
				<p>
					Author:
					<c:forEach items="${item.bookAuthors}" var="author">
						<c:out value="${author.name}" />
					</c:forEach>
				<p>
			</c:forEach>
	<a href='/librarian'>Back to menu</a>

</body>
</html>