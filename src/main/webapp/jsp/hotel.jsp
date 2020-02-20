<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<title>++ProTravel - ${user.mail}</title>
<head>
<link rel="icon" href="${pageContext.servletContext.contextPath}/images/icon.gif" type="image/gif" sizes="16x16">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="${pageContext.servletContext.contextPath}/js/hotels.js"></script>

<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/userdashboard.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src=" https://cdnjs.cloudflare.com/ajax/libs/ekko-lightbox/5.3.0/ekko-lightbox.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ekko-lightbox/5.3.0/ekko-lightbox.css">
<style>
.card {
	height: 170px;
	float: right;
	position: relative;
	border: #d9d9d9 solid 1px;
	-moz-border-radius-topright: 10px;
	-moz-border-radius-topleft: 10px;
	-webkit-border-top-right-radius: 10px;
	-webkit-border-top-left-radius: 10px;
	border-top-left-radius: 10px;
	border-top-right-radius: 10px;
}

.card-header {
	font-size: 1.2em;
	color: #FFF;
	background: #293b66;
	padding: 10px;
}

.card-body {
	padding: 5px;
}

.card-btn {
	position: absolute;
	bottom: 15px;
	width: 90%;
}

.description {
	max-width: 80%;
	display: inline-block;
}

.borderless td, .borderless th {
	border: none;
	border-top: 0px !important;
}

.borderless {
	width: 20%;
}
</style>
<!-- DatePicker CSS -->
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/bootstrap-datepicker3.min.css">
<script src="${pageContext.servletContext.contextPath}/js/bootstrap-datepicker.min.js"></script>
</head>
<body class="user-light-grey">
	<nav class="navbar navbar-default navbar-static-top">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${pageContext.servletContext.contextPath}/dashboard">++ProTravel</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav navbar-right">
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
			</div>
		</div>
		<!-- /.navbar-collapse -->
	</nav>
	<!-- Header -->
	<!-- Page content -->
	<div class="user-content" style="min-height: 200px;">
		<div class="container">
			<h2>Visit the ${hotel.name}</h2>
			<div class="card">
				<div class="card-header">Book Now:</div>
				<div class="card-body">
					<h5 class="card-title">Only From:</h5>
					<p id="suite_price">${hotel.suitePrice}</p>
					<a href="${pageContext.servletContext.contextPath}/dashboard/book/hotel?id=${hotel.hotelId}&user=${user.id}&suite-price=${hotel.suitePrice}" class="card-btn btn btn-primary" id="booking-btn">Book</a>
				</div>
			</div>
			<div class="details">
				<hr>
				<table class="table borderless border-0">

					<tbody>
						<tr>
							<th scope="row">City</th>
							<td>${hotel.city}</td>
						</tr>
						<tr>
							<th scope="row">Address</th>
							<td>${hotel.address}</td>
						</tr>
						<tr>
					</tbody>
				</table>
				<hr>
			</div>
		</div>
	</div>
<div class="container">
  <h2>Reservation form</h2>
  <form id="reservation-form">
    <div class="form-group">
      <label for="staying">Staying:</label>
 		<div class="input-group input-daterange" id="staying">
			<div class="input-group-addon">From</div>
				<input id="startDate" name="startDate" type="text" class="form-control" placeholder="mm/dd/yyyy" required />
						<div class="input-group-addon">to</div>
				<input id="endDate" name="endDate" type="text" class="form-control" placeholder="mm/dd/yyyy" required />
		</div>	
    </div>
    <div class="form-group">
      <label for="nights">Nights:</label>
      <input type="number" class="form-control" id="nights" value="1" placeholder="Nights" name="nights">
       </div>
      <div class="form-group">
      <label for="nights">Price:</label>
      <input type="number" class="form-control" id="price" value="${hotel.suitePrice}" name="price" readonly>
    </div>
  </form>
</div>
	<div id="alert-area" style="height:60px;">
				
	</div>
	<!-- Footer -->
	<footer class="user-container user-center user-margin-top">
		<h3 align="center">Enjoy your staying at ${hotel.name} !</h3>
		<br>
		<div class="col">
			<a
				href="https://images.pexels.com/photos/271624/pexels-photo-271624.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
				data-toggle="lightbox" data-gallery="example-gallery" class="">
				<img
				src="https://images.pexels.com/photos/271624/pexels-photo-271624.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
				class="col-sm-2">
			</a>
		</div>
		<div class="col">
			<a
				href="https://images.pexels.com/photos/280121/pexels-photo-280121.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
				data-toggle="lightbox" data-gallery="example-gallery" class="-2">
				<img
				src="https://images.pexels.com/photos/280121/pexels-photo-280121.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
				class="col-sm-2">
			</a>
		</div>
		<div class="col">
			<a
				href="https://images.pexels.com/photos/332090/pexels-photo-332090.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
				data-toggle="lightbox" data-gallery="example-gallery" class="">
				<img
				src="https://images.pexels.com/photos/332090/pexels-photo-332090.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
				class="col-sm-2">
			</a>
		</div>
		<div class="col">
			<a
				href="https://images.pexels.com/photos/34650/pexels-photo.jpg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
				data-toggle="lightbox" data-gallery="example-gallery" class="">
				<img
				src="https://images.pexels.com/photos/34650/pexels-photo.jpg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
				class="col-sm-2">
			</a>
		</div>
		<div class="col">
			<a
				href="https://images.pexels.com/photos/635041/pexels-photo-635041.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
				data-toggle="lightbox" data-gallery="example-gallery" class="">
				<img
				src="https://images.pexels.com/photos/635041/pexels-photo-635041.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
				class="col-sm-2">
			</a>
		</div>
		<div class="col">
			<a
				href="https://images.pexels.com/photos/269676/pexels-photo-269676.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
				data-toggle="lightbox" data-gallery="example-gallery" class="">
				<img
				src="https://images.pexels.com/photos/269676/pexels-photo-269676.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
				class="col-sm-2">
			</a>
		</div>
	</footer>
	<script>
		$(document).on('click', '[data-toggle="lightbox"]', function(event) {
			event.preventDefault();
			$(this).ekkoLightbox();
		});
	</script>
</body>
</html>