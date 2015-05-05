<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>SnippetShare</title>
    <meta name="description" content="This one page example has a fixed navbar and full page height sections. Each section is vertically centered on larger screens, and then stack responsively on smaller screens. Scrollspy is used to activate the current menu item. This layout also has a contact form example. Uses animate.css, FontAwesome, Google Fonts (Lato and Bitter) and Bootstrap." />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="generator" content="Codeply">



    <link rel="stylesheet" href="assets/css/bootstrap.min.css" />
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" />
    <link href="http://cdnjs.cloudflare.com/ajax/libs/animate.css/3.1.1/animate.min.css" rel="stylesheet" />

    <link rel="stylesheet" href="assets/css/styles.css" />
  </head>
  <body >
    <nav class="navbar navbar-trans navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapsible">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand text-danger" href="http://arboreal-harbor-92603.appspot.com/">SnippetShare</a>
        </div>
        <div class="navbar-collapse collapse" id="navbar-collapsible">
            <ul class="nav navbar-nav navbar-left">
                <li><a href="#section1">Home</a></li>
                <li><a href="#section2">About</a></li>
                <li>&nbsp;</li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#" data-toggle="modal" data-target="#myModal"><i class="fa fa-heart-o fa-lg"></i></a></li>
            </ul>
        </div>
    </div>
</nav>

<section class="container-fluid" id="section1">
    <div class="v-center">
        <h1 class="text-center">Share your idea</h1>
        <h2 class="text-center lato animate slideInDown">Say <b>Something</b> Unique</h2>
        <p class="text-center">
            <br>
            <a href="#" class="btn btn-success btn-lg btn-huge lato" data-toggle="modal" data-target="#myModal">Log In</a>
            <a href="#" class="btn btn-danger btn-lg btn-huge lato" data-toggle="modal" data-target="#yourModal">Sigh Up</a>
        </p>
    </div>
    <a href="#section2">
		<div class="scroll-down bounceInDown animated">
            <span>
                <i class="fa fa-angle-down fa-2x"></i>
            </span>
		</div>
        </a>
</section>

<section class="container-fluid" id="section2">
    <div class="container">
        <div class="row">
            <div class="col-sm-4">
                <div class="row">
                    <div class="col-sm-12 text-center">
                        <div class="panel panel-default slideInLeft animate">
                            <div class="panel-heading"><h3>Easy</h3></div>
                            <div class="panel-body">
                                <p>The easiest way to share your everything with your friends and family.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-4 text-center">
                <div class="row">
                    <div class="col-sm-12 text-center">
                        <div class="panel panel-default slideInUp animate">
                            <div class="panel-heading">
                            <h3>Private</h3></div>
                            <div class="panel-body">
                                <p>A private group designed just for you and your close friends.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-4 text-center">
                <div class="row">
                    <div class="col-sm-12 text-center">
                        <div class="panel panel-default slideInRight animate">
                            <div class="panel-heading">
                            <h3>Proven</h3></div>
                            <div class="panel-body">
                                <p>About 4 people across the U.S. rely on SnippetShare.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--/row-->

        <div class="text-center"><h2>Team</h2></div>
        <br>

        <div class="row">
            <div class="col-sm-2 col-sm-offset-2 col-xs-6">
                <div class="text-center">
                    <a href="">
                        <img style="width:100px;" class="img-circle img-responsive img-thumbnail" src="assets/images/wf.jpg">
                    </a>
                    <h3 class="text-center"></h3>
                </div>
            </div>
            <div class="col-sm-2 col-xs-6">
                <div class="text-center">
                    <a href="">
                        <img style="width:100px;" class="img-circle img-responsive img-thumbnail" src="assets/images/lj.jpg">
                    </a>
                    <h3 class="text-center"></h3>
                </div>
            </div>
            <div class="col-sm-2 col-xs-6">
                <div class="text-center">
                    <a href="">
                        <img style="width:100px;" class="img-circle img-responsive img-thumbnail" src="assets/images/sw.jpg">
                    </a>
                    <h3 class="text-center"></h3>
                </div>
            </div>
            <div class="col-sm-2 col-xs-6">
                <div class="text-center">
                    <a href="">
                        <img style="width:100px;" class="img-circle img-responsive img-thumbnail" src="assets/images/xm.jpg">
                    </a>
                    <h3 class="text-center"></h3>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-2 col-sm-offset-2 col-xs-6">
                <div class="text-center">
                    <h3 class="text-center">Wu Fei</h3>
                    <p>Leader</p>
                    <p>ID: 010053004</p>
                </div>
            </div>
            <div class="col-sm-2 col-xs-6">
                <div class="text-center">
                    <h3 class="text-center">Lei JIe</h3>
                    <p>Member</p>
                    <p>ID: 009340253</p>
                </div>
            </div>
            <div class="col-sm-2 col-xs-6">
                <div class="text-center">
                    <h3 class="text-center">Sun Wei</h3>
                    <p>Member</p>
                    <p>ID: 009988121</p>
                </div>
            </div>
            <div class="col-sm-2 col-xs-6">
                <div class="text-center">
                    <h3 class="text-center">Xiaomeng Yi</h3>
                    <p>Member</p>
                    <p>ID: 009411402</p>
                </div>
            </div>
        </div>
        <!--/row-->
    </div>
    <!--/container-->
