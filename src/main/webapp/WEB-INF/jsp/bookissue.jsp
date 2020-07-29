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
	<form:form method="POST" action="/bookissue" modelAttribute="bookIssue">

	  <div class="container">
        <br />
	     <table>
                  	<tr>
                  		<td><form:label path="issue">Issue Date</form:label></td>
                  		<td><form:input type="date" path="issue"/></td>
                  	</tr>
                  	<tr>
                  		<td><form:label path="toReturn">Return Date</form:label></td>
                  		<td><form:input type="date" path="toReturn"/></td>
                  	</tr>

                     <tr>
                     	<td><form:label path="borrower">Member</form:label></td>
                     	<td><form:select path="borrower" multiple="false">
                     	<form:options items="${memberList}"  itemValue="id" itemLabel="name"/>
                     	</form:select></td>
                     </tr>
                     <tr>
                     	<td><form:label path="bookToIssue">Book</form:label></td>
                     	<td><form:select path="bookToIssue" multiple="false">
                     	<form:options items="${bookList}" itemValue="id" itemLabel="title"/>
                     	</form:select></td>
                     </tr>


         			<tr>
         				<td><button class="btn btn-lg btn-primary btn-block" type="submit">Issue Book</button></td>
         			</tr>
         		</table>
       </div>
	</form:form>

</body>
    <%@ include file="tags/footer.jsp"%>
</html>