package UI.Admintor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MemberManage extends Application  {

	public static void main(String[] args) {
		Application.launch(main.class,args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root=FXMLLoader.load(getClass().getResource("管理人员-管理用户.fxml"));
		Scene scene=new Scene(root);
		primaryStage.initStyle(StageStyle.DECORATED);
		primaryStage.setScene(scene);
		primaryStage.setTitle("0");
		primaryStage.show();
	}
}
