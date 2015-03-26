package it.unibz.quiz;


public class QuestionBean
{

	private static final String PICTEXT = "Abb.";

	private String questiontext = null;

	private String pic = null;

	private AnswerBean[] answers = null;
	

	public QuestionBean(String questiontext, String pic, AnswerBean[] answers){
		this.questiontext = questiontext;
		this.pic = pic;
		this.answers = answers;
	}
	

	public String getQuestiontext() {
		return questiontext;
	}

	public String getPic() {
		return pic;
	}

	public AnswerBean[] getAnswers() {
		return answers;
	}

	public boolean getAnswered() {
		boolean ret = true;
		for(int i = 0; i<answers.length; i++){
			if(answers[i].getAnswered() == false)
				ret = false;
		}
		return ret;
	}

	public String getPicText() {
		String ret = null;
		if(this.pic != null && this.answers != null){
			ret=PICTEXT + pic.substring(0,pic.length() -4);
		}
		return ret;
	}
}