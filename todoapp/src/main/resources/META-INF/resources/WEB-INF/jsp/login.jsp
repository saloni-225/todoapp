<html>
	<head>
		<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
		<title>Login</title>
	</head>
	<body>
		<div class="container">
			<h1>Login</h1>
			<hr>
			<pre >${errorMessage}</pre>
			<form method="post">
				Name <input type="txt" name ="name">
				Password <input type="password" name="password">
				<input type="submit">
			</form>
		</div>
		
		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</body>
</html>