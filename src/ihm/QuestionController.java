package ihm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.TextAlignment;
import Model.PartQuestion;
import Model.Question;


public class QuestionController extends Controller{
	Label a= getLabelA();
	Label b= getLabelB();
	Label c= getLabelC();
	Label d= getLabelD();
	Label joker1= getJoker1();
	Label joker2= getJoker2();
	Label exit= getExit();
	Label title= getLabelTitle();
	ImageView image = new ImageView();
	List<PartQuestion> questions= new ArrayList<PartQuestion>();
	PartQuestion actualPartQuestion=null;
	Question actualQuestion=null;
	
	@Override
	protected void setStartCondition() {
		this.setBackgroundImage("question.png",600,374);
		this.image.setFitWidth(200);
		this.image.setFitHeight(150);
		this.image.setLayoutX(203);
		this.image.setLayoutY(45);
		this.getChildren().addAll(a,b,c,d,joker1,joker2,image,exit,title);
		exit.setOnMouseClicked(e->{
			try {
				Controller.initialise(this.getApp(), AccueilController.class);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		a.setOnMouseClicked(e->{
			if(answer()){
				
			}else{
				
			}
		});
	}
	public void setQuestion(List<PartQuestion> questions){
		this.questions=questions;
		setNextQuestion();
		displayQuestion();
	}
	private void displayQuestion(){
		initialiseDisplay();
		switch(this.actualPartQuestion.getType()){
		case Image:displayImage(this.actualPartQuestion.getPicture());
		case Listen:displayAudio(this.actualPartQuestion.getSoundFile());
		}
		this.title.setText(this.actualQuestion.getQuestion());
		for(int i=0; i<this.actualQuestion.getAnswers().size() && i<4;i++){
			switch (i) {
			case 0:
				this.a.setText(this.actualQuestion.getAnswers().get(i));
				this.a.setDisable(false);
				break;
			case 1:
				this.b.setText(this.actualQuestion.getAnswers().get(i));
				this.b.setDisable(false);
				break;
			case 2:
				this.c.setText(this.actualQuestion.getAnswers().get(i));
				this.c.setDisable(false);
				break;
			case 3:
				this.d.setText(this.actualQuestion.getAnswers().get(i));
				this.d.setDisable(false);
				break;
			}
		}
		System.out.println("question display : "+this.actualQuestion.getQuestion());
	}
	private boolean answer(){
		return true;
	}
	private void initialiseDisplay(){
		this.a.setText("");
		this.a.setDisable(true);
		this.b.setText("");
		this.b.setDisable(true);
		this.c.setText("");
		this.c.setDisable(true);
		this.d.setText("");
		this.d.setDisable(true);
		this.image.setVisible(false);
	}
	private void displayAudio(String path){
		try {
			Runnable task = new Runnable() {
	               public void run() {
	       			Media hit = new Media(Paths.get(path).toUri().toString());
	       			MediaPlayer mediaPlayer = new MediaPlayer(hit);
	       			mediaPlayer.play();}
	            };
	            new Thread(task).start();
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
	private void displayImage(String path){
		Image img;
		try {
			img = new Image(new FileInputStream(new File(path)), image.getFitWidth(), image.getFitHeight(), false, true);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		this.image.setImage(img);
		this.image.setVisible(true);
	}
	/**
	 * 
	 * @return false if have no more question
	 */
	private boolean setNextQuestion(){
		try{
			if(actualPartQuestion==null){//premiere question
				this.actualPartQuestion = questions.get(0);
				this.actualQuestion=actualPartQuestion.getQuestion().get(0);
				return true;
			}
			
			//cas ou il reste des sous question
			int indexQuestion = this.actualPartQuestion.getQuestion().indexOf(this.actualQuestion);
			if(indexQuestion+1<this.actualPartQuestion.getQuestion().size()){//sous question suivante
				this.actualQuestion=this.actualPartQuestion.getQuestion().get(indexQuestion+1);
				return true;
			}
			
			//chagement de question
			int indexPart = this.questions.indexOf(this.actualPartQuestion);
			if(indexPart+1<this.questions.size()){//sous question suivante
				this.actualPartQuestion=this.questions.get(indexPart+1);
				this.actualQuestion=this.actualPartQuestion.getQuestion().get(0);
				return true;
			}
			this.actualPartQuestion=null;
			this.actualQuestion=null;
			return false;
		}catch(Exception e){
			e.printStackTrace();
			this.actualPartQuestion=null;
			this.actualQuestion=null;
			return false;
		}
	}
	static public Label getLabelA(){
		Label l = new Label();
		l.setLayoutX(46);
		l.setLayoutY(287);
		l.setPrefHeight(33);
		l.setPrefWidth(235);
		setLabelGraphic(l);
		return l;
	}
	static public Label getLabelB(){
		Label l = new Label();
		l.setLayoutX(323);
		l.setLayoutY(287);
		l.setPrefHeight(33);
		l.setPrefWidth(235);
		setLabelGraphic(l);
		return l;
	}	
	static public Label getLabelC(){
		Label l = new Label();
		l.setLayoutX(46);
		l.setLayoutY(334);
		l.setPrefHeight(33);
		l.setPrefWidth(235);
		setLabelGraphic(l);
		return l;
	}
	static public Label getLabelD(){
		Label l = new Label();
		l.setLayoutX(323);
		l.setLayoutY(334);
		l.setPrefHeight(33);
		l.setPrefWidth(235);
		setLabelGraphic(l);
		return l;
	}
	static public Label getLabelTitle(){
		Label l = new Label();
		l.setLayoutX(57);
		l.setLayoutY(215);
		l.setPrefHeight(58);
		l.setPrefWidth(485);
		l.setStyle("-fx-font-weight: bold;");
		setLabelGraphic(l);
		return l;
	}
	static public Label getJoker1(){
		Label l = new Label();
		l.setLayoutX(455);
		l.setLayoutY(5);
		l.setPrefHeight(37);
		l.setPrefWidth(65);
		return l;
	}
	static public Label getJoker2(){
		Label l = new Label();
		l.setLayoutX(530);
		l.setLayoutY(5);
		l.setPrefHeight(37);
		l.setPrefWidth(65);
		return l;
	}
	static public Label getExit(){
		Label l = new Label();
		l.setLayoutX(5);
		l.setLayoutY(5);
		l.setPrefHeight(37);
		l.setPrefWidth(65);
		return l;
	}
}
