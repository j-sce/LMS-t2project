<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book title</title>
<%@ include file="tags/header.jsp"%>
</head>
<body>
	${errorMessage}</br>
	${message}
	<form:form method="POST" action="/insertbook" modelAttribute="book">
		<table>

			<tr>
        		<td><form:label path="isbn">ISBN</form:label></td>
        		<td><form:input path="isbn"/></td>
        	</tr>
			<tr>
				<td><form:label path="title">Title</form:label></td>
				<td><form:input path="title"/></td>
			</tr>
			<tr>
				<td><form:label path="publisher">Publisher</form:label></td>
				<td><form:input path="publisher"/></td>
			</tr>
			<tr>
				<td><form:label path="year">Year</form:label></td>
				<td><form:input path="year"/></td>
			</tr>
			<tr>
            	<td><form:label path="available">available</form:label></td>
            	<td><form:input path="available"/></td>
            </tr>

			<tr>
				<td><input type="submit" value="Submit"/></td>
			</tr>
		</table>

	</form:form>
	<a href='/'>Back to home</a>
	<br />
</body>
</html>