</section>

<section class="container-fluid" id="section7">
    <div class="row">
        <!--fontawesome icons-->
        <div class="col-sm-1 col-sm-offset-3 col-xs-4 text-center">
            <i class="fa fa-github fa-4x"></i>
        </div>
        <div class="col-sm-1 col-xs-4 text-center">
            <i class="fa fa-foursquare fa-4x"></i>
        </div>
        <div class="col-sm-1 col-xs-4 text-center">
            <i class="fa fa-pinterest fa-4x"></i>
        </div>
        <div class="col-sm-1 col-xs-4 text-center">
            <i class="fa fa-google-plus fa-4x"></i>
        </div>
        <div class="col-sm-1 col-xs-4 text-center">
            <i class="fa fa-twitter fa-4x"></i>
        </div>
        <div class="col-sm-1 col-xs-4 text-center">
            <i class="fa fa-dribbble fa-4x"></i>
        </div>
    </div>
</section>

<footer id="footer">
    <div class="container">
        <div class="row">
            <div class="col-xs-6 col-sm-6 col-md-3 column">
                <h4>Information</h4>
                <ul class="nav">
                    <li><a href="about-us.html">Products</a></li>
                    <li><a href="about-us.html">Services</a></li>
                    <li><a href="about-us.html">Benefits</a></li>
                    <li><a href="elements.html">Developers</a></li>
                </ul>
            </div>
            <div class="col-xs-6 col-md-3 column">
                <h4>Follow Us</h4>
                <ul class="nav">
                    <li><a href="#">Twitter</a></li>
                    <li><a href="#">Facebook</a></li>
                    <li><a href="#">Google+</a></li>
                    <li><a href="#">Pinterest</a></li>
                </ul>
            </div>
            <div class="col-xs-6 col-md-3 column">
                <h4>Contact Us</h4>
                <ul class="nav">
                    <li><a href="#">Email</a></li>
                    <li><a href="#">Headquarters</a></li>
                    <li><a href="#">Management</a></li>
                    <li><a href="#">Support</a></li>
                </ul>
            </div>
            <div class="col-xs-6 col-md-3 column">
                <h4>Customer Service</h4>
                <ul class="nav">
                    <li><a href="#">About Us</a></li>
                    <li><a href="#">Delivery Information</a></li>
                    <li><a href="#">Privacy Policy</a></li>
                    <li><a href="#">Terms &amp; Conditions</a></li>
                </ul>
            </div>
        </div>
        <!--/row-->
        <p class="text-right">SnippetShare 2015</p>
    </div>
</footer>

<div class="scroll-up">
	<a href="#"><i class="fa fa-angle-up"></i></a>
</div>

<div id="myModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">close</button>
                <h2 class="text-center">Login</h2>
            </div>

            <div class="modal-body row">
                <h6 class="text-center">COMPLETE THESE FIELDS TO SIGN UP</h6>
                <form class="col-md-10 col-md-offset-1 col-xs-12 col-xs-offset-0" method="POST" action="<c:url value="/j_spring_security_check" />">
                    <div class="form-group">
                        <input type="text" class="form-control input-lg" placeholder="Username" name="username" id="inputEmail" required autofocus>
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control input-lg" placeholder="Password" name="password" id="inputPassword" required>
                    </div>
                    <div class="form-group">
                        <button class="btn btn-danger btn-lg btn-block" type="submit" value="Login">Sign In</button>
                        <span class="pull-right"><a href="#">Register</a></span><span><a href="#">Need help?</a></span>
                    </div>
                </form>
            </div>

			<c:if test="${not empty param.error}"> 
				<font color="red"> 
					Login error. <br /> 
					Reason : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message} 
				</font>
			</c:if>


            <div class="modal-footer">
                <h6 class="text-center"><a href="">Privacy is important to us. Click here to read why.</a></h6>
            </div>
        </div>
    </div>
</div>

<div id="yourModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">close</button>
                <h2 class="text-center">SignUp</h2>
            </div>

            <div class="modal-body row">
                <h6 class="text-center">COMPLETE THESE FIELDS TO SIGN UP</h6>
                <form class="col-md-10 col-md-offset-1 col-xs-12 col-xs-offset-0" method="POST" action="signup">
                    <div class="form-group">
                        <input type="text" class="form-control input-lg" placeholder="Username" name="username" id="inputEmail" required autofocus>
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control input-lg" placeholder="Password" name="password" id="inputPassword" required>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control input-lg" placeholder="Fullname" name="name" id="inputEmail" required autofocus>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control input-lg" placeholder="Address" name="address" id="inputEmail" required autofocus>
                    </div>
                    <div class="form-group">
                        <button class="btn btn-danger btn-lg btn-block" type="submit" value="Signup">Sign Up</button>
                        <span><a href="#">Need help?</a></span>
                    </div>
                </form>
            </div>

			<c:if test="${not empty param.error}"> 
				<font color="red"> 
					Login error. <br /> 
					Reason : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message} 
				</font>
			</c:if>


            <div class="modal-footer">
                <h6 class="text-center"><a href="">Privacy is important to us. Click here to read why.</a></h6>
            </div>
        </div>
    </div>
</div>

    <!--scripts loaded here-->
    
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    
    <script src="assets/js/scripts.js"></script>
  </body>
</html>