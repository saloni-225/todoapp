<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
		<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
		<title>Login</title>
	</head>
	<body>
		<div class="container mb-5">
				<h1>${name}</h1>
				<h2>Enter Todo Details!</h2>
				<hr>
				<%--Form mapping to todo object : Basically form backing object --%>
				<form:form method="post" modelAttribute="todo">
					Description <form:input type="text" path="description"  required="required" />
					<form:errors path="description" cssClass="text-warning"></form:errors>
					<form:input type="hidden" path="id" />
					<form:input type="hidden" path="done"  />
					<input type="submit" class="btn btn-success" />
				</form:form>	
			</div>
				
				
				<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
				<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</body>
</html>