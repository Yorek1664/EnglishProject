package ihm;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class AccueilController extends Controller{
	private static final int PADDING = 15;
	VBox vbox = new VBox();
	HBox hbox = new HBox();
	Label title = new Label("Training for Toeic");
	Button butRead = new Button("Reading");
	Button butList = new Button("Listening");
	@Override
	protected void setStartCondition() {
		this.getChildren().add(vbox);
		this.vbox.setAlignment(Pos.CENTER);
		this.vbox.setPadding(new Insets(15));
		this.vbox.getChildren().addAll(title,hbox);
		this.hbox.getChildren().addAll(butRead,butList);
		butRead.setOnAction(e->{
			title.textProperty().set("read");
		});
		butList.setOnAction(e->{
			title.textProperty().set("list");
		});
		
		//Binding position/size
		
		vbox.prefWidthProperty().bind(this.widthProperty());
		vbox.maxWidthProperty().bind(vbox.prefWidthProperty());
		vbox.minWidthProperty().bind(vbox.prefWidthProperty());

		hbox.prefWidthProperty().bind(vbox.prefWidthProperty().subtract(PADDING));
		hbox.maxWidthProperty().bind(hbox.prefWidthProperty());
		hbox.minWidthProperty().bind(hbox.prefWidthProperty());
		
		butRead.prefWidthProperty().bind(hbox.prefWidthProperty().divide(3));
		butRead.maxWidthProperty().bind(butRead.prefWidthProperty());
		butRead.minWidthProperty().bind(butRead.prefWidthProperty());

		butList.prefWidthProperty().bind(hbox.prefWidthProperty().divide(3));
		butList.maxWidthProperty().bind(butList.prefWidthProperty());
		butList.minWidthProperty().bind(butList.prefWidthProperty());
	}
}
