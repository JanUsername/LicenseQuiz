package it.unibz.quiz;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import it.unibz.db.util.ConnectionManager;

public class QuizBean
{

	private static final int NUM_QUESTIONS = 10;
	private static final int NUM_ANSWERS = 3;
	
	private int currentQuestionNo = 0;

	private boolean finished = false;

	private QuestionBean[] questions = null;
	

	public QuizBean() throws SQLException {

		
		Connection con = null;

		Statement statementquestions = null;
		Statement statementanswers = null;

		ResultSet resultSetquestions = null;
		ResultSet resultSetanswers = null;
		
		questions = new QuestionBean[NUM_QUESTIONS];
		AnswerBean[] answers = new AnswerBean[NUM_ANSWERS];

		try{
			con = ConnectionManager.getConnection();
			con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			con.setAutoCommit(false);
			statementquestions = con.createStatement();
			statementanswers = con.createStatement();
			
			resultSetquestions = statementquestions.executeQuery("SELECT * FROM fragen ORDER BY random() LIMIT "+NUM_QUESTIONS+";");
			int count = 0;
			while(resultSetquestions.next()){
				
				String sqlanswers = "SELECT * FROM antworten WHERE fragenummer = " +
				resultSetquestions.getString("fragenummer") + " ORDER BY random() LIMIT " 
				+ NUM_ANSWERS+";";
				
				resultSetanswers = statementanswers.executeQuery(sqlanswers);
				answers = new AnswerBean[NUM_ANSWERS];
				
				int count2 = 0;
				while(resultSetanswers.next()){
					answers[count2] = new AnswerBean(resultSetanswers.getString("antworttext"), 
							resultSetanswers.getString("richtig").equals("0") ? false : true);
					count2++;
				}

				this.questions[count] = new QuestionBean(resultSetquestions.getString("fragetext"), 
						resultSetquestions.getString("bild"), answers);
				count++;
			}
			con.commit();
		} catch (SQLException se) {
			throw new SQLException("QuizBean: " + se.getMessage());
		} finally {
			try {resultSetquestions.close();}catch(Exception ex){;}
			try {resultSetanswers.close();}catch(Exception ex){;}
			try {statementquestions.close();}catch(Exception ex){;}
			try {statementquestions.close();}catch(Exception ex){;}
			try {con.close();}catch(Exception ex){;}
		}
	}


	public int getCurrentQuestionNo() {
		return this.currentQuestionNo;
	}

	public void setCurrentQuestionNo(int currentQuestionNo) {
		this.currentQuestionNo = currentQuestionNo;
	}

	public int getNoQuestions() {
		return NUM_QUESTIONS;
	}

	public QuestionBean getCurrentQuestion() {
		return this.questions[this.currentQuestionNo];
	}

	public boolean getHasNextQuestion() {
		if(this.currentQuestionNo >= this.questions.length-1)
			return false;
		return true;
	}

	public boolean getHasPrevQuestion() {
		return this.currentQuestionNo == 0 ? false : true;
	}

	public QuestionBean[] getQuestions() {
		return this.questions;
	}

	public int getNoAnsQuestion() {
		int ret = -1;
		for (int i = 0; questions != null && i < questions.length; i++)
			for (int j = 0; questions[i].getAnswers() != null &&
				j < questions[i].getAnswers().length;j++) {
				if (ret == -1)
					ret = 0;
				if (questions[i].getAnswers()[j].getAnswered() == false)
					ret++;
			}
		return ret;
	}

	public int getNoNotAnsQuestion() {
		return getNoQuestions() - getNoAnsQuestion();
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public boolean getFinished() {
		return this.finished;
	}

	public int getResult() {
		int ret = -1;
		for (int i = 0; questions != null && i < questions.length; i++)
			for (int j = 0; questions[i].getAnswers() != null &&
				j < questions[i].getAnswers().length;j++) {
				if (ret == -1)
					ret = 0;
				ret+=questions[i].getAnswers()[j].getResult();
			}
				
		return ret;
	}

	public int getMaximalResult() {
		int ret = 0;
		for (int i = 0; questions != null && i < questions.length; i++)
			for (int j = 0; questions[i].getAnswers() != null &&
				j < questions[i].getAnswers().length;j++) {
					ret++;
			}
		return ret;
	}

	public int getInPercent() {
		double ret = -1;
		if (this.getResult() >= 0 && this.getMaximalResult() > 0)
			ret = (double)this.getResult()/(double)this.getMaximalResult()*100;
		return (int)ret;
	}

	public boolean getPassed() {
		boolean ret = false;
		if ((double)((double) this.getResult()/this.getMaximalResult()) >= 86.666)
			ret = true;
		return ret;
	}
}
