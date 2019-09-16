<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*,com.oms.DAO.*, com.oms.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Order Management System</title>
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="css/mdb.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/style_1.css">
<!-- Your custom styles (optional) -->
<link href="css/style.css" rel="stylesheet">
</head>
<body>



	<%
		//String employee_id=request.getParameter("employee_id");  
		//Employee employee=AdminDAO.getEmployeeById(Long.parseLong(employee_id));
	%>


	<%
		List<Orders> list = OrderDAO.getOrderedItems();
		List<Items> list1 = ItemsDAO.getPurchaseableItems();
	%>


	<section>
				
			<div class="modal fade" id="modalRegisterForm" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content" style="width:650px">
					<div class="modal-header text-center">
						<h4 class="modal-title w-100 font-weight-bold">Pending</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					
						
	<table id="dtVerticalScrollExample"
		class="table table-striped table-bordered table-md container"
		cellspacing="0" width="100%">

		<thead>
			<tr>
				<th class="th-sm"><b><u>Order ID</u></b></th>
				
				<th class="th-sm"><b><u>Quantity</u></b></th>
				<th class="th-sm"><b><u>Total Cost</u></b></th>
				<th class="th-sm"><b><u>Accept</u></b></th>
				<th class="th-sm"><b><u>Reject</u></b></th>
				
			</tr>

		</thead>
		<%
			for (Orders o : list) {
		%>
		<tbody>
			<tr>
              <form action="">
              <input hidden name="supplier_id" value="<%=o.getSupplier_id() %>" />
	          <input hidden name="item_id" value="<%=o.getItem_id()%>" />
				<td><%=o.getOrder_id()%></td>
				
			<td><%=o.getOrder_quantity()%></td>
                <td><%=o.getOrder_cost() %></td> 
				<td><a type="button"
						href='EditEmployee.jsp?employee_id=<%=o.getItem_id()%>'
						class="btn btn-success btn-sm m-0 waves-effect user-modify-btn"
						data-toggle="modal" data-target="#modalRegisterForm">Accept</a></td>
				<td><a type="button"
					class="btn btn-danger btn-sm m-0 waves-effect delete-confirm-btn"
					data-toggle="modal" data-target="#modalConfirmDelete">Reject</a></td> 
					</form>
			</tr>
			<%
				}
			%>
		</tbody>

	</table>
				</div>
			</div>
			</section>
			
			
			<section>
			<div class="modal fade" id="modalRegisterForm1" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header text-center">
						<h4 class="modal-title w-100 font-weight-bold">Add Items</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<form action="SupplierAddItems">
						<div class="modal-body mx-3">

							<div class="md-form mb-5">
								<i class="fas fa-user prefix grey-text"></i> <input type="text"
									name="item_name" id="orangeForm-name"
									class="form-control validate"> <label
									data-error="wrong" data-success="right" for="orangeForm-name">Item Name
								</label>
							</div>


							<div class="md-form mb-4">
								<i class="fas fa-info prefix grey-text"></i> <input
									type="text" name="item_description" id="orangeForm-pass"
									class="form-control validate"> <label
									data-error="wrong" data-success="right" for="orangeForm-pass">Item Desc</label>
							</div>


							
									
							</div>
							

							<div class="modal-footer">
								<button type="button" class="btn aqua-gradient"
									data-dismiss="modal">Close</button>
								<button type="submit" class="btn aqua-gradient">Add</button>
							</div>
						</div>
					</form>

				</div>
			</div>
		
		
		
		<section>

			
		</section>
		<!--Modal: modalConfirmDelete-->
		
			<div class="modal fade delete-confirm" id="modalConfirmDelete" tabindex="-1"
				role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-sm modal-notify modal-danger"
					role="document">
					<!--Content-->
					<div class="modal-content text-center" style="height: 300px;">
						<!--Header-->
						<div class="modal-header d-flex justify-content-center">
							<p class="heading">Are you sure?</p>
						</div>

						<!--Body-->
						<div class="modal-body">

							<i class="fas fa-times fa-4x animated rotateIn"></i>

						</div>

						<!--Footer-->
						<form action="AdminDeleteServlet">
						<input type="text" id="eid" name="employee_id" hidden/>
						<div class="modal-footer flex-center"><button type="submit"
							  class="btn  btn-outline-danger" id="yes-button">Yes</button> <a
								type="button" class="btn  btn-danger waves-effect"
								data-dismiss="modal">No</a>
						</div>
						</form>
					</div>
					<!--/.Content-->
				</div>
			</div>
		
		<!--Modal: modalConfirmDelete-->


		<!-- Modal add user -->

		
			
	</section>
			
	

	<header>
		<nav class="navbar navbar-light white">
			<form class="form-inline">
				<button class="btn purple-gradient btn-rounded" type="button"
					data-toggle="modal" data-target="#modalRegisterForm1"  style="position: absolute; right: 140px;">Add Items</button>
					<button class="btn purple-gradient btn-rounded" type="button"
					data-toggle="modal" data-target="#modalRegisterForm" style="position: absolute; right: 300px;">Pending List</button>
				<a class="btn purple-gradient btn-rounded" type="button"
					 style="position: absolute; right: 0px;" href="login.html">LogOut</a>
				<!-- Just an image -->



				<a class="float-right nav-link"
					style=""> <img
					src="img/logo.png" height="50">
				</a> <a class="nav-link"  href="login.html" 
					style="color: #0b0e0e; font-weight: bold; border-bottom: 3px solid rgb(199, 20, 20); position: absolute; left: 250px;">HOME
				</a>
			</form>
		</nav>
	</header>


	<table id="dtVerticalScrollExample"
		class="table table-striped table-bordered table-md container"
		cellspacing="0" width="100%">

		<thead>
			<tr>
				<th class="th-sm"><b><u>ID</u></b></th>
				<th class="th-sm"><b><u>Name</u></b></th>
				<th class="th-sm"><b><u>Description</u></b></th>
			
				
			</tr>

		</thead>
		<%
			for (Items i : list1) {
		%>
		<tbody>
			<tr>

				<td><%=i.getItem_id()%></td>
				<td><%=i.getItem_name()%></td>
				<td><%=i.getItem_description()%></td>
              
				<%-- <td><button type="button"
						href='EditEmployee.jsp?employee_id=<%=i.getItem_id()%>'
						class="btn btn-outline-primary btn-sm m-0 waves-effect user-modify-btn"
						data-toggle="modal" data-target="#modalRegisterForm">Accept</button></td>
				<td><a type="button"
					class="btn btn-outline-primary btn-sm m-0 waves-effect delete-confirm-btn"
					data-toggle="modal" data-target="#modalConfirmDelete">Reject</a></td> --%>
			</tr>
			<%
				}
			%>
		</tbody>

	</table>
	<!-- Modal add user -->



	<!-- <! sign in!> -->







	<!-- Button trigger modal
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalConfirmDelete">Launch
    modal</button> -->

	<!--Modal: modalConfirmDelete-->


	<!--Modal: modalConfirmDelete-->


	<!-- Button trigger modal -->
</body>
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<!-- Bootstrap tooltips -->
<script type="text/javascript" src="js/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript" src="js/mdb.min.js"></script>



<script>
	// Material Select Initialization
	$(document).ready(function() {
		$('.mdb-select').materialSelect();
	});

	$(document).ready(function() {
		$('#dtDynamicVerticalScrollExample').DataTable({
			"scrollY" : "50vh",
			"scrollCollapse" : true,
		});
		$('.dataTables_length').addClass('bs-select');
	});

	//$('.dropdown-toggle').dropdown()

	$('.user-modify-btn').on('click', function() {
		$('#modify_user_modal').modal('show');
		$tr = $(this).closest("tr");
		var data = $tr.children("td").map(function() {
			return $(this).text();
		}).get();
		$('#Employee-edit-id').val(data[0]);
		$('#employee-edit-name').val(data[1]);
		$('#employee-edit-designation').val(data[2]);

	});
	
	
	$('.delete-confirm-btn').on('click', function() {
		$('#modalConfirmDelete').modal('show');
		$tr = $(this).closest("tr");
		var data = $tr.children("td").map(function() {
			return $(this).text();
		}).get();
		$('#eid').val(data[0]);
		

	});
</script>
</html>