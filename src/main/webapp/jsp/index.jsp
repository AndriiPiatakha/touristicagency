<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<title>++ProTravel - ${user.mail}</title>
<head>
      <meta charset="UTF-8">
      <title>++ProTravel</title>
      <link rel="icon" href="images/icon.gif" type="image/gif" sizes="16x16">
      <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
      <link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" />
      <!-- Include Date Range Picker -->
      <script type="text/javascript"
         src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
      <link rel="stylesheet"
         href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css" />
      <link rel="stylesheet"
         href="https://formden.com/static/cdn/font-awesome/4.4.0/css/font-awesome.min.css" />
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
      <link href="css/index.css" rel="stylesheet">
      <link href="css/signup.css" rel="stylesheet">
      <link href="css/login.css" rel="stylesheet">
      <script src="js/script.js" type="text/javascript"></script>
</head>
<body>
 <div class="container-fluid no-padding">
         <div class="row">
            <div class="col-md-12" style="padding-left: 0px;  padding-right: 0px;">
               <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                  <ol class="carousel-indicators">
                     <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                     <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                     <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                  </ol>
                  <div class="carousel-inner">
                     <div class="item active">
                        <img src="images/slide1.jpg"  class="img-fluid">
                     </div>
                     <div class="item">
                        <img src="images/slide2.jpg" class="img-fluid">
                     </div>
                     <div class="item">
                        <img src="images/slide3.jpg"  class="img-fluid">
                     </div>
                  </div>
                  <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                  <span class="glyphicon glyphicon-chevron-left"></span></a><a class="right carousel-control"
                     href="#carousel-example-generic" data-slide="next"><span class="glyphicon glyphicon-chevron-right">
                  </span></a>
               </div>
               <div class="main-text hidden-xs">
                  <div class="col-md-12 text-center">
                     <h1>Welcome to the ++ProTravel</h1>
                     <h2 class="quote">To Travel is To Live</h2>
                     <div class="login-menu">
                        <a class="btn btn-clear btn-sm btn-min-block" id="login-btn" onclick="document.getElementById('id01').style.display='block'">Login</a>
                        <!-- -->
                        <div id="id01" class="modal" style="display:<c:out value="${displayLogin}"/>">
                           <form class="modal-content animate" action="${pageContext.request.contextPath}/login" id="login-id" method="post">
                              <div class="container">
                                 <label for="l-username"><b>Username</b></label>
                                 <input type="text" id="l-username" placeholder="Enter Username" name="username" required>
                                 <label for="l-password"><b>Password</b></label>
                                 <input type="password" id="l-password" placeholder="Enter Password" name="password" required>
                                 <button type="submit">Login</button>
                                 <label>
                                 <input type="checkbox" checked="checked" name="remember"> Remember me
                                 </label>
                              </div>
                              <div class="container" style="background-color:#f1f1f1">
                                 <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
                                 	<c:if test="${not empty errorMessage}">
											<c:out value="${errorMessage}"/>
									</c:if>
                                 <span class="psw">Forgot <a href="#">password?</a></span>
                              </div>
                           </form>
                        </div>
                        <!-- -->
                        <a class="btn btn-clear btn-sm btn-min-block" id="sign-up" onclick="document.getElementById('id02').style.display='block'">Sign up</a>
                     </div>
                     <div id="id02" class="modal">
                        <span onclick="document.getElementById('id02').style.display='none'" class="close" title="Close Modal">&times;</span>
                        <form class="modal-content animate" action="signing"  method="post" id="signup">
                           <div class="container">
                              <h1>Sign Up</h1>
                              <p>Please fill in this form to create an account.</p>
                              <div class="form-group">
                                 <label for="username-signup"><span class="asteriskField">
                                 * </span>Name:</label> <input type="text" name="username" class="form-control"
                                    id=username-signup placeholder="Username" required>
                              </div>
                              <div class="form-group">
                                 <label for="inputEmail-signup"><span class="asteriskField">
                                 * </span>Email:</label> <input type="email" name="mail" class="form-control"
                                    id="inputEmail-signup" placeholder="Email" required>
                              </div>
                              <div class="form-group">
                                 <label for="inputPassword-signup"><span class="asteriskField">
                                 * </span>Password:</label> <input type="password" name="password"
                                    class="form-control" id="inputPassword-signup" placeholder="Password"
                                    required>
                              </div>
                              <div class="form-group confirm-password">
                                 <label for="repeatPassword-signup"><span class="asteriskField">
                                 * </span>Repeat Password:</label> <input type="password" name="repeat_password"
                                    class="form-control" id="repeatPassword-signup" placeholder="Repeat Password"
                                    required>
                              </div>
                              <div class="form-group">
                                 <label for="birthday-signup" class="control-label requiredField">
                                 <span class="asteriskField"> * </span>Birthday:
                                 </label>
                                 <div class="input-group">
                                    <div class="input-group-addon">
                                       <i class="fa fa-calendar"> </i>
                                    </div>
                                    <input class="form-control" id="birthday-signup" name="birthday"
                                       placeholder="MM/DD/YYYY" type="text" />
                                 </div>
                              </div>
                              <label>
                              <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
                              </label>
                              <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>
                              <div class="clearfix">
                                 <button type="button" onclick="document.getElementById('id02').style.display='none'" class="cancelbtn">Cancel</button>
                                 <button type="submit" class="signupbtn">Sign Up</button>
                              </div>
                           </div>
                        </form>
                     </div>
                  </div>
               </div>
            </div>
         </div>
         <div id="push">
         </div>
      </div>
</body>
</html>