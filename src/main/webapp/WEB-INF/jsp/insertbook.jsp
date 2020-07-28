<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Book</title>
<%@ include file="tags/header.jsp"%>
</head>
<body>
	${errorMessage}</br>
	${message}
	<form:form method="POST" action="/insertbook" modelAttribute="book">

	  <div class="container">
        <br />
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
                     	<td><form:label path="available">Available</form:label></td>
                     	<td><form:input path="available"/></td>
                     </tr>
                     <tr>
                     	<td><form:label path="bookAuthors">Authors</form:label></td>
                     	<td><form:select path="bookAuthors" multiple="true">
                     	<form:options items="${authorsList}"  itemValue="id" itemLabel="name"/>
                     	</form:select></td>
                     </tr>
                     <tr>
                        <td><form:label path="bookSubjects">Subjects</form:label></td>
                        <td><form:select path="bookSubjects" multiple="true">
                        <form:options items="${subjectList}"  itemValue="id" itemLabel="name"/>
                        </form:select></td>
                     </tr>


         			<tr>
         				<td><button class="btn btn-lg btn-primary btn-block" type="submit">Insert</button></td>
         			</tr>
         		</table>


       </div>
	</form:form>
    <%@ include file="tags/footer.jsp"%>
</body>
</html>