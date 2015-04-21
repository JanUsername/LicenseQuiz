package it.unibz.quiz.controller;

import it.unibz.quiz.QuizBean;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ExamController
 */
@WebServlet("/quiz")
public class QuizController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		try {
			session.removeAttribute("quiz");
			session = request.getSession();
			System.out.println("Setting Exam ");
			QuizBean quiz = new QuizBean();
			session.setAttribute("quiz", quiz);

			request.getRequestDispatcher("/LicenseQuiz.jsp").forward(request,
					response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
