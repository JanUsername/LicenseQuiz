package it.unibz.quiz.controller;

import it.unibz.quiz.QuizBean;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/buttonLis")
public class ButtonController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String applicationContextPath = request.getContextPath();
		
		
		HttpSession session = request.getSession();
		try {

			session = request.getSession();
			QuizBean quiz = (QuizBean) session.getAttribute("quiz");
			
			if(request.getParameter("question1T") != null){
				quiz.getCurrentQuestion().getAnswers()[0].setChosenAnswer(true);
			}
			
			if(request.getParameter("question1F") != null){
				quiz.getCurrentQuestion().getAnswers()[0].setChosenAnswer(false);
			}
			
			if(request.getParameter("question2T") != null){
				quiz.getCurrentQuestion().getAnswers()[1].setChosenAnswer(true);
			}
			
			if(request.getParameter("question2F") != null){
				quiz.getCurrentQuestion().getAnswers()[1].setChosenAnswer(false);
			}
			
			if(request.getParameter("question3T") != null){
				quiz.getCurrentQuestion().getAnswers()[2].setChosenAnswer(true);
			}
			
			if(request.getParameter("question3F") != null){
				quiz.getCurrentQuestion().getAnswers()[2].setChosenAnswer(false);
			}

			
			if(request.getParameter("next") != null){
				quiz.setCurrentQuestionNo(quiz.getCurrentQuestionNo()+1);
			}
			
			if(request.getParameter("previous") != null){
				quiz.setCurrentQuestionNo(quiz.getCurrentQuestionNo()-1);
			}
			
			if(request.getParameter("select") != null){
				quiz.setCurrentQuestionNo(Integer.parseInt(request.getParameter("select")));
			}
			
			if(request.getParameter("answered") != null){
				quiz.setCurrentQuestionNo(Integer.parseInt(request.getParameter("answered")));
			}
			
			if(request.getParameter("notAnswered") != null){
				quiz.setCurrentQuestionNo(Integer.parseInt(request.getParameter("notAnswered")));
			}
			
			if(request.getParameter("finish") != null){
				request.getRequestDispatcher("/EvaluateQuiz.jsp").forward(request,
						response);
			} else {
			
			request.getRequestDispatcher("/LicenseQuiz.jsp").forward(request,
					response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
