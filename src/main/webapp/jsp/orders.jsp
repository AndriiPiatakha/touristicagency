<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<title>++ProTravel - ${user.mail}</title>
<head>
<link rel="icon" href="${pageContext.servletContext.contextPath}/images/icon.gif" type="image/gif"
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
<script type="text/javascript" src="../js/orders.js"></script>
<link rel="stylesheet" type="text/css" href="../css/admin.css" />
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.css" />
<!-- DataTables CSS -->
<link href="${pageContext.servletContext.contextPath}/vendor/datatables-plugins/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link href="${pageContext.servletContext.contextPath}/vendor/datatables-responsive/dataTables.responsive.css"
	rel="stylesheet">
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/vendor/sb-admin-2.css">
<!-- DatePicker CSS -->
<link rel="stylesheet" href="../css/bootstrap-datepicker3.min.css">
<script src="${pageContext.servletContext.contextPath}/js/bootstrap-datepicker.min.js"></script>
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
					<li><a href="users"><i
							class="fa fa-user fa-fw"></i>Users</a></li>
					<li><a href="tours"><i class="fa fa-globe fa-fw"></i>
							Tours</a></li>
					<li><a href="orders" class="active"><i class="fa fa-shopping-cart fa-fw"></i>
							Orders</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div id="page-wrapper">
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">All Orders</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<table id="orders" class="table table-striped table-bordered"
							style="width: 100%">
							<thead>
								<tr>
									<th>Order Id</th>
									<th>User</th>
									<th>Tour Name</th>
									<th>Tour Price</th>
									<th>Flight</th>
									<th>Flight Price</th>
									<th>Hotel</th>
									<th>Hotel Price</th>
									<th>Rental</th>
									<th>Rental Price</th>
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

	<!-- DataTables JavaScript -->
	<script src="${pageContext.servletContext.contextPath}/vendor/datatables/js/jquery.dataTables.min.js"></script>
	<script src="${pageContext.servletContext.contextPath}/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
	<script src="${pageContext.servletContext.contextPath}/vendor/datatables-responsive/dataTables.responsive.js"></script>
</body>
</html>