<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
   <title>++ProTravel - ${user.mail}</title>
   <head>
   		<link rel="icon" href="images/icon.gif" type="image/gif" sizes="16x16">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
      <link rel="stylesheet" href="css/userdashboard.css">
      <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
      <link rel="stylesheet"
         href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
      <style>
         body, h1, h2, h3, h4, h5, h6 {
         font-family: "Helvetica Neue",Helvetica,Arial,sans-serif;
         }
         #contacts-form {
         margin-top: 3vh;
         }
         #contacts {
         max-width: 45vh;
         margin-left: 5vh;
         margin-top: 3%;
         }
         #newsletter{
         max-width: 80%;
         margin-left: 5vh;
         }
      </style>
   </head>
   <body class="user-light-grey">
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.servletContext.contextPath}/dashboard">++ProTravel</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
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
        </div><!-- /.navbar-collapse -->
</nav>
      <div class="user-container" id="contacts">
         <h2>Contacts</h2>
         <p>Let us book your next trip!</p>
         <i class="fa fa-map-marker" style="width:30px"></i> Chicago, US<br>
         <i class="fa fa-phone" style="width:30px"></i> Phone: +00 151515<br>
         <i class="fa fa-envelope" style="width:30px"> </i> Email: mail@mail.com<br>
         <form action="/action_page.php" target="_blank" id="contacts-form">
            <p><input class="user-input user-padding-16 user-border" type="text" placeholder="Name" required
               name="Name"></p>
            <p><input class="user-input user-padding-16 user-border" type="text" placeholder="Email" required
               name="Email"></p>
            <p><input class="user-input user-padding-16 user-border" type="text" placeholder="Message" required
               name="Message"></p>
            <p>
               <button class="user-button user-black user-padding-large" type="submit">SEND MESSAGE</button>
            </p>
         </form>
      </div>
      <!-- End page content -->
      </div>
      <!-- Newsletter -->
      <div class="user-container" id="newsletter">
         <div class="user-panel user-padding-16 user-black user-opacity user-card user-hover-opacity-off">
            <h2>Get the best offers first!</h2>
            <p>Join our newsletter.</p>
            <label>E-mail</label>
            <input class="user-input user-border" type="text" placeholder="Your Email address">
            <button type="button" class="user-button user-red user-margin-top">Subscribe</button>
         </div>
      </div>
      <!-- End page content -->
      </div>
      <!-- Footer -->
      <footer class="user-container user-center user-opacity user-margin-bottom">
      </footer>
   </body>
</html>