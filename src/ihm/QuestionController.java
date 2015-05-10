package ihm;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;




import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import Model.PartQuestion;
import Model.Question;


public class QuestionController extends Controller{
	Label a= getLabelA();
	Label b= getLabelB();
	Label c= getLabelC();
	Label d= getLabelD();
	Label joker1= getJoker1();
	boolean joker1Use=false;
	Label joker2= getJoker2();
	boolean joker2Use=false;
	Label exit= getExit();
	Label title= getLabelTitle();
	ImageView image = new ImageView();
	List<PartQuestion> questions= new ArrayList<PartQuestion>();
	PartQuestion actualPartQuestion=null;
	Question actualQuestion=null;
	Thread threadMusic ;
	MediaPlayer mediaPlayer;
	IntegerProperty score=new SimpleIntegerProperty(0);
	ImageView gain;
	List<Label> valideImages = new ArrayList<Label>();
	
	
	@Override
	protected void setStartCondition() {
		this.setBackgroundImage("question.png",600,374);
		this.image.setFitWidth(200);
		this.image.setFitHeight(150);
		this.image.setLayoutX(203);
		this.image.setLayoutY(45);
		
		this.gain = new ImageView();
		this.gain.setFitWidth(95);
		this.gain.setFitHeight(165);
		this.gain.setLayoutX(500);
		this.gain.setLayoutY(45);
		try {
			this.gain.setImage(new Image(new FileInputStream(new File("src/gain.png")), image.getFitWidth(), image.getFitHeight(), false, true));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		
		this.getChildren().addAll(a,b,c,d,joker1,joker2,image,exit,title,gain);
		setListValide();
		score.addListener((obs,o,n)->{
			if(n.intValue()>15){
				n=15;
			}
			for(int i =0;i<n.intValue();i++){
				valideImages.get(14-i).setVisible(true);
			}
		});
		exit.setOnMouseClicked(e->{
			exit();
		});
		a.setOnMouseClicked(e->{
			answer(a.getText());
		});
		b.setOnMouseClicked(e->{
			answer(b.getText());
		});
		c.setOnMouseClicked(e->{
			answer(c.getText());
		});
		d.setOnMouseClicked(e->{
			answer(d.getText());
		});
		title.setOnMouseClicked(e->{
			replay();
		});
		joker1.setOnMouseClicked(e->{
			joker1();
		});
		joker2.setOnMouseClicked(e->{
			joker2();
		});
	}
	private void answer(String s) {
		if(verifAnswer(s)){
			score.set(score.get()+1);
			setNextQuestion();
			displayQuestion();
		}else{
			if(score.get()<5){
				score.set(0);
			}else if(score.get()<10){
				score.set(5);
			}else if(score.get()<15){
				score.set(10);
			}
			exit();
		}
	}
	private void exit() {
		try {
			Alert alert = new Alert(AlertType.INFORMATION, "You ear "+getValue()+"€ in this game.", null);
			alert.setHeaderText("Finish!");
			alert.setTitle("Game over");
			alert.showAndWait();
			initialiseDisplay();
			Controller.initialise(this.getApp(), AccueilController.class);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	public void setQuestion(List<PartQuestion> questions){
		this.questions=questions;
		setNextQuestion();
		displayQuestion();
	}
	@SuppressWarnings("incomplete-switch")
	private void displayQuestion(){
		initialiseDisplay();
		if(this.actualPartQuestion==null || this.actualQuestion==null){
			Alert alert = new Alert(AlertType.INFORMATION, "You finish this part!", null);
			alert.setHeaderText("GREAT JOB");
			alert.setTitle("Good");
			alert.showAndWait();
			exit();
			return;
		}
		switch(this.actualPartQuestion.getType()){
		case Image:displayImage(this.actualPartQuestion.getPicture());
		case Listen:displayAudio(this.actualPartQuestion.getSoundFile());
		}
		this.title.setText(this.actualQuestion.getQuestion());
		for(int i=0; i<this.actualQuestion.getAnswers().size() && i<4;i++){
			switch (i) {
			case 0:
				this.a.setText(this.actualQuestion.getAnswers().get(i));
				this.a.setVisible(true);
				break;
			case 1:
				this.b.setText(this.actualQuestion.getAnswers().get(i));
				this.b.setVisible(true);
				break;
			case 2:
				this.c.setText(this.actualQuestion.getAnswers().get(i));
				this.c.setVisible(true);
				break;
			case 3:
				this.d.setText(this.actualQuestion.getAnswers().get(i));
				this.d.setVisible(true);
				break;
			}
		}
		System.out.println("question display : "+this.actualQuestion.getQuestion());
	}
	private boolean verifAnswer(String s){
		System.out.println("Correct answer: "+this.actualQuestion.getGoodAnswer());
		System.out.println("User answer: "+s);
		if(s.equalsIgnoreCase(this.actualQuestion.getGoodAnswer())){
			Alert alert = new Alert(AlertType.INFORMATION, "Great Answer", null);
			alert.setHeaderText("Good");
			alert.setTitle("Good");
			alert.showAndWait();
			return true;
		}else{
			new Alert(AlertType.ERROR, "Bad Answer, Retry an other time.", null).showAndWait();
			return false;
		}
	}
	private void initialiseDisplay(){
		if(mediaPlayer !=null){
			mediaPlayer.stop();
			mediaPlayer = null;
		}
		this.a.setText("");
		this.a.setVisible(false);
		this.b.setText("");
		this.b.setVisible(false);
		this.c.setText("");
		this.c.setVisible(false);
		this.d.setText("");
		this.d.setVisible(false);
		this.image.setVisible(false);
		this.title.setTooltip(null);
	}
	private void displayAudio(String path){
		try {
			this.title.setTooltip(new Tooltip("Click for replay the audio"));
   			Media hit = new Media(Paths.get(path).toUri().toString());
   			mediaPlayer = new MediaPlayer(hit);
   			int indexQuestion = this.actualPartQuestion.getQuestion().indexOf(this.actualQuestion);
			if(indexQuestion==0){
				mediaPlayer.play();//play automatique suelement la premiere fois
			}
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
	private void replay(){
		if(mediaPlayer!=null){
			mediaPlayer.stop();
			mediaPlayer.play();
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
	public void joker1(){
		if(!joker1Use){
			joker1Use=true;
			int ind = this.actualQuestion.getAnswers().indexOf(this.actualQuestion.getGoodAnswer());
			Random r = new Random();
			int masque = 0;
			while(masque <2){
				switch(r.nextInt(4)){
				case 0: if(!(ind==0) && a.isVisible()){a.setVisible(false);masque++;};break;
				case 1: if(!(ind==1) && b.isVisible()){b.setVisible(false);masque++;};break;
				case 2: if(!(ind==2) && c.isVisible()){c.setVisible(false);masque++;};break;
				case 3: if(!(ind==3) && d.isVisible()){d.setVisible(false);masque++;};break;
				}
				System.out.println("turn");
			}
			try {
				joker1.setGraphic(new ImageView(new Image(new FileInputStream(new File("src/croix.png")),65,37,false,false)));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	public void joker2(){
		if(!joker2Use){
			joker2Use=true;
			int ind = this.actualQuestion.getAnswers().indexOf(this.actualQuestion.getGoodAnswer());
			Random r = new Random();
			int p1 = r.nextInt(100);
			List<Integer> l = new ArrayList<Integer>();
			l.add(r.nextInt(100-p1));
			l.add(r.nextInt(100-p1-l.get(0)));
			l.add(100-p1-l.get(0)-l.get(1));
			String l1,l2,l3,l4;
			if(ind==0){
				l1 = "A : "+p1+"%";
			}else{
				l1 = "A : "+l.get(0)+"%";
				l.remove(0);
			}
			if(ind==1){
				l2 = "B : "+p1+"%";
			}else{
				l2 = "B : "+l.get(0)+"%";
				l.remove(0);
			}
			if(ind==2){
				l3 = "C : "+p1+"%";
			}else{
				l3 = "C : "+l.get(0)+"%";
				l.remove(0);
			}
			if(ind==3){
				l4 = "D : "+p1+"%";
			}else{
				l4 = "D : "+l.get(0)+"%";
				l.remove(0);
			}
			
			Alert alert = new Alert(AlertType.INFORMATION, l1+"\n"+l2+"\n"+l3+"\n"+l4, null);
			alert.setHeaderText("Public vote");
			alert.setTitle("Joker");
			alert.showAndWait();
			try {
				joker2.setGraphic(new ImageView(new Image(new FileInputStream(new File("src/croix.png")),65,37,false,false)));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	private void setListValide(){
		for(int i=0;i<15;i++){
			Label contour = new Label();
			contour.setPrefWidth(2);
			contour.setPrefHeight(2);
			contour.minHeightProperty().bind(contour.prefHeightProperty());
			contour.maxHeightProperty().bind(contour.prefHeightProperty());
			contour.minWidthProperty().bind(contour.prefWidthProperty());
			contour.maxWidthProperty().bind(contour.prefWidthProperty());
			contour.setLayoutX(577);
			contour.setLayoutY(55+(int)(10.4*i));
			contour.setVisible(false);
			try {
				contour.setGraphic(new ImageView(new Image(new FileInputStream(new File("src/valide.png")), 12, 7, false, true)));
			} catch (FileNotFoundException e2) {}
			this.valideImages.add(contour);
			this.getChildren().add(contour);
		}
	}
	private double getValue(){
		if(score.get()<=0){
			return 0;
		}
		switch (score.get()) {
		case 1:
			return 200;
		case 2:
			return 300;
		case 3:
			return 500;
		case 4:
			return 800;
		case 5:
			return 1500;
		case 6:
			return 3000;
		case 7:
			return 6000;
		case 8:
			return 12000;
		case 9:
			return 24000;
		case 10:
			return 48000;
		case 11:
			return 72000;
		case 12:
			return 100000;
		case 13:
			return 150000;
		case 14:
			return 300000;
		default:
			return 1000000;
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
		l.setTooltip(new Tooltip("Click for replay the audio"));
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
