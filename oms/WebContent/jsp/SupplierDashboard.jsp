<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.oms.DAO.*, com.oms.model.Items"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Insert items</h1>
<form action="/oms/SupplierAddItems" >
   item name:<br>
  <input type="text" name="item_name" >
  <br>
  item description <br>
  <input type="text" name="item_description" >
  <br><br>
   item cost <br>
  <input type="text" name="item_cost" >
  <br><br>
  
   item quantity <br>
  <input type="text" name="item_quantity" >
  <br><br>
  
   item status <br>
  <input type="text" name="item_status" >
  <br><br>
  
  
   supplier id <br>
  <input type="text" name="supplier_id" >
  <br><br>
  
  
  
  <input type="submit" value="Submit">
</form> 






<h1>Items List</h1>
<div align="center"><img src="images/world.gif" width="10%" height="10%"></div>
<% List<Items> list=SupplierDAO.getAllItems();  %>

<div class="test">
<table>
<tr>
	<th>item ID</th>
	<th> Item name</th>
	<th>Description</th>
	<th>Cost </th>
	<th> Quantity</th>
	<th>Status</th>
	<th>Edit </th>
	<th>Delete  </th>

</tr>
<% for(Items i:list){  %>
<tr>
	<td><%=i.getItem_id() %></td>
	<td><%=i.getItem_name()  %></td>
	<td><%=i.getItem_description() %></td>
	<td><%=i.getItem_cost() %></td>
	<td><%=i.getItem_quantity()  %></td>
	<td><%=i.getItemStatus()  %></td>
	
	
	<td><a href='EditItems.jsp?item_id=<%=i.getItem_id()%>'>Edit</a></td>
	<td><a href='/oms/SupplierDeleteItems?item_id=<%=i.getItem_id()%>'>Delete</a></td>
	</tr>
	
	<%} %>

</table>


</body>
</html>