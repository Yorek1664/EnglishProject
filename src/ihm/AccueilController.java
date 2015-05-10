package ihm;



import java.util.ArrayList;
import java.util.List;

import xml.ParserXml;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import Model.PartQuestion;
import Model.PartQuestion.TypeQuestion;
import Model.Question;


public class AccueilController extends Controller{
	Label a= getLabelA();
	Label b= getLabelB();
	Label title= getLabelTitle();
	@Override
	protected void setStartCondition() {
		this.setBackgroundImage("accueil.png",600,400);
		this.getChildren().addAll(a,b,title);
		a.setOnMouseClicked(e->{
			try {
				QuestionController questionController = (QuestionController)Controller.initialise(this.getApp(), QuestionController.class);
				questionController.setQuestion(listQuestionListen());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		b.setOnMouseClicked(e->{
			try {
				QuestionController questionController = (QuestionController)Controller.initialise(this.getApp(), QuestionController.class);
				questionController.setQuestion(listQuestionReading());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
	}
	static public Label getLabelA(){
		Label l = new Label();
		l.setLayoutX(60);
		l.setLayoutY(303);
		l.setPrefHeight(36);
		l.setPrefWidth(230);
		l.setText("Listening part");
		setLabelGraphic(l);
		return l;
	}
	static public Label getLabelB(){
		Label l = new Label();
		l.setLayoutX(310);
		l.setLayoutY(303);
		l.setPrefHeight(36);
		l.setPrefWidth(230);
		l.setText("Reading part");
		setLabelGraphic(l);		
		return l;
	}
	static public Label getLabelTitle(){
		Label l = new Label();
		l.setLayoutX(80);
		l.setLayoutY(205);
		l.setPrefHeight(63);
		l.setPrefWidth(440);
		l.setText("Training for the TOEIC");
		setLabelGraphic(l);
		l.setStyle("-fx-font-weight: bold;");
		l.setFont(Font.font("TimeNewRoman", 32));
		return l;
	}
	
	
	public List<PartQuestion> listQuestionListen(){
		List<PartQuestion> list = new ArrayList<PartQuestion>();

		List<PartQuestion> QPart1 = new ArrayList<PartQuestion>();
		List<PartQuestion> QPart2 = new ArrayList<PartQuestion>();
		List<PartQuestion> QPart3 = new ArrayList<PartQuestion>();
		List<PartQuestion> QPart4 = new ArrayList<PartQuestion>();
		
		
		ParserXml parser = new ParserXml();
		
		QPart1 = parser.getListeningPart1();
		QPart2 = parser.getListeningPart2();
		QPart3 = parser.getListeningPart3();
		QPart4 = parser.getListeningPart4();
	
		
		list.add(QPart1.get(0));
		list.add(QPart2.get(0));
		list.add(QPart3.get(0));
		list.add(QPart4.get(0));
		
		return list;
	}
	
	public List<PartQuestion> listQuestionReading(){
		List<PartQuestion> list = new ArrayList<PartQuestion>();
		List<PartQuestion> QPart5 = new ArrayList<PartQuestion>();
		
		ParserXml parser = new ParserXml();
		QPart5 = parser.getReadingPart1();
		
		list.add(QPart5.get(0));
		
		return list;
	}
}
