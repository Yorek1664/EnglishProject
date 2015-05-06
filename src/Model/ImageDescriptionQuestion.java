package Model;

public class ImageDescriptionQuestion{

	private final String type = "Listening";
	
	private final String part = "1";
	
	private String pic_file;
	
	private String sound_file;
	
	private String[] choice;
	
	private char answer;
	
	public ImageDescriptionQuestion(String pic, String sound, String[] c, char a){
		this.pic_file = pic;
		this.sound_file = sound;
		this.choice = c;
		this.answer = a;
	}

	public String getType() {
		return type;
	}

	public String getPart() {
		return part;
	}

	public String getPic_file() {
		return pic_file;
	}

	public String getSound_file() {
		return sound_file;
	}

	public String[] getChoice() {
		return choice;
	}

	public char getAnswer() {
		return answer;
	}

	public void setPic_file(String pic_file) {
		this.pic_file = pic_file;
	}

	public void setSound_file(String sound_file) {
		this.sound_file = sound_file;
	}

	public void setChoice(String[] choice) {
		this.choice = choice;
	}

	public void setAnswer(char answer) {
		this.answer = answer;
	}
	

}
