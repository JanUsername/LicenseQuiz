<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Evaluation of the quiz</h1>


<%--

	Evaluation of the quiz

 --%>
<form action="quiz" method="get">
	<table width="100%">
		<tr>
			<td>
				You have earned ${sessionScope.quiz.result} points of a maximum of ${sessionScope.quiz.maximalResult}. 
				In Percentage: ${sessionScope.quiz.inPercent}%.
			</td>
			<td rowspan="3">
				<input type="submit" name="new" value="New Quiz">
			</td>
		</tr>
		<tr>
			<td>
			</td>
		</tr>
		<tr>
			<td>
			<c:choose>
					<c:when test="${sessionScope.quiz.passed}">
						<b><i>Congratulations ! You have passed the exam.</i></b>
					</c:when>
					<c:otherwise>
						<b><i>Try again. You have failed !</i></b>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
	</table>
</form>
<hr>

<c:forEach items="${sessionScope.quiz.questions}" var="currentQuest" varStatus="vs">
	<table width="100%" class="table" style="background-color:PaleGreen;">
		<tr>
			<td>
				<b>Question ${vs.count} of ${sessionScope.quiz.noQuestions}</b>
			</td>
			<td rowspan="2" align="right">
				<c:if test="${not empty currentQuest.pic}">
					<img src="images1/${currentQuest.pic }">
				</c:if>	
			</td>
		</tr>
		<tr>
			<td>
				${currentQuest.questiontext}
			</td>
		</tr>
		<tr>
			<td>
			</td>
			<td align="right">
				${currentQuest.picText}
			</td>
		</tr>
	</table>

	<table width="100%" class="table" style="background-color:AntiqueWhite;">
		<tr>
			<th width="70%">
			</th>
			<th colspan="2" align="left">
				Your<br>Answers
			</th>
			<th colspan="2" align="left">
				Correct<br>Answers
			</th>
			<th>
			</th>
		</tr>
		<tr align="left">
			<td>
			</td>
			<td>
				True
			</td>
			<td>
				False
			</td>
			<td>
				True
			</td>
			<td>
				False
			</td>
			<td>
				Score
			</td>
		</tr>
		<tr>
			<td>
				${currentQuest.answers[0].answertext}
			</td>

			

			

			<%--
			
			Radiobuttons are disabled in order to evaluate the Answers

			 --%>
			<c:choose>
				<c:when test="${currentQuest.answers[0].answered eq false}">
					<td>
						<input type="radio" disabled="disabled">
					</td>
					<td>
						<input type="radio" disabled="disabled">
					</td>
				</c:when>
				<c:when test="${currentQuest.answers[0].chosenAnswer}">
					<td>
						<input type="radio" checked="checked">
					</td>
					<td>
						<input type="radio" disabled="disabled">
					</td>
				</c:when>
				<c:otherwise>
					<td>
						<input type="radio" disabled="disabled">
					</td>
					<td>
						<input type="radio" checked="checked">
					</td>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${currentQuest.answers[0]._true}">
					<td>
						<input type="radio" checked="checked">
					</td>
					<td>
						<input type="radio" disabled="disabled">
					</td>
				</c:when>
				<c:otherwise>
					<td >
						<input type="radio" disabled="disabled" >
					</td>
					<td>
						<input type="radio" checked="checked" >
					</td>
				</c:otherwise>
			</c:choose>
			<td>
				${currentQuest.answers[0].result }
			</td>
		</tr>
		<tr>
			<td>
				${currentQuest.answers[1].answertext }
			</td>
			<c:choose>
				<c:when test="${currentQuest.answers[1].answered eq false}">
					<td>
						<input type="radio" disabled="disabled">
					</td>
					<td>
						<input type="radio" disabled="disabled">
					</td>
				</c:when>
				<c:when test="${currentQuest.answers[1].chosenAnswer}">
					<td>
						<input type="radio" checked="checked">
					</td>
					<td>
						<input type="radio" disabled="disabled">
					</td>
				</c:when>
				<c:otherwise>
					<td>
						<input type="radio" disabled="disabled">
					</td>
					<td>
						<input type="radio" checked="checked">
					</td>
				</c:otherwise>
			</c:choose>
						<c:choose>
				<c:when test="${currentQuest.answers[1]._true}">
					<td>
						<input type="radio" checked="checked">
					</td>
					<td>
						<input type="radio" disabled="disabled">
					</td>
				</c:when>
				<c:otherwise>
					<td>
						<input type="radio" disabled="disabled">
					</td>
					<td>
						<input type="radio" checked="checked">
					</td>
				</c:otherwise>
			</c:choose>
			<td>
				${currentQuest.answers[1].result }
			</td>
		</tr>
		<tr>
			<td>
				${currentQuest.answers[2].answertext }
			</td>
			<c:choose>
				<c:when test="${currentQuest.answers[2].answered eq false}">
					<td>
						<input type="radio" disabled="disabled">
					</td>
					<td>
						<input type="radio" disabled="disabled">
					</td>
				</c:when>
				<c:when test="${currentQuest.answers[2].chosenAnswer}">
					<td>
						<input type="radio" checked="checked">
					</td>
					<td>
						<input type="radio" disabled="disabled">
					</td>
				</c:when>
				<c:otherwise>
					<td>
						<input type="radio" disabled="disabled">
					</td>
					<td>
						<input type="radio" checked="checked">
					</td>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${currentQuest.answers[2]._true}">
					<td>
						<input type="radio" checked="checked">
					</td>
					<td>
						<input type="radio" disabled="disabled">
					</td>
				</c:when>
				<c:otherwise>
					<td>
						<input type="radio" disabled="disabled">
					</td>
					<td>
						<input type="radio" checked="checked">
					</td>
				</c:otherwise>
			</c:choose>
			<td>
				${currentQuest.answers[2].result }
			</td>
		</tr>
	</table>
	<hr>
</c:forEach>