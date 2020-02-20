<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<title>++ProTravel - ${user.mail}</title>
<head>
    <link rel="icon" href="images/icon.gif" type="image/gif" sizes="16x16">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src=" https://cdnjs.cloudflare.com/ajax/libs/ekko-lightbox/5.3.0/ekko-lightbox.min.js"></script>

    <script src="${pageContext.servletContext.contextPath}/js/userprofile.js" type="text/javascript"></script>
    <link rel="stylesheet" href="css/userdashboard.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="css/profile.css" rel="stylesheet">
	<!-- DataTables Responsive CSS -->
	<link href="${pageContext.servletContext.contextPath}/vendor/datatables-responsive/dataTables.responsive.css"
		rel="stylesheet">
	<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/vendor/sb-admin-2.css">
    <!-- Include Date Picker -->
    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css" />
    <script src="js/script.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ekko-lightbox/5.3.0/ekko-lightbox.css">
    <style>
        .card{
            height: 170px;
            float: right;
            position: relative;
            border: #d9d9d9 solid 1px;
            -moz-border-radius-topright:10px;
            -moz-border-radius-topleft:10px;
            -webkit-border-top-right-radius:10px;
            -webkit-border-top-left-radius:10px;
            border-top-left-radius:10px;
            border-top-right-radius:10px;
        }

        .borderless td, .borderless th {
            border: none;
            border-top: 0px !important;
        }
        .menu{

            width: 50%;
            display:inline-block;
        }
        .list-group-item{
            height: 70px;
            font-size: 1.5em;
        }
        .personal-info{

        }
        </style>
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
</nav>
<!-- Page content -->
<div class="user-content" style="min-height: 200px;">
    <div class="container">
        <h2>${user.username} account</h2>
    <br>
            <div class="list-group menu">
                <button class="list-group-item list-group-item-action" id="search-tours"><i class="fa fa-globe"></i> Tours</button>
                <button class="list-group-item list-group-item-action" id="search-flights"><i class="fa fa-plane"></i> Flights</button>
                <button class="list-group-item list-group-item-action" id="search-bookings"><i class="fa fa-building"></i> Bookings</button>
            </div>
            <div class="personal-info">
                <h3>Personal Information</h3>
                <table class="table borderless border-0">
                    <tbody class="col-md-2">
                    <tr>
                        <th scope="row">Name:</th>
                        <td >${user.username}</td>
                        <td>
                            <button type="button" class="btn btn-info" data-toggle="modal" data-target="#edit-name">
                                <span class="glyphicon glyphicon-pencil"></span> Edit
                            </button>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">E-mail:</th>
                        <td  >${user.mail}</td>
                        <td>
                            <button type="button" class="btn btn-info" data-toggle="modal" data-target="#edit-mail">
                                <span class="glyphicon glyphicon-pencil"></span> Edit
                            </button>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">Birthday:</th>
                        <td >${user.birthday}</td>
                        <td>
                            <button type="button" class="btn btn-info" data-toggle="modal" data-target="#edit-birthday">
                                <span class="glyphicon glyphicon-pencil"></span> Edit
                            </button>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <button type="button" class="btn btn-success btn-l" data-toggle="modal" data-target="#edit-password">
                    <span class="glyphicon glyphicon-lock"></span> Change Password
                </button>
                <div class="modal fade modal-info" id="edit-name" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered" role="document">
                        <div class="modal-content">
                            <div class="modal-body">
                                <form class="" action="profile/edit/password  method="post" id="f_n_edit">
                                    <div class="container">
                                        <div class="form-group"><label for="username-edit"><span class="asteriskField">
                                 </span>Name:</label> <input type="text" name="username" class="form-control" id=username-edit placeholder="Username" required>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary cancelbtn" data-dismiss="modal">Close</button>
                                <button class="btn btn-primary" type="submit" form="f_n_edit">Save changes</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Modal -->
                <div class="modal fade modal-info" id="edit-mail" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered" role="document">
                        <div class="modal-content">

                            <div class="modal-body">
                                <form class="" action="profile/edit/email" method="post" id="f_m_edit">
                                    <div class="container">
                                        <div class="form-group"><label for="mail-edit"><span class="asteriskField">
                                 </span>E-Mail:</label> <input type="text" name="mail" class="form-control" id=mail-edit placeholder="e-mail" required>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary cancelbtn" data-dismiss="modal">Close</button>
                                <button class="btn btn-primary"  type="submit" form="f_m_edit">Save changes</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Modal -->
                <div class="modal fade modal-info" id="edit-birthday" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered" role="document">
                        <div class="modal-content">
                            <div class="modal-body">
                                <form class="" action="profile/edit/birthday" method="post" id="f_b_edit">
                                    <div class="container">
                                        <label for="birthday-edit" class="control-label requiredField"><span class="asteriskField"></span>Birthday:</label>
                                        <div class="form-group">
                                             <div class="input-group">
                                                <div class="input-group-addon">
                                                <i class="fa fa-calendar"> </i>
                                                </div>
                                         <input class="form-control" id="birthday-edit" name="birthday" placeholder="MM/DD/YYYY" type="text" />
                                        </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary cancelbtn" data-dismiss="modal">Close</button>
                                <button class="btn btn-primary" type="submit" form="f_b_edit">Save changes</button>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
        <div class="modal fade modal-info" id="edit-password" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-body">
                        <form class="" action="profile/edit/password" method="post" id="f_p_edit">
                            <div class="container">
                                <div class="form-group">
                                    <label for="old-password"><span class="asteriskField">
                                  </span>Old password:</label> <input type="password" name="password"
                                                                  class="form-control" id="old-password" placeholder="Old password"
                                                                  required>
                                </div>
                                <div class="form-group">
                                    <label for="new-password"><span class="asteriskField">
                                  </span>New password:</label> <input type="password" name="password"
                                                                   class="form-control" id="new-password" placeholder="Password"
                                                                   required>
                                </div>
                                <div class="form-group confirm-password">
                                    <label for="repeat-password"><span class="asteriskField">
                                 * </span>Repeat new password:</label> <input type="password" name="repeat_password"
                                                                          class="form-control" id="repeat-password" placeholder="Repeat password"
                                                                          required>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary cancelbtn" data-dismiss="modal">Close</button>
                        <button class="btn btn-primary" type="submit" form="f_b_edit">Save changes</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- Tours Modal -->
        <div class="modal fade" id="tours-modal" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Search Result:</h4>
                    </div>
                    <div class="modal-body">
                        <table id="tours" class="table table-striped table-bordered" style="width:100%">
                            <thead>
                            <tr>
                            	<th>Order Id</th>
                                <th>Tour Name</th>
                                 <th></th>
                            </tr>
                            </thead>
                        </table>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default"
                                data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- Modal -->
        <div class="modal fade" id="flights-modal" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Search Result:</h4>
                    </div>
                    <div class="modal-body">
                        <table width="100%"
                               class="table table-striped table-bordered table-hover"
                               id="flights">
                            <thead>
                            <tr>
                            	<th>Order Id</th>
                                <th>Flight</th>
                                <th></th>
                            </tr>
                            </thead>
                        </table>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default"
                                data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
              <!-- Modal -->
        <div class="modal fade" id="bookings-modal" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Search Result:</h4>
                    </div>
                    <div class="modal-body">
                        <table width="100%"
                               class="table table-striped table-bordered table-hover"
                               id="bookings">
                            <thead>
                            <tr>
                              	<th>My bookings</th>
                              	<th>Hotel</th>
                              	 <th>Check-in</th>
                              	 <th>Check-out</th>
                              	 <th>Price</th>
                              	 <th></th>
                            </tr>
                            </thead>
                        </table>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default"
                                data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
