package it.unibz.quiz.controller;

import it.unibz.quiz.QuizBean;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

/**
 * Servlet implementation class ExamController
 */
@WebServlet("/quiz")
public class QuizController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = null;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		logger = Logger.getRootLogger();
		PatternLayout layout = new PatternLayout("%d{HH:mm:ss}  %-5.5p  %t %m%n");
		logger.addAppender(new ConsoleAppender(layout));
	}

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
			QuizBean quiz = new QuizBean();
			session.setAttribute("quiz", quiz);
			logger.setLevel(Level.TRACE);
			logger.trace("New Quiz created");
			request.getRequestDispatcher("/LicenseQuiz.jsp").forward(request,
					response);
			logger.trace("Forward user to quiz form");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
