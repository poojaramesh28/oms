<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"    import="java.util.*,com.oms.DAO.*, com.oms.model.*"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%  
String item_name=request.getParameter("item_name");  
List<SupplierList> list =SupplierListDAO.getSupplierList(item_name);
String emp_sid =request.getAttribute("employee_id").toString();
int emp_id = Integer.parseInt(emp_sid);
%>

%> 
<% for(SupplierList s:list){  %>



>
<table>
<tr>
	<th>supplier name</th>
	<th> Item cost</th>
	<th>Quantity</th>
	<th>Send for Approval</th>
	

</tr>
<tr>
<form action="/oms/ManagerOrderServlet">
<input hidden name="employee_id" value=<%=emp_id %> "/>
<input hidden name="supplier_id" value="<%=s.getSupplierId() %>" />
	<input hidden name="item_id" value="<%=s.getItem_id()%>" />
	<td><input readonly  name="supplier_name" value="<%=s.getSupplierName() %>" /></td>
	<td><input readonly name="item_cost"  value="<%=s.getItemCost() %>" /></td>
	<td><input type="number" name="item_quantity" /></td>
	<td><input type="submit" value="Place Order">
</form> 
	
	
	</tr>
	
<%} %>

</table>


</body>
</html>