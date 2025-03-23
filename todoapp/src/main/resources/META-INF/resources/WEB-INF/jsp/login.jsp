<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<h1>Login</h1>
	<hr>
	<pre>${errorMessage}</pre>
	<form method="post">
		Name <input type="txt" name="name"> Password <input
			type="password" name="password"> <input type="submit">
	</form>
</div>

<%@ include file="common/footer.jspf"%>