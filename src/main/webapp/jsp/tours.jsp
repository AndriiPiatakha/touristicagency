<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<title>++ProTravel - ${user.mail}</title>
<head>
	<link rel="icon" href="${pageContext.servletContext.contextPath}/images/icon.gif" type="image/gif" sizes="16x16">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- Include Date Range Picker -->
    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/admin.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/admin.css"/>
    <link rel="stylesheet" type="text/css"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.css"/>
    <!-- DataTables CSS -->
    <link href="${pageContext.servletContext.contextPath}/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="${pageContext.servletContext.contextPath}/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">
    <link rel="stylesheet" href="../vendor/sb-admin-2.css">
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
							class="fa fa-user fa-fw"></i> Users</a></li>
					<li><a href="tours" class="active"><i class="fa fa-globe fa-fw"></i>
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
					<h3>Create Tour</h3>
					<form id="create-tour-form" method="post">
						<div class="form-group row">
							<label for="tour_name" class="col-sm-2 col-form-label">Name:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="tour_name"
									placeholder="Name" name="tour-name" required>
							</div>
						</div>
						<div class="form-group row">
							<label for="tour_description" class="col-sm-2 col-form-label">Description:</label>
							<div class="col-sm-10">
								<textarea rows="4" cols="50" class="col-sm-8" name="description"
									id="tour_description" form="create-tour-form"
									placeholder="Description" required></textarea>
							</div>
						</div>
						<div class="form-group row">
							<label for="tour_dates" class="col-sm-2 col-form-label">Dates:</label>
							<div class="col-sm-4" id="tour_dates">
								<div class="input-group input-daterange">
									<div class="input-group-addon">From</div>
									<input id="startDate" name="startDate" type="text"
										class="form-control" placeholder="mm/dd/yyyy" required />
									<div class="input-group-addon">to</div>
									<input id="endDate" name="endDate" type="text"
										class="form-control" placeholder="mm/dd/yyyy" required />
								</div>
							</div>
						</div>
						<div class="form-group row">
							<label for="tour_price" class="col-sm-2 col-form-label">Price:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="tour_price"
									placeholder="Price" name="tour-price" required>
							</div>
						</div>
							<div class="form-group row">
							<label for="tour_language" class="col-sm-2 col-form-label">Language:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="tour_language"
									placeholder="Language" name="tour-language" required>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-sm-10">
								<button type="submit" class="btn btn-primary pull-right">Create
									tour</button>
							</div>
						</div>
					</form>
				<div id="alert-area" style="height:60px;">
				
				</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">All Tours</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<table id="tours" class="table table-striped table-bordered"
							style="width: 100%">
							<thead>
								<tr>
									<th>Id</th>
									<th>Name</th>
									<th>Description</th>
									<th>Start</th>
									<th>End</th>
									<th>Price</th>
									<th>Language</th>
									<th>Details</th>
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
	
	<div class="modal fade" id="editTourModal" tabindex="-1" role="dialog" aria-labelledby="editTourModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h3 class="modal-title" id="editTourModalLabel">Edit Tour</h3>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        <form id="edit-tour-form">
	          <div class="form-group">
	            <label for="tour-name" class="col-form-label">Name:</label>
	            <input type="text" class="form-control" id="tour-name"  name="tour-name" required/>
	          </div>
	          <div class="form-group">
	            <label for="description-text" class="col-form-label">Description:</label>
	            <textarea class="form-control" id="description-text"  name="description" required></textarea>
	          </div>
	             <div class="form-group">
	               <label for="edit_tour_dates" class="col-form-label">Dates:</label>
	          		<div id="edit_tour_dates">
								<div class="input-group input-daterange">
									<div class="input-group-addon">From</div>
									<input id="startDate" name="startDate" type="text" class="form-control" placeholder="mm/dd/yyyy" required />
								<div class="input-group-addon">to</div>
							<input id="endDate" name="endDate" type="text" class="form-control" placeholder="mm/dd/yyyy" required />
						</div>
					</div>
				</div>
				<div class="form-group">
		            <label for="tour-price" class="col-form-label">Price:</label>
		            <input type="text" class="form-control" id="tour-price"  name="price" required/>
	          	</div>
	          	<div class="form-group">
		            <label for="tour-language" class="col-form-label">Language:</label>
		            <input type="text" class="form-control" id="tour-language" name="language" required/>
	          	</div>
	        </form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	        <button type="submit" form="edit-tour-form" class="btn btn-primary" id="update-tour-btn">Update</button>
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