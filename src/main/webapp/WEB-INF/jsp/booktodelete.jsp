<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select book to delete</title>
<%@ include file="tags/header.jsp"%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

</head>
<body>
<div>Select book to delete:<a class="anchorjs-link "aria-label="Anchor" data-anchorjs-icon="#" style="padding-left: 0.375em;"></a></div>

<div class="bd-example">
<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Title</th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
    			<tr>
    			<c:forEach items="${books}" var="item">
    				<tr>
    				<td><c:out value="${item.id }" /></td>
    				<td><c:out value="${item.title}" /></td>
    				<td><a href="/deletebook/${item.id}">Delete</a></td>
    			</c:forEach>
                </tr>
  </tbody>
</table>
</div>
  <%@ include file="tags/footer.jsp"%>
</body>
</html>