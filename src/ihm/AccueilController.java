package ihm;



import java.util.ArrayList;
import java.util.List;

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
				questionController.setQuestion(listQuestionListen());
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
		List<Question> questions= new ArrayList<Question>();
		List<String> answers= new ArrayList<String>();
		//question 1;
		answers.add("A");
		answers.add("B");
		answers.add("C");
		answers.add("D");
		questions.add(new Question("listen and observe(C)",answers,"C"));
		list.add(new PartQuestion(TypeQuestion.Image, "./pic/part1_pic1.PNG", "./sound/part1_audio1.mp3", questions));
		
		//Question 2
		questions.clear();
		answers.clear();
		answers.add("A");
		answers.add("B");
		answers.add("C");
		questions.add(new Question("listen(A)",answers,"A"));
		list.add(new PartQuestion(TypeQuestion.Listen, null, "./sound/part2_audio1.mp3", questions));
		
		//Question3
		questions.clear();
		answers.add("D");
		questions.add(new Question("listen(B)",answers,"B"));
		questions.add(new Question("listen(C)",answers,"C"));
		questions.add(new Question("listen(D)",answers,"D"));
		list.add(new PartQuestion(TypeQuestion.Listen, null, "./sound/part3_audio1.mp3", questions));
		
		//Question4
		questions.clear();
		questions.add(new Question("answer(B)",answers,"B"));
		list.add(new PartQuestion(TypeQuestion.read, null, null, questions));
		return list;
	}
}
