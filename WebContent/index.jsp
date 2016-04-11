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

					<!-- start title and picture -->

					<c:choose>
						<c:when test="${ empty(presNum.imgpath)}">
							<div class="row">
								<div class="col-xs-12">

									<div id="mainTitle">
										<h2>
											<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
											Welcome to Presidents <span class="glyphicon glyphicon-star"
												aria-hidden="true"></span>
										</h2>

									</div>


								</div>

							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="text-center">
										<img class="img-responsive img-rounded text-center"
											src="img/trump.jpg" alt="president image">
									</div>

								</div>
							</div>
						</c:when>
						<c:otherwise>
							<div class="row">
								<div class="col-xs-12">

									<div id="mainTitle">
										<h2>

											<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
											${presNum.name} <span class="glyphicon glyphicon-star"
												aria-hidden="true"></span>
										</h2>

									</div>
								</div>
							</div>
							<div class="row">

								<div class="text-center">
									<div class="col-xs-12">
										<img class="img-responsive img-rounded"
											src="${presNum.imgpath}" alt="president image">
									</div>

								</div>





							</div>
						</c:otherwise>
					</c:choose>

					<!-- End title and picture -->

					<!-- Start arrow selections -->



					<div class="row ">
						<div class="col-xs-12">
							<div class="smMargAll" id="arrowButtons">
								<form action="presServlet" method="GET">
									<button type="submit" name="option" value="previous"
										class="btn btn-default btn-lg brdrless col-xs-6">
										<span class="glyphicon glyphicon-triangle-left"
											aria-hidden="true"></span>
									</button>

									<button type="submit" name="option" value="next"
										class="btn btn-default btn-lg col-xs-6">
										<span class="glyphicon glyphicon-triangle-right"
											aria-hidden="true"></span>
									</button>
								</form>

							</div>

						</div>
					</div>


					<!-- End arrow selections -->

					<!-- Start bio and wiki link -->


					<c:choose>
						<c:when test="${ empty(presNum.imgpath)}">
						</c:when>
						<c:otherwise>
							<div class="row">
								<div class="col-xs-12">
									<div class="panel panel-default nobrdr">
										<div class="comment more bio panel-body">
										
											<b>Term Number:</b> ${presNum.termnumber} <b>Party:</b> ${presNum.party}
											<b>Term Length:</b> ${presNum.years}
											 <br><br>
											<b>Bio:</b> ${presNum.bio}
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div id="wikiRow">
										<b>Wiki Link:</b> <a href="${presNum.link}">www.wikipedia.org/${presNum.name}</a>
									</div>

								</div>
							</div>
							<br>
						</c:otherwise>
					</c:choose>

					<!-- End bio and wiki link -->

					<!-- Start search bar -->


					<div class="row">
						<div class="col-xs-12">
							<form action="presServlet" method="GET">
								<div class="input-group text-center ">
									<input type="text" name="presNum" placeholder="Search for president by number" class="form-control whitebrdr">
									 <span class="input-group-btn">
										<button type="submit" name="option" value="submit"
											class="btn btn-secondary">go</button>
									</span>
								</div>
							</form>
						</div>


					</div>

					<!-- End Search Bar -->

					<br>

					<!-- Start Search Button -->


					<div class="row">
						<div class="col-xs-12">
							<div class="text-center">
								<h3 class="moreButton">
									<a href="index2.jsp"><button class="btn">Search By
											Party</button></a>
								</h3>
							</div>

						</div>

					</div>

					<!--End Search Button  -->

					<!-- Start music player -->

					<div class="row">
						<div class="col-xs-12">
							<iframe width="100%" height="80" scrolling="no" frameborder="no"
								src="https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/tracks/124731051&amp;auto_play=false&amp;hide_related=false&amp;show_comments=true&amp;show_user=true&amp;show_reposts=false&amp;visual=true"></iframe>
						</div>
					</div>

					<!-- End Music Player -->

				</div>

				<!-- End jumbotron -->

			</div>

			<!-- End container -->
		</div>

		<!-- End intro Body -->


	</div>




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
