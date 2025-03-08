<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
		<title>Login</title>
	</head>
	<body>
		<div class="container mb-5">
				<h1>${name}</h1>
				<h2>Welcome to Todo page!</h2>
				<hr>
				
				
				<table class="table">
					<thead>
						<tr>
							
							<th>Description</th>
							<th>Target Done</th>
							<th>Is Done?</th>
							<th></th>
							<th></th>
							
						</tr>
					</head>
					<tbody>
						<c:forEach items="${todos}" var="todo">
							<tr>
								<td>${todo.description}</td>
								<td>${todo.targetDate}</td>
								<td>${todo.done}</td>
								<td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a></td>
								<td><a href="update-todo?id=${todo.id}" class="btn btn-success">Update</a></td>
								
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<a href="add-todo" class="btn btn-success">Add Todo</a>
				
			</div>
				
				
				<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
				<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</body>
</html>