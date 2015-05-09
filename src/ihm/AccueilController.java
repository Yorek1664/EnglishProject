package ihm;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.TextAlignment;


public class AccueilController extends Controller{
	private static final int PADDING = 15;
	Label title = new Label("Training for Toeic");
	Label butRead = new Label("Reading");
	Label butList = new Label();
	@Override
	protected void setStartCondition() {
		//this.setBackgroundImage("accueil.png",600,400);
		this.setBackgroundImage("question.png",600,374);
		this.getChildren().addAll(getLabelTitle(),getExit());
		//Binding position/size
	}
	/*static public Label getLabelA(){
		Label l = new Label();
		l.setLayoutX(60);
		l.setLayoutY(303);
		l.setPrefHeight(36);
		l.setPrefWidth(230);
		l.setTextAlignment(TextAlignment.CENTER);
		return l;
	}
	static public Label getLabelB(){
		Label l = new Label();
		l.setLayoutX(310);
		l.setLayoutY(303);
		l.setPrefHeight(36);
		l.setPrefWidth(230);
		l.setTextAlignment(TextAlignment.CENTER);
		return l;
	}
	static public Label getLabelTitle(){
		Label l = new Label();
		l.setLayoutX(80);
		l.setLayoutY(205);
		l.setPrefHeight(63);
		l.setPrefWidth(440);
		l.setTextAlignment(TextAlignment.CENTER);
		return l;
	}*/
	static public Label getLabelA(){
		Label l = new Label();
		l.setLayoutX(46);
		l.setLayoutY(287);
		l.setPrefHeight(33);
		l.setPrefWidth(235);
		l.setTextAlignment(TextAlignment.CENTER);
		return l;
	}
	static public Label getLabelB(){
		Label l = new Label();
		l.setLayoutX(323);
		l.setLayoutY(287);
		l.setPrefHeight(33);
		l.setPrefWidth(235);
		l.setTextAlignment(TextAlignment.CENTER);
		return l;
	}	
	static public Label getLabelC(){
		Label l = new Label();
		l.setLayoutX(46);
		l.setLayoutY(334);
		l.setPrefHeight(33);
		l.setPrefWidth(235);
		l.setTextAlignment(TextAlignment.CENTER);
		return l;
	}
	static public Label getLabelD(){
		Label l = new Label();
		l.setLayoutX(323);
		l.setLayoutY(334);
		l.setPrefHeight(33);
		l.setPrefWidth(235);
		l.setTextAlignment(TextAlignment.CENTER);
		return l;
	}
	static public Label getLabelTitle(){
		Label l = new Label();
		l.setLayoutX(57);
		l.setLayoutY(215);
		l.setPrefHeight(58);
		l.setPrefWidth(485);
		l.setTextAlignment(TextAlignment.CENTER);
		return l;
	}

	static public Label getJoker1(){
		Label l = new Label();
		l.setLayoutX(380);
		l.setLayoutY(5);
		l.setPrefHeight(37);
		l.setPrefWidth(65);
		Button button = new Button();
		button.setPrefSize(l.getPrefWidth(), l.getPrefHeight());
		l.setGraphic(button);
		return l;
	}
	static public Label getJoker2(){
		Label l = new Label();
		l.setLayoutX(455);
		l.setLayoutY(5);
		l.setPrefHeight(37);
		l.setPrefWidth(65);
		Button button = new Button();
		button.setPrefSize(l.getPrefWidth(), l.getPrefHeight());
		l.setGraphic(button);
		return l;
	}
	static public Label getJoker3(){
		Label l = new Label();
		l.setLayoutX(530);
		l.setLayoutY(5);
		l.setPrefHeight(37);
		l.setPrefWidth(65);
		Button button = new Button();
		button.setPrefSize(l.getPrefWidth(), l.getPrefHeight());
		l.setGraphic(button);
		return l;
	}

	static public Label getExit(){
		Label l = new Label();
		l.setLayoutX(5);
		l.setLayoutY(5);
		l.setPrefHeight(37);
		l.setPrefWidth(65);
		Button button = new Button();
		button.setPrefSize(l.getPrefWidth(), l.getPrefHeight());
		l.setGraphic(button);
		return l;
	}
}
