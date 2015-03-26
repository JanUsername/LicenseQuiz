<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<meta charset="utf-8">
<title>licence exam quiz</title>
</head>
<body>
	<div class="jumbotron">
		<button
			onclick="location.href='${pageContext.request.contextPath}/quiz'">Start
			Exam</button>
	</div>
	<!-- question + img -->
	<div class="row" style="background-color: PaleGreen;">
		<div class="col-md-10">
			<p class="bg-info">Welcome to our driver quiz</p>
		</div>
		<div class="col-md-2">
			<a href="car.jpg" class="thumbnail"> <img class="img-responsive"
				src="car.jpg" alt="you should see this pic">
			</a>
		</div>
	</div>
</html>