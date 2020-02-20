<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<title>++ProTravel - ${user.mail}</title>
<head>
<link rel="icon" href="../images/icon.gif" type="image/gif"
	sizes="16x16">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Include Date Range Picker -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/users.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/admin.css" />
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.css" />
<!-- DataTables CSS -->
<link href="../vendor/datatables-plugins/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link href="../vendor/datatables-responsive/dataTables.responsive.css"
	rel="stylesheet">
<link rel="stylesheet" href="../vendor/sb-admin-2.css">
<!-- DatePicker CSS -->
<link rel="stylesheet" href="../css/bootstrap-datepicker3.min.css">
<script src="../js/bootstrap-datepicker.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-default navbar-static-top" role="navigation"
		style="margin-bottom: 0">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${pageContext.servletContext.contextPath}/dashboard">++ProTravel</a>
		</div>
		<!-- /.navbar-header -->
				<ul class="nav navbar-top-links navbar-right">
					<c:if test="${user.role == 1 || user.role == 0}">
						<li><a href="${pageContext.servletContext.contextPath}/adminpanel" aria-haspopup="true"
							aria-expanded="false"><i class="fa fa-dashboard fa-fw"></i>
								Site Administration</a></li>
					</c:if>
					<li><a href="${pageContext.servletContext.contextPath}/contacts" aria-haspopup="true"
						aria-expanded="false"><i class="fa fa-envelope fa-fw"></i>
							Contact us</a></li>
					<c:if test="${not empty user.username}">
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">Welcome, ${user.username} <i
								class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
						</a>
							<ul class="dropdown-menu dropdown-user">
								<li><a href="${pageContext.servletContext.contextPath}/profile"><i class="fa fa-user fa-fw"></i> User
										Profile</a></li>
								<li class="divider"></li>
								<li><a href="${pageContext.servletContext.contextPath}/logout"><i class="fa fa-sign-out fa-fw"></i>
										Logout</a></li>
							</ul></li>
					</c:if>
				</ul>
		<!-- /.navbar-top-links -->
		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav in" id="side-menu">
					<li class="sidebar-search">
						<div class="input-group custom-search-form">
							<input type="text" class="form-control" placeholder="Search...">
							<span class="input-group-btn">
								<button class="btn btn-default" type="button">
									<i class="fa fa-search"></i>
								</button>
							</span>
						</div>
					</li>
					<li><a href="users" class="active"><i
							class="fa fa-user fa-fw"></i>Users</a></li>
					<li><a href="tours"><i class="fa fa-globe fa-fw"></i>
							Tours</a></li>
					<li><a href="orders"><i class="fa fa-shopping-cart fa-fw"></i>
							Orders</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div id="page-wrapper">
		<div class="row">
			<div class="col-lg-12">
				<div>
					<h3>Add a new user</h3>
					<form id="create-user-form" method="post">
						<div class="form-group row">
							<label for="user_name" class="col-sm-2 col-form-label">Name:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="user_name"
									placeholder="Name" name="user-name" required>
							</div>
						</div>
						<div class="form-group row">
							<label for="user_mail" class="col-sm-2 col-form-label">E-mail</label>
							<div class="col-sm-4">
								<input type="email" class="form-control" id="user_mail"
									placeholder="E-mail" name="user-mail" required>
							</div>
						</div>
						<div class="form-group row">
							<label for="birthday" class="col-sm-2 col-form-label">Birthday:</label>
							<div class="col-sm-4">
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-calendar"> </i>
									</div>
									<input id="birthday" name="user-birthday" type="text"
										class="form-control" placeholder="mm/dd/yyyy" required />
								</div>
							</div>
						</div>
						<div class="form-group row">
							<label for="user_role_id" class="col-sm-2 col-form-label">Role
								Id:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="user_role_id"
									placeholder="Role id" name="user-role-id" required>
							</div>
						</div>
						<div class="form-group row">
							<label for="password" class="col-sm-2 col-form-label">Password:</label>
							<div class="col-sm-4">
								<input type="password" name="password" class="form-control"
									id="password" placeholder="Password" required>
							</div>
						</div>
						<div class="form-group row">
							<label for="repeat_password" class="col-sm-2 col-form-label">Repeat
								password:</label>
							<div class="col-sm-4">
								<input type="password" name="repeat_password"
									class="form-control confirm-password" id="repeat-password"
									placeholder="Repeat Password" required>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-sm-10">
								<button type="submit" class="btn btn-primary pull-right">Add
									user</button>
							</div>
						</div>
					</form>
					<div id="alert-area" style="height: 60px;"></div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">All Tours</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<table id="users" class="table table-striped table-bordered"
							style="width: 100%">
							<thead>
								<tr>
									<th>Id</th>
									<th>Name</th>
									<th>Password</th>
									<th>Mail</th>
									<th>Birthday</th>
									<th>Role Id</th>
									<th>Edit</th>
									<th>Delete</th>
								</tr>
							</thead>
						</table>
					</div>
					<!-- /.panel-body -->
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="editUserModal" tabindex="-1" role="dialog"
		aria-labelledby="editUserModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h3 class="modal-title" id="editUserModalLabel">Edit User</h3>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form id="edit-user-form" method="post">
						<div class="form-group">
							<label for="user-name" class="col-form-label">Name:</label> <input
								type="text" class="form-control" id="user-name" name="user-name"
								required />
						</div>
						<div class="form-group">
							<label for="edit_user_mail" class="col-form-label">E-mail</label>
							<input type="email" class="form-control" id="edit_user_mail"
								placeholder="E-mail" name="user-mail" required>
						</div>
						<div class="form-group">
							<label for="edit-birthday" class="col-form-label">Birthday:</label>
							<div id="edit_birthday_date">
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-calendar"> </i>
									</div>
									<input id="edit-birthday" name="user-birthday" type="text"
										class="form-control" placeholder="mm/dd/yyyy" required />
								</div>
							</div>
						</div>
							<div class="form-group">
							<label for="role-id" class="col-form-label">Role Id:</label> <input
								type="text" class="form-control" id="role-id" name="user-role-id"
								required />
						</div>
						
							<div class="form-group">
							<label for="edit_password" class="col-form-label">Password:</label> <input
								type="password" class="form-control" id="edit_password" name="password"
								required />
						</div>
							<div class="form-group">
							<label for="edit_repeat_password" class="col-form-label">Repeat
								password:</label> <input
								type="password" class="form-control confirm-password" id="edit_repeat_password" name="repeat-password"
								required />
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="submit" form="edit-user-form" class="btn btn-primary"
						id="update-user-btn">Update</button>
				</div>
			</div>
		</div>
	</div>
	<!-- DataTables JavaScript -->
	<script src="../vendor/datatables/js/jquery.dataTables.min.js"></script>
	<script src="../vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
	<script src="../vendor/datatables-responsive/dataTables.responsive.js"></script>
</body>
</html>