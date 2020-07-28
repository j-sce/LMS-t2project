<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

  <nav class="navbar navbar-expand navbar-dark shadow bg-dark p-1 px-md-2 mb-3">
    <div class="collapse navbar-collapse" id="navbarCollapse">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item">
          <a class="nav-link active" href="/">LMS</a>
        </li>
	<sec:authorize access="hasRole('ADMIN')">
        <li class="nav-item">
          <a class="nav-link" href="/insertbook">Insert book</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/booktoupdate">Update book</a>
        </li>
		<li class="nav-item">
          <a class="nav-link" href="/booktodelete">Delete book</a>
        </li>
	</sec:authorize>
		<li class="nav-item">
          <a class="nav-link" href="/findbook">Find book</a>
        </li>
      </ul>
      <ul class="navbar-nav ml-md-auto">
        <li class="nav-item">
      </ul>
    <sec:authorize access="!isAuthenticated()">
      <a class="btn btn-bd-download d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3 text-primary" href="/login">Login</a>
     </sec:authorize>
    <sec:authorize access="isAuthenticated()">
       <a class="btn btn-bd-download d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3 text-danger" href="/logout">Logout</a>
    </sec:authorize>
    </div>
  </nav>
