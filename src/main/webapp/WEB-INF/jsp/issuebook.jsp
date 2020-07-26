<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<tittle>Issue Book</title>
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


<%@ include file="tags/header.jsp"%>
</head>
<body>
	${errorMessage}</br>
	${message}
	<form:form method="POST" action="/issuebook" modelAttribute="book">
	   <div class="container">
			<table>
			<tr>
        		<td><form:label path="id">ID</form:label></td>
        		<td><form:input path="id" readonly="true"/></td>
        	</tr>
			<tr>
        		<td><form:label path="isbn">ISBN</form:label></td>
        		<td><form:input path="isbn" readonly="true"/></td>
        	</tr>
			<tr>
				<td><form:label path="title">Title</form:label></td>
				<td><form:input path="title" readonly="true"/></td>
			</tr>
			<tr>
				<td><form:label path="publisher">Publisher</form:label></td>
				<td><form:input path="publisher" readonly="true"/></td>
			</tr>
			<tr>
				<td><form:label path="year">Year</form:label></td>
				<td><form:input path="year" readonly="true"/></td>
			</tr>
			<tr>
            	<td><form:label path="available">available</form:label></td>
            	<td><form:input path="available" readonly="true"/></td>
            </tr>

			<tr>
         		<td><button class="btn btn-lg btn-primary btn-block" type="submit">Delete</button></td>
			</tr>
		</table>
       </div>
	</form:form>
	<br />
	<a href='/librarian'>Back to menu</a>
	<br />
</body>
</html>