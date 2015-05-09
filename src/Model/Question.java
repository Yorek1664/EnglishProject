package Model;

import java.util.List;

public class Question {

	private String question;
	private List<String> answers;
	private String goodAnswer;
	
	
	public Question() {
	}
	public Question(String question, List<String> answers) {
		super();
		this.question = question;
		this.answers = answers;
	}
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<String> getAnswers() {
		return answers;
	}
	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}
	public String getGoodAnswer() {
		return goodAnswer;
	}
	public void setGoodAnswer(String goodAnswer) {
		this.goodAnswer = goodAnswer;
	}
	
	
}
