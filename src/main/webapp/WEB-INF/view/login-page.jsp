<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Login form</title>
<style>
.errormessage{
	color: red;
}
</style>
</head>

<body>
	<h1>Login user </h1><br>
	<form:form
		action="${pageContext.request.contextPath}/authenticateTheUser"
		method="POST">
		
		<b>Username : </b><input type="text" name="username" /><br></br>

		<b>Password : </b> <input type="password" name="password"></input><br></br>

		<c:if test="${param.error!=null }">
		<i class="errormessage">wrong username/password</i>
		</c:if><br></br>
		
		<input type="submit" value="Login" />
		
		
		
	</form:form>
</body>
</html>