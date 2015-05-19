package it.unibz.quiz;

import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;

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
	
	public String getAnswertext () throws Exception{
		Translate.setClientId("LicenseQuiz");
        Translate.setClientSecret("tdh3lRzvruel4InSIW7/gKUmsxB1AHU8OvMxLWlgVLU=");

        String translatedText = Translate.execute(this.answertext, Language.GERMAN, Language.ENGLISH);
		return translatedText;
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