</div>
<!-- Footer -->
<footer class="user-container user-center user-margin-top">
    <h3>Enjoy ${tour.name} sights</h3>
        <div class="col">
            <a href="https://unsplash.it/1200/768.jpg?image=251" data-toggle="lightbox" data-gallery="example-gallery" class="">
                <img src="https://unsplash.it/600.jpg?image=251" class="col-sm-2">
            </a>
        </div>
        <div class="col">
            <a href="https://unsplash.it/1200/768.jpg?image=252" data-toggle="lightbox" data-gallery="example-gallery" class="-2">
                <img src="https://unsplash.it/600.jpg?image=252" class="col-sm-2">
            </a>
        </div>
        <div class="col">
            <a href="https://unsplash.it/1200/768.jpg?image=253" data-toggle="lightbox" data-gallery="example-gallery" class="">
                <img src="https://unsplash.it/600.jpg?image=253" class="col-sm-2">
            </a>
        </div>
        <div class="col">
            <a href="https://unsplash.it/1200/768.jpg?image=254" data-toggle="lightbox" data-gallery="example-gallery" class="">
                <img src="https://unsplash.it/600.jpg?image=254" class="col-sm-2">
            </a>
        </div>
        <div class="col">
            <a href="https://unsplash.it/1200/768.jpg?image=255" data-toggle="lightbox" data-gallery="example-gallery" class="">
                <img src="https://unsplash.it/600.jpg?image=255" class="col-sm-2">
            </a>
        </div>
        <div class="col">
            <a href="https://unsplash.it/1200/768.jpg?image=256" data-toggle="lightbox" data-gallery="example-gallery" class="">
                <img src="https://unsplash.it/600.jpg?image=256" class="col-sm-2">
            </a>
        </div>
    </footer>
    
	<!-- DataTables JavaScript -->
	<script src="${pageContext.servletContext.contextPath}/vendor/datatables/js/jquery.dataTables.min.js"></script>
	<script src="${pageContext.servletContext.contextPath}/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
	<script src="${pageContext.servletContext.contextPath}/vendor/datatables-responsive/dataTables.responsive.js"></script>
</body>
<script>
    $(document).on('click', '[data-toggle="lightbox"]', function(event) {
        event.preventDefault();
        $(this).ekkoLightbox();
    });
    </script>
</body>
</html>
