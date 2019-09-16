<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.oms.DAO.*, com.oms.model.*"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <title>Order Management System</title>
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
  <!-- Bootstrap core CSS -->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <!-- Material Design Bootstrap -->
  <link href="css/mdb.min.css" rel="stylesheet">
  <link rel="stylesheet" href="css/style_1.css">
  <!-- Your custom styles (optional) -->
  <link href="css/style.css" rel="stylesheet">
<style>
body {
  background-image: url("img/crop.jpg");
  background-repeat: no-repeat;
	background-size: cover;
	width: 100%;
	max-width: 960px;
	margin: 0 auto;
  
}
h1
{
color:white;
font-size: 20px;
}

</style>
</head>
<body>

<header>
    <nav class="navbar navbar">
        <form class="form-inline">
          <button class="btn purple-gradient btn-rounded" type="button" data-toggle="modal" data-target="#modalRegisterForm">LogOut</button>
         
          <!-- Just an image -->



    <a class="float-right nav-link" style="position:absolute;right:0px;">
              <img src="img/logo.png" height="50">
    </a>
    <a class="nav-link" href="#" style="color:#0b0e0e;font-weight: bold;border-bottom:3px solid rgb(199, 20, 20); position:absolute;right:250px; ">HOME
            &nbsp;<i class="fas fa-home"></i><span class="sr-only"></span></a>
        </form>
      </nav>
      </header>
    
 <b>Purchase Employee </b>
 
 
 
 
<center><h1>Items List <i class='fas fa-motorcycle'></i></h1></center>	

<% List<Items> list=ItemsDAO.getPurchaseableItems(); 
String emp_sid =request.getAttribute("employee_id").toString();
int emp_id = Integer.parseInt(emp_sid);
%>



<table class="table table-striped table-responsive-md btn-table">

  <thead>
    <tr>
      
	<th> <b>Item name</b></th>
	<th><b>Description</b></th>
	<th><b>Show Suppliers </b> </th>
    </tr>
  </thead>
<% for(Items i:list){  %>
  <tbody>
  
    <tr>
      
     
	<td><b><%=i.getItem_name()  %></b></td>
	<td><b><%=i.getItem_description() %></b></td>
	
	<td>
        <a type="button" class="btn  purple-gradient btn-rounded btn-sm m-0" href='SupplierListServlet?item_name=<%=i.getItem_name()%>&type_of_employee=manager&employee_id=<%=emp_id%>'>Show Suppliers</a>
      </td>
    </tr>
    <%} %>
   </tbody>

</table>




 <h5>This list is to appear when Show suppliers is clicked. either in same page or different page as per requirement </h5>

<h1>Supplier List</h1> 	



</body>

<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<!-- Bootstrap tooltips -->
<script type="text/javascript" src="js/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript" src="js/mdb.min.js"></script>



<script>// Material Select Initialization
      $(document).ready(function() {
      $('.mdb-select').materialSelect();
      });</script>
     
     <script>
    $(document).ready(function () {
      $('#dtDynamicVerticalScrollExample').DataTable({
      "scrollY": "50vh",
      "scrollCollapse": true,
      });
      $('.dataTables_length').addClass('bs-select');
      });
     
</script>

</html>