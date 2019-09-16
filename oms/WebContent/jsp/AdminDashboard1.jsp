<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"   import="java.util.*,com.oms.DAO.*, com.oms.model.Employee"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

--Users list from AdminDAO.getallemployees()
--Button to add new user
--Button to delete user
--Button to modify user




 Admin's jsp page
 
<h2>add Form</h2>

<form action="/oms/AdminAddServlet" method="post">
   name:<br>
  <input type="text" name="employee_name" >
  <br>
  pass <br>
  <input type="password" name="employee_password" >
  <br><br>
   designation <br>
  <input type="text" name="employee_designation" >
  <br><br>
  
  <input type="submit" value="Submit">
</form> 





<h1>Employees List</h1>
<div align="center"><img src="images/world.gif" width="10%" height="10%"></div>
<% List<Employee> list=AdminDAO.getAllEmployees();  %>
<div class="test">
<table>
<tr>
	<th>Employee ID</th>
	<th> Employee name</th>
	<th>designation </th>
	<th>Edit </th>
	<th>Delete  </th>

</tr>
<% for(Employee i:list){  %>
<tr>
	<td><%=i.getEmployee_id()  %></td>
	<td><%=i.getEmployee_name()  %></td>
	<td><%=i.getEmployee_designation()  %></td>

	<td><a href='EditEmployee.jsp?employee_id=<%=i.getEmployee_id()%>'>Edit</a></td>
	<td><a href='/oms/AdminDeleteServlet?employee_id=<%=i.getEmployee_id()%>'>Delete</a></td>
	</tr>
	
	<%} %>



 
 
 

</body>
</html>