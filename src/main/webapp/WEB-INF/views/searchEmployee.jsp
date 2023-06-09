<%@page import="com.hiberanate.HibernateMVC.dto.EmployeeDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="navBar.jsp" />
<%
EmployeeDTO employee = (EmployeeDTO) request.getAttribute("employee");
%>
<%
String msg = (String) request.getAttribute("msg");
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
	<form action="./search" method="post">
		<fieldset>
			<legend>:::Search Employee:::</legend>
			<table>
				<tr>
					<td><label>Enter Employee ID</label></td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td><input type="submit" value="SEARCH"></td>
				</tr>
			</table>
		</fieldset>
	</form>
	<%
	if (msg != null) {
	%>
	<h3 style="text-align: center; color: red;"><%=msg%></h3>
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
</html>