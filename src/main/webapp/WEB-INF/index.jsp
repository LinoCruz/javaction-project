<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
<!-- Google fonts-->
 <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet" />
 <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet" />
 <!-- Core theme CSS (includes Bootstrap)-->
 <link href="css/style.css" rel="stylesheet" />
<title>JavAction</title>
</head>

<body  id="page-top">

<!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="#page-top">JavAction</a>
                <button class="navbar-toggler navbar-toggler-right" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item"><a class="nav-link" href="#login">Login</a></li>
                        <li class="nav-item"><a class="nav-link" href="#about">About</a></li>
                    </ul>
                </div>
            </div>
        </nav>

<!-- Masthead-->
        <header class="masthead">
            <div class="container px-4 px-lg-5 d-flex h-100 align-items-center justify-content-center">
                <div class="d-flex justify-content-center">
                    <div class="text-center">
                        <h1 class="mx-auto my-0 text-uppercase">JavACTION</h1>
                        <h2 class="text-white-50 mx-auto mt-2 mb-5">Challenge yourself with algorithms everyday to become the best programmer ever.</h2>
                        <a class="btn btn-primary" href="#login">Sign In</a>
                        <a class="btn btn-secondary" href="#login">Login</a>
                    </div>
                </div>
            </div>
        </header>
        
<!-- Log In and Sign up-->
        <section class="projects-section bg-light" id="login">
            <div class="container px-4 px-lg-5">
                <!-- Featured Project Row-->
                <div class="row gx-0 mb-4 mb-lg-5">
                    <div class="col-xl-7 col-lg-7" id="register">
                    <h2 style="color: ; font-weight:bold">Sign Up</h2>
				<form:form method="post" action="/register" modelAttribute="nuevoUsuario">
					
					<div class="form-group">
						<form:label path="first_name">First Name:</form:label>
						<form:input path="first_name" class="form-control"/>
						<form:errors path="first_name" class="text-danger" />
					</div>
					
					<div class="form-group">
						<form:label path="last_name">Last Name:</form:label>
						<form:input path="last_name" class="form-control"/>
						<form:errors path="last_name" class="text-danger" />
					</div>
					
					<div class="form-group">
						<form:label path="email">Email:</form:label>
						<form:input type="email" path="email" class="form-control"/>
						<form:errors path="email" class="text-danger" />
					</div>
					
					<div class="form-group">
						<form:label path="password">Password:</form:label>
						<form:password path="password" class="form-control"/>
						<form:errors path="password" class="text-danger" />
					</div>
					
					<div class="form-group">
						<form:label path="confirm">Confirm Password:</form:label>
						<form:password path="confirm" class="form-control"/>
						<form:errors path="confirm" class="text-danger" />
					</div>
					<form:input type="hidden" path="level" value="1"/>
					<input type="submit" value="Sign Up" class="btn btn-primary" style="margin-top:15px">
					
				</form:form>
                    </div>
                    <div class="col-xl-4 col-lg-5">
                        <h2>Log in</h2>
				<form:form method="post" action="/login" modelAttribute="nuevoLogin">
					<div class="form-group">
						<form:label path="email">Email:</form:label>
						<form:input type="email" path="email" class="form-control"/>
						<form:errors path="email" class="text-danger" />
					</div>
					
					<div class="form-group">
						<form:label path="password">Password:</form:label>
						<form:password path="password" class="form-control"/>
						<form:errors path="password" class="text-danger" />
					</div>
					<input type="submit" value="Login" class="btn btn-secondary" style="margin-top:15px">
				</form:form>
                    </div>
                </div>
            </div>
        </section>        
<!-- About-->
<!-- Signup-->
        <section class="signup-section" id="about">
            <div class="container px-4 px-lg-5">
                <div class="row gx-4 gx-lg-5">
                    <div class="col-md-10 col-lg-8 mx-auto text-center">
                        <i class="fa-solid fa-code fa-2x mb-2 text-white"></i>
                        <h2 class="text-white mb-5">About the project</h2>
                
                       <h4 style="color: white"> In this project, developed using java, you can find multiple challenges of algorithms. Why it is important to practice algorithms? Well:</h4>
                       <div style="text-align: left; margin-top:10px">
                        <h5 style="color: white"> - If you want to crack the interviews and get into the product based companies </h5>
						<h5 style="color: white"> - If you love to solve real-world complex problems.</h5>
						</div>
						<hr>
						<h4 style="color: white"> But, what if you pick an algorithm and can't resolved it? Well, give yourself a 30 minutes at least to resolve an algorithm and if you can't just go to the answers option where you cand find a code with the answer and even watch curated videos selected by our community that just explain the answer of the challenge.</h4> 
						<hr>
						<h4 style="color: white"> We have several options in different languages, just remember there is not only one answer so just feel proud of yourself if you resolve the challenge. </h4>

                           
                    </div>
                </div>
            </div>
        </section>
<!-- Footer-->
	<footer class="footer bg-black small text-center text-white-50"><div class="container px-4 px-lg-5">Copyright &copy 2022	JavACTION made by <a href="https://linocruz.github.io/my_web_page/">Lino Cruz</a></div></footer> 

<!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/script.js"></script>
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <!-- * *                               SB Forms JS                               * *-->
        <!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>