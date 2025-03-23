<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container mb-5">
	<h1>${name}</h1>
	<h2>Enter Todo Details!</h2>
	<hr>
	<%--Form mapping to todo object : Basically form backing object --%>
	<form:form method="post" modelAttribute="todo">
		<fieldset class="mb-4">
			<label>Description</label>
			<form:input type="text" path="description" required="required" />
			<form:errors path="description" cssClass="text-warning"></form:errors>
		</fieldset>
		<fieldset class="mb-4">
			<label>Target Date</label>
			<form:input type="text" path="targetDate" required="required" />

		</fieldset>
		<form:input type="hidden" path="id" />
		<form:input type="hidden" path="done" />
		<input type="submit" class="btn btn-success" />
	</form:form>
</div>


<%@ include file="common/footer.jspf"%>

<script type="text/javascript">
	$('#targetDate').datepicker({
		format : 'yyyy-mm-dd'
	});
</script>
