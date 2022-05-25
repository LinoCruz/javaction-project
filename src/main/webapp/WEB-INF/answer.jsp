<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>New Algorithm</title>
</head>
<body>
<div class="container">
<h1>Now add the answers</h1>
</div>

<div class="container row">
	<div class="col-5">
	<form:form action="/algorithms/answer" method="post" modelAttribute="answer">
					<div class="form-group">
						<form:label path="code">Answer One:</form:label>
						<form:textarea path="code" class="form-control"></form:textarea>
						<form:errors path="code" class="text-danger"/>
					</div>
					<form:hidden path="algorithm" value="${algorithm}" />
					<input type="submit" value="Add Answer" class="btn btn-primary">
	</form:form>
	</div>
	
	
	<div class="col-3">
	<form:form action="/algorithms/video" method="post" modelAttribute="video">
					<form:hidden path="algorithm" value="${algorithm}" />
					<div class="form-group">
						<form:label path="link">Video:</form:label>
						<form:input path="link" class="form-control"/>
						<form:errors path="link" class="text-danger"/>
					</div>
					<input type="submit" value="Add Video" class="btn btn-primary">
					
	</form:form>
	</div>


</div>
<div>
<h3>You have it all?</h3>
<a href="/logout" class="btn btn-success">Finish</a>
<a href="/algorithms/admin" class="btn btn-warning">Create a new one</a>
</div>

</body>
</html>