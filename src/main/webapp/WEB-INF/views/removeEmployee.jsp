<%@page import="java.text.NumberFormat.Style"%>
<%@page import="com.hiberanate.HibernateMVC.dto.EmployeeDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="navBar.jsp" />
<%
String msg = (String) request.getAttribute("msg");
%>
<%
List<EmployeeDTO> employees = (List<EmployeeDTO>) request.getAttribute("employeeList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Management</title>
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
	<form action="./remove" method="post">
		<fieldset>
			<legend>:::Remove Employee:::</legend>
			<table>
				<tr>
					<td><label>ID</label></td>
					<td><input type="text" name="id"
						placeholder="Enter Employee ID"></td>
				</tr>
				<tr>
					<td><input type="submit" value="REMOVE"></td>
				</tr>

			</table>
		</fieldset>
	</form>
	<%
	if (employees != null) {
	%>

	<%
	if (msg != null) {
	%>
	<h3 style="text-align: center; color: red;"><%=msg%>
	</h3>
	<%
	}
	%>
	<table style="width: 100%;">
		<tr>
			<td>
				<h3>ID</h3>
			</td>
			<td><h3>Name</h3></td>
			<td>
				<h3>Designation</h3>
			</td>
			<td>
				<h3>Email</h3>
			</td>
			<td>
				<h3>Username</h3>
			</td>
			<td>
				<h3>Password</h3>
			</td>
		</tr>
		<%
		for (int i = 0; i < employees.size(); i++) {
		%>

		<tr>
			<td><%=employees.get(i).getId()%></td>
			<td><%=employees.get(i).getName()%></td>
			<td><%=employees.get(i).getDesgination()%></td>
			<td><%=employees.get(i).getEmail()%></td>
			<td><%=employees.get(i).getUserName()%></td>
			<td><%=employees.get(i).getPassword()%></td>
		</tr>

		<%
		}
		%>

	</table>
	<%
	}
	%>

</body>
</html>