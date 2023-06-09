<%@page import="com.hiberanate.HibernateMVC.dto.EmployeeDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="navBar.jsp" />
<%
String message = (String) request.getAttribute("msg");
%>
<%
EmployeeDTO employee = (EmployeeDTO) request.getAttribute("employee");
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
	<fieldset>
		<legend>:::Insert Employee Details:::</legend>
		<form action="./insert" method="post">
			<table>
				<tr>
					<td><label>Name</label></td>
					<td><input type="text" name="name"
						placeholder="Employee Full Name"></td>
				</tr>
				<tr>
					<td><label>Email</label></td>
					<td><input type="text" name="email"
						placeholder="Employee Email"></td>
				</tr>
				<tr>
					<td><label>Designation</label></td>
					<td><input type="text" name="designation"
						placeholder="Employee Designation"></td>
				</tr>
				<tr>
					<td><label>Username</label></td>
					<td><input type="text" name="userName"
						placeholder="Employee Username"></td>
				</tr>
				<tr>
					<td><label>Password</label></td>
					<td><input type="text" name="password"
						placeholder="Employee Password"></td>
				</tr>
				<tr style="float: none;">
					<td><input type="submit" value="SUBMIT"></td>
				</tr>
			</table>
		</form>
	</fieldset>
	<%
	if (message != null) {
	%>
	<h3 style="text-align: center; color: #28F473;"><%=message%></h3>
	<%
	}
	%>
	<%
	if (employee != null) {
	%>
	<table style="width: 100%;">
		<thead>
			<tr>
				<th><label>Employee ID</label></th>
				<th><label>Employee Name</label></th>
				<th><label>Employee Email</label></th>
				<th><label>Employee Designation</label></th>
				<th><label>Employee UserName</label></th>
				<th><label>Employee Password</label></th>
			</tr>
		</thead>
		<tbody>
			<tr style="text-align: center;">

				<td><%=employee.getId()%></td>

				<td><%=employee.getName()%></td>

				<td><%=employee.getEmail()%></td>

				<td><%=employee.getDesgination()%></td>

				<td><%=employee.getUserName()%></td>

				<td><%=employee.getPassword()%></td>
			</tr>
		</tbody>


	</table>
	<%
	}
	%>
</body>
</html>ss