<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style type="text/css">
fieldset table {
	margin: auto;
	text-align: left;
}
fieldset {
	margin: 15px 520px;
	text-align: center;
}
legend {
	color: white;
	background-color: #333;
}
</style>
</head>
<body>
	<%
	if (msg != null) {
	%>
	<h3 style="color: red; text-align: center;"><%=msg%>
	</h3>
	<%
	}
	%>
	<fieldset>
		<legend>:::Login:::</legend>
		<form action="./login" method="post">
			<table>
				<tr>
					<td><label>Username</label></td>
					<td><input type="text" name="userName"></td>
				</tr>
				<tr>
					<td><label>Password</label></td>
					<td><input type="password" name="password"></td>
				</tr>

				<tr>
					<td><input type="submit" value="LOGIN"></td>
				</tr>
			</table>
		</form>
	</fieldset>


</body>
</html>