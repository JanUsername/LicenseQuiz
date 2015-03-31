package it.unibz.quiz;

public class AnswerBean
{
	private String answertext = null;
	private boolean _true = false;
	private boolean chosenAnswer = false;
	private boolean answered = false;
	

	public AnswerBean(String answertext, boolean _true) {
		if(answertext != null){
			this.answertext = answertext;
			this._true = _true;
		}
	}
	

	public String getAnswertext (){
		return this.answertext;
	}

	public boolean get_true() {
		return this._true;
	}

	public void setChosenAnswer(boolean chosenAnswer) {
		this.chosenAnswer = chosenAnswer;
		this.answered = true;
	}

	public boolean getChosenAnswer() {
		return this.chosenAnswer;
	}

	public boolean getAnswered() {
		return this.answered;
	}

	public int getResult() {
		int ret;
		if(this.answered && this._true == this.chosenAnswer){
			ret = 1;
		}else
			ret = 0;
		return ret;
	}
}
