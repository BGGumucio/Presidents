<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">

<head>
<title>Presidents</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible"
	content="IE=edge text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Presidents</title>

<!-- Bootstrap Core CSS -->
<!-- <link href="/css/bootstrap.min.css" rel="stylesheet"> -->

<link rel="stylesheet" href="css/bootstrap.min.css">

<!-- Custom CSS -->
<link href="css/grayscale.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link
	href="http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
</head>

<body>
	<!-- Navigation -->
	<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-main-collapse">
					<i class="fa fa-bars"></i>
				</button>
				<a class="navbar-brand page-scroll" href="#page-top"> <i
					class="fa fa-play-circle"></i> <span class="light">PRESIDENTS</span>
				</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div
				class="collapse navbar-collapse navbar-right navbar-main-collapse">
				<ul class="nav navbar-nav">
					<!-- Hidden li included to remove active class from about link when scrolled up past about section -->
					<li class="hidden"><a href="#page-top"></a></li>
					<li><a class="page-scroll" href="#about"></a></li>

				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>
	<div class="intro">
		<div class="intro-body">
			<div class="container">


				<div class=" jumbotron smargtop" id="main-div">

					<!-- start title and pictures -->
					<c:choose>
						<c:when test="${ empty(sessionScope.presList)}">
							<div class="row">
								<div class="col-xs-12">

									<div id="mainTitle">
										<h2>
											<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
											Time to Party <span class="glyphicon glyphicon-star"
												aria-hidden="true"></span>
										</h2>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">

									<div class="text-center" id="pres-image">
										<img class="img-responsive img-rounded" id="trump"
											src="img/trump.jpg" alt="president image">
									</div>
								</div>
							</div>
						</c:when>
						<c:otherwise>



							<div class="row">
								<div class="col-xs-12">




									<div id="mainTitle">






										<c:forEach var="president" items="${presList}" end="0">
											<h2>
												<span class="glyphicon glyphicon-star" aria-hidden="true"></span>

											
												<c:out value="${president.party}" />
												Party <span class="glyphicon glyphicon-star"
													aria-hidden="true"></span>
											</h2>
										</c:forEach>

									</div>
								</div>
							</div>

							<div class="row">



								<c:forEach var="president" items="${presList}">


									<div class="col-xs-5 col-sm-4 col-md-3 littlePic spec center-block" >
										<a href="${president.presSubmit}" target="_blank" class="thumbnail smallPresPic nobrdrnobckgrnd">
											<img src="${president.imgpath}" alt="${president.name}">
										</a>
										<b class="text-center tiny-image-name">${president.name}</b>
									</div>

								</c:forEach>

							</div>

						</c:otherwise>

					</c:choose>

					<!-- end pics -->

					<!-- start selection row -->

					<br>
					<div class="row">
						<div class="col-xs-1"></div>
						<form action="presServlet2" method="GET">
							<div class="form-group col-xs-8 text-center">
								<select name="party" class="form-control" id="sel1">
									<option >Choose Party</option>
									<option value="Democrat">Democrat</option>
									<option value="Democratic-Republican">Democratic-Republican</option>
									<option value="Federalists">Federalists</option>
									<option value="Independent">Independent</option>
									<option value="Republican">Republican</option>
									<option value="Whig">Whig</option>

								</select>


							</div>

							<button type="submit" name="option" value="submit"
								class=" btn col-xs-2">go</button>
						</form>
						<div class="col-xs-1"></div>

					</div>











					<!-- End selection row -->

					<!-- Start button row -->


					<div class="row">
						<div class="col-xs-12">
							<h3 class="moreButton text-center">
								<a href="index.jsp"><button class="btn">Search by
										term Number</button></a>
							</h3>

						</div>


					</div>

					<!--End button Row -->



				</div>
				<!-- End jumbotron -->
			</div>
			<!-- End container -->

		</div>
		<!-- End intro body -->
	</div>
	<!-- End intro -->



	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

	<!-- Plugin JavaScript -->
	<script src="js/jquery.easing.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="js/grayscale.js"></script>
</body>

</html>

