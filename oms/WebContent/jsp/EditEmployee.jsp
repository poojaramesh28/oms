<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"    import="java.util.*,com.oms.DAO.*, com.oms.model.Employee"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%  
String employee_id=request.getParameter("employee_id");  
Employee employee=AdminDAO.getEmployeeById(Long.parseLong(employee_id));  
%> 




<form action="/oms/AdminEditServlet">

id:<br>
  <input  type="text" disabled   name="employee_id" value="<%=employee.getEmployee_id() %>"/> <br>
   name:<br>
  <input type="text" name="employee_name" value="<%=employee.getEmployee_name()%>" />
  <br>
  pass <br>
  <input type="password" name="employee_password" value="<%=employee.getemployee_password()%>" />
  <br><br>
   designation <br>
  <input type="text" name="employee_designation" value="<%=employee.getEmployee_designation()%>" />
  <br><br>
  
  <input type="submit" value="Submit">
</form> 

</body>
</html>