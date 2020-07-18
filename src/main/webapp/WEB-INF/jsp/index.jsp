<%@ page language="java"
	contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="tags/header.jsp"%>
</head>
<body>
<div class="container">
  <div class="card-deck mb-3 text-center">
    <div class="card mb-4 shadow-sm">
      <div class="card-header">
        <h4 class="my-0 font-weight-normal">Student</h4>
      </div>
      <div class="card-body">
        <a href='/student'><button type="button" class="btn btn-lg btn-block btn-outline-primary">Sign</button></a>
      </div>
    </div>
    <div class="card mb-4 shadow-sm">
      <div class="card-header">
        <h4 class="my-0 font-weight-normal">Librarian</h4>
      </div>
      <div class="card-body">
        <a href='/librarian'><button type="button" class="btn btn-lg btn-block btn-outline-primary">Sign</button></a>
      </div>
    </div>
  </div>

</body>
</html>