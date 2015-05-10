package Model;

import java.util.ArrayList;
import java.util.List;

public class Question {

	private String question;
	private List<String> answers;
	private String goodAnswer;
	
	
	public Question() {
		super();
		this.answers = new ArrayList<String>();
	}
	
	public Question(String question, List<String> answers, String goodAnswer) {
		super();
		this.question = question;
		this.answers = answers;
		this.goodAnswer=goodAnswer;
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
	
	public void addAnswers(String answer){
		this.answers.add(answer);
	}
	
	
}
