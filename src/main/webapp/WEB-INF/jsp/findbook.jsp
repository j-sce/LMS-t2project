<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Find books</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <style>
table, td, th {
	border: 1px solid #ddd;
	text-align: left;
	padding: 15px;
}
table {
	border-collapse: collapse;
	width: 100%;
}

body {
	background-color: #F3F1F0;
}
form {
	float: left;
}
label, input {
    display: block;
}
label {
    margin: 10px;
}
.container {
	width: 700px;
  	height: 100px;
  	
}

</style>
</head>
<body>
	${errorMessage}
<div class="container">
	<form method="post" action="findbook">
		<label for="subject"> Subject</label> 
		<input name="subject" />
		<input type="Submit" style="visibility: hidden;"/>
	</form>      
	<form method="post" action="findbook">
		<label for="author"> Author</label> 
		<input name="author"/>
		<input type="Submit" style="visibility: hidden;"/>
	</form>     
	<form method="post" action="findbook">
		<label for="isbn">ISBN</label>
		<input name="isbn" /> 
		<input type="Submit" style="visibility: hidden;"/>
	</form>     
	<form method="post" action="findbook">
		<label for="title">Book title</label> 
		<input name="title" />
		<input type="Submit" style="visibility: hidden;"/>
	</form>     
	<form method="post" action="findbook">
		<label for="publisher">Publisher</label> 
		<input name="publisher"/>
		<input type="Submit" style="visibility: hidden;"/>
	</form>
	<form method="post" action="findbook">
		<label for="year">Year</label> 
		<input name="year" /> 
		<input type="Submit" style="visibility: hidden;"/>
	</form>
	<form method="post" action="findbook"> 
		<label for="available">Available</label> 
		<input name="available" /> 
		<input type="Submit" style="visibility: hidden;"/>
	</form><br>
</div>
<p>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>ISBN</th>
			<th>Title</th>
			<th>Publisher</th>
			<th>Year</th>
			<th>Available</th>
 			<th>Subject</th>
			<th>Author</th> 
		</tr>

			<tr>
			<c:forEach items="${books}" var="item">
				<tr>
				<td><c:out value="${item.id }" /></td>
				<td><c:out value="${item.isbn }" /></td>
				<td><c:out value="${item.title}" /></td>
				<td><c:out value="${item.publisher}" /></td>
				<td><c:out value="${item.year}" /></td>
				<td><c:out value="${item.available}" /></td>
				<td><c:forEach items="${item.bookSubjects}" var="subject">
					<c:out value="${subject.name}" />
				</c:forEach></td>
				<td><c:forEach items="${item.bookAuthors}" var="author">
					<c:out value="${author.name}" />
				</c:forEach></td></tr>
			</c:forEach>

	</table>
	<a href='/librarian'>Back to menu</a>

</body>
</html>