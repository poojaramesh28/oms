<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"    import="java.util.*,com.oms.DAO.*, com.oms.model.Items" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%  
String item_id=request.getParameter("item_id");  
Items item=SupplierDAO.getItemById(Long.parseLong(item_id));  
%> 
<%=item.getItem_id() %>



<form action="../SupplierUpdateItems">

item id :<br>
  <input type="text" disabled  name="item_id" value="<%=item.getItem_id()%>"/> 

  
item cost:<br>
  <input type="text"  name="item_cost" /> 
  
<br>
   item name<br>
  <input type="text" name="item_name" />
  <br>
  
  item description <br>
  <input type="text" name="item_description" />
  <br><br>
   item Status <br>
  <input type="text" name="item_status" />
  <br><br>
  
   Quantity <br>
  <input type="text" name="item_quantity" value="<%=item.getItem_quantity()%>" />
  <br><br>
  
  <input type="submit" value="Submit">
</form> 



</body>
</html>