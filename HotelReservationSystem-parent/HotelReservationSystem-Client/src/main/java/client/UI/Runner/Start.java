package client.UI.Runner;
import common.otherEnumClasses.Person;
import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
/**
 *
 * @author zhuyingshan
 */

public class Start extends Application  {
        public static Person person=new Person();
        
	public static void main(String[] args) {
		Application.launch(Start.class,args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root=FXMLLoader.load((new File("src/main/java/client/UI/Runner/Runner.fxml")).toURL());
		Scene scene=new Scene(root);
		primaryStage.initStyle(StageStyle.DECORATED);
		primaryStage.setScene(scene);
		primaryStage.setTitle("隽程酒店管理系统");
		primaryStage.show();
	}
}
