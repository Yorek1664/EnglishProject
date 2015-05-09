package ihm;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;



public abstract class Controller extends Pane{
	private App app;
	protected abstract void setStartCondition();
	public static final Controller initialise(App app, Class<? extends Controller> clazz) throws InstantiationException, IllegalAccessException{
		Controller c = clazz.newInstance();
		c.setStartCondition();
		c.setApp(app);
		c.getApp().setGraphic(c);
		c.prefHeightProperty().bind(c.getApp().heightProperty());
		c.prefWidthProperty().bind(c.getApp().widthProperty());
		c.maxHeightProperty().bind(c.prefHeightProperty());
		c.minHeightProperty().bind(c.prefHeightProperty());
		c.maxWidthProperty().bind(c.prefWidthProperty());
		c.minWidthProperty().bind(c.prefWidthProperty());
		c.setPadding(new Insets(15));
		return c;
	}
	public final App getApp(){
		return app;
	}
	private void setApp(App app){
		this.app=app;
	}
	public void setBackgroundImage(String url,double width,double height){
		BackgroundImage myBI= new BackgroundImage(new Image(url,width,height,false,true),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		//then you set to your node
		this.setBackground(new Background(myBI));
	}
}
