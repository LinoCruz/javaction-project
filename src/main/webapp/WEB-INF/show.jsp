<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="ie=edge" />
 <!-- BOOTSTRAP CSS -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
      crossorigin="anonymous"
    />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<!-- Font Awesome icons-->
<script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    <!-- Theme CSS -->
<link href="css/styles.css" rel="stylesheet" />
<title>JavACTION</title>
</head>
<body style="background-color: #F1F1F1">

<!--  HEADER -->
	
	<header class="p-3 mb-3 border-bottom" style="background: linear-gradient(90deg, rgba(0,0,0,1) 0%, rgba(35,35,43,1) 29%, rgba(107,32,32,1) 74%, rgba(3,94,112,1) 100%)">
    <div class="container">
      <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
        <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-dark text-decoration-none">
         <i class="fa-brands fa-java" style="color:white; height:35px"></i>
        </a>

        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
          <li><a href="#" class="nav-link px-2 link-secondary" style="color:#F6F6F6; font-weight: bold; font-size: 25px">Jav<span style="color:#CE0808; font-size:22px">ACTION</span></a></li>
        </ul>

        <div class="dropdown text-end">
          <a href="#" class="d-block link-dark text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
            <img src="/img/user.png" alt="user random pic" width="32" height="32" class="rounded-circle">
          </a>
      
          <ul class="dropdown-menu text-small" aria-labelledby="dropdownUser1">
            <li><a class="dropdown-item" href="/logout">Sign out</a></li>
          </ul>
        </div>
      </div>
    </div>
  </header>
<!--  EXPLANATION -->
<section class="container">
<div class="card" style="border: 0 solid white; background-color: #F1F1F1">
	  <div class="card-body">
	 
	   
	   <h5 class="card-title text-danger" style="font-size:45px">${algo.name}</h5> 
	  
		<h6 class="card-subtitle mb-2 text-muted" style="font-size:20px">What to do?</h6>
	    <p class="card-text">${algo.challenge}</p>
		<h6 class="card-subtitle mb-2 text-muted" style="font-size:18px">More info?</h6>
	    <p class="card-text" style="font-size:14px">${algo.moreinfo}</p>
	  </div>
</div>
</section>

<!-- COMPILADOR -->
<section class="container justify-content-center">
 <a href="/dashboard" class="btn btn-warning">Go Back</a>
<div class="col-10">
<h5>Now it's your turn, use this compiler to resolve the algorithm: </h5>


<div data-pym-src="https://www.jdoodle.com/embed/v0/4Jcm"></div>
</div>
</section>

<!-- ANSWERS -->
<section class="container">
 <button onclick="myFuncion()" class="btn btn-danger">
        Need a hint? Click here to see some videos.
    </button>
    
<div class="row row-cols-1 row-cols-md-2 g-4" id="moreText">
 
 
 
  <c:forEach var="video" items="${videos}">
  <div class="col">
  
    <div class="card">
      <iframe width="560" height="315" src="https://www.youtube.com/embed/${video.getLink().substring(32)}" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
    </div>  
 
  </div>
 </c:forEach>
</div>

	


</section>
<!-- FOOTER -->
<div class="container">
  <footer class="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top">
    <div class="col-md-4 d-flex align-items-center">
      <a href="/" class="mb-3 me-2 mb-md-0 text-muted text-decoration-none lh-1">
      </a>
      <span class="text-muted">© 2022 Made By Lino Cruz </span>
    </div>

    <ul class="nav col-md-4 justify-content-end list-unstyled d-flex">
      <li class="ms-3"><a class="text-muted" href="https://github.com/LinoCruz"><i class="fa-brands fa-github" style="width=24; height=24"></i></a></li>
      <li class="ms-3"><a class="text-muted" href="https://www.youtube.com/channel/UCB_YFjDFb9vZ7QcarxmjGPw"><i class="fa-brands fa-youtube" style="width=24; height=24"></i></a></li>
      <li class="ms-3"><a class="text-muted" href="https://discord.gg/nvp8TfRK8h"><i class="fa-brands fa-discord" style="width=24; height=24"></i></a></li>
    </ul>
  </footer>
</div>

<script src="https://www.jdoodle.com/assets/jdoodle-pym.min.js" type="text/javascript"></script>
<script src="/js/scripts.js"></script>
</body>
</html>