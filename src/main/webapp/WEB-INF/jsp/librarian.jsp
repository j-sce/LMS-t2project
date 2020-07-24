<%@ page language="java"
	contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Library</title>
<%@ include file="tags/header.jsp"%>
</head>
<body>
<div class="container">
    <br />
    <a href='/findbook'><button class="btn btn-lg btn-primary btn-block" type="submit">Find book</button></a>
	<br />
    <a href='/insertbook'><button class="btn btn-lg btn-primary btn-block" type="submit">Insert book</button></a>
	<br />
	<a href='/updatebook'><button class="btn btn-lg btn-primary btn-block" type="submit">Update book</button></a>
    <br />
	<a href='/deletebook'><button class="btn btn-lg btn-primary btn-block" type="submit">Delete book</button></a>
    <br />
</div>
	<br />
	<a href='/'>Back to home</a>
	<br />
</body>
</html>