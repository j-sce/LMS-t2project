<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Book</title>
<%@ include file="tags/header.jsp"%>
</head>
<body>
	${errorMessage}</br>
	${message}
	<form:form method="POST" action="/updatebook" modelAttribute="book">

	  <div class="container">
        <br />
		<table>
			<tr>
        		<td><form:label path="id">ID</form:label></td>
        		<td><form:input path="id" readonly="true"/></td>
        	</tr>
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
            	<td><form:label path="available">Available</form:label></td>
            	<td><form:input path="available"/></td>
            </tr>

			<tr>
         		<td><button class="btn btn-lg btn-primary btn-block" type="submit">Update</button></td>
			</tr>
		</table>
       </div>
	</form:form>
	<br />
	<a href='/librarian'>Back to menu</a>
	<br />
</body>
</html>