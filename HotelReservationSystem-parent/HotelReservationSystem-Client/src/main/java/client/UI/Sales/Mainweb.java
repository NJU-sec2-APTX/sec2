package UI.Sales;

import UI.Admintor.main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Mainweb extends Application  {

	public static void main(String[] args) {
		Application.launch(main.class,args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root=FXMLLoader.load(getClass().getResource("网站营销人员-框架.fxml"));
		Scene scene=new Scene(root);
		primaryStage.initStyle(StageStyle.DECORATED);
		primaryStage.setScene(scene);
		primaryStage.setTitle("second");
		primaryStage.show();
	}

}
