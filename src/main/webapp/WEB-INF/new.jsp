<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Admin</title>
</head>
<body>
<div class="container">
<h1>Welcome to the Jungle Admin</h1>
<h2>Let's create a new code challenge</h2>

</div>

<div class="container">
		<h1>New Challenge</h1>
		<form:form action="/algorithms/create" method="post" modelAttribute="algorithm">
			<div class="form-group">
				<form:label path="name">Name:</form:label>
				<form:input path="name" class="form-control"/>
				<form:errors path="name"/>
			</div>
			<div class="form-group">
				<form:label path="challenge">Challenge:</form:label>
				<form:textarea path="challenge" class="form-control"/>
				<form:errors path="challenge"/>
			</div>
				<div class="form-group">
				<form:label path="moreinfo">Additional Info:</form:label>
				<form:textarea path="moreinfo" class="form-control"/>
				<form:errors path="moreinfo"/>
			</div>
			
			<div class="form-group">
					<form:label path="type">Type:</form:label>
					<form:select path="type" class="form-control">
						<c:forEach var="type" items="${types}">
							<option value="${type}">${type}</option>
						</c:forEach>
					</form:select>
					<form:errors path="type" class="text-danger" />
			</div>		
				
			<form:hidden path="user" value="${user_session.id }"/>
			<form:hidden path="status" value="undone"/>
			<input type="submit" value="Next part" class="btn btn-success">
		</form:form>
	</div>
</body>
</html>