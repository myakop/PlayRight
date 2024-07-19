package application;

import java.io.Serializable;
import java.util.ArrayList;

public class Question implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String questionText, asker;
	private ArrayList<String> answers;
	
	

	public ArrayList<String> getAnswers() {
		if(answers==null) {
			answers= new ArrayList<>();
			Main.update();
		}
		return answers;
	}

	public void setAnswers(ArrayList<String> answers) {
		this.answers = answers;
	}

	public Question(String questionText, String asker) {
		super();
		this.questionText = questionText;
		this.asker = asker;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getAsker() {
		return asker;
	}

	public void setAsker(String asker) {
		this.asker = asker;
	}

	@Override
	public String toString() {
		return "Question [questionText=" + questionText + ", asker=" + asker + "]";
	}
	
	
	
	

}
