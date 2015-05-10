package Model;

import java.util.List;

public class PartQuestion {

	public enum TypeQuestion{
		Image,//have 1 picture, 1 soundfile, 1 question
		Listen,//1 soundfile, 1 or more question
		read;//1 or more question
	}
	
	private TypeQuestion type;
	private String picture;
	private String soundFile;
	private List<Question> questions;
	
	public PartQuestion() {
		super();
	}
	
	public PartQuestion(TypeQuestion type, String picture, String soundFile,
			List<Question> questions) {
		super();
		this.type = type;
		this.picture = picture;
		this.soundFile = soundFile;
		this.questions = questions;
	}
	
	public TypeQuestion getType() {
		return type;
	}
	public void setType(TypeQuestion type) {
		this.type = type;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getSoundFile() {
		return soundFile;
	}
	public void setSoundFile(String soundFile) {
		this.soundFile = soundFile;
	}
	public List<Question> getQuestion() {
		return questions;
	}
	public void setQuestion(List<Question> questions) {
		this.questions = questions;
	}
	
	
}
