<%@page import="com.hiberanate.HibernateMVC.dto.EmployeeDTO" %>>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="navBar.jsp"/>
    <%EmployeeDTO employee =(EmployeeDTO)request.getAttribute("employee");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <% if(employee != null){ %>
      <table>
         <tr>
            <td>
               <label>Employee Name:</label>
            </td>
            <td><%=employee.getName()%></td>
         </tr>
         
          <tr>
            <td>
               <label>Employee Email:</label>
            </td>
            <td><%=employee.getEmail()%></td>
         </tr>
         
          <tr>
            <td>
               <label>Employee Designation:</label>
            </td>
            <td><%=employee.getDesgination()%></td>
         </tr>
          <tr>
            <td>
               <label>Employee Username:</label>
            </td>
            <td><%=employee.getUserName() %></td>
         </tr>
          <tr>
            <td>
               <label>Employee Password:</label>
            </td>
            <td><%=employee.getPassword()%></td>
         </tr>
         
      </table>
     <%} %>
</body>
</html>