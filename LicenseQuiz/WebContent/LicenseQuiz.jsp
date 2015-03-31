<html>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<jsp:useBean id="quiz" class="it.unibz.quiz.QuizBean" scope="session" />
	<head>
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		<!-- Latest compiled JavaScript -->
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
		<meta charset="utf-8">
		<title> Licence exam quiz </title>
		
		<script type="text/javascript" >
		function notFinishedYet()
		{
			return confirm("Attention ! The quiz form is not finished yet. Proceed anyway ?");
		}
		function secureFinish()
		{
			return confirm("Are you sure you want to end the quiz ?");
		}
	</script>
	</head>
	<body>
		<h1>License quiz</h1>
		
		<form action="ButtonListener.jsp" method="get">
			<table width="100%">
				<tr>
					<td rowspan="2">
						<c:choose>
							<c:when test="${quiz.noNotAnsQuestion ne 0 }">
								<input type="submit" name="finish" class="btn btn-primary btn-lg" value="End quiz"
									 onclick="return notFinishedYet()" >					
							</c:when>
							<c:otherwise>
								<input type="submit" name="finish" class="btn btn-primary btn-lg" value="End quiz"
									 onclick="return secureFinish()" >
							</c:otherwise>
						</c:choose>
					</td>
					<td>
						Answered:
						<c:forEach items="${quiz.questions}" var="i" varStatus="vs">
							<c:if test="${i.answered eq true}">
								<a href="ButtonListener.jsp?select=${vs.count-1}">${vs.count}</a>
							</c:if>
						</c:forEach>
						<c:if test="${quiz.noAnsQuestion eq 0}">
							None					
						</c:if>
					</td>
					<td rowspan="2" align="right">
						<c:choose>
							<c:when test="${quiz.hasPrevQuestion eq false}">
								<input type="submit" name="previous" class="btn btn-primary btn-lg" value="previous" disabled>
							</c:when>
							<c:otherwise>
								<input type="submit" name="previous" class="btn btn-primary btn-lg" value="previous">
							</c:otherwise>
						</c:choose>
					</td>
					<td rowspan="2" align="left">
						<c:choose>
							<c:when test="${quiz.hasNextQuestion eq false}">
								<input type="submit" name="next" class="btn btn-primary btn-lg" value="next" disabled>
							</c:when>
							<c:otherwise>
								<input type="submit" name="next" class="btn btn-primary btn-lg" value="next" >
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr>
					<td>
						Not answered: 
						<c:forEach items="${quiz.questions}" var="i" varStatus="vs">
							<c:if test="${i.answered eq false}">
								<a href="ButtonListener.jsp?select=${vs.count-1}">${vs.count}</a>
							</c:if>
						</c:forEach>
					</td>
				</tr>
			</table>
		<div class="table" style="background-color:PaleGreen;">
			<hr>
			<table width="100%">
				<tr>
					<td width="75%">
						<b>Question ${quiz.currentQuestionNo+1 } of ${quiz.noQuestions }</b>
					</td>
					<td rowspan="2" align="center">
						<c:if test="${not empty quiz.currentQuestion.pic}">
							<img src="images1/${quiz.currentQuestion.pic }">
						</c:if>
					</td>
				</tr>
				<tr>
					<td>
						<div class="col-md-10">
							${quiz.currentQuestion.questiontext }
						</div>
					</td>
				</tr>
				<tr>
					<td>
					</td>
					<td align="center">
						<c:if test="${not empty quiz.currentQuestion.pic}">
							${quiz.currentQuestion.picText }
						</c:if>
					</td>
				</tr>
			</table>
			
			<hr>
			</div>
			<div class="table" style="background-color:lavender;">
			<table width="100%">
				<tr align="left">
					<th>
						Answer
					</th>
					<th>
						True
					</th>
					<th>
						False
					</th>
				</tr>
				<c:forEach items="${quiz.currentQuestion.answers }" var="answer" varStatus="vs">
					<tr>
						<c:choose>
							<c:when test="${answer.answered && answer.chosenAnswer eq true }">
								<td>${answer.answertext }</td>
								<td><input type="radio" name="question${vs.count}" checked="checked"></td>
								<td><input type="radio" name="question${vs.count}"></td>
							</c:when>
							<c:when test="${answer.answered && answer.chosenAnswer eq false }">
								<td>${answer.answertext }</td>
								<td><input type="radio" name="question${vs.count}"></td>
								<td><input type="radio" name="question${vs.count}" checked="checked"></td>
							</c:when>
							<c:otherwise>
								<td>${answer.answertext }</td>
								<td><input type="radio" name="question${vs.count}"></td>
								<td><input type="radio" name="question${vs.count}"></td>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
			</table>		
			<hr>
			</div>
		</form>
	</body>
</html>