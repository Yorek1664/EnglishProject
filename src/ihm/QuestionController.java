package ihm;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class QuestionController extends Controller{
	VBox vbox = new VBox();
	HBox hbox1 = new HBox();
	HBox hbox2 = new HBox();
	Label question = new Label("");
	Label butA = new Label("A");
	Label butB = new Label("B");
	Label butC = new Label("C");
	Label butD = new Label("D");
	@Override
	protected void setStartCondition() {
		this.getChildren().add(vbox);
		this.vbox.setAlignment(Pos.CENTER);
		this.vbox.getChildren().addAll(question,hbox1,hbox2);
		this.hbox1.getChildren().addAll(butA,butB);
		this.hbox1.getChildren().addAll(butC,butD);
		butA.setOnMouseClicked(e->{
			question.textProperty().set("A");
		});
		butB.setOnMouseClicked(e->{
			question.textProperty().set("B");
		});
		butC.setOnMouseClicked(e->{
			question.textProperty().set("C");
		});
		butD.setOnMouseClicked(e->{
			question.textProperty().set("D");
		});
		
		//Binding position/size
		
		vbox.prefWidthProperty().bind(this.widthProperty());
		vbox.maxWidthProperty().bind(vbox.prefWidthProperty());
		vbox.minWidthProperty().bind(vbox.prefWidthProperty());

		
	}

	static public Label getLabelA(){
		Label l = new Label();
		l.setLayoutX(60);
		l.setLayoutY(303);
		l.setPrefHeight(36);
		l.setPrefWidth(230);
		Button button = new Button();
		button.setPrefSize(l.getPrefWidth(), l.getPrefHeight());
		l.setGraphic(button);
		return l;
	}
	static public Label getLabelB(){
		Label l = new Label();
		l.setLayoutX(310);
		l.setLayoutY(303);
		l.setPrefHeight(36);
		l.setPrefWidth(230);
		Button button = new Button();
		button.setPrefSize(l.getPrefWidth(), l.getPrefHeight());
		l.setGraphic(button);
		return l;
	}	
	static public Label getLabelC(){
		Label l = new Label();
		l.setLayoutX(60);
		l.setLayoutY(303);
		l.setPrefHeight(36);
		l.setPrefWidth(230);
		Button button = new Button();
		button.setPrefSize(l.getPrefWidth(), l.getPrefHeight());
		l.setGraphic(button);
		return l;
	}
	static public Label getLabelD(){
		Label l = new Label();
		l.setLayoutX(310);
		l.setLayoutY(303);
		l.setPrefHeight(36);
		l.setPrefWidth(230);
		Button button = new Button();
		button.setPrefSize(l.getPrefWidth(), l.getPrefHeight());
		l.setGraphic(button);
		return l;
	}
	static public Label getLabelTitle(){
		Label l = new Label();
		l.setLayoutX(80);
		l.setLayoutY(205);
		l.setPrefHeight(63);
		l.setPrefWidth(440);
		Button button = new Button();
		button.setPrefSize(l.getPrefWidth(), l.getPrefHeight());
		l.setGraphic(button);
		return l;
	}
}
